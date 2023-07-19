package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class PaymentCreditGateTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        SQLHelper.cleanDatabase();
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием специального номера APPROVED карты в кредит")

    public void paymentForTheTourTravelOfTheDayUsingASpecialAPPROVEDCardNumberOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.getValidApprovedCard();
        paymentCreditGatePage.introductionOfCardData(cardInfo);
        paymentCreditGatePage.clickOnTheContinueButton();
        var paymentStatus = SQLHelper.getStatusCreditPayments();
        Assertions.assertEquals("APPROVED", paymentStatus);
    }
    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием специального номера DECLINED карты в кредит")

    public void paymentForTheTourTravelOfTheDayUsingASpecialDECLINEDCardNumberOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.getValidDeclinedCard();
        paymentCreditGatePage.introductionOfCardData(cardInfo);
        paymentCreditGatePage.clickOnTheContinueButton();
        var paymentStatus = SQLHelper.getStatusCreditPayments();
        Assertions.assertEquals("DECLINED", paymentStatus);
    }
}
