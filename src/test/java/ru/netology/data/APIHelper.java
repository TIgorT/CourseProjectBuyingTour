package ru.netology.data;

import lombok.Value;

public class APIHelper {

    @Value
    public static class CardInfo {
        private String cvc;
        private String holder;
        private String month;

        private String number;

        private String year;


    }

    public static CardInfo getValidApprovedCard() {
        return new  CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(),DataHelper.generateValidDataFirstNameLastNameInLatin(),DataHelper.generateTheCurrentMonth(),DataHelper.getApprovedCardNumber(),DataHelper.generateTheCurrentYear());
    }
    public static CardInfo getValidDeclinedCard() {
        return new  CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(),DataHelper.generateValidDataFirstNameLastNameInLatin(),DataHelper.generateTheCurrentMonth(),DataHelper.getDeclinedCardNumber(),DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyCardNumberField() {
        return new  CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(),DataHelper.generateValidDataFirstNameLastNameInLatin(),DataHelper.generateTheCurrentMonth(),DataHelper.getEmptyCardNumberField(),DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyMonthField() {
        return new  CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(),DataHelper.generateValidDataFirstNameLastNameInLatin(),DataHelper.getEmptyMonthField(),DataHelper.getApprovedCardNumber(),DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyYearField() {
        return new  CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(),DataHelper.generateValidDataFirstNameLastNameInLatin(),DataHelper.generateTheCurrentMonth(),DataHelper.getApprovedCardNumber(),DataHelper.getEmptyYearField());
    }

    public static CardInfo bodyWithAnEmptyHolderField() {
        return new  CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(),DataHelper.getEmptyOwnerField(),DataHelper.generateTheCurrentMonth(),DataHelper.getApprovedCardNumber(),DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyCvcField() {
        return new  CardInfo(DataHelper.getEmptyCVCCVVField(),DataHelper.generateValidDataFirstNameLastNameInLatin(),DataHelper.generateTheCurrentMonth(),DataHelper.getApprovedCardNumber(),DataHelper.generateTheCurrentYear());
    }


}
