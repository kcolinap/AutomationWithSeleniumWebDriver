package AcseleV13_8LBC.main.controller.LBC_PolizaEmision;

import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos13_8;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Created by agil on 19/09/2016.
 */
public class AseguradoVida {

    private final static Logger log = Logger.getLogger(AseguradoVida.class);

    public void AseguradoVida(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            if (polizaBean.getAseguradoVidaNombre1() != null || polizaBean.getAseguradoVidaNombre2() != null || polizaBean.getAseguradoVidaApellido1() != null || polizaBean.getAseguradoVidaApellido2() != null) {

                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                asegurado.click();
                asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (polizaBean.getAseguradoVidaNombre1() != null && polizaBean.getAseguradoVidaNombre2() != null && polizaBean.getAseguradoVidaApellido1() != null && polizaBean.getAseguradoVidaApellido2() != null) {
                    asegurado.sendKeys(polizaBean.getAseguradoVidaNombre1() + " " + polizaBean.getAseguradoVidaNombre2() + " " + polizaBean.getAseguradoVidaApellido1() + " " + polizaBean.getAseguradoVidaApellido2());
                }
                else if (polizaBean.getAseguradoVidaNombre1() != null && polizaBean.getAseguradoVidaNombre2() != null && polizaBean.getAseguradoVidaApellido1() != null && polizaBean.getAseguradoVidaApellido2() == null) {
                    asegurado.sendKeys(polizaBean.getAseguradoVidaNombre1() + " " + polizaBean.getAseguradoVidaNombre2() + " " + polizaBean.getAseguradoVidaApellido1());
                }
                else if (polizaBean.getAseguradoVidaNombre1() != null && polizaBean.getAseguradoVidaNombre2() == null && polizaBean.getAseguradoVidaApellido1() != null && polizaBean.getAseguradoVidaApellido2() != null) {
                    asegurado.sendKeys(polizaBean.getAseguradoVidaNombre1() + " " + polizaBean.getAseguradoVidaApellido1() + " " + polizaBean.getAseguradoVidaApellido2());
                }
                else if (polizaBean.getAseguradoVidaNombre1() != null && polizaBean.getAseguradoVidaNombre2() == null && polizaBean.getAseguradoVidaApellido1() != null && polizaBean.getAseguradoVidaApellido2() == null) {
                    asegurado.sendKeys(polizaBean.getAseguradoVidaNombre1() + " " + polizaBean.getAseguradoVidaApellido1());
                }

            }

            Thread.sleep(2000);
            WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li"));
            //"//*[@id=\"432163512439293-autocomplete\"]/ul/li"
            selAsegurado.click();

            Thread.sleep(2000);
            WebElement btnAsoc = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsoc.click();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Asociar Asegurado Vida");
            }

            if (polizaBean.getPorcentajeParticipacionAseguradoVida() != null){
                Thread.sleep(2000);
                WebElement porcentajePartipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajePartipacion.clear();
                porcentajePartipacion.sendKeys(polizaBean.getPorcentajeParticipacionAseguradoVida());

            }

            Thread.sleep(2000);
            WebElement bguardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            Thread.sleep(1000);
            bguardar.click();

            /***Espera***/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Guardar Asegurado Vida");
            }
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EditarAseguradoVida(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2,
                                    int numScreenShoot3){

        try {

            Thread.sleep(2000);
            WebElement selAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_1_Checked']"));
            selAsegVida.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            Thread.sleep(3000);
            if (polizaBean.getNuevoPorcentajeParticipacionAseguradoVida() != null) {
                WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                nuevoPorcentaje.clear();
                nuevoPorcentaje.sendKeys(polizaBean.getNuevoPorcentajeParticipacionAseguradoVida());

                // Captura
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);
            }


            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Guardar Nuevo Porcentaje Asegurado Vida");
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EliminarAseguradoVida(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2,
                                      int numScreenShoot3){

        try {

            Thread.sleep(1000);
            WebElement selAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            selAsegVida.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnEliminar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_DeleteButton']"));
            btnEliminar.click();


            // Captura
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Eliminar Asegurado Vida");
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
