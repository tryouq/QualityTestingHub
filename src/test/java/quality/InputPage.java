package quality;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.w3c.dom.Text;

import java.awt.font.TextAttribute;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class InputPage {
    public void openWebSite(String url){
        Selenide.open(url);
    }

    public void clickInputPage(){
        $x("//*[@id=\"content\"]/div/div/section[2]/div/div[1]/div/div[2]/div/div/a/span/span").click();
    }

    //Введение имени
    public String inputTextWithAdd(){
        $x("//*[@id=\"nameInput\"]").setValue("Maxim");
        $x("//*[@id=\"post-101\"]/div/div/section[4]/div/div/div/div/div/button").click();

        //Возврат текста которого ввели в поле
        String text = $x("//*[@id=\"data-container\"]/div").getText();
        //Там считывает еще и клосе, поэтому подчистил его
        return text.replace("Close", "");
    }

    public void deleteText(){
        $x("//*[@id=\"data-container\"]/div/span").click();
    }

    public String getDeleteText(){
        return $x("//*[@id=\"data-container\"]").getText();
    }
}
