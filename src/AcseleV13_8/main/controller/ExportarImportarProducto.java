package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ExportarImportarProductoBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by kzambrano on 17/08/2016.
 */
public class ExportarImportarProducto {

    private final static Logger log = Logger.getLogger(ExportarImportarProducto.class);

    public String nombreAutomatizacion ="Exportar Importar Producto";

    public void testLink (ExportarImportarProductoBean exportarImportarProductoBean, int i) throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuConfiguracion m = new MenuConfiguracion();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.MantenimientoProducto(a, driver, nombreAutomatizacion);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        BuscarSiniestro (driver, a, exportarImportarProductoBean);

        Thread.sleep(3000);


    }

    public void BuscarSiniestro (WebDriver driver, Metodos a, ExportarImportarProductoBean exportarImportarProductoBean) throws IOException, InterruptedException{

        try {

            Thread.sleep(2000);
            WebElement product = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div"));
            product.click();
            Thread.sleep(1000);
            WebElement producto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li/div/a/span"));
            Thread.sleep(1000);
            producto.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement btnMigracion = driver.findElement(By.xpath("//*[@id=\"ext-gen146\"]"));
            btnMigracion.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen5",nombreAutomatizacion);
            Thread.sleep(2000);


            WebElement exportarConf = driver.findElement(By.xpath("/html/body/div[5]/ul/li[7]/a"));
            exportarConf.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen6",nombreAutomatizacion);
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen7", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);



    }

}

}
