package edu.neumont.projectFiles.controllers.routing;

import edu.neumont.projectFiles.controllers.LandingPage;
import edu.neumont.projectFiles.controllers.LoginPage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anthony on 5/12/2015.
 */
@WebServlet("/"+ GodServlet.myPath+"/*")
public class GodServlet extends HttpServlet {
    public static final String myPath = "router";


    private static Router GetRoutes = new Router()
            .addURIRegex(LandingPage.Regex, LandingPage::DoIt)
            .addURIRegex(LoginPage.Regex, LoginPage::getPage)
            ;

    private static Router PostRoutes = new Router()
            //.addURIRegex(QuestionActionRouter.questionVoteUpPattern, QuestionActionRouter.Instance::upVoteQuestion)
            ;

    private void handleRequest(Router router, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Route r = router.getServlet(request);
            if (r == null) {
                response.setStatus(404);
                request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
            } else {
                if (r.getStatusCode() != null)
                    response.setStatus(r.getStatusCode());
                if (r.getModel() != null)
                    request.setAttribute("model", r.getModel());
                //time to move on
                if (r.getForwardURL() != null)
                    request.getRequestDispatcher(r.getForwardURL()).forward(request, response);
                if (r.getRedirectURL() != null)
                    response.sendRedirect(r.getRedirectURL());
            }
        } catch (Exception e) {
            //response.setStatus(500); //something broke
            //response.getWriter().println("Something happened to my insides and I don't feel so good");
            throw e;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(PostRoutes, request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handleRequest(GetRoutes, request, response);
    }
}