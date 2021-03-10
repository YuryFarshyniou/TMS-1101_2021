package tasks.lesson_13.by.yurachel.methodichka_29_31.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class SchoolDiary {

    private List<Appraisal> appraisals;

    public List<Appraisal> getAppraisals() {
        return appraisals;
    }

    public void setAppraisals(List<Appraisal> appraisals) {
        this.appraisals = appraisals;
    }

    {
        appraisals = new ArrayList<>();
    }

    public void addAppraisal(Appraisal... appraisals2) {
        appraisals.addAll(Arrays.asList(appraisals2));
    }

    public void showSchoolDiary() {
        for (Appraisal appraisal : appraisals) {
            System.out.println(appraisal);
        }
    }

    public void removeBadAppraisals() {

        Predicate<Appraisal> pred = new Predicate<Appraisal>() {
            public boolean test(Appraisal appraisal) {
                return appraisal.getAppraisal() < 4;
            }
        };
        appraisals.removeIf(pred);

//        appraisals.removeIf(appraisal -> appraisal.getAppraisal() < 4);
    }


    public Appraisal maxAppraisal() {
        Iterator<Appraisal> iterator = appraisals.iterator();
        Appraisal maxAppraisal = appraisals.get(0);
        while (iterator.hasNext()) {
            Appraisal appraisal = iterator.next();
            if (appraisal.getAppraisal() > maxAppraisal.getAppraisal()) {
                maxAppraisal = appraisal;
            }
        }
        return maxAppraisal;
    }
}
