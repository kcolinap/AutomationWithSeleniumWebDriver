package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EmisionPolizaAseguradoVidaBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 11/08/2016.
 */
public class EmisionPolizaAseguradoVida {

    private final static Logger log = Logger.getLogger(EmisionPolizaAseguradoVida.class);

    public String nombreAutomatizacion = "Emision de Póliza Asegurado Vida";

    public void testLink(EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean, int i) throws IOException, InterruptedException {

        try {

            //implementando clases
            Metodos a = new Metodos();
            MenuOperaciones m = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Creación de Póliza
            m.OpePol_Crear(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            CrearPoliza(a, driver, emisionPolizaAseguradoVidaBean);
        } catch (Exception e) {
        e.printStackTrace();
        //             log.info(e);
        log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void CrearPoliza(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){

        try {

            // //TipoElemento[@wicketpath='WicketpathElemento']
            Thread.sleep(2000);

            AdminPropuestaPoliza(a, driver, emisionPolizaAseguradoVidaBean);

            /***Espera***/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            Thread.sleep(3000);
            EvAplicar(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(4000);
            InformacionGeneral(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(4000);

            /***Espera***/
            WebElement mensajeEspera2 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera2.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 2");
            }
            TomadorTercero(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(2000);
            UnidadRiesgo(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(2000);
            ObjetoAsegurado(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(2000);
            AseguradoVidaAgregar(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(2000);
            AseguradoVidaEditar(a, driver, emisionPolizaAseguradoVidaBean);

            Thread.sleep(2000);
            AseguradoVidaEliminar(a, driver, emisionPolizaAseguradoVidaBean);


        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AdminPropuestaPoliza(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean) {
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(emisionPolizaAseguradoVidaBean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(emisionPolizaAseguradoVidaBean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(emisionPolizaAseguradoVidaBean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (emisionPolizaAseguradoVidaBean.getFechaHasta() != null) {
                fechaHas.sendKeys(emisionPolizaAseguradoVidaBean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EvAplicar(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){
        try {
            Thread.sleep(3000);
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(emisionPolizaAseguradoVidaBean.getEventoAplicar()); // Emitir
            Thread.sleep(2000);

            if (emisionPolizaAseguradoVidaBean.getFechaMovimiento() != null){
                WebElement fechaMovimiento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                fechaMovimiento.sendKeys(emisionPolizaAseguradoVidaBean.getFechaMovimiento());
                Thread.sleep(1000);
            }
            if (emisionPolizaAseguradoVidaBean.getFechaEfectivaApliEv() != null){
                WebElement fechaEfecAplicEvent = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_2_fila_fieldDate']"));
                fechaEfecAplicEvent.sendKeys(emisionPolizaAseguradoVidaBean.getFechaEfectivaApliEv());
                Thread.sleep(1000);
            }


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

    public void InformacionGeneral(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){
        try { //TipoElemento[@wicketpath='WicketpathElemento']

            if (emisionPolizaAseguradoVidaBean.getPlanFinanciamiento() != null){
                Select planFinanciamiento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                planFinanciamiento.selectByValue(emisionPolizaAseguradoVidaBean.getPlanFinanciamiento());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getMoneda() != null){
                Select moneda = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                moneda.selectByValue(emisionPolizaAseguradoVidaBean.getMoneda());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getSucursal() != null){
                Select sucursal= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                sucursal.selectByValue(emisionPolizaAseguradoVidaBean.getSucursal());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getNumPoliza() != null){
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(emisionPolizaAseguradoVidaBean.getNumPoliza());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getTipoProduccion() != null){
                Select tipoProduccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
                tipoProduccion.selectByValue(emisionPolizaAseguradoVidaBean.getTipoProduccion());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getPeriodoGraciaDias() != null){
                WebElement periodoGraciaDias = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                periodoGraciaDias.sendKeys(emisionPolizaAseguradoVidaBean.getPeriodoGraciaDias());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getLineaCredito() != null){
                Select lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                lineaCredito.selectByValue(emisionPolizaAseguradoVidaBean.getLineaCredito());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getHoraIniVencimiento() != null){
                Select horaIniVencimiento= new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                horaIniVencimiento.selectByValue(emisionPolizaAseguradoVidaBean.getHoraIniVencimiento());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getUnidadNegocio() != null){
                Select unidadNegocio = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                unidadNegocio.selectByValue(emisionPolizaAseguradoVidaBean.getUnidadNegocio());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getCanalVenta() != null){
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_2_field']")));
                canalVenta.selectByValue(emisionPolizaAseguradoVidaBean.getCanalVenta());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getFrecuencuaPago() != null){
                Select frecuenciaPago  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                frecuenciaPago.selectByValue(emisionPolizaAseguradoVidaBean.getFrecuencuaPago());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getTipoPoliza() != null){
                Select tipoPoliza = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
                tipoPoliza.selectByValue(emisionPolizaAseguradoVidaBean.getTipoPoliza());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getTipoValorAsegurado() != null){
                Select tipoValorAsegurado = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                tipoValorAsegurado.selectByValue(emisionPolizaAseguradoVidaBean.getTipoValorAsegurado());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getNivelAgrupaReaseguro() != null){
                Select nivelAgrupamientoReaseguro  = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_repeaterSelect_1_field']")));
                nivelAgrupamientoReaseguro.selectByValue(emisionPolizaAseguradoVidaBean.getNivelAgrupaReaseguro());
                Thread.sleep(1000);
            }

            if (emisionPolizaAseguradoVidaBean.getNivelAgrupaReaseguro() != null){
                WebElement si = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field_repeaterChoice_2_radio']"));
                si.click();
                Thread.sleep(1000);
            }
            else if (emisionPolizaAseguradoVidaBean.getNivelAgrupaReaseguro() == null){
                WebElement no = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field_repeaterChoice_1_radio']"));
                no.click();
                Thread.sleep(1000);
            }


            Thread.sleep(2000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

            /** Experimento de Espera que se deshabilite el mensaje de Espera**/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                //System.out.println("Experimento de Espera 1");
            }

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TomadorTercero(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){
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

            if (emisionPolizaAseguradoVidaBean.getTipoTerceroT() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaAseguradoVidaBean.getTipoTerceroT());
            }
            if (emisionPolizaAseguradoVidaBean.getTipoDocIdT() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaAseguradoVidaBean.getTipoDocIdT());
            }
            if (emisionPolizaAseguradoVidaBean.getNumDocIdT() != null){
                cedulaInput.sendKeys(emisionPolizaAseguradoVidaBean.getNumDocIdT());
            }
            if (emisionPolizaAseguradoVidaBean.getNombreT() != null){
                nombreInput.sendKeys(emisionPolizaAseguradoVidaBean.getNombreT());
            }
            if (emisionPolizaAseguradoVidaBean.getApellidoT() != null){
                apellidoInput.sendKeys(emisionPolizaAseguradoVidaBean.getApellidoT());
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

            if (emisionPolizaAseguradoVidaBean.getPorcentajeT() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaAseguradoVidaBean.getPorcentajeT());
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

    public void UnidadRiesgo(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){
        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement btnNuevaUR = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevaUR.click();

            /***Espera***/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            Thread.sleep(2000);
            if (emisionPolizaAseguradoVidaBean.getFechaProceso() != null){
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaProceso.sendKeys(emisionPolizaAseguradoVidaBean.getFechaProceso());
            }
            if (emisionPolizaAseguradoVidaBean.getNumUnidadRiesgo() != null){
                WebElement numUnidadRiesgo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                Thread.sleep(1000);
                numUnidadRiesgo.sendKeys(emisionPolizaAseguradoVidaBean.getNumUnidadRiesgo());
            }
            if (emisionPolizaAseguradoVidaBean.getNumCredito() != null){
                WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                Thread.sleep(1000);
                numCredito.sendKeys(emisionPolizaAseguradoVidaBean.getNumCredito());
            }
            if (emisionPolizaAseguradoVidaBean.getMontoAsegurado() != null){
                WebElement montoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                Thread.sleep(1000);
                montoAsegurado.clear();
                montoAsegurado.sendKeys(Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, Keys.ARROW_LEFT, emisionPolizaAseguradoVidaBean.getMontoAsegurado());
            }
            if (emisionPolizaAseguradoVidaBean.getFactorVida() != null){
                WebElement factorVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                Thread.sleep(1000);
                factorVida.sendKeys(emisionPolizaAseguradoVidaBean.getFactorVida());
            }
            if (emisionPolizaAseguradoVidaBean.getValorSeguroPrima() != null){
                WebElement valorSeguroPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
                Thread.sleep(1000);
                valorSeguroPrima.sendKeys(emisionPolizaAseguradoVidaBean.getValorSeguroPrima());
            }
            if (emisionPolizaAseguradoVidaBean.getFechaDesembolso() != null){
                WebElement fechaDesembolso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaDesembolso.sendKeys(emisionPolizaAseguradoVidaBean.getFechaDesembolso());
            }
            if (emisionPolizaAseguradoVidaBean.getValorPrestamo() != null){
                WebElement valorPrestamo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_field']"));
                Thread.sleep(1000);
                valorPrestamo.sendKeys(emisionPolizaAseguradoVidaBean.getValorPrestamo());
            }
            if (emisionPolizaAseguradoVidaBean.getCuotasPactadas() != null){
                WebElement cuotasPactadas = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_field']"));
                Thread.sleep(1000);
                cuotasPactadas.sendKeys(emisionPolizaAseguradoVidaBean.getCuotasPactadas());
            }
            if (emisionPolizaAseguradoVidaBean.getSaldoCapital() != null){
                WebElement saldoCapital = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                Thread.sleep(1000);
                saldoCapital.sendKeys(emisionPolizaAseguradoVidaBean.getSaldoCapital());
            }
            if (emisionPolizaAseguradoVidaBean.getEdoCredito() != null){
                Select estadoCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_repeaterSelect_1_field']")));
                Thread.sleep(1000);
                estadoCredito.selectByValue(emisionPolizaAseguradoVidaBean.getEdoCredito());
            }
            if (emisionPolizaAseguradoVidaBean.getCuotasMora() != null){
                WebElement cuotasMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_field']"));
                Thread.sleep(1000);
                cuotasMora.sendKeys(emisionPolizaAseguradoVidaBean.getCuotasMora());
            }

            if (emisionPolizaAseguradoVidaBean.getFechaPago() != null){
                WebElement fechaPago = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaPago.sendKeys(emisionPolizaAseguradoVidaBean.getFechaPago());
            }
            if (emisionPolizaAseguradoVidaBean.getCuotaPagada() != null){
                WebElement cuotaPagada = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_field']"));
                Thread.sleep(1000);
                cuotaPagada.sendKeys(emisionPolizaAseguradoVidaBean.getCuotaPagada());
            }
            if (emisionPolizaAseguradoVidaBean.getFechaMora() != null){
                WebElement fechaMora = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_7_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaMora.sendKeys(emisionPolizaAseguradoVidaBean.getFechaMora());
            }
            if (emisionPolizaAseguradoVidaBean.getPorcFacultativo() != null){
                WebElement porcentajeFacultativo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_8_fila_field']"));
                Thread.sleep(1000);
                porcentajeFacultativo.sendKeys(emisionPolizaAseguradoVidaBean.getPorcFacultativo());
            }
            if (emisionPolizaAseguradoVidaBean.getFechaProceso() != null){
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaProceso.clear();
                fechaProceso.sendKeys(emisionPolizaAseguradoVidaBean.getFechaProceso());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

            if (emisionPolizaAseguradoVidaBean.getFechaProceso() != null){
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                Thread.sleep(1000);
                fechaProceso.clear();
                fechaProceso.sendKeys(emisionPolizaAseguradoVidaBean.getFechaProceso());
            }
            Thread.sleep(1000);
            btnGuardar.click();

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(3000);


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAsegurado(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){
        try{//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);


            if (emisionPolizaAseguradoVidaBean.getAseguradoPrimario() != null){
                Thread.sleep(1000);
                WebElement aseguradoPrimarioSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field_repeaterChoice_2_radio']"));
                aseguradoPrimarioSi.click();
            }
            if (emisionPolizaAseguradoVidaBean.getAseguradoPrimario() == "NO" || emisionPolizaAseguradoVidaBean.getAseguradoPrimario() == "no"){
                Thread.sleep(1000);
                WebElement aseguradoPrimarioNo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field_repeaterChoice_1_radio']"));
                aseguradoPrimarioNo.click();
            }
            if (emisionPolizaAseguradoVidaBean.getPorcExtraPrima() != null){
                Thread.sleep(1000);
                WebElement porcExtraPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                porcExtraPrima.sendKeys(emisionPolizaAseguradoVidaBean.getPorcExtraPrima());
            }
            if (emisionPolizaAseguradoVidaBean.getPorcDescuento() != null){
                Thread.sleep(1000);
                WebElement porcDescuento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                porcDescuento.sendKeys(emisionPolizaAseguradoVidaBean.getPorcDescuento());
            }
            if (emisionPolizaAseguradoVidaBean.getDocIdAsegurado() != null){
                Thread.sleep(1000);
                WebElement docIdAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                docIdAsegurado.sendKeys(emisionPolizaAseguradoVidaBean.getDocIdAsegurado());
            }
            if (emisionPolizaAseguradoVidaBean.getFechaNacAsegurado() != null){
                Thread.sleep(1000);
                WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                fechaNacAsegurado.sendKeys(emisionPolizaAseguradoVidaBean.getFechaNacAsegurado());
            }
            if (emisionPolizaAseguradoVidaBean.getDireccionAsegurado() != null){
                Thread.sleep(1000);
                WebElement direccionAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                direccionAsegurado.sendKeys(emisionPolizaAseguradoVidaBean.getDireccionAsegurado());
            }
            if (emisionPolizaAseguradoVidaBean.getTelefonoFijo() != null){
                Thread.sleep(1000);
                WebElement telefonoFijo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_field']"));
                telefonoFijo.sendKeys(emisionPolizaAseguradoVidaBean.getTelefonoFijo());
            }

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

            Thread.sleep(2000);
            if (emisionPolizaAseguradoVidaBean.getDepartamento() != null){
                Thread.sleep(2000);
                Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                departamento.selectByValue(emisionPolizaAseguradoVidaBean.getDepartamento());
            }
            if (emisionPolizaAseguradoVidaBean.getCiudad() != null){
                Thread.sleep(2000);
                Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
                ciudad.selectByValue(emisionPolizaAseguradoVidaBean.getCiudad());
            }

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            btnGuardar.click();



            /***Espera***/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AseguradoVidaAgregar(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);
            WebElement btnBusquedaAvanzada = driver.findElement(By.xpath("//a[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearchLink']"));
            btnBusquedaAvanzada.click();


            Thread.sleep(2000);

            Select tipoAseuradoVidaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_thirdPartyTypes']")));
            Select tipoDocIdSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            WebElement cedulaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            WebElement nombreInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            WebElement apellidoInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
            WebElement btnBuscarAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_templateContainer_searchForm_searchButton']"));


            if (emisionPolizaAseguradoVidaBean.getTipoTerceroAV() != null){
                Thread.sleep(2000);
                tipoAseuradoVidaSelect.selectByValue(emisionPolizaAseguradoVidaBean.getTipoTerceroAV());
            }
            if (emisionPolizaAseguradoVidaBean.getTipoDocIdAV() != null){
                Thread.sleep(2000);
                tipoDocIdSelect.selectByValue(emisionPolizaAseguradoVidaBean.getTipoDocIdAV());
            }
            if (emisionPolizaAseguradoVidaBean.getNumDocIdAV() != null){
                Thread.sleep(2000);
                cedulaInput.sendKeys(emisionPolizaAseguradoVidaBean.getNumDocIdAV());
            }
            if (emisionPolizaAseguradoVidaBean.getNombreAV() != null){
                Thread.sleep(2000);
                nombreInput.sendKeys(emisionPolizaAseguradoVidaBean.getNombreAV());
            }
            if (emisionPolizaAseguradoVidaBean.getApellidoAV() != null){
                Thread.sleep(2000);
                apellidoInput.sendKeys(emisionPolizaAseguradoVidaBean.getApellidoAV());
            }

            Thread.sleep(2000);
            btnBuscarAsegVida.click();

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            Thread.sleep(2000);
            WebElement btnSelAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            btnSelAsegVida.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAsociarAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnAsociarAsegVida.click();

            /** Espere **/
            WebElement mensajeEspera2 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera2.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            if (emisionPolizaAseguradoVidaBean.getPorcentajeAV() != null) {
                WebElement porcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentaje.clear();
                porcentaje.sendKeys(emisionPolizaAseguradoVidaBean.getPorcentajeAV());
            }

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen15", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAGuardarAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnAGuardarAsegVida.click();

            Thread.sleep(2000);
            WebElement cerrarBuscador = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_closeDetailSearch_container']"));
            cerrarBuscador.click();

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AseguradoVidaEditar(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){

        try {

            Thread.sleep(2000);
            WebElement selAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_1_Checked']"));
            selAsegVida.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen16", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnParticipacion = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_EditButton']"));
            btnParticipacion.click();

            Thread.sleep(1000);

            if (emisionPolizaAseguradoVidaBean.getNuevoPorcentajeAV() != null) {
                WebElement nuevoPorcentaje = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                nuevoPorcentaje.clear();
                nuevoPorcentaje.sendKeys(emisionPolizaAseguradoVidaBean.getNuevoPorcentajeAV());

                // Captura
                Thread.sleep(1000);
                a.ScreenShot(driver, "screen17", nombreAutomatizacion);
                Toolkit.getDefaultToolkit().beep();
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            btnGuardar.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen18", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AseguradoVidaEliminar(Metodos a, WebDriver driver, EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean){

        try {

            Thread.sleep(1000);
            WebElement selAsegVida = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_Container_sorting_3_Checked']"));
            selAsegVida.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen19", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnEliminar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_DeleteButton']"));
            btnEliminar.click();


            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen20", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            Thread.sleep(1000);
            WebElement btnSi = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_modalDialogSecurity_content_questionForm_yesOption']"));
            btnSi.click();

            // Captura
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen21", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

}
