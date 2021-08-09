package User;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import model.UserDTO;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class AddUserAPI {

    private static String ADD_USER = "/v2/user";
    private static String baseURL = "";
    private EnvironmentVariables environmentVariables;

    @Before
    public void configureBaseUrl() {
        baseURL= EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.baseurl");
    }

    @Step("I add User")
    public void addUser(UserDTO userDTO) {

        SerenityRest.given()
//                .baseUri(environmentVariables.getProperty("restapi.baseurl")+ADD_USER)
                .baseUri(baseURL + ADD_USER)
                .body(userDTO)
                .contentType("application/json")
                .post();
    }
}
