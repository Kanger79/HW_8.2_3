package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class postManTest {

    @Test
    void shouldReturnSendData() {
        // Given - When - Then
    // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Home Work\r\nисполнитель Кангер Дмитрий\r\nгруппа QA-60") // отправляемые данные (заголовки и query можно выставлять аналогично)

    // Выполняемые действия
                .when()
                .post("/post")
    // Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Home Work\r\nисполнитель Кангер Дмитрий\r\nгруппа QA-60"))
                .headers("Content-Type", equalTo("application/json; charset=utf-8"))
                .headers("Connection", equalTo("keep-alive"))
        ;
    }

}