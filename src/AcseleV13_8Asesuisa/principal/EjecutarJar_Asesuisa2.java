package AcseleV13_8Asesuisa.principal;

import AcseleV13_8Asesuisa.tests.VistaAsesuisa_BusquedaSimplePolizaTest;
import AcseleV13_8Asesuisa.tests.VistaAsesuisa_CancelacionAnulacionPolizaTest;
import AcseleV13_8Asesuisa.tests.VistaAsesuisa_ConsultaEdoCuentaTercerosTest;
import org.apache.log4j.Logger;

// AcseleV13_8Asesuisa.tests.VistaAsesuisa_ConsultaEdoCuentaTercerosTest;

/**
 * Created by agil on 23/03/2017.
 */
public class EjecutarJar_Asesuisa2 {

    private final static Logger log = Logger.getLogger(EjecutarJar_Asesuisa2.class);

    public static void main(String[] args) {

        args = new String[]{"3"};

        int j;

        for (int t = 0; t < args.length; t++) {

            log.info("Arrancando el main");
            String prueba;

            switch (args[t]){
                case "1":
                    for (j=0; j<3; j++) {
                        prueba = "VistaAsesuisa_BusquedaSimplePolizaTest";
                        log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                        log.info("--->>> Caso #"+(j+1));
                        try {
                            VistaAsesuisa_BusquedaSimplePolizaTest busquedaSimplePolizaTest = new VistaAsesuisa_BusquedaSimplePolizaTest();
                            busquedaSimplePolizaTest.setUp(j+1);
                            busquedaSimplePolizaTest.mainTest();
                            busquedaSimplePolizaTest.tearDown(j+1);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                    }
                    break;
                case "2":
                    for (j=0; j<10; j++){
                        prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                        log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                        log.info("--->>> Caso #"+(j+1));
                        try {
                            VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                            consultaEdoCuentaTercerosTest.setUp(j+1);
                            consultaEdoCuentaTercerosTest.mainTest();
                            consultaEdoCuentaTercerosTest.tearDown(j+1);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                    }
                    break;
                case "3":
                    for (j=0; j<8; j++) {
                        prueba = "VistaAsesuisa_CancelacionAnulacionPolizaTest";
                        log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                        log.info("--->>> Caso #" + (j + 1));
                        try {
                            VistaAsesuisa_CancelacionAnulacionPolizaTest cancelacionAnulacionPolizaTest = new VistaAsesuisa_CancelacionAnulacionPolizaTest();
                            cancelacionAnulacionPolizaTest.setUp(j + 1);
                            cancelacionAnulacionPolizaTest.mainTest();
                            cancelacionAnulacionPolizaTest.tearDown(j + 1);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                    }
                    break;
                default:
                    log.info("--->>> No se ha seleccionado ninguna prueba o el valor de la misma es incorrecto");
                    break;

                /*case "":
                    prueba = "";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    log.info("--->>> Caso # ");
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
