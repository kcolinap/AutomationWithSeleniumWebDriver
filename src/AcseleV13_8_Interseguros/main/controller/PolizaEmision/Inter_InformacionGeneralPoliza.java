package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by agil on 23/11/2016.
 */
public class Inter_InformacionGeneralPoliza {

    private final static Logger log = Logger.getLogger(Inter_InformacionGeneralPoliza.class);

    public void InformacionGeneral(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));

            if (interPolizaBean.getPlanesFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(interPolizaBean.getPlanesFinanciamiento());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(interPolizaBean.getMonedas());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getOficina() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(interPolizaBean.getOficina());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(interPolizaBean.getNumeroPoliza());
                Thread.sleep(1000);
                otroElemento.click();
                Thread.sleep(3000);
            }

            if (interPolizaBean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaEmision());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                canalVenta.selectByValue(interPolizaBean.getCanalVenta());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getFrecuenciaPago() != null){
                Select frecuenciaPago  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                frecuenciaPago.selectByValue(interPolizaBean.getFrecuenciaPago());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getFechaEventoAnterior() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaEventoAnterior());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getFechaProximaGeneracionPrima() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaProximaGeneracionPrima());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getFechaProximaFacturacion() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaProximaFacturacion());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getNumeroPlan() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getNumeroPlan());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }


            if (interPolizaBean.getFechaEmisionEnAcsele() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaEmisionEnAcsele());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getPlanInteligo() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(interPolizaBean.getPlanInteligo());
                Thread.sleep(3000);
            }

            if (interPolizaBean.getNivelAgrupamientoReaseguro() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(interPolizaBean.getNivelAgrupamientoReaseguro());
                Thread.sleep(3000);
            }

            if (interPolizaBean.getFechaVenta() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaVenta());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getClaseReaseguro() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(interPolizaBean.getClaseReaseguro());
                Thread.sleep(3000);
            }

            if (interPolizaBean.getNumeroCotizacion() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_field']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getNumeroCotizacion());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getNumeroPropuesta() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getNumeroPropuesta());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            a.waitSearchWicket(driver, "Espere Informacion General Poliza");

        }catch (Exception e){
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
