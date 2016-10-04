package AcseleV13_8.main.controller.PolizaEmision;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.beans.PolizaBean;
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

    public void InformacionGeneral(Metodos a, WebDriver driver, PolizaBean polizaBean,
                                   String nombreAutomatizacion, int i, int numScreenShoot){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));

            if (polizaBean.getPlanFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(polizaBean.getPlanFinanciamiento());
                Thread.sleep(2000);
            }

            if (polizaBean.getMoneda() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(polizaBean.getMoneda());
                Thread.sleep(2000);
            }

            if (polizaBean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(polizaBean.getSucursal());
                Thread.sleep(1000);
            }

            if (polizaBean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(polizaBean.getNumeroPoliza());
                Thread.sleep(1000);
                otroElemento.click();
                Thread.sleep(3000);
            }

            if (polizaBean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(polizaBean.getFechaEmision());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }

            }

            if (polizaBean.getTipoProduccion() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(polizaBean.getTipoProduccion());
                Thread.sleep(3000);
            }

            if (polizaBean.getPeriodoGracia() != null){
                WebElement periodoGraciaDias = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                periodoGraciaDias.sendKeys(polizaBean.getPeriodoGracia());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (polizaBean.getLineaCredito() != null){
                Select lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                lineaCredito.selectByValue(polizaBean.getLineaCredito());
                Thread.sleep(2000);
            }

            if (polizaBean.getHoraIniciacionVencimiento() != null){
                Thread.sleep(1000);
                Select horaIniVencimiento= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                horaIniVencimiento.selectByValue(polizaBean.getHoraIniciacionVencimiento());
                Thread.sleep(2000);
            }

            if (polizaBean.getUnidadNegocio() != null){
                Select unidadNegocio = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                unidadNegocio.selectByValue(polizaBean.getUnidadNegocio());
                Thread.sleep(2000);
            }

            if (polizaBean.getCanalVenta() != null){
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_2_field']")));
                canalVenta.selectByValue(polizaBean.getCanalVenta());
                Thread.sleep(2000);
            }

            if (polizaBean.getFrecuenciaPago() != null){
                Select frecuenciaPago  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                frecuenciaPago.selectByValue(polizaBean.getFrecuenciaPago());
                Thread.sleep(2000);
            }

            if (polizaBean.getTipoPoliza() != null){
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                tipoPoliza.selectByValue(polizaBean.getTipoPoliza());
                Thread.sleep(2000);
            }

            if (polizaBean.getTipoValorAsegurado() != null){
                Select tipoValorAsegurado = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                tipoValorAsegurado.selectByValue(polizaBean.getTipoValorAsegurado());
                Thread.sleep(2000);
            }

            if (polizaBean.getNivelAgrupamientoReaseguro() != null){
                Select nivelAgrupamientoReaseguro  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
                nivelAgrupamientoReaseguro.selectByValue(polizaBean.getNivelAgrupamientoReaseguro());
                Thread.sleep(2000);
            }

            if (polizaBean.getPermiteManejoCuentasProvisionales() != null){
                String permite = polizaBean.getPermiteManejoCuentasProvisionales().toLowerCase();
                if (permite.equals("no")) {
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    Thread.sleep(1000);
                }
                else if (permite.equals("si")){
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    Thread.sleep(3000);

                    if (polizaBean.getMesProvisional() != null){
                        Select mesProvisional = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                        mesProvisional.selectByValue(polizaBean.getMesProvisional());
                        Thread.sleep(1000);
                    }

                    if (polizaBean.getAnioProvisional() != null) {
                        Select anioProvisional = new Select(driver.findElement(By.xpath("//select[@wicketpath='']")));
                        anioProvisional.selectByValue(polizaBean.getAnioProvisional());
                        Thread.sleep(1000);
                    }
                }
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Informacion General Poliza");
            }

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

}
