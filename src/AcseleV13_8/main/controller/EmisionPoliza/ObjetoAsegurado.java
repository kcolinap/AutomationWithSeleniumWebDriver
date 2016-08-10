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
public class ObjetoAsegurado {

    private final static Logger log = Logger.getLogger(ObjetoAsegurado.class);

    public void ObjetoAsegurado(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
                                String nombreAutomatizacion){
        try{//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);

            WebElement aseguradoPrimarioNo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field_repeaterChoice_1_radio']"));
            WebElement aseguradoPrimarioSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field_repeaterChoice_2_radio']"));
            WebElement porcExtraPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
            WebElement porcDescuento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
            WebElement docIdAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
            WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
            WebElement direccionAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
            WebElement telefonoFijo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_field']"));
            Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
            Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));

            if (emisionPolizaBeneficiarioNaturalBean.getAseguradoPrimario() != null){
                aseguradoPrimarioSi.click();
            }
            if (emisionPolizaBeneficiarioNaturalBean.getAseguradoPrimario() == "NO" || emisionPolizaBeneficiarioNaturalBean.getAseguradoPrimario() == "no"){
                aseguradoPrimarioNo.click();
            }
            if (emisionPolizaBeneficiarioNaturalBean.getPorcExtraPrima() != null){
                porcExtraPrima.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcExtraPrima());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getPorcDescuento() != null){
                porcDescuento.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcDescuento());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getDocIdAsegurado() != null){
                docIdAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getDocIdAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaNacAsegurado() != null){
                fechaNacAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaNacAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getDireccionAsegurado() != null){
                direccionAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getDireccionAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getTelefonoFijo() != null){
                telefonoFijo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getTelefonoFijo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getDepartamento() != null){
                departamento.selectByValue(emisionPolizaBeneficiarioNaturalBean.getDepartamento());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCiudad() != null){
                ciudad.selectByValue(emisionPolizaBeneficiarioNaturalBean.getCiudad());
            }

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

            /** Espere**/

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
