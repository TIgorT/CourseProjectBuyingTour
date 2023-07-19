package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PaymentCreditGatePage {
    private final SelenideElement tourJourneyOfTheDay = $x("//h2[@class='heading heading_size_l heading_theme_alfa-on-white']");
    private final SelenideElement nameOfThePaymentType = $x("//h3[@class='heading heading_size_m heading_theme_alfa-on-white']");

    private final SelenideElement cardNumber = $("[placeholder='0000 0000 0000 0000']");

    private final SelenideElement cardMonth = $("[placeholder='08']");

    private final SelenideElement cardYear = $("[placeholder='22']");

    private final SelenideElement cardOwner = $(byText("Владелец")).parent().$("[class='input__control']");

    private final SelenideElement cardCVCCVV = $("[placeholder='999']");

    private final SelenideElement buttonContinue = $x("//*[contains(@class,'spin')]/../..");

    private final SelenideElement operationIsSuccessful = $x("//*[contains(@class,'notification__title')][contains(text(),'Успешно')]");

    private final SelenideElement operationIsApprovedByTheBank = $x("//*[contains(@class,'notification__content')][contains(text(),'Операция одобрена Банком.')]");



    public void paymentCreditGatePageVisibility() {
        tourJourneyOfTheDay.shouldHave(exactText("Путешествие дня")).shouldBe(visible);
        nameOfThePaymentType.shouldHave(exactText("Кредит по данным карты")).shouldBe(visible);

    }

    public void introductionOfCardData(DataHelper.CardInfo info) {
        cardNumber.setValue(info.getCardNumber());
        cardMonth.setValue(info.getMonth());
        cardYear.setValue(info.getYear());
        cardOwner.setValue(info.getOwner());
        cardCVCCVV.setValue(info.getCardCVCCVV());
    }

    public void clickOnTheContinueButton() {
        buttonContinue.click();
        operationIsSuccessful.shouldBe(visible, Duration.ofMillis(15000));
        operationIsApprovedByTheBank.shouldBe(visible);
    }
}


