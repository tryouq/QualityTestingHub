package quality;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class AddPage {
    public void openWebSite(String url){
        Selenide.open(url);
    }

    public void clickAdd(){
        $x("//*[@id=\"content\"]/div/div/section[2]/div/div[2]/div/div[1]/div/div/a/span/span").click();
        //sleep(500);
    }

    public void enterText(){
        //Ввод текста в поле по xpath
        $x("//*[@id=\"data\"]").append("text test 123");
        $(By.className("addbtn")).click();
    }

    public String getText(){
        String customeText = $x("//*[@id=\"label1\"]").getText();
        return customeText;
    }

    public void deleteText(){
        $(By.className("deletebtn")).click();
        //sleep(2000);
    }

    public boolean getClearText(){
        if ($(new ByText("text test 123")).isDisplayed()==false) {
            return false;
        } else return true;
    }
}
