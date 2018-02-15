import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.driver.MyDriverManager;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

@Title("Appium demo test")
public class AppiumDemoTest {

    @Features("Google search")
    @Title("Google search test with Selenoid")
    @Test
    public void searchDemo(){
        WebDriverRunner.setWebDriver(MyDriverManager.createCustomChromeAppiumDriver("http://127.0.0.1:4723/wd/hub", Thread.currentThread().getStackTrace()[1].getMethodName()));
        com.codeborne.selenide.Configuration.browser = "chrome";
        open("http://google.com");
        new SearchPage().search("Appium")
                .verifyTestResultContainsString("Appium: Mobile App Automation Made Awesome.");
        close();

    }
}
