package AcseleV13_8_Interseguros.principal;

import AcseleV13_8_Interseguros.tests.*;
import org.apache.log4j.Logger;

/**
 * Created by agil on 11/15/16.
 */
public class EjecutarJar {

    private final static Logger log = Logger.getLogger(EjecutarJar.class);

    public static void main(String[] args) throws Exception {

        //args = new String[]{"2"};

        for (int t = 0; t < args.length; t++) {


            log.info("Arrancando el main");
            //log.error("Arrancando el main");
            //log.debug("Arrancando el main");
            String prueba;

            switch (args[t]){
                case "1":
                    prueba = "VistaINTER_ConsultaTerceroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaTerceroTest vistaINTER_consultaTerceroTest = new VistaINTER_ConsultaTerceroTest();
                        vistaINTER_consultaTerceroTest.setUp();
                        vistaINTER_consultaTerceroTest.mainTest();
                        vistaINTER_consultaTerceroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "2":
                    prueba = "VistaINTER_CreacionCajaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CreacionCajaTest vistaINTER_creacionCajaTest = new VistaINTER_CreacionCajaTest();
                        vistaINTER_creacionCajaTest.setUp();
                        vistaINTER_creacionCajaTest.mainTest();
                        vistaINTER_creacionCajaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "3":
                    prueba = "VistaINTER_TercerosInfTecnicaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_TercerosInfTecnicaTest vistaINTER_tercerosInfTecnicaTest = new VistaINTER_TercerosInfTecnicaTest();
                        vistaINTER_tercerosInfTecnicaTest.setUp();
                        vistaINTER_tercerosInfTecnicaTest.mainTest();
                        vistaINTER_tercerosInfTecnicaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "4":
                    prueba = "VistaINTER_CerrarSiniestroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CerrarSiniestroTest vistaINTERCerrarSiniestroTest = new VistaINTER_CerrarSiniestroTest();
                        vistaINTERCerrarSiniestroTest.setUp();
                        vistaINTERCerrarSiniestroTest.mainTest();
                        vistaINTERCerrarSiniestroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "5":
                    prueba = "VistaINTER_ReabrirSiniestroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ReabrirSiniestroTest vistaINTERReabrirSiniestroTest = new VistaINTER_ReabrirSiniestroTest();
                        vistaINTERReabrirSiniestroTest.setUp();
                        vistaINTERReabrirSiniestroTest.mainTest();
                        vistaINTERReabrirSiniestroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "6":
                    prueba = "VistaINTER_RechazarSiniestroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_RechazarSiniestroTest vistaINTER_rechazarSiniestroTest = new VistaINTER_RechazarSiniestroTest();
                        vistaINTER_rechazarSiniestroTest.setUp();
                        vistaINTER_rechazarSiniestroTest.mainTest();
                        vistaINTER_rechazarSiniestroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "7":
                    prueba = "VistaINTER_CumuloAseguradoTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CumuloAseguradoTest vistaINTERCumuloAseguradoTest = new VistaINTER_CumuloAseguradoTest();
                        vistaINTERCumuloAseguradoTest.setUp();
                        vistaINTERCumuloAseguradoTest.mainTest();
                        vistaINTERCumuloAseguradoTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "8":
                    prueba = "VistaINTER_CumuloProductoTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CumuloProductoTest vistaINTERCumuloProductoTest = new VistaINTER_CumuloProductoTest();
                        vistaINTERCumuloProductoTest.setUp();
                        vistaINTERCumuloProductoTest.mainTest();
                        vistaINTERCumuloProductoTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "9":
                    prueba = "VistaINTER_CumuloTerceroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CumuloTerceroTest vistaINTERCumuloTerceroTest = new VistaINTER_CumuloTerceroTest();
                        vistaINTERCumuloTerceroTest.setUp();
                        vistaINTERCumuloTerceroTest.mainTest();
                        vistaINTERCumuloTerceroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "10":
                    prueba = "VistaInter_PolizaEmisionVariasURTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_PolizaEmisionVariasURTest vistaInterPolizaEmisionVariasURTest = new VistaInter_PolizaEmisionVariasURTest();
                        vistaInterPolizaEmisionVariasURTest.setUp();
                        vistaInterPolizaEmisionVariasURTest.mainTest();
                        vistaInterPolizaEmisionVariasURTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "11":
                    prueba = "VistaInter_PolizaEmisionVariosOADotalSimpleTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_PolizaEmisionVariosOADotalSimpleTest vistaInterPolizaEmisionVariosOADotalSimpleTest = new VistaInter_PolizaEmisionVariosOADotalSimpleTest();
                        vistaInterPolizaEmisionVariosOADotalSimpleTest.setUp();
                        vistaInterPolizaEmisionVariosOADotalSimpleTest.mainTest();
                        vistaInterPolizaEmisionVariosOADotalSimpleTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "12":
                    prueba = "VistaInter_PolizaEmisionVariosOATest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_PolizaEmisionVariosOATest vistaInterPolizaEmisionVariosOATest = new VistaInter_PolizaEmisionVariosOATest();
                        vistaInterPolizaEmisionVariosOATest.setUp();
                        vistaInterPolizaEmisionVariosOATest.mainTest();
                        vistaInterPolizaEmisionVariosOATest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "13":
                    prueba = "VistaInter_PolizaIncluirEditarEliminarContratanteTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_PolizaIncluirEditarEliminarContratanteTest vistaInterPolizaIncluirEditarEliminarContratanteTest = new VistaInter_PolizaIncluirEditarEliminarContratanteTest();
                        vistaInterPolizaIncluirEditarEliminarContratanteTest.setUp();
                        vistaInterPolizaIncluirEditarEliminarContratanteTest.mainTest();
                        vistaInterPolizaIncluirEditarEliminarContratanteTest.tearDown();
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
