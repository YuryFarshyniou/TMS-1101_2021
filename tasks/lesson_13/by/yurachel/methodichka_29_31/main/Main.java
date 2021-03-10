package tasks.lesson_13.by.yurachel.methodichka_29_31.main;

import tasks.lesson_13.by.yurachel.methodichka_29_31.entity.Appraisal;
import tasks.lesson_13.by.yurachel.methodichka_29_31.entity.SchoolDiary;


public class Main {
    public static void main(String[] args) {

        SchoolDiary schoolDiary = new SchoolDiary();

        schoolDiary.addAppraisal(new Appraisal(5), new Appraisal(10), new Appraisal(2), new Appraisal(7), new Appraisal(6), new Appraisal(3), new Appraisal(4));
        schoolDiary.showSchoolDiary();

        System.out.println("*******************");

        schoolDiary.removeBadAppraisals();

        schoolDiary.showSchoolDiary();

        System.out.println("******************");

        System.out.println(schoolDiary.maxAppraisal());


    }
}
