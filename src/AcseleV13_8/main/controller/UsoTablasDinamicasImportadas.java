package AcseleV13_8.main.controller;

import AcseleV13_8.beans.UsoTablasDinamicasImportadasBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by agil on 17/08/2016.
 */
public class UsoTablasDinamicasImportadas {

    private final static Logger log = Logger.getLogger(UsoTablasDinamicasImportadas.class);

    public static String nombreAutomatizacion = "Uso de Tablas Dinamicas Importadas";

    public void testLink(UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean, int i) throws IOException, InterruptedException {

        try {
            //implementando clases
            Metodos a = new Metodos();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();
            MenuOperaciones menuOperaciones = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Ingreso al menu
            menuMantenimiento.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BuscarTabla(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            ImportTablaDinamica(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            driver.close();

            a.regresarVentana(driver);

            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 7, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //TablaDinamica(a, driver, importExportTablasDinamicasBean);
            CrearPoliza(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            InformacionPoliza(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            AgregarTerceroTomador(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            AgregarUnidadRiesgo(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            AgregarObjetoAsegurado(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
            Comprobar(a, driver, usoTablasDinamicasImportadasBean);

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BuscarTabla(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try {

            Thread.sleep(2000);

            WebElement nombreTabDina = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/input"));
            nombreTabDina.sendKeys(usoTablasDinamicasImportadasBean.getNombreTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/form/table/tbody/tr[5]/td/input[2]"));
            btnAceptar.click();


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }

    public  void ImportTablaDinamica(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try {

            System.out.println("Inicio de la funcion ImportTablaDinamica");

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3-2", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnImport = driver.findElement(By.xpath("//*[@id=\"idb_0402008_TableTemplateViewer_07\"]"));
            btnImport.click();

            Thread.sleep(4000);

            // Cambiar de ventana
            // getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
            Set<String> sid = driver.getWindowHandles();
            // Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println(parentId);
            String childId = it.next();
            System.out.println(childId);
            String childId2 = it.next();
            System.out.println(childId2);
            // swtiching control to child Window
            driver.switchTo().window(childId2);

            WebElement btnSelect = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td/input[1]"));
            /****/
            //btnSelect.sendKeys("C://AcseleTests//Export//Prueba2.xml");
            btnSelect.sendKeys(usoTablasDinamicasImportadasBean.getRutaTablaDinamica());

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAcept = driver.findElement(By.xpath("//*[@id=\"idb_0402023_selectXMLFile_01\"]"));
            btnAcept.click();

            Thread.sleep(3000);
            // Mensajes de Alerta
            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }


            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            WebElement btnClose = driver.findElement(By.xpath("//*[@id=\"idb_0402023_DynamicTablesImportExportResultMessage_01\"]"));
            btnClose.click();

            Thread.sleep(2000);
            driver.switchTo().window(childId);

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();




        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void CrearPoliza(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (usoTablasDinamicasImportadasBean.getProducto() != null) {
                Select producto = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
                producto.selectByValue(usoTablasDinamicasImportadasBean.getProducto());
            }

            if (usoTablasDinamicasImportadasBean.getVigencia() != null) {
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
                vigencia.selectByValue(usoTablasDinamicasImportadasBean.getVigencia());
            }

            if (usoTablasDinamicasImportadasBean.getFechaDesde() != null) {
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
                fechaDesde.sendKeys(usoTablasDinamicasImportadasBean.getFechaDesde());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnCrear = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_CreateQuoteButton']"));
            btnCrear.click();

            /***Espera***/
            WebElement mensajeEspera1 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera1.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            if (usoTablasDinamicasImportadasBean.getEventoAplicar() != null) {
                Select eventoAplicar = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
                eventoAplicar.selectByValue(usoTablasDinamicasImportadasBean.getEventoAplicar());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']"));
            btnContinuar.click();

            /***Espera***/
            WebElement mensajeEspera2 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera2.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 2");
            }

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InformacionPoliza(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (usoTablasDinamicasImportadasBean.getNumPoliza() != null) {
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(usoTablasDinamicasImportadasBean.getNumPoliza());
            }

            if (usoTablasDinamicasImportadasBean.getLineaCredito() != null) {
                Thread.sleep(3000);
                Select lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                lineaCredito.selectByValue(usoTablasDinamicasImportadasBean.getLineaCredito()); // Consumo Con Garantia Hipotecaria
                if (usoTablasDinamicasImportadasBean.getLineaCredito() != null) {
                    Thread.sleep(3000);
                    lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                    lineaCredito.selectByValue(usoTablasDinamicasImportadasBean.getLineaCredito()); // Consumo Con Garantia Hipotecaria
                }
            }

            if (usoTablasDinamicasImportadasBean.getUnidadNegocio() != null) {
                Thread.sleep(3000);
                Select unidadNegocio = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                unidadNegocio.selectByValue(usoTablasDinamicasImportadasBean.getUnidadNegocio()); // Bancaseguros
            }

            if (usoTablasDinamicasImportadasBean.getCanalVenta() != null) {
                Thread.sleep(3000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_2_field']")));
                canalVenta.selectByValue(usoTablasDinamicasImportadasBean.getCanalVenta()); // ATM
            }

            if (usoTablasDinamicasImportadasBean.getTipoValorAsegurado() != null) {
                Thread.sleep(3000);
                Select tipoValorAsegurado = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                tipoValorAsegurado.selectByValue(usoTablasDinamicasImportadasBean.getTipoValorAsegurado()); // Valor inicial del desembolso
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_calculateButton']"));
            btnGuardar.click();

            /***Espera***/
            WebElement mensajeEspera3 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera3.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 3");
            }


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarTerceroTomador(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (usoTablasDinamicasImportadasBean.getTomadorNombre() != null) {
                WebElement inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                inputTomador.click();
                inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                inputTomador.sendKeys(usoTablasDinamicasImportadasBean.getTomadorNombre());
            }

            Thread.sleep(2000);
            WebElement selTomador = driver.findElement(By.xpath("/html/body/div[6]/div/ul/li"));
            selTomador.click();

            Thread.sleep(2000);
            WebElement btnAsociar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsociar.click();

            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_paymentCollectorBranches_tablePaymentCollectorBranch_0_addPaymentModeButton']"));
            btnAgregar.click();

            /***Espera***/
            WebElement mensajeEspera4 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera4.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 4");
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(2000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
                                                                                   //"policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation"
            btnGuardar.click();

            /***Espera***/
            WebElement mensajeEspera5 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera5.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 5");
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarUnidadRiesgo(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnNuevo = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_registerFormRisk_NewButtonRisk']"));
            btnNuevo.click();

            /***Espera***/
            WebElement mensajeEspera6 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera6.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 6");
            }

            if (usoTablasDinamicasImportadasBean.getNumCredito() != null) {
                Thread.sleep(2000);
                WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numCredito.sendKeys(usoTablasDinamicasImportadasBean.getNumCredito());
            }

            if (usoTablasDinamicasImportadasBean.getFechaProceso() != null) {
                Thread.sleep(2000);
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                fechaProceso.sendKeys(usoTablasDinamicasImportadasBean.getFechaProceso());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_saveButtonRU']"));
            btnGuardar.click();

            /***Espera***/
            WebElement mensajeEspera7 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera7.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 7");
            }

            Thread.sleep(2000);
            WebElement mensajefecha = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_feedbackLabel']"));
            if (mensajefecha.isDisplayed()){
                Thread.sleep(1000);
                WebElement fechaProceso2 = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                fechaProceso2.sendKeys(usoTablasDinamicasImportadasBean.getFechaProceso());
                Thread.sleep(1000);

                Thread.sleep(1000);
                a.ScreenShot(driver, "screen13-2", nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                btnGuardar.click();
            }

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarObjetoAsegurado(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (usoTablasDinamicasImportadasBean.getDocIdAsegurado() != null) {
                Thread.sleep(1000);
                WebElement docIdAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                docIdAsegurado.sendKeys(usoTablasDinamicasImportadasBean.getDocIdAsegurado());
            }

            if (usoTablasDinamicasImportadasBean.getFechaNacAsegurado() != null) {
                Thread.sleep(1000);
                WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                fechaNacAsegurado.sendKeys(usoTablasDinamicasImportadasBean.getFechaNacAsegurado());
            }

            if (usoTablasDinamicasImportadasBean.getDireccionAsegurado() != null) {
                Thread.sleep(1000);
                WebElement direccionAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                direccionAsegurado.sendKeys(usoTablasDinamicasImportadasBean.getDireccionAsegurado());
            }


            Thread.sleep(2000);
            if (usoTablasDinamicasImportadasBean.getDepartamentoAsegurado() != null) {
                Thread.sleep(1000);
                Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                departamento.selectByValue(usoTablasDinamicasImportadasBean.getDepartamentoAsegurado());

//                Thread.sleep(2000);
//                String city = "CALAMAR";
//                if (city != null) {
//                    Thread.sleep(1000);
//                    Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
//                    ciudad.selectByValue(city);
//                }

            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
            btnGuardar.click();

            /***Espera***/
            WebElement mensajeEspera8 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera8.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 8");
            }

            Thread.sleep(2000);
            WebElement mensajeDep = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_feedbackLabel']"));
            if (mensajeDep.isDisplayed()){
                Thread.sleep(2000);
                if (usoTablasDinamicasImportadasBean.getDepartamentoAsegurado() != null) {
                    Thread.sleep(1000);
                    Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                    departamento.selectByValue(usoTablasDinamicasImportadasBean.getDepartamentoAsegurado());

                    Thread.sleep(2000);
                    if (usoTablasDinamicasImportadasBean.getCiudadAsegurado() != null) {
                        Thread.sleep(1000);
                        Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
                        ciudad.selectByValue(usoTablasDinamicasImportadasBean.getCiudadAsegurado());
                    }

                }
                Thread.sleep(1000);
                a.ScreenShot(driver, "screen14-2", nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                Thread.sleep(1000);
                btnGuardar.click();
            }

            /***Espera***/
            WebElement mensajeEspera9 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera9.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 9");
            }

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public static void Comprobar(Metodos a, WebDriver driver, UsoTablasDinamicasImportadasBean usoTablasDinamicasImportadasBean){

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();
            Thread.sleep(1000);

            /***Espera***/
            WebElement mensajeEspera10 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera10.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 10");
            }

            Thread.sleep(1000);
            WebElement cantidad = driver.findElement(By.xpath("//span[@wicketpath='modalWindowForm_EventSection_content_PolicyResultsSection_TPMovementTable_ThirdPartyMovementTable_1_TPAmount']"));
            cantidad.getText();
            System.out.println(cantidad.getText());
            System.out.println(cantidad.getSize());
            System.out.println(cantidad.getTagName());

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen15", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            //IOException e = new IOException();
            if (cantidad.getText().equals(usoTablasDinamicasImportadasBean.getValorComparacionTD())){
                System.out.println("Test Case - " + nombreAutomatizacion + ": Exitosa");
            }
            else {
                System.out.println("Fallida");
                log.info("Test Case - " + nombreAutomatizacion + ": Fallida");
                //throw e;
            }


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }


}
