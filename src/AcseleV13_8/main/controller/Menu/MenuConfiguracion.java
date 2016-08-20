package AcseleV13_8.main.controller.Menu;

import AcseleV13_8.main.controller.Metodos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by agil on 25/07/2016.
 */
public class MenuConfiguracion {

    protected ThreadLocal<WebDriver> threadDriver = null;

    private final static Logger log = Logger.getLogger(MenuConfiguracion.class);

    Metodos a = new Metodos();
    //27

    /** Plantillas (Modo Privilegiados) **/
    public void PlantillasModoPrivilegiados (){}
    /** -- Plantillas (Modo Privilegiados) -- **/

    /** Plantillas (Modo no Privilegiados) **/
    public void PlantillasModoNoPrivilegiados(){}
    /** -- Plantillas (Modo no Privilegiados) -- **/

    /** Configuracion de Propiedades Eventos Masivos **/
    public void ConfiguracionPropiedadesEventosMasivos(){}
    /** -- Configuracion de Propiedades Eventos Masivos -- **/

    /** Mantenimiento de Producto (Applet) **/
    public void MantenimientoProductoApplet(){}
    /** -- Mantenimiento de Producto (Applet) -- **/

    /** Mantenimiento de Producto **/

    public void MantenimientoProducto(Metodos a, WebDriver driver, String nombreAutomatizacion) {

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]"));//configuracion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[26]/div[5]"));//mantenimiento productos
            Thread.sleep(1000);

            action.moveToElement(menu1).build().perform();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);
            Thread.sleep(1000);
            menu2.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
    /** -- Mantenimiento de Producto -- **/


    /** Configuracion de Eventos **/
        public void ConfigEventos_Recargos(){}
    /** -- Configuracion de Eventos -- **/

    /** Configuracion de Procesos **/
        public void ConfigProcesos_RegistroApp(){}
        public void ConfigProcesos_ConstructorWorkflow(){}
    /** -- Configuracion de Procesos -- **/

    /** Configuracion de Cotizaciones **/
    public void ConfiguracionCotizaciones(){}
    /** -- Configuracion de Cotizaciones -- **/

    /** Reaseguro Coaseguro **/
        public void ReaCoa_RamoReaseguro(){}
        public void ReaCoa_ClaseRiesgo(){}
        public void ReaCoa_ContratosReaseguro(){}
        public void ReaCoa_ContratoFacultativo(){}
        public void ReaCoa_GruposCoaseguro(){}
        public void ReaCoa_contratoCoaseguro(){}
        public void ReaCoa_GruposReaseguro  (){}
        public void ReaCoa_ClausulasReaseguro(){}
    /** -- Reaseguro Coaseguro -- **/

    /** Sieniestro **/
        public void Siniestro_MantenimientoEvento(){}
        public void Siniestro_Estadisticas(){}
        public void Siniestro_ReservasPorConcepto(){}
        public void Siniestro_OrdenCompra(){}
        public void Siniestro_Facturacion(){}
    /** -- Sieniestro -- **/

    /** Movimientos de Contabilidad **/
    public void MovimientosContabilidad(){}
    /** -- Movimientos de Contabilidad -- **/

    /** Propiedades del Sistema **/
        public void PropSis_EditorPropriedades(){}
        public void PropSis_EditorEtiquetas(){}
    /** -- Propiedades del Sistema -- **/

    /** Fondos de Inversion **/
        public void FondosInv_ConfigurarFondosInversion(){}
        public void FondosInv_TiposFondos(){}
    /** -- Fondos de Inversion -- **/

    /** Polizas Maestras (Acuerdos) **/
    public void PolizasMaestrasAcuerdos(){}
    /** -- Polizas Maestras (Acuerdos) -- **/

    /** Configuracion de Red Comercial **/
    public void ConfiguracionRedComercial(){}
    /** -- Configuracion de Red Comercial -- **/

    /** Registros de Servicios Web Externos **/
    public void RegistrosServiciosWebExternos(){}
    /** -- Registros de Servicios Web Externos -- **/

    /** (Nuevo) Movimientos de Contabilidad **/
    public void NuevoMovimientosContabilidad(){}
    /** -- (Nuevo) Movimientos de Contabilidad -- **/

    /** (Nuevo) Plantillas (Modo No Privilegiado) **/

    public void NuevoPlantillasModoNoPrivilegiado(Metodos a, WebDriver driver, String nombreAutomatizacion) {

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]"));//configuracion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[26]/div[18]"));//NuevoPlantillasModoNoPrivilegiado
            Thread.sleep(1000);

            action.moveToElement(menu1).build().perform();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);
            Thread.sleep(1000);
            menu2.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
    /** -- (Nuevo) Plantillas (Modo No Privilegiado) -- **/

    /** (Nuevo) Plantillas (Modo Privilegiado) **/
    public void NuevoPlantillasModoPrivilegiado(){}
    /** -- (Nuevo) Plantillas (Modo Privilegiado) -- **/

    /** Configuracion de Ciclo de Vida **/
    public void ConfiguracionCicloVida(){}
    /** -- Configuracion de Ciclo de Vida -- **/

    /** Subir Configuracion XLSX para ASL **/
    public void SubirConfiguracionXLSXParaASL(){}
    /** -- Subir Configuracion XLSX para ASL -- **/

    /** Bidireccionalidad de las Relaciones entre Terceros **/
    public void BidireccionalidadRelacionesEntreTerceros(){}
    /** -- Bidireccionalidad de las Relaciones entre Terceros -- **/

    /** Configuracion de Procesos Masivos **/
    public void ConfiguracionProcesosMasivos(){}
    /** -- Configuracion de Procesos Masivos -- **/

    /** Administracion de Recargos **/
        public void AdminiRecargos_MotivosRecargados(){}
        public void AdminiRecargos_TiposRecargados(){}
    /** -- Administracion de Recargos -- **/

    /** Configuracion de Criterios de Busqueda **/
    public void ConfiguracionCriteriosBusqueda(){}
    /** -- Configuracion de Criterios de Busqueda -- **/

    /** Validacion Existencia de Riesgo **/
    public void ValidacionExistenciaRiesgo(){}
    /** -- Validacion Existencia de Riesgo -- **/

    /** Configuracion UAA **/
        public void ConfigUAA_TasaCambio(){}
    /** -- Configuracion UAA -- **/

    
}
