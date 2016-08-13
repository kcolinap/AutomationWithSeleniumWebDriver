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
public class InformacionGeneralPoliza {

    private final static Logger log = Logger.getLogger(InformacionGeneralPoliza.class);

    public void InformacionGeneral(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
                                   String nombreAutomatizacion){
        try { //TipoElemento[@wicketpath='WicketpathElemento']

            if (emisionPolizaBeneficiarioNaturalBean.getPlanFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(emisionPolizaBeneficiarioNaturalBean.getPlanFinanciamiento());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getMoneda() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(emisionPolizaBeneficiarioNaturalBean.getMoneda());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(emisionPolizaBeneficiarioNaturalBean.getSucursal());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getNumPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumPoliza());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getTipoProduccion() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoProduccion());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getPeriodoGraciaDias() != null){
                WebElement periodoGraciaDias = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                periodoGraciaDias.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPeriodoGraciaDias());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getLineaCredito() != null){
                Select lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                lineaCredito.selectByValue(emisionPolizaBeneficiarioNaturalBean.getLineaCredito());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getHoraIniVencimiento() != null){
                Select horaIniVencimiento= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                horaIniVencimiento.selectByValue(emisionPolizaBeneficiarioNaturalBean.getHoraIniVencimiento());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getUnidadNegocio() != null){
                Select unidadNegocio = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                unidadNegocio.selectByValue(emisionPolizaBeneficiarioNaturalBean.getUnidadNegocio());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getCanalVenta() != null){
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_2_field']")));
                canalVenta.selectByValue(emisionPolizaBeneficiarioNaturalBean.getCanalVenta());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getFrecuencuaPago() != null){
                Select frecuenciaPago  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                frecuenciaPago.selectByValue(emisionPolizaBeneficiarioNaturalBean.getFrecuencuaPago());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getTipoPoliza() != null){
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                tipoPoliza.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoPoliza());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getTipoValorAsegurado() != null){
                Select tipoValorAsegurado = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                tipoValorAsegurado.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoValorAsegurado());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getNivelAgrupaReaseguro() != null){
                Select nivelAgrupamientoReaseguro  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
                nivelAgrupamientoReaseguro.selectByValue(emisionPolizaBeneficiarioNaturalBean.getNivelAgrupaReaseguro());
                Thread.sleep(1000);
            }

            if (emisionPolizaBeneficiarioNaturalBean.getNivelAgrupaReaseguro() != null){
                WebElement si = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field_repeaterChoice_2_radio']"));
                si.click();
                Thread.sleep(1000);
            }
            else if (emisionPolizaBeneficiarioNaturalBean.getNivelAgrupaReaseguro() == null){
                WebElement no = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field_repeaterChoice_1_radio']"));
                no.click();
                Thread.sleep(1000);
            }


            Thread.sleep(2000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            /** Experimento de Espera que se deshabilite el mensaje de Espera**/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                //System.out.println("Experimento de Espera 1");
            }

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

}
