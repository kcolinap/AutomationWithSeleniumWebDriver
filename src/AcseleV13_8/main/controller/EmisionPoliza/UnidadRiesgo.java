package AcseleV13_8.main.controller.EmisionPoliza;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 10/08/2016.
 */
public class UnidadRiesgo {

    private final static Logger log = Logger.getLogger(UnidadRiesgo.class);

    public void UnidadRiesgo(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
                             String nombreAutomatizacion){
        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement btnNuevaUR = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevaUR.click();

            /***Espera***/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            Thread.sleep(2000);
            if (emisionPolizaBeneficiarioNaturalBean.getFechaProceso() != null){
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaProceso.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaProceso());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNumUnidadRiesgo() != null){
                WebElement numUnidadRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                Thread.sleep(1000);
                numUnidadRiesgo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumUnidadRiesgo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNumCredito() != null){
                WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                Thread.sleep(1000);
                numCredito.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumCredito());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getMontoAsegurado() != null){
                WebElement montoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                Thread.sleep(1000);
                montoAsegurado.clear();
                montoAsegurado.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, emisionPolizaBeneficiarioNaturalBean.getMontoAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFactorVida() != null){
                WebElement factorVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                Thread.sleep(1000);
                factorVida.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFactorVida());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getValorSeguroPrima() != null){
                WebElement valorSeguroPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                Thread.sleep(1000);
                valorSeguroPrima.sendKeys(emisionPolizaBeneficiarioNaturalBean.getValorSeguroPrima());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaDesembolso() != null){
                WebElement fechaDesembolso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaDesembolso.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaDesembolso());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getValorPrestamo() != null){
                WebElement valorPrestamo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field']"));
                Thread.sleep(1000);
                valorPrestamo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getValorPrestamo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCuotasPactadas() != null){
                WebElement cuotasPactadas = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_field']"));
                Thread.sleep(1000);
                cuotasPactadas.sendKeys(emisionPolizaBeneficiarioNaturalBean.getCuotasPactadas());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getSaldoCapital() != null){
                WebElement saldoCapital = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                Thread.sleep(1000);
                saldoCapital.sendKeys(emisionPolizaBeneficiarioNaturalBean.getSaldoCapital());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getEdoCredito() != null){
                Select estadoCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                Thread.sleep(1000);
                estadoCredito.selectByValue(emisionPolizaBeneficiarioNaturalBean.getEdoCredito());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCuotasMora() != null){
                WebElement cuotasMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                Thread.sleep(1000);
                cuotasMora.sendKeys(emisionPolizaBeneficiarioNaturalBean.getCuotasMora());
            }

            if (emisionPolizaBeneficiarioNaturalBean.getFechaPago() != null){
                WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaPago.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaPago());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCuotaPagada() != null){
                WebElement cuotaPagada = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field']"));
                Thread.sleep(1000);
                cuotaPagada.sendKeys(emisionPolizaBeneficiarioNaturalBean.getCuotaPagada());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaMora() != null){
                WebElement fechaMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaMora.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaMora());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getPorcFacultativo() != null){
                WebElement porcentajeFacultativo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                Thread.sleep(1000);
                porcentajeFacultativo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcFacultativo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaProceso() != null){
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaProceso.clear();
                fechaProceso.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaProceso());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

            if (emisionPolizaBeneficiarioNaturalBean.getFechaProceso() != null){
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaProceso.clear();
                fechaProceso.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaProceso());
            }
            Thread.sleep(1000);
            btnGuardar.click();

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(3000);


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
