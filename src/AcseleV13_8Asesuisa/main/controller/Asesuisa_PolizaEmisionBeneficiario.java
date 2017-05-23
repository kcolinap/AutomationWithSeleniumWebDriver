package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionBeneficiarioBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.*;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by agil on 17/05/2017.
 */
public class Asesuisa_PolizaEmisionBeneficiario {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizaEmisionBeneficiario.class);

    public String nombreAutomatizacion = "Asesuisa Emision Beneficiario";
    private WebDriver driver;

    public void testLink(Asesuisa_PolizaEmisionBeneficiarioBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();
            Asesuisa_PrePoliza prePoliza = new Asesuisa_PrePoliza();
            Asesuisa_InformacionGeneralPoliza informacionGeneralPoliza = new Asesuisa_InformacionGeneralPoliza();
            Asesuisa_Tomador tomador = new Asesuisa_Tomador();
            Asesuisa_UnidadRiesgo unidadRiesgo = new Asesuisa_UnidadRiesgo();
            Asesuisa_ObjetoAsegurado objetoAsegurado = new Asesuisa_ObjetoAsegurado();
            Asesuisa_Beneficiario beneficiario = new Asesuisa_Beneficiario();

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
            unidadRiesgo.UnidadesRiesgoAutomotores1(a, driver, bean, nombreAutomatizacion, i, folderName, 10);
            Thread.sleep(2000);
            objetoAsegurado.ObjetoAseguradoAutomotores1(a, driver, bean, nombreAutomatizacion, i, folderName, 11, 12, 13, 14, 15, 16, 17, 18);
            Thread.sleep(2000);
            objetoAsegurado.Asegurado1(a, driver, bean, nombreAutomatizacion, i, folderName, 19, 20);
            Thread.sleep(2000);
            beneficiario.AgregarBeneficiario(a, driver, bean, nombreAutomatizacion, i, folderName, 21, 22);
            Thread.sleep(2000);
            EditarBeneficiario(a, driver, bean, nombreAutomatizacion, i, folderName, 23, 24, 25);
            Thread.sleep(2000);
            EliminarBeneficiario(a, driver, bean, nombreAutomatizacion, i, folderName, 26, 27, 28);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void EditarBeneficiario(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionBeneficiarioBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot,
                               int numScreenShoot2, int numScreenShoot3) {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);

            WebElement seleccionaBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_Container_sorting_1_Checked']"));
            seleccionaBeneficiario.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            //Thread.sleep(3000);

            WebDriverWait wait1 = new WebDriverWait(driver, 1);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']")));

            WebElement porcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            porcentaje.clear();
            Thread.sleep(1000);
            porcentaje.sendKeys(bean.getBeneficiarioPorcentajeEditar());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            a.waitSearchWicket(driver, "Guardar Tomador Editado");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EliminarBeneficiario(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionBeneficiarioBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot,
                                 int numScreenShoot2, int numScreenShoot3) {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);

            WebElement seleccionaBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            seleccionaBeneficiario.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnEliminar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_DeleteButton']"));
            btnEliminar.click();

            WebDriverWait wait1 = new WebDriverWait(driver, 1);
            wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']")));

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            a.waitSearchWicket(driver, "Eliminando Beneficiario");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
    
}
