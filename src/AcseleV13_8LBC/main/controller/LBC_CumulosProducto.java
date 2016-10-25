package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CumulosProductolbcBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 17/10/2016.
 */
public class LBC_CumulosProducto {
    private final static Logger log = Logger.getLogger(LBC_CumulosProducto.class);

    public String nombreAutomatizacion = "Cumulos Productos";

    public void testLink(LBC_CumulosProductolbcBean lbcCumulosProductolbcBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        LBC_Metodos a = new LBC_Metodos();
        LBC_MenuOperaciones m = new LBC_MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(8000);

        m.Cumulos_CumulosPorProducto(driver, a, nombreAutomatizacion,i);
        Thread.sleep(4000);
        a.cambiarVentana(driver);
        BusquedaProductos(driver, a, lbcCumulosProductolbcBean,i);


    }


    public void BusquedaProductos (WebDriver driver, LBC_Metodos a, LBC_CumulosProductolbcBean lbcCumulosProductolbcBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);
            Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"products\"]")));
            producto.selectByValue(lbcCumulosProductolbcBean.getProducto());

            Thread.sleep(1000);
            Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda.selectByValue(lbcCumulosProductolbcBean.getMoneda());

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }




}
