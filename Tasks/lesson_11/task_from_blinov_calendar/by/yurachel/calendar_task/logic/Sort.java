package Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.logic;

import Tasks.lesson_11.task_from_blinov_calendar.by.yurachel.calendar_task.entity.Calendar;

import java.util.List;

public class Sort {

    // Сортируем праздники до дате.

    public void sortHolidays(List<Calendar.Holiday> holidayList, String order) throws Exception {
        if (order.equalsIgnoreCase("Ascending")) {
            holidayList.sort((holiday1, holiday2) -> holiday1.getHolidayDay() - holiday2.getHolidayDay());
        } else if (order.equalsIgnoreCase("Descending")) {
            holidayList.sort((holiday1, holiday2) -> holiday2.getHolidayDay() - holiday1.getHolidayDay());
        } else {
            throw new Exception("This order doesn't exists");
        }
    }
}
