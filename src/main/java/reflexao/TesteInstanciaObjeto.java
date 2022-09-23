package reflexao;

import controle.Controle;

import java.lang.constant.Constable;

public class TesteInstanciaObjeto {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<Controle> controleClass1 = Controle.class;
        Controle controle2 = new Controle();
        Class<?> controle3 = Class.forName("controle.Controle");


       Controle controleNew1  = controleClass1.newInstance();

        Object controleNew3  = controle3.newInstance();

        System.out.println(controleNew1 instanceof Controle);
        System.out.println(controleNew3 instanceof Controle);

    }

}

