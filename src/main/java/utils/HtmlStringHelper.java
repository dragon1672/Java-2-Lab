package utils;

import java.util.regex.Pattern;

/**
 * Created by Anthony on 5/19/2015.
 */
public class HtmlStringHelper {
    public static final Pattern HTML_TAG = Pattern.compile("<.*?(?:\\s*[a-zA-Z_:][-a-zA-Z0-9_:.]+=(?:'(?:.*?\\s*?)*?')|(?:\"(?:.*?\\s*?)*?\"))?>");
    public static final Pattern ALL_SCRIPTS = Pattern.compile("<\\s*[sS][cC][rR][iI][pP][tT](?:\\s*[a-zA-Z_:][-a-zA-Z0-9_:.]+\\s*=\\s*(?:(?:'(?:[^']*)*?')|(?:\"(?:[^\"]*)*?\")))?>(.*?\\n*?)*?<\\s*\\/?\\s*[sS][cC][rR][iI][pP][tT](?:\\s*[a-zA-Z_:][-a-zA-Z0-9_:.]+\\s*=\\s*(?:(?:'(?:[^']*)*?')|(?:\"(?:[^\"]*)*?\")))?>");


    /**
     * Removes all HTML elements from string
     * @param HTML raw HTML
     * @return String that can be rendered in HTML not AS HTML
     */
    public static String Sanitize(String HTML) {
        return HTML_TAG.matcher(HTML).replaceAll(""); // no tags for u
    }

    /**
     * Preserves HTML elements while removing scripting elements
     * @param HTML raw HTML
     * @return HTML formatted string where no code will run
     */
    public static String RemoveScripts(String HTML) {
        return ALL_SCRIPTS.matcher(HTML).replaceAll(""); // no tags for u
    }

    public static String SanitizeAndRemoveScripts(String HTML) {
        return Sanitize(RemoveScripts(HTML));
    }
}
