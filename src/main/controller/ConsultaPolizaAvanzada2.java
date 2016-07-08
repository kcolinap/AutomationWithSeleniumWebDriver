package main.controller;

import beans.BusquedaPolizaAvanzadaBean;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 18/05/2016.
 */
public class ConsultaPolizaAvanzada2 {

    String nombreAutomatizacion ="Consulta Poliza Avanzada Pool";
    //Pliza a buscar
    //String nPoliza = "EA00222";
    //String fechaEm = "17-12-2015";


    public void testLink(WebDriver driver, BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean, int i)throws Exception {

        Metodos2 a= new Metodos2();   //implementando metodos.
       /* WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion); //validando sesion.
        Thread.sleep(3000);*/

        IngresarMenu(a, driver, i);
        BuscarPolizaSimple(a, driver, busquedaPolizaAvanzadaBean, i);
    }

    public void IngresarMenu(Metodos2 a, WebDriver driver, int i) throws IOException, InterruptedException {
        //Entrando en Menu
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[2]"));// Operaciones polizas
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[6]/div[6]"));// Cotización-Suscripción-Mantenimiento de Pólizas
        menu1.click();
        menu2.click();
        a.ScreenShotPool(driver, i, "screen2", nombreAutomatizacion); //screenshot2
        menu3.click();
        a.cambiarVentana(driver); // Cambiar de ventana
    }

    public void BuscarPolizaSimple(Metodos2 a, WebDriver driver, BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean, int i) throws InterruptedException, IOException {

        Thread.sleep(2000);

        //Screenshot
        a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);

        if (i == 0) {
            // Boton Busqueda Avanzada
            driver.findElement(By.xpath("//*[@id=\"idb\"]/span")).click();
            Thread.sleep(3000);

            /***/
            driver.close();
            Thread.sleep(3000);
            a.regresarVentana(driver);
        }
        else if (i ==1){
            IngresarMenu(a, driver, i);
            Thread.sleep(3000);
            a.cambiarVentana(driver); // Cambiar de ventana
            Thread.sleep(3000);

            // Boton Busqueda Avanzada
            driver.findElement(By.xpath("//*[@id=\"id14c\"]/span")).click();
            Thread.sleep(3000);

            /***/
            driver.close();
            Thread.sleep(3000);
            a.regresarVentana(driver);
        }
        else if (i ==2){
            IngresarMenu(a, driver, i);
            Thread.sleep(3000);
            a.cambiarVentana(driver); // Cambiar de ventana
            Thread.sleep(3000);

            // Boton Busqueda Avanzada
            driver.findElement(By.xpath("//*[@id=\"id14c\"]/span")).click();
            Thread.sleep(3000);

            /***/
            driver.close();
            Thread.sleep(3000);
            a.regresarVentana(driver);
        }
        else if (i ==3){
            IngresarMenu(a, driver, i);
            Thread.sleep(3000);
            a.cambiarVentana(driver); // Cambiar de ventana
            Thread.sleep(3000);

            // Boton Busqueda Avanzada
            driver.findElement(By.xpath("//*[@id=\"id14c\"]/span")).click();
            Thread.sleep(3000);

            /***/
            driver.close();
            Thread.sleep(3000);
            a.regresarVentana(driver);
        }


        // Select del Producto
        Select tipoProducto = new Select(driver.findElement(By.xpath("//*[@id=\"id21\"]")));
        //tipoProducto.selectByValue("VidaDeudoresAvVillas");
        tipoProducto.selectByValue(busquedaPolizaAvanzadaBean.getProducto());

        //Fecha de Emision
        WebElement fechaEmision = driver.findElement(By.name("templatePolicy:repeaterPanel1:2:fila:fieldDate"));
        fechaEmision.sendKeys(busquedaPolizaAvanzadaBean.getFechaEmision());

        // Num Poliza
        WebElement numeroPolza = driver.findElement(By.name("templatePolicy:repeaterPanel2:1:fila:field"));
        numeroPolza.sendKeys(busquedaPolizaAvanzadaBean.getNumPoliza());
        Thread.sleep(5000);

        //Fecha de Emision
        fechaEmision = driver.findElement(By.name("templatePolicy:repeaterPanel1:2:fila:fieldDate"));
        fechaEmision.sendKeys(busquedaPolizaAvanzadaBean.getFechaEmision());

        // Num Poliza
        numeroPolza = driver.findElement(By.name("templatePolicy:repeaterPanel2:1:fila:field"));
        numeroPolza.sendKeys(busquedaPolizaAvanzadaBean.getNumPoliza());
        Thread.sleep(5000);

        //Screenshot
        a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

        // Boton Buscar
        driver.findElement(By.name("searchButton")).click();
        Thread.sleep(4000);

        //Seleccion poliza
        driver.findElement(By.name("ConsultPolicy:ResultSearchSimplePolicy:groupPolicies")).click();

        //Screenshot
        a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

        // Boton Consultar
        driver.findElement(By.name("container:ConsultPolicyButton")).click();

        Thread.sleep(3000);
        //Screenshot
        a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

        System.out.println("Fin del Test");
        Thread.sleep(3000);
        driver.close();

        Thread.sleep(3000);
        a.regresarVentana(driver);

        /*****/
        //Entrando en Menu
/*        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[2]"));// Operaciones polizas
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[6]/div[6]"));// Cotización-Suscripción-Mantenimiento de Pólizas
        menu1.click();
        menu2.click();
        a.ScreenShotPool(driver, i, "screen2", nombreAutomatizacion); //screenshot2
        menu3.click();
        Thread.sleep(3000);
        a.cambiarVentana(driver); // Cambiar de ventana
        Thread.sleep(3000);
        // Boton Busqueda Avanzada
        driver.findElement(By.xpath("//*[@id=\"id14c\"]/span")).click();
        Thread.sleep(3000);
*/
    }
}
