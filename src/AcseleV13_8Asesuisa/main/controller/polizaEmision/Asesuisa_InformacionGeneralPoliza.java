package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionGeneral30282Bean;
import AcseleV13_8Asesuisa.beans.Asesuisa_PolizasBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 21/02/2017.
 */
public class Asesuisa_InformacionGeneralPoliza {

    private final static Logger log = Logger.getLogger(Asesuisa_InformacionGeneralPoliza.class);

    public void InformacionGeneralVidaIntegral(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));

            if (bean.getPlanesFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(bean.getPlanesFinanciamiento());
                Thread.sleep(2000);
            }

            if (bean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(bean.getMonedas());
                Thread.sleep(2000);
            }

            if (bean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(bean.getSucursal());
                Thread.sleep(1000);
            }

            if (bean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(bean.getNumeroPoliza());
                Thread.sleep(1000);
                otroElemento.click();
                Thread.sleep(3000);
            }

            if (bean.getNumeroPolizaBlanca() != null){
                WebElement numPolizaBlanca = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                numPolizaBlanca.sendKeys(bean.getNumeroPolizaBlanca());
                Thread.sleep(1000);
                otroElemento.click();
                Thread.sleep(3000);
            }

            if (bean.getNumeroCotizacion() != null){
                WebElement numCotizacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                if (numCotizacion.isEnabled()){
                    numCotizacion.sendKeys(bean.getNumeroCotizacion());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (bean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(bean.getFechaEmision());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (bean.getTipoPoliza() != null){
                Thread.sleep(2000);
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                tipoPoliza.selectByValue(bean.getTipoPoliza());
                Thread.sleep(2000);
            }

            if (bean.getTipoProduccion() != null){
                Thread.sleep(2000);
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(bean.getTipoProduccion());
                Thread.sleep(2000);
            }

            if (bean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                WebElement wCanalVenta = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']"));
                if (wCanalVenta.isEnabled()) {
                    canalVenta.selectByValue(bean.getCanalVenta());
                    Thread.sleep(2000);
                }
            }

            if (bean.getCodigoRamo() != null){
                Thread.sleep(2000);
                Select codigoRamo = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                WebElement wCodigoRamo = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']"));
                if (wCodigoRamo.isEnabled()) {
                    codigoRamo.selectByValue(bean.getCodigoRamo());
                    Thread.sleep(2000);
                }
            }

            if (bean.getClasePoliza() != null){
                Select clasePoliza  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_2_field']")));
                clasePoliza.selectByValue(bean.getClasePoliza());
                Thread.sleep(2000);
            }

            if (bean.getObservacionSuscripcion() != null){
                WebElement observacionSuscripcion = driver.findElement(By.xpath("//textarea[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                observacionSuscripcion.sendKeys(bean.getObservacionSuscripcion());
                Thread.sleep(1000);
                otroElemento.click();
                Thread.sleep(4000);
            }

            if (bean.getComisionNegociable() != null){
                Thread.sleep(2000);
                Select comisionNegociable = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_1_fila_repeaterSelect_1_field']")));
                comisionNegociable.selectByValue(bean.getComisionNegociable());
                Thread.sleep(2000);
            }

            if (bean.getNivelAgrupacionReaseguro() != null){
                Thread.sleep(2000);
                Select nivelAgrupacionReaseguro = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_2_fila_repeaterSelect_1_field']")));
                WebElement wNivelAgrupacionReaseguro = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater_2_fila_repeaterSelect_1_field']"));
                if (wNivelAgrupacionReaseguro.isEnabled()) {
                    nivelAgrupacionReaseguro.selectByValue(bean.getNivelAgrupacionReaseguro());
                    Thread.sleep(2000);
                }
            }

            if (bean.getUnidadComercial() != null){
                Thread.sleep(2000);
                Select unidadComercial = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                unidadComercial.selectByValue(bean.getUnidadComercial());
                Thread.sleep(2000);
            }

            if (bean.getProyectoDependencia() != null){
                WebElement proyectoDependencia = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_1_datatemplates_repeater2_2_fila_field']"));
                 proyectoDependencia.sendKeys(bean.getProyectoDependencia());
                 Thread.sleep(1000);
                 otroElemento.click();
                 Thread.sleep(4000);
            }


            /** Informacion Bancaria **/
            if (bean.getDPDVendedor() != null){
                WebElement dPDVendedor = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater_1_fila_field']"));
                if (dPDVendedor.isEnabled()){
                    dPDVendedor.sendKeys(bean.getDPDVendedor());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (bean.getNombreVendedorBancaseguros() != null){
                WebElement nombreVendedorBancaseguros = driver.findElement(By.xpath("//input[@wicketpath='var wcall=wicketAjaxPost('?wicket:interface=:1:policyInformationContent:PolicyInformation:BasicInformation:registerForm:DataTemplate:tabPanel:repeaterTab:2:SubTabsInformation:repeater:2:fila:field::IBehaviorListener:1:-1', wicketSerialize(Wicket.$('id64')),null,null, function() {return Wicket.$('id64') != null;}.bind(this));']"));
                if (nombreVendedorBancaseguros.isEnabled()){
                    nombreVendedorBancaseguros.sendKeys(bean.getNombreVendedorBancaseguros());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }


            if (bean.getCodigoAgenciaVentas() != null){
                WebElement codigoAgenciaVentas = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_field']"));
                if (codigoAgenciaVentas.isEnabled()){
                    codigoAgenciaVentas.sendKeys(bean.getCodigoAgenciaVentas());
                    Thread.sleep(1000);
                    otroElemento.click();
                    //boolean isPresent = driver.findElements(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_field']")).size() > 0;
                    WebElement capa = driver.findElement(By.id("bigLayer"));
                    while (capa.isDisplayed()) {
                        Thread.sleep(2000);
                    }
                }
            }

            if (bean.getNombreAgenciaVentas() != null){
                WebElement nombreAgenciaVentas = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater_4_fila_field']"));
                if (nombreAgenciaVentas.isEnabled()){
                    nombreAgenciaVentas.sendKeys(bean.getNombreAgenciaVentas());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getCiudadAgenciaBancaria() != null){
                WebElement ciudadAgenciaBancaria = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater_5_fila_field']"));
                if (ciudadAgenciaBancaria.isEnabled()){
                    ciudadAgenciaBancaria.sendKeys(bean.getCiudadAgenciaBancaria());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getCanalVentaBancaseguros() != null){
                WebElement canalVentaBancaseguros = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_1_fila_field']"));
                if (canalVentaBancaseguros.isEnabled()){
                    canalVentaBancaseguros.sendKeys(bean.getCanalVentaBancaseguros());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getGrupoAgencia() != null){
                Select grupoAgencia = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                grupoAgencia.selectByValue(bean.getGrupoAgencia());
                Thread.sleep(3000);
            }

            if (bean.getDistritoComercial() != null){
                Select distritoComercial = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                distritoComercial.selectByValue(bean.getDistritoComercial());
                Thread.sleep(3000);
            }

            if (bean.getDistritoOperativo() != null){
                Select distritoOperativo = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                distritoOperativo.selectByValue(bean.getDistritoOperativo());
                Thread.sleep(3000);
            }

            if (bean.getSupervisorBancaseguros() != null){
                Select supervisorBancaseguros = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
                supervisorBancaseguros.selectByValue(bean.getSupervisorBancaseguros());
                Thread.sleep(3000);
            }

            jse.executeScript("window.scrollBy(0,-1500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            a.waitSearchWicket(driver, "Espere Informacion General Poliza");
            Thread.sleep(1000);

            //btnGuardarInfGeneral.click();
            //a.waitSearchWicket(driver, "Espere Informacion General Poliza");
            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InformacionGeneralRoboYHurto30282(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

       /* try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (bean.getPlanesFinanciamiento()!=null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(bean.getPlanesFinanciamiento());
                Thread.sleep(1000);
            }

            if (bean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(bean.getMonedas());
                Thread.sleep(1000);
            }

            if (bean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(bean.getSucursal());
                Thread.sleep(1000);
            }

            if (bean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(bean.getNumeroPoliza());
                Thread.sleep(1000);
                //otroElemento.click();
                //Thread.sleep(3000);
            }

            if (bean.getTipoProduccion()!=null){
                Select tipoProduccion= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(bean.getTipoProduccion());
                Thread.sleep(1000);
            }

            if (bean.getFuncionamientoPoliza()!=null){
                Select tipoProduccion= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(bean.getFuncionamientoPoliza());
                Thread.sleep(1000);
            }

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }*/
    }

    public void InformacionGeneralDotalSimple(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            /*JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));


            if (bean.getPlanesFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(bean.getPlanesFinanciamiento());
                Thread.sleep(2000);
            }

            if (bean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(bean.getMonedas());
                Thread.sleep(2000);
            }


            if (bean.getOficina() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(bean.getOficina());
                Thread.sleep(1000);
            }

            if (bean.getNumeroPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                if (numPoliza.isEnabled()) {
                    numPoliza.sendKeys(bean.getNumeroPoliza());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(3000);
                }
            }

            if (bean.getFechaEmision() != null){
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_fieldDate']"));
                if (fechaEmision.isEnabled()){
                    fechaEmision.sendKeys(bean.getFechaEmision());
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(4000);
                }
            }

            if (bean.getCanalVentaVida() != null){
                Thread.sleep(2000);
                Select canalVentaVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                WebElement canalVentaVidaElement = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']"));
                if (canalVentaVidaElement.isEnabled()) {
                    canalVentaVida.selectByValue(bean.getCanalVentaVida());
                    Thread.sleep(2000);
                }
            }

            if (bean.getCanalVenta() != null){
                Thread.sleep(2000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                WebElement canalVentaElement = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']"));
                if (canalVentaElement.isEnabled()) {
                    canalVenta.selectByValue(bean.getCanalVenta());
                    Thread.sleep(2000);
                }
            }

            if (bean.getFrecuenciaPago() != null){
                Select frecuenciaPago  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                WebElement frecuenciaPagoElement  = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']"));
                if (frecuenciaPagoElement.isEnabled()) {
                    frecuenciaPago.selectByValue(bean.getFrecuenciaPago());
                    Thread.sleep(2000);
                }
            }

            if (bean.getAplicaDescuento() != null){
                Select aplicaDescuento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                aplicaDescuento.selectByValue(bean.getAplicaDescuento());
                Thread.sleep(2000);
            }

            if (bean.getTipoDocumento() != null){
                Select tipoDocumento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_9_fila_repeaterSelect_1_field']")));
                tipoDocumento.selectByValue(bean.getTipoDocumento());
                Thread.sleep(2000);
            }

            if (bean.getNumeroDocumento() != null){
                WebElement numeroDocumento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_10_fila_field']"));
                numeroDocumento.sendKeys(bean.getNumeroDocumento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));
                otroElemento.click();
                Thread.sleep(3000);
            }

            if (bean.getFechaCotizacion() != null){
                WebElement fechaCotizacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_12_fila_fieldDate']"));
                fechaCotizacion.sendKeys(bean.getFechaCotizacion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getNumeroCotizacion() != null){
                WebElement numeroCotizacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_13_fila_field']"));
                if (numeroCotizacion.isEnabled()) {
                    numeroCotizacion.sendKeys(bean.getNumeroCotizacion());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getNumeroPropuestaAnterior() != null){
                WebElement numeroPropuestaAnterior = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_14_fila_field']"));
                if (numeroPropuestaAnterior.isEnabled()) {
                    numeroPropuestaAnterior.sendKeys(bean.getNumeroPropuestaAnterior());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getNumeroPropuestaAnterior() != null){
                Select numeroPropuestaAnterior = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_15_fila_repeaterSelect_1_field']")));
                numeroPropuestaAnterior.selectByValue(bean.getNumeroPropuestaAnterior());
                Thread.sleep(2000);
            }

            if (bean.getNumeroPropuesta() != null){
                WebElement numeroPropuesta = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_16_fila_field']"));
                numeroPropuesta.sendKeys(bean.getNumeroPropuesta());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getNivelAgrupamientoReaseguro() != null){
                Select nivelAgrupamientoReaseguro = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_17_fila_repeaterSelect_1_field']")));
                nivelAgrupamientoReaseguro.selectByValue(bean.getNivelAgrupamientoReaseguro());
                Thread.sleep(2000);
            }

            if (bean.getIndicadorDPS() != null){
                Select indicadorDPS = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_19_fila_repeaterSelect_1_field']")));
                WebElement indicadorDPSSelect = driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_19_fila_repeaterSelect_1_field']"));
                if (indicadorDPSSelect.isEnabled()) {
                    indicadorDPS.selectByValue(bean.getIndicadorDPS());
                    Thread.sleep(2000);
                }
            }

            if (bean.getEnvioComunicacionesPoliza() != null){
                Select envioComunicacionesPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_20_fila_repeaterSelect_1_field']")));
                Thread.sleep(2000);
                envioComunicacionesPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_20_fila_repeaterSelect_1_field']")));
                envioComunicacionesPoliza.selectByValue(bean.getEnvioComunicacionesPoliza());
                Thread.sleep(2000);
            }

            if (bean.getEnvioComunicacionesEndoso() != null){
                Select envioComunicacionesEndoso = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_22_fila_repeaterSelect_1_field']")));
                envioComunicacionesEndoso.selectByValue(bean.getEnvioComunicacionesEndoso());
                Thread.sleep(2000);
            }

            if (bean.getPrevalizacionViaCobro() != null && bean.getPrevalizacionViaCobro().toLowerCase().equals("si")){
                WebElement prevalizacionViaCobro = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_24_fila_field_repeaterChoice_1_radio']"));
                prevalizacionViaCobro.click();
                Thread.sleep(2000);
            }

            if (bean.getNuevaCotizacionRecibida() != null && bean.getNuevaCotizacionRecibida().toLowerCase().equals("si")){
                WebElement nuevaCotizacionRecibida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_25_fila_field_repeaterChoice_1_radio']"));
                if (nuevaCotizacionRecibida.isEnabled()) {
                    nuevaCotizacionRecibida.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getSolicitudAfiliacion() != null && bean.getSolicitudAfiliacion().toLowerCase().equals("si")){
                WebElement solicitudAfiliacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field_repeaterChoice_1_radio']"));
                solicitudAfiliacion.click();
                Thread.sleep(2000);
            }

            if (bean.getTipoPago() != null){
                Select tipoPago = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                tipoPago.selectByValue(bean.getTipoPago());
                Thread.sleep(2000);
            }

            if (bean.getNumeroOperacion() != null){
                WebElement numeroOperacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                numeroOperacion.sendKeys(bean.getNumeroOperacion());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getMonedaTransaccion() != null){
                Select monedaTransaccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
                monedaTransaccion.selectByValue(bean.getMonedaTransaccion());
                Thread.sleep(2000);
            }

            if (bean.getMontoTransaccion() != null){
                WebElement montoTransaccion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field']"));
                montoTransaccion.sendKeys(bean.getMontoTransaccion());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getMonedaDePrima() != null){
                Select monedaDePrima = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_repeaterSelect_1_field']")));
                monedaDePrima.selectByValue(bean.getMonedaDePrima());
                Thread.sleep(2000);
            }

            if (bean.getMontoPrimeraPrima() != null){
                WebElement montoPrimeraPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                montoPrimeraPrima.sendKeys(bean.getMontoPrimeraPrima());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getAgenteInicialPoliza() != null){
                WebElement agenteInicialPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_10_fila_field']"));
                agenteInicialPoliza.sendKeys(bean.getAgenteInicialPoliza());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getCodigoAgenteInicial() != null){
                WebElement codigoAgenteInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_11_fila_field']"));
                codigoAgenteInicial.sendKeys(bean.getCodigoAgenteInicial());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getCorreoAgenteInicial() != null){
                WebElement correoAgenteInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_12_fila_field']"));
                correoAgenteInicial.sendKeys(bean.getCorreoAgenteInicial());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getCodigoAgenciaInicial() != null){
                WebElement codigoAgenciaInicial = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_13_fila_field']"));
                codigoAgenciaInicial.sendKeys(bean.getCodigoAgenciaInicial());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getAgenteFinalPoliza() != null){
                WebElement agenteFinalPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_14_fila_field']"));
                agenteFinalPoliza.sendKeys(bean.getAgenteFinalPoliza());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getCodigoAgenteFinal() != null){
                WebElement codigoAgenteFinal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_15_fila_field']"));
                codigoAgenteFinal.sendKeys(bean.getCodigoAgenteFinal());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getCorreoAgenteFinal() != null){
                WebElement correoAgenteFinal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_16_fila_field']"));
                correoAgenteFinal.sendKeys(bean.getCorreoAgenteFinal());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getCodigoAgenciaFinal() != null){
                WebElement codigoAgenciaFinal = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_17_fila_field']"));
                codigoAgenciaFinal.sendKeys(bean.getCodigoAgenciaFinal());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getPeriodoDiasProcedeSuspencionCancelacion() != null){
                WebElement periodoDiasProcedeSuspencionCancelacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_16_fila_field']"));
                periodoDiasProcedeSuspencionCancelacion.sendKeys(bean.getPeriodoDiasProcedeSuspencionCancelacion());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (bean.getProductosVida() != null){
                Select productosVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_22_fila_repeaterSelect_1_field']")));
                productosVida.selectByValue(bean.getProductosVida());
                Thread.sleep(2000);
            }

            if (bean.getPlan() != null){
                Select plan = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_22_fila_repeaterSelect_2_field']")));
                Thread.sleep(2000);
                plan.selectByValue(bean.getPlan());
                Thread.sleep(2000);
            }

            if (bean.getFechaProxGenPrimaVi() != null){
                WebElement fechaProxGenPrimaVi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_19_fila_fieldDate']"));
                if (fechaProxGenPrimaVi.isEnabled()) {
                    fechaProxGenPrimaVi.sendKeys(bean.getFechaProxGenPrimaVi());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (bean.getPolizaCesionada() != null){
                Select polizaCesionada = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_20_fila_repeaterSelect_1_field']")));
                polizaCesionada.selectByValue(bean.getPolizaCesionada());
                Thread.sleep(2000);
            }

            if (bean.getLoginUsuario() != null){
                WebElement loginUsuario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_21_fila_field']"));
                if (loginUsuario.isEnabled()) {
                    loginUsuario.sendKeys(bean.getLoginUsuario());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

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
*/
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InformacionGeneralAutomotores(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName,int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));

            if (bean.getPlanesFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                //planFinanciamiento.selectByValue(bean.getPlanesFinanciamiento());
                planFinanciamiento.selectByVisibleText(bean.getPlanesFinanciamiento());
                Thread.sleep(2000);
            }

            if (bean.getMonedas() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                //moneda.selectByValue(bean.getMonedas());
                moneda.selectByVisibleText(bean.getMonedas());
                Thread.sleep(2000);
            }

            if (bean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
//                sucursal.selectByValue(bean.getSucursal());
                sucursal.selectByVisibleText(bean.getSucursal());
                Thread.sleep(3000);
            }

            if (bean.getTipoEmision() != null){
                if (bean.getTipoEmision().toLowerCase().equals("express")){
                    WebElement express = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field_repeaterChoice_1_radio']"));
                    express.click();
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(3000);
                }
                else if (bean.getTipoEmision().toLowerCase().equals("estandar")) {
                    WebElement estandar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field_repeaterChoice_2_radio']"));
                    estandar.click();
                    Thread.sleep(1000);
                    otroElemento.click();
                    Thread.sleep(3000);
                }
            }

            if (bean.getTipoPoliza() != null){
                Select tipoPoliza= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_10_fila_repeaterSelect_1_field']")));
//                tipoPoliza.selectByValue(bean.getTipoPoliza());
                tipoPoliza.selectByVisibleText(bean.getTipoPoliza());
                Thread.sleep(1000);
            }

            if (bean.getComisionNegociable() != null){
                Select comisionNegociable= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                comisionNegociable.selectByValue(bean.getComisionNegociable());
                Thread.sleep(1000);
            }

            if (bean.getUnidadComercial() != null){
                Select comisionNegociable= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
//                comisionNegociable.selectByValue(bean.getUnidadComercial());
                comisionNegociable.selectByVisibleText(bean.getUnidadComercial());
                Thread.sleep(2000);
            }

            if (bean.getCanalVenta() != null){
                Select comisionNegociable= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
//                comisionNegociable.selectByValue(bean.getCanalVenta());
                comisionNegociable.selectByVisibleText(bean.getCanalVenta());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,-1500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            a.waitSearchWicket(driver, "Espere Informacion General Poliza");
            Thread.sleep(1000);

            //btnGuardarInfGeneral.click();
            //a.waitSearchWicket(driver, "Espere Informacion General Poliza");
            Thread.sleep(10000);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
