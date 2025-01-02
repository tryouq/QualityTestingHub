package quality;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    public void set(){
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @Before
    public void init(){
        set();
    }

    @After
    public void setDown(){
        Selenide.closeWebDriver();
    }
}
