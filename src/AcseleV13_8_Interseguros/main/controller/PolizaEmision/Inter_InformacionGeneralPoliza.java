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

    public void InformacionGeneralInteligo(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot){

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
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            a.waitSearchWicket(driver, "Espere Informacion General Poliza");

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InformacionGeneralDotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

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
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(interPolizaBean.getOficina());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                if (numPoliza.isEnabled()) {
                    numPoliza.sendKeys(interPolizaBean.getNumeroPoliza());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(3000);
                }
            }

            if (interPolizaBean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(interPolizaBean.getFechaEmision());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (interPolizaBean.getCanalVentaVida() != null){
                Thread.sleep(2000);
                Select canalVentaVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                WebElement canalVentaVidaElement = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']"));
                if (canalVentaVidaElement.isEnabled()) {
                    canalVentaVida.selectByValue(interPolizaBean.getCanalVentaVida());
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                WebElement canalVentaElement = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']"));
                if (canalVentaElement.isEnabled()) {
                    canalVenta.selectByValue(interPolizaBean.getCanalVenta());
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getFrecuenciaPago() != null){
                Select frecuenciaPago  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                WebElement frecuenciaPagoElement  = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']"));
                if (frecuenciaPagoElement.isEnabled()) {
                    frecuenciaPago.selectByValue(interPolizaBean.getFrecuenciaPago());
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getAplicaDescuento() != null){
                Select aplicaDescuento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                aplicaDescuento.selectByValue(interPolizaBean.getAplicaDescuento());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getTipoDocumento() != null){
                Select tipoDocumento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_9_fila_repeaterSelect_1_field']")));
                tipoDocumento.selectByValue(interPolizaBean.getTipoDocumento());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getNumeroDocumento() != null){
                WebElement numeroDocumento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_10_fila_field']"));
                numeroDocumento.sendKeys(interPolizaBean.getNumeroDocumento());
                otroElemento.click();
                Thread.sleep(3000);
            }

            if (interPolizaBean.getFechaCotizacion() != null){
                WebElement fechaCotizacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_12_fila_fieldDate']"));
                fechaCotizacion.sendKeys(interPolizaBean.getFechaCotizacion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getNumeroCotizacion() != null){
                WebElement numeroCotizacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_13_fila_field']"));
                if (numeroCotizacion.isEnabled()) {
                    numeroCotizacion.sendKeys(interPolizaBean.getNumeroCotizacion());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getNumeroPropuestaAnterior() != null){
                WebElement numeroPropuestaAnterior = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_14_fila_field']"));
                if (numeroPropuestaAnterior.isEnabled()) {
                    numeroPropuestaAnterior.sendKeys(interPolizaBean.getNumeroPropuestaAnterior());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getNumeroPropuestaAnterior() != null){
                Select numeroPropuestaAnterior = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_15_fila_repeaterSelect_1_field']")));
                numeroPropuestaAnterior.selectByValue(interPolizaBean.getNumeroPropuestaAnterior());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getNumeroPropuesta() != null){
                WebElement numeroPropuesta = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_16_fila_field']"));
                numeroPropuesta.sendKeys(interPolizaBean.getNumeroPropuesta());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getNivelAgrupamientoReaseguro() != null){
                Select nivelAgrupamientoReaseguro = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_17_fila_repeaterSelect_1_field']")));
                nivelAgrupamientoReaseguro.selectByValue(interPolizaBean.getNivelAgrupamientoReaseguro());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getIndicadorDPS() != null){
                Select indicadorDPS = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_19_fila_repeaterSelect_1_field']")));
                WebElement indicadorDPSSelect = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_19_fila_repeaterSelect_1_field']"));
                if (indicadorDPSSelect.isEnabled()) {
                    indicadorDPS.selectByValue(interPolizaBean.getIndicadorDPS());
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEnvioComunicacionesPoliza() != null){
                Select envioComunicacionesPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_20_fila_repeaterSelect_1_field']")));
                envioComunicacionesPoliza.selectByValue(interPolizaBean.getEnvioComunicacionesPoliza());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getEnvioComunicacionesEndoso() != null){
                Select envioComunicacionesEndoso = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_22_fila_repeaterSelect_1_field']")));
                envioComunicacionesEndoso.selectByValue(interPolizaBean.getEnvioComunicacionesEndoso());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getPrevalizacionViaCobro() != null && interPolizaBean.getPrevalizacionViaCobro().toLowerCase().equals("si")){
                WebElement prevalizacionViaCobro = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_24_fila_field_repeaterChoice_1_radio']"));
                prevalizacionViaCobro.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getNuevaCotizacionRecibida() != null && interPolizaBean.getNuevaCotizacionRecibida().toLowerCase().equals("si")){
                WebElement nuevaCotizacionRecibida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_25_fila_field_repeaterChoice_1_radio']"));
                if (nuevaCotizacionRecibida.isEnabled()) {
                    nuevaCotizacionRecibida.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getSolicitudAfiliacion() != null && interPolizaBean.getSolicitudAfiliacion().toLowerCase().equals("si")){
                WebElement solicitudAfiliacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field_repeaterChoice_1_radio']"));
                solicitudAfiliacion.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getTipoPago() != null){
                Select tipoPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                tipoPago.selectByValue(interPolizaBean.getTipoPago());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getNumeroOperacion() != null){
                WebElement numeroOperacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                numeroOperacion.sendKeys(interPolizaBean.getNumeroOperacion());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getMonedaTransaccion() != null){
                Select monedaTransaccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
                monedaTransaccion.selectByValue(interPolizaBean.getMonedaTransaccion());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getMontoTransaccion() != null){
                WebElement montoTransaccion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field']"));
                montoTransaccion.sendKeys(interPolizaBean.getMontoTransaccion());
                otroElemento.click();
                Thread.sleep(2000);
            }
/*
            if (interPolizaBean.getMonedaDePrima() != null){
                Select monedaDePrima = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                monedaDePrima.selectByValue(interPolizaBean.getMonedaDePrima());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getMontoPrimeraPrima() != null){
                WebElement montoPrimeraPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_field']"));
                montoPrimeraPrima.sendKeys(interPolizaBean.getMontoPrimeraPrima());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getAgenteInicialPoliza() != null){
                WebElement agenteInicialPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                agenteInicialPoliza.sendKeys(interPolizaBean.getAgenteInicialPoliza());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCodigoAgenteInicial() != null){
                WebElement codigoAgenteInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_9_fila_field']"));
                codigoAgenteInicial.sendKeys(interPolizaBean.getCodigoAgenteInicial());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCorreoAgenteInicial() != null){
                WebElement correoAgenteInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_10_fila_field']"));
                correoAgenteInicial.sendKeys(interPolizaBean.getCorreoAgenteInicial());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCodigoAgenciaInicial() != null){
                WebElement codigoAgenciaInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_11_fila_field']"));
                codigoAgenciaInicial.sendKeys(interPolizaBean.getCodigoAgenciaInicial());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getAgenteFinalPoliza() != null){
                WebElement agenteFinalPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_12_fila_field']"));
                agenteFinalPoliza.sendKeys(interPolizaBean.getAgenteFinalPoliza());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCodigoAgenteFinal() != null){
                WebElement codigoAgenteFinal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_13_fila_field']"));
                codigoAgenteFinal.sendKeys(interPolizaBean.getCodigoAgenteFinal());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCorreoAgenteFinal() != null){
                WebElement correoAgenteFinal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_14_fila_field']"));
                correoAgenteFinal.sendKeys(interPolizaBean.getCorreoAgenteFinal());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCodigoAgenciaFinal() != null){
                WebElement codigoAgenciaFinal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_15_fila_field']"));
                codigoAgenciaFinal.sendKeys(interPolizaBean.getCodigoAgenciaFinal());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getPeriodoDiasProcedeSuspencionCancelacion() != null){
                WebElement periodoDiasProcedeSuspencionCancelacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_16_fila_field']"));
                periodoDiasProcedeSuspencionCancelacion.sendKeys(interPolizaBean.getPeriodoDiasProcedeSuspencionCancelacion());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getProductosVida() != null){
                Select productosVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_18_fila_repeaterSelect_1_field']")));
                productosVida.selectByValue(interPolizaBean.getProductosVida());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getPlan() != null){
                Select plan = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_19_fila_repeaterSelect_2_field']")));
                plan.selectByValue(interPolizaBean.getPlan());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getFechaProxGenPrimaVi() != null){
                WebElement fechaProxGenPrimaVi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_19_fila_fieldDate']"));
                if (fechaProxGenPrimaVi.isEnabled()) {
                    fechaProxGenPrimaVi.sendKeys(interPolizaBean.getFechaProxGenPrimaVi());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getPolizaCesionada() != null){
                Select polizaCesionada = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_20_fila_repeaterSelect_1_field']")));
                polizaCesionada.selectByValue(interPolizaBean.getPolizaCesionada());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getLoginUsuario() != null){
                WebElement loginUsuario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_21_fila_field']"));
                if (loginUsuario.isEnabled()) {
                    loginUsuario.sendKeys(interPolizaBean.getLoginUsuario());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }*/

            jse.executeScript("window.scrollBy(0,-1000)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            a.waitSearchWicket(driver, "Espere Informacion General Poliza");

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
