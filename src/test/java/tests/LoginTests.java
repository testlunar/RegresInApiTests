package tests;

import io.qameta.allure.Epic;
import lombokModels.login.LoginRequest;
import lombokModels.login.LoginResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specs.Data.*;
import static specs.Endpoints.*;
import static specs.Specifications.*;


@Epic("reqres.in")

@DisplayName("Логин пользователя в систему")
public class LoginTests {

    @Test
    @Tag("Positive")
    @DisplayName("Успешный логин пользователя")
    void loginSuccessTest() {
        LoginRequest data = new LoginRequest();
        data.setEmail(EMAIL_FOR_SUCCESS);
        data.setPassword(PASS_FOR_SUCCESS_LOGIN);

        LoginResponse response = given(requestSpec)
                .body(data)
                .when()
                .post(API_LOGIN)
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(LoginResponse.class);

        assertThat(response.getToken()).isEqualTo(TOKEN);
    }

    @Test
    @Tag("Negative")
    @DisplayName("Неуспешный логин пользователя")
    void loginFailTest() {
        LoginRequest data = new LoginRequest();
        data.setEmail(EMAIL_FOR_UN_SUCCESS_LOGIN);

        String response = given(requestSpec)
                .body(data)
                .when()
                .post(API_LOGIN)
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .extract().path("error");

        assertThat(response).isEqualTo(ERROR_MESSAGE);
    }
}
