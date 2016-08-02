package main.controller;

import beans.EmisionPolizaBeneficiarioNaturalBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 02/08/2016.
 */
public class EmisionPolizaBeneficiarioNatural {

    private final static Logger log = Logger.getLogger(EmisionPolizaBeneficiarioNatural.class);

    public String nombreAutomatizacion = "Emision de Póliza Beneficiario Natural";

    public void testLink(EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean, int i) throws IOException, InterruptedException {

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
        CrearPoliza(a, driver, emisionPolizaBeneficiarioNaturalBean);
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

    public void CrearPoliza(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean) throws InterruptedException {

        // //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        AdminitracionPropuestaPoliza(a, driver, emisionPolizaBeneficiarioNaturalBean);
        Thread.sleep(3000);
        EventoAplicar(a, driver, emisionPolizaBeneficiarioNaturalBean);
        Thread.sleep(4000);
        InformacionGeneral(a, driver, emisionPolizaBeneficiarioNaturalBean);
        Thread.sleep(4000);

        /***Espera***/
        TomadorTercero(a, driver, emisionPolizaBeneficiarioNaturalBean);
        UnidadRiesgo(a, driver, emisionPolizaBeneficiarioNaturalBean);
    }

    public void AdminitracionPropuestaPoliza(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean){
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(emisionPolizaVariosOABean.getProducto()); //VidaDeudoresAvVillas
            Thread.sleep(2000);

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(emisionPolizaVariosOABean.getVigencia()); //12= Anual
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(emisionPolizaVariosOABean.getFechaDesde()); // 19-07-2016
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (emisionPolizaVariosOABean.getFechaHasta() != null) {
                fechaHas.sendKeys(emisionPolizaVariosOABean.getFechaHasta());
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

    public void EventoAplicar(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean){
        try {
            Thread.sleep(3000);
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(emisionPolizaVariosOABean.getEventoAplicar()); // Emitir
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
    public void InformacionGeneral(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean){
        try {
            Select sucursalSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
            sucursalSelect.selectByValue(emisionPolizaVariosOABean.getSucursal()); //24651917 = Direccion General

            Thread.sleep(2000);
            Select tipoProduccionSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
            tipoProduccionSelect.selectByValue(emisionPolizaVariosOABean.getTipoProduccion()); // 24652617 = Directa

            WebElement periodoGracia = driver. findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_field']"));
            periodoGracia.sendKeys(emisionPolizaVariosOABean.getPeriodoGracia()); // 15
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            WebElement tasaInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_5_fila_field']"));
            tasaInput.clear();
            tasaInput.sendKeys(emisionPolizaVariosOABean.getTasa()); // 10
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            Select lineaCreditoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
            lineaCreditoSelect.selectByValue(emisionPolizaVariosOABean.getLineaCredito()); // 41249817 = Educativa

            Thread.sleep(2000);
            Select unidadNegocioSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
            unidadNegocioSelect.selectByValue(emisionPolizaVariosOABean.getUnidadNegocio()); // 23913017 = Bancaseguros

            Thread.sleep(2000);
            Select canalVentaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_2_field']")));
            canalVentaSelect.selectByValue(emisionPolizaVariosOABean.getCanalVenta()); // 21.0 = ATM

            Thread.sleep(2000);
            Select tipoValorAseguradoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
            tipoValorAseguradoSelect.selectByValue(emisionPolizaVariosOABean.getTipoValorAsegurado()); // 23916617 = Valor inicial del desembolso


//            Thread.sleep(3000);
//            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            Select tipoTasaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
            tipoTasaSelect.selectByValue(emisionPolizaVariosOABean.getTipoTasa()); // 24650617 = Por 100


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

    public void TomadorTercero(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean){
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

            if (emisionPolizaVariosOABean.getTipoTercero() != null){
                tipoTeceroSelect.selectByValue(emisionPolizaVariosOABean.getTipoTercero());
            }
            if (emisionPolizaVariosOABean.getTipoDicIdentidad() != null){
                tipoDocIdSelect.selectByValue(emisionPolizaVariosOABean.getTipoDicIdentidad());
            }
            if (emisionPolizaVariosOABean.getCedula() != null){
                cedulaInput.sendKeys(emisionPolizaVariosOABean.getCedula());
            }
            if (emisionPolizaVariosOABean.getNombre() != null){
                nombreInput.sendKeys(emisionPolizaVariosOABean.getNombre());
            }
            if (emisionPolizaVariosOABean.getApellido() != null){
                apellidoInput.sendKeys(emisionPolizaVariosOABean.getApellido());
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

            if (emisionPolizaVariosOABean.getPorcentajeTomador() != null) {
                WebElement porcentajeTomadorInput = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_repeaterPanel2_1_fila_field']"));
                porcentajeTomadorInput.clear();
                porcentajeTomadorInput.sendKeys(emisionPolizaVariosOABean.getPorcentajeTomador());
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

    public void UnidadRiesgo(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean){
        try {
            // Primera UR
            WebElement btnNuevaUR1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevaUR1.click();
            Thread.sleep(6000);

            WebElement numCredito1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
            numCredito1.sendKeys(emisionPolizaVariosOABean.getNumCredito());
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();

            Thread.sleep(2000);
            WebElement montoAseg1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
            montoAseg1.clear();
            montoAseg1.sendKeys(emisionPolizaVariosOABean.getMontoAsgurado());
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_styleAcordeon_label']")).click();
            Thread.sleep(3000);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar1 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar1.click();

            Thread.sleep(4000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            ObjetoAsegurado1(a, driver, emisionPolizaVariosOABean);

            Thread.sleep(3000);
            WebElement btnNuevoOA = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_registerFormInsurance_containerButton_NewButtonInsurance']"));
            btnNuevoOA.click();
            Thread.sleep(3000);


            ObjetoAsegurado2(a, driver, emisionPolizaVariosOABean);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ObjetoAsegurado1(Metodos a, WebDriver driver, EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean){
        try{
            Thread.sleep(3000);
            WebElement porExPrima = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
            porExPrima.clear();
            porExPrima.sendKeys(emisionPolizaVariosOABean.getPorcExtraPrima1());
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_styleAcordeon_label']"));
            Thread.sleep(3000);


            Thread.sleep(4000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

            AseguradoVida(a, driver, emisionPolizaVariosOABean);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }


}
