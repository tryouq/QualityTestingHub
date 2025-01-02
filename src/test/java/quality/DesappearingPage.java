package quality;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DesappearingPage {
    private final SelenideElement desButton = $x("//*[@id=\"content\"]/div/div/section[2]/div/div[1]/div/div[1]/div/div/a/span/span");

    public void openWebSite(String url){
        Selenide.open(url);
    }

    public void clickDesappearing(){
        desButton.click();
    }

    public String getHrefDes(){
        return WebDriverRunner.url();
    }

    //Сначала кликаю, потом возвращаю строку, где атрибут стиля, то есть css style
    public String clickFigureCircle(){
        $(By.className("circle")).click();
        String circle = $(By.className("circle")).getAttribute("style");
        return circle;
    }

    public String clickFigureRounded() {
        $(By.className("rounded")).click();
        String rounded = $(By.className("circle")).getAttribute("style");
        return rounded;
    }

    public String clickFigureSquare(){
        $(By.className("square")).click();
        String square = $(By.className("circle")).getAttribute("style");
        return square;
    }
}
