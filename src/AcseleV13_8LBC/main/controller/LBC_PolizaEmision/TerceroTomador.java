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
public class TerceroTomador {

    private final static Logger log = Logger.getLogger(TerceroTomador.class);

    public void TomadorTercero(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){
        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (polizaBean.getTomadorNombre1() != null || polizaBean.getTomadorNombre2() != null || polizaBean.getTomadorApellido1() != null || polizaBean.getTomadorApellido2() != null) {
                WebElement inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                inputTomador.click();
                inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (polizaBean.getTomadorNombre1() != null && polizaBean.getTomadorNombre2() != null && polizaBean.getTomadorApellido1() != null && polizaBean.getTomadorApellido2() != null){
                    inputTomador.sendKeys(polizaBean.getTomadorNombre1() + " " + polizaBean.getTomadorNombre2() + " " + polizaBean.getTomadorApellido1() + " " + polizaBean.getTomadorApellido2());
                }
                else if (polizaBean.getTomadorNombre1() != null && polizaBean.getTomadorNombre2() != null && polizaBean.getTomadorApellido1() != null && polizaBean.getTomadorApellido2() == null){
                    inputTomador.sendKeys(polizaBean.getTomadorNombre1() + " " + polizaBean.getTomadorNombre2() + " " + polizaBean.getTomadorApellido1());
                }
                else if (polizaBean.getTomadorNombre1() != null && polizaBean.getTomadorNombre2() == null && polizaBean.getTomadorApellido1() != null && polizaBean.getTomadorApellido2() != null){
                    inputTomador.sendKeys(polizaBean.getTomadorNombre1() + " " + polizaBean.getTomadorApellido1() + " " +polizaBean.getTomadorApellido2());
                }
                else if (polizaBean.getTomadorNombre1() != null && polizaBean.getTomadorNombre2() == null && polizaBean.getTomadorApellido1() != null && polizaBean.getTomadorApellido2() == null){
                    inputTomador.sendKeys(polizaBean.getTomadorNombre1() + " " + polizaBean.getTomadorApellido1());
                }

            }

            Thread.sleep(2000);
            WebElement selTomador = driver.findElement(By.xpath("/html/body/div[6]/div/ul/li"));
            selTomador.click();

            Thread.sleep(2000);
            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsociar.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Asociar Tomador");
            }

            if (polizaBean.getPorcentajeParticipacionTomador() != null){
                WebElement porcentajeTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomador.clear();
                porcentajeTomador.sendKeys(polizaBean.getPorcentajeParticipacionTomador());
                Thread.sleep(1000);
            }

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            btnAgregar.click();

            /** Espere **/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Agregar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            //"policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation"
            btnGuardar.click();

            /** Espere **/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Guardar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TomadorTercero2(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2){
        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (polizaBean.getTomador2Nombre1() != null || polizaBean.getTomador2Nombre2() != null || polizaBean.getTomador2Apellido1() != null || polizaBean.getTomador2Apellido2() != null) {
                //WebElement inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                WebElement inputTomador = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_readOnlyPanel']"));
                //Thread.sleep(2000);
                inputTomador = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_readOnlyPanel_selectedValue']"));

                inputTomador.click();
                Thread.sleep(1000);
//                inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_searh']"));

                inputTomador = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_readOnlyPanel_selectedValue']"));                //inputTomador.click();
                //inputTomador.click();
                //inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                //inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_searh']"));
                //inputTomador = driver.findElement(By.xpath("//span[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_readOnlyPanel']"));

                if (polizaBean.getTomador2Nombre1() != null && polizaBean.getTomador2Nombre2() != null && polizaBean.getTomador2Apellido1() != null && polizaBean.getTomador2Apellido2() != null){
                    inputTomador.sendKeys(polizaBean.getTomador2Nombre1() + " " + polizaBean.getTomador2Nombre2() + " " + polizaBean.getTomador2Apellido1() + " " + polizaBean.getTomador2Apellido2());
                }
                else if (polizaBean.getTomador2Nombre1() != null && polizaBean.getTomador2Nombre2() != null && polizaBean.getTomador2Apellido1() != null && polizaBean.getTomador2Apellido2() == null){
                    inputTomador.sendKeys(polizaBean.getTomador2Nombre1() + " " + polizaBean.getTomador2Nombre2() + " " + polizaBean.getTomador2Apellido1());
                }
                else if (polizaBean.getTomador2Nombre1() != null && polizaBean.getTomador2Nombre2() == null && polizaBean.getTomador2Apellido1() != null && polizaBean.getTomador2Apellido2() != null){
                    inputTomador.sendKeys(polizaBean.getTomador2Nombre1() + " " + polizaBean.getTomador2Apellido1() + " " +polizaBean.getTomador2Apellido2());
                }
                else if (polizaBean.getTomador2Nombre1() != null && polizaBean.getTomador2Nombre2() == null && polizaBean.getTomador2Apellido1() != null && polizaBean.getTomador2Apellido2() == null){
                    inputTomador.sendKeys(polizaBean.getTomador2Nombre1() + " " + polizaBean.getTomador2Apellido1());
                }

            }

            Thread.sleep(2000);
            WebElement selTomador = driver.findElement(By.xpath("/html/body/div[6]/div/ul/li"));
            selTomador.click();

            Thread.sleep(2000);
            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsociar.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Asociar Tomador");
            }

            if (polizaBean.getPorcentajeParticipacionTomador2() != null){
                WebElement porcentajeTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomador.clear();
                porcentajeTomador.sendKeys(polizaBean.getPorcentajeParticipacionTomador2());
                Thread.sleep(1000);
            }

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            btnAgregar.click();

            /** Espere **/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Agregar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            //"policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation"
            btnGuardar.click();

            /** Espere **/
            Thread.sleep(1000);
            mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Guardar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TomadorTercero2BusquedaAvanzada(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){
        try {
            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//a[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearchLink']"));
            btnBusquedaAvanzada.click();

            Thread.sleep(2000);

            Select tipoTeceroSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_thirdPartyTypes']")));
            Select tipoDocIdSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement cedulaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            WebElement nombre1Input = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            WebElement apellido1Input = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
            WebElement btnBuscarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_searchButton']"));

            if (polizaBean.getTipoTomador2() != null){
                tipoTeceroSelect.selectByValue(polizaBean.getTipoTomador2());
            }
            if (polizaBean.getTipoDocumentoIdentidad2() != null){
                tipoDocIdSelect.selectByValue(polizaBean.getTipoDocumentoIdentidad2());
            }
            if (polizaBean.getNumeroDocumentoIdentidad2() != null){
                cedulaInput.sendKeys(polizaBean.getNumeroDocumentoIdentidad2());
            }
            if (polizaBean.getTomador2Nombre1() != null){
                nombre1Input.sendKeys(polizaBean.getTomador2Nombre1());
            }
            if (polizaBean.getTomador2Apellido1() != null){
                apellido1Input.sendKeys(polizaBean.getTomador2Apellido1());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscarTomador.click();
            Thread.sleep(3000);

            WebElement btnSelTercero = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            btnSelTercero.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnAsociar.click();
            Thread.sleep(4000);

            if (polizaBean.getPorcentajeParticipacionTomador2() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(polizaBean.getPorcentajeParticipacionTomador2());
            }

            WebElement btnModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_radio']"));
            btnModoPago.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
            }
        }

    public void EditarTomadorTercero1(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);
            WebElement cerrarBuscador = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']"));
            cerrarBuscador.click();
            Thread.sleep(2000);

            WebElement selTomador1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            selTomador1.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            Thread.sleep(2000);

            WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            nuevoPorcentaje.clear();
            nuevoPorcentaje.sendKeys(polizaBean.getNuevoPorcentajeParticipacionTomador());

            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            btnAgregar.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Asociar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EditarTomadorTercero2(Metodos13_8 a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            WebElement selTomador2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_9_Checked']"));
            selTomador2.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            Thread.sleep(2000);

            WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
            nuevoPorcentaje.clear();
            nuevoPorcentaje.sendKeys(polizaBean.getNuevoPorcentajeParticipacionTomador2());

            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            btnAgregar.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Asociar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EliminarTomador2(Metodos13_8 a, WebDriver driver, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3) {

        try {
            Thread.sleep(5000);
            WebElement closeSearcher = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']"));
            closeSearcher.click();

            Thread.sleep(1000);
            WebElement selTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_5_Checked']"));
            selTomador.click();
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement eliminarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_DeleteButton']"));
            eliminarTomador.click();

            Thread.sleep(3000);
            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Eliminar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void TomadorTerceroBusquedaAvanzada(Metodos13_8 a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean, String nombreAutomatizacion){
        try {
            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//a[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearchLink']"));
            btnBusquedaAvanzada.click();

            Thread.sleep(2000);

            Select tipoTeceroSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_thirdPartyTypes']")));
            Select tipoDocIdSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement cedulaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            WebElement nombreInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            WebElement apellidoInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
            WebElement btnBuscarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_searchButton']"));
            /*
            if (emisionPolizaBeneficiarioNaturalBean.getTipoTerceroT() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoTerceroT());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getTipoDocIdT() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaBeneficiarioNaturalBean.getTipoDocIdT());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNumDocIdT() != null){
                cedulaInput.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNumDocIdT());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getNombreT() != null){
                nombreInput.sendKeys(emisionPolizaBeneficiarioNaturalBean.getNombreT());
            }
            if (emisionPolizaBeneficiarioNaturalBean.getApellidoT() != null){
                apellidoInput.sendKeys(emisionPolizaBeneficiarioNaturalBean.getApellidoT());
            }
            */
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscarTomador.click();
            Thread.sleep(3000);

            WebElement btnSelTercero = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            btnSelTercero.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnAsociar.click();
            Thread.sleep(4000);
            /*
            if (emisionPolizaBeneficiarioNaturalBean.getPorcentajeT() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaBeneficiarioNaturalBean.getPorcentajeT());
            }
            */
            WebElement btnModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_radio']"));
            btnModoPago.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }
}
