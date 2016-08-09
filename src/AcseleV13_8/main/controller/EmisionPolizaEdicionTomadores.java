package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaEdicionTomadoresBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 29/07/2016.
 */
public class EmisionPolizaEdicionTomadores {

    private final static Logger log = Logger.getLogger(EmisionPolizaEdicionTomadores.class);

    public String nombreAutomatizacion = "Edicion de Póliza Edicion Tomadores";

    public void testLink(EmisionPolizaEdicionTomadoresBean emisionPolizaInclusionTomadoresBean, int i) throws IOException, InterruptedException {

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
        CrearPoliza(a, driver, emisionPolizaInclusionTomadoresBean);
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

    public void CrearPoliza(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaInclusionTomadoresBean) throws InterruptedException, IOException {

        // //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        AdminitracionPropuestaPoliza(a, driver, emisionPolizaInclusionTomadoresBean);
        Thread.sleep(3000);
        EventoAplicar(a, driver, emisionPolizaInclusionTomadoresBean);
        Thread.sleep(4000);
        InformacionGeneral(a, driver, emisionPolizaInclusionTomadoresBean);
        Thread.sleep(4000);
        TomadorTercero1(a, driver, emisionPolizaInclusionTomadoresBean);
        Thread.sleep(2000);
        TomadorTercero2(a, driver, emisionPolizaInclusionTomadoresBean);
        Thread.sleep(2000);
        EditarTomadorTercero1(a, driver, emisionPolizaInclusionTomadoresBean);
        Thread.sleep(2000);
        EditarTomadorTercero2(a, driver, emisionPolizaInclusionTomadoresBean);

    }

    public void AdminitracionPropuestaPoliza(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean){
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(emisionPolizaEdicionTomadoresBean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (emisionPolizaEdicionTomadoresBean.getFechaHasta() != null) {
                fechaHas.sendKeys(emisionPolizaEdicionTomadoresBean.getFechaHasta());
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

    public void EventoAplicar(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean){
        try {
            Thread.sleep(3000);
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getEventoAplicar()); // Emitir
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
    public void InformacionGeneral(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean){
        try {
            Select sucursalSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
            sucursalSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getSucursal()); //24651917 = Direccion General

            Thread.sleep(2000);
            Select tipoProduccionSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
            tipoProduccionSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoProduccion()); // 24652617 = Directa

            WebElement periodoGracia = driver. findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
            periodoGracia.sendKeys(emisionPolizaEdicionTomadoresBean.getPeriodoGracia()); // 15
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            WebElement tasaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_field']"));
            tasaInput.clear();
            tasaInput.sendKeys(emisionPolizaEdicionTomadoresBean.getTasa()); // 10
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(3000);
            Select lineaCreditoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
            lineaCreditoSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getLineaCredito()); // 41249817 = Educativa

            Thread.sleep(2000);
            Select unidadNegocioSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
            unidadNegocioSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getUnidadNegocio()); // 23913017 = Bancaseguros

            Thread.sleep(2000);
            Select canalVentaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_2_field']")));
            canalVentaSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getCanalVenta()); // 21.0 = ATM

            Thread.sleep(2000);
            Select tipoValorAseguradoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
            tipoValorAseguradoSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoValorAsegurado()); // 23916617 = Valor inicial del desembolso


//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            Select tipoTasaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
            tipoTasaSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoTasa()); // 24650617 = Por 100


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

    public void TomadorTercero1(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean){
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

            if (emisionPolizaEdicionTomadoresBean.getTipoTercero1() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoTercero1());
            }
            if (emisionPolizaEdicionTomadoresBean.getTipoDocId1() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoDocId1());
            }
            if (emisionPolizaEdicionTomadoresBean.getCedula1() != null){
                cedulaInput.sendKeys(emisionPolizaEdicionTomadoresBean.getCedula1());
            }
            if (emisionPolizaEdicionTomadoresBean.getNombre1() != null){
                nombreInput.sendKeys(emisionPolizaEdicionTomadoresBean.getNombre1());
            }
            if (emisionPolizaEdicionTomadoresBean.getApellido1() != null){
                apellidoInput.sendKeys(emisionPolizaEdicionTomadoresBean.getApellido1());
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

            if (emisionPolizaEdicionTomadoresBean.getPorcentajeTomador1() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaEdicionTomadoresBean.getPorcentajeTomador1());
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

    public void TomadorTercero2(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean){
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

            if (emisionPolizaEdicionTomadoresBean.getTipoTercero2() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoTercero2());
            }
            if (emisionPolizaEdicionTomadoresBean.getTipoDocId2() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaEdicionTomadoresBean.getTipoDocId2());
            }
            if (emisionPolizaEdicionTomadoresBean.getCedula2() != null){
                cedulaInput.sendKeys(emisionPolizaEdicionTomadoresBean.getCedula2());
            }
            if (emisionPolizaEdicionTomadoresBean.getNombre2() != null){
                nombreInput.sendKeys(emisionPolizaEdicionTomadoresBean.getNombre2());
            }
            if (emisionPolizaEdicionTomadoresBean.getApellido2() != null){
                apellidoInput.sendKeys(emisionPolizaEdicionTomadoresBean.getApellido2());
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

            if (emisionPolizaEdicionTomadoresBean.getPorcentajeTomador2() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaEdicionTomadoresBean.getPorcentajeTomador2());
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

    public void EditarTomadorTercero1(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        WebElement cerrarBuscador = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']"));
        cerrarBuscador.click();
        Thread.sleep(2000);

        WebElement selTomador1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
        selTomador1.click();

        Thread.sleep(1000);
        a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();

        WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
        btnParticipacion.click();

        Thread.sleep(2000);

        WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
        nuevoPorcentaje.clear();
        nuevoPorcentaje.sendKeys(emisionPolizaEdicionTomadoresBean.getNuevoPorcentajeTomador1());

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
        a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();

        WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
        btnGuardar.click();

        Thread.sleep(4000);
        a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();


    }

    public void EditarTomadorTercero2(Metodos a, WebDriver driver, EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);

        WebElement selTomador2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_9_Checked']"));
        selTomador2.click();

        Thread.sleep(1000);
        a.ScreenShot(driver, "screen15", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();

        WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
        btnParticipacion.click();

        Thread.sleep(2000);

        WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
        nuevoPorcentaje.clear();
        nuevoPorcentaje.sendKeys(emisionPolizaEdicionTomadoresBean.getNuevoPorcentajeTomador2());

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
