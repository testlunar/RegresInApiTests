package tests;

import io.qameta.allure.Epic;
import lombokModels.registationUser.RegistrationRequest;
import lombokModels.registationUser.RegistrationResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specs.Data.*;
import static specs.Endpoints.*;
import static specs.Specifications.*;

@Epic("reqres.in")
@DisplayName("Регистрация пользователя")
public class RegistrationTests {

    @Test
    @Tag("Positive")
    @DisplayName("Успешная регистрация пользователя")
    void registrationSuccessTest() {

        RegistrationRequest data = new RegistrationRequest();
        data.setEmail(EMAIL_FOR_SUCCESS);
        data.setPassword(PASS_FOR_SUCCESS_REGISTRATION);

        RegistrationResponse response = given(requestSpec)
                .body(data)
                .when()
                .post(API_REGISTER)
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(RegistrationResponse.class);

        assertThat(response.getToken()).isEqualTo(TOKEN);
        assertThat(response.getId()).isEqualTo(ID);
    }

    @Test
    @Tag("Negative")
    @DisplayName("Неуспешная регистрация пользователя")
    void registrationFailTest() {
        RegistrationRequest data = new RegistrationRequest();
        data.setEmail(EMAIL_FOR_UN_SUCCESS_REGISTRATION);

        String response = given(requestSpec)
                .body(data)
                .when()
                .post(API_REGISTER)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().path("error");

        assertThat(response).isEqualTo(ERROR_MESSAGE);
    }
}
