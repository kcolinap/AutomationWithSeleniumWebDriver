package AcseleV13_8Asesuisa.principal;

import AcseleV13_8Asesuisa.tests.*;//VistaAsesuisa_BusquedaSimplePolizaTest;
// AcseleV13_8Asesuisa.tests.VistaAsesuisa_ConsultaEdoCuentaTercerosTest;
import org.apache.log4j.Logger;

/**
 * Created by agil on 23/03/2017.
 */
public class EjecutarJar_Asesuisa {

    private final static Logger log = Logger.getLogger(EjecutarJar_Asesuisa.class);

    public static void main(String[] args) {

        args = new String[]{"3"};

        int j;

        for (int t = 0; t < args.length; t++) {

            log.info("Arrancando el main");
            String prueba;

            switch (args[t]){
                case "1":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(1);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "2":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(2);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "3":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(3);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(3);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "4":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(4);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(4);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "5":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(5);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(5);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "6":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(6);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(6);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "7":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(7);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(7);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "8":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(8);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(8);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "988":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(9);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(9);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "10":
                    prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                        consultaEdoCuentaTercerosTest.setUp(10);
                        consultaEdoCuentaTercerosTest.mainTest();
                        consultaEdoCuentaTercerosTest.tearDown(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "11":
                    prueba = "VistaAsesuisa_BusquedaSimplePolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_BusquedaSimplePolizaTest busquedaSimplePolizaTest = new VistaAsesuisa_BusquedaSimplePolizaTest();
                        busquedaSimplePolizaTest.setUp(1);
                        busquedaSimplePolizaTest.mainTest();
                        busquedaSimplePolizaTest.tearDown(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "12":
                    prueba = "VistaAsesuisa_BusquedaSimplePolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_BusquedaSimplePolizaTest busquedaSimplePolizaTest = new VistaAsesuisa_BusquedaSimplePolizaTest();
                        busquedaSimplePolizaTest.setUp(2);
                        busquedaSimplePolizaTest.mainTest();
                        busquedaSimplePolizaTest.tearDown(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "13":
                    prueba = "VistaAsesuisa_BusquedaSimplePolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaAsesuisa_BusquedaSimplePolizaTest busquedaSimplePolizaTest = new VistaAsesuisa_BusquedaSimplePolizaTest();
                        busquedaSimplePolizaTest.setUp(3);
                        busquedaSimplePolizaTest.mainTest();
                        busquedaSimplePolizaTest.tearDown(3);
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