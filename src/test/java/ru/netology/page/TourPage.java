package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TourPage {

    private final SelenideElement byCardButton = $(byText("Купить"));
    private final SelenideElement byCreditCardButton = $(byText("Купить в кредит"));

    public TourPage payByCard() {
        byCardButton.click();
        return new CardPage();
    }

    public TourPage payByCreditCard() {
        byCreditCardButton.click();
        return new CreditPage();
    }
}