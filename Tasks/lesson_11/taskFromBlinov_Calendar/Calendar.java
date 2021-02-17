package Tasks.lesson_11.taskFromBlinov_Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    private Weekend weekends;
    private Holiday holiday;
    private int year;
    private int amountOfDayInThisYear;
    private final String firstDayOfTheYear;
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmountOfDayInThisYear() {
        return amountOfDayInThisYear;
    }

    public void setAmountOfDayInThisYear(int amountOfDayInThisYear) {
        this.amountOfDayInThisYear = amountOfDayInThisYear;
    }

    public Weekend getWeekends() {
        return weekends;
    }

    public void setWeekends(Weekend weekends) {
        this.weekends = weekends;
    }

    public Calendar(int year, int amountOfDay, String firstDayOfTheYear) {
        this.year = year;
        this.amountOfDayInThisYear = amountOfDay;
        this.firstDayOfTheYear = firstDayOfTheYear;
    }

    // Внутренний класс для выходных.

    class Weekend {
        List<Integer> weekend = new ArrayList<>();

        // Добавляем дни выходных в список.

        public void weekends() {
            int weekendDays = 1;
            switch (firstDayOfTheYear.toLowerCase()) {
                case "monday":
                    weekendDays += 5;
                    break;
                case "tuesday":
                    weekendDays += 4;
                    break;
                case "wednesday":
                    weekendDays += 3;
                    break;
                case "thursday":
                    weekendDays += 2;
                    break;
                case "friday":
                    weekendDays += 1;
                    break;
            }
            while (weekendDays <= amountOfDayInThisYear) {
                if (firstDayOfTheYear.equalsIgnoreCase("sunday") && weekendDays == 1) {
                    weekend.add(weekendDays);
                    weekendDays += 6;
                } else {
                    weekend.add(weekendDays);
                    weekend.add(weekendDays + 1);
                    weekendDays += 7;
                }
            }
        }

        // Выводим выходные.

        public void showWeekends() {
            int weeks = 1;
            for (int i = 0; i < weekend.size(); ) {
                if (firstDayOfTheYear.equalsIgnoreCase("sunday") && i == 0) {
                    System.out.println(weeks + " week: Sunday - " + weekend.get(i));
                    i++;
                } else {
                    System.out.println(weeks + " week: Saturday - " + weekend.get(i) + ", Sunday - " + weekend.get(i + 1));
                    i += 2;
                }
                weeks++;
            }
        }
    }

    // Класс для праздничных дней.

    class Holiday {
        Map<String, Integer> holiday = new HashMap<>();

        // Добавляем праздники.

        public void addHoliday() throws IOException {
            while (true) {
                System.out.println("Do you want add another holiday?(yes//no)");
                String answer = reader.readLine();
                if (answer.equalsIgnoreCase("yes")) {
                    System.out.println("Add holiday's name: ");
                    String holidayName = reader.readLine();
                    System.out.println("Add day of the year corresponding to the holiday: ");
                    int dayOfTheYear = Integer.parseInt(reader.readLine());
                    if (dayOfTheYear > amountOfDayInThisYear || dayOfTheYear < 1) {
                        System.out.println("You enter wrong day.This year has only " + amountOfDayInThisYear + " days.");
                        dayOfTheYear = -1;
                    }
                    holiday.put(holidayName, dayOfTheYear);
                } else {
                    return;
                }
            }
        }

        // Выводим праздники на консоль.

        public void showHoliday() {
            for (Map.Entry entry : holiday.entrySet()) {
                System.out.println("Holiday: " + entry.getKey() + ", day of the year: " + entry.getValue() + ";");
            }
        }
    }
}