package Lesson_8;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

//Наследуем baseURI
public class PostmanEchoTest extends BaseApiTest {

    //Тест GET метода
    @Test
    public void testGetMethod() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
        .when()
                .get("/get")
        .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                //Проверяем что URL в ответе совпадает с ожидаемым
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    //Тест POST с текстом
    @Test
    public void testPostRawTextMethod() {
        given()
                .contentType("text/plain")
                .body("Creating new record")
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("data", equalTo("Creating new record"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    //Тест POST с form data
    @Test
    public void testPostFormDataMethod() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
        .when()
                .post("/post")
        .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    //Тест PUT метода
    @Test
    public void testPutMethod() {
        given()
                .contentType("text/plain")
                .body("Full update of record")
        .when()
                .put("/put")
        .then()
                .statusCode(200)
                .body("data", equalTo("Full update of record"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    //Тест PATCH метода
    @Test
    public void testPatchMethod() {
        given()
                .contentType("text/plain")
                .body("Partial update of record")
        .when()
                .patch("/patch")
        .then()
                .statusCode(200)
                .body("data", equalTo("Partial update of record"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    //Тест DELETE метода
    @Test
    public void testDeleteMethod() {
        given()
                .contentType("text/plain")
                .body("Deleting record")
        .when()
                .delete("/delete")
        .then()
                .statusCode(200)
                .body("data", equalTo("Deleting record"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}