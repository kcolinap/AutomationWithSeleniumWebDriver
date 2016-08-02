package main.controller;

import beans.EmisionPolizaEliminacionTomadoresBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 01/08/2016.
 */
public class EmisionPolizaEliminacionTomadores {

    private final static Logger log = Logger.getLogger(EmisionPolizaEliminacionTomadores.class);

    public String nombreAutomatizacion = "Eliminacion de Póliza Edicion Tomadores";

    public void testLink(EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean, int i) throws IOException, InterruptedException {


        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Creación de Póliza
        IngresarMenuEmisionPoliza(driver, a);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        CrearPoliza(a, driver, emisionPolizaEliminacionTomadoresBean);
    }

    public void IngresarMenuEmisionPoliza(WebDriver driver, Metodos a) throws IOException, InterruptedException {

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]")); // Operación
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[2]")); // Operaciones Pólizas
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[6]/div[2]")); // Crear
            menu1.click();
            menu2.click();
            a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            menu3.click();
        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CrearPoliza(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean) throws InterruptedException, IOException {

        // //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        AdminitracionPropuestaPoliza(a, driver, emisionPolizaEliminacionTomadoresBean);
        Thread.sleep(3000);
        EventoAplicar(a, driver, emisionPolizaEliminacionTomadoresBean);
        Thread.sleep(4000);
        InformacionGeneral(a, driver, emisionPolizaEliminacionTomadoresBean);
        Thread.sleep(4000);
        TomadorTercero1(a, driver, emisionPolizaEliminacionTomadoresBean);
        Thread.sleep(2000);
        TomadorTercero2(a, driver, emisionPolizaEliminacionTomadoresBean);
        Thread.sleep(2000);
        EliminarTomador(a, driver);
        Thread.sleep(2000);
        //EditarTomadorTercero1(a, driver, emisionPolizaEliminacionTomadoresBean);
        Thread.sleep(2000);

    }

    public void AdminitracionPropuestaPoliza(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean){
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(emisionPolizaEliminacionTomadoresBean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (emisionPolizaEliminacionTomadoresBean.getFechaHasta() != null) {
                fechaHas.sendKeys(emisionPolizaEliminacionTomadoresBean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EventoAplicar(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean){
        try {
            Thread.sleep(3000);
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getEventoAplicar()); // Emitir
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    /**Poliza**/
    public void InformacionGeneral(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean){
        try {
            Select sucursalSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
            sucursalSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getSucursal()); //24651917 = Direccion General

            Thread.sleep(2000);
            Select tipoProduccionSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
            tipoProduccionSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoProduccion()); // 24652617 = Directa

            WebElement periodoGracia = driver. findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
            periodoGracia.sendKeys(emisionPolizaEliminacionTomadoresBean.getPeriodoGracia()); // 15
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            WebElement tasaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_field']"));
            tasaInput.clear();
            tasaInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getTasa()); // 10
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(3000);
            Select lineaCreditoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
            lineaCreditoSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getLineaCredito()); // 41249817 = Educativa

            Thread.sleep(2000);
            Select unidadNegocioSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
            unidadNegocioSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getUnidadNegocio()); // 23913017 = Bancaseguros

            Thread.sleep(2000);
            Select canalVentaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_2_field']")));
            canalVentaSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getCanalVenta()); // 21.0 = ATM

            Thread.sleep(2000);
            Select tipoValorAseguradoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
            tipoValorAseguradoSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoValorAsegurado()); // 23916617 = Valor inicial del desembolso


//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            Select tipoTasaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
            tipoTasaSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoTasa()); // 24650617 = Por 100


            Thread.sleep(2000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            /** Espere **/
            while (driver.findElement(By.id("waitMessage")).isDisplayed()){
                Thread.sleep(5000);
                int z = 0;
                System.out.println("Espere Informacion General = " + z);
                z++;
            }

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TomadorTercero1(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean){
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

            if (emisionPolizaEliminacionTomadoresBean.getTipoTercero1() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoTercero1());
            }
            if (emisionPolizaEliminacionTomadoresBean.getTipoDocId1() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoDocId1());
            }
            if (emisionPolizaEliminacionTomadoresBean.getCedula1() != null){
                cedulaInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getCedula1());
            }
            if (emisionPolizaEliminacionTomadoresBean.getNombre1() != null){
                nombreInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getNombre1());
            }
            if (emisionPolizaEliminacionTomadoresBean.getApellido1() != null){
                apellidoInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getApellido1());
            }

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

            if (emisionPolizaEliminacionTomadoresBean.getPorcentajeTomador1() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getPorcentajeTomador1());
            }

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
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TomadorTercero2(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean){
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

            if (emisionPolizaEliminacionTomadoresBean.getTipoTercero2() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoTercero2());
            }
            if (emisionPolizaEliminacionTomadoresBean.getTipoDocId2() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaEliminacionTomadoresBean.getTipoDocId2());
            }
            if (emisionPolizaEliminacionTomadoresBean.getCedula2() != null){
                cedulaInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getCedula2());
            }
            if (emisionPolizaEliminacionTomadoresBean.getNombre2() != null){
                nombreInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getNombre2());
            }
            if (emisionPolizaEliminacionTomadoresBean.getApellido2() != null){
                apellidoInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getApellido2());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscarTomador.click();
            Thread.sleep(3000);

            WebElement btnSelTercero = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            btnSelTercero.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnAsociar.click();
            Thread.sleep(4000);

            if (emisionPolizaEliminacionTomadoresBean.getPorcentajeTomador2() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaEliminacionTomadoresBean.getPorcentajeTomador2());
            }

            WebElement btnModoPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_radio']"));
            btnModoPago.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EliminarTomador(Metodos a, WebDriver driver) {

        try {
            Thread.sleep(5000);
            WebElement closeSearcher = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']"));
            closeSearcher.click();

            Thread.sleep(1000);
            WebElement selTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_5_Checked']"));
            selTomador.click();
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement eliminarTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_DeleteButton']"));
            eliminarTomador.click();

            Thread.sleep(3000);
            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen15", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            /** Espere **/
            WebElement mensajeEspera3 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera3.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Experimento de Eliminar Tomador");
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen16", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EditarTomadorTercero1(Metodos a, WebDriver driver, EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        WebElement cerrarBuscador = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']"));
        cerrarBuscador.click();
        Thread.sleep(2000);

        WebElement selTomador1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
        selTomador1.click();

        Thread.sleep(1000);
        a.ScreenShot(driver, "screen15", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();

        WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
        btnParticipacion.click();

        Thread.sleep(2000);

        WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
        nuevoPorcentaje.clear();
        nuevoPorcentaje.sendKeys(emisionPolizaEliminacionTomadoresBean.getNuevoPorcentajeTomador1());

        WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
        btnAgregar.click();

        /**Espere*/
        /** Experimento de Espera que se deshabilite el mensaje de Espera**/
        WebElement mensajeEspera3 = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera3.isDisplayed()){
            Thread.sleep(5000);
            System.out.println("Experimento de Espera Agregar Tomador");
        }

        Thread.sleep(1000);
        a.ScreenShot(driver, "screen16", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();

        WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
        btnGuardar.click();

        Thread.sleep(4000);
        a.ScreenShot(driver, "screen17", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();


    }


}
