package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;


import static com.codeborne.selenide.Selenide.open;


public class PaymentGateTest {
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
    @DisplayName("Оплата тура 'Путешествие дня' с использованием специального номера APPROVED карты")

    public void paymentForTheTripOfTheDayTourUsingASpecialAPPROVEDCardNumber() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.getValidApprovedCard();
        paymentGatePage.introductionOfCardData(cardInfo);
        paymentGatePage.clickOnTheContinueButton();
        var paymentStatus = SQLHelper.getStatusPayments();
        var tourAmount = SQLHelper.getThePaymentAmount();
        Assertions.assertEquals("APPROVED", paymentStatus);
        Assertions.assertEquals(DataHelper.tourAmount(), tourAmount);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием специального номера DECLINED карты")
    public void paymentForTheTourTravelOfTheDayUsingASpecialDECLINEDCardNumber() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        var cardInfo = DataHelper.getValidDeclinedCard();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.introductionOfCardData(cardInfo);
        paymentGatePage.clickOnTheContinueButton();
        var paymentStatus = SQLHelper.getStatusPayments();
        Assertions.assertEquals("DECLINED", paymentStatus);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием шестнадцати рандомных цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourWithTheGenerationOfASixteenDigitRandomCardNumber() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomSixteenNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButtonWithTheErrorInformation();
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием тринадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingThirteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomThirteenNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButtonWithTheErrorInformation();
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием пятнадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingFifteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomFifteenNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButtonWithTheErrorInformation();
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием восемнадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingEighteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.randomEighteenNumericCharacters();
        paymentGatePage.fillInTheCardNumberField(cardInfo);
        paymentGatePage.checkCardNumberFieldValue(cardInfo);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием девятнадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingNineteenNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.randomNineteenNumericCharacters();
        paymentGatePage.fillInTheCardNumberField(cardInfo);
        paymentGatePage.checkCardNumberFieldValue(cardInfo);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием двадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingTwentyNumericCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.randomTwentyNumericCharacters();
        paymentGatePage.fillInTheCardNumberField(cardInfo);
        paymentGatePage.checkCardNumberFieldValue(cardInfo);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одного цифрового символа в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingOneDigitalSymbolInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.generateRandomOneNumericCharacters());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheCardNumberField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'Номер карты'")
    public void paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.generateRandomAlphabeticCharacters();
        paymentGatePage.fillInTheCardNumberField(cardInfo);
        paymentGatePage.checkCardNumberFieldValue("");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спец символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.generateRandomSpecialCharacters();
        paymentGatePage.fillInTheCardNumberField(cardInfo);
        paymentGatePage.checkCardNumberFieldValue("");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием пустого поля 'Номер карты'")
    public void paymentForTheTourTravelOfTheDayUsingAnEmptyCardNumberField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheCardNumberField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одного цифрового символа в поле 'Месяц'")
    public void paymentForTheJourneyOfTheDayTourUsingOneDigitalSymbolInTheMonthField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingASingleNumericCharacter());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheMonthField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием трёх цифровых символов в поле 'Месяц'")
    public void paymentForTheTourTravelOfTheDayUsingThreeNumericCharactersInTheMonthField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        var cardInfo = DataHelper.generateAMonthUsingThreeNumericCharacters();
        paymentGatePage.fillInTheMonthField(cardInfo);
        int quantity = paymentGatePage.checkMonthFieldValue();
        Assertions.assertEquals(DataHelper.monthUsingThreeNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура Путешествие дня с введением в поле Месяц значения 13")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfTheValueThirteenInTheMonthField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingTheValueThirteen());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheMonthField("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'Месяц'")
    public void paymentForTheJourneyOfTheDayTourUsingAlphabeticCharactersInTheMonthField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingAlphabeticCharacters());
        int quantity = paymentGatePage.checkMonthFieldValue();
        Assertions.assertEquals(DataHelper.emptyMonthFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спец символов в поле 'Месяц'")
    public void paymentForTheTourTripOfTheDayUsingSpecialSymbolsInTheMonthField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingSpecialSymbols());
        int quantity = paymentGatePage.checkMonthFieldValue();
        Assertions.assertEquals(DataHelper.emptyMonthFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с пустым полем 'Месяц'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyFieldMonth() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheMonthField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня'с использованием одного цифрового символа в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingOneDigitalSymbolInTheYearField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheYearUsingNumericCharacter());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием трёх цифровых символов в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingThreeNumericCharactersInTheYearField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheYearField(DataHelper.generateTheYearUsingThreeNumericCharacters());
        int quantity = paymentGatePage.checkYearFieldValue();
        Assertions.assertEquals(DataHelper.theYearUsingThreeNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с введением в поле 'Год' прошлогодней даты ")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfLastYearsDateInTheYearField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateLastYears());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Истёк срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с введением в поле 'Год' даты (плюс шесть лет к текущему году)")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfTheDatInTheYearFieldPlusSixYearsToTheCurrentYear() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearPlusSixYears());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheYearField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearUsingAlphabeticCharacters());
        int quantity = paymentGatePage.checkYearFieldValue();
        Assertions.assertEquals(DataHelper.emptyYearFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спец символов в поле 'Год'")
    public void paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheYearField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearUsingSpecialSymbols());
        int quantity = paymentGatePage.checkYearFieldValue();
        Assertions.assertEquals(DataHelper.emptyYearFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с пустым полем 'Год'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyFieldYear() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheYearField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии латиницей через символ '-'")
    public void paymentForTheTourTravelOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameInLatinLettersSeparatedByAHyphen() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidHolderWithDoubleLastName());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.clickOnTheContinueButton();
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одного буквенного символа в поле 'Владелец'")
    public void paymentForTheTourTravelOfTheDayUsingOneLetterCharacterInTheOwnerField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateOneLetterCharacter());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием двадцати двух буквенных символов в поле 'Владелец'")
    public void paymentForTheTourTravelOfTheDayUsingTwentyTwoLetterCharactersInTheOwnerField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateTwentyTwoLetterCharactersIncludingSpaces());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с введением в поле 'Владелец' только имени на латинице")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfOnlyTheNameInLatinInTheOwnerField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateOnlyNamesInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии кириллицей")
    public void paymentForTheTourTravelOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameInCyrillic() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInCyrillic());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии, используя спецсимволы")
    public void paymentForTheTripOfTheDayTourWithWritingInTheOwnerOfTheFirstAndLastNameFieldUsingSpecialCharacters() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInLatinUsingTheSameSpecialCharacters());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии, используя цифровые символы")
    public void paymentForTheTripOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameFieldUsingNumericCharacters() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInLatinUsingTheSameNumbersCharacters());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с пустым полем 'Владелец'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyOwnerField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentGatePage.errorFormatInTheOwnerField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием одно цифрового символа в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingASingleDigitSymbolInTheCVCCVVField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingNumericCharacter());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием четырёх цифровых символов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingFourNumericCharactersInTheCVCCVVField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingFourNumericCharacters());
        int quantity = paymentGatePage.checkCVCCVVFieldValue();
        Assertions.assertEquals(DataHelper.theCVCCVVUsingFourNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием буквенных символов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingAlphabeticCharactersInTheCVCCVVField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingAlphabeticCharacters());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием спецсимволов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingSpecialCharactersInTheCVCCVVField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingSpecialCharacters());
        paymentGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура 'Путешествие дня' с использованием пустого поля 'CVC/CVV'")
    public void paymentForTheTourTravelOfTheDayUsingAnEmptyCVCCVVField() {
        var mainPage = new MainPage();
        var paymentGatePage = mainPage.clickButtonPay();
        paymentGatePage.paymentGatePageVisibility();
        paymentGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentGatePage.errorFormatInTheCVCCVVField("Поле обязательно для заполнения");
    }
}
