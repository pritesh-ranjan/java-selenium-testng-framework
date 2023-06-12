package pages;

import pages.components.SearchBar;

public class YelpBasePage extends BasePage {
    private final SearchBar searchBar;

    public YelpBasePage() {
        searchBar = new SearchBar();
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }
}
