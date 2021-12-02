package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
    static Faker enOption = new Faker(new Locale("en"));
    static DateGenerator dateGenerator = new DateGenerator();
    static CardGenerator cardNumberGenerator = new CardGenerator();

    public static CardInformation getValidCardInfo() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                enOption.harryPotter().character(),
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getInvalidCardInfo() {
        return new CardInformation(
                cardNumberGenerator.getDeclinedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Ivan Ivanov",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getEmptyCardInfo() {
        return new CardInformation(
                " ",
                " ",
                " ",
                " ",
                " ");
    }

    public static CardInformation getCardInfoWithCyrillicName() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Иван Иванов",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInfoWithZeroMonthAndYear() {
        return new CardInformation(cardNumberGenerator.getApprovedCardNumber(),
                "00",
                "00",
                "Ivan Ivanov",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInfoWithZeroCVV() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(5).getYear(),
                dateGenerator.shiftMonth(2).getMonth(),
                "Ivan Ivanov",
                "000");
    }

    public static CardInformation getCardInfoWithExpiredYear() {
        return new CardInformation(
                cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(-5).getYear(),
                dateGenerator.shiftMonth(0).getMonth(),
                "Ivan Ivanov",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    public static CardInformation getCardInfoWithExpiredMonth() {
        return new CardInformation(cardNumberGenerator.getApprovedCardNumber(),
                dateGenerator.shiftYear(0).getYear(),
                dateGenerator.shiftMonth(-2).getMonth(),
                "Ivan Ivanov",
                Integer.toString(enOption.number().numberBetween(100, 999)));
    }

    @Value
    public static class CardInformation {
        private String cardNumber;
        private String year;
        private String month;
        private String holder;
        private String CVV;
    }
}