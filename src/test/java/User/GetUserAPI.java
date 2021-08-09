package User;

import io.cucumber.java.Before;
import model.UserDTO;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class GetUserAPI {

    private static String GET_USER = "/v2/user/{username}";
    private EnvironmentVariables environmentVariables;
    private String baseURL;


    public void configureBaseUrl() {
        baseURL= EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("restapi.baseurl");
    }

    @Step("Get User Details")
    public UserDTO getUser(String userName) {
        configureBaseUrl();
        UserDTO response = SerenityRest.given()
                .pathParam("username", userName)
                .get(baseURL + GET_USER)
                .as(UserDTO.class);
        return response;
    }
}
