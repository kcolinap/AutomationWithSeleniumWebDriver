package AcseleV13_8_Interseguros.main.controller.Interseguros_Menu;

import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 25/07/2016.
 */
public class Interseguros_MenuOperaciones {

    protected ThreadLocal<WebDriver> threadDriver = null;

    private final static Logger log = Logger.getLogger(Interseguros_MenuOperaciones.class);

    Interseguros_Metodos a = new Interseguros_Metodos();

    /** Operaciones (Workflow) **/

    public void OperacionesWorkflow(){}

    /** -- Operaciones (Workflow) -- **/



    /** Operaciones Polizas **/

    public void OpePol_CrearWController(){}

    public void OpePol_Crear(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]")); // Operación
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]")); // Cotización - Suscripción - Edición
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[4]/div[2]")); // Crear (FrontEnd)
            menu1.click();
            menu2.click();
            Thread.sleep(1000);
            action.moveToElement(menu3).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            menu3.click();
        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void OpePol_CrearCotizacion(){}

    public void OpePol_BusquedaCotizaciones(){}

    public void OpePol_SuscripcionMantenimientoPolizasWController(){}

    public void OpePol_CotizacionSuscripcionMantenimientoPolizas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot){
        try{
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]"));// Operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operaciones polizas
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[4]/div[6]"));// Cotización-Suscripción-Mantenimiento de Pólizas
            action.moveToElement(menu1).build().perform();
            action.moveToElement(menu2).build().perform();
            action.moveToElement(menu3).build().perform();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            menu3.click();

        }catch (Exception e) {
            e.printStackTrace();
            //                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void OpePol_BusquedaSolicitud(){}

    public void OpePol_AdministracionCuotasComodin(){}

    public void OpePol_EmisionMasivaPropuestas(){}

    public void OpePol_RecuperacionOperacionesPendientesWController(){}

    public void OpePol_RecuperacionOperacionesPendientes(){}

    /** OpePol_EndososMasivos **/
    public void OpePol_EndososMasivos_IncluirExcluirCoberturas(){}

    public void OpePol_EndososMasivos_CambioPlan(){}
    /** -- OpePol_EndososMasivos -- **/

    public void OpePol_CargaASL(){}

    public void OpePol_ultimaOperacionReserva(){}

    public void OpePol_ProcesoCancelacionPorFaltaPago(){}

    /** OpePol_PolizasArchivosProcesados **/
    public void OpePol_ArchivosProcesados_ListaArchivosProcesados(){}

    public void OpePol_ArchivosProcesados_ReordenarArchivos(){}

    public void OpePol_ArchivosProcesados_AplicarAccionMasiva(){}
    /** -- OpePol_PolizasArchivosProcesados -- **/

    public void OpePol_BusquedaDocumentos(){}

    /** OpePol_PolizasMasivo **/
    public void OpePol_PolizasMasivo_Importar(){}

    public void OpePol_PolizasMasivo_Exportar(){}

    public void OpePol_PolizasMasivo_HistoricoPolizasRechazadas(){}
    /** -- OpePol_PolizasMasivo -- **/

    public void OpePol_CotizacionesPendientes(){}
    /**  -- Operaciones Polizas --  **/




    /** Operaciones Siniestros**/

    public void OpeSini_DeclaracionSiniestro(){}

    public void OpeSini_MantenimientoSiniestro(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i) {

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[2]"));//mantenimiento siniestro

            menu1.click();
            menu2.click();
            Thread.sleep(1000);

            action.moveToElement(menu3).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2

            menu3.click();
        }catch (Exception e) {
            e.printStackTrace();
            //                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void OpeSini_CreacionSiniestroFrontEnd(){}

    public void OpeSini_NotificacionSiniestro(){}

    public void OpeSini_MantenimientoSiniestroVaadin(){}

    public void OpeSini_CreacionSiniestro(WebDriver driver, Interseguros_Metodos a,  String nombreAutomatizacion, int numScreenShoot, int i){
        try{
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[6]"));//crear siniestro

            menu1.click();
            menu2.click();
            Thread.sleep(1000);
            action.moveToElement(menu3).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Thread.sleep(1000);
            menu3.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void OpeSini_Recuperaciones(){}

    public void OpeSini_MantenimientoRecuperacion(){}

    public void OpeSini_CargaSiniestrosAPartirDeUnaMediaExternaASL(){}

    public void OpeSini_BuscadorSiniestrosPendientes(){}

    public void OpeSini_ActividadesPendientesReclamo(){}

    public void OpeSini_HistorialActividadesReclamo(){}

    public void OpeSini_HistorialReclamo(WebDriver driver, String nombreAutomatizacion, int i){

        try{

            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[13]"));//historial reclamos

            menu1.click();
            menu2.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);
            menu3.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void OpeSini_ArchivosProcesadosPorASLClaim(){}

    public void OpeSini_SiniestrosPorProcesar(){}

    public void OpeSini_BusquedaDocumentos(){}

    public void OpeSini_LiquidacionSiniestro(){}

    public void OpeSini_DeclaracionCartaGarantia(){}

    public void OpeSini_AuditarCartaGarantia(){}

    public void OpeSini_SiniestrosLiquidadosPorUsuarios(){}

    public void OpeSini_ConsultaOrdenesPago(){}

    public void OpeSini_GeneracionPlanillasLiquidacionPagos(){}

    /** -- Operaciones Siniestros -- **/



    /** Coaseguro Reaseguro **/

    public void CoaRea_OperacionConsultaReaseguros(){}

    public void CoaRea_MantenimientoDistribucionReaseguro(){}

    public void CoaRea_ContratoFacultativo(){}

    /** CoaRea_CuentasTecnicas **/
    public void CoaRea_CuentasTecnicas_LiquidacionCuentaTecnica(){}
    public void CoaRea_CuentasTecnicas_ConsultaCuentaTecnica(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

        try{
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));//coaseguro reaseguro
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[9]/div[4]"));//cuentas tecnicas
            WebElement menu4 = driver.findElement(By.xpath("/html/body/div[10]/div[2]"));//consulta de cuenta tecnica
            action.moveToElement(menu1).build().perform();
            action.moveToElement(menu2).build().perform();
            action.moveToElement(menu3).build().perform();
            action.moveToElement(menu4).build().perform();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            menu4.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
    public void CoaRea_CuentasTecnicas_PrevisualizacionCuentasTecnicas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

        try{
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));//coaseguro reaseguro
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[9]/div[4]"));//cuentas tecnicas
            WebElement menu4 = driver.findElement(By.xpath("/html/body/div[10]/div[3]"));//previsuaalizacion de cuenta tecnica
            action.moveToElement(menu1).build().perform();
            action.moveToElement(menu2).build().perform();
            action.moveToElement(menu3).build().perform();
            action.moveToElement(menu4).build().perform();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            menu4.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
    /** -- CoaRea_CuentasTecnicas -- **/

    public void CoaRea_LiquidacionCoasegurador(){}

    public void CoaRea_LiquidacionReaseguro(){}

    public void CoaRea_UtilidadesReaseguro(){}

    public void CoaRea_BusquedaLiquidacionReaseguro(){}

    public void CoaRea_ConsultaCoaseguros(){}

    public void CoaRea_SiniestrosCoaseguroContado(){}

    public void CoaRea_HisturicoReaseguro(){}

    public void CoaRea_ConsultaReaseguroPolizaMaestra(){}

    public void CoaRea_PrimasDepositoReaseguro(){}

    public void CoaRea_ConsultaSiniestrosContratosNoProporcionales(){}

    public void CoaRea_ReinstalacionLimiteAgregadoAnual(){}

    public void CoaRea_AjustePrimasReaseguro(){}

    public void CoaRea_FraccionamientoReaseguradoresFacultativos(){}

    /** -- Coaseguro Reaseguro -- **/



    /** UAA (Administrador de Cuentas Universal) **/

    /** Caja **/
    public void UAA_Caja_AperturaCaja(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]")); // Operación
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[3]/div[5]")); // UAA (Administrador de Cuentas Universal))
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[11]/div[1]")); // Caja
            WebElement menu4 = driver.findElement(By.xpath("/html/body/div[12]/div[1]")); // Apertura de Caja
            menu1.click();
            menu2.click();
            menu3.click();
            Thread.sleep(1000);
            action.moveToElement(menu4).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            menu4.click();
        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void UAA_Caja_InicioSesion(){}

    public void UAA_Caja_AplicacionCobro(){}

    public void UAA_Caja_ConsultaOperacionesCobranza(){}

    public void UAA_Caja_ReversoRecaudacion(){}

    public void UAA_Caja_AplicacionPagoSobreIngresosNoImputados(){}

    public void UAA_Caja_Reportes(){}

    public void UAA_Caja_SaldoDiarioPorCajero(){}

    public void UAA_Caja_ReAperturaCaja(){}

    public void UAA_Caja_CierreSesion(){}

    public void UAA_Caja_CierreVariosCajeros(){}

    public void UAA_Caja_CierreCaja(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i) {

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]")); // Operación
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[3]/div[5]")); // UAA (Administrador de Cuentas Universal))
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[11]/div[1]")); // Caja
            WebElement menu4 = driver.findElement(By.xpath("/html/body/div[12]/div[12]")); // Cierre de Caja
            menu1.click();
            menu2.click();
            menu3.click();
            Thread.sleep(1000);
            action.moveToElement(menu4).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            menu4.click();
        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void UAA_Caja_PrimasPagadasACancelar(){}

    public void UAA_Caja_PrimasPendientesACancelar(){}

    public void UAA_Caja_PrimasVencidasNoPagadasYFondosInversion(){}

    public void UAA_Caja_ConsultaFacturasGeneradas(){}

    /** -- Caja -- **/

    /** Facturacion y Cobro **/

    public void UAA_FactCobro_GeneracionAvisoCobro(){}
    public void UAA_FactCobro_ImportarArchivoValidacionPagos(){}
    public void UAA_FactCobro_RealizarRecaudacionMasiva(){}
    public void UAA_FactCobro_ReversoRecaudacionMasiva(){}
    public void UAA_FactCobro_CerrandoOperacionesManuales(){}
    public void UAA_FactCobro_ConsultaRecibosEnviadosAlCobro(){}
    public void UAA_FactCobro_GeneracionAvisoCobroMasivo(){}
    public void UAA_FactCobro_ProcesoPagosPorProducto(){}

    /** -- Facturacion y Cobro -- **/

    public void UAA_ModificacionMovimientosTercero(WebDriver driver, String nombreAutomatizacion, int i )throws IOException, InterruptedException{
        try{
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[5]"));//cumulos
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[13]/div[3]"));//cumulos terceros

            menu1.click();
            menu2.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);
            Thread.sleep(2000);
            menu3.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    /** Reportes **/
    public void UAA_Rep_ReporteAntiguedad(){}
    public void UAA_Rep_ContratantesMorosos(){}
    public void UAA_Rep_AvisosDeCobros(){}
    /** -- Reportes -- **/

    public void UAA_EstadosCuenta(){}

    /** Agentes **/
    public void UAA_Agentes_LiquidacionAgente(){}
    public void UAA_Agentes_ReversoLiquidacionAgente(){}
    public void UAA_Agentes_TraspasoDeCartera(){}
    /** -- Agentes -- **/

    public void UAA_LiquidacionTercero(){}

    public void UAA_ExportarMovimientosSAP(){}

    public void UAA_DevoluciunPrimaDepusito(){}

    public void UAA_NotificacionVencimiento(){}

    public void UAA_ReconciliacionPagoPrima(){}

    /** ConsultaMultimoneda **/
    public void UAA_ConsMulti_TasaCambio(){}
    public void UAA_ConsMulti_Moneda(){}
    /** -- ConsultaMultimoneda -- **/

    public void UAA_AgrupacionAsientosContables(){}

    /** UAA (Administrador de Cuentas Universal) **/




    /** Reportes **/
    public void Repor_ReportesGenerales(){}
    public void Repor_ImprimirReportesPorLotes(){}
    public void Repor_ReportesGenerados(){}
    public void Repor_MantenimientoReportes(){}
    /** -- Reportes -- **/





    /** Fondos de Inversion **/
    public void Inv_Adquisicion(){}
    public void Inv_EstadoCuentaFondos(){}
    public void Inv_OperacionesCambios(){}
    /** -- Fondos de Inversion -- **/





    /** Solicitud de Inspecciones **/
    public void SolicitudInspecciones(){}
    /** -- Solicitud de Inspecciones -- **/



    /** Operaciones de Vida **/
    public void OpeVida_SaldarOProrrogar(){}
    public void OpeVida_MostrarReservas(){}
    public void OpeVida_MostrarPrestamosWController(){}
    public void OpeVida_MostrarPrestamos(){}
    public void OpeVida_RescateWController(){}
    public void OpeVida_Rescate(){}
    public void OpeVida_MostrarLogsReserva(){}
    public void OpeVida_ConsultarTablasFlujo(){}
    /** -- Operaciones de Vida -- **/




    /** Administracion de Cotizaciones **/
    public void AdminCoti_NuevaCotizacion(){}
    public void AdminCoti_BuscarCotizacion(){}
    public void AdminCoti_BuscarPoliza(){}
    /** -- Administracion de Cotizaciones -- **/




    /** Cumulos **/
    public void Cumulos_CumulosPorTerceros(WebDriver driver, String nombreAutomatizacion, int i ) throws IOException, InterruptedException{

        try{
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[11]"));//cumulos
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[24]/div[1]"));//cumulos terceros

            menu1.click();
            menu2.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);
            Thread.sleep(2000);
            menu3.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
    public void Cumulos_CumulosPorProducto(WebDriver driver, String nombreAutomatizacion, int i)throws IOException, InterruptedException{
        try{
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[11]"));//cumulos
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[24]/div[2]"));//cumulos productos

            menu1.click();
            menu2.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);
            Thread.sleep(2000);
            menu3.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
    public void Cumulos_CumulosPorAsegurado(WebDriver driver, String nombreAutomatizacion, int i)throws IOException, InterruptedException{
        try{

            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[11]"));//cumulos
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[24]/div[3]"));//cumulos asegurado

            menu1.click();
            menu2.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);
            Thread.sleep(3000);
            menu3.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
    /** -- Cumulos -- **/




    /** Operaciones de Renta **/
    public void OperaRenta_OperacionesRentaVitalicia(){}
    /** -- Operaciones de Renta -- **/




    /** Consultar en Lista Restrictiva **/
    public void ConsultarListaRestrictiva(WebDriver driver, String nombreAutomatizacion, int i)throws IOException, InterruptedException{
        try{

            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[13]"));//consulta listas restrictivas


            menu1.click();
            a.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion);
            Thread.sleep(4000);
            menu2.click();
            Thread.sleep(2000);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
    /** -- Consultar en Lista Restrictiva -- **/



    /** Facturacion Automatica **/
    public void FactAut_GeneracionFacturacionAutomatica(){}
    public void FactAut_ConsultaFacturacion(){}
    public void FactAut_LogProcesamiento(){}


    /** -- Facturacion Automatica -- **/

}
