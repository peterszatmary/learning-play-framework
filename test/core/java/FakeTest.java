package core.java;

import org.junit.Assert;
import org.junit.Test;
import play.Logger;

/**
 * Created by nue on 4.9.2015.
 */
public class FakeTest {

    // junit test under play
    @Test
    public void fake() {
        Logger.info("fake test starts");
        Assert.assertTrue(0 != 2);
        //Assert.assertEquals("A", "B");
        //Assert.assertFalse(0 != 2);
        Logger.info("fake test ends");
    }

}
