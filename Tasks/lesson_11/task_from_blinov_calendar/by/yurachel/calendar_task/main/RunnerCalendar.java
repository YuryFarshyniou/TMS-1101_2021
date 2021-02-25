package Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.main;

import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity.Calendar;

public class RunnerCalendar {
    public static void main(String[] args) throws Exception {
        Calendar calendar = new Calendar();
        calendar.addWeekend("May", 20, "Friday", true, "My birthday");
        calendar.addWeekend("February", 21, "Sunday", false, "Weekend");
        calendar.addWeekend("February", 23, "Tuesday", true, "February 23");
        calendar.showWeekend();

        System.out.println("**********************");
        calendar.sortHolidays("Ascending");
        calendar.showWeekend();

        System.out.println("*****************");

        calendar.showHolidaysOrWeekend("Weekend");
    }
}
