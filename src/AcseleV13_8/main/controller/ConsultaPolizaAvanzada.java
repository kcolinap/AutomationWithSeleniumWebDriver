package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ConsultaPolizaAvanzadaBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 18/05/2016.
 */
public class ConsultaPolizaAvanzada {

    private final static Logger log = Logger.getLogger(ConsultaPolizaAvanzada.class);

    public String nombreAutomatizacion ="Consulta Poliza Avanzada";
    //Pliza a buscar
    //String nPoliza = "EA00222";
    //String fechaEm = "17-12-2015";


    public void testLink(ConsultaPolizaAvanzadaBean consultaPolizaAvanzadaBean, int i)throws Exception {

        // Instanciando Clases
        Metodos a= new Metodos();
        MenuOperaciones menuOperaciones = new MenuOperaciones();


        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(5000);

        //Entrando en Menu
        menuOperaciones.OpePol_CotizacionSuscripcionMantenimientoPolizas(a, driver, nombreAutomatizacion, 2);
        Thread.sleep(2000);
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarPolizaSimple(a, driver, consultaPolizaAvanzadaBean, i);
    }

    public void BuscarPolizaSimple(Metodos a, WebDriver driver, ConsultaPolizaAvanzadaBean consultaPolizaAvanzadaBean, int i) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']

        Thread.sleep(2000);

        //Screenshot
        a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Boton Busqueda Avanzada
        driver.findElement(By.xpath("//a[@wicketpath='ConsultPolicy_searchForm_detailSearchLink']")).click();
        Thread.sleep(3000);

        /** Inicio Formulario **/
        // Select del Producto
        if (consultaPolizaAvanzadaBean.getProducto() != null){
            Select tipoProducto = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_productsList']")));
            //tipoProducto.selectByValue("VidaDeudoresAvVillas");
            tipoProducto.selectByValue(consultaPolizaAvanzadaBean.getProducto());
            Thread.sleep(2000);
        }

        // Estado del ciclo de vida
        if (consultaPolizaAvanzadaBean.getEdoCicloVida() != null){
            Select edoCicloVida = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_stateProductsList']")));
            edoCicloVida.selectByValue(consultaPolizaAvanzadaBean.getEdoCicloVida());
            Thread.sleep(1000);
        }
        // Fecha de Emision
        if (consultaPolizaAvanzadaBean.getFechaEmision() != null){
            WebElement fechaEmision = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel1_2_fila_fieldDate']"));
            fechaEmision.sendKeys(consultaPolizaAvanzadaBean.getFechaEmision());
            Thread.sleep(1000);
        }

        // Num Poliza
        if (consultaPolizaAvanzadaBean.getNumPoliza() != null){
            WebElement numeroPolza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templatePolicy_repeaterPanel2_1_fila_field']"));
            numeroPolza.sendKeys(consultaPolizaAvanzadaBean.getNumPoliza());
            Thread.sleep(1000);
        }

        //Screenshot
        a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Tipo Tercero
        if (consultaPolizaAvanzadaBean.getTipoTercero() != null){
            Select tipoTer = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_thirdPartyList']")));
            tipoTer.selectByValue(consultaPolizaAvanzadaBean.getTipoTercero());
            Thread.sleep(4000);
        }

        // Tipo de Documento Identificación
        if (consultaPolizaAvanzadaBean.getTipoDocIdent() != null){
            Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDocId.selectByValue(consultaPolizaAvanzadaBean.getTipoDocIdent());
            Thread.sleep(1000);
        }

        // Número de Documento identificación
        if (consultaPolizaAvanzadaBean.getNumDocIdent() != null){
            //driver.findElement(By.xpath("//*[@id=\"id1fd\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel1_2_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getNumDocIdent());
            Thread.sleep(1000);
        }

        // Pasaporte
        if (consultaPolizaAvanzadaBean.getPasaporte() != null){
            //driver.findElement(By.xpath("//*[@id=\"id226\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel2_1_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getPasaporte());
            Thread.sleep(1000);
        }

        // Primer Nombre
        if (consultaPolizaAvanzadaBean.getPrimerNombre() != null){
            //driver.findElement(By.xpath("//*[@id=\"id200\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel1_3_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getPrimerNombre());
        }

        // Primer Apellido
        if (consultaPolizaAvanzadaBean.getPrimerApellido() != null){
            //driver.findElement(By.xpath("//*[@id=\"id206\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel1_5_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getPrimerApellido());
        }

        // Email1
        if (consultaPolizaAvanzadaBean.getEmail1() != null){
            //driver.findElement(By.xpath("//*[@id=\"id211\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel1_9_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getEmail1());
        }

        // Telefono Fijo
        if (consultaPolizaAvanzadaBean.getTelFijo() != null){
            //driver.findElement(By.xpath("//*[@id=\"id22c\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel2_3_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getTelFijo());
        }

        //Telefono Celular
        if (consultaPolizaAvanzadaBean.getTelCelular() != null){
            //driver.findElement(By.xpath("//*[@id=\"ide8\"]"));
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_templateThird_repeaterPanel2_9_fila_field']")).sendKeys(consultaPolizaAvanzadaBean.getTelCelular());
        }

        //Screenshot
        Thread.sleep(2000);
        a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
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
