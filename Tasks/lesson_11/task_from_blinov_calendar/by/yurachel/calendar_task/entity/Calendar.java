package Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private Weekend weekends;
    private Holiday holiday;
    private int year;
    private int amountOfDayInThisYear;
    private List<Calendar.Holiday> holidayList;

    {
        holidayList = new ArrayList<>();
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public List<Holiday> getHolidayList() {
        return holidayList;
    }

    public void setHolidayList(List<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    public int getYear() {
        return year;
    }

    public int getAmountOfDayInThisYear() {
        return amountOfDayInThisYear;
    }

    public Weekend getWeekends() {
        return weekends;
    }

    public void setWeekends(Weekend weekends) {
        this.weekends = weekends;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAmountOfDayInThisYear(int amountOfDayInThisYear) {
        this.amountOfDayInThisYear = amountOfDayInThisYear;
    }

    public Calendar(int year, int amountOfDay) {
        this.year = year;
        this.amountOfDayInThisYear = amountOfDay;
    }

    // Внутренний класс для выходных.

    public class Weekend {
        private final String firstDayOfTheYear;
        private final List<Integer> weekend;

        {
            weekend = new ArrayList<>();
        }

        public String getFirstDayOfTheYear() {
            return firstDayOfTheYear;
        }

        public List<Integer> getWeekend() {
            return weekend;
        }

        public Weekend(String firstDayOfTheYear) {
            this.firstDayOfTheYear = firstDayOfTheYear;
        }
    }


    // Класс для праздничных дней.

    public class Holiday {

        private String holidayName;
        private int holidayDay;

        public String getHolidayName() {
            return holidayName;
        }

        public void setHolidayName(String holidayName) {
            this.holidayName = holidayName;
        }

        public int getHolidayDay() {
            return holidayDay;
        }

        public void setHolidayDay(int holidayDay) {
            this.holidayDay = holidayDay;
        }

        public Holiday(String holidayName, int holidayDay) {
            this.holidayName = holidayName;
            this.holidayDay = holidayDay;
        }

        @Override
        public String toString() {
            return "Holiday: " + holidayName + ", day of the year: " + holidayDay;
        }
    }
}