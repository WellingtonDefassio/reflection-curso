package reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TesteInvocaMetodoComParametro {

    public static void main(String[] args) throws Exception {


        Class<?> subControleClass = Class.forName("controle.Controle");
        Constructor<?> constructor = subControleClass.getDeclaredConstructor();
        Object instance = constructor.newInstance();

        Method method = subControleClass.getDeclaredMethod("metodoControle2", String.class, Integer.class);

        Object invoke = method.invoke(instance, "Pintassilgo do Agreste", 2);

        System.out.println(invoke);

    }

}
