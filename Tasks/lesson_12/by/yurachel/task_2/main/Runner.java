package Tasks.lesson_12.by.yurachel.task_2.main;


import Tasks.lesson_12.by.yurachel.task_2.annotation.Version;
import Tasks.lesson_12.by.yurachel.task_2.service.MyService;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Runner {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Class<MyService> service = MyService.class;
        inspectService(service);

    }

    public static void inspectService(Class<?> service) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (service.isAnnotationPresent(Version.class)) {
            MyService sy = (MyService) service.getDeclaredConstructor(String.class,String.class, int.class).newInstance("Hello","World",25);
            Method[] m = service.getDeclaredMethods();
            for (Method meth : m) {
                if (meth.getModifiers() == Modifier.PRIVATE) {
                    meth.setAccessible(true);
                    meth.invoke(sy);
                }
            }
        } else {
            System.out.println("This class isn't annotated by our annotation.");
        }

    }
}
