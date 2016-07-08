package main.controller;

import beans.BusquedaPolizaAvanzadaBean;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by agil on 18/05/2016.
 */
public class ConsultaPolizaAvanzada {

    String nombreAutomatizacion ="Consulta Poliza Avanzada";
    //Pliza a buscar
    //String nPoliza = "EA00222";
    //String fechaEm = "17-12-2015";


    public void testLink(BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean, int i)throws Exception {

        Metodos a= new Metodos();   //implementando metodos.
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[2]"));// Operaciones polizas
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[6]/div[6]"));// Cotización-Suscripción-Mantenimiento de Pólizas
        menu1.click();
        menu2.click();
        a.ScreenShotPool(driver, i, "screen2", nombreAutomatizacion); //screenshot2
        Toolkit.getDefaultToolkit().beep();
        menu3.click();
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarPolizaSimple(a, driver, busquedaPolizaAvanzadaBean, i);
    }

    public void BuscarPolizaSimple(Metodos a, WebDriver driver, BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean, int i) throws InterruptedException, IOException {

        Thread.sleep(2000);

        //Screenshot
        a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Boton Busqueda Avanzada
        driver.findElement(By.xpath("//*[@id=\"idb\"]/span")).click();
        Thread.sleep(3000);

        /** Inicio Formulario **/
        // Select del Producto
        if (busquedaPolizaAvanzadaBean.getProducto() != null){
            Select tipoProducto = new Select(driver.findElement(By.xpath("//*[@id=\"id21\"]")));
            //tipoProducto.selectByValue("VidaDeudoresAvVillas");
            tipoProducto.selectByValue(busquedaPolizaAvanzadaBean.getProducto());
            Thread.sleep(2000);
        }

        // Estado del ciclo de vida
        if (busquedaPolizaAvanzadaBean.getEdoCicloVida() != null){
            Select edoCicloVida = new Select(driver.findElement(By.xpath("//*[@id=\"id22\"]")));
            edoCicloVida.selectByValue(busquedaPolizaAvanzadaBean.getEdoCicloVida());
            Thread.sleep(1000);
        }
        // Fecha de Emision
        if (busquedaPolizaAvanzadaBean.getFechaEmision() != null){
            WebElement fechaEmision = driver.findElement(By.name("templatePolicy:repeaterPanel1:2:fila:fieldDate"));
            fechaEmision.sendKeys(busquedaPolizaAvanzadaBean.getFechaEmision());
            Thread.sleep(1000);
        }

        // Num Poliza
        if (busquedaPolizaAvanzadaBean.getNumPoliza() != null){
            WebElement numeroPolza = driver.findElement(By.name("templatePolicy:repeaterPanel2:1:fila:field"));
            numeroPolza.sendKeys(busquedaPolizaAvanzadaBean.getNumPoliza());
            Thread.sleep(1000);
        }

        //Screenshot
        a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Tipo Tercero
        if (busquedaPolizaAvanzadaBean.getTipoTercero() != null){
            Select tipoTer = new Select(driver.findElement(By.xpath("//*[@id=\"id40\"]")));
            tipoTer.selectByValue(busquedaPolizaAvanzadaBean.getTipoTercero());
            Thread.sleep(4000);
        }

        // Tipo de Documento Identificación
        if (busquedaPolizaAvanzadaBean.getTipoDocIdent() != null){
            Select tipoDocId = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDocId.selectByValue(busquedaPolizaAvanzadaBean.getTipoDocIdent());
            Thread.sleep(1000);
        }

        // Número de Documento identificación
        if (busquedaPolizaAvanzadaBean.getNumDocIdent() != null){
            //driver.findElement(By.xpath("//*[@id=\"id1fd\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getNumDocIdent());
            Thread.sleep(1000);
        }

        // Pasaporte
        if (busquedaPolizaAvanzadaBean.getPasaporte() != null){
            //driver.findElement(By.xpath("//*[@id=\"id226\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel2:1:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getPasaporte());
            Thread.sleep(1000);
        }

        // Primer Nombre
        if (busquedaPolizaAvanzadaBean.getPrimerNombre() != null){
            //driver.findElement(By.xpath("//*[@id=\"id200\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getPrimerNombre());
        }

        // Primer Apellido
        if (busquedaPolizaAvanzadaBean.getPrimerApellido() != null){
            //driver.findElement(By.xpath("//*[@id=\"id206\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getPrimerApellido());
        }

        // Email1
        if (busquedaPolizaAvanzadaBean.getEmail1() != null){
            //driver.findElement(By.xpath("//*[@id=\"id211\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel1:9:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getEmail1());
        }

        // Telefono Fijo
        if (busquedaPolizaAvanzadaBean.getTelFijo() != null){
            //driver.findElement(By.xpath("//*[@id=\"id22c\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel2:3:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getTelFijo());
        }

        //Telefono Celular
        if (busquedaPolizaAvanzadaBean.getTelCelular() != null){
            //driver.findElement(By.xpath("//*[@id=\"ide8\"]"));
            driver.findElement(By.name("templateThird:repeaterPanel2:9:fila:field")).sendKeys(busquedaPolizaAvanzadaBean.getTelCelular());
        }

        //Screenshot
        Thread.sleep(2000);
        a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Boton Buscar
        driver.findElement(By.name("searchButton")).click();
        Thread.sleep(6000);

        //Seleccion poliza
        driver.findElement(By.name("ConsultPolicy:ResultSearchSimplePolicy:groupPolicies")).click();

        //Screenshot
        Thread.sleep(2000);
        a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Boton Consultar
        driver.findElement(By.name("container:ConsultPolicyButton")).click();
        Thread.sleep(3000);


        if (driver.findElements(By.name("EventSection:content:Form:continueButton")).size() != 0){
            driver.findElement(By.name("EventSection:content:Form:continueButton")).click();
            Thread.sleep(3000);
        }
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

        Thread.sleep(3000);
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
