package main.controller;

import beans.BusquedaPolizaAvanzadaBean;
import beans.EstadoCuentasBean;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 27/05/2016.
 */
public class EstadoCuentas {

    String nombreAutomatizacion ="Estado de Cuentas";
    //Pliza a buscar
    //String nPoliza = "EA00222";
    //String fechaEm = "17-12-2015";


    public void testLink(EstadoCuentasBean estadoCuentasBean)throws Exception {

        Metodos a= new Metodos();   //implementando metodos.
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]"));// Consultas
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[4]/div[2]"));// Estado de Cuentas
        menu1.click();
        a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
        menu2.click();
        a.cambiarVentana(driver); // Cambiar de ventana

        EdoCuentas(a, driver, estadoCuentasBean);
    }

    public void EdoCuentas(Metodos a, WebDriver driver, EstadoCuentasBean estadoCuentasBean) throws InterruptedException, IOException {

        Thread.sleep(3000);

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        // Select del Tipo de Tercero
        //Select tipoTercero = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
        Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='WicketpathElemento']")));
        tipoTercero.selectByValue(estadoCuentasBean.getTipoTercero());
        Thread.sleep(12000);

        // Num Documento Identificacion
//        WebElement numDocIdent = driver.findElement(By.name("DocumentoIdentidad"));
        WebElement numDocIdent = driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']"));
        numDocIdent.sendKeys(estadoCuentasBean.getNumDocIdentificacion());

        // Primer Nombre
//        WebElement priNombre = driver.findElement(By.name("Nombre"));
        WebElement priNombre = driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']"));
        priNombre.sendKeys(estadoCuentasBean.getPrimerNombre());

        // Primer Apellido
//        WebElement priApellido = driver.findElement(By.name("Apellido"));
        WebElement priApellido = driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']"));
        priApellido.sendKeys(estadoCuentasBean.getPrimerApellido());
        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);
        Thread.sleep(1000);

        // Boton Buscar
//        driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]")).click();
        driver.findElement(By.xpath("//input[@wicketpath='WicketpathElemento']")).click();
        Thread.sleep(7000);

        /***/
        // Seleccionar el Tercero Buscado
//        driver.findElement(By.name("ThirdPartyID")).click();
        driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']")).click();
        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Thread.sleep(1000);
        // Boton Aceptar
//        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='WicketpathElemento']")).click();
        Thread.sleep(5000);

        /***/
        //Borrar Fecha inicial y final
//        driver.findElement(By.name("startdateShow")).clear();
        driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']")).clear();
//        driver.findElement(By.name("enddateShow")).clear();
        driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']")).clear();

        // Moneda
//        Select moneda = new Select(driver.findElement(By.name("currencyID")));
        Select moneda = new Select(driver.findElement(By.name("//select[@wicketpath='WicketpathElemento']")));
        moneda.selectByValue(estadoCuentasBean.getMoneda());

        // Producto
//        Select producto = new Select(driver.findElement(By.name("productID")));
        Select producto = new Select(driver.findElement(By.name("//select[@wicketpath='WicketpathElemento']")));
        producto.selectByValue(estadoCuentasBean.getProducto());

        // Num Poliza
//        WebElement numeroPolza = driver.findElement(By.name("policyId"));
        WebElement numeroPolza = driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']"));
        numeroPolza.sendKeys(estadoCuentasBean.getNumPoliza());

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        Thread.sleep(1000);

        // Boton Enviar
//        driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]")).click();
        driver.findElement(By.xpath("//input[@wicketpath='WicketpathElemento']")).click();
        Thread.sleep(5000);


        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);

        System.out.println("Fin del Test");

    }
}
