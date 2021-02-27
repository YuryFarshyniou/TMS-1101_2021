package Tasks.lesson_12.by.yurachel.methodichka_28.main;

import Tasks.lesson_12.by.yurachel.methodichka_28.entity.Values;

public class Runner {
    public static void main(String[] args) {
        Values<Number> s = new Values<>();
        s.setArray(new Number[5]);
        s.getArray()[0] = 26.1;
        s.getArray()[1] = 6;
        s.getArray()[2] = -56.1;
        s.getArray()[3] = 13L;
        s.getArray()[4] = 53.1F;
        System.out.println(s.getAnyNumber(5));




//        s.addValues(5);
//        s.addValues(56);
//        s.addValues(-56.7);//
//        s.getAnyValue(1);
    }
}
