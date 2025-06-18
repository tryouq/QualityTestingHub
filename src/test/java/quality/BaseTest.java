package quality;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    public void set() {
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    public void openWebSite(String url){
        Selenide.open(url);
    }

    @Before
    public void init() {
        set();
    }

    @After
    public void setDown() {
        Selenide.closeWebDriver();
    }

}