package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static specs.Data.BASE_URL;

public class Specifications {
    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri(BASE_URL)
            .basePath("/api");

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .build();
}
