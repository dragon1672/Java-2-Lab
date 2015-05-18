package edu.neumont.projectFiles.controllers.routing;

import utils.CollectionUtils;
import utils.FunctionInterfaces.Functions.*;
import utils.Tuple;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;

import static utils.NullSafeGets.NullSafeGet;


/**
 * Created by Anthony on 5/12/2015.
 */
public class Router {
    //region Helper Classes =====================================================================================================

    public interface Validator extends Function1<Boolean, HttpServletRequest> {
    }

    public interface ResponseExtractor extends Function1<Route, HttpServletRequest> {
    }

    static class RouteOption extends Tuple<Validator, ResponseExtractor> {
        public RouteOption(Validator first, ResponseExtractor second) {
            super(first, second);
        }

        public Validator getValidator() {
            return this.First;
        }

        public boolean isValid(HttpServletRequest request) {
            return getValidator().Invoke(request);
        }

        public ResponseExtractor getResponseExtractor() {
            return this.Second;
        }

        public Route extractResponse(HttpServletRequest request) {
            return getResponseExtractor().Invoke(request);
        }
    }

    //endregion

    private Collection<RouteOption> mapper = new ArrayList<>();

    private String removeIfExists(String src, String toRemove) {
        if(src.startsWith(toRemove))
            return src.substring(toRemove.length());
        return src;
    }

    public Router addURIRegex(Pattern regex, ResponseExtractor toAdd) {
        return add(a -> {
            Pattern tmp = regex;
            return tmp.matcher(a.getPathInfo()).matches();
        }, toAdd);
    }

    public Router addURIRegex(String regex, ResponseExtractor toAdd) {
        addURIRegex(Pattern.compile(regex), toAdd);
        return this;
    }

    public Router add(Validator validator, ResponseExtractor toAdd) {
        mapper.add(new RouteOption(validator, toAdd));
        return this;
    }

    public Route getServlet(HttpServletRequest request) {
        return NullSafeGet(CollectionUtils.firstOrDefault(mapper, n -> n.isValid(request)), n -> n.extractResponse(request));
    }
}
