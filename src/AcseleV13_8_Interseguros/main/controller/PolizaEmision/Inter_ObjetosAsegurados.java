package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 24/11/2016.
 */
public class Inter_ObjetosAsegurados {

    private final static Logger log = Logger.getLogger(Inter_ObjetosAsegurados.class);

    public void ObjetoAsegurado1_Inteligo(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

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
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAsegurado2_Inteligo(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot){

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
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAsegurado1_DotalSimple(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);
            WebElement otroElemento; //= driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));

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
                    //otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMinimaIngreso() != null){
                WebElement edadMinimaIngreso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                if (edadMinimaIngreso.isEnabled()) {
                    edadMinimaIngreso.sendKeys(interPolizaBean.getEdadMinimaIngreso());
                    //otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMaximaIngreso() != null){
                WebElement edadMaximaIngreso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                if (edadMaximaIngreso.isEnabled()) {
                    edadMaximaIngreso.sendKeys(interPolizaBean.getEdadMaximaIngreso());
                    //otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            if (interPolizaBean.getEdadMaximaPermanencia() != null){
                WebElement edadMaximaPermanencia = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                if (edadMaximaPermanencia.isEnabled()) {
                    edadMaximaPermanencia.sendKeys(interPolizaBean.getEdadMaximaPermanencia());
                    //otroElemento.click();
                    Thread.sleep(2000);
                }
            }

            /* **************************Beneficiario No. 1************************************* */
            if (interPolizaBean.getInformacionBeneficiario1Apellido1() != null){

                WebElement informacionBeneficiario1Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_2_fila_field']"));
                informacionBeneficiario1Apellido1.clear();
                Thread.sleep(1000);
                informacionBeneficiario1Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_2_fila_field']"));
                informacionBeneficiario1Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario1Apellido1());
                Thread.sleep(3000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_2_fila_etiqueta']"));
                otroElemento.click();
            }

            if (interPolizaBean.getInformacionBeneficiario1Apellido2() != null){
                WebElement informacionBeneficiario1Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_field']"));
                informacionBeneficiario1Apellido2.clear();
                Thread.sleep(3000);
                informacionBeneficiario1Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_field']"));
                informacionBeneficiario1Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario1Apellido2());
                Thread.sleep(4000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_3_fila_etiqueta']"));
                otroElemento.click();
            }

            if (interPolizaBean.getInformacionBeneficiario1Nombres() != null){


                WebElement informacionBeneficiario1Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_4_fila_field']"));
                informacionBeneficiario1Nombres.clear();
                Thread.sleep(3000);
                informacionBeneficiario1Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_4_fila_field']"));
                informacionBeneficiario1Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario1Nombres());
                Thread.sleep(4000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_4_fila_etiqueta']"));
                otroElemento.click();
            }

            if (interPolizaBean.getInformacionBeneficiario1FechaNacimiento() != null){;
                WebElement informacionBeneficiario1FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_5_fila_fieldDate']"));
                informacionBeneficiario1FechaNacimiento.clear();
                Thread.sleep(3000);
                informacionBeneficiario1FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_5_fila_fieldDate']"));
                informacionBeneficiario1FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario1FechaNacimiento());
                Thread.sleep(4000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_5_fila_etiqueta']"));
                otroElemento.click();
            }

            if (interPolizaBean.getInformacionBeneficiario1DocumentoIdentidad() != null){
                WebElement informacionBeneficiario1DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_6_fila_field']"));
                informacionBeneficiario1DocumentoIdentidad.clear();
                Thread.sleep(3000);
                informacionBeneficiario1DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_6_fila_field']"));
                informacionBeneficiario1DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario1DocumentoIdentidad());
                Thread.sleep(3000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_14_fila_etiqueta']"));
                otroElemento.click();
            }

            if (interPolizaBean.getInformacionBeneficiario1Parentesco() != null){
                Select informacionBeneficiario1Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                informacionBeneficiario1Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario1Parentesco());
                Thread.sleep(3000);
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_7_fila_repeaterSelect_1_etiqueta']"));
                otroElemento.click();
                Thread.sleep(3000);
                informacionBeneficiario1Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                informacionBeneficiario1Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario1Parentesco());
                Thread.sleep(3000);
            }

            if (interPolizaBean.getInformacionBeneficiario1PorcDistribucion() != null){
                WebElement informacionBeneficiario1PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_8_fila_field']"));
                informacionBeneficiario1PorcDistribucion.click();
                Thread.sleep(800);
                informacionBeneficiario1PorcDistribucion.sendKeys(Keys.chord(Keys.BACK_SPACE));
                Thread.sleep(1000);
                informacionBeneficiario1PorcDistribucion.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(1000);
                informacionBeneficiario1PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_8_fila_field']"));
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
                WebElement informacionBeneficiario3Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_18_fila_field']"));
                informacionBeneficiario3Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario3Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Apellido2() != null){
                WebElement informacionBeneficiario3Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_19_fila_field']"));
                informacionBeneficiario3Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario3Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Nombres() != null){
                WebElement informacionBeneficiario3Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_20_fila_field']"));
                informacionBeneficiario3Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario3Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3FechaNacimiento() != null){
                WebElement informacionBeneficiario3FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_21_fila_fieldDate']"));
                informacionBeneficiario3FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario3FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3DocumentoIdentidad() != null){
                WebElement informacionBeneficiario3DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_22_fila_field']"));
                informacionBeneficiario3DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario3DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3Parentesco() != null){
                Select informacionBeneficiario3Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_23_fila_repeaterSelect_1_field']")));
                informacionBeneficiario3Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario3Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario3PorcDistribucion() != null){
                WebElement informacionBeneficiario3PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_24_fila_field']"));
                informacionBeneficiario3PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario3PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */






            /* *************************Beneficiario No. 4************************************** */
            if (interPolizaBean.getInformacionBeneficiario4Apellido1() != null){
                WebElement informacionBeneficiario4Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_26_fila_field']"));
                informacionBeneficiario4Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario4Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario4Apellido2() != null){
                WebElement informacionBeneficiario4Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_27_fila_field']"));
                informacionBeneficiario4Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario4Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario4Nombres() != null){
                WebElement informacionBeneficiario4Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_28_fila_field']"));
                informacionBeneficiario4Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario4Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario4FechaNacimiento() != null){
                WebElement informacionBeneficiario4FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_29_fila_field']"));
                informacionBeneficiario4FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario4FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario4DocumentoIdentidad() != null){
                WebElement informacionBeneficiario4DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_30_fila_field']"));
                informacionBeneficiario4DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario4DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario4Parentesco() != null){
                Select informacionBeneficiario4Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_31_fila_field']")));
                informacionBeneficiario4Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario4Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario4PorcDistribucion() != null){
                WebElement informacionBeneficiario4PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_32_fila_field']"));
                informacionBeneficiario4PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario4PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */


            /* *************************Beneficiario No. 5************************************** */
            if (interPolizaBean.getInformacionBeneficiario5Apellido1() != null){
                WebElement informacionBeneficiario5Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_34_fila_field']"));
                informacionBeneficiario5Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario5Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario5Apellido2() != null){
                WebElement informacionBeneficiario5Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_35_fila_field']"));
                informacionBeneficiario5Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario5Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario5Nombres() != null){
                WebElement informacionBeneficiario5Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_36_fila_field']"));
                informacionBeneficiario5Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario5Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario5FechaNacimiento() != null){
                WebElement informacionBeneficiario5FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_37_fila_field']"));
                informacionBeneficiario5FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario5FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario5DocumentoIdentidad() != null){
                WebElement informacionBeneficiario5DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_38_fila_field']"));
                informacionBeneficiario5DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario5DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario5Parentesco() != null){
                Select informacionBeneficiario5Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_39_fila_field']")));
                informacionBeneficiario5Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario5Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario5PorcDistribucion() != null){
                WebElement informacionBeneficiario5PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater_40_fila_field']"));
                informacionBeneficiario5PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario5PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */



            /* *************************Beneficiario No. 6************************************** */
            if (interPolizaBean.getInformacionBeneficiario6Apellido1() != null){
                WebElement informacionBeneficiario6Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_2_fila_field']"));
                informacionBeneficiario6Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario6Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario6Apellido2() != null){
                WebElement informacionBeneficiario6Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_3_fila_field']"));
                informacionBeneficiario6Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario6Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario6Nombres() != null){
                WebElement informacionBeneficiario6Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_4_fila_field']"));
                informacionBeneficiario6Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario6Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario6FechaNacimiento() != null){
                WebElement informacionBeneficiario6FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_5_fila_field']"));
                informacionBeneficiario6FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario6FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario6DocumentoIdentidad() != null){
                WebElement informacionBeneficiario6DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_6_fila_field']"));
                informacionBeneficiario6DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario6DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario6Parentesco() != null){
                Select informacionBeneficiario6Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_7_fila_field']")));
                informacionBeneficiario6Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario6Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario6PorcDistribucion() != null){
                WebElement informacionBeneficiario6PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_8_fila_field']"));
                informacionBeneficiario6PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario6PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */



            /* *************************Beneficiario No. 7************************************** */
            if (interPolizaBean.getInformacionBeneficiario7Apellido1() != null){
                WebElement informacionBeneficiario7Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_10_fila_field']"));
                informacionBeneficiario7Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario7Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario7Apellido2() != null){
                WebElement informacionBeneficiario7Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_11_fila_field']"));
                informacionBeneficiario7Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario7Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario7Nombres() != null){
                WebElement informacionBeneficiario7Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_12_fila_field']"));
                informacionBeneficiario7Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario7Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario7FechaNacimiento() != null){
                WebElement informacionBeneficiario7FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_13_fila_field']"));
                informacionBeneficiario7FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario7FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario7DocumentoIdentidad() != null){
                WebElement informacionBeneficiario7DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_14_fila_field']"));
                informacionBeneficiario7DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario7DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario7Parentesco() != null){
                Select informacionBeneficiario7Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_15_fila_field']")));
                informacionBeneficiario7Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario7Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario7PorcDistribucion() != null){
                WebElement informacionBeneficiario7PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_16_fila_field']"));
                informacionBeneficiario7PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario7PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */



            /* *************************Beneficiario No. 8************************************** */
            if (interPolizaBean.getInformacionBeneficiario8Apellido1() != null){
                WebElement informacionBeneficiario8Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_18_fila_field']"));
                informacionBeneficiario8Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario8Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario8Apellido2() != null){
                WebElement informacionBeneficiario8Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_19_fila_field']"));
                informacionBeneficiario8Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario8Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario8Nombres() != null){
                WebElement informacionBeneficiario8Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_20_fila_field']"));
                informacionBeneficiario8Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario8Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario8FechaNacimiento() != null){
                WebElement informacionBeneficiario8FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_21_fila_field']"));
                informacionBeneficiario8FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario8FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario8DocumentoIdentidad() != null){
                WebElement informacionBeneficiario8DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_22_fila_field']"));
                informacionBeneficiario8DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario8DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario8Parentesco() != null){
                Select informacionBeneficiario8Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_23_fila_field']")));
                informacionBeneficiario8Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario8Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario8PorcDistribucion() != null){
                WebElement informacionBeneficiario8PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_24_fila_field']"));
                informacionBeneficiario8PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario8PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */


            /* *************************Beneficiario No. 9************************************** */
            if (interPolizaBean.getInformacionBeneficiario9Apellido1() != null){
                WebElement informacionBeneficiario9Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_26_fila_field']"));
                informacionBeneficiario9Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario9Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario9Apellido2() != null){
                WebElement informacionBeneficiario9Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_27_fila_field']"));
                informacionBeneficiario9Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario9Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario9Nombres() != null){
                WebElement informacionBeneficiario9Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_28_fila_field']"));
                informacionBeneficiario9Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario9Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario9FechaNacimiento() != null){
                WebElement informacionBeneficiario9FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_29_fila_field']"));
                informacionBeneficiario9FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario9FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario9DocumentoIdentidad() != null){
                WebElement informacionBeneficiario9DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_30_fila_field']"));
                informacionBeneficiario9DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario9DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario9Parentesco() != null){
                Select informacionBeneficiario9Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_31_fila_field']")));
                informacionBeneficiario9Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario9Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario9PorcDistribucion() != null){
                WebElement informacionBeneficiario9PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_32_fila_field']"));
                informacionBeneficiario9PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario9PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */


            /* *************************Beneficiario No. 10************************************** */
            if (interPolizaBean.getInformacionBeneficiario10Apellido1() != null){
                WebElement informacionBeneficiario10Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_34_fila_field']"));
                informacionBeneficiario10Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiario10Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario10Apellido2() != null){
                WebElement informacionBeneficiario10Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_35_fila_field']"));
                informacionBeneficiario10Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiario10Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario10Nombres() != null){
                WebElement informacionBeneficiario10Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_36_fila_field']"));
                informacionBeneficiario10Nombres.sendKeys(interPolizaBean.getInformacionBeneficiario10Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario10FechaNacimiento() != null){
                WebElement informacionBeneficiario10FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_37_fila_field']"));
                informacionBeneficiario10FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiario10FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario10DocumentoIdentidad() != null){
                WebElement informacionBeneficiario10DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_38_fila_field']"));
                informacionBeneficiario10DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiario10DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario10Parentesco() != null){
                Select informacionBeneficiario10Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_39_fila_field']")));
                informacionBeneficiario10Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiario10Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiario10PorcDistribucion() != null){
                WebElement informacionBeneficiario10PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_SubTabsInformation_repeater2_40_fila_field']"));
                informacionBeneficiario10PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiario10PorcDistribucion());
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
                WebElement informacionBeneficiarioContingente2Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_10_fila_field']"));
                informacionBeneficiarioContingente2Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Apellido2() != null){
                WebElement informacionBeneficiarioContingente2Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_11_fila_field']"));
                informacionBeneficiarioContingente2Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Nombres() != null){
                WebElement informacionBeneficiarioContingente2Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_12_fila_field']"));
                informacionBeneficiarioContingente2Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente2FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_13_fila_field']"));
                informacionBeneficiarioContingente2FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente2DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_14_fila_field']"));
                informacionBeneficiarioContingente2DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2Parentesco() != null){
                Select informacionBeneficiarioContingente2Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_15_fila_field']")));
                informacionBeneficiarioContingente2Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente2PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_16_fila_field']"));
                informacionBeneficiarioContingente2PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */




            /* *************************INFORMACION Beneficiario No. 3************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente3Apellido1() != null){
                WebElement informacionBeneficiarioContingente3Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_18_fila_field']"));
                informacionBeneficiarioContingente3Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente3Apellido2() != null){
                WebElement informacionBeneficiarioContingente3Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_19_fila_field']"));
                informacionBeneficiarioContingente3Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente3Nombres() != null){
                WebElement informacionBeneficiarioContingente3Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater_20_fila_field']"));
                informacionBeneficiarioContingente3Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente3FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente3FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_1_fila_fieldDate']"));
                informacionBeneficiarioContingente3FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente3DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente3DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_2_fila_fieldDate']"));
                informacionBeneficiarioContingente3DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente3Parentesco() != null){
                Select informacionBeneficiarioContingente3Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_3_fila_fieldDate']")));
                informacionBeneficiarioContingente3Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente3PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente3PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                informacionBeneficiarioContingente3PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */


            /* *************************INFORMACION Beneficiario No. 4************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente4Apellido1() != null){
                WebElement informacionBeneficiarioContingente4Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_6_fila_field']"));
                informacionBeneficiarioContingente4Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente4Apellido2() != null){
                WebElement informacionBeneficiarioContingente4Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_7_fila_field']"));
                informacionBeneficiarioContingente4Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente4Nombres() != null){
                WebElement informacionBeneficiarioContingente4Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_8_fila_field']"));
                informacionBeneficiarioContingente4Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente4FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente4FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_9_fila_field']"));
                informacionBeneficiarioContingente4FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente4DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente4DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_10_fila_field']"));
                informacionBeneficiarioContingente4DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente4Parentesco() != null){
                Select informacionBeneficiarioContingente4Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_11_fila_field']")));
                informacionBeneficiarioContingente4Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente4PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente4PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_12_fila_field']"));
                informacionBeneficiarioContingente4PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }
            /* *************************************************************** */



            /* *************************INFORMACION Beneficiario No. 5************************************** */
            if (interPolizaBean.getInformacionBeneficiarioContingente5Apellido1() != null){
                WebElement informacionBeneficiarioContingente5Apellido1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_14_fila_field']"));
                informacionBeneficiarioContingente5Apellido1.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido1());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente5Apellido2() != null){
                WebElement informacionBeneficiarioContingente5Apellido2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_15_fila_field']"));
                informacionBeneficiarioContingente5Apellido2.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Apellido2());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente5Nombres() != null){
                WebElement informacionBeneficiarioContingente5Nombres = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_16_fila_field']"));
                informacionBeneficiarioContingente5Nombres.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2Nombres());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente5FechaNacimiento() != null){
                WebElement informacionBeneficiarioContingente5FechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_17_fila_field']"));
                informacionBeneficiarioContingente5FechaNacimiento.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2FechaNacimiento());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente5DocumentoIdentidad() != null){
                WebElement informacionBeneficiarioContingente5DocumentoIdentidad = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_18_fila_field']"));
                informacionBeneficiarioContingente5DocumentoIdentidad.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2DocumentoIdentidad());
                otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_2_styleAcordeon_label']"));
                otroElemento.click();
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente5Parentesco() != null){
                Select informacionBeneficiarioContingente5Parentesco = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_19_fila_field']")));
                informacionBeneficiarioContingente5Parentesco.selectByValue(interPolizaBean.getInformacionBeneficiarioContingente2Parentesco());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getInformacionBeneficiarioContingente5PorcDistribucion() != null){
                WebElement informacionBeneficiarioContingente5PorcDistribucion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_3_SubTabsInformation_repeater2_20_fila_field']"));
                informacionBeneficiarioContingente5PorcDistribucion.sendKeys(interPolizaBean.getInformacionBeneficiarioContingente2PorcDistribucion());
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
            Boolean existe = false; //driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']")).isDisplayed();
            while (!existe){
                Thread.sleep(2000);
                btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
                btnGuardar.click();
                a.waitSearchWicket(driver, "Espere a que se muestre el asegurado");
                existe =  driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']")).isDisplayed();
                if (existe){
                    break;
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAsegurado2_DotalSimple(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

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
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
