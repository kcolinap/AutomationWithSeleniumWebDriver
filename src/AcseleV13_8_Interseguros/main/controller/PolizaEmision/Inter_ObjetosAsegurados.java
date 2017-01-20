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
 * Created by agil on 24/11/2016.
 */
public class Inter_ObjetosAsegurados {

    private final static Logger log = Logger.getLogger(Inter_ObjetosAsegurados.class);

    public void ObjetoAsegurado1_Inteligo(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            //WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            //btnNuevo.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado1());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNombreCompletoAsegurado1() != null){
                WebElement nombreCompletoAsegurado1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (nombreCompletoAsegurado1.isEnabled()) {
                    nombreCompletoAsegurado1.clear();
                    nombreCompletoAsegurado1.sendKeys(interPolizaBean.getNombreCompletoAsegurado1());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNombreCompletoBeneficiario1() != null){
                WebElement nombreCompletoBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (nombreCompletoBeneficiario1.isEnabled()) {
                    nombreCompletoBeneficiario1.clear();
                    nombreCompletoBeneficiario1.sendKeys(interPolizaBean.getNombreCompletoBeneficiario1());
                    Thread.sleep(1000);
                }
            }

            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }

    public void ObjetoAsegurado2_Inteligo(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            btnNuevo.click();

            /*Thread.sleep(2000);
            WebElement seleccionarNuevoOA = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_InsuranceObjectTable_InsuranceObjectsTable_2_insuranceItem_IONameLink_IOName']"));
            seleccionarNuevoOA.click();
            Thread.sleep(1000);*/

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado2() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                numUnidRiesgo.clear();
                numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado2());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getNombreCompletoAsegurado2() != null){
                WebElement nombreCompletoAsegurado1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (nombreCompletoAsegurado1.isEnabled()) {
                    nombreCompletoAsegurado1.clear();
                    nombreCompletoAsegurado1.sendKeys(interPolizaBean.getNombreCompletoAsegurado2());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNombreCompletoBeneficiario2() != null){
                WebElement nombreCompletoBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (nombreCompletoBeneficiario1.isEnabled()) {
                    nombreCompletoBeneficiario1.clear();
                    nombreCompletoBeneficiario1.sendKeys(interPolizaBean.getNombreCompletoBeneficiario2());
                    Thread.sleep(1000);
                }
            }

            //jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }

    public void ObjetoAsegurado1_DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                if (numUnidRiesgo.isEnabled()) {
                    numUnidRiesgo.clear();
                    numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado1());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNumOACOT() != null){
                WebElement numOACOT = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (numOACOT.isEnabled()) {
                    numOACOT.clear();
                    numOACOT.sendKeys(interPolizaBean.getNumOACOT());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getFechaNacimientoCotizador() != null){
                WebElement fechaNacimientoCotizador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_fieldDate']"));
                fechaNacimientoCotizador.clear();
                fechaNacimientoCotizador.sendKeys(interPolizaBean.getFechaNacimientoCotizador());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getSexoAseguradoCotizador() != null){
                Select sexoAseguradoCotizador = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                sexoAseguradoCotizador.selectByValue(interPolizaBean.getSexoAseguradoCotizador());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCotizadorFumador() != null){
                Select cotizadorFumador = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                cotizadorFumador.selectByValue(interPolizaBean.getCotizadorFumador());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getEdadActuarialAsegurado() != null){
                WebElement edadActuarialAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (edadActuarialAsegurado.isEnabled()) {
                    edadActuarialAsegurado.sendKeys(interPolizaBean.getEdadActuarialAsegurado());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMinimaIngreso() != null){
                WebElement edadMinimaIngreso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                if (edadMinimaIngreso.isEnabled()) {
                    edadMinimaIngreso.sendKeys(interPolizaBean.getEdadMinimaIngreso());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMaximaIngreso() != null){
                WebElement edadMaximaIngreso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                if (edadMaximaIngreso.isEnabled()) {
                    edadMaximaIngreso.sendKeys(interPolizaBean.getEdadMaximaIngreso());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMaximaPermanencia() != null){
                WebElement edadMaximaPermanencia = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                if (edadMaximaPermanencia.isEnabled()) {
                    edadMaximaPermanencia.sendKeys(interPolizaBean.getEdadMaximaPermanencia());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            /* **************************Beneficiario No. 1************************************* */
            if (interPolizaBean.getInformacionBeneficiario1Apellido1() != null){
                WebElement informacionBeneficiario1Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_2_fila_field']"));
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                informacionBeneficiario1Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario1Apellido1());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1Apellido2() != null){
                WebElement informacionBeneficiario1Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_field']"));
                informacionBeneficiario1Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario1Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1Nombres() != null){
                WebElement informacionBeneficiario1Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_4_fila_field']"));
                informacionBeneficiario1Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario1Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1FechaNacimiento() != null){
                WebElement informacionBeneficiario1FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_5_fila_fieldDate']"));
                informacionBeneficiario1FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario1FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1DocumentoIdentidad() != null){
                WebElement informacionBeneficiario1DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_6_fila_field']"));
                informacionBeneficiario1DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario1DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1Parentesco() != null){
                Select informacionBeneficiario1Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                informacionBeneficiario1Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario1Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1PorcDistribucion() != null){
                WebElement informacionBeneficiario1PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_8_fila_field']"));
                informacionBeneficiario1PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario1PorcDistribucion());
                Thread.sleep(2000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            /* *************************Beneficiario No. 2************************************** */
            if (interPolizaBean.getInformacionBeneficiario2Apellido1() != null){
                WebElement informacionBeneficiario2Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_10_fila_field']"));
                informacionBeneficiario2Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2Apellido2() != null){
                WebElement informacionBeneficiario2Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_11_fila_field']"));
                informacionBeneficiario2Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2Nombres() != null){
                WebElement informacionBeneficiario2Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_12_fila_field']"));
                informacionBeneficiario2Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2DocumentoIdentidad() != null){
                WebElement informacionBeneficiario2DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_1_fila_field']"));
                informacionBeneficiario2DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2FechaNacimiento() != null){
                WebElement informacionBeneficiario2FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_2_fila_fieldDate']"));
                informacionBeneficiario2FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2Parentesco() != null){
                Select informacionBeneficiario2Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                informacionBeneficiario2Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2PorcDistribucion() != null){
                WebElement informacionBeneficiario2PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_4_fila_field']"));
                informacionBeneficiario2PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            /* *************************Beneficiario No. 3************************************** */
            if (interPolizaBean.getInformacionBeneficiario3Apellido1() != null){
                WebElement informacionBeneficiario3Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_6_fila_field']"));
                informacionBeneficiario3Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario3Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Apellido2() != null){
                WebElement informacionBeneficiario3Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_7_fila_field']"));
                informacionBeneficiario3Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario3Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Nombres() != null){
                WebElement informacionBeneficiario3Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_8_fila_field']"));
                informacionBeneficiario3Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario3Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3DocumentoIdentidad() != null){
                WebElement informacionBeneficiario3DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_9_fila_field']"));
                informacionBeneficiario3DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario3DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3FechaNacimiento() != null){
                WebElement informacionBeneficiario3FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_10_fila_fieldDate']"));
                informacionBeneficiario3FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario3FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Parentesco() != null){
                Select informacionBeneficiario3Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_11_fila_repeaterSelect_1_field']")));
                informacionBeneficiario3Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario3Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3PorcDistribucion() != null){
                WebElement informacionBeneficiario3PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_12_fila_field']"));
                informacionBeneficiario3PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario3PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */








            /* *************************INFORMACION Beneficiario No. 1************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente1Apellido1() != null){
                WebElement informacionBeneficiarioContingente1Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_2_fila_field']"));
                informacionBeneficiarioContingente1Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1Apellido2() != null){
                WebElement informacionBeneficiarioContingente1Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_3_fila_field']"));
                informacionBeneficiarioContingente1Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1Nombres() != null){
                WebElement informacionBeneficiarioContingente1Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_4_fila_field']"));
                informacionBeneficiarioContingente1Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente1FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_5_fila_fieldDate']"));
                informacionBeneficiarioContingente1FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente1DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_6_fila_field']"));
                informacionBeneficiarioContingente1DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1Parentesco() != null){
                Select informacionBeneficiarioContingente1Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                informacionBeneficiarioContingente1Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente1Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente1PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_8_fila_field']"));
                informacionBeneficiarioContingente1PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            /* *************************INFORMACION Beneficiario No. 2************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente2Apellido1() != null){
                WebElement informacionBeneficiarioContingente2Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_1_fila_field']"));
                informacionBeneficiarioContingente2Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Apellido2() != null){
                WebElement informacionBeneficiarioContingente2Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_2_fila_field']"));
                informacionBeneficiarioContingente2Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Nombres() != null){
                WebElement informacionBeneficiarioContingente2Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_3_fila_field']"));
                informacionBeneficiarioContingente2Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente2FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                informacionBeneficiarioContingente2FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente2DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_5_fila_field']"));
                informacionBeneficiarioContingente2DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Parentesco() != null){
                Select informacionBeneficiarioContingente2Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                informacionBeneficiarioContingente2Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getEstadoPropuesta() != null){
                Select estadoPropuesta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_7_fila_repeaterSelect_1_field']")));
                estadoPropuesta.selectByValue(interPolizaBean.getEstadoPropuesta());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente2PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_8_fila_field']"));
                informacionBeneficiarioContingente2PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */


            jse.executeScript("window.scrollBy(0,-1300)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
            e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());
        }
    }

    public void ObjetoAsegurado2_DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement nuevoObjetoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            nuevoObjetoAsegurado.click();

            a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            if (interPolizaBean.getNumeroObjetoAsegurado1() != null){
                WebElement numUnidRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                if (numUnidRiesgo.isEnabled()) {
                    numUnidRiesgo.clear();
                    numUnidRiesgo.sendKeys(interPolizaBean.getNumeroObjetoAsegurado1());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getNumOACOT() != null){
                WebElement numOACOT = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                if (numOACOT.isEnabled()) {
                    numOACOT.clear();
                    numOACOT.sendKeys(interPolizaBean.getNumOACOT());
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getFechaNacimientoCotizador() != null){
                WebElement fechaNacimientoCotizador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_fieldDate']"));
                fechaNacimientoCotizador.clear();
                fechaNacimientoCotizador.sendKeys(interPolizaBean.getFechaNacimientoCotizador());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getSexoAseguradoCotizador() != null){
                Select sexoAseguradoCotizador = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                sexoAseguradoCotizador.selectByValue(interPolizaBean.getSexoAseguradoCotizador());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getCotizadorFumador() != null){
                Select cotizadorFumador = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                cotizadorFumador.selectByValue(interPolizaBean.getCotizadorFumador());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getEdadActuarialAsegurado() != null){
                WebElement edadActuarialAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                if (edadActuarialAsegurado.isEnabled()) {
                    edadActuarialAsegurado.sendKeys(interPolizaBean.getEdadActuarialAsegurado());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMinimaIngreso() != null){
                WebElement edadMinimaIngreso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                if (edadMinimaIngreso.isEnabled()) {
                    edadMinimaIngreso.sendKeys(interPolizaBean.getEdadMinimaIngreso());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMaximaIngreso() != null){
                WebElement edadMaximaIngreso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                if (edadMaximaIngreso.isEnabled()) {
                    edadMaximaIngreso.sendKeys(interPolizaBean.getEdadMaximaIngreso());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMaximaPermanencia() != null){
                WebElement edadMaximaPermanencia = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                if (edadMaximaPermanencia.isEnabled()) {
                    edadMaximaPermanencia.sendKeys(interPolizaBean.getEdadMaximaPermanencia());
                    otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            /* **************************Beneficiario No. 1************************************* */
            if (interPolizaBean.getInformacionBeneficiario1Apellido1() != null){
                WebElement informacionBeneficiario1Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_2_fila_field']"));
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                informacionBeneficiario1Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario1Apellido1());
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1Apellido2() != null){
                WebElement informacionBeneficiario1Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_field']"));
                informacionBeneficiario1Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario1Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1Nombres() != null){
                WebElement informacionBeneficiario1Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_4_fila_field']"));
                informacionBeneficiario1Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario1Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1FechaNacimiento() != null){
                WebElement informacionBeneficiario1FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_5_fila_fieldDate']"));
                informacionBeneficiario1FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario1FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1DocumentoIdentidad() != null){
                WebElement informacionBeneficiario1DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_6_fila_field']"));
                informacionBeneficiario1DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario1DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1Parentesco() != null){
                Select informacionBeneficiario1Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                informacionBeneficiario1Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario1Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario1PorcDistribucion() != null){
                WebElement informacionBeneficiario1PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_8_fila_field']"));
                informacionBeneficiario1PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario1PorcDistribucion());
                Thread.sleep(2000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            /* *************************Beneficiario No. 2************************************** */
            if (interPolizaBean.getInformacionBeneficiario2Apellido1() != null){
                WebElement informacionBeneficiario2Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_10_fila_field']"));
                informacionBeneficiario2Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2Apellido2() != null){
                WebElement informacionBeneficiario2Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_11_fila_field']"));
                informacionBeneficiario2Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2Nombres() != null){
                WebElement informacionBeneficiario2Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_12_fila_field']"));
                informacionBeneficiario2Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2DocumentoIdentidad() != null){
                WebElement informacionBeneficiario2DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_1_fila_field']"));
                informacionBeneficiario2DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2FechaNacimiento() != null){
                WebElement informacionBeneficiario2FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_2_fila_fieldDate']"));
                informacionBeneficiario2FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2Parentesco() != null){
                Select informacionBeneficiario2Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                informacionBeneficiario2Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario2PorcDistribucion() != null){
                WebElement informacionBeneficiario2PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_4_fila_field']"));
                informacionBeneficiario2PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            /* *************************Beneficiario No. 3************************************** */
            if (interPolizaBean.getInformacionBeneficiario3Apellido1() != null){
                WebElement informacionBeneficiario3Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_6_fila_field']"));
                informacionBeneficiario3Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario3Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Apellido2() != null){
                WebElement informacionBeneficiario3Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_7_fila_field']"));
                informacionBeneficiario3Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario3Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Nombres() != null){
                WebElement informacionBeneficiario3Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_8_fila_field']"));
                informacionBeneficiario3Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario3Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3DocumentoIdentidad() != null){
                WebElement informacionBeneficiario3DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_9_fila_field']"));
                informacionBeneficiario3DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario3DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3FechaNacimiento() != null){
                WebElement informacionBeneficiario3FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_10_fila_fieldDate']"));
                informacionBeneficiario3FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario3FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Parentesco() != null){
                Select informacionBeneficiario3Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_11_fila_repeaterSelect_1_field']")));
                informacionBeneficiario3Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario3Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3PorcDistribucion() != null){
                WebElement informacionBeneficiario3PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_12_fila_field']"));
                informacionBeneficiario3PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario3PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */








            /* *************************INFORMACION Beneficiario No. 1************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente1Apellido1() != null){
                WebElement informacionBeneficiarioContingente1Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_2_fila_field']"));
                informacionBeneficiarioContingente1Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1Apellido2() != null){
                WebElement informacionBeneficiarioContingente1Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_3_fila_field']"));
                informacionBeneficiarioContingente1Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1Nombres() != null){
                WebElement informacionBeneficiarioContingente1Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_4_fila_field']"));
                informacionBeneficiarioContingente1Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente1FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_5_fila_fieldDate']"));
                informacionBeneficiarioContingente1FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente1DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_6_fila_field']"));
                informacionBeneficiarioContingente1DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1Parentesco() != null){
                Select informacionBeneficiarioContingente1Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                informacionBeneficiarioContingente1Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente1Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente1PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente1PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_8_fila_field']"));
                informacionBeneficiarioContingente1PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente1PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            /* *************************INFORMACION Beneficiario No. 2************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente2Apellido1() != null){
                WebElement informacionBeneficiarioContingente2Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_1_fila_field']"));
                informacionBeneficiarioContingente2Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Apellido2() != null){
                WebElement informacionBeneficiarioContingente2Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_2_fila_field']"));
                informacionBeneficiarioContingente2Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Nombres() != null){
                WebElement informacionBeneficiarioContingente2Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_3_fila_field']"));
                informacionBeneficiarioContingente2Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente2FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                informacionBeneficiarioContingente2FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente2DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_5_fila_field']"));
                informacionBeneficiarioContingente2DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Parentesco() != null){
                Select informacionBeneficiarioContingente2Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                informacionBeneficiarioContingente2Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getEstadoPropuesta() != null){
                Select estadoPropuesta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_7_fila_repeaterSelect_1_field']")));
                estadoPropuesta.selectByValue(interPolizaBean.getEstadoPropuesta());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente2PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_8_fila_field']"));
                informacionBeneficiarioContingente2PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */


            jse.executeScript("window.scrollBy(0,-1300)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

        }catch (Exception e) {
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
