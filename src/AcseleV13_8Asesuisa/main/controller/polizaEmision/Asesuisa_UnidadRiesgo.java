package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizasBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Created by agil on 05/03/2017.
 */
public class Asesuisa_UnidadRiesgo {

    private final static Logger log = Logger.getLogger(Asesuisa_UnidadRiesgo.class);

    public void UnidadesRiesgo1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,600)", "");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();
            Thread.sleep(1000);
            //btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            //btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (bean.getNumeroUnidadRiesgo1() != null) {
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(bean.getNumeroUnidadRiesgo1());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadesRiesgoAutomotores1(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,600)", "");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();
            Thread.sleep(1000);
            //btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            //btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,1600)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadesRiesgoAutomotores2(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,600)", "");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();
            Thread.sleep(1000);
            //btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            //btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,1600)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
