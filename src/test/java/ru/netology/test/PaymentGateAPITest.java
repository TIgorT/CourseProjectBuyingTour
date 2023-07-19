package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.data.APIHelper;
import ru.netology.data.SQLHelper;


import static io.restassured.RestAssured.given;

public class PaymentGateAPITest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SQLHelper.cleanDatabase();
    }
    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();


    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с валидно заполненным body и данными APPROVED карты ")
    public void postRequestToPurchaseATourTravelOfTheDayWithAValidFilledBodyAndAPPROVEDCardData(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.getValidApprovedCard())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с валидно заполненным body и данными DECLINED карты ")
    public void postRequestToPurchaseATourTravelOfTheDayWithAValidFilledBodyAndDECLINEDCardData(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.getValidDeclinedCard())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым body ")
    // в постмане  почему то 500
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyBody(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body("")
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута cardNumber в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheNumberAttributeInTheBodyTheRestOfTheDataIsFilledInValid(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.bodyWithAnEmptyCardNumberField())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута month в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheMonthAttributeInTheBodyTheRestOfTheDataIsFilledInValid(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.bodyWithAnEmptyMonthField())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута year в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheYearAttributeInTheBodyTheRestOfTheDataIsFilledInValid(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.bodyWithAnEmptyYearField())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута holder в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfTourTravelOfTheDayWithAnEmptyValueOfTheHolderAttributeInBodyTheRestOfTheDataIsFilledInValid(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.bodyWithAnEmptyHolderField())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута cvc в body, остальные данные заполнены валидно")
    public void postARequestToPurchaseATourTravelOfTheDayWithAnEmptyValueOfTheCvcAttributeInTheBodyTheRestOfTheDataIsFilledInValid(){
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(APIHelper.bodyWithAnEmptyCvcField())
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(400);
    }

}
