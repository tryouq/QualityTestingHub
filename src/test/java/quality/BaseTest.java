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

    @BeforeAll
    public static void setup() {
        // Устанавливаем глобальный таймаут ожидания (в миллисекундах)
        Configuration.timeout = 10000; // 10 секунд

        // Устанавливаем интервал проверки (polling interval) в миллисекундах
        Configuration.pollingInterval = 1000; // Проверка каждые 500 мс
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