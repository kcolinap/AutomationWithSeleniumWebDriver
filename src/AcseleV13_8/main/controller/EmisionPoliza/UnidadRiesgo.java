package AcseleV13_8.main.controller.EmisionPoliza;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

            /** Espere **/

            WebElement numUnidadRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
            WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
            WebElement montoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
            WebElement factorVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
            WebElement valorSeguroPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
            WebElement fechaDesembolso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_fieldDate']"));
            WebElement valorPrestamo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field']"));
            WebElement cuotasPactadas = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_field']"));
            WebElement saldoCapital = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
            Select estadoCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
            WebElement cuotasMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
            WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
            WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_fieldDate']"));
            WebElement cuotaPagada = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field']"));
            WebElement fechaMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_fieldDate']"));
            WebElement porcentajeFacultativo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));

            if (emisionPolizaBeneficiarioNaturalBean.getNumUnidadRiesgo() != null){
                numUnidadRiesgo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumUnidadRiesgo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNumCredito() != null){
                numCredito.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumCredito());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getMontoAsegurado() != null){
                montoAsegurado.clear();
                Thread.sleep(1000);
                montoAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getMontoAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFactorVida() != null){
                factorVida.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFactorVida());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getValorSeguroPrima() != null){
                valorSeguroPrima.sendKeys(emisionPolizaBeneficiarioNaturalBean.getValorSeguroPrima());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaDesembolso() != null){
                fechaDesembolso.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaDesembolso());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getValorPrestamo() != null){
                valorPrestamo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getValorPrestamo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCuotasPactadas() != null){
                cuotasPactadas.sendKeys(emisionPolizaBeneficiarioNaturalBean.getCuotasPactadas());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getSaldoCapital() != null){
                saldoCapital.sendKeys(emisionPolizaBeneficiarioNaturalBean.getSaldoCapital());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getEdoCredito() != null){
                estadoCredito.selectByValue(emisionPolizaBeneficiarioNaturalBean.getEdoCredito());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCuotasMora() != null){
                cuotasMora.sendKeys(emisionPolizaBeneficiarioNaturalBean.getCuotasMora());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaProceso() != null){
                fechaProceso.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaProceso());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaPago() != null){
                fechaPago.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaPago());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCuotaPagada() != null){
                cuotaPagada.sendKeys(emisionPolizaBeneficiarioNaturalBean.getCuotaPagada());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaMora() != null){
                fechaMora.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaMora());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getPorcFacultativo() != null){
                porcentajeFacultativo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcFacultativo());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
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
