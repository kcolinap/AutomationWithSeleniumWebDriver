package AcseleV13_8Asesuisa.principal;

import AcseleV13_8Asesuisa.tests.*;
import org.apache.log4j.Logger;

/**
 * Created by agil on 30/03/2017.
 */
public class EjecutarJar_Asesuisa {

    private final static Logger log = Logger.getLogger(EjecutarJar_Asesuisa.class);

    public static void main(String[] args) {

        //args = new String[]{"10", "17", "7"};
        //System.out.println("El tamaño del arreglo es: " + args.length);

        String primero = args[0];
        String segundo = args[1];
        String tercero = args[2];
        /*System.out.println(primero);
        System.out.println(segundo);
        System.out.println(tercero);
        */
        log.info("Arrancando el main");
        String prueba;

        switch (primero){

            case "1": // 1) Consultas de Edos de Ctas de terceros por todos los campos
                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "VistaAsesuisa_ConsultaEdoCuentaTercerosTest";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {
                    VistaAsesuisa_ConsultaEdoCuentaTercerosTest consultaEdoCuentaTercerosTest = new VistaAsesuisa_ConsultaEdoCuentaTercerosTest();
                    consultaEdoCuentaTercerosTest.setUp(segundo);
                    consultaEdoCuentaTercerosTest.mainTest();
                    consultaEdoCuentaTercerosTest.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "2": // 2)Consultas de pólizas (búsqueda simple)
                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "VistaAsesuisa_BusquedaSimplePolizaTest";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {
                    VistaAsesuisa_BusquedaSimplePolizaTest busquedaSimplePolizaTest = new VistaAsesuisa_BusquedaSimplePolizaTest();
                    busquedaSimplePolizaTest.setUp(segundo);
                    busquedaSimplePolizaTest.mainTest();
                    busquedaSimplePolizaTest.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "3": // 3)Consultas de pólizas por todos los campos (búsqueda avanzada)
                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "VistaAsesuisa_BusquedaAvanzadaPolizaTest";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {
                    VistaAsesuisa_BusquedaAvanzadaPolizaTest busquedaAvanzadaPolizaTest= new VistaAsesuisa_BusquedaAvanzadaPolizaTest();
                    busquedaAvanzadaPolizaTest.setUp(segundo);
                    busquedaAvanzadaPolizaTest.mainTest();
                    busquedaAvanzadaPolizaTest.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "4": // 4) Cancelación/Anulación de Pólizas.
                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "VistaAsesuisa_CancelacionAnulacionPolizaTest";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {
                    VistaAsesuisa_CancelacionAnulacionPolizaTest cancelacionAnulacionPolizaTest = new VistaAsesuisa_CancelacionAnulacionPolizaTest();
                    cancelacionAnulacionPolizaTest.setUp(segundo);
                    cancelacionAnulacionPolizaTest.mainTest();
                    cancelacionAnulacionPolizaTest.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "5": // 5) Renovación de pólizas.
                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "VistaAsesuisa_RenovacionPolizaTest";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {
                    VistaAsesuisa_RenovacionPolizaTest renovacionPolizaTestPolizaTest = new VistaAsesuisa_RenovacionPolizaTest();
                    renovacionPolizaTestPolizaTest.setUp(segundo);
                    renovacionPolizaTestPolizaTest.mainTest();
                    renovacionPolizaTestPolizaTest.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);
                break;

            case "6": // 6) Terceros:
                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Consulta de Terceros
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosConsultaTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosConsultaTest tercerosConsultaTest = new VistaAsesuisa_TercerosConsultaTest();
                            tercerosConsultaTest.setUp(tercero);
                            tercerosConsultaTest.mainTest();
                            tercerosConsultaTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);


                        break;
                    case "2": // b. Creación de Terceros con el mismo tipo y documento de identidad un tercero existente
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosCreacionRepetidaTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosCreacionRepetidaTest tercerosCreacionRepetidaTest = new VistaAsesuisa_TercerosCreacionRepetidaTest();
                            tercerosCreacionRepetidaTest.setUp(tercero);
                            tercerosCreacionRepetidaTest.mainTest();
                            tercerosCreacionRepetidaTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "3": // NA c. Creación de Terceros con diferente tipo y documento de identidad un tercero existente
                        System.out.println("Numero: " + tercero);
                        break;
                    case "4": // d. Edición de Terceros.
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosEditarTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosEditarTest tercerosEditarTest = new VistaAsesuisa_TercerosEditarTest();
                            tercerosEditarTest.setUp(tercero);
                            tercerosEditarTest.mainTest();
                            tercerosEditarTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "5": // e. Edición de Terceros. Cambiar tipo y documento de identidad por los datos de un tercero existente
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosCambioTipoDocumentoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosCambioTipoDocumentoTest tercerosCambioTipoDocumentoTest = new VistaAsesuisa_TercerosCambioTipoDocumentoTest();
                            tercerosCambioTipoDocumentoTest.setUp(tercero);
                            tercerosCambioTipoDocumentoTest.mainTest();
                            tercerosCambioTipoDocumentoTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "6": // f. Información Técnica
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosInformacionTecnicaTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosInformacionTecnicaTest tercerosInformacionTecnicaTest = new VistaAsesuisa_TercerosInformacionTecnicaTest();
                            tercerosInformacionTecnicaTest.setUp(tercero);
                            tercerosInformacionTecnicaTest.mainTest();
                            tercerosInformacionTecnicaTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "7": // g. Direcciones
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosDireccionesTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosDireccionesTest tercerosDireccionesTest = new VistaAsesuisa_TercerosDireccionesTest();
                            tercerosDireccionesTest.setUp(tercero);
                            tercerosDireccionesTest.mainTest();
                            tercerosDireccionesTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "8": // h. Documentos
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosDocumentosTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosDocumentosTest tercerosDocumentosTest = new VistaAsesuisa_TercerosDocumentosTest();
                            tercerosDocumentosTest.setUp(tercero);
                            tercerosDocumentosTest.mainTest();
                            tercerosDocumentosTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "9": // i. Modos de Pago
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_ModosdePagoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_ModosdePagoTest mododePago = new VistaAsesuisa_ModosdePagoTest();
                            mododePago.setUp(tercero);
                            mododePago.mainTest();
                            mododePago.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        break;
                    case "10": // j. Roles revisión general
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_RolesTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_RolesTest roles = new VistaAsesuisa_RolesTest();
                            roles.setUp(tercero);
                            roles.mainTest(tercero);
                            roles.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        break;
                    case "11": // k. Asociar rol a tercero nuevo y validarlo
                        System.out.println("Numero: " + tercero);
                        break;
                    case "12": // l. Modificar rol: cambiar género y fecha nacimiento rol Asegurado Vida – luego consultar traza de auditoria
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_ModificarRolTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_ModificarRolTest modRol = new VistaAsesuisa_ModificarRolTest();
                            modRol.setUp(tercero);
                            modRol.mainTest();
                            modRol.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }

                        break;
                    case "13": // m.Información financiera
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_TercerosInformacionFinancieraTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosInformacionFinancieraTest infFinac = new VistaAsesuisa_TercerosInformacionFinancieraTest();
                            infFinac.setUp(tercero);
                            infFinac.mainTest();
                            infFinac.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        break;
                    case "14": // o. Líneas de Crédito (Garantías)
                        System.out.println("Numero: " + tercero);
                        break;
                    case "15": // q. Validar asociación rol : Beneficiario Natural a tercero jurídico y Beneficiario Jurídico a tercero Natural
                        System.out.println("Numero: " + tercero);
                        break;
                    case "16": // r. Habilitar/Deshabilitar – Terceros y luego Validarlos en la aplicación
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_TercerosHabDeshabTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TercerosHabDeshabTest tercerosHabDeshabTest = new VistaAsesuisa_TercerosHabDeshabTest();
                            tercerosHabDeshabTest.setUp(tercero);
                            tercerosHabDeshabTest.mainTest();
                            tercerosHabDeshabTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }

                        break;
                    case "17": // s. Creación de Terceros con diferente tipo de documento de identidad un tercero existente
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "7": // 7) Caja (Crear Caja - Asociar Caja a Cajero - Aperturar y Cerrar Caja)

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Crear caja
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_CajaCrearTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaCrearTest cajaCrearTest = new VistaAsesuisa_CajaCrearTest();
                            cajaCrearTest.setUp(tercero);
                            cajaCrearTest.mainTest();
                            cajaCrearTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "2": // b. Asociar caja a cajero
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_CajaAsociarCajeroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaAsociarCajeroTest cajaAsociarCajeroTest = new VistaAsesuisa_CajaAsociarCajeroTest();
                            cajaAsociarCajeroTest.setUp(tercero);
                            cajaAsociarCajeroTest.mainTest();
                            cajaAsociarCajeroTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "3": // c. Aperturar Caja
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_CajaAperturarTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaAperturarTest cajaAperturarTest = new VistaAsesuisa_CajaAperturarTest();
                            cajaAperturarTest.setUp(tercero);
                            cajaAperturarTest.mainTest();
                            cajaAperturarTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "4": // d. Cerrar Caja
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_CajaCerrarTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaCerrarTest cajaCerrarTest = new VistaAsesuisa_CajaCerrarTest();
                            cajaCerrarTest.setUp(tercero);
                            cajaCerrarTest.mainTest();
                            cajaCerrarTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "5": // e. Dosificaciones de caja
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaDosificacionesTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaDosificacionesTest cajaDosificacionesTest = new VistaAsesuisa_CajaDosificacionesTest();
                            cajaDosificacionesTest.setUp(tercero);
                            cajaDosificacionesTest.mainTest();
                            cajaDosificacionesTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "6": // f. Dosificaciones de caja mantenimiento
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaDosificacionesMantTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaDosificacionesMantTest cajaDosificacionesMantTest = new VistaAsesuisa_CajaDosificacionesMantTest();
                            cajaDosificacionesMantTest.setUp(tercero);
                            cajaDosificacionesMantTest.mainTest();
                            cajaDosificacionesMantTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "7": // h. Modalidades de factura en caja
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaModalidadesTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaModalidadesTest cajaModalidadesTest = new VistaAsesuisa_CajaModalidadesTest();
                            cajaModalidadesTest.setUp(tercero);
                            cajaModalidadesTest.mainTest();
                            cajaModalidadesTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "8": // g. Notas de credito de caja
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaNotasCreditoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaNotasCreditoTest cajaNotasCreditoTest = new VistaAsesuisa_CajaNotasCreditoTest();
                            cajaNotasCreditoTest.setUp(tercero);
                            cajaNotasCreditoTest.mainTest();
                            cajaNotasCreditoTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "9": // i. Caja Anulacion de Facturas
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaAnularFacturaTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaAnularFacturaTest cajaAnularFacturaTestTest = new VistaAsesuisa_CajaAnularFacturaTest();
                            cajaAnularFacturaTestTest.setUp(tercero);
                            cajaAnularFacturaTestTest.mainTest();
                            cajaAnularFacturaTestTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "10": // j. Pagos en caja
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaPagosTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaPagosTest cajaPagosTest = new VistaAsesuisa_CajaPagosTest();
                            cajaPagosTest.setUp(tercero);
                            cajaPagosTest.mainTest();
                            cajaPagosTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "11": // j. Pagos en caja Facturas por Agrupacion
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CajaFactAgrupTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CajaFactAgrupTest cajaFactAgrupTest = new VistaAsesuisa_CajaFactAgrupTest();
                            cajaFactAgrupTest.setUp(tercero);
                            cajaFactAgrupTest.mainTest();
                            cajaFactAgrupTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                }
                break;

            case "8": // 8) Emisión de Pólizas.

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Emision con plan de financiamiento
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaEmisionConPlanFinanciamientoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaEmisionConPlanFinanciamientoTest polizaEmisionConPlanFinanciamientoTest = new VistaAsesuisa_PolizaEmisionConPlanFinanciamientoTest();
                            polizaEmisionConPlanFinanciamientoTest.setUp(tercero);
                            polizaEmisionConPlanFinanciamientoTest.mainTest();
                            polizaEmisionConPlanFinanciamientoTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "2": // b. Emision sin plan de financiamiento
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaEmisionSinPlanFinanciamientoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaEmisionSinPlanFinanciamientoTest polizaEmisionSinPlanFinanciamientoTest = new VistaAsesuisa_PolizaEmisionSinPlanFinanciamientoTest();
                            polizaEmisionSinPlanFinanciamientoTest.setUp(tercero);
                            polizaEmisionSinPlanFinanciamientoTest.mainTest();
                            polizaEmisionSinPlanFinanciamientoTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "3": // c. Inclusión de varios OA
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaEmisionVariosOAAutomotoresTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaEmisionVariosOAAutomotoresTest polizaEmisionVariosOAAutomotoresTest = new VistaAsesuisa_PolizaEmisionVariosOAAutomotoresTest();
                            polizaEmisionVariosOAAutomotoresTest.setUp(tercero);
                            polizaEmisionVariosOAAutomotoresTest.mainTest();
                            polizaEmisionVariosOAAutomotoresTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "4": // d. Inclusión de varios UR
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaEmisionVariasURAutomotoresTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaEmisionVariasURAutomotoresTest polizaEmisionVariasURAutomotoresTest = new VistaAsesuisa_PolizaEmisionVariasURAutomotoresTest();
                            polizaEmisionVariasURAutomotoresTest.setUp(tercero);
                            polizaEmisionVariasURAutomotoresTest.mainTest();
                            polizaEmisionVariasURAutomotoresTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "5": // e. Inclusión, edición y eliminación de Tomadores
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaEmisionTomadoresTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaEmisionTomadoresTest asesuisa_polizaEmisionTomadoresTest = new VistaAsesuisa_PolizaEmisionTomadoresTest();
                            asesuisa_polizaEmisionTomadoresTest.setUp(tercero);
                            asesuisa_polizaEmisionTomadoresTest.mainTest();
                            asesuisa_polizaEmisionTomadoresTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "6": // f. nclusión, edición y eliminación de Beneficiarios Naturales
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaEmisionBeneficiarioTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaEmisionBeneficiarioTest asesuisa_polizaEmisionBeneficiarioTest = new VistaAsesuisa_PolizaEmisionBeneficiarioTest();
                            asesuisa_polizaEmisionBeneficiarioTest.setUp(tercero);
                            asesuisa_polizaEmisionBeneficiarioTest.mainTest();
                            asesuisa_polizaEmisionBeneficiarioTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "7": // g. Inclusión, edición y eliminación de Pagadores
                        System.out.println("Numero: " + tercero);
                        break;
                    case "8": // h. Validar que se genere el open ítem de la prima emitida y tenga el número de la póliza asociado
                        System.out.println("Numero: " + tercero);
                        break;
                    case "9": // i. Emisión con facultativo
                        System.out.println("Numero: " + tercero);
                        break;
                    case "10": // i. Cotización con plan de financiamiento
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaCotizacionConPlanFinanciamientoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaCotizacionConPlanFinanciamientoTest polizaCotizacionConPlanFinanciamientoTest = new VistaAsesuisa_PolizaCotizacionConPlanFinanciamientoTest();
                            polizaCotizacionConPlanFinanciamientoTest.setUp(tercero);
                            polizaCotizacionConPlanFinanciamientoTest.mainTest();
                            polizaCotizacionConPlanFinanciamientoTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "11": // i. Cotización sin plan de financiamiento
                        System.out.println("Numero: " + tercero);

                        prueba = "VistaAsesuisa_PolizaCotizacionSinPlanFinanciamientoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PolizaCotizacionSinPlanFinanciamientoTest polizaCotizacionSinPlanFinanciamientoTest = new VistaAsesuisa_PolizaCotizacionSinPlanFinanciamientoTest();
                            polizaCotizacionSinPlanFinanciamientoTest.setUp(tercero);
                            polizaCotizacionSinPlanFinanciamientoTest.mainTest();
                            polizaCotizacionSinPlanFinanciamientoTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "12": // i. Cotización con varios OA y UR
                        System.out.println("Numero: " + tercero);
                        break;

                }
                break;

            case "9": // 9) Generación de documentos de Pólizas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Impresión de documentos a nivel de Póliza
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. Impresión de documentos a nivel de UR
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "10": // 10) Siniestros:

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Creación de siniestros
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_SiniestroCrearTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_SiniestroCrearTest siniestroCrearTest = new VistaAsesuisa_SiniestroCrearTest();
                            siniestroCrearTest.setUp(tercero);
                            siniestroCrearTest.mainTest();
                            siniestroCrearTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "2": // b. Agregar y rechazar coberturas
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_CoberturasSiniestroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_CoberturasSiniestroTest coberturasSiniestro = new VistaAsesuisa_CoberturasSiniestroTest();
                            coberturasSiniestro.setUp(tercero);
                            coberturasSiniestro.mainTest();
                            coberturasSiniestro.tearDown(tercero);
                        }catch (Exception e){
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "3": // c. Pagos por conceptos
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_PagosPorConceptoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PagosPorConceptoTest pagosConcepto = new VistaAsesuisa_PagosPorConceptoTest();
                            pagosConcepto.setUp(tercero);
                            pagosConcepto.mainTest();
                            pagosConcepto.tearDown(tercero);
                        }catch (Exception e){
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "4": // d. Histórico de Siniestros
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_HistSiniestroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_HistSiniestroTest hSiniestro = new VistaAsesuisa_HistSiniestroTest();
                            hSiniestro.setUp(tercero);
                            hSiniestro.mainTest();
                            hSiniestro.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;

                    case "5": // e. Cerrar, rechazar y reabrir Siniestros
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_ManteSiniestroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_ManteSiniestroTest mSiniestro=  new VistaAsesuisa_ManteSiniestroTest();
                            mSiniestro.setUp(tercero);
                            mSiniestro.mainTest();
                            mSiniestro.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "6": // f. Validar que no se puedan hacer operaciones o movimientos con Siniestros Cerrados o Rechazados
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_ValidacionOperacionSiniestroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_ValidacionOperacionSiniestroTest oSiniestro = new VistaAsesuisa_ValidacionOperacionSiniestroTest();
                            oSiniestro.setUp(tercero);
                            oSiniestro.mainTest();
                            oSiniestro.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "7": // g. Ajustes a las reservas de siniestros (casos bordes ajustes de reservas con valor cero)
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_AjusteReservaSiniestroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_AjusteReservaSiniestroTest aSiniestro =  new VistaAsesuisa_AjusteReservaSiniestroTest();
                            aSiniestro.setUp(tercero);
                            aSiniestro.mainTest();
                            aSiniestro.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "8": // h. Ajuste automático de reservas
                        System.out.println("Numero: " + tercero);
                        break;
                    case "9": // i. Módulo de facturas de siniestros
                        System.out.println("Numero: " + tercero);
                        break;
                    case "10": // j. Pago de siniestros (Crear pago)
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_SiniestroPagoTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_SiniestrosPagosTest jSiniestro = new VistaAsesuisa_SiniestrosPagosTest();
                            jSiniestro.setUp(tercero);
                            jSiniestro.mainTest();
                            jSiniestro.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "11": // k. Aprobar pagos
                        System.out.println("Numero: " + tercero);
                        break;
                    case "12": // l. Enviar Pagos
                        System.out.println("Numero: " + tercero);
                        break;
                    case "13": // m. Rechazar Pagos
                        System.out.println("Numero: " + tercero);
                        break;
                    case "14": // n. Cancelar Pagos
                        System.out.println("Numero: " + tercero);
                        break;
                    case "15": // o. Consultas de órdenes de pago.
                        System.out.println("Numero: " + tercero);
                        break;
                    case "16": // p. pago express en siniestro
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_PagoExpressSiniestroTest ";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_PagoExpressSiniestroTest  PagoExpressSiniestroTest = new VistaAsesuisa_PagoExpressSiniestroTest ();
                            PagoExpressSiniestroTest.setUp(tercero);
                            PagoExpressSiniestroTest.mainTest();
                            PagoExpressSiniestroTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);

                        break;
                    case "17": // q. Módulo de búsqueda de Siniestros Búsqueda avanzada
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_SiniestroBusquedaAvanzadaTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_SiniestroBusquedaAvanzadaTest busquedaAvanzadaTest = new VistaAsesuisa_SiniestroBusquedaAvanzadaTest();
                            busquedaAvanzadaTest.setUp(tercero);
                            busquedaAvanzadaTest.mainTest();
                            busquedaAvanzadaTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "18": // r. Módulo de búsqueda de Siniestros Búsqueda simple
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_SiniestroBusquedaSimpleTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_SiniestroBusquedaSimpleTest busquedaSimpleTest = new VistaAsesuisa_SiniestroBusquedaSimpleTest();
                            busquedaSimpleTest.setUp(tercero);
                            busquedaSimpleTest.mainTest();
                            busquedaSimpleTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "19": // s. Generación de documentos en Siniestros.
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_GeneracionDocumentosSiniestrosTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_GeneracionDocumentosSiniestrosTest docSiniestros = new VistaAsesuisa_GeneracionDocumentosSiniestrosTest();
                            docSiniestros.setUp(tercero);
                            docSiniestros.mainTest();
                            docSiniestros.tearDown(tercero);
                        }catch (Exception e){
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "20": // t. Edición y modificación de Siniestros (varios OA).
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_EdicionModificacionSiniestroTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_EdicionModificacionSiniestroTest edicionSiniestro = new VistaAsesuisa_EdicionModificacionSiniestroTest();
                            edicionSiniestro.setUp(tercero);
                            edicionSiniestro.mainTest();
                            edicionSiniestro.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);
                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "21": // u. Propiedades Padre/Hijo
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "11": // 11) Trazas de auditoria.

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // NA a. Generación de trazas
                        System.out.println("Numero: " + tercero);
                        /*prueba = "Generar Traza";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_GenerarTrazaTest generarTraza = new VistaAsesuisa_GenerarTrazaTest();
                            generarTraza.setUp(tercero);
                            generarTraza.mainTest();
                            generarTraza.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        */
                        break;
                    case "2": // NA b. Detalle de las trazas
                        System.out.println("Numero: " + tercero);
                        /*prueba = "MostrarDetalleauditoria";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaTrazaDetalleAuditoriaTest vistaTrazaDetalleAuditoria = new VistaTrazaDetalleAuditoriaTest();
                            vistaTrazaDetalleAuditoria.setUp(tercero);
                            vistaTrazaDetalleAuditoria.mainTest();
                            vistaTrazaDetalleAuditoria.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        */
                        break;
                    case "3": // NA c. Exportar documentos ( Exportar en Excel y Pdf) - Incluye la validación detallada de los reportes
                        System.out.println("Numero: " + tercero);
                        /*prueba = "Exportar traza auditoria";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_ExportarTrazaAuditoriaTest vistaExportarTrazaAuditoria = new VistaAsesuisa_ExportarTrazaAuditoriaTest();
                            vistaExportarTrazaAuditoria.setUp(tercero);
                            vistaExportarTrazaAuditoria.mainTest();
                            vistaExportarTrazaAuditoria.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        */
                        break;
                }
                break;

            case "12": // 12) Export/Import de Tablas Dinámicas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Export de Tablas Dinámicas
                        System.out.println("Numero: " + tercero);
                        prueba = "VistaAsesuisa_TablaDinamicaExportTest";
                        log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                        try {
                            VistaAsesuisa_TablaDinamicaExportTest vistaAsesuisaTablaDinamicaExportTest = new VistaAsesuisa_TablaDinamicaExportTest();
                            vistaAsesuisaTablaDinamicaExportTest.setUp(tercero);
                            vistaAsesuisaTablaDinamicaExportTest.mainTest();
                            vistaAsesuisaTablaDinamicaExportTest.tearDown(tercero);
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error("Test Case - " + prueba + " - " + e);

                        }
                        log.info("--->>> Final de la prueba " + prueba);
                        break;
                    case "2": // b. Import de Dinámicas
                        System.out.println("Numero: " + tercero);
                        break;
                    case "3": // c. Uso de Tablas Dinámicas Importadas
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "13": // 13) Export/Import de producto.

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Export de producto
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. Import de producto
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "14": // 14) Creación manual de OpenItems

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "15": // 15) Módulo de Cúmulos

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "16": // 16) Endosos

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "17": // 17) Preliquidación, Liquidación de Terceros, y Ctas Tecnicas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Preliquidación de Terceros
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. Liquidación de Terceros
                        System.out.println("Numero: " + tercero);
                        break;
                    case "3": // c. Liquidacion de cuenta tecnica
                        System.out.println("Numero: " + tercero);
                        break;
                    case "4": // d. Consulta de cuenta tecnica
                        System.out.println("Numero: " + tercero);
                        break;
                    case "5": // e. Previsualizacion de cuenta tecnica
                        System.out.println("Numero: " + tercero);
                        break;
                    case "6": // f. Validación de ctas técnicas liquidadas
                        System.out.println("Numero: " + tercero);
                        break;
                    case "7": // g. Consulta de terceros liquidados
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "18": // 18) Product Tool

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Validaciones a nivel de ROL, TOMADOR Y POLIZA.
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "19": // 19) Validaciones Adicionales:

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Configurador de Movimientos y Generación de Movimientos (entry tool)  AEASESUISA-2871
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. Validación de Movimientos y Generación de Movimientos (entry tool)  AEASESUISA-2871
                        System.out.println("Numero: " + tercero);
                        break;
                    case "3": // c. Creación de Inspecciones
                        System.out.println("Numero: " + tercero);
                        break;
                    case "4": // d. Consultas de Inspecciones
                        System.out.println("Numero: " + tercero);
                        break;
                    case "5": // e. Edición de Inspecciones
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "20": // 20) Reaseguros

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Distribución de componentes de reaseguros
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. Liquidación de Reaseguro
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "21": // 21) Coaseguro

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. Liquidación de coaseguros
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. Consulta de coaseguros
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "22": // 17) Template Tool

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a.Transformadores revisión general
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. eliminar transformadores
                        System.out.println("Numero: " + tercero);
                        break;
                    case "3": // c. incluir transformadores manual
                        System.out.println("Numero: " + tercero);
                        break;
                    case "4": // d. importar transformadores de un archivo
                        System.out.println("Numero: " + tercero);
                        break;
                    case "5": // e. Incluir etiqueta a transformador
                        System.out.println("Numero: " + tercero);
                        break;
                    case "6": // f. Propiedades tipo listas
                        System.out.println("Numero: " + tercero);
                        break;
                    case "7": // g. Formulaciones de Vaadin
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            /*case "22": // 22) Cuentas Tecnicas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": // a. liquidacion de cuenta tecnica
                        System.out.println("Numero: " + tercero);
                        break;
                    case "2": // b. consulta de cuenta tecnica
                        System.out.println("Numero: " + tercero);
                        break;
                    case "3": // c. previsualizacion de cuenta tecnica
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;
            */
            case "23": // 23) Envio de notificación por evento de pólizas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "24": // 24) Criterios y Agrupamientos de asientos contables

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "25": // 25) Consulta de Siniestro (modulo nuevo)

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "26": // 26) Aprobar notificaciones que se encuentren en la bandeja de entrada de Acsel-e para operaciones de póliza

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "27": // 27) Cuentas contables

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "28": // 28) Recuperacion de polizas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "29": // 29) Cuentas bancarias

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "30": // 30) Previsualización de facturas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "31": // 31) Movimientos de Pólzias

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "32": // 32) Cuota Comodin

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "33": // 33) Generación de TVG

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "34": // 34) Maduración de Pólizas

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "35": // 35) Prestamos automáticos

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            case "36": // 36) Prestamos documentados

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;
            case "37": // 36) Prestamos documentados

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;
            case "38": // 36) Emision poliza userStory 30282

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "VistaAsesuisa_PolizaEmisionGeneral30282Test";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {
                    VistaAsesuisa_PolizaEmisionGeneral30282Test polizaEmisionGeneral30282Test = new VistaAsesuisa_PolizaEmisionGeneral30282Test();
                    polizaEmisionGeneral30282Test.setUp(segundo);
                    polizaEmisionGeneral30282Test.mainTest();
                    polizaEmisionGeneral30282Test.tearDown(segundo);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + prueba + " - " + e);
                }
                log.info("--->>> Final de la prueba " + prueba);

                break;

            default:
                log.info("--->>> No se ha seleccionado ninguna prueba o el valor de la misma es incorrecto");
                break;

            /*case "18": // 18) Product Tool

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);
                switch (segundo){
                    case "1": //
                        System.out.println("Numero: " + tercero);
                        break;
                }
                break;

            case "36": // 36) Prestamos documentados

                System.out.println("Caso: " + args[0]);
                System.out.println("Bloque: " + segundo);

                prueba = "";
                log.info("--->>> Ejecutando la prueba " + segundo + " " + prueba);
                try {

                    //.setUp(segundo);
                    //.mainTest();
                    //.tearDown(segundo);
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
