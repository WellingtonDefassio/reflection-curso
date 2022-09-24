package reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TesteInvocaMetodoSemParametro {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        Class<?> subControleClass = Class.forName("controle.SubControle");
        Constructor<?> declaredConstructor = subControleClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Object instanceSubControle = declaredConstructor.newInstance();

        Method[] methods = subControleClass.getMethods();
        Method[] methodsDeclared = subControleClass.getDeclaredMethods();

        for (Method m : methods) {

            System.out.println(m);
        }

        System.out.println();

        for (Method m : methodsDeclared) {

            System.out.println(m);
        }

        Method method = subControleClass.getDeclaredMethod("metodoSubControle1");
        method.setAccessible(true);
        Object retorno = method.invoke(instanceSubControle);

        System.out.println("retorno...");
        System.out.println(retorno);

    }
}
