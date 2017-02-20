package AcseleV13_8LBC.main.controller.LBC_PolizaEmision;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos13_8;
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
public class UnidadesRiesgo {

    private final static Logger log = Logger.getLogger(UnidadesRiesgo.class);

    public void UnidadesRiesgo(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Nueva Unidad de Riesgo");
            }

            if (polizaBean.getNumeroUnidadRiesgo() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(polizaBean.getNumeroUnidadRiesgo());
                Thread.sleep(1000);
            }

            if (polizaBean.getNumeroCredito() != null) {
                Thread.sleep(2000);
                WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numCredito.sendKeys(polizaBean.getNumeroCredito());
            }

            if (polizaBean.getMontoAsegurado() != null) {
                Thread.sleep(3000);
                WebElement montoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                montoAsegurado.click();
                Thread.sleep(3000);
                WebElement afuera = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afuera.click();
                montoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                montoAsegurado.clear();
                Thread.sleep(3000);
                montoAsegurado.sendKeys(polizaBean.getMontoAsegurado());
                Thread.sleep(3000);
                WebElement afueraClick = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afueraClick.click();

            }

            if (polizaBean.getFactorVida() != null) {
                Thread.sleep(2000);
                WebElement factorVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                factorVida.click();
                Thread.sleep(2000);
                WebElement afuera = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afuera.click();
                factorVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                factorVida.clear();
                Thread.sleep(2000);
                factorVida.sendKeys(polizaBean.getFactorVida());
                Thread.sleep(2000);
                WebElement afueraClick = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afueraClick.click();
            }

            if (polizaBean.getValorSeguroPrima() != null){
                Thread.sleep(2000);
                WebElement valorSeguro = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                valorSeguro.click();
                Thread.sleep(2000);
                WebElement afuera = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afuera.click();
                valorSeguro = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                valorSeguro.clear();
                Thread.sleep(2000);
                valorSeguro.sendKeys(polizaBean.getValorSeguroPrima());
                Thread.sleep(2000);
                WebElement afueraClick = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afueraClick.click();
            }

            if (polizaBean.getFechaDesembolso() != null){
                Thread.sleep(2000);
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_fieldDate']"));
                fechaProceso.sendKeys(polizaBean.getFechaDesembolso());
            }

            if (polizaBean.getValorPrestamo() != null){
                Thread.sleep(2000);
                WebElement valorPrestamo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field']"));
                valorPrestamo.click();
                Thread.sleep(1000);
                WebElement afuera = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afuera.click();
                valorPrestamo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field']"));
                valorPrestamo.clear();
                Thread.sleep(2000);
                valorPrestamo.sendKeys(polizaBean.getValorPrestamo());
                Thread.sleep(1000);
                WebElement afueraClick = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afueraClick.click();
            }

            if (polizaBean.getCuotasPactadas() != null){
                Thread.sleep(2000);
                WebElement cuotasPactadas = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_field']"));
                cuotasPactadas.sendKeys(polizaBean.getCuotasPactadas());
            }

            if (polizaBean.getSaldoCapital() != null){
                Thread.sleep(2000);
                WebElement saldoCapital = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                saldoCapital.sendKeys(polizaBean.getSaldoCapital());
            }

            if (polizaBean.getEstadoCredito() != null){
                Thread.sleep(2000);
                Select estadoCredito = new Select(driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                estadoCredito.selectByValue(polizaBean.getEstadoCredito());
            }

            if (polizaBean.getCuotasMora() != null){
                Thread.sleep(2000);
                WebElement cuotasMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                cuotasMora.sendKeys(polizaBean.getCuotasMora());
            }

            if (polizaBean.getFechaProceso() != null) {
                Thread.sleep(2000);
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                fechaProceso.sendKeys(polizaBean.getFechaProceso());
            }

            if (polizaBean.getFechaPago() != null) {
                Thread.sleep(2000);
                WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_fieldDate']"));
                fechaPago.click();

                Thread.sleep(1000);
                WebElement afuera = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afuera.click();
                Thread.sleep(2000);
                fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_fieldDate']"));
                //fechaPago.clear();

                fechaPago.sendKeys(polizaBean.getFechaPago());

                Thread.sleep(1000);
                WebElement afueraClick = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                afueraClick.click();
            }

            if (polizaBean.getCuotaPagada() != null) {
                Thread.sleep(2000);
                WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field']"));
                fechaPago.sendKeys(polizaBean.getCuotaPagada());
            }
            if (polizaBean.getFechaMora() != null) {
                Thread.sleep(2000);
                WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_fieldDate']"));
                fechaPago.sendKeys(polizaBean.getFechaMora());
            }
            if (polizaBean.getPorcentajeFacultativo() != null) {
                Thread.sleep(2000);
                WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                fechaPago.sendKeys(polizaBean.getPorcentajeFacultativo());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

            /** Espere **/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Guardar Unidad de Riesgo");
            }

            Thread.sleep(2000);
            WebElement mensajefecha = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_feedbackLabel']"));
            if (mensajefecha.isDisplayed()){
                Thread.sleep(1000);
                WebElement fechaProceso2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                fechaProceso2.sendKeys(polizaBean.getFechaProceso());
                Thread.sleep(1000);

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                btnGuardar.click();
            }

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void UnidadRiesgoOld(Metodos13_8 a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
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
            /*if (emisionPolizaBeneficiarioNaturalBean.getNumUnidadRiesgo() != null){
                WebElement numUnidadRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                Thread.sleep(1000);
                numUnidadRiesgo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumUnidadRiesgo());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNumCredito() != null){
                WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                Thread.sleep(1000);
                numCredito.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumCredito());
            }*/
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
            /*if (emisionPolizaBeneficiarioNaturalBean.getEdoCredito() != null){
                Select estadoCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                Thread.sleep(1000);
                estadoCredito.selectByValue(emisionPolizaBeneficiarioNaturalBean.getEdoCredito());
            }*/
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
            /*if (emisionPolizaBeneficiarioNaturalBean.getPorcFacultativo() != null){
                WebElement porcentajeFacultativo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                Thread.sleep(1000);
                porcentajeFacultativo.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcFacultativo());
            }*/
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
