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
 * Created by agil on 23/11/2016.
 */
public class Inter_Contratante {

    private final static Logger log = Logger.getLogger(Inter_Contratante.class);

    public void AgregarContratante(Interseguros_Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            if (interPolizaBean.getContratante1Nombre1() != null || interPolizaBean.getContratante1Nombre2() != null || interPolizaBean.getContratante1Apellido1() != null || interPolizaBean.getContratante1Apellido2() != null) {

                WebElement contratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                contratante.click();
                contratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (interPolizaBean.getContratante1Nombre1() != null && interPolizaBean.getContratante1Nombre2() != null && interPolizaBean.getContratante1Apellido1() != null && interPolizaBean.getContratante1Apellido2() != null) {
                    contratante.sendKeys(interPolizaBean.getContratante1Nombre1() + " " + interPolizaBean.getContratante1Nombre2() + " " + interPolizaBean.getContratante1Apellido1() + " " + interPolizaBean.getContratante1Apellido2());
                }
                else if (interPolizaBean.getContratante1Nombre1() != null && interPolizaBean.getContratante1Nombre2() != null && interPolizaBean.getContratante1Apellido1() != null && interPolizaBean.getContratante1Apellido2() == null) {
                    contratante.sendKeys(interPolizaBean.getContratante1Nombre1() + " " + interPolizaBean.getContratante1Nombre2() + " " + interPolizaBean.getContratante1Apellido1());
                }
                else if (interPolizaBean.getContratante1Nombre1() != null && interPolizaBean.getContratante1Nombre2() == null && interPolizaBean.getContratante1Apellido1() != null && interPolizaBean.getContratante1Apellido2() != null) {
                    contratante.sendKeys(interPolizaBean.getContratante1Nombre1() + " " + interPolizaBean.getContratante1Apellido1() + " " + interPolizaBean.getContratante1Apellido2());
                }
                else if (interPolizaBean.getContratante1Nombre1() != null && interPolizaBean.getContratante1Nombre2() == null && interPolizaBean.getContratante1Apellido1() != null && interPolizaBean.getContratante1Apellido2() == null) {
                    contratante.sendKeys(interPolizaBean.getContratante1Nombre1() + " " + interPolizaBean.getContratante1Apellido1());
                }
            }

            Thread.sleep(2000);
            WebElement selContratante = driver.findElement(By.xpath("/html/body/div[6]/div/ul/li[1]"));
            // /html/body/div[6]/div/ul/li[1]
            selContratante.click();
            Thread.sleep(2000);

            WebElement asociarContratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarContratante.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Contratante");

            if (interPolizaBean.getPorcentajeContratante1() != null && !interPolizaBean.getPorcentajeContratante1().equals("100")){
                WebElement porcentajeContratante1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeContratante1.sendKeys(interPolizaBean.getPorcentajeContratante1());
                Thread.sleep(1000);
            }

            WebElement seleccionarModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            seleccionarModoPago.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Seleccionar Modo de Pago del Contratante");

            jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarContratante = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarContratante.click();

            a.waitSearchWicket(driver, "Espere Guardando Contratante");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

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
