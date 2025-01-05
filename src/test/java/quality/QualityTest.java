package quality;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QualityTest extends BaseTest{
    private final static String Base_url = "https://automationpractice.qualitytestinghub.com/";
    private final static String currentUrlDes = "https://automationpractice.qualitytestinghub.com/disappearing-elements/";

    @Test
    //@Order(1)
    public void test1_checkDes(){
        DesappearingPage desPage = new DesappearingPage();

        desPage.openWebSite(Base_url);
        desPage.clickDesappearing();

        //проверка url, что мы на верной странице
        assertEquals(desPage.getHrefDes(), currentUrlDes);

        //вернул в функциях строки в css style, тут сравниваю что он display none
        assertEquals(desPage.clickFigureCircle(), "display: none;");
        assertEquals(desPage.clickFigureRounded(), "display: none;");
        assertEquals(desPage.clickFigureSquare(), "display: none;");

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }

    private final static String currentUrlAdd = "https://automationpractice.qualitytestinghub.com/add-remove-elements/";
    @Test
    //@Order(2)
    public void test2_checkAddRem(){
        AddPage addPage = new AddPage();

        addPage.openWebSite(Base_url);
        addPage.clickAdd();
        //Проверка что мы находимся на верной странице
        assertEquals(WebDriverRunner.url(), currentUrlAdd);

        //Вводи и добовляем текст
        addPage.enterText();
        //проверяем что текст был введен и добавлен
        String testText = "text test 123";
        assertEquals(addPage.getText(), testText);
        //удаляем текст
        addPage.deleteText();
        //Проверяем по тексту что его нет на странице
        assertFalse(addPage.getClearText());

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }

    //В дальнейшем под rest assure
    //Test
    //public void test3_brokenImages(){}

    private final static String currentJQueryPage= "https://automationpractice.qualitytestinghub.com/jquery-ui-menu/";
    @Test
    public void test4_jqueryUI(){
        JQueryUIpage jqueryPage = new JQueryUIpage();

        jqueryPage.openWebSite(Base_url);
        jqueryPage.clickJqueryPage();
        assertEquals(WebDriverRunner.url(), currentJQueryPage);

        //Проверка что в эллементах выпадаещего меню ушел display none
        assertFalse(jqueryPage.clickMusicButton().contains("display: none;"));
        assertFalse(jqueryPage.clickRockButton().contains("display: none;"));

        //Проверить что в выпадающем меню мы нашли кнопку альтернатива
        String nameAlternativeButton = "Alternative";
        assertEquals(jqueryPage.clickAlternativeBanner(), nameAlternativeButton);

        //Проверка что в выпадающем меню появился display none
        assertTrue(jqueryPage.bannersIsClose().contains("display: none;"));

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }
}
