package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by agil on 24/11/2016.
 */
public class Inter_ObjetosAsegurados {

    private final static Logger log = Logger.getLogger(Inter_ObjetosAsegurados.class);

    public void ObjetoAsegurado1_Inteligo(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            //WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            //btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado1());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNombreCompletoAsegurado1() != null){
                WebElement nombreCompletoAsegurado1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (nombreCompletoAsegurado1.isEnabled()) {
                    nombreCompletoAsegurado1.clear();
                    nombreCompletoAsegurado1.sendKeys(interPolizaBean.getNombreCompletoAsegurado1());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNombreCompletoBeneficiario1() != null){
                WebElement nombreCompletoBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (nombreCompletoBeneficiario1.isEnabled()) {
                    nombreCompletoBeneficiario1.clear();
                    nombreCompletoBeneficiario1.sendKeys(interPolizaBean.getNombreCompletoBeneficiario1());
                    Thread.sleep(1000);
                }
            }

            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }

    public void ObjetoAsegurado2_Inteligo(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            btnNuevo.click();

            /*Thread.sleep(2000);
            WebElement seleccionarNuevoOA = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_InsuranceObjectTable_InsuranceObjectsTable_2_insuranceItem_IONameLink_IOName']"));
            seleccionarNuevoOA.click();
            Thread.sleep(1000);*/

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado2() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado2());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNombreCompletoAsegurado2() != null){
                WebElement nombreCompletoAsegurado1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (nombreCompletoAsegurado1.isEnabled()) {
                    nombreCompletoAsegurado1.clear();
                    nombreCompletoAsegurado1.sendKeys(interPolizaBean.getNombreCompletoAsegurado2());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNombreCompletoBeneficiario2() != null){
                WebElement nombreCompletoBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (nombreCompletoBeneficiario1.isEnabled()) {
                    nombreCompletoBeneficiario1.clear();
                    nombreCompletoBeneficiario1.sendKeys(interPolizaBean.getNombreCompletoBeneficiario2());
                    Thread.sleep(1000);
                }
            }

            //jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }

    public void ObjetoAsegurado1_DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            //WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            //btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado1());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNombreCompletoAsegurado1() != null){
                WebElement nombreCompletoAsegurado1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (nombreCompletoAsegurado1.isEnabled()) {
                    nombreCompletoAsegurado1.clear();
                    nombreCompletoAsegurado1.sendKeys(interPolizaBean.getNombreCompletoAsegurado1());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNombreCompletoBeneficiario1() != null){
                WebElement nombreCompletoBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (nombreCompletoBeneficiario1.isEnabled()) {
                    nombreCompletoBeneficiario1.clear();
                    nombreCompletoBeneficiario1.sendKeys(interPolizaBean.getNombreCompletoBeneficiario1());
                    Thread.sleep(1000);
                }
            }

            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }
}
