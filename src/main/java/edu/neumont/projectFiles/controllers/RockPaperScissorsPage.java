package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.RPS.MoveResponse;
import edu.neumont.projectFiles.models.RPS.RPSMove;
import edu.neumont.projectFiles.models.RPS.RPSMoveSet;
import edu.neumont.projectFiles.models.RPS.RPSManager;
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
    public static Pattern Regex = Pattern.compile("/RPS");
    private static Map<Long, RPSManager> RPSGames = new HashMap<>();
    //TODO: figure out where I get the RPS game type
    //sets what game rules are for this RPS
    private static RPSMoveSet RPSRules = RPSMoveSet.ClassicRockPaperScissors;
    private static Tuple<RPSMove, RPSMove> RPSSet = new Tuple<>();

    public static Route DummyGetPage(HttpServletRequest request) {
        long fakeRoomID = 1l;
        return getPage(fakeRoomID, request);
    }

    public static Route getPage(long roomID, HttpServletRequest request) {
        Route toReturn = Route.RedirectToUrl(request.getContextPath() + "/login");
        //Check if the current user is logged in, if not logged in redirect to login
        HttpSession session = request.getSession();
        Long userID = -1l;
        if (session != null) {
            userID = (Long) session.getAttribute("userID");
            if (userID != null) {
                //grab the user from the logged in userID
                UserModel userM = Singletons.theDAL.retrieveUserModel(userID);
                if (userM != null) {
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
                    if(rpsGame.getP2() != null && rpsGame.getP2().getIndex() > 0) {
                        String doneWithGame = request.getParameter("DoneWithGame");
                        rpsGame.getP1().setDoneWithGame(doneWithGame != null);
                        rpsGame.getP2().setDoneWithGame(doneWithGame != null);

                        if(rpsGame.getP1().isReadyToStartNewGame() && rpsGame.getP2().isReadyToStartNewGame()) {
                            RPSSet = new Tuple<>();
                        }
                    }
                    //For each user do this:
                    if (player.isDoneWithGame()) {
                        updateGames(roomID, rpsGame);
                        //redirect player to their account when they are finished with the game.
                        toReturn = Route.RedirectToUrl(request.getContextPath() + "/accountInformation/" + userID);
                    } else if(player.isReadyToStartNewGame()){
                            player.setReadyToStartNewGame(false);
                        toReturn = Route.ForwardToUrl("/WEB-INF/RPSStart.jsp");
                    }else {
                        String rpsMoveStr = request.getParameter("RPSMove");
                        //check if time to display results
                        if (rpsMoveStr == null || rpsMoveStr.isEmpty()) {
                            if (RPSSet.getFirst() != null && RPSSet.getSecond() != null) {
                                rpsGame.addMove(RPSSet);
                                updateGames(roomID, rpsGame);
                                //check who won
                                MoveResponse moveResponse = RPSRules.getResponse(RPSSet.getFirst(), RPSSet.getSecond());
                                String GameMessage = "It's a tie!";
                                if(moveResponse.P1Won()) {
                                    GameMessage = "user: " + rpsGame.getP1().getUser().getDisplayName() + " has beat user: " +rpsGame.getP2().getUser().getDisplayName() + ", " +RPSSet.getFirst().getText() + " " + moveResponse.moveData.beatMsg+ " " +RPSSet.getSecond().getText();
                                } else if(moveResponse.P2Won()){
                                    GameMessage = "user:" + rpsGame.getP2().getUser().getDisplayName() + " has beat user: " +rpsGame.getP1().getUser().getDisplayName() + ", " +RPSSet.getSecond().getText() + " " + moveResponse.moveData.beatMsg+ " " +RPSSet.getFirst().getText();
                                }
                                //display result page

                                player.setReadyToStartNewGame(true);
                                toReturn = Route.ForwardToUrl("/WEB-INF/RPSResults.jsp", GameMessage);
                            }
                            // waiting for all players ready //refresh button clicked
                            else if((userIsPlayer1 && rpsGame.getP1().getLastSavedMove() != null) ||
                                     !userIsPlayer1 && rpsGame.getP2().getLastSavedMove() != null){
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
                                if (RPSSet.getFirst() == null || RPSSet.getSecond() == null) {
                                    if (userIsPlayer1) {
                                        if (rpsGame.getP1().getIndex() <= rpsGame.getP2().getIndex()) {
                                            RPSSet.setFirst(rpsMove);
                                            rpsGame.getP1().setIndex(rpsGame.getP1().getIndex() + 1);
                                            rpsGame.getP1().setLastSavedMove(rpsMove);
                                            updateGames(roomID, rpsGame);
                                        }
                                    } else {
                                        if (rpsGame.getP2().getIndex() <= rpsGame.getP1().getIndex()) {
                                            RPSSet.setSecond(rpsMove);
                                            rpsGame.getP2().setIndex(rpsGame.getP2().getIndex() + 1);
                                            rpsGame.getP2().setLastSavedMove(rpsMove);
                                            updateGames(roomID, rpsGame);
                                        }
                                    }
                                }
                            }

                            //if at start of the game, and it is user1, user2 doesn't exist yet so allow user1 first move to work.
                            if(rpsGame.getP1() != null && userIsPlayer1 && rpsGame.getP1().getIndex() == 0)
                            {
                                RPSSet.setFirst(rpsMove);
                                rpsGame.getP1().setIndex(rpsGame.getP1().getIndex() + 1);
                                rpsGame.getP1().setLastSavedMove(rpsMove);
                                updateGames(roomID, rpsGame);
                            }
                        }
                    }
                }
            }
        }
        return toReturn;
    }

    private static void getPageUsingPlayer(RPSManager.RPSUser user, boolean isPlayer1)
    {

    }

    private static void updateGames(Long roomID, RPSManager rpsm) {
        RPSGames.remove(roomID);
        RPSGames.put(roomID, rpsm);
    }
}
