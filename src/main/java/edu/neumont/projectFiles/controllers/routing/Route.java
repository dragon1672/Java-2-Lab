package edu.neumont.projectFiles.controllers.routing;

/**
 * Created by Anthony on 5/12/2015.
 */
public class Route {
    private Object Model;
    private String RedirectURL;
    private String ForwardURL;
    private Integer StatusCode;

    private Route(Object model, String redirectURL, String forwardURL, Integer statusCode) {
        Model = model;
        RedirectURL = redirectURL;
        ForwardURL = forwardURL;
        StatusCode = statusCode;
        if ((redirectURL == null) == (forwardURL == null)) { // either both or neither are set
            if (redirectURL != null) // means both are set
                throw new IllegalArgumentException("Cannot set both forward and redirect URL");
            throw new IllegalArgumentException("Must set either forward or redirect URL");
        }
    }

    public static Route ForwardToUrl(String forwardURL) {
        return ForwardToUrl(forwardURL, null);
    }

    public static Route ForwardToUrl(String forwardURL, Object model) {
        return ForwardToUrl(forwardURL, model, null);
    }

    public static Route ForwardToUrl(String forwardURL, Object model, Integer statusCode) {
        return new Route(model, null, forwardURL, statusCode);
    }

    public static Route RedirectToUrl(String redirectURL) {
        return RedirectToUrl(redirectURL, null);
    }

    public static Route RedirectToUrl(String redirectURL, Object model) {
        return RedirectToUrl(redirectURL, model, null);
    }

    public static Route RedirectToUrl(String redirectURL, Object model, Integer statusCode) {
        return new Route(model, redirectURL, null, statusCode);
    }

    public Object getModel() {
        return Model;
    }

    public String getRedirectURL() {
        return RedirectURL;
    }

    public String getForwardURL() {
        return ForwardURL;
    }

    public Integer getStatusCode() {
        return StatusCode;
    }
}
