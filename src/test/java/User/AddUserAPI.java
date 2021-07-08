package User;

import model.UserDTO;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class AddUserAPI {

    private static String ADD_USER = "/v2/user";
    private EnvironmentVariables environmentVariables;
    @Step("I add User")
    public void addUser(UserDTO userDTO) {
        SerenityRest.given()
                .baseUri(environmentVariables.getProperty("restapi.baseurl")+ADD_USER)
                .body(userDTO)
                .contentType("application/json")
                .post();
    }
}
