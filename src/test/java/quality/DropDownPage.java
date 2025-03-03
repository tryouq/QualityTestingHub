package quality;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DropDownPage {
    public void openWebSite(String url){
        Selenide.open(url);
    }

    public void clickPage(){
        $x("//*[@id=\"content\"]/div/div/section[2]/div/div[3]/div/div[2]/div/div/a/span/span").click();
    }

    public void useFromDropDown(){
        //Так можно выберать значения из dropDown
        SelenideElement dropdown = $("#testingtypes");
        dropdown.selectOption("FunctionTesting");
    }

    public boolean useValue(String a){
        if ($(new ByText(a)).isDisplayed()==true){
        return true;
        }else return false;
    }
}
