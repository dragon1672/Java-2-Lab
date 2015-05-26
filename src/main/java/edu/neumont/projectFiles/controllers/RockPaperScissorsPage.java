package edu.neumont.projectFiles.controllers;

import edu.neumont.projectFiles.controllers.routing.Route;
import edu.neumont.projectFiles.models.UserModel;
import edu.neumont.projectFiles.services.Singletons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.regex.Pattern;

/**
 * Created by bwaite on 5/22/2015.
 */
public class RockPaperScissorsPage {
    public static Pattern Regex = Pattern.compile("/RPS");
    public static class QuickGameModel{
        private UserModel user1;
        private UserModel user2;

        private String user1Choice;
        private String user2Choice;

        private String winner;

        public UserModel getUser1() {
            return user1;
        }

        public void setUser1(UserModel user1) {
            this.user1 = user1;
        }

        public UserModel getUser2() {
            return user2;
        }

        public void setUser2(UserModel user2) {
            this.user2 = user2;
        }

        public String getUser1Choice() {
            return user1Choice;
        }

        public void setUser1Choice(String user1Choice) {
            this.user1Choice = user1Choice;
        }

        public String getUser2Choice() {
            return user2Choice;
        }

        public void setUser2Choice(String user2Choice) {
            this.user2Choice = user2Choice;
        }

        public String getWinner() {
            if(winner == null)
            {
                winner = "FIGURE IT OUT";

            }
            return winner;
        }
    }
    private static QuickGameModel qgm = new QuickGameModel();;

    public static Route getPage(HttpServletRequest request) {
        Route toReturn = Route.ForwardToUrl("/WEB-INF/login.jsp");
        String username = "";
        Long userID = null;
        HttpSession session = request.getSession();
        if (session != null) {
            username = (String) session.getAttribute("username");
            userID = (Long) session.getAttribute("userID");
        }
        //If logged in check for players
        if (userID != null) {
            toReturn = Route.ForwardToUrl("/WEB-INF/WaitingForPlayers.jsp");
            UserModel userM = Singletons.theDAL.retrieveUserModel(userID);
            //connect user to this game if not connected
            if (qgm.getUser1() == null) {
                qgm.setUser1(userM);
            } else if (qgm.getUser2() == null && qgm.getUser1() != userM) {
                qgm.setUser2(userM);
            }
            //check for 2 players for this game
            if (qgm.getUser1() != null && qgm.getUser2() != null) {
                //check weather need to pick choice or display results
                String choice = request.getParameter("choice");
                if(userM == qgm.getUser1()) {
                    qgm.setUser1Choice(choice);
                } else if(userM ==  qgm.getUser2()) {
                    qgm.setUser2Choice(choice);
                }
                if (userM != null) {
                    if((qgm.getUser1Choice() != null && qgm.getUser2Choice() == null)
                        ||(qgm.getUser2Choice() != null && qgm.getUser1Choice() == null)){
                        toReturn = Route.ForwardToUrl("/WEB-INF/plaintext.jsp", "Refresh to Check for Results");
                    }else if(qgm.getUser1Choice() != null && qgm.getUser2Choice() != null){
                        toReturn = Route.ForwardToUrl("/WEB-INF/RPSresults.jsp", qgm);
                        qgm = new QuickGameModel();
                    }else{
                        toReturn = Route.ForwardToUrl("/WEB-INF/RPSstart.jsp");
                    }
                }
            } else {
                toReturn = Route.ForwardToUrl("/WEB-INF/plaintext.jsp","Refresh to Check for Another player");
            }
        }
        return toReturn;
    }
}
