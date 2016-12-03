package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by agil on 24/11/2016.
 */
public class Inter_Asegurado {

    private final static Logger log = Logger.getLogger(Inter_Asegurado.class);

    public void AgregarAsegurado1(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getAsegurado1Nombre1() != null || interPolizaBean.getAsegurado1Nombre2() != null || interPolizaBean.getAsegurado1Apellido1() != null || interPolizaBean.getAsegurado1Apellido2() != null) {

                WebElement contratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                contratante.click();
                contratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() != null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() != null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Nombre2() + " " + interPolizaBean.getAsegurado1Apellido1() + " " + interPolizaBean.getAsegurado1Apellido2());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() != null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() == null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Nombre2() + " " + interPolizaBean.getAsegurado1Apellido1());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() == null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() != null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Apellido1() + " " + interPolizaBean.getAsegurado1Apellido2());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() == null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() == null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            selAsegurado.click();
            Thread.sleep(2000);

            WebElement asociarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Asegurado");

            if (interPolizaBean.getPorcentajeAsegurado1() != null && !interPolizaBean.getPorcentajeAsegurado1().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeAsegurado1());
                Thread.sleep(1000);
            }

            WebElement guardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            guardarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Guardar Asegurado");

            jse.executeScript("window.scrollBy(0,100)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


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

    public void AgregarAsegurado2(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getAsegurado2Nombre1() != null || interPolizaBean.getAsegurado2Nombre2() != null || interPolizaBean.getAsegurado2Apellido1() != null || interPolizaBean.getAsegurado2Apellido2() != null) {

                WebElement contratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                contratante.click();
                contratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getAsegurado2Nombre1() != null && interPolizaBean.getAsegurado2Nombre2() != null && interPolizaBean.getAsegurado2Apellido1() != null && interPolizaBean.getAsegurado2Apellido2() != null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado2Nombre1() + " " + interPolizaBean.getAsegurado2Nombre2() + " " + interPolizaBean.getAsegurado2Apellido1() + " " + interPolizaBean.getAsegurado2Apellido2());
                }
                else if (interPolizaBean.getAsegurado2Nombre1() != null && interPolizaBean.getAsegurado2Nombre2() != null && interPolizaBean.getAsegurado2Apellido1() != null && interPolizaBean.getAsegurado2Apellido2() == null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado2Nombre1() + " " + interPolizaBean.getAsegurado2Nombre2() + " " + interPolizaBean.getAsegurado2Apellido1());
                }
                else if (interPolizaBean.getAsegurado2Nombre1() != null && interPolizaBean.getAsegurado2Nombre2() == null && interPolizaBean.getAsegurado2Apellido1() != null && interPolizaBean.getAsegurado2Apellido2() != null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado2Nombre1() + " " + interPolizaBean.getAsegurado2Apellido1() + " " + interPolizaBean.getAsegurado2Apellido2());
                }
                else if (interPolizaBean.getAsegurado2Nombre1() != null && interPolizaBean.getAsegurado2Nombre2() == null && interPolizaBean.getAsegurado2Apellido1() != null && interPolizaBean.getAsegurado2Apellido2() == null) {
                    contratante.sendKeys(interPolizaBean.getAsegurado2Nombre1() + " " + interPolizaBean.getAsegurado2Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[9]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            selAsegurado.click();
            Thread.sleep(2000);

            WebElement asociarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Asegurado");

            if (interPolizaBean.getPorcentajeAsegurado2() != null && !interPolizaBean.getPorcentajeAsegurado2().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeAsegurado2());
                Thread.sleep(1000);
            }

            WebElement guardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            guardarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Guardar Asegurado");

            jse.executeScript("window.scrollBy(0,100)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


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

    public void AgregarAsegurado1_DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getAsegurado1Nombre1() != null || interPolizaBean.getAsegurado1Nombre2() != null || interPolizaBean.getAsegurado1Apellido1() != null || interPolizaBean.getAsegurado1Apellido2() != null) {

                Thread.sleep(3000);
                WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_TomadorLabel']"));
                otroElemento.click();
                Thread.sleep(1500);
                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                asegurado.click();
                //asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() != null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() != null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Nombre2() + " " + interPolizaBean.getAsegurado1Apellido1() + " " + interPolizaBean.getAsegurado1Apellido2());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() != null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() == null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Nombre2() + " " + interPolizaBean.getAsegurado1Apellido1());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() == null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() != null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Apellido1() + " " + interPolizaBean.getAsegurado1Apellido2());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() == null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() == null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            selAsegurado.click();
            Thread.sleep(2000);

            WebElement asociarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Asegurado");

            if (interPolizaBean.getPorcentajeAsegurado1() != null && !interPolizaBean.getPorcentajeAsegurado1().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeAsegurado1());
                Thread.sleep(1000);
            }

            WebElement guardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            guardarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Guardar Asegurado");

            jse.executeScript("window.scrollBy(0,100)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


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

    public void AgregarAsegurado2_DotalSimple(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getAsegurado1Nombre1() != null || interPolizaBean.getAsegurado1Nombre2() != null || interPolizaBean.getAsegurado1Apellido1() != null || interPolizaBean.getAsegurado1Apellido2() != null) {

                Thread.sleep(3000);
                WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_TomadorLabel']"));
                otroElemento.click();
                Thread.sleep(1500);
                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                asegurado.click();
                //asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() != null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() != null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Nombre2() + " " + interPolizaBean.getAsegurado1Apellido1() + " " + interPolizaBean.getAsegurado1Apellido2());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() != null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() == null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Nombre2() + " " + interPolizaBean.getAsegurado1Apellido1());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() == null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() != null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Apellido1() + " " + interPolizaBean.getAsegurado1Apellido2());
                }
                else if (interPolizaBean.getAsegurado1Nombre1() != null && interPolizaBean.getAsegurado1Nombre2() == null && interPolizaBean.getAsegurado1Apellido1() != null && interPolizaBean.getAsegurado1Apellido2() == null) {
                    asegurado.sendKeys(interPolizaBean.getAsegurado1Nombre1() + " " + interPolizaBean.getAsegurado1Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[8]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            selAsegurado.click();
            Thread.sleep(2000);

            WebElement asociarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Asegurado");

            if (interPolizaBean.getPorcentajeAsegurado1() != null && !interPolizaBean.getPorcentajeAsegurado1().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeAsegurado1());
                Thread.sleep(1000);
            }

            WebElement guardarAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            guardarAsegurado.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Guardar Asegurado");

            jse.executeScript("window.scrollBy(0,100)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


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
