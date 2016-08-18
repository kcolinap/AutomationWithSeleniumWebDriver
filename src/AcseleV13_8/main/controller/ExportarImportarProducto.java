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

        ExportarProducto(driver, a, exportarImportarProductoBean);

        Thread.sleep(3000);

        ImportarProducto (driver, a,exportarImportarProductoBean);




    }

    public void ExportarProducto (WebDriver driver, Metodos a, ExportarImportarProductoBean exportarImportarProductoBean) throws IOException, InterruptedException{

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
            Thread.sleep(4000);
            a.ScreenShot(driver,"screen7", nombreAutomatizacion);
            Thread.sleep(2000);
            WebElement cerrarExport = driver.findElement(By.xpath("/html/body/div[9]/div[1]/div/div/div/div"));
            cerrarExport.click();



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

         }

    }

    public void ImportarProducto (WebDriver driver, Metodos a, ExportarImportarProductoBean exportarImportarProductoBean) throws IOException, InterruptedException{

        try {

            Thread.sleep(2000);
            WebElement btnMigracion = driver.findElement(By.xpath("//*[@id=\"ext-gen146\"]"));
            btnMigracion.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen8",nombreAutomatizacion);
            Thread.sleep(2000);


            WebElement importarConf = driver.findElement(By.xpath("/html/body/div[5]/ul/li[9]/a"));
            importarConf.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen9",nombreAutomatizacion);
            Thread.sleep(2000);

        /*    WebElement ruta = driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[1]/div/div/div/div/div/div/div[1]/div/form/table/tbody[2]/tr[2]/td[1]/label"));

            ruta.click();
            Thread.sleep(1000);

*/
            WebElement archivo = driver.findElement(By.xpath("//*[@id=\"isc_7\"]"));
            Thread.sleep(1000);
      //      archivo.sendKeys("\\Qa32\\c$\\AcseleTests\\Export\\CO-ExportedProductTool-VidaDeudoresAvVillas-20160818094215PRUEBA.xml");
            archivo.sendKeys("//Qa32//c$//AcseleTests//Export//CO-ExportedProductTool-VidaDeudoresAvVillas-20160818094215PRUEBA.xml");
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion);
            Thread.sleep(1000);



            WebElement btncargar = driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td"));
            btncargar.click();
            Thread.sleep(8000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement nombre = driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[7]/td/b/a"));
            nombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);
            Thread.sleep(2000);

            WebElement btnX = driver.findElement(By.xpath("//*[@id=\"resizablepanel\"]/a"));
            btnX.click();
            Thread.sleep(1000);

            WebElement btnCerrar = driver.findElement(By.xpath("//*[@id=\"idb_04020140104_result_01\"]"));
            Thread.sleep(1000);
            btnCerrar.click();
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion);










        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

}
