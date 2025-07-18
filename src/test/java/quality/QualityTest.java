package quality;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class QualityTest extends BaseTest{
    private final static String Base_url = "https://automationpractice.qualitytestinghub.com/";
    private final static String currentUrlDes = "https://automationpractice.qualitytestinghub.com/disappearing-elements/";


    @Test
    @Order(3)
    public void test1_checkDes(){
        DesappearingPage desPage = new DesappearingPage();
        set();
        openWebSite(Base_url);
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
    @Order(2)
    public void test2_checkAddRem(){
        AddPage addPage = new AddPage();

        set();
        openWebSite(Base_url);
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
    @Order(1)
    public void test4_jqueryUI(){
        JQueryUIpage jqueryPage = new JQueryUIpage();

        set();
        openWebSite(Base_url);
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

    private final static String inputPageUrl = "https://automationpractice.qualitytestinghub.com/inputs/";
    @Test
    @Order(4)
    void test5_inputPage(){
        InputPage inputPage = new InputPage();

        set();
        inputPage.openWebSite(Base_url);
        inputPage.clickInputPage();
        assertEquals(WebDriverRunner.url(), inputPageUrl);

        //Проверка что текст MaximClose, клосе потому что, не забирало чисто текст с первого дива, также с кнопки берет
        assertEquals("Maxim", inputPage.inputTextWithAdd());
        inputPage.deleteText();

        //Проверили что текста нет, так как не получится проверить по style=hidden, ТУТ ТОКО ТАК!
        assertEquals("", inputPage.getDeleteText());

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }

    //В дальнейшем под rest assure
    //Test
    //public void test6_DragAndDrop(){}

    private final static String dropDownUrl = "https://automationpractice.qualitytestinghub.com/dropdown-list/";
    @Test
    @Order(5)
    void test7_DropDownList(){
        DropDownPage dropDown = new DropDownPage();
        set();
        openWebSite(Base_url);
        dropDown.clickPage();
        assertEquals(WebDriverRunner.url(), dropDownUrl);

        dropDown.useFromDropDown();

        //Проверка что дроп даун меню работает и можно сделать выбор из выпадающего меню
        assertTrue(dropDown.useValue("FunctionTesting"));

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }

    private final String checkboxesUrl = "https://automationpractice.qualitytestinghub.com/checkboxes/";
    @Test
    @Order(6)
    void test8_CheckBoxes(){
        CheckBoxes checkBoxes = new CheckBoxes();
        set();
        openWebSite(Base_url);
        checkBoxes.clickPage();

        assertEquals(checkboxesUrl, WebDriverRunner.url());

        checkBoxes.clickBlackBox();
        checkBoxes.clickGreyBox();

        assertTrue(checkBoxes.checkBoxBlackBox());
        assertTrue(checkBoxes.checkBoxGreyBox());

        checkBoxes.clickBlackBox();
        checkBoxes.clickGreyBox();

        assertFalse(checkBoxes.checkBoxBlackBox());
        assertFalse(checkBoxes.checkBoxGreyBox());

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }

    private final String jsAlertURL = "https://automationpractice.qualitytestinghub.com/javascript-alerts/";
    @Test
    @Order(7)
    void test9_JSAlert(){
        JSAlert jsAlert = new JSAlert();

        set();
        openWebSite(Base_url);
        assertEquals(jsAlertURL, jsAlert.clickPage());

        //Проверки на прохождение alerts
        assertTrue(jsAlert.clickJsAlert());
        assertTrue(jsAlert.clickJsConfirm());
        assertTrue(jsAlert.clickJsPrompt());

        //Выход на основую станицу и проверка что перешли
        $x("//*[@id=\"menu-item-132\"]/a").click();
        assertEquals(WebDriverRunner.url(), Base_url);
    }

    //Не получилось, дерьмо какое то
    private final String floatingMenuURL = "https://automationpractice.qualitytestinghub.com/floating-menu/";
    @Test
    @Order(8)
    void test10_FloatingMenu(){
        FloatingMenu floatingMenu = new FloatingMenu();
        set();
        openWebSite(Base_url);
        assertEquals(floatingMenuURL, floatingMenu.clickFloatingPage());

        //assertEquals(floatingMenu.useScroll(), "black");
    }
}
