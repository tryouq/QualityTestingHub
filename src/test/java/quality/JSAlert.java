package quality;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.selector.ByText;

import static com.codeborne.selenide.Selenide.*;

public class JSAlert {
    public void openWebSite(String url){
        Selenide.open(url);
    }

    public String clickPage(){
        $x("//*[@id=\"content\"]/div/div/section[2]/div/div[1]/div/div[3]/div/div/a").click();
        return WebDriverRunner.url();
    }

    public boolean clickJsAlert(){
        $x("//*[@id=\"post-110\"]/div/div/section[4]/div/div/div/div/div/div[1]/button").click();
        confirm(); //для ок alerta
        return $(new ByText("You have clicked Javascript Alert")).isDisplayed(); //Возвращаем полученный текст с страницы
    }

    public boolean clickJsConfirm(){
        $x("//*[@id=\"post-110\"]/div/div/section[4]/div/div/div/div/div/div[2]/button").click();
        confirm();//для ок confirm
        return $(new ByText("You have clicked JavaScript Confirm")).isDisplayed();
    }

    public boolean clickJsPrompt(){
        $x("//*[@id=\"post-110\"]/div/div/section[4]/div/div/div/div/div/div[3]/button").click();
        prompt("Проверка промта");
        return $(new ByText("Welcome Проверка промта")).isDisplayed();
    }
}
