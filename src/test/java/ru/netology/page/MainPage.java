package ru.netology.page;


import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    public final SelenideElement buttonPay = $x("//*[contains(text(),'Купить')]");

    public  final SelenideElement buttonPayCredit =$x("//*[contains(text(),'Купить в кредит')]");


    public PaymentGatePage clickButtonPay(){
        buttonPay.click();
        return new PaymentGatePage();
    }

    public  PaymentCreditGatePage  clickButtonCredit(){
        buttonPayCredit.click();
        return new PaymentCreditGatePage();
    }


}
