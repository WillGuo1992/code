import javafx.beans.binding.ObjectExpression;

import java.lang.reflect.*;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
       // Scanner scanner = new Scanner(System.in);
       // String input = scanner.nextLine();
        String input = "java.util.Scanner";
        Class aClass = Class.forName(input);
        //1.print the title \ extend class and { and /n
        printTitleAndExtend(aClass);
        System.out.print("{\n");
        //3.Contstructors
        printContstrcutors(aClass);
        //4.field\
        printFileds(aClass);
        //5.function and /n }
        printFunctions(aClass);
        System.out.print("}");
    }



    private static void printTitleAndExtend(Class aClass) {
        String modifier = Modifier.toString(aClass.getModifiers());
        System.out.print(modifier+" class "+aClass.getName());
        Class supper = aClass.getSuperclass();
        Class[] interfaces =  aClass.getInterfaces();
        if (supper != null && !supper.getName().equals(Object.class)) {
            System.out.print(" extends " + supper.getName());
        }
        if (interfaces != null) {
            System.out.print(" implements ");
            for (int j = 0; j < interfaces.length; j++) {
                if (j != 0) {
                    System.out.print(",");
                }
                System.out.print(interfaces[j].getName());
            }
        }
        System.out.print("\n");
    }


    private static void printFunctions(Class aClass) {
        System.out.print("\n");
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("  ");
            System.out.print(Modifier.toString(method.getModifiers())+" ");
            System.out.print(method.getReturnType().getName()+" ");
            System.out.print(method.getName()+"(");
            Class[] paras = method.getParameterTypes();
            for (int i = 0; i < paras.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(paras[i].getName());
            }
            System.out.print(");\n");
        }
    }

    private static void printFileds(Class aClass) {
        System.out.print("\n");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.print("  ");
            System.out.print(Modifier.toString(field.getModifiers()));
            System.out.print(" "+field.getType().getName()+" ");

            System.out.print(field.getName());
            System.out.print(";\n");
        }
    }

    private static void printContstrcutors(Class aClass) {
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            String modifer = Modifier.toString(constructor.getModifiers());
            String className = aClass.getName();
            Class[] paras = constructor.getParameterTypes();
            System.out.print("  ");
            System.out.print(modifer);
            System.out.print(className);
            System.out.print("(");
            for (int i = 0; i < paras.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(paras[i].getName());
            }
            System.out.print(");\n");
        }
    }

    public static Object goodCppy(Object obj, int newLenght) {
        Class aClass = obj.getClass();
        if (!aClass.isArray()) return null;
        Class compontType = aClass.getComponentType();
        int length = Array.getLength(obj);
        Object newArray = Array.newInstance(compontType, newLenght);
        System.arraycopy(obj, 0, newArray, length, Math.min(length, newLenght));
        return newArray;
    }
}
