package pages;

import org.openqa.selenium.By;
import pages.components.SearchResult;

import java.util.List;

public class SearchResultsPage extends YelpBasePage {
    private static final By PAGE_HEADING = By.xpath("//h1/span");
    private static final By SEARCH_RESULTS_DIVS = By.xpath("//ul/li[.//div[contains(@class, 'businessName')]]");

    public String getPageHeading() {
        return getText(PAGE_HEADING);
    }

    public List<SearchResult> getSearchResults() {
        return driver.findElements(SEARCH_RESULTS_DIVS)
                .stream()
                .map(SearchResult::new)
                .toList();

    }
}
