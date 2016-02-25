package views;

import org.junit.Test;
import play.i18n.Messages;
import play.twirl.api.Content;
import testutils.PlayTestCredencials;

import static play.test.Helpers.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import static play.test.Helpers.fakeApplication;

/**
 * Created by nue on 4.9.2015.
 */
public class IndexViewTest extends PlayTestCredencials {

    // point here is controll existance of strings in output
    @Test
    public void renderTest() {
        running(fakeApplication(), () -> { // runnable
                Content html = views.html.index.render("", null);
                assertEquals("text/html", html.contentType());
                // email label
                assertTrue(contentAsString(html).contains(Messages.get("index.text.email")));
                // password label
                assertTrue(contentAsString(html).contains(Messages.get("index.text.password")));
                // on index is video
                assertTrue(contentAsString(html).contains("flex-video"));
                // registration link
                assertTrue(contentAsString(html).contains(Messages.get("index.text.registration") + "</a>"));
        });
    }

}
