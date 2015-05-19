package utils;

/**
 * Created by Anthony on 5/19/2015.
 */
public class HtmlStringHelper {
    /**
     * Removes all HTML elements from string
     * @param HTML raw HTML
     * @return String that can be rendered in HTML not AS HTML
     */
    public static String Sanatize(String HTML) {
        return HTML;
    }

    /**
     * Preserves HTML elements while removing scripting elements
     * @param HTML raw HTML
     * @return HTML formatted string where no code will run
     */
    public static String RemoveScripts(String HTML) {
        return HTML;
    }
}
