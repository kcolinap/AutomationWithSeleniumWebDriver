package AcseleV13_8.main.controller.PolizaEmision;

import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos;
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

    public void ObjetoAsegurado(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

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

            if (polizaBean.getPorcentajeParticipacionAseguradoVida() != null){
                WebElement porcentajePartipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajePartipacion.clear();
                porcentajePartipacion.sendKeys(polizaBean.getPorcentajeParticipacionAseguradoVida());

            }

            Thread.sleep(2000);
            WebElement bguardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            Thread.sleep(1000);
            bguardar.click();

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            /***Espera***/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera Agregar Asegurado Vida");
            }

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
