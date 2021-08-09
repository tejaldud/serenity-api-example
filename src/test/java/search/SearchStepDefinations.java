package search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchStepDefinations {

    @Steps
    SearchPage searchPage;
    @Steps
    ResultsPage resultsPage;

    @When("I am on the Search page")
    public void onSearchPage() {
        searchPage.open();
    }

    @And("I search for term (.*)$")
    public void iSearchForTerm(String term) {
        searchPage.searchBy(term);
    }

    @Then("he should only see search results containing the word (.*)$")
    public void he_should_only_see_search_results_containing_the_word(String expectedKeyword) {
        resultsPage.getSearchResultTitles().forEach(
                title -> assertThat(title).containsIgnoringCase(expectedKeyword)
        );
    }
}
