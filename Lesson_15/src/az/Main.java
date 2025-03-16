package az;

import az.annotations.Autowired;
import az.domain.Person;
import az.domain.User;
import az.model.Container;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {


    public static void main(String[] args) {
        Container container = new Container();

        processAutowired(container);

        User user = container.getUser();
        Person person = container.getPerson();

        System.out.println("User: " + user);
        System.out.println("Person : " + person);
        System.out.println("=========================");

        user.setAge(15);
        user.setName("John");

        person.setName("Ali");

        System.out.println("User: " + user);
        System.out.println("Person : " + person);
    }

    public static void processAutowired(Object object) {
        processFields(object);
        processMethods(object);
    }

    private static void processMethods(Object object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Autowired.class)) {
                method.setAccessible(true);
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    Class<?> parameterType = parameter.getType();
                    try {
                        method.invoke(object, parameterType.getConstructor().newInstance());
                    } catch (Exception e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
            }
        }
    }

    private static void processFields(Object object) {
        Field[] declaredFields = object.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            Autowired autowired = field.getDeclaredAnnotation(Autowired.class);
            if (autowired != null) {
                field.setAccessible(true);

                Class<?> type = field.getType();

                try {
                    Constructor<?> constructor = type.getConstructor();
                    field.set(object, constructor.newInstance());
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }

        }
    }

}
