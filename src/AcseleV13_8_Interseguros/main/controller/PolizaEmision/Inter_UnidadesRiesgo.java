package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Key;

/**
 * Created by agil on 24/11/2016.
 */
public class Inter_UnidadesRiesgo {

    private final static Logger log = Logger.getLogger(Inter_UnidadesRiesgo.class);

    public void UnidadesRiesgo1(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroUnidadRiesgo1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroUnidadRiesgo1());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadesRiesgo2(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroUnidadRiesgo1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroUnidadRiesgo1());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadesRiesgo1DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroUnidadRiesgo1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroUnidadRiesgo1());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getCapitalAseguradoCoberturaFallecimiento1() != null) {
                WebElement capitalAseguradoCoberturaFallecimiento1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                capitalAseguradoCoberturaFallecimiento1.clear();
                Thread.sleep(2000);
                //jse.executeScript("showWait()", "");
                jse.executeScript("hideWait()", "");
                Thread.sleep(1000);
                capitalAseguradoCoberturaFallecimiento1.click();
                Thread.sleep(1000);
                capitalAseguradoCoberturaFallecimiento1.sendKeys(interPolizaBean.getCapitalAseguradoCoberturaFallecimiento1());
                Thread.sleep(1000);
                WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(1000);
                //otro.sendKeys(Keys.ENTER);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadesRiesgo2DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroUnidadRiesgo2() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroUnidadRiesgo2());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getCapitalAseguradoCoberturaFallecimiento2() != null) {
                WebElement capitalAseguradoCoberturaFallecimiento2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                capitalAseguradoCoberturaFallecimiento2.clear();
                Thread.sleep(2000);
                //jse.executeScript("showWait()", "");
                jse.executeScript("hideWait()", "");
                Thread.sleep(1000);
                capitalAseguradoCoberturaFallecimiento2.click();
                Thread.sleep(1000);
                capitalAseguradoCoberturaFallecimiento2.sendKeys(interPolizaBean.getCapitalAseguradoCoberturaFallecimiento2());
                Thread.sleep(1000);
                WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otro.click();
                Thread.sleep(1000);
                //otro.sendKeys(Keys.ENTER);
            }

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
