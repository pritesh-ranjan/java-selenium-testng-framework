package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;

import static constants.UIConstants.SPACE;

public class SearchResult extends BasePage {
    private static final String STATUS = "Open";
    private static final By BUSINESS_NAME_LOCATOR = By.cssSelector("div[class^=' businessName']");
    private static final By STAR_RATING_LOCATOR = By.cssSelector("div[class^=' five-stars']");
    private static final By OPEN_CLOSE_STATUS_LOCATOR = By.xpath("div[@data-testid='shimmer_container']//p/span");
    private final WebElement RESULT;
    private final String businessName;

    public SearchResult(WebElement result) {
        this.RESULT = result;
        this.businessName = result.findElement(BUSINESS_NAME_LOCATOR).getText();
    }

    public int getStarRating() {
        return Integer.parseInt(RESULT.findElement(STAR_RATING_LOCATOR).getText().split(SPACE)[0]);
    }


    public String getBusinessName() {
        return businessName;
    }

}
