package ru.netology.test;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.APIHelper;
import ru.netology.data.SQLHelper;

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

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с валидно заполненным body и данными APPROVED карты ")
    public void postRequestToPurchaseATourTravelOfTheDayWithAValidFilledBodyAndAPPROVEDCardData() {
        APIHelper apiHelper = new APIHelper();
        SQLHelper.cleanDatabase();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.getValidApprovedCard(), 200);
        var paymentStatus = SQLHelper.getStatusPayments();
        var visibilityInTheDatabase = SQLHelper.getQuantityInTheDatabase();
        Assertions.assertEquals(1, visibilityInTheDatabase.size());
        Assertions.assertEquals("APPROVED", paymentStatus);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с валидно заполненным body и данными DECLINED карты ")
    public void postRequestToPurchaseATourTravelOfTheDayWithAValidFilledBodyAndDECLINEDCardData() {
        APIHelper apiHelper = new APIHelper();
        SQLHelper.cleanDatabase();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.getValidDeclinedCard(), 200);
        var paymentStatus = SQLHelper.getStatusPayments();
        var visibilityInTheDatabase = SQLHelper.getQuantityInTheDatabase();
        Assertions.assertEquals(1, visibilityInTheDatabase.size());
        Assertions.assertEquals("DECLINED", paymentStatus);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым body ")
    // БАГ
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyBody() {
        APIHelper apiHelper = new APIHelper();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.bodyWithAnEmptyBody(), 400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута cardNumber в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheNumberAttributeInTheBodyTheRestOfTheDataIsFilledInValid() {
        APIHelper apiHelper = new APIHelper();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.bodyWithAnEmptyCardNumberField(), 400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута month в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheMonthAttributeInTheBodyTheRestOfTheDataIsFilledInValid() {
        APIHelper apiHelper = new APIHelper();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.bodyWithAnEmptyMonthField(), 400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута year в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfATourTravelOfTheDayWithAnEmptyValueOfTheYearAttributeInTheBodyTheRestOfTheDataIsFilledInValid() {
        APIHelper apiHelper = new APIHelper();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.bodyWithAnEmptyYearField(), 400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута holder в body, остальные данные заполнены валидно")
    public void postRequestPurchaseOfTourTravelOfTheDayWithAnEmptyValueOfTheHolderAttributeInBodyTheRestOfTheDataIsFilledInValid() {
        APIHelper apiHelper = new APIHelper();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.bodyWithAnEmptyHolderField(), 400);
    }

    @Test
    @DisplayName("POST запрос покупка тура 'Путешествие дня' с пустым значением атрибута cvc в body, остальные данные заполнены валидно")
    public void postARequestToPurchaseATourTravelOfTheDayWithAnEmptyValueOfTheCvcAttributeInTheBodyTheRestOfTheDataIsFilledInValid() {
        APIHelper apiHelper = new APIHelper();
        apiHelper.postRequestToPurchaseATourTravelOfTheDay(APIHelper.bodyWithAnEmptyCvcField(), 400);
    }

}
