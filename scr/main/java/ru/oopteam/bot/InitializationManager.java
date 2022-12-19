package ru.oopteam.bot;

import org.reflections.Reflections;
import ru.oopteam.bot.annotations.Initializer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class InitializationManager {
    public static void initialize(String packageToScan) {
        Reflections reflections = new Reflections(packageToScan);
        Set<Class<?>> annotated =
                reflections.getTypesAnnotatedWith(Initializer.class);

        for (Class<?> annotatedClass : annotated) {
            try {
                Method method = annotatedClass.getMethod("initialize");
                method.setAccessible(true);
                method.invoke(null);
            } catch (NoSuchMethodException e) {
                System.out.println("Метод не найден в классе: " + annotatedClass.getName());
            } catch (InvocationTargetException | IllegalAccessException ignored) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}