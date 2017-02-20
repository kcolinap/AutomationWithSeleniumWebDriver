package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CumuloProductoBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 12/01/2017.
 */
public class INTER_CumuloProduto {

    private final static Logger log = Logger.getLogger(INTER_CumuloProductoBean.class);

    public String nombreAutomatizacion = "INTER Cumulos Productos";
    private WebDriver driver;

    public void testLink(INTER_CumuloProductoBean inter_cumuloProductoBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            //implementando clase de metodos
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(3000);

            m.Cumulos_CumulosPorProducto(driver, nombreAutomatizacion, i, folderName, 2);
            Thread.sleep(8000);
            a.cambiarVentana(driver);
            BusquedaProductos(a, inter_cumuloProductoBean, i, folderName, 3, 4);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }


    public void BusquedaProductos (Metodos a, INTER_CumuloProductoBean inter_cumuloProductoBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try{
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"products\"]")));
            producto.selectByValue(inter_cumuloProductoBean.getProducto());

            Thread.sleep(3000);
            Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda.selectByValue(inter_cumuloProductoBean.getMoneda());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


}
