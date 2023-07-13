package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PaymentGatePage {

    private final SelenideElement nameOfThePaymentType = $x("//h3[@class='heading heading_size_m heading_theme_alfa-on-white']");
    private final SelenideElement tourJourneyOfTheDay = $x("//h2[@class='heading heading_size_l heading_theme_alfa-on-white']");
    private final SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");

    private final SelenideElement cardMonth = $("[placeholder='08']");

    private final SelenideElement cardYear = $("[placeholder='22']");

    private final SelenideElement cardOwner = $(byText("Владелец")).parent().$("[class='input__control']");

    private final SelenideElement cardCVCCVV = $("[placeholder='999']");

    private final SelenideElement buttonContinue = $x("//*[contains(@class,'spin')]/../..");

    private final SelenideElement operationIsSuccessful = $x("//*[contains(@class,'notification__title')][contains(text(),'Успешно')]");

    private final SelenideElement operationIsApprovedByTheBank = $x("//*[contains(@class,'notification__content')][contains(text(),'Операция одобрена Банком.')]");

    private final SelenideElement operationWentWrong = $x("//*[contains(@class,'notification__title')][contains(text(),'Ошибка')]");
    private final SelenideElement operationWentWrongInTheBank = $x("//*[contains(@class,'notification__content')][contains(text(),'Ошибка! Банк отказал в проведении операции.')]");
    private final SelenideElement errorInTheCardNumberField = $(byText("Номер карты")).parent().$("[class='input__sub']");
    private final SelenideElement errorInTheMonthField = $(byText("Месяц")).parent().$("[class='input__sub']");
    private final SelenideElement errorInTheYearField = $(byText("Год")).parent().$("[class='input__sub']");
    private final SelenideElement errorInTheOwnerField = $(byText("Владелец")).parent().$("[class='input__sub']");
    private final SelenideElement errorInTheCVCCVVField = $(byText("CVC/CVV")).parent().$("[class='input__sub']");


    public void paymentGatePageVisibility() {
        tourJourneyOfTheDay.shouldHave(exactText("Путешествие дня")).shouldBe(visible);
        nameOfThePaymentType.shouldHave(exactText("Оплата по карте")).shouldBe(visible);

    }

    public void fillInTheCardNumberField(String number) {
        cardNumber.setValue(number);
    }

    public void fillInTheMonthField(String month) {
        cardMonth.setValue(month);
    }

    public void fillInTheYearField(String year) {
        cardYear.setValue(year);
    }

    public void fillInTheOwnerField(String owner) {
        cardOwner.setValue(owner);
    }

    public void fillInTheCVCCVVField(String cvccvv) {
        cardCVCCVV.setValue(cvccvv);
    }

    public void clickOnTheContinueButton(String expectedTextFirst, String expectedTextSecond) {
        buttonContinue.click();
        operationIsSuccessful.shouldHave(exactText(expectedTextFirst),Duration.ofMillis(14000)).shouldBe(visible, Duration.ofMillis(15000));
        operationIsApprovedByTheBank.shouldHave(exactText(expectedTextSecond),Duration.ofMillis(14000)).shouldBe(visible, Duration.ofMillis(15000));
    }

    public void clickOnTheContinueButtonWithTheErrorInformation(String expectedTextFirst, String expectedTextSecond) {
        buttonContinue.click();
        operationWentWrong.shouldHave(exactText(expectedTextFirst),Duration.ofMillis(14000)).shouldBe(visible, Duration.ofMillis(18000));
        operationWentWrongInTheBank.shouldHave(exactText(expectedTextSecond),Duration.ofMillis(14000)).shouldBe(visible, Duration.ofMillis(20000));
    }

    public String theNumberOfDigitsInTheCardNumberField() {
        return cardNumber.getAttribute("value");
    }

    public String theNumberOfDigitsInTheMonthField() {
        return cardMonth.getAttribute("value");
    }

    public String theNumberOfDigitsInTheYearField() {
        return cardYear.getAttribute("value");
    }

    public String theNumberOfDigitsInTheCVCCVVField() {
        return cardCVCCVV.getAttribute("value");
    }


    public void introductionOfValidDataApprovedCar(DataHelper.CardInfo info, String expectedTextFirst, String expectedTextSecond) {
        cardNumber.setValue(info.getCardNumber());
        cardMonth.setValue(info.getMonth());
        cardYear.setValue(info.getYear());
        cardOwner.setValue(info.getOwner());
        cardCVCCVV.setValue(info.getCardCVCCVV());
        buttonContinue.click();
        operationIsSuccessful.shouldHave(exactText(expectedTextFirst)).shouldBe(visible, Duration.ofMillis(40_000));
        operationIsApprovedByTheBank.shouldHave(exactText(expectedTextSecond)).shouldBe(visible, Duration.ofMillis(40_000));
    }

    public void introductionOfValidDataDeclinedCar(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        cardMonth.setValue(info.getMonth());
        cardYear.setValue(info.getYear());
        cardOwner.setValue(info.getOwner());
        cardCVCCVV.setValue(info.getCardCVCCVV());
        buttonContinue.click();
        operationIsSuccessful.shouldBe(visible, Duration.ofMillis(12_000));
        operationIsApprovedByTheBank.shouldBe(visible, Duration.ofMillis(12_000));
    }

    public void errorFormatInTheCardNumberField(String expectedText) {
        buttonContinue.click();
        errorInTheCardNumberField.shouldHave(exactText(expectedText)).shouldBe(visible, Duration.ofMillis(5000));
    }

    public void errorFormatInTheMonthField(String expectedText) {
        buttonContinue.click();
        errorInTheMonthField.shouldHave(exactText(expectedText)).shouldBe(visible, Duration.ofMillis(5000));

    }

    public void errorFormatInTheYearField(String expectedText) {
        buttonContinue.click();
        errorInTheYearField.shouldHave(exactText(expectedText)).shouldBe(visible, Duration.ofMillis(5000));
    }

    public void errorFormatInTheOwnerField(String expectedText) {
        buttonContinue.click();
        errorInTheOwnerField.shouldHave(exactText(expectedText)).shouldBe(visible, Duration.ofMillis(5000));
    }

    public void errorFormatInTheCVCCVVField(String expectedText) {
        buttonContinue.click();
        errorInTheCVCCVVField.shouldHave(exactText(expectedText)).shouldBe(visible, Duration.ofMillis(5000));
    }


}
