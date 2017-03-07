package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosOAVidaIntegralBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.awt.*;

/**
 * Created by agil on 21/02/2017.
 */
public class Asesuisa_Tomador {

    private final static Logger log = Logger.getLogger(Asesuisa_Tomador.class);

    public void AgregarTomador(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionVariosOAVidaIntegralBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //jse.executeScript("window.scrollBy(0,500)", "");

            if (bean.getTomador1Nombre1() != null || bean.getTomador1Nombre2() != null || bean.getTomador1Apellido1() != null || bean.getTomador1Apellido2() != null) {

                Thread.sleep(1500);
                WebElement tomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                tomador.click();
                Thread.sleep(500);
                tomador.click();
                tomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (bean.getTomador1Nombre1() != null && bean.getTomador1Nombre2() != null && bean.getTomador1Apellido1() != null && bean.getTomador1Apellido2() != null) {
                    tomador.sendKeys(bean.getTomador1Nombre1() + " " + bean.getTomador1Nombre2() + " " + bean.getTomador1Apellido1() + " " + bean.getTomador1Apellido2());
                }
                else if (bean.getTomador1Nombre1() != null && bean.getTomador1Nombre2() != null && bean.getTomador1Apellido1() != null && bean.getTomador1Apellido2() == null) {
                    tomador.sendKeys(bean.getTomador1Nombre1() + " " + bean.getTomador1Nombre2() + " " + bean.getTomador1Apellido1());
                }
                else if (bean.getTomador1Nombre1() != null && bean.getTomador1Nombre2() == null && bean.getTomador1Apellido1() != null && bean.getTomador1Apellido2() != null) {
                    tomador.sendKeys(bean.getTomador1Nombre1() + " " + bean.getTomador1Apellido1() + " " + bean.getTomador1Apellido2());
                }
                else if (bean.getTomador1Nombre1() != null && bean.getTomador1Nombre2() == null && bean.getTomador1Apellido1() != null && bean.getTomador1Apellido2() == null) {
                    tomador.sendKeys(bean.getTomador1Nombre1() + " " + bean.getTomador1Apellido1());
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

            WebElement asociarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            asociarTomador.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Asociar Tomador");

            if (bean.getPorcentajeTomador1() != null && !bean.getPorcentajeTomador1().equals("100")){
                WebElement porcentajeTomador1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomador1.sendKeys(bean.getPorcentajeTomador1());
                Thread.sleep(1000);
            }

            WebElement seleccionarModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            seleccionarModoPago.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Seleccionar Modo de Pago del Tomador");

            jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(3000);

            WebElement btnGuardarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarTomador.click();

            a.waitSearchWicket(driver, "Espere Guardando Tomador");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

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

    public void AgregarTomadorBusquedaAvanzada(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionVariosOAVidaIntegralBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(1000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,500)", "");

            Thread.sleep(1000);
            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//a[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearchLink']"));
            btnBusquedaAvanzada.click();
            Thread.sleep(1000);
            btnBusquedaAvanzada.click();

            WebElement primerNombre = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
            WebElement segundoNombre = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            WebElement primerApellido = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
            WebElement segundoApellido = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));

            Thread.sleep(2000);




        } catch (Exception e){
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

    public void EditarTomador(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionVariosOAVidaIntegralBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;


            WebElement seleccionarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_1_Checked']"));
            seleccionarTomador.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            Thread.sleep(2000);

            if (bean.getPorcentajeTomador2() != null && !bean.getPorcentajeTomador2().equals("100")) {
                WebElement porcentajeTomador1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomador1.clear();
                porcentajeTomador1.sendKeys(bean.getPorcentajeTomador2());
                Thread.sleep(1000);
            }

            WebElement seleccionarModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            seleccionarModoPago.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Agregar Tomador");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardarTomador.click();

            a.waitSearchWicket(driver, "Espere: Guardando Tomador");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EliminarTomador(Metodos a, WebDriver driver, Asesuisa_PolizaEmisionVariosOAVidaIntegralBean bean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            WebElement seleccionarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            seleccionarTomador.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnEliminar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_DeleteButton']"));
            btnEliminar.click();

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-5000)", "");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            a.waitSearchWicket(driver, "Espere: Eliminando Tomador");

            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,5000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
