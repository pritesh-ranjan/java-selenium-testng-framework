import annotations.Author;
import annotations.Browser;
import annotations.TestCaseLink;
import controllers.BaseTest;
import org.assertj.core.api.Assertions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class SearchTests extends BaseTest {
    @Author(author = "Pritesh")
    @TestCaseLink(jiraId = "21723")
    @Browser(name = "CHROME")
    @Test(description = "To test positive search flow", dataProvider = "getValidSearchData")
    public void searchPositiveTest(String searchText) {
        SearchResultsPage resultsPage = new HomePage()
                .getSearchBar()
                .enterSearchText(searchText)
                .search();
        Reporter.log("searched with " + searchText);
        Assertions.assertThat(resultsPage.getTitle()).containsIgnoringCase(searchText);
        Assertions.assertThat(resultsPage.getPageHeading()).containsIgnoringCase(searchText);
    }

    @Author(author = "Pritesh")
    @TestCaseLink(jiraId = "21727")
    @Test(description = "test functionality", dataProvider = "getInvalidSearchData")
    public void searchNegativeTest(String searchText) {
        SearchResultsPage resultsPage = new HomePage()
                .getSearchBar()
                .enterSearchText(searchText)
                .search();
        Reporter.log("searched with " + searchText);
        Assertions.assertThat(resultsPage.getTitle()).containsIgnoringCase(searchText);
        Assertions.assertThat(resultsPage.getPageHeading()).doesNotContainIgnoringCase(searchText);
    }

    @DataProvider
    public Object[][] getValidSearchData() {
        return new Object[][]{
                {"italian"},
                {"cheap dinner"}
        };
    }

    @DataProvider
    public Object[][] getInvalidSearchData() {
        return new Object[][]{
                {"Ilalian Food"},
                {"sheap diner"}
        };
    }
}
