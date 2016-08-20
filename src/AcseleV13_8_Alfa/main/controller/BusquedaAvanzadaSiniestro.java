package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.BusquedaAvanzadaSiniestroBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 09/08/2016.
 */
public class BusquedaAvanzadaSiniestro {
    private final static Logger log = Logger.getLogger(BusquedaAvanzadaSiniestro.class);

    public String nombreAutomatizacion = "Busqueda Avanzada Siniestro";

    public void testLink(BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Busqueda de Siniestro
        m.OpeSini_MantenimientoSiniestro(driver, a, nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        //Thread.sleep(2000);

        InsertarDatos(a, driver, busquedaAvanzadaSiniestroBean); //Insertar Datos de Caja

        //Presiono el botón Buscar
        driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span")).click();
        a.changeLastWindows(driver);
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Thread.sleep(1500);

        SeleccionarSiniestro(a, driver, busquedaAvanzadaSiniestroBean); //Seleccionar Dato Siniestro
        Thread.sleep(1500);
        a.changeLastWindows(driver);
        //Se hace click en la última pantalla solicitada
        //para pasarle el control y se quede aqui.
        driver.findElement(By.xpath("/html/body/div[10]")).click();
        Thread.sleep(2000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
    }

    public void InsertarDatos(Metodos a, WebDriver driver, BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean) throws InterruptedException, IOException {

        try{
            Thread.sleep(3000);
/*            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);*/
            //Presiono el botón Buscar
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[5]/div/div/div[3]/div/span/span")).click();
            a.cambiarVentana(driver);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1500);

           //Se ingresa una fecha
            if (busquedaAvanzadaSiniestroBean.getOrdenar() != null) {
                WebElement desplegarCombo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div[3]/div/div/div[3]/div/input"));
                desplegarCombo.click();

                Thread.sleep(1000);
                WebElement seleccionarValorOrden = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td/span"));
                seleccionarValorOrden.click();
                Thread.sleep(1000);

            }
           if (busquedaAvanzadaSiniestroBean.getEmision() != null) {
               WebElement emision = driver.findElement(By.xpath("//*[@id=\"FechaEmision\"]/input"));
               emision.sendKeys(busquedaAvanzadaSiniestroBean.getEmision());
               Thread.sleep(1000);
           }

/*            if (buscarSiniestroSimpleBean.getNumPoliza() != null) {
                Thread.sleep(3000);
                WebElement numPoliza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[8]/input"));
                numPoliza.sendKeys(buscarSiniestroSimpleBean.getNumPoliza());
            }
            if (buscarSiniestroSimpleBean.getOcurrencia() != null) {
                Thread.sleep(3000);
                Select ocurrencia = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[3]/div/input")));
                ocurrencia.selectByValue(buscarSiniestroSimpleBean.getOcurrencia());
            }
            if (buscarSiniestroSimpleBean.getProducto() != null) {

                //Thread.sleep(3000);
                WebElement desplegarComboProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[11]/div/div"));
                desplegarComboProducto.click();
                Thread.sleep(1000);

                WebElement seleccionarValorProducto = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td"));

                Thread.sleep(1000);
                seleccionarValorProducto.click();
                Thread.sleep(1000);

            }
            Thread.sleep(2000);

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();*/

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Buscar Siniestro - " + e);
        }

    }

    public void SeleccionarSiniestro(Metodos a, WebDriver driver, BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean) throws InterruptedException, IOException {
        try{
            Thread.sleep(2000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Seleccionar Siniestro
            if (busquedaAvanzadaSiniestroBean.getOrdenar() != null) {
                WebElement Siniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[3]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
                Siniestro.click();
            }
            Thread.sleep(500);

            //Screenshot
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            //Seleccionar botón de Consulta de Siniestro
            driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[5]/div/div/div[1]/div/span/span")).click();


        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Buscar Siniestro - " + e);
        }

    }
}
