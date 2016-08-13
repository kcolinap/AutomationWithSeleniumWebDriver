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


            if (emisionPolizaBeneficiarioNaturalBean.getAseguradoPrimario() != null){
                Thread.sleep(1000);
                WebElement aseguradoPrimarioSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field_repeaterChoice_2_radio']"));
                aseguradoPrimarioSi.click();
            }
            if (emisionPolizaBeneficiarioNaturalBean.getAseguradoPrimario() == "NO" || emisionPolizaBeneficiarioNaturalBean.getAseguradoPrimario() == "no"){
                Thread.sleep(1000);
                WebElement aseguradoPrimarioNo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field_repeaterChoice_1_radio']"));
                aseguradoPrimarioNo.click();
            }
            if (emisionPolizaBeneficiarioNaturalBean.getPorcExtraPrima() != null){
                Thread.sleep(1000);
                WebElement porcExtraPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                porcExtraPrima.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcExtraPrima());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getPorcDescuento() != null){
                Thread.sleep(1000);
                WebElement porcDescuento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                porcDescuento.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcDescuento());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getDocIdAsegurado() != null){
                Thread.sleep(1000);
                WebElement docIdAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                docIdAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getDocIdAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getFechaNacAsegurado() != null){
                Thread.sleep(1000);
                WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                fechaNacAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getFechaNacAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getDireccionAsegurado() != null){
                Thread.sleep(1000);
                WebElement direccionAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                direccionAsegurado.sendKeys(emisionPolizaBeneficiarioNaturalBean.getDireccionAsegurado());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getTelefonoFijo() != null){
                Thread.sleep(1000);
                WebElement telefonoFijo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_field']"));
                telefonoFijo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getTelefonoFijo());
            }

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

            if (emisionPolizaBeneficiarioNaturalBean.getDepartamento() != null){
                Thread.sleep(2000);
                Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                departamento.selectByValue(emisionPolizaBeneficiarioNaturalBean.getDepartamento());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getCiudad() != null){
                Thread.sleep(2000);
                Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
                ciudad.selectByValue(emisionPolizaBeneficiarioNaturalBean.getCiudad());
            }

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            btnGuardar.click();



            /***Espera***/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
