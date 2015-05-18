package edu.neumont.projectFiles.controllers.routing;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Anthony on 5/14/2015.
 */
@WebFilter(filterName = "RouteFilter", urlPatterns = {"/*"})
public class RouteFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String requestedURL = req.getRequestURI();
        if(requestedURL.startsWith(req.getContextPath())) {
            requestedURL = requestedURL.substring(req.getContextPath().length());
        }


        if (!requestedURL.startsWith("/WEB-INF/") && !requestedURL.startsWith("/resources/") && !requestedURL.startsWith("/"+ GodServlet.myPath+"/")) {
            String newUrl = "/"+ GodServlet.myPath + requestedURL;
            req.getRequestDispatcher(newUrl).forward(request,response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
