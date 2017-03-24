package AcseleV13_8Asesuisa.principal;

import org.apache.log4j.Logger;

/**
 * Created by agil on 23/03/2017.
 */
public class EjecutarJar_Asesuisa {

    private final static Logger log = Logger.getLogger(EjecutarJar_Asesuisa.class);

    public static void main(String[] args) {

        //args = new String[]{"20"};

        for (int t = 0; t < args.length; t++) {

            log.info("Arrancando el main");
            String prueba;

            switch (args[t]){
                case "1":
                    prueba = "";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        //VistaINTER_ConsultaTerceroTest vistaINTER_consultaTerceroTest = new VistaINTER_ConsultaTerceroTest();
                        //vistaINTER_consultaTerceroTest.setUp();
                        //vistaINTER_consultaTerceroTest.mainTest();
                        //vistaINTER_consultaTerceroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                default:
                    log.info("--->>> No se ha seleccionado ninguna prueba o el valor de la misma es incorrecto");
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
            log.info("Final del main");
        }
    }
}
