import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    void shouldTestDataInfo() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    void shouldTestTextMessage() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Test message")

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("data", equalTo("Test message"))
        ;

    }
}
