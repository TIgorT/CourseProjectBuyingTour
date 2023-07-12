package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DataHelper {
    private static Faker faker = new Faker(new Locale("en"));

    private DataHelper() {

    }

    // Значения поля "Номер карты"
    public static String getApprovedCardNumber() {
        return ("1111 2222 3333 4444");
    }

    public static String getDeclinedCardNumber() {

        return ("5555 6666 7777 8888");
    }
    public static String generateRandomSixteenNumericCharacters() {
        return faker.numerify("#### #### #### ####");
    }

    public static String generateRandomThirteenNumericCharacters() {
        return faker.numerify("#### ### ### ###");
    }

    public static String generateRandomFifteenNumericCharacters() {
        return faker.numerify("#### ###### #####");
    }

    public static String randomEighteenNumericCharacters() {
        return ("1234 4897 8541 7359 78");
    }

    public static String randomNineteenNumericCharacters() {
        return ("1234 4897 8541 7359 764");
    }

    public static String randomTwentyNumericCharacters() {

        return ("1234 4897 8541 7359 5371");
    }
    public static String randomTwentyNumericCharactersForAssert() {

        return ("1234 4897 8541 7359 537");
    }

    public static String generateRandomOneNumericCharacters() {
        return faker.numerify("#");
    }

    public static String generateRandomAlphabeticCharacters() {
        return faker.letterify("???? ???? ???? ????");
    }

    public static String generateRandomSpecialCharacters() {
        return ("%?*!");
    }

    // Значения поля "Месяц"

    public static String generateTheCurrentMonth() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateAMonthUsingASingleNumericCharacter() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("M"));
    }

    public static String generateAMonthUsingThreeNumericCharacters() {
        return faker.numerify("###");
    }


    public static String generateTheCurrentMonthUsingThreeNumericCharacters() {
        return faker.numerify("");
    }

    public static String generateAMonthUsingTheValueThirteen() {
        return ("13");
    }

    public static String generateAMonthUsingAlphabeticCharacters() {
        return faker.letterify("??");
    }

    public static String generateAMonthUsingSpecialSymbols() {
        return ("%?");
    }

    //Значения поля "Год"
    public static String generateTheCurrentYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateTheYearUsingNumericCharacter() {
        return faker.numerify("#");
    }

    public static String generateTheYearUsingThreeNumericCharacters() {
        return faker.numerify("###");
    }

    public static String generateLastYears(int year) {
        return LocalDate.now().minusYears(year).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateTheCurrentYearPlusSixYears(int year) {
        return LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("YY"));
    }

    public static String generateTheCurrentYearUsingAlphabeticCharacters() {
        return faker.letterify("??");
    }

    public static String generateTheCurrentYearUsingSpecialSymbols() {
        return ("%?");
    }
    //Значения поля "Владелец"

    public static String generateValidDataFirstNameLastNameInLatin() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateOneLetterCharacter() {
        return faker.letterify("?");
    }

    public static String generateTwentyOneLetterCharactersIncludingSpaces() {
        return faker.letterify("???????????? ???? ???");
    }

    public static String generateValidHolderWithDoubleLastName() {
        return faker.name().firstName() + "-" + faker.name().firstName() + faker.name().lastName();
    }

    public static String generateDataFirstNameLastNameInCyrillic() {
        Faker fakerWithCyrillicLocale = new Faker(new Locale("ru"));
        return fakerWithCyrillicLocale.name().firstName() + fakerWithCyrillicLocale.name().lastName();
    }

    public static String generateDataFirstNameLastNameInLatinUsingTheSameSpecialCharacters() {
        return faker.name().firstName() + "" + faker.name().lastName() + "%?*!";
    }

    public static String generateDataFirstNameLastNameInLatinUsingTheSameNumbersCharacters() {
        return faker.name().firstName() + "" + faker.name().lastName() + "1234";
    }

    // Поле CVC / CVV

    public static String generateTheCVCCVVUsingThreeNumericCharacters() {
        return faker.numerify("###");
    }

    public static String generateTheCVCCVVUsingNumericCharacter() {
        return faker.numerify("#");
    }

    public static String generateTheCVCCVVUsingFourNumericCharacters() {
        return faker.numerify("####");
    }

    public static String generateTheCVCCVVUsingAlphabeticCharacters() {
        return faker.letterify("???");
    }

    public static String generateTheCVCCVVUsingSpecialCharacters() {
        return ("%?");
    }

    @Value
    public static class CardInfo {
        private String cardNumber;
        private String month;
        private String year;
        private String owner;
        private String cardCVCCVV;

    }

    public static CardInfo getValidApprovedCard() {
        return new CardInfo(getApprovedCardNumber(), generateTheCurrentMonth(), generateTheCurrentYear(), generateValidDataFirstNameLastNameInLatin(), generateTheCVCCVVUsingThreeNumericCharacters());
    }

    public static CardInfo getValidDeclinedCard() {
        return new CardInfo(getDeclinedCardNumber(), generateTheCurrentMonth(), generateTheCurrentYear(), generateValidDataFirstNameLastNameInLatin(), generateTheCVCCVVUsingThreeNumericCharacters());
    }

}
