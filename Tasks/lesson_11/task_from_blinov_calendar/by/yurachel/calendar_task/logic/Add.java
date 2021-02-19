package Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.logic;


import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity.Calendar;

public class Add {

    // Добавляем дни выходных в список.

    public void addWeekends(Calendar calendar) {
        int weekendDays = 1;
        switch (calendar.getWeekends().getFirstDayOfTheYear().toLowerCase()) {
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

        while (weekendDays <= calendar.getAmountOfDayInThisYear()) {
            if (calendar.getWeekends().getFirstDayOfTheYear().equalsIgnoreCase("sunday") && weekendDays == 1) {
                calendar.getWeekends().getWeekend().add(weekendDays);
                weekendDays += 6;
            } else {
                calendar.getWeekends().getWeekend().add(weekendDays);
                calendar.getWeekends().getWeekend().add(weekendDays + 1);
                weekendDays += 7;
            }
        }
    }

    // Добавляем праздники.
    public void addHoliday(Calendar calendar, String holidayName, int holidayDay) {
        Calendar.Holiday holiday = calendar.new Holiday(holidayName, holidayDay);
        calendar.getHolidayList().add(holiday);
    }
}
