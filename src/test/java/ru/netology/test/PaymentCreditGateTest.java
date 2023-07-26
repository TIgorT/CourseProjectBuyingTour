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

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием шестнадцати рандомных цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourWithTheGenerationOfASixteenDigitRandomCardNumberOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.generateRandomSixteenNumericCharacters());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.clickOnTheContinueButtonWithTheErrorInformation();
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием тринадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingThirteenNumericCharactersInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.generateRandomThirteenNumericCharacters());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.clickOnTheContinueButtonWithTheErrorInformation();
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием пятнадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingFifteenNumericCharactersInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.generateRandomFifteenNumericCharacters());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.clickOnTheContinueButtonWithTheErrorInformation();
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием восемнадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingEighteenNumericCharactersInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.randomEighteenNumericCharacters();
        paymentCreditGatePage.fillInTheCardNumberField(cardInfo);
        paymentCreditGatePage.checkCardNumberFieldValue(cardInfo);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием девятнадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingNineteenNumericCharactersInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.randomNineteenNumericCharacters();
        paymentCreditGatePage.fillInTheCardNumberField(cardInfo);
        paymentCreditGatePage.checkCardNumberFieldValue(cardInfo);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием двадцати цифровых символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingTwentyNumericCharactersInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.randomTwentyNumericCharacters();
        paymentCreditGatePage.fillInTheCardNumberField(cardInfo);
        paymentCreditGatePage.checkCardNumberFieldValue(cardInfo);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием одного цифрового символа в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingOneDigitalSymbolInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.generateRandomOneNumericCharacters());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheCardNumberField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием буквенных символов в поле 'Номер карты'")
    public void paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.generateRandomAlphabeticCharacters();
        paymentCreditGatePage.fillInTheCardNumberField(cardInfo);
        paymentCreditGatePage.checkCardNumberFieldValue("");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием спец символов в поле 'Номер карты'")
    public void paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.generateRandomSpecialCharacters();
        paymentCreditGatePage.fillInTheCardNumberField(cardInfo);
        paymentCreditGatePage.checkCardNumberFieldValue("");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием пустого поля 'Номер карты'")
    public void paymentForTheTourTravelOfTheDayUsingAnEmptyCardNumberFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheCardNumberField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием одного цифрового символа в поле 'Месяц'")
    public void paymentForTheJourneyOfTheDayTourUsingOneDigitalSymbolInTheMonthFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingASingleNumericCharacter());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheMonthField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием трёх цифровых символов в поле 'Месяц'")
    public void paymentForTheTourTravelOfTheDayUsingThreeNumericCharactersInTheMonthFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        var cardInfo = DataHelper.generateAMonthUsingThreeNumericCharacters();
        paymentCreditGatePage.fillInTheMonthField(cardInfo);
        int quantity = paymentCreditGatePage.checkMonthFieldValue();
        Assertions.assertEquals(DataHelper.monthUsingThreeNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит Путешествие дня с введением в поле Месяц значения 13")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfTheValueThirteenInTheMonthFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingTheValueThirteen());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheMonthField("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием буквенных символов в поле 'Месяц'")
    public void paymentForTheJourneyOfTheDayTourUsingAlphabeticCharactersInTheMonthFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingAlphabeticCharacters());
        int quantity = paymentCreditGatePage.checkMonthFieldValue();
        Assertions.assertEquals(DataHelper.emptyMonthFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием спец символов в поле 'Месяц'")
    public void paymentForTheTourTripOfTheDayUsingSpecialSymbolsInTheMonthFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateAMonthUsingSpecialSymbols());
        int quantity = paymentCreditGatePage.checkMonthFieldValue();
        Assertions.assertEquals(DataHelper.emptyMonthFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с пустым полем 'Месяц'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyFieldMonthOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheMonthField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня'с использованием одного цифрового символа в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingOneDigitalSymbolInTheYearFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheYearUsingNumericCharacter());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheYearField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием трёх цифровых символов в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingThreeNumericCharactersInTheYearFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheYearUsingThreeNumericCharacters());
        int quantity = paymentCreditGatePage.checkYearFieldValue();
        Assertions.assertEquals(DataHelper.theYearUsingThreeNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с введением в поле 'Год' прошлогодней даты ")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfLastYearsDateInTheYearFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateLastYears());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheYearField("Истёк срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с введением в поле 'Год' даты (плюс шесть лет к текущему году)")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfTheDatInTheYearFieldPlusSixYearsToTheCurrentYearOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearPlusSixYears());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheYearField("Неверно указан срок действия карты");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием буквенных символов в поле 'Год'")
    public void paymentForTheTourTravelOfTheDayUsingAlphabeticCharactersInTheYearFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearUsingAlphabeticCharacters());
        int quantity = paymentCreditGatePage.checkYearFieldValue();
        Assertions.assertEquals(DataHelper.emptyYearFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием спец символов в поле 'Год'")
    public void paymentForTheTripOfTheDayTourUsingSpecialSymbolsInTheYearFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYearUsingSpecialSymbols());
        int quantity = paymentCreditGatePage.checkYearFieldValue();
        Assertions.assertEquals(DataHelper.emptyYearFieldForTheAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с пустым полем 'Год'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyFieldYearOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheYearField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии латиницей через символ '-'")
    public void paymentForTheTourTravelOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameInLatinLettersSeparatedByAHyphenOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidHolderWithDoubleLastName());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.clickOnTheContinueButton();
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием одного буквенного символа в поле 'Владелец'")
    public void paymentForTheTourTravelOfTheDayUsingOneLetterCharacterInTheOwnerFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateOneLetterCharacter());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием двадцати двух буквенных символов в поле 'Владелец'")
    public void paymentForTheTourTravelOfTheDayUsingTwentyTwoLetterCharactersInTheOwnerFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateTwentyTwoLetterCharactersIncludingSpaces());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с введением в поле 'Владелец' только имени на латинице")
    public void paymentForTheTourTravelOfTheDayWithTheIntroductionOfOnlyTheNameInLatinInTheOwnerFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateOnlyNamesInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии кириллицей")
    public void paymentForTheTourTravelOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameInCyrillicOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInCyrillic());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит  'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии, используя спецсимволы")
    public void paymentForTheTripOfTheDayTourWithWritingInTheOwnerOfTheFirstAndLastNameFieldUsingSpecialCharactersOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInLatinUsingTheSameSpecialCharacters());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с написанием в поле 'Владелец' имени и фамилии, используя цифровые символы")
    public void paymentForTheTripOfTheDayWithWritingInTheOwnerOfTheFirstAndLastNameFieldUsingNumericCharactersOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateDataFirstNameLastNameInLatinUsingTheSameNumbersCharacters());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с пустым полем 'Владелец'")
    public void paymentForTheTourTravelOfTheDayWithAnEmptyOwnerFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters());
        paymentCreditGatePage.errorFormatInTheOwnerField("Поле обязательно для заполнения");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием одно цифрового символа в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingASingleDigitSymbolInTheCVCCVVFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingNumericCharacter());
        paymentCreditGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием четырёх цифровых символов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingFourNumericCharactersInTheCVCCVVFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingFourNumericCharacters());
        int quantity = paymentCreditGatePage.checkCVCCVVFieldValue();
        Assertions.assertEquals(DataHelper.theCVCCVVUsingFourNumericCharactersForAssert(), quantity);
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием буквенных символов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingAlphabeticCharactersInTheCVCCVVFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingAlphabeticCharacters());
        paymentCreditGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием спецсимволов в поле 'CVC/CVV'")
    public void paymentForTheTripOfTheDayTourUsingSpecialCharactersInTheCVCCVVFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.fillInTheCVCCVVField(DataHelper.generateTheCVCCVVUsingSpecialCharacters());
        paymentCreditGatePage.errorFormatInTheCVCCVVField("Неверный формат");
    }

    @Test
    @DisplayName("Оплата тура в кредит 'Путешествие дня' с использованием пустого поля 'CVC/CVV'")
    public void paymentForTheTourTravelOfTheDayUsingAnEmptyCVCCVVFieldOnCredit() {
        var mainPage = new MainPage();
        var paymentCreditGatePage = mainPage.clickButtonCredit();
        paymentCreditGatePage.paymentCreditGatePageVisibility();
        paymentCreditGatePage.fillInTheCardNumberField(DataHelper.getApprovedCardNumber());
        paymentCreditGatePage.fillInTheMonthField(DataHelper.generateTheCurrentMonth());
        paymentCreditGatePage.fillInTheYearField(DataHelper.generateTheCurrentYear());
        paymentCreditGatePage.fillInTheOwnerField(DataHelper.generateValidDataFirstNameLastNameInLatin());
        paymentCreditGatePage.errorFormatInTheCVCCVVField("Поле обязательно для заполнения");
    }
}
