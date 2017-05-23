package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizasBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

/**
 * Created by agil on 18/05/2017.
 */
public class Asesuisa_Beneficiario {

    private final static Logger log = Logger.getLogger(Asesuisa_Beneficiario.class);

    public void AgregarBeneficiario(Metodos a, WebDriver driver, Asesuisa_PolizasBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);

            if (bean.getBeneficiario1Nombre1() != null || bean.getBeneficiario1Nombre2() != null || bean.getBeneficiario1Apellido1() != null || bean.getBeneficiario1Apellido2() != null) {

                Thread.sleep(1500);
                WebElement tomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                tomador.click();
                Thread.sleep(1500);
                tomador.click();
                tomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() != null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() != null) {
                    tomador.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Nombre2() + " " + bean.getBeneficiario1Apellido1() + " " + bean.getBeneficiario1Apellido2());
                }
                else if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() != null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() == null) {
                    tomador.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Nombre2() + " " + bean.getBeneficiario1Apellido1());
                }
                else if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() == null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() != null) {
                    tomador.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Apellido1() + " " + bean.getBeneficiario1Apellido2());
                }
                else if (bean.getBeneficiario1Nombre1() != null && bean.getBeneficiario1Nombre2() == null && bean.getBeneficiario1Apellido1() != null && bean.getBeneficiario1Apellido2() == null) {
                    tomador.sendKeys(bean.getBeneficiario1Nombre1() + " " + bean.getBeneficiario1Apellido1());
                }
                Thread.sleep(2000);
                tomador.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(500);
                tomador.sendKeys(Keys.ENTER);

            }

            Thread.sleep(2000);
            //WebElement selTomador = driver.findElement(By.xpath("/html/body/div[6]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            //selTomador.click();
            Thread.sleep(2000);

            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsociar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Beneficiario");

            if (bean.getTipoBeneficiario1() != null) {
                Select tipoBeneficiario = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoBeneficiario.selectByVisibleText(bean.getTipoBeneficiario1());
                Thread.sleep(1000);
            }

            if (bean.getPorcentajeBeneficiario1() != null && !bean.getPorcentajeBeneficiario1().equals("100")){
                WebElement porcentajeBeneficiario1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeBeneficiario1.sendKeys(bean.getPorcentajeBeneficiario1());
                Thread.sleep(1000);
            }

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_2_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Guardando Beneficiario");

            jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
