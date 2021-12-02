package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.SqlHelper;
import ru.netology.data.DataHelper;
import ru.netology.page.CardPage;
import ru.netology.page.CreditPage;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;

public class NegativeTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    public void openChrome() {
        open("http://localhost:8080/");
    }

    @Test
    public void payByCardWithInvalidNumber() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var declinedCardInformation = DataHelper.getInvalidCardInfo();
        tourPage.payByCard();
        payByCard.enterPayCardData(declinedCardInformation);
        payByCard.notSuccessfulPayCardPayment();
        var paymentId = SqlHelper.getPaymentId();
        var statusForPayment = SqlHelper.getStatusForPayment(paymentId);
        Assertions.assertEquals("DECLINED", statusForPayment);
    }

    @Test
    public void payByCreditWithInvalidNumber() {
        var tourPage = new TourPage();
        var payByCredit = new CreditPage();
        var declinedCardInformation = DataHelper.getInvalidCardInfo();
        tourPage.payByCreditCard();
        payByCredit.enterCreditCardData(declinedCardInformation);
        payByCredit.notSuccessfulCreditCardPayment();
        var paymentId = SqlHelper.getPaymentId();
        var statusForPayment = SqlHelper.getStatusForCredit(paymentId);
        Assertions.assertEquals("DECLINED", statusForPayment);
    }

    @Test
    public void payByCardWithEmptyFields() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var invalidCardInformation = DataHelper.getEmptyCardInfo();
        tourPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @Test
    public void payByCreditWithEmptyFields() {
        var tourPage = new TourPage();
        var payByCredit = new CreditPage();
        var emptyCardInformation = DataHelper.getEmptyCardInfo();
        tourPage.payByCreditCard();
        payByCredit.enterCreditCardData(emptyCardInformation);
        payByCredit.invalidCreditCardFormat();
    }

    @Test
    public void payByCardWithCyrillicName() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var invalidCardInformation = DataHelper.getCardInfoWithCyrillicName();
        tourPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @Test
    public void payByCreditWithCyrillicName() {
        var tourPage = new TourPage();
        var payByCredit = new CreditPage();
        var invalidCardInformation = DataHelper.getCardInfoWithCyrillicName();
        tourPage.payByCreditCard();
        payByCredit.enterCreditCardData(invalidCardInformation);
        payByCredit.invalidCreditCardFormat();
    }

    @Test
    public void payByCardWithZeroMonthAndYear() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var invalidCardInformation = DataHelper.getCardInfoWithZeroMonthAndYear();
        tourPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.expiredPayCardYear();
    }

    @Test
    public void payByCreditWithZeroMonthAndYear() {
        var tourPage = new TourPage();
        var payByCreditCard = new CreditPage();
        var invalidCardInformation = DataHelper.getCardInfoWithZeroMonthAndYear();
        tourPage.payByCreditCard();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.expiredCreditCardYear();
    }

    @Test
    public void payByCardWithZeroCVV() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var invalidCardInformation = DataHelper.getCardInfoWithZeroCVV();
        tourPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.invalidPayCardFormat();
    }

    @Test
    public void payByCreditWithZeroCVV() {
        var tourPage = new TourPage();
        var payByCreditCard = new CreditPage();
        var invalidCardInformation = DataHelper.getCardInfoWithZeroCVV();
        tourPage.payByCreditCard();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.invalidCreditCardFormat();
    }

    @Test
    public void payByCardWithExpiredYear() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var invalidCardInformation = DataHelper.getCardInfoWithExpiredYear();
        tourPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.expiredPayCardYear();
    }

    @Test
    public void payByCreditWithExpiredYear() {
        var tourPage = new TourPage();
        var payByCreditCard = new CreditPage();
        var invalidCardInformation = DataHelper.getCardInfoWithExpiredYear();
        tourPage.payByCreditCard();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.expiredCreditCardYear();
    }

    @Test
    public void payByCardWithExpiredMonth() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var invalidCardInformation = DataHelper.getCardInfoWithExpiredMonth();
        tourPage.payByCard();
        payByCard.enterPayCardData(invalidCardInformation);
        payByCard.expiredPayCardMonth();
    }

    @Test
    public void payByCreditWithExpiredMonth() {
        var tourPage = new TourPage();
        var payByCreditCard = new CreditPage();
        var invalidCardInformation = DataHelper.getCardInfoWithExpiredMonth();
        tourPage.payByCreditCard();
        payByCreditCard.enterCreditCardData(invalidCardInformation);
        payByCreditCard.expiredCreditCardMonth();
    }
}