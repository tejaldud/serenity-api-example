package User;

import model.UserDTO;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class GetUserAPI {

    private static String GET_USER = "/v2/user/{username}";
    private EnvironmentVariables environmentVariables;
    @Step("Get User Details")
    public UserDTO getUser(String userName) {
        UserDTO response = SerenityRest.given()
                .pathParam("username", userName)
                .get(environmentVariables.getProperty("restapi.baseurl") + GET_USER)
                .as(UserDTO.class);
        return response;
    }
}
