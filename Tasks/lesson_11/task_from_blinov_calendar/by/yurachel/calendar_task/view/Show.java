package Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.view;

import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity.Calendar;

import java.util.List;

public class Show {

    // Выводим выходные.

    public  void showWeekends(Calendar calendar, List<Integer> daysList) {
        int weeks = 1;
        for (int i = 0; i < calendar.getWeekends().getWeekend().size(); ) {
            if (calendar.getWeekends().getFirstDayOfTheYear().equalsIgnoreCase("sunday") && i == 0) {
                System.out.println(weeks + " week: Sunday - " + daysList.get(i));
                i++;
            } else {
                System.out.println(weeks + " week: Saturday - " + daysList.get(i) + ", Sunday - " + daysList.get(i + 1));
                i += 2;
            }
            weeks++;
        }
    }

    // Выводим праздники на консоль.

    public void showHoliday(List<Calendar.Holiday> holidayList) {
        for (Calendar.Holiday entry : holidayList) {
            System.out.println(entry);
        }
    }
}
