package AcseleV13_8LBC.main.controller;
import AcseleV13_8LBC.beans.ConsultaAvanzadaPolizaBean;
import AcseleV13_8LBC.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
/**
 * Created by aazuaje on 11/10/2016.
 */
public class ConsultaAvanzadaPoliza {

    private final static Logger log = Logger.getLogger(ConsultaAvanzadaPoliza.class);

    public String nombreAutomatizacion ="Consulta Poliza Avanzada";
    //Poliza a buscar
    //String nPoliza = "EA00222";
    //String fechaEm = "17-12-2015";


    public void testLink(ConsultaAvanzadaPolizaBean consultaAvanzadaPolizaBean, int i)throws Exception {

        // Instanciando Clases
        MetodosLBC a= new MetodosLBC();
        MenuOperaciones menuOperaciones = new MenuOperaciones();


        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(5000);

        //Entrando en Menu
        menuOperaciones.OpePol_CotizacionSuscripcionMantenimientoPolizas(a, driver, nombreAutomatizacion, 2);
        Thread.sleep(2000);
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarPolizaAvanzada(a, driver, consultaAvanzadaPolizaBean, i);
    }

    public void BuscarPolizaAvanzada(MetodosLBC a, WebDriver driver, ConsultaAvanzadaPolizaBean consultaAvanzadaPolizaBean, int i) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']

        Thread.sleep(2000);

        //Screenshot
        a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Boton Busqueda Avanzada
        driver.findElement(By.xpath("//a[@wicketpath='ConsultPolicy_searchForm_detailSearchLink']")).click();
        Thread.sleep(3000);

        /** Inicio Formulario **/

        if (consultaAvanzadaPolizaBean.getProducto() != null){
            Select tipoProducto = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_productsList']")));

            tipoProducto.selectByValue(consultaAvanzadaPolizaBean.getProducto());
            Thread.sleep(2000);
        }


        // Estado del ciclo de vida
        if (consultaAvanzadaPolizaBean.getEdoCicloVida() != null){
            Select edoCicloVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_stateProductsList']")));
            edoCicloVida.selectByValue(consultaAvanzadaPolizaBean.getEdoCicloVida());
            Thread.sleep(1000);
        }
        // Fecha de Emision
        if (consultaAvanzadaPolizaBean.getFechaEmision() != null){
            WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_2_fila_fieldDate']"));
            fechaEmision.sendKeys(consultaAvanzadaPolizaBean.getFechaEmision());
            Thread.sleep(1000);
        }

        // Num Poliza
        if (consultaAvanzadaPolizaBean.getNumPoliza() != null){
            WebElement numeroPolza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_1_fila_field']"));
            numeroPolza.sendKeys(consultaAvanzadaPolizaBean.getNumPoliza());
            Thread.sleep(1000);
        }

        //Screenshot
        a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();


        // Boton Buscar
        driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']")).click();
        Thread.sleep(6000);

        //Seleccion poliza
        driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

        //Screenshot
        Thread.sleep(2000);
        a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
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

        Thread.sleep(1000);
        // Si aparece un mensaje "El asegurado Presenta Cumulo"
        if (driver.findElement(By.xpath("//label[@wicketpath='modalWindowForm_EventSection_content_eventMessage']")).isDisplayed()){
            //Screenshot
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen6-2", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();
        }


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

//        WebElement presetnaCumulo = driver.findElement(By.name("EventSection:content:Form:continueButton"));
//        // Presenta Cumulo
//        if(presetnaCumulo.isDisplayed()){
//
//            presetnaCumulo.click();
//            Thread.sleep(3000);
//        }

        Thread.sleep(1000);
        /** Espere **/
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

        //driver.quit();

    }

    public void rutasXpath(WebDriver driver){
        /** Poliza **/
        // Producto
        driver.findElement(By.xpath("//*[@id=\"id21\"]"));
        driver.findElement(By.name(""));
        // value "VidaDeudoresAvVillas"

        // Estado del ciclo de vida
        driver.findElement(By.xpath("//*[@id=\"id22\"]"));
        // Value = "129538" Anulada
        // Value = "128738" Cancelara
        // Value = "94298" Cotizado
        // Value = "129438" Emitida
        // Value = "129238" Excluido
        // Value = "128438" Inicial

        // Fecha Emision
        driver.findElement(By.xpath("//*[@id=\"_FechaEmision\"]"));
        driver.findElement(By.name("templatePolicy:repeaterPanel1:2:fila:fieldDate"));

        // Num Poliza
        driver.findElement(By.xpath("//*[@id=\"id14f\"]"));
        driver.findElement(By.name("templatePolicy:repeaterPanel2:1:fila:field"));

        driver.findElement(By.xpath("//*[@id=\"id16c\"]"));

        // Tasa
        driver.findElement(By.xpath("//*[@id=\"id19f\"]"));
        driver.findElement(By.name("templatePolicy:repeaterPanel1:7:fila:field"));

        // Tipo Tasa
        driver.findElement(By.xpath("//*[@id=\"id1b1\"]"));
        driver.findElement(By.name("templatePolicy:repeaterPanel2:7:fila:repeaterSelect:1:field"));
        // Value = "24650717" Por 1000
        // Value = "24650617" Por 100

        /** Tercero **/
        // Tipo Tercero
        driver.findElement(By.xpath("//*[@id=\"id40\"]"));
        driver.findElement(By.id("id40"));
        //Value = "PersonaNatural"
        //Value = "PersonaJuridica"

        // Tipo de Documento Identificación
        driver.findElement(By.xpath("//*[@id=\"id1fa\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field"));
        // Value = "38942717" Tarjeta de identidad
        // Value = "38943117" NIT
        // Value = "38942617" Registro civil de nacimiento
        // Value = "38942817" Cédula de ciudadanía
        // Value = "38943317" Tipo de documento extranjero
        // Value = "38942917" Tarjeta de extranjería
        // Value = "38943017" Cédula de extranjería
        // Value = "38943217" Pasaporte

        // Número de Documento identificación
        driver.findElement(By.xpath("//*[@id=\"id1fd\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));

        // Pasaporte
        driver.findElement(By.xpath("//*[@id=\"id226\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel2:1:fila:field"));

        // Primer nombre
        driver.findElement(By.xpath("//*[@id=\"id200\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));

        // Primer Apellido
        driver.findElement(By.xpath("//*[@id=\"id206\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));

        // Telefono fijo
        driver.findElement(By.xpath("//*[@id=\"id22c\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel2:3:fila:field"));

        //email1
        driver.findElement(By.xpath("//*[@id=\"id211\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel1:9:fila:field"));

        // Telefono Celular
        driver.findElement(By.xpath("//*[@id=\"ide8\"]"));
        driver.findElement(By.name("templateThird:repeaterPanel2:9:fila:field"));

        driver.findElement(By.xpath(""));
        driver.findElement(By.name(""));

        driver.findElement(By.xpath(""));
        driver.findElement(By.name(""));


    }
}


