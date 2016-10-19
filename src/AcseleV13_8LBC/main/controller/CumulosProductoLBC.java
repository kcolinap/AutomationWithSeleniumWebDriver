package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.CumulosProductoLBCBean;
import AcseleV13_8LBC.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 17/10/2016.
 */
public class CumulosProductoLBC {
    private final static Logger log = Logger.getLogger(CumulosProductoLBC.class);

    public String nombreAutomatizacion = "Cumulos Productos";

    public void testLink(CumulosProductoLBCBean cumulosProductoLBCBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        MetodosLBC a = new MetodosLBC();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorProducto(driver, a, nombreAutomatizacion,i);
        Thread.sleep(4000);
        a.cambiarVentana(driver);
        BusquedaProductos(driver, a, cumulosProductoLBCBean,i);


    }


    public void BusquedaProductos (WebDriver driver, MetodosLBC a, CumulosProductoLBCBean cumulosProductoLBCBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);
            Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"products\"]")));
            producto.selectByValue(cumulosProductoLBCBean.getProducto());

            Thread.sleep(1000);
            Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda.selectByValue(cumulosProductoLBCBean.getMoneda());

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }




}
