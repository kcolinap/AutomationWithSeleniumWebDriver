package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ExportarImportarProductoBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.MantenimientoProducto(driver, nombreAutomatizacion, 3);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

     //   ExportarProducto(driver, a, exportarImportarProductoBean, i);

        Thread.sleep(3000);

        ImportarProducto (driver, a,exportarImportarProductoBean, i);




    }

    public void ExportarProducto (WebDriver driver, Metodos a, ExportarImportarProductoBean exportarImportarProductoBean, int i) throws IOException, InterruptedException{

        try {

            //selcciona el producto del product tool
            Actions action = new Actions(driver);
            Thread.sleep(2000);
            WebElement product = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div"));
            product.click();
            Thread.sleep(1000);
            WebElement producto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li/div/a/span"));
            Thread.sleep(1000);
            producto.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

            Thread.sleep(1000);

            //hace click en el boton migracion, y selecciona la opcion exportar datos de configuracion
            //una vez realizado el export cierra la ventana con la informacion de la misma.
            WebElement btnMigracion = driver.findElement(By.xpath("//*[@id=\"ext-gen146\"]"));
            btnMigracion.click();
            Thread.sleep(1000);
            WebElement exportarConf = driver.findElement(By.xpath("/html/body/div[5]/ul/li[7]/a"));
            Thread.sleep(1000);
            action.moveToElement(exportarConf).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            exportarConf.click();
            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
            Thread.sleep(3000);
            WebElement cerrarExport = driver.findElement(By.xpath("/html/body/div[9]/div[1]/div/div/div/div"));
            cerrarExport.click();



        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

         }

    }

    public void ImportarProducto (WebDriver driver, Metodos a, ExportarImportarProductoBean exportarImportarProductoBean, int i) throws IOException, InterruptedException{

        try {
/*
            //hace click en el boton migracion y selecciona la opcion importar datos de configuracion
            Actions action = new Actions(driver);
            Thread.sleep(2000);
            WebElement btnMigracion = driver.findElement(By.xpath("//*[@id=\"ext-gen146\"]"));
            btnMigracion.click();
            Thread.sleep(1000);
            WebElement importarConf = driver.findElement(By.xpath("/html/body/div[5]/ul/li[9]/a"));
            Thread.sleep(1000);
            action.moveToElement(importarConf).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);
            importarConf.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);
            Thread.sleep(2000);

             //se envia la ruta donde se encuentra ubicado el archivo que sera importado. Para más informacion sobre este proceso revisar la Vista

            WebElement archivo = driver.findElement(By.xpath("//*[@id=\"isc_7\"]"));
            Thread.sleep(1000);
            archivo.sendKeys("C:\\AcseleTests\\AutomationTestAcsele\\rutas\\export\\CO-ExportedProductTool-VidaDeudoresAvVillas-20160908090919Prueba.xml");
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);
            Thread.sleep(1000);



            WebElement btncargar = driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[1]/div/div/div/div/div/div/div[2]/div/table/tbody/tr/td"));
            btncargar.click();
            Thread.sleep(8000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);
            Thread.sleep(1000);

            //una vez culminado el proceso de import se hace click en el link que contiene la informacion del producto
            //se cierra el detalle y luego se hace click en el boton cerrar para volver a la pantalla anterior y visualizar el nuevo producto importado.

            WebElement nombre = driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[7]/td/b/a"));
            nombre.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion);
            Thread.sleep(2000);

            WebElement btnX = driver.findElement(By.xpath("//*[@id=\"resizablepanel\"]/a"));
            btnX.click();
            Thread.sleep(1000);

            WebElement btnCerrar = driver.findElement(By.xpath("//*[@id=\"idb_04020140104_result_01\"]"));
            Thread.sleep(1000);
            btnCerrar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen12", nombreAutomatizacion);
*/
            Thread.sleep(3000);

            for (int j = 1; j <= 50; j++){

                //System.out.println("dentro del bucle: " + i);
                Thread.sleep(1000);
                WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li["+ j +"]/div/a/span")); //arreglo para seleccionar la lista deseada.

                String texto = opcionNombre.getText();

                //System.out.println("prueba-->>>>>"+opcionNombre+" => "+ opcionNombre.isEnabled());
                //System.out.println("Texto: " + texto);
                //  nuevaPlantilla.click();

                if (texto.equals(exportarImportarProductoBean.getNombreProducto())){
                    opcionNombre.click();
                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);
                    System.out.println("Prueba: '" + texto + "' seleccionado");
                    break;
                }

            }

            Thread.sleep(2000);
            WebElement activarProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[2]/tbody/tr[1]/td/div/div/div/img[3]"));
            activarProducto.click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);

            Thread.sleep(3000);
            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[1]/div/div/div/div/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button"));
            btnSalvar.click();

            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen14", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

}
