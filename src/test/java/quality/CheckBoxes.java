package quality;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.conditions.Checked;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.$x;

public class CheckBoxes {
    public void openWebSite(String url){
        Selenide.open(url);
    }

    public void clickPage(){
        $x("//*[@id=\"content\"]/div/div/section[2]/div/div[4]/div/div[2]/div/div/a/span/span").click();
    }

     public void clickBlackBox(){
        $x("//*[@id=\"post-67\"]/div/div/section/div/div/div/div/div/form/label[1]").click();
     }

     public boolean checkBoxBlackBox(){
        return $x("//*[@id=\"blackboxtesting\"]").is(checked);
     }

     public void clickGreyBox(){
        $x("//*[@id=\"post-67\"]/div/div/section/div/div/div/div/div/form/label[3]").click();
     }

     public boolean checkBoxGreyBox(){
        return $x("//*[@id=\"greyboxtesting\"]").is(checked);
     }
}
