package tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    private List<Weekend> weekendList;

    {
        weekendList = new ArrayList<>();
    }

    public List<Weekend> getWeekendList() {
        return weekendList;
    }

    public void setWeekendList(List<Weekend> weekendList) {
        this.weekendList = weekendList;
    }

    // Внутренний класс для выходных.

    private class Weekend {
        private String month;
        private int date;
        private String dayOfTheWeek;
        boolean isHoliday;
        private String description;

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public String getDayOfTheWeek() {
            return dayOfTheWeek;
        }

        public void setDayOfTheWeek(String dayOfTheWeek) {
            this.dayOfTheWeek = dayOfTheWeek;
        }

        public boolean isHoliday() {
            return isHoliday;
        }

        public void setHoliday(boolean holiday) {
            isHoliday = holiday;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Weekend(String month, int date, String dayOfTheWeek, boolean isHoliday, String description) {
            this.month = month;
            this.date = date;
            this.dayOfTheWeek = dayOfTheWeek;
            this.isHoliday = isHoliday;
            this.description = description;
        }

        public String toString() {
            return "Weekend's information: " + "month: " + month + ", date: " + date +
                    ", dayOfTheWeek: " + dayOfTheWeek + ", is holiday: " + isHoliday + ", description: " + description;
        }
    }

    // Добавляем выходные в список.

    public void addWeekend(String month, int date, String dayOfTheWeek, boolean isHoliday, String description) {
        weekendList.add(new Weekend(month, date, dayOfTheWeek, isHoliday, description));
    }

    // Выводим выходные на консоль.

    public void showWeekend() {
        for (Weekend weekend : weekendList) {
            System.out.println(weekend);
        }
    }

    // Сортируем праздники до дате.

    public void sortHolidays(String order) throws Exception {
        if (order.equalsIgnoreCase("Ascending")) {
            weekendList.sort((weekend1, weekend2) -> weekend1.getMonth().compareTo(weekend2.getMonth()));
        } else if (order.equalsIgnoreCase("Descending")) {
            weekendList.sort((weekend1, weekend2) -> weekend2.getMonth().compareTo(weekend1.getMonth()));
        } else {
            throw new Exception("This order doesn't exists");
        }
    }

    // Выводим праздники или выходные.

    public void showHolidaysOrWeekend(String holidayOrWeekend) {
        for (Weekend weekend : weekendList) {
            if (holidayOrWeekend.equalsIgnoreCase("Holiday")) {
                if (weekend.isHoliday) {
                    System.out.println(weekend);
                }
            } else if (holidayOrWeekend.equalsIgnoreCase("Weekend")) {
                if (!weekend.isHoliday) {
                    System.out.println(weekend);
                }
            }
        }
    }


}