package AcseleV13_8LBC.main.controller.LBC_PolizaEmision;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos13_8;
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

    public void ObjetoAsegurado(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (polizaBean.getDocumentoIdentidadAsegurado() != null) {
                Thread.sleep(1000);
                WebElement docIdAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                docIdAsegurado.sendKeys(polizaBean.getDocumentoIdentidadAsegurado());
            }

            if (polizaBean.getFechaNacimientoAsegurado() != null) {
                Thread.sleep(1000);
                WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                fechaNacAsegurado.sendKeys(polizaBean.getFechaNacimientoAsegurado());
            }

            if (polizaBean.getDireccionAsegurado() != null) {
                Thread.sleep(3000);
                WebElement direccionAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                direccionAsegurado.sendKeys(polizaBean.getDireccionAsegurado());
            }


            Thread.sleep(2000);
            if (polizaBean.getDepartamento() != null) {
                Thread.sleep(1000);
                Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                departamento.selectByValue(polizaBean.getDepartamento());

//                Thread.sleep(2000);
//                String city = "CALAMAR";
//                if (city != null) {
//                    Thread.sleep(1000);
//                    Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
//                    ciudad.selectByValue(city);
//                }

            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Guardar Objeto Asegurado");
            }

            Thread.sleep(2000);
            WebElement mensajeDep = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_feedbackLabel']"));
            if (mensajeDep.isDisplayed()){
                Thread.sleep(2000);
                if (polizaBean.getDepartamento() != null) {
                    Thread.sleep(1000);
                    Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                    departamento.selectByValue(polizaBean.getDepartamento());

                    Thread.sleep(2000);
                    if (polizaBean.getCiudad() != null) {
                        Thread.sleep(1000);
                        Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
                        ciudad.selectByValue(polizaBean.getCiudad());
                    }

                }
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                Thread.sleep(2000);
                WebElement btnguardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
                btnguardar.click();

                /***Espera***/
                Thread.sleep(1000);
                mensajeEspera = driver.findElement(By.id("waitMessage"));
                while (mensajeEspera.isDisplayed()){
                    Thread.sleep(5000);
                    System.out.println("Espera Guardar Objeto Asegurado");
                }
            }

            Thread.sleep(2000);
            WebElement mensajeFechaNacAseg = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_feedbackLabel']"));
            if (mensajeFechaNacAseg.isDisplayed()){

                if (polizaBean.getFechaNacimientoAsegurado() != null) {
                    Thread.sleep(1000);
                    WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                    fechaNacAsegurado.sendKeys(polizaBean.getFechaNacimientoAsegurado());
                }
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                Thread.sleep(2000);
                WebElement btnguardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
                btnguardar.click();

                /***Espera***/
                Thread.sleep(1000);
                mensajeEspera = driver.findElement(By.id("waitMessage"));
                while (mensajeEspera.isDisplayed()){
                    Thread.sleep(5000);
                    System.out.println("Espera Guardar Objeto Asegurado");
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ObjetoAseguradoOld(Metodos13_8 a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean,
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
            /*if (emisionPolizaBeneficiarioNaturalBean.getPorcExtraPrima() != null){
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
            */
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
