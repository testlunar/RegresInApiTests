package tests;

import io.qameta.allure.Epic;
import lombokModels.createUser.CreateUserRequest;
import lombokModels.createUser.CreateUserResponse;
import lombokModels.singleUserSearch.SingleUserResponse;
import lombokModels.updateUser.UpdateUserRequest;
import lombokModels.updateUser.UpdateUserResponce;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static specs.Data.*;
import static specs.Endpoints.*;
import static specs.Specifications.requestSpec;

@Epic("reqres.in")
@DisplayName("Действия над пользователями")
public class UserTests {

    @Test
    @Tag("Positive")
    @DisplayName("Создание пользователя")
    void createUserTest() {
        CreateUserRequest data = new CreateUserRequest();
        data.setName(USER_NAME);
        data.setJob(USER_FOR_CREATE_JOB);

        CreateUserResponse response = given(requestSpec)
                .body(data)
                .when()
                .post(API_USERS)
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .extract().as(CreateUserResponse.class);

        assertThat(response.getName()).isEqualTo(USER_NAME);
        assertThat(response.getJob()).isEqualTo(USER_FOR_CREATE_JOB);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Обновление пользователя")
    void updateUserInfoTest() {
        UpdateUserRequest data = new UpdateUserRequest();
        data.setName(USER_NAME);
        data.setJob(USER_FOR_UPDATE_JOB);

        UpdateUserResponce response = given(requestSpec)
                .body(data)
                .when()
                .put(API_USER_UPDATE)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(UpdateUserResponce.class);

        assertThat(response.getName()).isEqualTo(USER_NAME);
        assertThat(response.getJob()).isEqualTo(USER_FOR_UPDATE_JOB);
    }

    @Test
    @Tag("Negative")
    @DisplayName("Пользователь не найден")
    void singleUserNotFoundTest() {

        given(requestSpec)
                .log().uri()
                .when()
                .get(API_USER_NOT_FOUND)
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Запрос по id и проверка данных пользователя")
    void getUserByIdTest() {
        SingleUserResponse response = given(requestSpec)
                .when()
                .get(API_USER_GET_BY_ID)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(SingleUserResponse.class);

        assertThat(response.getData().getLast_name()).isEqualTo(USER_ID2_LAST_NAME);
        assertThat(response.getData().getFirst_name()).isEqualTo(USER_ID2_FIRST_NAME);
        assertThat(response.getData().getEmail()).isEqualTo(USER_ID2_EMAIL);
        assertThat(response.getData().getId()).isEqualTo(USER_ID2_);
        assertThat(response.getData().getAvatar()).isEqualTo(USER_ID2_AVATAR);

    }

    @Test
    @Tag("Positive")
    @DisplayName("Удаление пользователя")
    void deleteUserByIdTest() {
        given(requestSpec)
                .when()
                .delete(API_USER_DELETE)
                .then()
                .log().status()
                .log().body()
                .statusCode(204);
    }

    @Test
    @Tag("Positive")
    @DisplayName("Проверка, что количество записей в списке равно заданному")
    void getListSizeResourceTest() {
        int sizeDataList = given(requestSpec)
                .when()
                .get(API_UNKNOWN)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().body().jsonPath().getList("data").size();

        assertThat(sizeDataList).isEqualTo(6);
    }
}
