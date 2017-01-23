package AcseleV13_8_Interseguros.principal;

import AcseleV13_8_Interseguros.tests.VistaINTER_ConsultaTerceroTest;
import AcseleV13_8_Interseguros.tests.VistaINTER_CreacionCajaTest;
import AcseleV13_8_Interseguros.tests.VistaINTER_TercerosInfTecnicaTest;
import org.apache.log4j.Logger;

/**
 * Created by agil on 11/15/16.
 */
public class EjecutarJar {

    private final static Logger log = Logger.getLogger(EjecutarJar.class);

    public static void main(String[] args) throws Exception {

        //args = new String[]{"2"};

        for (int i = 0; i < args.length; i++) {


            log.info("Arrancando el main");
            //log.error("Arrancando el main");
            //log.debug("Arrancando el main");


            switch (args[i]){
                case "1":
                    log.info("--->>> Ejecutando la prueba " + args[i] + " VistaINTER_ConsultaTerceroTest");
                    try {
                        VistaINTER_ConsultaTerceroTest vistaINTER_consultaTerceroTest = new VistaINTER_ConsultaTerceroTest();
                        vistaINTER_consultaTerceroTest.setUp();
                        vistaINTER_consultaTerceroTest.mainTest();
                        vistaINTER_consultaTerceroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + "VistaINTER_ConsultaTerceroTest" + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + "VistaINTER_ConsultaTerceroTest");
                    break;

                case "2":
                    log.info("--->>> Ejecutando la prueba " + args[i] + " VistaINTER_CreacionCajaTest");
                    try {
                        VistaINTER_CreacionCajaTest vistaINTER_creacionCajaTest = new VistaINTER_CreacionCajaTest();
                        vistaINTER_creacionCajaTest.setUp();
                        vistaINTER_creacionCajaTest.mainTest();
                        vistaINTER_creacionCajaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + "VistaINTER_CreacionCajaTest" + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + "VistaINTER_CreacionCajaTest");
                    break;

                case "3":
                    log.info("--->>> Ejecutando la prueba " + args[i] + " VistaINTER_TercerosInfTecnicaTest");
                    try {
                        VistaINTER_TercerosInfTecnicaTest vistaINTER_tercerosInfTecnicaTest = new VistaINTER_TercerosInfTecnicaTest();
                        vistaINTER_tercerosInfTecnicaTest.setUp();
                        vistaINTER_tercerosInfTecnicaTest.mainTest();
                        vistaINTER_tercerosInfTecnicaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + "VistaINTER_TercerosInfTecnicaTest" + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + "VistaINTER_TercerosInfTecnicaTest");
                    break;
            }

            /*
            if (args[i].equals("0")) {

            }*/

            log.info("Final del main");
        }
    }
}
