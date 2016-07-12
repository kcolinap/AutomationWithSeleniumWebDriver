package main.controller;

import beans.TercerosHabilitarDeshabilitarBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 12/07/2016.
 */
public class TercerosHabilitarDeshabilitar {

    private final static Logger log = Logger.getLogger(TercerosHabilitarDeshabilitar.class);

    public String nombreAutomatizacion = "Terceros Habilitar Deshabilitar";

    public void testLink(TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean, int i) throws Exception{

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Consulta del Tercero
        IngresarMenuBuscarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosHabilitarDeshabilitarBean); //Busqueda Tercero

        // Boton Habilitar Deshabilitar
        WebElement btnHabDesh = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
        btnHabDesh.click();

        Thread.sleep(3000);
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(1000);


        // Aceptar la Habilitación/Deshabilitación del tercero
        WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_questionForm_confirmButton']"));
        btnAceptar.click();
        Thread.sleep(3000);
        WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_2_thirdPartyRadio']"));
        selccionTercero.click();
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Cerrar la ventana
        driver.close();
        // Regresar a Ventana anterior
        a.regresarVentana(driver);

        // Creación de Póliza
        IngresarMenuEmisionPoliza(driver, a);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        CrearPoliza(a, driver, tercerosHabilitarDeshabilitarBean);

    }

    public void IngresarMenuBuscarTercero(WebDriver driver, Metodos a) throws IOException, InterruptedException{
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]")); // Mantenimiento
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[2]")); // Mantenimiento de Terceros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[36]/div[2]")); // Busqueda de Terceros
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
        menu3.click();
    }

    public void BusquedaT(Metodos a, WebDriver driver, TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        try {
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosHabilitarDeshabilitarBean.getTipTercer() != null){
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(tercerosHabilitarDeshabilitarBean.getTipTercer());
            }
            Thread.sleep(2000);

            if (tercerosHabilitarDeshabilitarBean.getTipDcID() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(tercerosHabilitarDeshabilitarBean.getTipDcID());
            }

            if (tercerosHabilitarDeshabilitarBean.getCedulaID() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(tercerosHabilitarDeshabilitarBean.getCedulaID());
            }

            if (tercerosHabilitarDeshabilitarBean.getNombreT() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(tercerosHabilitarDeshabilitarBean.getNombreT());
            }

//        if (tercerosHabilitarDeshabilitarBean.getApellidoT() != null) {
//        WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(tercerosHabilitarDeshabilitarBean.getApellidoT());
//        }

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void IngresarMenuEmisionPoliza(WebDriver driver, Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]")); // Operación
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[2]")); // Operaciones Pólizas
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[6]/div[2]")); // Crear
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen9", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();
        menu3.click();
    }

    public void CrearPoliza(Metodos a, WebDriver driver, TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean) throws InterruptedException {

        // //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        // Formulario de Administración de Propuestas y Pólizas
        try {
            Select productoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
            productoSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getProducto());
            Thread.sleep(2000);

            Select vigenciaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
            vigenciaSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getVigencia());
            Thread.sleep(2000);

            WebElement fechaDes = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
            fechaDes.sendKeys(tercerosHabilitarDeshabilitarBean.getFechaDesde());
            Thread.sleep(2000);

            WebElement fechaHas = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
            if (tercerosHabilitarDeshabilitarBean.getFechaHasta() != null) {
                fechaHas.sendKeys(tercerosHabilitarDeshabilitarBean.getFechaHasta());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }

        Thread.sleep(3000);

        // Formulario de Evento a Aplicar
        try {
            Select eventoAplicarSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));

            eventoAplicarSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getEventoAplicar());
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }

        Thread.sleep(4000);

        // Formulario de la Póliza
        try {
            Select sucursalSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
            sucursalSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getSucursal());

            Thread.sleep(2000);
            Select tipoProduccionSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_repeaterSelect_1_field']")));
            tipoProduccionSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getTipoProduccion());

            Thread.sleep(2000);
            Select lineaCreditoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
            lineaCreditoSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getLineaCredito());

            Thread.sleep(2000);
            Select unidadNegocioSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
            unidadNegocioSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getUnidadNegocio());

            Thread.sleep(2000);
            Select canalVentaSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_2_field']")));
            canalVentaSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getCanalVenta());

            Thread.sleep(2000);
            Select tipoValorAseguradoSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_repeaterSelect_1_field']")));
            tipoValorAseguradoSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getTipoValorAsegurado());

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnGuardarInfGeneral = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardarInfGeneral.click();

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }

        /** Experimento de Espera que se deshabilite el mensaje de Espera**/
//        WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
//        while (mensajeEspera.isDisplayed()){
//            Thread.sleep(5000);
//        }

        Thread.sleep(4000);
        // Tomador (Tercero) // //TipoElemento[@wicketpath='WicketpathElemento']
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

            if (tercerosHabilitarDeshabilitarBean.getTipTercer() != null){
                tipoTeceroSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getTipTercer());
            }
            if (tercerosHabilitarDeshabilitarBean.getTipDcID() != null){
                tipoDocIdSelect.selectByValue(tercerosHabilitarDeshabilitarBean.getTipDcID());
            }
            if (tercerosHabilitarDeshabilitarBean.getCedulaID() != null){
                cedulaInput.sendKeys(tercerosHabilitarDeshabilitarBean.getCedulaID());
            }
            if (tercerosHabilitarDeshabilitarBean.getNombreT() != null){
                nombreInput.sendKeys(tercerosHabilitarDeshabilitarBean.getNombreT());
            }
            if (tercerosHabilitarDeshabilitarBean.getApellidoT() != null){
                apellidoInput.sendKeys(tercerosHabilitarDeshabilitarBean.getApellidoT());
            }

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            btnBuscarTomador.click();

            Thread.sleep(2000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }

        /**
        try {
            WebElement selecTercero = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_detailSearch_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"))
        }catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 21 - " + nombreAutomatizacion + " - " + e);
        }
         */


    }

}
