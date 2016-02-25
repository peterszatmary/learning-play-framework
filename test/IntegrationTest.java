import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;
import testutils.PlayTestCredencials;

import static play.test.Helpers.*;
import static org.junit.Assert.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {

    //seams like a bug: selenium bug
    // https://github.com/playframework/playframework/issues/2607
    // i will test just non responsive part of app
    // org.openqa.selenium.WebDriverException: com.gargoylesoftware.htmlunit.ScriptException: TypeError: Cannot find function addEventListener in object [object HTMLDocument]. (http://localhost:3334/assets/javascripts/foundation/js/vendor/jquery.js#24)
    @Test
    public void test() {
        //TODO dorobit pre homepage
        running(testServer(3334, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3334/homepage");
                assertTrue(browser.pageSource().contains(""));
            }
        });
    }
}
