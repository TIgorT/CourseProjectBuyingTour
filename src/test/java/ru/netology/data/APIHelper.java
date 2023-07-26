package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Value;

import static io.restassured.RestAssured.given;

public class APIHelper {

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    @Value
    public static class CardInfo {
        private String cvc;
        private String holder;
        private String month;

        private String number;

        private String year;


    }


    public void postRequestToPurchaseATourTravelOfTheDay(CardInfo cardInfo, int statusCode) {
        given().
                baseUri("http://localhost:8080/")
                .spec(requestSpec)
                .body(cardInfo)
                .when()
                .post("api/v1/pay")
                .then()
                .statusCode(statusCode);
    }

    public static CardInfo getValidApprovedCard() {
        return new CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(), DataHelper.generateValidDataFirstNameLastNameInLatin(), DataHelper.generateTheCurrentMonth(), DataHelper.getApprovedCardNumber(), DataHelper.generateTheCurrentYear());
    }

    public static CardInfo getValidDeclinedCard() {
        return new CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(), DataHelper.generateValidDataFirstNameLastNameInLatin(), DataHelper.generateTheCurrentMonth(), DataHelper.getDeclinedCardNumber(), DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyCardNumberField() {
        return new CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(), DataHelper.generateValidDataFirstNameLastNameInLatin(), DataHelper.generateTheCurrentMonth(), DataHelper.getEmptyCardNumberField(), DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyMonthField() {
        return new CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(), DataHelper.generateValidDataFirstNameLastNameInLatin(), DataHelper.getEmptyMonthField(), DataHelper.getApprovedCardNumber(), DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyYearField() {
        return new CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(), DataHelper.generateValidDataFirstNameLastNameInLatin(), DataHelper.generateTheCurrentMonth(), DataHelper.getApprovedCardNumber(), DataHelper.getEmptyYearField());
    }

    public static CardInfo bodyWithAnEmptyHolderField() {
        return new CardInfo(DataHelper.generateTheCVCCVVUsingThreeNumericCharacters(), DataHelper.getEmptyOwnerField(), DataHelper.generateTheCurrentMonth(), DataHelper.getApprovedCardNumber(), DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyCvcField() {
        return new CardInfo(DataHelper.getEmptyCVCCVVField(), DataHelper.generateValidDataFirstNameLastNameInLatin(), DataHelper.generateTheCurrentMonth(), DataHelper.getApprovedCardNumber(), DataHelper.generateTheCurrentYear());
    }

    public static CardInfo bodyWithAnEmptyBody() {
        return new CardInfo(DataHelper.getEmptyCVCCVVField(), DataHelper.getEmptyOwnerField(), DataHelper.getEmptyMonthField(), DataHelper.getEmptyCardNumberField(), DataHelper.getEmptyYearField());
    }


}
