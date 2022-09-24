package reflexao;

import controle.Controle;
import controle.SubControle;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaObjetoCorretamente {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException {

        Class<SubControle> subControleClass = SubControle.class;
        Controle controle2 = new Controle();
        Class<?> controle3 = Class.forName("controle.Controle");


        Constructor<SubControle> subControleConstructor = subControleClass.getConstructor();
        Constructor<SubControle> subControleConstructor2 = subControleClass.getDeclaredConstructor(String.class);

        System.out.println(subControleConstructor);
        System.out.println(subControleConstructor2);

        subControleConstructor2.setAccessible(true);
        SubControle subControle = subControleConstructor2.newInstance("?");

        System.out.println(subControle);

        Constructor<?> constructor = controle3.getDeclaredConstructor();
        constructor.newInstance();


    }

}
