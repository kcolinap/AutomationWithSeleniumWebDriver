package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionTomadoresBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_InformacionGeneralPoliza;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_PrePoliza;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_Tomador;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

/**
 * Created by agil on 16/05/2017.
 */
public class Asesuisa_PolizaEmisionTomadores {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionTomadores.class);

    public String nombreAutomatizacion = "Asesuisa Emision Tomadores";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionTomadoresBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();
            Asesuisa_PrePoliza prePoliza = new Asesuisa_PrePoliza();
            Asesuisa_InformacionGeneralPoliza informacionGeneralPoliza = new Asesuisa_InformacionGeneralPoliza();
            Asesuisa_Tomador tomador = new Asesuisa_Tomador();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            menuOperaciones.OpePol_CotizacionSuscripcionEdicionCrearFrontEnd(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza */

            Thread.sleep(3000);
            prePoliza.AdministracionPropuestaPoliza(a, driver, bean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);
            prePoliza.EvAplicar(a, driver, bean, nombreAutomatizacion, i, folderName, 4);
            Thread.sleep(2000);
            informacionGeneralPoliza.InformacionGeneralAutomotores(a, driver, bean, nombreAutomatizacion, i, folderName, 5, 6, 7);
            Thread.sleep(2000);
            tomador.AgregarTomador(a, driver, bean, nombreAutomatizacion, i, folderName, 8, 9);
            Thread.sleep(2000);
            EditarTomador(a, driver, bean, nombreAutomatizacion, i, folderName, 10, 11, 12);
            EliminarTomador(a, driver, bean, nombreAutomatizacion, i, folderName, 13, 14, 15);


            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void EditarTomador (Metodos a, WebDriver driver, Asesuisa_PolizaEmisionTomadoresBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot,
                               int numScreenShoot2, int numScreenShoot3) {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);

            WebElement seleccionaTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_1_Checked']"));
            seleccionaTomador.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            //Thread.sleep(3000);

            WebDriverWait wait1 = new WebDriverWait(driver, 1);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']")));

            WebElement porcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            porcentaje.clear();
            Thread.sleep(1000);
            porcentaje.sendKeys(bean.getTomadorPorcentajeEditar());

            Thread.sleep(1000);
            WebElement agrgarModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            agrgarModoPago.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            a.waitSearchWicket(driver, "Guardar Tomador Editado");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EliminarTomador (Metodos a, WebDriver driver, Asesuisa_PolizaEmisionTomadoresBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot,
                               int numScreenShoot2, int numScreenShoot3) {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);

            WebElement seleccionaTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            seleccionaTomador.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnEliminar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_DeleteButton']"));
            btnEliminar.click();

            WebDriverWait wait1 = new WebDriverWait(driver, 1);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']")));

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            a.waitSearchWicket(driver, "Eliminando Tomador");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
