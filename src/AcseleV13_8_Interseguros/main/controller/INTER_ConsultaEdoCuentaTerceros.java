package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaEdoCuentaTercerosBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuConsultas;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 15/11/2016.
 */
public class INTER_ConsultaEdoCuentaTerceros {

    private final static Logger log = Logger.getLogger(INTER_ConsultaEdoCuentaTerceros.class);

    public String nombreAutomatizacion ="Estado de Cuentas";
    private WebDriver driver;

    public void testLink(INTER_ConsultaEdoCuentaTercerosBean inter_consultaEdoCuentaTercerosBean, int i, String folderName)throws Exception {

        try {

            Metodos a = new Metodos();   //implementando metodos.
            Interseguros_MenuConsultas m = new Interseguros_MenuConsultas();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(3000);

            m.EstadoCuentas(driver, nombreAutomatizacion, 2, i);
            Thread.sleep(4000);
            a.cambiarVentana(driver); // Cambiar de ventana

            consultaEdoCuentaTerceros(a, inter_consultaEdoCuentaTercerosBean);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void consultaEdoCuentaTerceros(Metodos a, INTER_ConsultaEdoCuentaTercerosBean inter_consultaEdoCuentaTercerosBean) throws InterruptedException, IOException {

        try {
            Thread.sleep(3000);

            //Screenshot
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);

            // Select del Tipo de Tercero
            Select tipoTercero = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
            tipoTercero.selectByValue(inter_consultaEdoCuentaTercerosBean.getTipoTercero());
            Thread.sleep(10000);

            // Num Documento Identificacion
            WebElement numDocIdent = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[1]/tbody/tr/td[2]/font/input[1]"));
            numDocIdent.sendKeys(inter_consultaEdoCuentaTercerosBean.getNumDocIdent());

            // Primer Apellido
            WebElement priApellido = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[13]/tbody/tr/td[2]/font/input[1]"));
            priApellido.sendKeys(inter_consultaEdoCuentaTercerosBean.getApellido());
            // Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);

            // Primer Nombre
            WebElement priNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[15]/tbody/tr/td[2]/font/input[1]"));
            priNombre.sendKeys(inter_consultaEdoCuentaTercerosBean.getNombre());

            // Boton Buscar
            driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[4]/td/button[1]")).click();
            Thread.sleep(7000);

            /***/
            // Seleccionar el Tercero Buscado
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]")).click();
            //Screenshot
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            // Boton Aceptar
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();
            Thread.sleep(5000);

            /***/
            // Borrar Fecha inicial y final
            driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]")).clear();
            driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]")).clear();

            // Moneda
            Select moneda = new Select(driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[7]/td[2]/select")));
            moneda.selectByValue(inter_consultaEdoCuentaTercerosBean.getMoneda());

            // Producto
            /*Select producto = new Select(driver.findElement(By.name("productID")));
            Select producto = new Select(driver.findElement(By.name("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[8]/td[2]/select")));
            producto.selectByValue(inter_consultaEdoCuentaTercerosBean.getProducto());*/

            // Num Poliza
            /*WebElement numeroPolza = driver.findElement(By.name("policyId"));
            WebElement numeroPolza = driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']"));
            //numeroPolza.sendKeys(inter_consultaEdoCuentaTercerosBean.getNumPoliza());*/

            //Screenshot
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);

            //Boton Enviar
            driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]")).click();
            Thread.sleep(5000);

            //Screenshot
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);

            System.out.println("Fin del Test");

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
