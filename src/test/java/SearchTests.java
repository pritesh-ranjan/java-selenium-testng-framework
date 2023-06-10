import annotations.Author;
import annotations.Browser;
import annotations.TestCaseLink;
import controllers.BaseTest;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.ConfigFactory;
import utils.WebDriverFactory;

public class SearchTests extends BaseTest {

    @Author(author = "Pritesh")
    @TestCaseLink(jiraId = "21723")
    @Browser(name = "CHROME")
    @Test(description = "test functionality")
    public void testFunc() {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get("https://www.google.com/");
        System.out.print(driver.getTitle());
        Assertions.assertThat(1).isEqualTo(2);
    }

    @Author(author = "Pritesh")
    @TestCaseLink(jiraId = "21723")
    @Browser(name = "CHROME")
    @Test(description = "test functionality")
    public void testFunc2() {
        WebDriver driver = WebDriverFactory.getDriver();
        driver.get(ConfigFactory.getConfig().url());
        System.out.print(driver.getTitle());
        Assertions.assertThat(1).isEqualTo(2);
    }
}
