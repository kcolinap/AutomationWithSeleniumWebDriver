package AcseleV13_8_Rimac.principal;

import AcseleV13_8_Interseguros.tests.*;
import org.apache.log4j.Logger;
//import org.eclipse.jetty.util.log.Log;

/**
 * Created by agil on 11/15/16.
 */
public class EjecutarJar_Rimac {

    private final static Logger log = Logger.getLogger(EjecutarJar_Rimac.class);

    public static void main(String[] args) throws Exception {

        //args = new String[]{"20"};

        for (int t = 0; t < args.length; t++) {


            log.info("Arrancando el main");
            //log.error("Arrancando el main");
            //log.debug("Arrancando el main");
            String prueba;

            switch (args[t]){
                case "1":
                    prueba = "VistaRimac_";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        /*VistaINTER_ConsultaTerceroTest vistaINTER_consultaTerceroTest = new VistaINTER_ConsultaTerceroTest();
                        vistaINTER_consultaTerceroTest.setUp();
                        vistaINTER_consultaTerceroTest.mainTest();
                        vistaINTER_consultaTerceroTest.tearDown();*/
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                /*case "":
                    prueba = "";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {

                        .setUp();
                        .mainTest();
                        .tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                */
            }

            /*
            if (args[t].equals("0")) {
            }*/

            log.info("Final del main");
        }
    }
}
