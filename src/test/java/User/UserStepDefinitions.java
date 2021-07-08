package User;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import model.UserDTO;
import net.thucydides.core.annotations.Steps;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class UserStepDefinitions {

    @Steps
    AddUserAPI userAPI;
    @Steps
    GetUserAPI getUserAPI;

    private UserDTO userDTO = new UserDTO();
    private UserDTO expectedUserDetails;

    @And("^I want to create user with below details:$")
    public void heHasEmailAddress(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        userDTO.setFirstName(data.get("firstName"));
        userDTO.setLastName(data.get("lastName"));
        userDTO.setPassword(data.get("password"));
        userDTO.setPhone(data.get("phone"));
        userDTO.setUsername(data.get("username"));
        userDTO.setEmail(data.get("email"));
    }

    @When("I create user")
    public void iCreateUser() {
        userAPI.addUser(userDTO);
    }

    @Then("I have user is created successfully")
    public void iHaveUserIsCreatedSuccessfully() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @When("I get user details with username as {string}")
    public void iGetUserWithUsernameAsTest(String userName) {
         expectedUserDetails = getUserAPI.getUser(userName);
    }

    @Then("I validate response has expected details")
    public void iValidateResponseHasExpectedDetails() throws JsonProcessingException {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("username", equalTo(userDTO.getUsername())));
        restAssuredThat(userDTO-> is(expectedUserDetails));
    }
}
