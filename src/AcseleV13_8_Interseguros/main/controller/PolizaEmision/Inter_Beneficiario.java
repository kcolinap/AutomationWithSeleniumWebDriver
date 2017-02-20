package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 24/11/2016.
 */
public class Inter_Beneficiario {

    private final static Logger log = Logger.getLogger(Inter_Beneficiario.class);

    public void AgregarBeneficiario1(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getBeneficiario1Nombre1() != null || interPolizaBean.getBeneficiario1Nombre2() != null || interPolizaBean.getBeneficiario1Apellido1() != null || interPolizaBean.getBeneficiario1Apellido2() != null) {

                WebElement beneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                beneficiario.click();
                beneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getBeneficiario1Nombre1() != null && interPolizaBean.getBeneficiario1Nombre2() != null && interPolizaBean.getBeneficiario1Apellido1() != null && interPolizaBean.getBeneficiario1Apellido2() != null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario1Nombre1() + " " + interPolizaBean.getBeneficiario1Nombre2() + " " + interPolizaBean.getBeneficiario1Apellido1() + " " + interPolizaBean.getBeneficiario1Apellido2());
                }
                else if (interPolizaBean.getBeneficiario1Nombre1() != null && interPolizaBean.getBeneficiario1Nombre2() != null && interPolizaBean.getBeneficiario1Apellido1() != null && interPolizaBean.getBeneficiario1Apellido2() == null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario1Nombre1() + " " + interPolizaBean.getBeneficiario1Nombre2() + " " + interPolizaBean.getBeneficiario1Apellido1());
                }
                else if (interPolizaBean.getBeneficiario1Nombre1() != null && interPolizaBean.getBeneficiario1Nombre2() == null && interPolizaBean.getBeneficiario1Apellido1() != null && interPolizaBean.getBeneficiario1Apellido2() != null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario1Nombre1() + " " + interPolizaBean.getBeneficiario1Apellido1() + " " + interPolizaBean.getBeneficiario1Apellido2());
                }
                else if (interPolizaBean.getBeneficiario1Nombre1() != null && interPolizaBean.getBeneficiario1Nombre2() == null && interPolizaBean.getBeneficiario1Apellido1() != null && interPolizaBean.getBeneficiario1Apellido2() == null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario1Nombre1() + " " + interPolizaBean.getBeneficiario1Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selBeneficiario = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li"));
            // /html/body/div[6]/div/ul/li[1]
            selBeneficiario.click();
            Thread.sleep(2000);



            WebElement asociarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarBeneficiario.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Beneficiario");

            if (interPolizaBean.getTipoBeneficiario1() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                planFinanciamiento.selectByValue(interPolizaBean.getTipoBeneficiario1());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getBeneficiarioIrrevocable1() != null){
                if (interPolizaBean.getBeneficiarioIrrevocable1().toLowerCase().equals("no")) {
                    WebElement btnBeneficiarioIrrevocable = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_1_radio']"));
                    btnBeneficiarioIrrevocable.click();
                    Thread.sleep(1000);
                }
                else if (interPolizaBean.getBeneficiarioIrrevocable1().toLowerCase().equals("si")) {
                    WebElement btnBeneficiarioIrrevocable = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_2_radio']"));
                    btnBeneficiarioIrrevocable.click();
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getPorcentajeBeneficiario1() != null && !interPolizaBean.getPorcentajeBeneficiario1().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeBeneficiario1());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getCodigoBeneficiario1() != null){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_2_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getCodigoBeneficiario1());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getParentescoBeneficiario1() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
                planFinanciamiento.selectByValue(interPolizaBean.getParentescoBeneficiario1());
                Thread.sleep(2000);
            }

            jse.executeScript("window.scrollBy(0,150)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement guardarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            guardarBeneficiario.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Seleccionar Modo de Pago del Contratante");

            //jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            /*e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());*/
        }
    }

    public void AgregarBeneficiario2(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getBeneficiario2Nombre1() != null || interPolizaBean.getBeneficiario2Nombre2() != null || interPolizaBean.getBeneficiario2Apellido1() != null || interPolizaBean.getBeneficiario2Apellido2() != null) {

                WebElement beneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                beneficiario.click();
                beneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getBeneficiario2Nombre1() != null && interPolizaBean.getBeneficiario2Nombre2() != null && interPolizaBean.getBeneficiario2Apellido1() != null && interPolizaBean.getBeneficiario2Apellido2() != null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario2Nombre1() + " " + interPolizaBean.getBeneficiario2Nombre2() + " " + interPolizaBean.getBeneficiario2Apellido1() + " " + interPolizaBean.getBeneficiario2Apellido2());
                }
                else if (interPolizaBean.getBeneficiario2Nombre1() != null && interPolizaBean.getBeneficiario2Nombre2() != null && interPolizaBean.getBeneficiario2Apellido1() != null && interPolizaBean.getBeneficiario2Apellido2() == null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario2Nombre1() + " " + interPolizaBean.getBeneficiario2Nombre2() + " " + interPolizaBean.getBeneficiario2Apellido1());
                }
                else if (interPolizaBean.getBeneficiario2Nombre1() != null && interPolizaBean.getBeneficiario2Nombre2() == null && interPolizaBean.getBeneficiario2Apellido1() != null && interPolizaBean.getBeneficiario2Apellido2() != null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario2Nombre1() + " " + interPolizaBean.getBeneficiario2Apellido1() + " " + interPolizaBean.getBeneficiario2Apellido2());
                }
                else if (interPolizaBean.getBeneficiario2Nombre1() != null && interPolizaBean.getBeneficiario2Nombre2() == null && interPolizaBean.getBeneficiario2Apellido1() != null && interPolizaBean.getBeneficiario2Apellido2() == null) {
                    beneficiario.sendKeys(interPolizaBean.getBeneficiario2Nombre1() + " " + interPolizaBean.getBeneficiario2Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selBeneficiario = driver.findElement(By.xpath("/html/body/div[10]/div/ul/li"));
            // /html/body/div[6]/div/ul/li[1]
            selBeneficiario.click();
            Thread.sleep(2000);



            WebElement asociarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarBeneficiario.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Beneficiario");

            if (interPolizaBean.getTipoBeneficiario2() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                planFinanciamiento.selectByValue(interPolizaBean.getTipoBeneficiario2());
                Thread.sleep(2000);
            }

            if (interPolizaBean.getBeneficiarioIrrevocable2() != null){
                if (interPolizaBean.getBeneficiarioIrrevocable2().toLowerCase().equals("no")) {
                    WebElement btnBeneficiarioIrrevocable = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_1_radio']"));
                    btnBeneficiarioIrrevocable.click();
                    Thread.sleep(1000);
                }
                else if (interPolizaBean.getBeneficiarioIrrevocable2().toLowerCase().equals("si")) {
                    WebElement btnBeneficiarioIrrevocable = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_2_fila_field_repeaterChoice_2_radio']"));
                    btnBeneficiarioIrrevocable.click();
                    Thread.sleep(1000);
                }
            }

            if (interPolizaBean.getPorcentajeBeneficiario2() != null && !interPolizaBean.getPorcentajeBeneficiario2().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeBeneficiario2());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getCodigoBeneficiario2() != null){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_2_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getCodigoBeneficiario2());
                Thread.sleep(1000);
            }

            if (interPolizaBean.getParentescoBeneficiario2() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
                planFinanciamiento.selectByValue(interPolizaBean.getParentescoBeneficiario2());
                Thread.sleep(2000);
            }

            jse.executeScript("window.scrollBy(0,150)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement guardarBeneficiario = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            guardarBeneficiario.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Seleccionar Modo de Pago del Contratante");

            //jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            /*e.printStackTrace();
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            sw.toString(); // stack trace as a string
            //log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + sw.toString());*/
        }
    }

}
