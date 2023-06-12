package pages.components;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.SearchResultsPage;

public class SearchBar extends BasePage {
    private static final By SEARCH_BOX = By.cssSelector("#search_description");
    private static final By SEARCH_LOCATION = By.cssSelector("#search_location");
    private static final By SUBMIT = By.xpath("//form//button[@aria-label='Search']");

    public SearchBar enterSearchText(String text) {
        sendKeys(SEARCH_BOX, text);
        return this;
    }

    public SearchBar setSearchLocation(String location) {
        sendKeys(SEARCH_LOCATION, location);
        return this;
    }

    public SearchResultsPage search() {
        click(SUBMIT);
        return new SearchResultsPage();
    }
}
