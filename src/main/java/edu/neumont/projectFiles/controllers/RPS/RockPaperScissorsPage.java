package edu.neumont.projectFiles.controllers.RPS;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.RPS.*;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;
import utils.Tuple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by bwaite on 5/22/2015.
 */
public class RockPaperScissorsPage {
    public static final String MyID = "RPS";
    public static Pattern Regex = Pattern.compile("/RPS");
    private static Map<Long, RPSManager> RPSGames = new HashMap<>();
    private static RPSMoveSet RPSRules = RPSMoveSet.ClassicRockPaperScissors;

    public static Route DummyGetPage(HttpServletRequest request) {
        long fakeRoomID = 1l;
        HttpSession session = request.getSession();
        Long userID = -1l;
        if (session != null) {
            userID = (Long) session.getAttribute("userID");
            if (userID != null) {
                //grab the user from the logged in userID
                UserModel userM = Singletons.theDAL.retrieveUserModel(userID);
                if (userM != null) {
                    return getPage(fakeRoomID, request, request.getPathInfo(), userM);
                }
            }
        }
        return Route.RedirectToUrl(request.getContextPath() + "/login");
    }

    public static Route getPage(long roomID, HttpServletRequest request, String URI, UserModel userM) {
        Route toReturn = Route.ForwardToUrl("/WEB-INF/RPSStart.jsp", new UserModel("dummy", "dummy", "dummy", "dummy", "dummy"));
        //Check if the current user is logged in, if not logged in redirect to login
        RPSManager rpsGame = new RPSManager();
        //grab a game if it exists
        if (RPSGames.containsKey(roomID)) {
            rpsGame = RPSGames.get(roomID);
        }
        //set up the users if not set up
        if (rpsGame.getP1() == null) {
            rpsGame.setP1(userM);
            updateGames(roomID, rpsGame);
        } else if (rpsGame.getP2() == null && rpsGame.getP1().getUser().getID() != userM.getID()) {
            rpsGame.setP2(userM);
            updateGames(roomID, rpsGame);
        }

        //Anthony will make sure the session user sent here is a user who is allowed to play this game.
        //set the player based on weather their id is equal to rpsGame player 1's ID.
        boolean userIsPlayer1 = (userM.getID() == rpsGame.getP1().getUser().getID());
        RPSManager.RPSUser player = userIsPlayer1 ? rpsGame.getP1() : rpsGame.getP2();
        //check for end game stuff
        if (rpsGame.getP2() != null && rpsGame.getP2().getIndex() > 0) {
            String doneWithGame = request.getParameter("DoneWithGame");
            rpsGame.getP1().setDoneWithGame(doneWithGame != null);
            rpsGame.getP2().setDoneWithGame(doneWithGame != null);

            if (rpsGame.getP1().isReadyToStartNewGame() && rpsGame.getP2().isReadyToStartNewGame()) {
                rpsGame.setCurrentMove(new Tuple<>());
            }
        }
        //For each user do this:
        if (player.isDoneWithGame()) {
            updateGames(roomID, rpsGame);
            //redirect player to their account when they are finished with the game.
            toReturn = Route.RedirectToUrl(request.getContextPath() + "/accountInformation/" + userM.getID());
        } else if (player.isReadyToStartNewGame()) {
            player.setReadyToStartNewGame(false);
            RPSStartModel startModel;
            if (rpsGame.getP1() != null && rpsGame.getP2() != null) {
                startModel = new RPSStartModel(player.getUser(), (userIsPlayer1 ? rpsGame.getP2() : rpsGame.getP1()).getUser());
            } else {
                startModel = new RPSStartModel(player.getUser(), new UserModel("dummy", "dummy", "dummy", "dummy", "dummy"));
            }
            toReturn = Route.ForwardToUrl("/WEB-INF/RPSStart.jsp", startModel);
        } else {
            String rpsMoveStr = request.getParameter("RPSMove");
            //check if time to display results
            if (rpsMoveStr == null || rpsMoveStr.isEmpty()) {
                if (rpsGame.getCurrentMove().getFirst() != null && rpsGame.getCurrentMove().getSecond() != null) {
                    rpsGame.addMove(rpsGame.getCurrentMove());
                    updateGames(roomID, rpsGame);
                    //check who won
                    MoveResponse moveResponse = RPSRules.getResponse(rpsGame.getCurrentMove().getFirst(), rpsGame.getCurrentMove().getSecond());
                    //String GameMessage = "It's a tie!";
                    //if(moveResponse.P1Won()) {
                    //    GameMessage = "user: " + rpsGame.getP1().getUser().getDisplayName() + " has beat user: " +rpsGame.getP2().getUser().getDisplayName() + ", " +rpsGame.getCurrentMove().getFirst().getText() + " " + moveResponse.moveData.beatMsg+ " " +rpsGame.getCurrentMove().getSecond().getText();
                    //} else if(moveResponse.P2Won()){
                    //    GameMessage = "user:" + rpsGame.getP2().getUser().getDisplayName() + " has beat user: " +rpsGame.getP1().getUser().getDisplayName() + ", " +rpsGame.getCurrentMove().getSecond().getText() + " " + moveResponse.moveData.beatMsg+ " " +rpsGame.getCurrentMove().getFirst().getText();
                    //}
                    //display result page
                    RPSResultsModel resultsModel = new RPSResultsModel(rpsGame, moveResponse, userIsPlayer1);

                    player.setReadyToStartNewGame(true);
                    toReturn = Route.ForwardToUrl("/WEB-INF/RPSResults.jsp", resultsModel);
                }
                // waiting for all players ready //refresh button clicked
                else if ((userIsPlayer1 && rpsGame.getP1().getLastSavedMove() != null) ||
                        !userIsPlayer1 && rpsGame.getP2().getLastSavedMove() != null) {
                    //wait for other player choice
                    toReturn = Route.ForwardToUrl("/WEB-INF/RPSWaitForOtherPlayerDecision.jsp");
                }
            }
            //check for player choice
            else {
                //wait for other player choice
                toReturn = Route.ForwardToUrl("/WEB-INF/RPSWaitForOtherPlayerDecision.jsp");
                updateGames(roomID, rpsGame);

                RPSMove rpsMove = RPSMove.fromString(rpsMoveStr);
                if (rpsGame.getP1() != null && rpsGame.getP2() != null) {
                    //if moves are still needed
                    if (rpsGame.getCurrentMove().getFirst() == null || rpsGame.getCurrentMove().getSecond() == null) {
                        if (userIsPlayer1) {
                            if (rpsGame.getP1().getIndex() <= rpsGame.getP2().getIndex()) {
                                rpsGame.getCurrentMove().setFirst(rpsMove);
                                rpsGame.getP1().setIndex(rpsGame.getP1().getIndex() + 1);
                                rpsGame.getP1().setLastSavedMove(rpsMove);
                                updateGames(roomID, rpsGame);
                            }
                        } else {
                            if (rpsGame.getP2().getIndex() <= rpsGame.getP1().getIndex()) {
                                rpsGame.getCurrentMove().setSecond(rpsMove);
                                rpsGame.getP2().setIndex(rpsGame.getP2().getIndex() + 1);
                                rpsGame.getP2().setLastSavedMove(rpsMove);
                                updateGames(roomID, rpsGame);
                            }
                        }
                    }
                }

                //if at start of the game, and it is user1, user2 doesn't exist yet so allow user1 first move to work.
                if (rpsGame.getP1() != null && userIsPlayer1 && rpsGame.getP1().getIndex() == 0) {
                    rpsGame.getCurrentMove().setFirst(rpsMove);
                    rpsGame.getP1().setIndex(rpsGame.getP1().getIndex() + 1);
                    rpsGame.getP1().setLastSavedMove(rpsMove);
                    updateGames(roomID, rpsGame);
                }
            }
        }
        return toReturn;
    }

    private static void updateGames(Long roomID, RPSManager rpsm) {
        RPSGames.remove(roomID);
        RPSGames.put(roomID, rpsm);
    }
}
