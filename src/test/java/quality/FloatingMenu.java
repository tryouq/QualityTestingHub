package quality;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FloatingMenu{
    public String clickFloatingPage(){
        $x("//*[@id=\"content\"]/div/div/section[2]/div/div[2]/div/div[3]/div/div/a").click();
        return WebDriverRunner.url();
    }

    public String useScroll(){
        $x("//*[@id=\"post-88\"]/div/div/section[4]/div/div/div/div/div/div[2]/p[20]").scrollTo();
        return $x("//*[@id=\"post-88\"]/div/div/section[4]/div/div/div/div/div/div[1]/a[3]").getAttribute("style");
    }
}
