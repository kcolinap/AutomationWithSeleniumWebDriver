package AcseleV13_8_Rimac.main.controller;

import AcseleV13_8_Rimac.beans.Rimac_ExportProductoBean;
import AcseleV13_8_Rimac.main.controller.Rimac_Menu.Rimac_MenuConfiguracion;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Created by agil on 20/03/2017.
 */
public class Rimac_ExportProducto {

    private final static Logger log = Logger.getLogger(Rimac_ImportProducto.class);

    public String nombreAutomatizacion = "Rimac Export Producto";
    private WebDriver driver;

    public void testLink(Rimac_ExportProductoBean bean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Rimac_MenuConfiguracion menuConfiguracion = new Rimac_MenuConfiguracion();

            driver = a.entrarPagina(a.UrlRimac());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            menuConfiguracion.NuevoMantenimientoProducto(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Importar el producto */

            Thread.sleep(3000);
            //interAsociarCajaConCajero.AsociarCajaConCajero(a, driver, interAsociarCajaCajeroBean, nombreAutomatizacion, i, folderName, 3, 4, 5, 6);
            seleccionarProducto(bean, a, i, folderName, 3, 4, 5);

            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                //driver.quit();
            }
        }
    }

    public void seleccionarProducto(Rimac_ExportProductoBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            Actions action = new Actions(driver);

            Thread.sleep(4000);

            for(int j = 1; i < 150; j++){
                WebElement producto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li[" + j + "]/div/a/span"));
                if (producto.getText().equals(bean.getProducto())) {
                    producto.click();
                    //System.out.println("----> " + j);
                    break;
                }
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnMigracion = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[1]/tbody/tr/td[1]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em"));
            btnMigracion.click();

            //WebElement exportarDatosConfig = driver.findElement(By.xpath("/html/body/div[5]/ul/li[7]/a"));
            WebElement exportarDatosConfig = driver.findElement(By.xpath("/html/body/div[5]/ul/li[11]"));
            action.moveToElement(exportarDatosConfig).build().perform();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            exportarDatosConfig.click();

            Thread.sleep(10000);
            // Ruta de migracion = \\192.168.1.54\compartida_qa\test\RIMAC\entries\migration

            WebElement productoExportado = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/div/div/div/div/div/div"));
            System.out.println("Ruta del export: \n-------->\n" + productoExportado.getText() + "\n<--------");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
