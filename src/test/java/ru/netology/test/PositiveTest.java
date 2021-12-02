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


public class PositiveTest {

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
    public void shouldPayByCardWithValidNumber() {
        var tourPage = new TourPage();
        var payByCard = new CardPage();
        var approvedCardInformation = DataHelper.getValidCardInfo();
        tourPage.payByCard();
        payByCard.enterPayCardData(approvedCardInformation);
        payByCard.successfulPayCardPayment();

        var paymentId = SqlHelper.getPaymentId();
        var statusForPayment = SqlHelper.getStatusForPayment(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }

    @Test
    public void shouldPayByCreditWithValidNumber() {
        var tourPage = new TourPage();
        var payByCredit = new CreditPage();
        var approvedCardInformation = DataHelper.getValidCardInfo();
        tourPage.payByCreditCard();
        payByCredit.enterCreditCardData(approvedCardInformation);
        payByCredit.successfulCreditCardPayment();

        var paymentId = SqlHelper.getPaymentId();
        var statusForPayment = SqlHelper.getStatusForCredit(paymentId);
        Assertions.assertEquals("APPROVED", statusForPayment);
    }
}