package AcseleV13_8_Interseguros.principal;

import AcseleV13_8_Interseguros.tests.*;
import org.apache.log4j.Logger;
//import org.eclipse.jetty.util.log.Log;

/**
 * Created by agil on 11/15/16.
 */
public class EjecutarJar {

    private final static Logger log = Logger.getLogger(EjecutarJar.class);

    public static void main(String[] args) throws Exception {

        //args = new String[]{"20"};

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
                case "14":
                    prueba = "VistaINTER_TercerosHabilitarDeshabilitarTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try{
                        VistaINTER_TercerosHabilitarDeshabilitarTest vistaINTERTercerosHabilitarDeshabilitarTest = new VistaINTER_TercerosHabilitarDeshabilitarTest();
                        vistaINTERTercerosHabilitarDeshabilitarTest.setUp();
                        vistaINTERTercerosHabilitarDeshabilitarTest.mainTest();
                        vistaINTERTercerosHabilitarDeshabilitarTest.tearDown();
                    }catch (Exception e){
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "15":
                    prueba = "VistaINTER_TercerosEditarNombreApellidoTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_TercerosEditarNombreApellidoTest vistaINTERTercerosEditarNombreApellidoTest = new VistaINTER_TercerosEditarNombreApellidoTest();
                        vistaINTERTercerosEditarNombreApellidoTest.setUp();
                        vistaINTERTercerosEditarNombreApellidoTest.mainTest();
                        vistaINTERTercerosEditarNombreApellidoTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "16":
                    prueba = "VistaINTER_TercerosDireccionesTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_TercerosDireccionesTest vistaINTER_tercerosDireccionesTest = new VistaINTER_TercerosDireccionesTest();
                        vistaINTER_tercerosDireccionesTest.setUp();
                        vistaINTER_tercerosDireccionesTest.mainTest();
                        vistaINTER_tercerosDireccionesTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "17":
                    prueba = "VistaINTER_AsociarCajaCajeroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_AsociarCajaCajeroTest vistaINTER_asociarCajaCajeroTest = new VistaINTER_AsociarCajaCajeroTest();
                        vistaINTER_asociarCajaCajeroTest.setUp();
                        vistaINTER_asociarCajaCajeroTest.mainTest();
                        vistaINTER_asociarCajaCajeroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "18":
                    prueba = "VistaINTER_BusquedaSiniestroAvanzadaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_BusquedaSiniestroAvanzadaTest vistaINTER_busquedaSiniestroAvanzadaTest = new VistaINTER_BusquedaSiniestroAvanzadaTest();
                        vistaINTER_busquedaSiniestroAvanzadaTest.setUp();
                        vistaINTER_busquedaSiniestroAvanzadaTest.mainTest();
                        vistaINTER_busquedaSiniestroAvanzadaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "19":
                    prueba = "VistaINTER_BusquedaSiniestroSimpleTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_BusquedaSiniestroSimpleTest vistaINTER_busquedaSiniestroSimpleTest = new VistaINTER_BusquedaSiniestroSimpleTest();
                        vistaINTER_busquedaSiniestroSimpleTest.setUp();
                        vistaINTER_busquedaSiniestroSimpleTest.mainTest();
                        vistaINTER_busquedaSiniestroSimpleTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "20":
                    prueba = "VistaINTER_CajaAperturaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CajaAperturaTest vistaINTER_cajaAperturaTest = new VistaINTER_CajaAperturaTest();
                        vistaINTER_cajaAperturaTest.setUp();
                        vistaINTER_cajaAperturaTest.mainTest();
                        vistaINTER_cajaAperturaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "21":
                    prueba = "VistaINTER_CajaCierreTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CajaCierreTest vistaINTER_cajaCierreTest = new VistaINTER_CajaCierreTest();
                        vistaINTER_cajaCierreTest.setUp();
                        vistaINTER_cajaCierreTest.mainTest();
                        vistaINTER_cajaCierreTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "22":
                    prueba = "VistaINTER_CancelacionPolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CancelacionPolizaTest vistaINTER_CancelacionPolizaTest = new VistaINTER_CancelacionPolizaTest();
                        vistaINTER_CancelacionPolizaTest.setUp();
                        vistaINTER_CancelacionPolizaTest.mainTest();
                        vistaINTER_CancelacionPolizaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "23":
                    prueba = "VistaINTER_CancelarPagosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CancelarPagosTest vistaINTER_cancelarPagosTest = new VistaINTER_CancelarPagosTest();
                        vistaINTER_cancelarPagosTest.setUp();
                        vistaINTER_cancelarPagosTest.mainTest();
                        vistaINTER_cancelarPagosTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "24":
                    prueba = "VistaINTER_ConsultaAvanzadaPolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaAvanzadaPolizaTest vistaINTER_consultaAvanzadaPolizaTest = new VistaINTER_ConsultaAvanzadaPolizaTest();
                        vistaINTER_consultaAvanzadaPolizaTest.setUp();
                        vistaINTER_consultaAvanzadaPolizaTest.mainTest();
                        vistaINTER_consultaAvanzadaPolizaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "25":
                    prueba = "VistaINTER_ConsultaCuentaTecnicaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaCuentaTecnicaTest vistaINTER_consultaCuentaTecnicaTest = new VistaINTER_ConsultaCuentaTecnicaTest();
                        vistaINTER_consultaCuentaTecnicaTest.setUp();
                        vistaINTER_consultaCuentaTecnicaTest.mainTest();
                        vistaINTER_consultaCuentaTecnicaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "26":
                    prueba = "VistaINTER_ConsultaEdoCuentaTercerosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaEdoCuentaTercerosTest vistaINTER_consultaEdoCuentaTercerosTest = new VistaINTER_ConsultaEdoCuentaTercerosTest();
                        vistaINTER_consultaEdoCuentaTercerosTest.setUp();
                        vistaINTER_consultaEdoCuentaTercerosTest.mainTest();
                        vistaINTER_consultaEdoCuentaTercerosTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "27":
                    prueba = "VistaINTER_ConsultaListaRestrictivaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaListaRestrictivaTest vistaINTER_consultaListaRestrictivaTest = new VistaINTER_ConsultaListaRestrictivaTest();
                        vistaINTER_consultaListaRestrictivaTest.setUp();
                        vistaINTER_consultaListaRestrictivaTest.mainTest();
                        vistaINTER_consultaListaRestrictivaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "28":
                    prueba = "VistaINTER_ConsultaOrdenesPagoTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaOrdenesPagoTest vistaINTER_consultaOrdenesPagoTest = new VistaINTER_ConsultaOrdenesPagoTest();
                        vistaINTER_consultaOrdenesPagoTest.setUp();
                        vistaINTER_consultaOrdenesPagoTest.mainTest();
                        vistaINTER_consultaOrdenesPagoTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "29":
                    prueba = "VistaINTER_ConsultaSimplePolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ConsultaSimplePolizaTest vistaINTER_consultaSimplePolizaTest = new VistaINTER_ConsultaSimplePolizaTest();
                        vistaINTER_consultaSimplePolizaTest.setUp();
                        vistaINTER_consultaSimplePolizaTest.mainTest();
                        vistaINTER_consultaSimplePolizaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "30":
                    prueba = "VistaINTER_CreacionListaRestrictivaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CreacionListaRestrictivaTest vistaINTER_creacionListaRestrictivaTest = new VistaINTER_CreacionListaRestrictivaTest();
                        vistaINTER_creacionListaRestrictivaTest.setUp();
                        vistaINTER_creacionListaRestrictivaTest.mainTest();
                        vistaINTER_creacionListaRestrictivaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "31":
                    prueba = "VistaINTER_CreacionSiniestroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CreacionSiniestroTest vistaINTER_creacionSiniestroTest = new VistaINTER_CreacionSiniestroTest();
                        vistaINTER_creacionSiniestroTest.setUp();
                        vistaINTER_creacionSiniestroTest.mainTest();
                        vistaINTER_creacionSiniestroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "32":
                    prueba = "VistaINTER_CrearCoincidenciaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CrearCoincidenciaTest vistaINTER_crearCoincidenciaTest = new VistaINTER_CrearCoincidenciaTest();
                        vistaINTER_crearCoincidenciaTest.setUp();
                        vistaINTER_crearCoincidenciaTest.mainTest();
                        vistaINTER_crearCoincidenciaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "33":
                    prueba = "VistaINTER_CrearOpenItemsTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_CrearOpenItemsTest vistaINTER_crearOpenItemsTest = new VistaINTER_CrearOpenItemsTest();
                        vistaINTER_crearOpenItemsTest.setUp();
                        vistaINTER_crearOpenItemsTest.mainTest();
                        vistaINTER_crearOpenItemsTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "34":
                    prueba = "";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_DistribucionReaseguroTest vistaINTER_distribucionReaseguroTest = new VistaINTER_DistribucionReaseguroTest();
                        vistaINTER_distribucionReaseguroTest.setUp();
                        vistaINTER_distribucionReaseguroTest.mainTest();
                        vistaINTER_distribucionReaseguroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "35":
                    prueba = "VistaINTER_EditarSiniestroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_EditarSiniestroTest vistaINTER_editarSiniestroTest = new VistaINTER_EditarSiniestroTest();
                        vistaINTER_editarSiniestroTest.setUp();
                        vistaINTER_editarSiniestroTest.mainTest();
                        vistaINTER_editarSiniestroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "36":
                    prueba = "VistaINTER_FormulacionesTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_FormulacionesTest vistaINTER_formulacionesTest = new VistaINTER_FormulacionesTest();
                        vistaINTER_formulacionesTest.setUp();
                        vistaINTER_formulacionesTest.mainTest();
                        vistaINTER_formulacionesTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "37":
                    prueba = "VistaINTER_HistorialReclamoTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_HistorialReclamoTest vistaINTER_historialReclamoTest = new VistaINTER_HistorialReclamoTest();
                        vistaINTER_historialReclamoTest.setUp();
                        vistaINTER_historialReclamoTest.mainTest();
                        vistaINTER_historialReclamoTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "38":
                    prueba = "VistaINTER_LiquidacionCtaTecnicaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_LiquidacionCtaTecnicaTest vistaINTER_liquidacionCtaTecnicaTest = new VistaINTER_LiquidacionCtaTecnicaTest();
                        vistaINTER_liquidacionCtaTecnicaTest.setUp();
                        vistaINTER_liquidacionCtaTecnicaTest.mainTest();
                        vistaINTER_liquidacionCtaTecnicaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "39":
                    prueba = "VistaINTER_ModosPagoTerceroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ModosPagoTerceroTest vistaINTER_modosPagoTerceroTest = new VistaINTER_ModosPagoTerceroTest();
                        vistaINTER_modosPagoTerceroTest.setUp();
                        vistaINTER_modosPagoTerceroTest.mainTest();
                        vistaINTER_modosPagoTerceroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "40":
                    prueba = "VistaINTER_ObjetarCoberturaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ObjetarCoberturaTest vistaINTER_objetarCoberturaTest = new VistaINTER_ObjetarCoberturaTest();
                        vistaINTER_objetarCoberturaTest.setUp();
                        vistaINTER_objetarCoberturaTest.mainTest();
                        vistaINTER_objetarCoberturaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "41":
                    prueba = "VistaINTER_PagoPorConceptosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_PagoPorConceptosTest vistaINTER_pagoPorConceptosTest = new VistaINTER_PagoPorConceptosTest();
                        vistaINTER_pagoPorConceptosTest.setUp();
                        vistaINTER_pagoPorConceptosTest.mainTest();
                        vistaINTER_pagoPorConceptosTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "42":
                    prueba = "VistaINTER_PolizaEmisionBeneficiarioNaturalTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_PolizaEmisionBeneficiarioNaturalTest vistaINTER_polizaEmisionBeneficiarioNaturalTest = new VistaINTER_PolizaEmisionBeneficiarioNaturalTest();
                        vistaINTER_polizaEmisionBeneficiarioNaturalTest.setUp();
                        vistaINTER_polizaEmisionBeneficiarioNaturalTest.mainTest();
                        vistaINTER_polizaEmisionBeneficiarioNaturalTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "43":
                    prueba = "VistaINTER_PrevisualizacionCuentaTecnicaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_PrevisualizacionCuentaTecnicaTest vistaINTER_previsualizacionCuentaTecnicaTest = new VistaINTER_PrevisualizacionCuentaTecnicaTest();
                        vistaINTER_previsualizacionCuentaTecnicaTest.setUp();
                        vistaINTER_previsualizacionCuentaTecnicaTest.mainTest();
                        vistaINTER_previsualizacionCuentaTecnicaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "44":
                    prueba = "VistaINTER_RechazarPagoSiniestroTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_RechazarPagoSiniestroTest vistaINTER_rechazarPagoSiniestroTest = new VistaINTER_RechazarPagoSiniestroTest();
                        vistaINTER_rechazarPagoSiniestroTest.setUp();
                        vistaINTER_rechazarPagoSiniestroTest.mainTest();
                        vistaINTER_rechazarPagoSiniestroTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "45":
                    prueba = "VistaINTER_RenovacionPolizaTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_RenovacionPolizaTest vistaINTER_renovacionPolizaTest = new VistaINTER_RenovacionPolizaTest();
                        vistaINTER_renovacionPolizaTest.setUp();
                        vistaINTER_renovacionPolizaTest.mainTest();
                        vistaINTER_renovacionPolizaTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "46":
                    prueba = "VistaInter_TablaDinamicaExportTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_TablaDinamicaExportTest vistaInter_tablaDinamicaExportTest = new VistaInter_TablaDinamicaExportTest();
                        vistaInter_tablaDinamicaExportTest.setUp();
                        vistaInter_tablaDinamicaExportTest.mainTest();
                        vistaInter_tablaDinamicaExportTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "47":
                    prueba = "VistaInter_TablaDinamicaImportTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_TablaDinamicaImportTest vistaInter_tablaDinamicaImportTest = new VistaInter_TablaDinamicaImportTest();
                        vistaInter_tablaDinamicaImportTest.setUp();
                        vistaInter_tablaDinamicaImportTest.mainTest();
                        vistaInter_tablaDinamicaImportTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "48":
                    prueba = "VistaINTER_TerceroDeshabilitarTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_TerceroDeshabilitarTest vistaINTER_terceroDeshabilitarTest = new VistaINTER_TerceroDeshabilitarTest();
                        vistaINTER_terceroDeshabilitarTest.setUp();
                        vistaINTER_terceroDeshabilitarTest.mainTest();
                        vistaINTER_terceroDeshabilitarTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "49":
                    prueba = "VistaInter_TercerosCrearTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_TercerosCrearTest vistaInter_tercerosCrearTest = new VistaInter_TercerosCrearTest();
                        vistaInter_tercerosCrearTest.setUp();
                        vistaInter_tercerosCrearTest.mainTest();
                        vistaInter_tercerosCrearTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "50":
                    prueba = "VistaINTER_TercerosDireccionesTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_TercerosDireccionesTest vistaINTER_tercerosDireccionesTest = new VistaINTER_TercerosDireccionesTest();
                        vistaINTER_tercerosDireccionesTest.setUp();
                        vistaINTER_tercerosDireccionesTest.mainTest();
                        vistaINTER_tercerosDireccionesTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "51":
                    prueba = "VistaInter_TercerosDocumentosTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaInter_TercerosDocumentosTest vistaInter_tercerosDocumentosTest = new VistaInter_TercerosDocumentosTest();
                        vistaInter_tercerosDocumentosTest.setUp();
                        vistaInter_tercerosDocumentosTest.mainTest();
                        vistaInter_tercerosDocumentosTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "52":
                    prueba = "VistaINTER_TransformadoresTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_TransformadoresTest vistaINTER_transformadoresTest = new VistaINTER_TransformadoresTest();
                        vistaINTER_transformadoresTest.setUp();
                        vistaINTER_transformadoresTest.mainTest();
                        vistaINTER_transformadoresTest.tearDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error("Test Case - " + prueba + " - " + e);
                    }
                    log.info("--->>> Final de la prueba " + prueba);
                    break;
                case "53":
                    prueba = "VistaINTER_ValidarOpenItemTest";
                    log.info("--->>> Ejecutando la prueba " + args[t] + " " + prueba);
                    try {
                        VistaINTER_ValidarOpenItemTest vistaINTER_validarOpenItemTest = new VistaINTER_ValidarOpenItemTest();
                        vistaINTER_validarOpenItemTest.setUp();
                        vistaINTER_validarOpenItemTest.mainTest();
                        vistaINTER_validarOpenItemTest.tearDown();
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

            /*
            if (args[t].equals("0")) {
            }*/

            log.info("Final del main");
        }
    }
}
