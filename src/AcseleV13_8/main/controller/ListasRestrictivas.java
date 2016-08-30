package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ListasRestrictivasBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.support.ui.Select;
import sun.security.krb5.internal.TGSRep;

/**
 * Created by kzambrano on 25/08/2016.
 */
public class ListasRestrictivas {

    private final static Logger log = Logger.getLogger(ListasRestrictivas.class);

    public String nombreAutomatizacion = "Listas Restrictivas Coincidencias";

    public void testLink (ListasRestrictivasBean listasRestrictivasBean, int i )  throws IOException, InterruptedException {


        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuMantenimiento m = new MenuMantenimiento();
        MenuOperaciones menuOperaciones = new MenuOperaciones();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.AdminLisRest_CrearListasRestrictivas(a, driver, nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);

        ListasRestrictivasCrear (driver, a, listasRestrictivasBean);
        Thread.sleep(2000);
        a.regresarVentana(driver);
        Thread.sleep(1500);


        m.AdminLisRest_CoincidenciaListasRestrictivas(a, driver, nombreAutomatizacion);

        Thread.sleep(3000);
        a.cambiarVentana(driver);

        CrearCoincidencias (driver, a, listasRestrictivasBean);
        Thread.sleep(1500);

        a.regresarVentana(driver);
        menuOperaciones.OpePol_Crear ( driver,  nombreAutomatizacion,  24);
        Thread.sleep(2000);
        a.cambiarVentana(driver);


        CrearPoliza(driver, a, listasRestrictivasBean);
        Thread.sleep(1000);
        InformacionPoliza (driver, a, listasRestrictivasBean);
        Thread.sleep(1000);
        AgregarTerceroTomador (driver, a, listasRestrictivasBean);
        Thread.sleep(1000);
        AgregarUnidadRiesgo (driver, a, listasRestrictivasBean);
        Thread.sleep(1000);
        AgregarObjetoAsegurado (driver, a, listasRestrictivasBean);
        Thread.sleep(1000);
        Comprobar(driver, a, listasRestrictivasBean);
        Thread.sleep(2500);
        a.regresarVentana(driver);
        Thread.sleep(2000);
        m.Aud_TrazasAuditoriaVaadin ( driver,  nombreAutomatizacion,  35);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        TrazasCoincidencias (driver, a, listasRestrictivasBean);




    }

    public void ListasRestrictivasCrear (WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        try {

            Thread.sleep(1500);
         /*   Thread.sleep(1000);

            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/span/span"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen5", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement tipo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div"));
            tipo.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement opcion = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td"));
            Thread.sleep(1000);
            opcion.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement nombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div"));
            nombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[6]/td/span"));
            Thread.sleep(1000);
            opcionNombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);
            Thread.sleep(3000);



            WebElement archivo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[2]/form/div/input[2]"));
            Thread.sleep(3000);
            //archivo.sendKeys (listasRestrictivasBean.getArchivo());

           //archivo.sendKeys("C://AcseleTests//rutas//PruebaAutomatizacion.xls");
            //archivo.sendKeys("C://AcseleTests//rutas");
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement pantalla = driver.findElement(By.xpath("//*[@id=\"fieldsListRestrictive\"]/div/div[3]/div/div/div[1]/div"));
            pantalla.click();
            Thread.sleep(4000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span/span"));
            btnAceptar.click();
            Thread.sleep(5000);
*/

            WebElement lista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div[3]/div[1]/table/tbody/tr[3]/td[1]/div"));
            lista.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen11", nombreAutomatizacion);
            Thread.sleep(1500);


            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/span/span"));
            Thread.sleep(1000);
            btnConsultar.click();
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);

            WebElement ultimaLista = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div/div/span/input"));
            ultimaLista.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement btnAcept = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[3]/div/div/div[1]/div/span"));
            Thread.sleep(1000);
            btnAcept.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnCerrar = driver.findElement(By.xpath("/html/body/div[3]/div[8]/div/div/div[5]/div/div/div[3]/div/div/div/div/span"));
            btnCerrar.click();
            Thread.sleep(1000);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }

    }


    public void CrearCoincidencias (WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{


        try {
            a.changeLastWindows(driver);
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen16", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement btnAgregarCoinc = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/span"));
            btnAgregarCoinc.click();
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen17", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement opcionLista = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[1]/div/div/div/table/tbody/tr/td[3]/div/div[1]/div/div/div[3]/div/div"));
            opcionLista.click();
            Thread.sleep(1000);

            WebElement listaNombre = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[7]/td/span"));
            Thread.sleep(1000);
            listaNombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen18", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement opcionCoinc = driver.findElement(By.xpath("//html/body/div[3]/div[5]/div/div/div[5]/div/div/div[1]/div/div/div/table/tbody/tr/td[3]/div/div[3]/div/div/div[3]/div/div"));
            opcionCoinc.click();
            Thread.sleep(1500);

            WebElement tipoCoinc = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td"));
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen19", nombreAutomatizacion);
            Thread.sleep(1000);
            tipoCoinc.click();
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen20", nombreAutomatizacion);

            WebElement primeraopcion = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[4]/div/select/option[1]"));
            primeraopcion.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen21", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span/span"));
            btnSeleccionar.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen22", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/span/span"));
            Thread.sleep(1000);
            btnSalvar.click();
            Thread.sleep(2000);


            WebElement ultimaCoinc = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div"));
            ultimaCoinc.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen23", nombreAutomatizacion);



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }

    }

    public void CrearPoliza (WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        a.changeLastWindows(driver);
        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(1000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (listasRestrictivasBean.getProducto() != null) {
                Select producto = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_productsComboBox']")));
                producto.selectByValue(listasRestrictivasBean.getProducto());
            }

            if (listasRestrictivasBean.getVigencia() != null) {
                Thread.sleep(2000);
                Select vigencia = new Select(driver.findElement(By.xpath("//select[@wicketpath='CreatePolicy_createPolicyForm_validitiesComboBox']")));
                vigencia.selectByValue(listasRestrictivasBean.getVigencia());
            }

            if (listasRestrictivasBean.getFechaDesde() != null) {
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("//input[@wicketpath='CreatePolicy_createPolicyForm_initialDate']"));
                fechaDesde.sendKeys(listasRestrictivasBean.getFechaDesde());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen25", nombreAutomatizacion); //screenshot2
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

            if (listasRestrictivasBean.getEventoAplicar() != null) {
                Select eventoAplicar = new Select(driver.findElement(By.xpath("//select[@wicketpath='modalWindowForm_EventSection_content_events_repeaterSelect_1_field']")));
                eventoAplicar.selectByValue(listasRestrictivasBean.getEventoAplicar());
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen26", nombreAutomatizacion); //screenshot2
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

    public void InformacionPoliza(WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (listasRestrictivasBean.getNumPoliza() != null) {
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numPoliza.sendKeys(listasRestrictivasBean.getNumPoliza());
            }

            if (listasRestrictivasBean.getLineaCredito() != null) {
                Thread.sleep(3000);
                Select lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                lineaCredito.selectByValue(listasRestrictivasBean.getLineaCredito()); // Consumo Con Garantia Hipotecaria
                if (listasRestrictivasBean.getLineaCredito() != null) {
                    Thread.sleep(3000);
                    lineaCredito = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                    lineaCredito.selectByValue(listasRestrictivasBean.getLineaCredito()); // Consumo Con Garantia Hipotecaria
                }
            }

            if (listasRestrictivasBean.getUnidadNegocio() != null) {
                Thread.sleep(3000);
                Select unidadNegocio = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_1_field']")));
                unidadNegocio.selectByValue(listasRestrictivasBean.getUnidadNegocio()); // Bancaseguros
            }

            if (listasRestrictivasBean.getCanalVenta() != null) {
                Thread.sleep(3000);
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_repeaterSelect_2_field']")));
                canalVenta.selectByValue(listasRestrictivasBean.getCanalVenta()); // ATM
            }

            if (listasRestrictivasBean.getTipoValorAsegurado() != null) {
                Thread.sleep(3000);
                Select tipoValorAsegurado = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_PolicyInformation_BasicInformation_registerForm_DataTemplate_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_repeaterSelect_1_field']")));
                tipoValorAsegurado.selectByValue(listasRestrictivasBean.getTipoValorAsegurado()); // Valor inicial del desembolso
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen27", nombreAutomatizacion); //screenshot2
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

    public void AgregarTerceroTomador(WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (listasRestrictivasBean.getTomadorNombre() != null) {
                WebElement inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                inputTomador.click();
                inputTomador = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_PolicyInformation_thirdTabs_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                inputTomador.sendKeys(listasRestrictivasBean.getTomadorNombre());
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
            a.ScreenShot(driver, "screen28", nombreAutomatizacion); //screenshot2
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
            a.ScreenShot(driver, "screen29", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarUnidadRiesgo(WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

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

            if (listasRestrictivasBean.getNumCredito() != null) {
                Thread.sleep(3000);
                WebElement numCredito = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_field']"));
                numCredito.sendKeys(listasRestrictivasBean.getNumCredito());
            }

            if (listasRestrictivasBean.getFechaProceso() != null) {
                Thread.sleep(2000);
                WebElement fechaProceso = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_fieldDate']"));
                fechaProceso.sendKeys(listasRestrictivasBean.getFechaProceso());
            }

            if (listasRestrictivasBean.getMontoAsegurado() != null) {
                Thread.sleep(2000);
                WebElement montoAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_field']"));
                Thread.sleep(1000);
                WebElement afuera = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_format']"));
                afuera.click();
                montoAsegurado.clear();
                Thread.sleep(1000);
                montoAsegurado.sendKeys(listasRestrictivasBean.getMontoAsegurado());
                Thread.sleep(1000);
                WebElement afueraClick = driver.findElement(By.xpath("//div[@wicketpath='policyInformationContent_RiskInformation_BasicInformationRiskUnit_RiskBasicInformationContent_registerFormRiskUnit_templateRiskUnit_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_format']"));
                afueraClick.click();

            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen30", nombreAutomatizacion); //screenshot2
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
                fechaProceso2.sendKeys(listasRestrictivasBean.getFechaProceso());
                Thread.sleep(1000);

                Thread.sleep(1000);
                a.ScreenShot(driver, "screen30-2", nombreAutomatizacion); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                btnGuardar.click();
            }

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void AgregarObjetoAsegurado(WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));

            if (listasRestrictivasBean.getDocIdAsegurado() != null) {
                Thread.sleep(1000);
                WebElement docIdAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_2_fila_field']"));
                docIdAsegurado.sendKeys(listasRestrictivasBean.getDocIdAsegurado());
            }

            if (listasRestrictivasBean.getFechaNacAsegurado() != null) {
                Thread.sleep(1000);
                WebElement fechaNacAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_3_fila_fieldDate']"));
                fechaNacAsegurado.sendKeys(listasRestrictivasBean.getFechaNacAsegurado());
            }

            if (listasRestrictivasBean.getDireccionAsegurado() != null) {
                Thread.sleep(1000);
                WebElement direccionAsegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_4_fila_field']"));
                direccionAsegurado.sendKeys(listasRestrictivasBean.getDireccionAsegurado());
            }


            Thread.sleep(2000);
            if (listasRestrictivasBean.getDepartamentoAsegurado() != null) {
                Thread.sleep(1000);
                Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                departamento.selectByValue(listasRestrictivasBean.getDepartamentoAsegurado());

//                Thread.sleep(2000);
//                String city = "CALAMAR";
//                if (city != null) {
//                    Thread.sleep(1000);
//                    Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
//                    ciudad.selectByValue(city);
//                }

            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen31", nombreAutomatizacion); //screenshot2
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
                if (listasRestrictivasBean.getDepartamentoAsegurado() != null) {
                    Thread.sleep(1000);
                    Select departamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_1_field']")));
                    departamento.selectByValue(listasRestrictivasBean.getDepartamentoAsegurado());

                    Thread.sleep(2000);
                    if (listasRestrictivasBean.getCiudadAsegurado() != null) {
                        Thread.sleep(1000);
                        Select ciudad = new Select(driver.findElement(By.xpath("//select[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_templateIO_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_6_fila_repeaterSelect_2_field']")));
                        ciudad.selectByValue(listasRestrictivasBean.getCiudadAsegurado());
                    }

                }

                Thread.sleep(2000);
                WebElement btnguardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskBasicInformation_InformationInsurance_registerForm_saveButton']"));
                btnguardar.click();
            }

            Thread.sleep(1500);
            if (listasRestrictivasBean.getAsegurado() != null) {
                WebElement asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                asegurado.click();
                asegurado = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AutoRisk_search']"));
                asegurado.sendKeys(listasRestrictivasBean.getAsegurado());
            }

            Thread.sleep(2000);
            WebElement selAsegurado = driver.findElement(By.xpath("/html/body/div[7]/div/ul/li"));
            selAsegurado.click();

            Thread.sleep(2000);
            WebElement btnAsoc = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_AssociateButton']"));
            btnAsoc.click();

            Thread.sleep(2000);
            WebElement bguardar = driver.findElement(By.xpath("//input[@wicketpath='policyInformationContent_RiskInformation_InsuranceRiskUnit_RiskAsegurado_repeaterSubTab_1_thirdRole_Tomador_thirdForm_addThird_registerFormParticipation_saveButtonParticipation']"));
            Thread.sleep(1000);
            bguardar.click();


            Thread.sleep(1500);
            a.ScreenShot(driver, "screen31-2", nombreAutomatizacion); //screenshot2
            Toolkit.getDefaultToolkit().beep();

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

    public void Comprobar(WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

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

            Thread.sleep(2000);
            WebElement btnAplicar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnAplicar.click();

            WebElement mensajeEspera11 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera11.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 11");
            }

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen32", nombreAutomatizacion); //screenshot2
            Thread.sleep(2000);

            WebElement advertencia = driver.findElement(By.xpath("//*[@id=\"id5f7\"]/table/tbody/tr/td/div[2]"));
            Thread.sleep(1000);
            advertencia.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen33", nombreAutomatizacion); //screenshot2

            Thread.sleep(1000);
            WebElement cerrarAdv = driver.findElement(By.xpath("//*[@id=\"id5f9\"]/div"));
            cerrarAdv.click();
            Thread.sleep(1000);

            WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_ErrorDialog_content_questionForm_ignoreValidationButton']"));
            btnContinuar.click();


            WebElement mensajeEspera12 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera12.isDisplayed()){
                Thread.sleep(5000);
                System.out.println("Espera 12");
            }

            Thread.sleep(5000);
            a.ScreenShot(driver, "screen34", nombreAutomatizacion); //screenshot2
            Thread.sleep(1500);



        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void TrazasCoincidencias(WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        try{
            a.changeLastWindows(driver);
            Thread.sleep(2000);

            WebElement tipoList = driver.findElement(By.xpath("//*[@id=\"type\"]/div"));
            tipoList.click();
            Thread.sleep(1000);

            WebElement listaSelect = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
            listaSelect.click();
            Thread.sleep(1500);

            WebElement fechaDesdeTraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[4]/td[3]/div/div/div[3]/div/div/div[3]/div/input"));
            fechaDesdeTraza.sendKeys(listasRestrictivasBean.getFechaDesdeTraza());
            Thread.sleep(1000);

            WebElement fechaHastaTraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[5]/td[3]/div/div/div[3]/div/div/div[3]/div/input"));
            fechaHastaTraza.sendKeys(listasRestrictivasBean.getFechaHastaTraza());
            Thread.sleep(1500);

            a.ScreenShot(driver, "screen36", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[8]/td[3]/div/div/div/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);


         /*   WebElement lista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[5]/td[5]/div"));
            Thread.sleep(1000);
            lista.click();
            Thread.sleep(1000);
*/

            for (int i = 1; i <= 1; i++){

                WebElement detalle = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + i + "]/td[1]/div/div/span/span"));

                System.out.println("prueba-->>>>>"+detalle+" => "+ detalle.isEnabled());

               // if (detalle.isEnabled() == true){
                    detalle.click();
                //}
            }

             Thread.sleep(1000);
        //    detalle.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen37", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case 25 - " + nombreAutomatizacion + " - " + e);
        }


    }



}








