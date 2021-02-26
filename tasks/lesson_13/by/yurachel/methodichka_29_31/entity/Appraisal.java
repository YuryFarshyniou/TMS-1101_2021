package tasks.lesson_13.by.yurachel.methodichka_29_31.entity;

public class Appraisal {
    private int appraisal;

    public int getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(int appraisal) {
        this.appraisal = appraisal;
    }

    public Appraisal(int appraisal) {
        this.appraisal = appraisal;
    }

    @Override
    public String toString() {
        return "Appraisal: " + appraisal;
    }
}
