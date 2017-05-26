package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosHabDeshabBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 25/04/2017.
 */
public class Asesuisa_TercerosHabDeshab {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosHabDeshab.class);

    public String nombreAutomatizacion = "Asesuisa Terceros Habilitar Deshabilitar";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosHabDeshabBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Habilitar/Deshabilitar Tercero */

            Boolean habilitado = BuscarTercero(bean, a, i, folderName, 3, 4, 5, 6, 7, 8);
            Thread.sleep(500);
            driver.close();
            Thread.sleep(500);
            a.regresarVentana(driver);

            /** Emitir Poliza **/
            menuOperaciones.OpePol_CotizacionSuscripcionEdicionCrearFrontEnd(driver, nombreAutomatizacion, 9, i, folderName);
            Thread.sleep(2000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);

            Thread.sleep(3000);

            EmitirPoliza(bean, a, i, folderName, 10, 11, 12, 13, 14, 15, 16);
            Thread.sleep(1000);
            AgregarTercero(bean, a, i, folderName, habilitado, 17, 18, 19, 20, 21);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public Boolean BuscarTercero(Asesuisa_TercerosHabDeshabBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2,
                              int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6){

        Boolean habilitado = null;
        what: try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(3000);

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            if (bean.getNumeroNIT() != null) {
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(bean.getNumeroNIT());
                Thread.sleep(1000);
                otro.click();
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(500);

            //jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Buscando Tercero");
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);

            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();

            WebElement estadoTercero = driver.findElement(By.xpath("//span[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_status']"));
            System.out.println("Tercero " + estadoTercero.getText());
            Boolean estado;
            if (estadoTercero.getText().equals("Habilitado")){
                estado = true;
            }
            else if (estadoTercero.getText().equals("Deshabilitado")){
                estado = false;
            }
            else {
                System.out.println("failed");
                break what;
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnHabilitarDeshabilitar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
            btnHabilitarDeshabilitar.click();
            Thread.sleep(3000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement mensaje = driver.findElement(By.xpath("//span[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_text']"));
            System.out.println(mensaje.getText());
            Boolean mensajeAccion;
            if (mensaje.getText().toLowerCase().equals("¿esta seguro que desea deshabilitar este tercero?")){
                mensajeAccion = true;
            }
            else if (mensaje.getText().toLowerCase().equals("¿está seguro que desea habilitar este tercero?")){
                mensajeAccion = false;
            }
            else {
                System.out.println("failed");
                break what;
            }

            WebElement confirmarMensaje = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_questionForm_confirmButton']"));
            confirmarMensaje.click();

            Thread.sleep(5000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            if (estado && mensajeAccion){ // Tercero Habilitado, Mensaje = Deshabilitar tercero?
                // No debe aparecer en la poliza
                habilitado = false;
                System.out.println("true");
            }
            else if (!estado && !mensajeAccion){ // Tercero Deshabilitado, Mensaje = Habilitar tercero?
                // Debe aparecer en la poliza
                habilitado = true;
                System.out.println("false");
            }


            a.waitSearchWicket(driver, "Espere: Ingresando a la edicion del Tercero");


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

        return habilitado;
    }

    public void EmitirPoliza(Asesuisa_TercerosHabDeshabBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,
                             int numScreenShoot5, int numScreenShoot6, int numScreenShoot7){

        poliza: try {

            //WebElement prueba = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;


            //Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']")));
            //WebElement elemento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));


            if (bean.getProducto() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
                select.selectByValue(bean.getProducto());
                Thread.sleep(1000);
            }

            if (bean.getVigencia() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
                select.selectByValue(bean.getVigencia());
                Thread.sleep(1000);
            }

            if (bean.getFechaDesde() != null){
                WebElement elemento = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
                elemento.sendKeys(bean.getFechaDesde());
                Thread.sleep(1000);
                WebElement clic = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
                clic.click();
            }

            if (bean.getFechaHasta() != null){
                WebElement elemento = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_finalDate']"));
                elemento.sendKeys(bean.getFechaHasta());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

            a.waitSearchWicket(driver, "Espere Evento a aplicar");

            if (bean.getEventoAplicar() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
                select.selectByValue(bean.getEventoAplicar());
                Thread.sleep(1000);
            }

            if (bean.getFechaMovimiento() != null){
                WebElement elemento = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_templateContainer_repeaterPanel_1_fila_fieldDate']"));
                elemento.sendKeys(bean.getFechaMovimiento());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

            a.waitSearchWicket(driver, "Continuando a Informacion de la poliza");


            // Informacion de la poliza

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));

            if (bean.getPlanFinanciamento() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_listFinancialPlans']")));
                select.selectByValue(bean.getPlanFinanciamento());
                otro.click();
                Thread.sleep(3000);
            }

            if (bean.getMonedas() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_ListCurrencies']")));
                select.selectByValue(bean.getMonedas());
                otro.click();
                Thread.sleep(3000);
            }

            if (bean.getSucursal() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getSucursal());
                otro.click();
                Thread.sleep(3000);
            }

            if (bean.getFuncionamientoPoliza() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getFuncionamientoPoliza());
                otro.click();
                Thread.sleep(10000);
            }

            if (bean.getCanalVenta() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_8_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getCanalVenta());
                otro.click();
                Thread.sleep(10000);
            }

            if (bean.getComisionNegociable() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_9_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getComisionNegociable());
                otro.click();
                Thread.sleep(3000);
            }

            if (bean.getUnidadComercial() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_10_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getUnidadComercial());
                otro.click();
                Thread.sleep(10000);
            }

            if (bean.getGiro() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_5_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getGiro());
                otro.click();
                Thread.sleep(3000);
            }

            Thread.sleep(10000);

            if (bean.getGiroActividadEconomica() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_2_datatemplates_repeater_5_fila_repeaterSelect_2_field']")));
                select.selectByValue(bean.getGiroActividadEconomica());
                otro.click();
                Thread.sleep(3000);
            }

            if (bean.getSumaAsegurada() != null){
                WebElement elemento = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_3_datatemplates_repeater_1_fila_field']"));
                elemento.clear();
                Thread.sleep(500);
                jse.executeScript("hideWait()", "");
                Thread.sleep(1500);
                elemento.sendKeys(bean.getSumaAsegurada());
                Thread.sleep(1500);
                jse.executeScript("hideWait()", "");
                otro = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_PolicyInformation_BasicInformationLabel']"));
                otro.click();
                Thread.sleep(2000);
            }

            if (bean.getTipoPoliza() != null){
                Select select = new Select (driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_textAreaPanel_wrapperRepeater_4_datatemplates_repeater2_1_fila_repeaterSelect_1_field']")));
                select.selectByValue(bean.getTipoPoliza());
                otro.click();
                Thread.sleep(3000);
            }

            jse.executeScript("window.scrollBy(0,-6000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardar.click();


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void AgregarTercero(Asesuisa_TercerosHabDeshabBean bean, Metodos a, int i, String folderName, Boolean habilitado, int numScreenShoot, int numScreenShoot2, int numScreenShoot3,
                               int numScreenShoot4, int numScreenShoot5){
        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,800)", "");
            Thread.sleep(1000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            if (bean.getPrimerNombre() != null || bean.getSegundoNombre() != null || bean.getPrimerApellido() != null || bean.getSegundoApellido() != null) {

                WebElement tercero = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                Thread.sleep(1500);
                tercero.click();
                tercero = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));

                if (bean.getPrimerNombre() != null && bean.getSegundoNombre() != null && bean.getPrimerApellido() != null && bean.getSegundoApellido() != null) {
                    tercero.sendKeys(bean.getPrimerNombre() + " " + bean.getSegundoNombre() + " " + bean.getPrimerApellido() + " " + bean.getSegundoApellido());
                }
                else if (bean.getPrimerNombre() != null && bean.getSegundoNombre() != null && bean.getPrimerApellido() != null && bean.getSegundoApellido() == null) {
                    tercero.sendKeys(bean.getPrimerNombre() + " " + bean.getSegundoNombre() + " " + bean.getPrimerApellido());
                }
                else if (bean.getPrimerNombre() != null && bean.getSegundoNombre() == null && bean.getPrimerApellido() != null && bean.getSegundoApellido() != null) {
                    tercero.sendKeys(bean.getPrimerNombre() + " " + bean.getPrimerApellido() + " " + bean.getSegundoApellido());
                }
                else if (bean.getPrimerNombre() != null && bean.getSegundoNombre() == null && bean.getPrimerApellido() != null && bean.getSegundoApellido() == null) {
                    tercero.sendKeys(bean.getPrimerNombre() + " " + bean.getPrimerApellido());
                }
            }

            Thread.sleep(2000);
            Boolean tHabilitado = driver.findElements(By.xpath("/html/body/div[6]/div/ul/li")).size() > 0;

            if (habilitado && tHabilitado){

                WebElement selTercero = driver.findElement(By.xpath("/html/body/div[6]/div/ul/li"));
                // /html/body/div[6]/div/ul/li[1]
                selTercero.click();
                Thread.sleep(2000);
                System.out.println("Tercero habilitado y agregado a la poliza");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
                btnAsociar.click();

                Thread.sleep(1000);
                a.waitSearchWicket(driver, "Asociando tercero");


                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
                btnAgregar.click();
                Thread.sleep(1000);
                a.waitSearchWicket(driver, "Agregando Pago");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
                btnGuardar.click();
                Thread.sleep(1000);
                a.waitSearchWicket(driver, "Guardando tercero");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
            else if (!habilitado && !tHabilitado){
                System.out.println("Tercero deshabilitado, no se puede agregar a la poliza");

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }
            else {
                System.out.println("failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
