package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CumulosProductosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;


/**
 * Created by aazuaje on 18/08/2016.
 */
public class CumulosProductos {

    private final static Logger log = Logger.getLogger(CumulosProductos.class);

    public String nombreAutomatizacion = "Cumulos Productos";

    public void testLink(CumulosProductosBean cumulosProductosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorProducto(driver, a, nombreAutomatizacion);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BusquedaProductos(driver, a, cumulosProductosBean);


    }


    public void BusquedaProductos (WebDriver driver, Metodos a, CumulosProductosBean cumulosProductosBean) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);
            Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"products\"]")));
            producto.selectByValue(cumulosProductosBean.getProducto());

            Thread.sleep(1000);
            Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda.selectByValue(cumulosProductosBean.getMoneda());

            Thread.sleep(1000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }



}
