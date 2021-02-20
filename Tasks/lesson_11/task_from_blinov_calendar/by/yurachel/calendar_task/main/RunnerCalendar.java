package Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.main;

import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity.Calendar;
import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.logic.Add;
import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.logic.Sort;
import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.view.Show;

public class RunnerCalendar {
    public static void main(String[] args) throws Exception {
        Calendar c = new Calendar(2020, 365);
        Sort sort = new Sort();
        Add add = new Add();
        Show show = new Show();

        // Дни недели.

//        c.setWeekends(c.new Weekend("Sunday"));
//        add.addWeekends(c);
//        Show.showWeekends(c, c.getWeekends().getWeekend());

        // Праздники.

        add.addHoliday(c, "New Year", 1);
        add.addHoliday(c, "March 8", 50);
        add.addHoliday(c, "Yurachel's birthday", 120);
        add.addHoliday(c, "February 23", 42);
        add.addHoliday(c, "Easter", 130);
        add.addHoliday(c, "September 1", 264);

        show.showHoliday(c.getHolidayList());
        sort.sortHolidays(c.getHolidayList(), "Ascending");
        System.out.println("************************************************");
        show.showHoliday(c.getHolidayList());

    }
}
