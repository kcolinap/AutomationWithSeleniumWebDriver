package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaAvanzadaPolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
/**
 * Created by mchurion on 15/11/2016.
 */
public class INTER_ConsultaAvanzadaPoliza {

    private final static Logger log = Logger.getLogger(INTER_ConsultaAvanzadaPoliza.class);

    public String nombreAutomatizacion ="Consulta Poliza Avanzada";
    private WebDriver driver;


    public void testLink(INTER_ConsultaAvanzadaPolizaBean interConsultaAvanzadaPolizaBean, int i, String folderName)throws Exception {

        try {

            // Instanciando Clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones interseguros_MenuOperaciones = new Interseguros_MenuOperaciones();


            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            interseguros_MenuOperaciones.OpePol_CotizacionSuscripcionMantenimientoPolizas(driver, nombreAutomatizacion, 2);
            Thread.sleep(2000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarPolizaAvanzada(a, interConsultaAvanzadaPolizaBean, i, folderName);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarPolizaAvanzada(Interseguros_Metodos a, INTER_ConsultaAvanzadaPolizaBean interConsultaAvanzadaPolizaBean, int i, String folderName) throws InterruptedException, IOException {

        try {

            //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Screenshot
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            // Boton Busqueda Avanzada
            driver.findElement(By.xpath("//a[@wicketpath='ConsultPolicy_searchForm_detailSearchLink']")).click();
            Thread.sleep(3000);

            /** Inicio Formulario **/
            // Ordenar Por
            if (interConsultaAvanzadaPolizaBean.getOrdenarPor() != null) {
                Select ordenarPor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_ListOrderBy']")));

                ordenarPor.selectByValue(interConsultaAvanzadaPolizaBean.getOrdenarPor());
                Thread.sleep(2000);
            }
            //Buscar Por
            if (interConsultaAvanzadaPolizaBean.getBuscarPor() != null) {
                Select buscarPor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_ListOrderBy']")));

                buscarPor.selectByValue(interConsultaAvanzadaPolizaBean.getBuscarPor());
                Thread.sleep(2000);
            }

            //Con Prima Depósito

            if (interConsultaAvanzadaPolizaBean.getConPrimaDeposito() != null) {
                if (interConsultaAvanzadaPolizaBean.getConPrimaDeposito().equals("true")) {
                    driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_check']")).click();

                    Thread.sleep(1000);
                }
            }
            if (interConsultaAvanzadaPolizaBean.getProducto() != null) {
                Select tipoProducto = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_productsList']")));

                tipoProducto.selectByValue(interConsultaAvanzadaPolizaBean.getProducto());
                Thread.sleep(2000);
            }

            // Estado del ciclo de vida
            if (interConsultaAvanzadaPolizaBean.getEdoCicloVida() != null) {
                Select edoCicloVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_eventTypeReasonStateProducts']")));
                edoCicloVida.selectByValue(interConsultaAvanzadaPolizaBean.getEdoCicloVida());
                Thread.sleep(1000);
            }

            // Oficina
            if (interConsultaAvanzadaPolizaBean.getOficina() != null) {
                Select oficina = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                oficina.selectByValue(interConsultaAvanzadaPolizaBean.getOficina());
                Thread.sleep(1000);
            }

            // Numero de Cotización
            if (interConsultaAvanzadaPolizaBean.getNumCotizacion() != null) { //input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_field']
                WebElement numCotizacion = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_1_fila_field']"));
                numCotizacion.sendKeys(interConsultaAvanzadaPolizaBean.getNumCotizacion());
                Thread.sleep(1000);
            }

            // Numero de Propuesta
            if (interConsultaAvanzadaPolizaBean.getNumPropuesta() != null) { //input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_field']
                WebElement numPropuesta = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_2_fila_field']"));
                numPropuesta.sendKeys(interConsultaAvanzadaPolizaBean.getNumPropuesta());
                Thread.sleep(1000);
            }

            // Num Poliza
            if (interConsultaAvanzadaPolizaBean.getNumPoliza() != null) { //input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_field']
                WebElement numPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_field']"));
                numPoliza.sendKeys(interConsultaAvanzadaPolizaBean.getNumPoliza());
                Thread.sleep(1000);
            }

            // Fecha de Emision
            if (interConsultaAvanzadaPolizaBean.getFechaEmision() != null) {
                WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_3_fila_fieldDate']"));
                fechaEmision.sendKeys(interConsultaAvanzadaPolizaBean.getFechaEmision());
                Thread.sleep(1000);
            }

            //Canal de Venta
            if (interConsultaAvanzadaPolizaBean.getCanalVenta() != null) {
                Select canalVenta = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_3_fila_repeaterSelect_1_field']")));

                canalVenta.selectByValue(interConsultaAvanzadaPolizaBean.getCanalVenta());
                Thread.sleep(1000);
            }

            //Fecha del evento Anterior
            if (interConsultaAvanzadaPolizaBean.getFechaEventoAnterior() != null) {
                Select fechaEventoAnterior = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_4_fila_fieldDate']")));

                fechaEventoAnterior.selectByValue(interConsultaAvanzadaPolizaBean.getFechaEventoAnterior());
                Thread.sleep(1000);
            }

            //Fecha Proxima Generación de Prima
            if (interConsultaAvanzadaPolizaBean.getFechaGeneracionPrima() != null) {
                Select fechaGeneracionPrima = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_5_fila_fieldDate']")));

                fechaGeneracionPrima.selectByValue(interConsultaAvanzadaPolizaBean.getFechaGeneracionPrima());
                Thread.sleep(1000);
            }

            //Flag Suspensión de Cancelación
            if (interConsultaAvanzadaPolizaBean.getFlagSuspCancel() != null) {
                Thread.sleep(1000);

                if (interConsultaAvanzadaPolizaBean.getFlagSuspCancel().toLowerCase().equals("no")) {
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_6_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(1000);
                } else if (interConsultaAvanzadaPolizaBean.getFlagSuspCancel().toLowerCase().equals("si")) {
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_6_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(1000);
                }
            }

            //Fecha Proxima Facturación
            if (interConsultaAvanzadaPolizaBean.getFechaProximaFacturacion() != null) {
                Select fechaProximaFacturacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_5_fila_fieldDate']")));

                fechaProximaFacturacion.selectByValue(interConsultaAvanzadaPolizaBean.getFechaProximaFacturacion());
                Thread.sleep(1000);
            }

            // Nombre Archivo Tramas
            if (interConsultaAvanzadaPolizaBean.getNombreArchivoTramas() != null) { //input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_field']
                WebElement nombreArchivoTramas = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_7_fila_field']"));
                nombreArchivoTramas.sendKeys(interConsultaAvanzadaPolizaBean.getNombreArchivoTramas());
                Thread.sleep(1000);
            }

            //Fecha Suspensión de Cancelación
            if (interConsultaAvanzadaPolizaBean.getFechaSuspensionCancel() != null) {
                Select fechaSuspensionCancel = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_6_fila_fieldDate']")));

                fechaSuspensionCancel.selectByValue(interConsultaAvanzadaPolizaBean.getFechaSuspensionCancel());
                Thread.sleep(1000);
            }

            // Periodo de Suspensión
            if (interConsultaAvanzadaPolizaBean.getPeriodoSuspensionCancel() != null) { //input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_2_fila_field']
                WebElement periodoSuspensionCancel = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_8_fila_field']"));
                periodoSuspensionCancel.sendKeys(interConsultaAvanzadaPolizaBean.getPeriodoSuspensionCancel());
                Thread.sleep(1000);
            }

            // Número de Plan
            if (interConsultaAvanzadaPolizaBean.getNumPlan() != null) {
                WebElement numPlan = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_7_fila_field']"));
                numPlan.sendKeys(interConsultaAvanzadaPolizaBean.getNumPlan());
                Thread.sleep(1000);
            }

            //Fecha Inicio de Suspensión
            if (interConsultaAvanzadaPolizaBean.getFechaInicioSuspenCancel() != null) {
                Select fechaInicioSuspenCancel = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_8_fila_fieldDate']")));

                fechaInicioSuspenCancel.selectByValue(interConsultaAvanzadaPolizaBean.getFechaInicioSuspenCancel());
                Thread.sleep(1000);
            }

            //Procede Suspensión
            if (interConsultaAvanzadaPolizaBean.getProcedeSuspensionCancel() != null) {
                Thread.sleep(1000);

                if (interConsultaAvanzadaPolizaBean.getProcedeSuspensionCancel().toLowerCase().equals("no")) {
                    WebElement no = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_9_fila_field_repeaterChoice_1_radio']"));
                    no.click();
                    //clicOut.click();
                    Thread.sleep(1000);
                } else if (interConsultaAvanzadaPolizaBean.getProcedeSuspensionCancel().toLowerCase().equals("si")) {
                    WebElement si = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_9_fila_field_repeaterChoice_2_radio']"));
                    si.click();
                    //clicOut.click();
                    Thread.sleep(1000);
                }
            }

            // Monto de la Prima Enviado en Archivo de Trama
            if (interConsultaAvanzadaPolizaBean.getMontoPrimaEnvArchTrama() != null) {
                WebElement montoPrimaEnvArchTrama = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_9_fila_field']"));
                montoPrimaEnvArchTrama.sendKeys(interConsultaAvanzadaPolizaBean.getMontoPrimaEnvArchTrama());
                Thread.sleep(1000);
            }

            //Screenshot
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();


            // Boton Buscar
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']")).click();
            Thread.sleep(6000);

            //Seleccion poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

            //Screenshot
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            // Boton Consultar
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_ConsultPolicyButton']")).click();
            Thread.sleep(3000);


            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }
            //Hacer scroll
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/label")).click();

            //Screenshot
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div/div[1]/div[3]/div[3]/div/div/div/div/div[2]/div/div[2]/table/tbody/tr/td[1]/div[22]/div/div/div/div[3]")).click();

            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/div/div[3]/form/div[7]/div/div/table/tfoot/tr/td[1]")).click();

            //Screenshot
            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            System.out.println("Fin del Test");
            Thread.sleep(1000);

            Thread.sleep(1000);
            // Si aparece un mensaje "El asegurado Presenta Cumulo"
/*        if (driver.findElement(By.xpath("//label[@wicketpath='modalWindowForm_EventSection_content_eventMessage']")).isDisplayed()){
            //Screenshot
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen6-2", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();
        }*/


        /*if (driver.findElements(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")).size() != 0){
            driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")).click();
            Thread.sleep(3000);
        }*/
        /*
        boolean present;
        try {
            driver.findElement(By.name("EventSection:content:Form:continueButton"));
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        if (present == true){
            driver.findElement(By.name("EventSection:content:Form:continueButton")).click();
            Thread.sleep(3000);
        }*/

        /*WebElement presetnaCumulo = driver.findElement(By.name("EventSection:content:Form:continueButton"));
        // Presenta Cumulo
        if(presetnaCumulo.isDisplayed()){

            presetnaCumulo.click();
            Thread.sleep(3000);
        }*/
        /*
        Thread.sleep(1000);
        *//** Espere **//*
        mensajeEspera = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera.isDisplayed()) {
            Thread.sleep(5000);
            System.out.println("Espera 2");
        }

        //Screenshot
        a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        System.out.println("Fin del Test");

        Thread.sleep(2000);

        //driver.quit();*/

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
