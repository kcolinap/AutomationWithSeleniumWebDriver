package AcseleV13_8_Interseguros.main.controller.Interseguros_Menu;

import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

/**
 * Created by agil on 25/07/2016.
 */
public class Interseguros_MenuMantenimiento {

    protected ThreadLocal<WebDriver> threadDriver = null;

    private final static Logger log = Logger.getLogger(Interseguros_MenuMantenimiento.class);

    Interseguros_Metodos a = new Interseguros_Metodos();

    /** Mantenimiento de Tercero (Wcontroller) **/
    public void MantenimientoTerceroWcontroller(){}
    /** -- Mantenimiento de Tercero (Wcontroller) -- **/

    /** Mantenimiento de Tercero **/


        public void MantTerc_IngresarTerceroFrontEnd(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

            try {
                Actions action = new Actions(driver);
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[2]")); // Mantenimiento de Tercero (FrontEnd)
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[37]/div[1]")); // Nuevo (FrontEnd)
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
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }
        }

    public void MantTerc_BuscarTercero(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[44]")); // Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[34]/div[2]")); // Mantenimiento de Tercero (FrontEnd)
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[35]/div[2]")); // Buscar (FrontEnd)
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
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    /** -- Mantenimiento de Tercero -- **/

    /** Declaracion Personal de Salud (DPS) **/
        public void DecPersSalDPS_Creacion(){}
    /** -- Declaracion Personal de Salud (DPS) -- **/

    /** Busqueda DPS **/
    public void BusquedaDPS(){}
    /** -- Busqueda DPS -- **/

    /** Busqueda DPS (Vaadin) **/
    public void BusquedaDPSVaadin(){}
    /** -- Busqueda DPS (Vaadin) -- **/

    /** Administracion de Litas Negras **/
    public void AdministracionLitasNegras(){}
    /** -- Administracion de Litas Negras -- **/

    /** UAA (Administracion de Cuentas Universal) **/
        public void UAA_HerenciRoles(){}
        public void UAA_Documentos(){}
        public void UAA_RolesDocumentos(){}

        public void UAA_Caja(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

            try {
                Actions action = new Actions(driver);
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[7]")); // UAA (Administrador de Cuentas Universal)
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[39]/div[4]")); // Caja
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
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }
        }

        public void UAA_AsociarCajaCajero(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){
            try {
                Actions action = new Actions(driver);
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[7]")); // UAA (Administrador de Cuentas Universal)
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[39]/div[5]")); // Asociar Caja con Cajero
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
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }
        }

        public void UAA_Moneda(){}
        public void UAA_TasaCambio(){}
        public void UAA_Banco(){}
        public void UAA_Instituciones(){}
        public void UAA_InstitucionesVaadin(){}
        public void UAA_Ciudades(){}
        public void UAA_Estados(){}
        public void UAA_Paises(){}
        /** Facturacion **/
            public void UAA_Fac_DosificacionFacturas(){}
            public void UAA_Fac_ModalidadFacturas(){}
        /** Facturacion **/
        public void UAA_AgrupadoresAsientosContables(){}
    /** -- UAA (Administracion de Cuentas Universal) -- **/

    /** Mantenimiento General **/

        public void MantGeral_TablasDinamicas(WebDriver driver, String nombreAutomatizacion, int numScreenShot){
            try {
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[8]")); // Mantenimiento General
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[43]/div[1]")); // Tablas Dinámicas
                menu1.click();
                menu2.click();
                a.ScreenShot(driver, "screen" + numScreenShot, nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();
                menu3.click();
            }catch (Exception e){
                e.printStackTrace();
                log.error("Test Case 25 - " + nombreAutomatizacion + " - " + e);
            }
        }
        public void MantGeral_TablasEstaticas(){}
        public void MantGeral_CambioMasivoViasCobro(){}
        public void MantGeral_AdministradorCalendario(){}
        public void MantGeral_GeneracionAsientosContables(){}
        public void MantGeral_RegeneracionAsientosContables(){}
        public void MantGeral_ReporteAsientosContables(){}
        public void MantGeral_EditorDocumentos(){}
        public void MantGeral_ImpresionDocumentos(){}
        public void MantGeral_Disparadores(){}
        public void MantGeral_ConfiguradorDirecciones(){}
        public void MantGeral_RechazarASL(){}
        public void MantGeral_ImprimirDocumentosBienvenida(){}
        public void MantGeral_HistoricoDocumentos(){}
        public void MantGeral_RecuperacionDocumentos(){}
        public void MantGeral_MantenimientoRequeisitos(){}
        public void MantGeral_DescargaLogs(){}
        public void MantGeral_CierresMensuales(){}
        public void MantGeral_EditorNotificaciones(){}
        public void MantGeral_TablasDimanicasVaadin(){}
    /** -- Mantenimiento General -- **/

    /** Administracion de Tareas **/
        public void AdminTar_Actividades(WebDriver driver, String nombreAutomatizacion, int numScreenShoot){

            try {
                Actions action = new Actions(driver);
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[9]"));// Administrador de Tareas
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[44]/div[1]"));// Actividades
                Thread.sleep(1000);

                //menu1.click();
                //menu2.click();
                action.moveToElement(menu1).build().perform();
                action.moveToElement(menu2).build().perform();
                action.moveToElement(menu3).build().perform();

                Thread.sleep(1000);
                a.ScreenShot(driver, "screen" + numScreenShoot, nombreAutomatizacion);
                Thread.sleep(1000);
                menu3.click();


            }catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }
        }
        public void AdminTar_EjecucionTareas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot){

            try {
                Actions action = new Actions(driver);
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[9]"));// Administrador de Tareas
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[44]/div[2]"));// Actividades
                Thread.sleep(1000);

                //menu1.click();
                //menu2.click();
                action.moveToElement(menu1).build().perform();
                action.moveToElement(menu2).build().perform();
                action.moveToElement(menu3).build().perform();

             //   Thread.sleep(1000);
                a.ScreenShot(driver, "screen" + numScreenShoot, nombreAutomatizacion);
                Thread.sleep(1000);
                menu3.click();


            }catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            }
        }
        public void AdminTar_AgendaProcesos(){}
        public void AdminTar_HistoricoProcesos(){}
        public void AdminTar_ConfigurarProcesosTipoArchivo(){}
    /** -- Administracion de Tareas -- **/

    /** Auditoria **/
        public void Aud_MantenimientoAuditoria(){}
        public void Aud_MantenimientoSLA(){}
        public void Aud_TrazasAuditoria(){}
        public void Aud_TrazasAuditoriaVaadin( WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

            try {

            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[10]")); // Auditoria
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[45]/div[4]")); // Trazas de Auditoria (Vaadin)
            menu1.click();
            menu2.click();
            Thread.sleep(1000);
            action.moveToElement(menu3).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            menu3.click();
        }catch (Exception e){
        e.printStackTrace();
        log.error("Test Case - " + nombreAutomatizacion + " - " + e);
    }
}


    /** -- Auditoria -- **/

    /** HCM **/
        public void HCM_MantenimientoEnfermedades(){}
        public void HCM_MantenimientoTiposAutorizacion(){}
        public void HCM_BeneficiosMedicos(){}
        public void HCM_MantenimientoTratamientos(){}
        public void HCM_MantenimientoEspecialidades(){}
        public void HCM_AsociacionDoctoresClinicas(){}
        public void HCM_AsociarTratamientosEnfermedades(){}
    /** -- HCM -- **/

    /** Fianza **/
        public void Fianza_MantenimientoTipoGarantia(){}
    /** -- Fianza -- **/

    /** Solicitud de Inspecciones **/
        public void SolInsp_TiposSolicitudInspeccion(){}
        public void SolInsp_Informes(){}
        public void SolInsp_ConfiguracionSolicitudesInspeccion(){}
    /** -- Solicitud de Inspecciones -- **/

    /** Tablas Actuariales **/
        public void TabAct_TablasMortalidad(){}
        public void TabAct_TasasIndependientes(){}
    /** -- Tablas Actuariales -- **/

    /** Administracion Central de Riesgo **/
    public void AdministracionCentralRiesgo(){}
    /** -- Administracion Central de Riesgo -- **/

    /** Administracion de Listas Restrictivas **/
    public void AdminLisRest_CrearListasRestrictivas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));  // Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[16]"));// Administracion de Listas Restrictivas
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[50]/div[1]")); // Crear Listas Restrictivas

            menu1.click();
            menu2.click();
            Thread.sleep(1000);
            action.moveToElement(menu3).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i,  "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Thread.sleep(100);
            menu3.click();

        } catch (Exception e){
            e.printStackTrace();
            log.error("Menu listas Restrictivas " + e);
        }
    }
        public void AdminLisRest_CoincidenciaListasRestrictivas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){

            try {
                Actions action = new Actions(driver);
                WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
                WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[16]"));//Administrador de Listas Restrictivas
                WebElement menu3 = driver.findElement(By.xpath("/html/body/div[50]/div[2]"));// Coincidencia Listas Restrictivas
                menu1.click();
                menu2.click();
                Thread.sleep(1000);
                action.moveToElement(menu3).build().perform();
                this.a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion ); //screenshot2
                Thread.sleep(1000);
                menu3.click();

            } catch (Exception e){
                e.printStackTrace();
                log.error("Menu listas Restrictivas " + e);
            }


        }
        public void AdminLisRest_ConfiguracionPropiedades(){}
    /** -- Administracion de Listas Restrictivas -- **/

}
