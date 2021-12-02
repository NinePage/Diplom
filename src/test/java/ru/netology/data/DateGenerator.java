package ru.netology.data;

import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    private final LocalDate actualData = LocalDate.now();
    private final DateTimeFormatter formatterYears = DateTimeFormatter.ofPattern("yy");
    private final DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");

    public Year shiftYear(int numberOfYears) {
        LocalDate newDate = actualData.plusYears(numberOfYears);
        return new Year(formatterYears.format(newDate));
    }

    public Month shiftMonth(int numberOfMonths) {
        LocalDate newDate = actualData.plusMonths(numberOfMonths);
        return new Month(formatterMonth.format(newDate));
    }

    @Value
    public static class Year {
        private String year;
    }

    @Value
    public static class Month {
        private String month;
    }
}