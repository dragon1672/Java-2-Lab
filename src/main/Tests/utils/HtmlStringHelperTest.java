package utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Anthony on 5/20/2015.
 */
public class HtmlStringHelperTest {

    @Test
    public void testSanitize() throws Exception {
        String HTML = "<!DOCTYPE html><html><head><title>RegExr: Learn, Build, & Test RegEx</title><script src=''>if(self !== top) { top.location = self.location; }</script><meta name=\"description\" content=\"Regular expression tester with syntax highlighting, contextual help, video tutorial, reference, and searchable community patterns.\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\"><meta name=\"viewport\" content=\"user-scalable=yes\"><meta name=\"application-name\" content=\"RegExr\"><meta name=\"msapplication-TileColor\" content=\"#44A4E0\"><meta name=\"msapplication-TileImage\" content=\"assets/windows8/mediumtile.png\"><meta name=\"msapplication-square70x70logo\" content=\"assets/windows8/smalltile.png\"><meta name=\"msapplication-square150x150logo\" content=\"assets/windows8/mediumtile.png\"><meta name=\"msapplication-wide310x150logo\" content=\"assets/windows8/widetile.png\"><meta name=\"msapplication-square310x310logo\" content=\"assets/windows8/largetile.png\"><link rel=\"shortcut icon\" href=\"regexrFavicon.ico\"><script src=\"js/regExWorker.template.js?no=1424970636468\"></script id=\"potato\"><script src=\"js/scripts.min.js?no=1424970636468\"></script><link rel=\"stylesheet\" href=\"css/regexr.css?no=1424970636468\"><script src=\"//ajax.googleapis.com/ajax/libs/webfont/1/webfont.js\"></script><script idpie=\"s'u'p\">(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\t\t\t(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\t\t\tm=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\t\t})(window,document,'script','//www.google-analytics.com/analytics.js','ga');\t\tga('create', 'UA-3579542-6', 'regexr.com');\t\tga('send', 'pageview', '/');</script></head><body><div class=\"top\"><h1 class=\"icon regexr-logo\">&#xE600;</h1><h1 class=\"regexr-text\">RegExr</h1><span class=\"version regexr-text\">v2.0<span class=\"beta-banner hidden\">BETA</span></span><div class=\"links\">by <a href=\"http://twitter.com/gskinner/\" target=\"_blank\">gskinner</a> <a href=\"./v1/\" target=\"_blank\">RegExr v1</a> <a href=\"http://github.com/gskinner/regexr/\" target=\"_blank\">GitHub</a> <a class=\"video-link\">Tutorial</a></div></div><div class=\"lib hidden\" id=\"libview\"><div class=\"title\"><span class=\"button noicon\" data-icon=\"&#xE225;\">Library</span></div><div class=\"community hidden\"><div class=\"search\"><span class=\"search-icon\"></span><input type=\"text\" class=\"search-input\" placeholder=\"Search\" tabindex=\"1\"></div><div class=\"tag-list-container\"><div class=\"tag-list\" tabindex=\"2\"><div class=\"renderer item\"><span>{{getLabel()}}</span></div></div></div><div class=\"community-list\" tabindex=\"3\"><div class=\"renderer item\"><pre class=\"label\">{{getLabel()}}</pre><div class=\"rating rating-list\">{{getStaticRating()}}</div></div></div><div class=\"community-content hidden\"><div class=\"header\"><div class=\"favorite icon\"></div><div class=\"load icon all\"></div><div class=\"rating rating-content\"></div></div><div class=\"scroll\"><pre class=\"description\"></pre><p class=\"author\"></p><hr><div class=\"load icon expr\"></div><code class=\"expression\"></code><hr><div class=\"preview-wrap\"><div class=\"load icon source\"></div><code class=\"preview\"></code><hr></div><div class=\"substitution-wrap\"><h1 class=\"substitution-title\">Substitution</h1><hr><div class=\"load icon subst\"></div><code class=\"substitution\"></code></div></div></div></div><div class=\"list\" tabindex=\"0\"><div class=\"renderer item\"><span class=\"icon\">{{getIcon()}}</span>{{getLabel()}}<span class=\"detail\">{{getDetail()}}</span></div></div><div class=\"content\"><b>RegExr is an online tool to <b>learn</b>, <b>build</b>, & <b>test</b> Regular Expressions (RegEx / RegExp).</b><hr><ul><li>Results update in <b>real-time</b> as you type.</li><li><b>Roll over</b> a match or expression for details.</li><li><b>Save</b> & <b>share</b> expressions with others.</li><li>Explore the <b>Library</b> for help & examples.</li><li><b>Undo</b> & <b>Redo</b> with {{getCtrlKey()}}-Z / Y.</li><li>Search for & rate <b>Community</b> patterns.</li></ul></div><div id=\"cheatsheet\"><table class=\"cheatsheet\"><tr><th colspan=\"2\" onclick=\"regexr.libView.show('charclasses')\">Character classes</th></tr><tr><td>.</td><td>any character except newline</td></tr><tr><td>\\w \\d \\s</td><td>word, digit, whitespace</td></tr><tr><td>\\W \\D \\S</td><td>not word, digit, whitespace</td></tr><tr><td>[abc]</td><td>any of a, b, or c</td></tr><tr><td>[^abc]</td><td>not a, b, or c</td></tr><tr><td>[a-g]</td><td>character between a & g</td></tr><tr><th colspan=\"2\" onclick=\"regexr.libView.show('anchors')\">Anchors</th></tr><tr><td>^abc$</td><td>start / end of the string</td></tr><tr><td>\\b</td><td>word boundary</td></tr><tr><th colspan=\"2\" onclick=\"regexr.libView.show('escchars')\">Escaped characters</th></tr><tr><td>\\. \\* \\\\</td><td>escaped special characters</td></tr><tr><td>\\t \\n \\r</td><td>tab, linefeed, carriage return</td></tr><tr><td>\\u00A9</td><td>unicode escaped &copy;</td></tr><tr><th colspan=\"2\" onclick=\"regexr.libView.show('groups')\">Groups & Lookaround</th></tr><tr><td>(abc)</td><td>capture group</td></tr><tr><td>\\1</td><td>backreference to group #1</td></tr><tr><td>(?:abc)</td><td>non-capturing group</td></tr><tr><td>(?=abc)</td><td>positive lookahead</td></tr><tr><td>(?!abc)</td><td>negative lookahead</td></tr><tr><th colspan=\"2\" onclick=\"regexr.libView.show('quants')\">Quantifiers & Alternation</th></tr><tr><td>a* a+ a?</td><td>0 or more, 1 or more, 0 or 1</td></tr><tr><td>a{5} a{2,}</td><td>exactly five, two or more</td></tr><tr><td>a{1,3}</td><td>between one & three</td></tr><tr><td>a+? a{2,}?</td><td>match as few as possible</td></tr><tr><td>ab|cd</td><td>match ab or cd</td></tr></table></div></div><div class=\"doc subst-disabled\" id=\"docview\"><div class=\"title expr\">Expression<ul class=\"buttonbar\"><li class=\"button share\" data-icon=\"&#xE309;\">share</li><li class=\"button save\" data-icon=\"&#xE073;\">save</li><li class=\"button flags\" data-icon=\"&#xE267;\">flags</li></ul></div><div class=\"editor expr\"><div class=\"results\"></div></div><div class=\"title source\">Text</div><div class=\"editor source\"><div class=\"measure\"></div><canvas class=\"canvas\" width=\"1\" height=\"1\"></canvas><textarea class=\"default\">Welcome to RegExr v2.0 by gskinner.com!Edit the Expression & Text to see matches. Roll over matches or the expression for details. Undo mistakes with {{ctrl}}-z. Save & Share expressions with friends or the Community. A full Reference & Help is available in the Library, or watch the video Tutorial.Sample text for testing:abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 +-.,!@#$%^&*();\\/|&lt;>\"'12345 -98.7 3.141 .6180 9,000 +42555.123.4567\t+1-(800)-555-2468foo@demo.net\tbar.ba@test.co.ukwww.demo.com\thttp://foo.co.uk/http://regexr.com/foo.html?q=bar\t\t</textarea></div><div class=\"title subst\">Substitution<ul class=\"buttonbar\"><li class=\"button nolabel\" data-icon=\"&#xE192;\" data-alticon=\"&#xE191;\"></li></ul></div><div class=\"editor subst\"></div><div class=\"editor substres\"></div><div class=\"menu flags\"><header>Expression Flags<ul class=\"buttonbar\"><li class=\"button help\" data-icon=\"&#xE195;\"></li></ul></header><hr><a class=\"check\" data-flag=\"i\">ignore case <code>(i)</code></a><br><a class=\"check\" data-flag=\"g\">global <code>(g)</code></a><br><a class=\"check\" data-flag=\"m\">multiline <code>(m)</code></a><br></div><div class=\"menu share\"><header>Share</header><hr><div id=\"shareLinkView\"><input type=\"text\" id=\"shareLinkTxt\"> <a id=\"shareCopyLink\">Copy Link<br><br></a><p id=\"noFlashCopyText\">Press <span class=\"copyKeyLabel\">Ctrl</span>+C to copy your link.</p></div><div id=\"saveView\"><p><a id=\"showSaveLink\">Save</a> your pattern before sharing.</p></div><header>Copy</header><hr><a id=\"copyExpression\">Expression</a> | <a id=\"copyPattern\">Pattern</a> | <a id=\"copyJavascript\">Javascript</a><div id=\"copyMessageView\" class=\"hidden\"><hr><code id=\"copyTxt\"></code><br>Copied to clipboard.</div><div id=\"noFlashCopyView\" class=\"hidden\"><hr><input id=\"noFlashCopyInput\" type=\"text\"><br>Press <span class=\"copyKeyLabel\">dynamic</span>-C to copy.</div></div><div class=\"menu save\"><header>Save</header><hr><div id=\"saveView\" class=\"hidden\"><div class=\"public-wrap\"><header class=\"sub-header\">Add to</header><hr><a id=\"publicChk\" class=\"check\">&nbsp;Community</a><br><a id=\"favouriteChk\" class=\"check\">&nbsp;Favourites</a><br><hr></div><div class=\"save-details-wrap hidden\"><label for=\"titleTxt\">name</label><span id=\"titleTxt-req\">*</span><br><input id=\"titleTxt\" type=\"text\" max=\"30\" maxlength=\"30\" required><br><label for=\"descriptionTxt\">description</label><br><textarea id=\"descriptionTxt\" rows=\"3\" max=\"250\" maxlength=\"250\"></textarea><br><label for=\"tagsTxt\">tags</label><br><input id=\"tagsTxt\" type=\"text\" max=\"50\" maxlength=\"50\"><br><div class=\"tag-list-container\"><div class=\"tag-list\" tabindex=\"2\"><div class=\"renderer item\"><span>{{getLabel()}}</span></div></div></div><label for=\"authorTxt\">author</label><br><input id=\"authorTxt\" type=\"text\" max=\"20\" maxlength=\"20\"><br></div><input id=\"saveBtn\" type=\"button\" class=\"save-button\" value=\"Save\"> <input id=\"updateBtn\" type=\"button\" class=\"update-button\" value=\"Update\"><div id=\"errorMessage\" class=\"error-default\"><hr><p>There was an error saving your pattern.</p><p>Please try again later.</p></div></div><div class=\"success hidden\">Pattern saved. You can now <a id=\"showShareLink\">share</a> your pattern.</div><div class=\"no-changes hidden\">No changes since last save.</div></div></div><div class=\"video hidden\"><iframe width=\"854\" height=\"510\" src=\"//www.youtube.com/embed/fOH62XXGdLs?enablejsapi=1\" frameborder=\"0\" allowfullscreen></iframe></div><img class=\"hidden spinner\" src=\"data:image/gif;base64,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\"> <img class=\"hidden spinner white\" src=\"data:image/gif;base64,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\"><div class=\"not-supported-mobile hidden\"><div class=\"top\"><h1 class=\"icon regexr-logo\">&#xE600;</h1><h1 class=\"regexr-text\">RegExr</h1><span class=\"version regexr-text\">v2.0</span></div><div class=\"content\"><p>RegExr isn't optimized for mobile devices yet. You can still take a look, but it might be a bit quirky.</p><a id=\"closeOverlay\"><b>&gt;</b> Okay!</a></div></div><div class=\"not-supported hidden\"><div class=\"top\"><h1 class=\"icon regexr-logo\">&#xE600;</h1><h1 class=\"regexr-text\">RegExr</h1><span class=\"version regexr-text\">v2.0</span></div><div class=\"content\"><p>RegExr requires a modern browser. Please update your browser to the latest version and try again.</p><p class=\"flash hidden\">If you have Flash support you can still visit <a href=\"v1/\">RegExr version 1</a></p></div></div><script>if (!$.isSupported()) {\t\tvar el = document.querySelector(\".not-supported\");\t\t$.removeClass(el, \"hidden\");\t\tif (ZeroClipboard.detectFlashSupport()) {\t\t\tvar flash = document.getElementsByClassName('flash')[0];\t\t\tflash.className = \"\";\t\t}\t} else if($.partialSupport()) {\t\tvar el = document.querySelector(\".not-supported-mobile\");\t\t$.removeClass(el, \"hidden\");\t\t$.el(\"#closeOverlay\").addEventListener(\"click\", function() {\t\t\t$.addClass(el, \"hidden\");\t\t});\t}</script><script>// injected on build:!function(){\"use strict\";var e=function(){this.init()},i=e.prototype={};i._ctaAnimation=null,i.docView=null,i.libView=null,i.init=function(){if($.isSupported()){ES6Promise.polyfill(),BrowserHistory.init(),BrowserHistory.on(\"change\",this.handleHistoryChange,this),\"regexr.com\"!=document.location.host&&\"www.regexr.com\"!=document.location.host&&$.removeClass($.el(\".beta-banner\"),\"hidden\"),ZeroClipboard.config({moviePath:\"assets/ZeroClipboard.swf\",debug:!1,useNoCache:!1,forceHandCursor:!0}),List.spinner=$.el(\".spinner\");var e=new DocView($.el(\"#docview\"));this.docView=e;var i=$.el(\"#docview .default\");DocView.DEFAULT_TEXT=(i.textContent||i.innerText).trim().replace(\"{{ctrl}}\",Utils.getCtrlKey().toLowerCase()),e.setText(),$.defer(e,e.setText),i.style.display=\"none\";var t=$.el(\"#cheatsheet\");t.style.display=\"none\",Docs.getItem(\"cheatsheet\").desc=t.innerHTML,e.setExpression(DocView.DEFAULT_EXPRESSION).setSubstitution(DocView.DEFAULT_SUBSTITUTION),e.resetHistory();var n=new LibView($.el(\"#libview\"),Docs.content.library);this.libView=n,n.docView=e,e.libView=n,ExpressionModel.docView=e,ExpressionModel.saveState(),this.videoLink=$.el(\".video-link\"),this.videoLink.addEventListener(\"click\",$.bind(this,this.showVideo)),this.handleVideoCloseProxy=$.bind(this,this.handleVideoClick);var o=this,s=this._ctaAnimation=function(e){if(s.stop)return void $.removeClass(o.videoLink,\"transition\");new TransitionEvents(o.videoLink).on(TransitionEvents.TRANSISTION_END,function(){new TransitionEvents(o.videoLink).on(TransitionEvents.TRANSISTION_END,function(){e(e)},null,!0);$.removeClass(o.videoLink,\"cta\")},null,!0);$.addClass(o.videoLink,\"cta\")};if(0==Settings.getVisitCount()){$.addClass(this.videoLink,\"transition\"),this.videoLink.onmouseover=function(){s.stop=!0,$.removeClass(o.videoLink,\"transition\"),clearInterval(a)},this._ctaAnimation(this._ctaAnimation);var a=setTimeout(function(){s.stop=!0},3e4)}Settings.trackVisit(),Settings.cleanSaveTokens(),this.navigate()}},i.handleHistoryChange=function(){this.navigate()},i.navigate=function(){var e=document.location.toString(),i=/[\\/#\\?]([\\w\\d]+)$/gi.exec(e),t=null;if(i&&(t=i[1]),ExpressionModel.id!=$.idToNumber(t)+\"\")if($.isIDValid(t)){var n=this;ServerModel.getPatternByID(t).then(function(e){ExpressionModel.setLastSave(e);var i=$.parsePattern(e.pattern);n.docView.setState(null!=e.state&&\"\"!=e.state?JSON.parse(e.state):{}),n.docView.populateAll(i.ex,i.flags,e.content,e.replace)},function(){BrowserHistory.go()})}else BrowserHistory.go()},i.showVideo=function(e){var i=null,t=$.el(\".video\");e!==!1?($.removeClass(t,\"hidden\"),t.addEventListener(\"click\",this.handleVideoCloseProxy),i=\"playVideo\",this._ctaAnimation.stop=!0):($.addClass(t,\"hidden\"),t.removeEventListener(\"click\",this.handleVideoCloseProxy),i=\"pauseVideo\");var n=$.el(\".video iframe\").contentWindow;n.postMessage('{\"event\":\"command\",\"func\":\"'+i+'\",\"args\":\"\"}',\"*\")},i.handleVideoClick=function(){this.showVideo(!1)},window.RegExr=e}(),WebFont.load({google:{families:[\"Source Code Pro:400,700\",\"Cabin:400,700\"],fontinactive:function(){WebFont.load({custom:{families:[\"Source Code Pro:400,700\",\"Cabin:400,700\"],urls:[\"css/fontFallback.css\"]}})}},active:function(){window.regexr=new window.RegExr}});</script></body></html>";
        String NoHTML = HtmlStringHelper.Sanitize(HTML);
        String HTMLScripts = HtmlStringHelper.SanitizeAndRemoveScripts(HTML);

        Assert.assertFalse(NoHTML.contains("<"));
        Assert.assertFalse(HTMLScripts.contains("<"));
        Assert.assertFalse(HTMLScripts.contains("function"));
    }
}