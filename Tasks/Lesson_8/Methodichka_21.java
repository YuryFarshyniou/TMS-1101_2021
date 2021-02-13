package Tasks.Lesson_8;

/* Напишите три цикла выполняющих многократное сложение строк, один с
помощью оператора сложения и String, другой с помощью StringBuilder и метода
append, а также аналогино для StringBuffer. Сравните скорость их выполнения. */

public class Methodichka_21 {
    public static void main(String[] args) {
        String str = "";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        long timeString = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            str += "Hello world ";
        }

//        System.out.println("Our string: " + str);
        System.out.println("Time String: " + (System.currentTimeMillis() - timeString));

        long timeStringBuilder = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(" Hello tms ");
        }

//        System.out.println("Our stringBuilder: " + stringBuilder);
        System.out.println("Time StringBuilder: " + (System.currentTimeMillis() - timeStringBuilder));

        long timeStringBuffer = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            stringBuffer.append(" Hello Mogilev ");
        }
//        System.out.println("Our stringBuffer: " + stringBuffer);
        System.out.println("Time StringBuffer: " + (System.currentTimeMillis() - timeStringBuffer));
    }
}
