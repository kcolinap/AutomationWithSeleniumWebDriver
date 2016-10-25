package AcseleV13_8LBC.main.controller.LBC_PolizaEmision;

import AcseleV13_8LBC.beans.LBC_PolizasBean;
import AcseleV13_8LBC.main.controller.MetodosLBC;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 10/08/2016.
 */
public class LBC_InformacionGeneralPoliza {

    private final static Logger log = Logger.getLogger(LBC_InformacionGeneralPoliza.class);

    public void InformacionGeneral(MetodosLBC a, WebDriver driver, LBC_PolizasBean lbcPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));

            if (lbcPolizaBean.getPlanesFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(lbcPolizaBean.getPlanesFinanciamiento());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(lbcPolizaBean.getMonedas());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getTipoCoaseguro() != null){
                Select tipoCoaseguro= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_CoinsuranceSelect']")));
                tipoCoaseguro.selectByValue(lbcPolizaBean.getTipoCoaseguro());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getOficina() != null){
                Select oficina= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                oficina.selectByValue(lbcPolizaBean.getOficina());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getNumeroPoliza() != null){
                WebElement numeroPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (numeroPoliza.isEnabled()){
                    numeroPoliza.sendKeys(lbcPolizaBean.getNumeroPoliza());
                    Thread.sleep(1000);
                    otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (lbcPolizaBean.getNumeroPropuesta() != null){
                WebElement numeroPropuesta = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                if (numeroPropuesta.isEnabled()){
                    numeroPropuesta.sendKeys(lbcPolizaBean.getNumeroPropuesta());
                    Thread.sleep(1000);
                    otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (lbcPolizaBean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_fieldDate']"));
                fechaEmision.sendKeys(lbcPolizaBean.getFechaEmision());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (lbcPolizaBean.getTipoProduccion() != null){
                Thread.sleep(1000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(lbcPolizaBean.getTipoProduccion());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getCanalVenta() != null){
                Thread.sleep(1000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                canalVenta.selectByValue(lbcPolizaBean.getCanalVenta());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getComisionNegociable() != null){
                Thread.sleep(1000);
                Select comisionNegociable = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                comisionNegociable.selectByValue(lbcPolizaBean.getComisionNegociable());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getSegmento() != null){
                Thread.sleep(1000);
                Select segmento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                segmento.selectByValue(lbcPolizaBean.getSegmento());
                Thread.sleep(2000);
            }

            if (lbcPolizaBean.getPorcentajeCuotaInicial() != null){
                WebElement porcentajeCuotaInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                porcentajeCuotaInicial.sendKeys(lbcPolizaBean.getPorcentajeCuotaInicial());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (lbcPolizaBean.getPrimaTotal() != null){
                WebElement primaTotal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                primaTotal.sendKeys(lbcPolizaBean.getPrimaTotal());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (lbcPolizaBean.getPrimaTecnicaNeta() != null){
                WebElement primaTecnicaNeta = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                primaTecnicaNeta.sendKeys(lbcPolizaBean.getPrimaTecnicaNeta());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (lbcPolizaBean.getFechaFinCotizacion() != null){
                WebElement fechaFinCotizacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                if (fechaFinCotizacion.isEnabled()){
                    fechaFinCotizacion.sendKeys(lbcPolizaBean.getFechaFinCotizacion());
                    Thread.sleep(1000);
                    otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (lbcPolizaBean.getObservacionesPolizas() != null){
                WebElement observacionesPolizas = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                observacionesPolizas.sendKeys(lbcPolizaBean.getObservacionesPolizas());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (lbcPolizaBean.getObservacionesSuscripcion() != null){
                WebElement observacionesSuscripcion = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                observacionesSuscripcion.sendKeys(lbcPolizaBean.getObservacionesSuscripcion());
                Thread.sleep(1000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (lbcPolizaBean.getValorAseguradoTotalPolizaEndoso() != null){
                WebElement valorAseguradoTotalPolizaEndoso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_1_fila_field']"));
                if (valorAseguradoTotalPolizaEndoso.isEnabled()){
                    valorAseguradoTotalPolizaEndoso.sendKeys(lbcPolizaBean.getValorAseguradoTotalPolizaEndoso());
                    Thread.sleep(1000);
                    otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
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
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
