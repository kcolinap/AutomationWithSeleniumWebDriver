package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.main.controller.Menu.MenuOperaciones;
import AcseleV13_8_Alfa.beans.CrearOpenItemsBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;


/**
 * Created by mchurion on 23/08/2016.
 */
public class CrearOpenItems {

    private final static Logger log = Logger.getLogger(CrearOpenItemsBean.class);

    public String nombreAutomatizacion = "Crear Open Items";

    public void testLink(CrearOpenItemsBean crearOpenItemsBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Busqueda de Siniestro (a, driver, nombreAutomatizacion);
        m.UAA_ModificacionMovimientosTercero(driver, a, nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);

        InsertarDatos(a, driver, crearOpenItemsBean); //Insertar Datos de busqueda

        //Selecciono el Siniestro a consultar
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]")).click();
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        //Presiono el botón Aceptar
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();

        BorrarFechas(a, driver); //Insertar Datos de busqueda

        //Presiono el botón Insertar
        //Thread.sleep(1000);
        a.cambiarVentana(driver);
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[8]/div/div[3]/div[2]/span[2]/button")).click();
        a.cambiarVentana(driver);
        a.ScreenShot(driver, "screen9", nombreAutomatizacion);

        //De aqui en adelante falta realizar el método correspondiente a la última pantalla que está fallando.
    }


    public void InsertarDatos(AcseleV13_8_Alfa.main.controller.Metodos a, WebDriver driver, CrearOpenItemsBean crearOpenItemsBean) throws InterruptedException, IOException {

        try {
            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Selecionar Tipo Tercero
            if (crearOpenItemsBean.getTipoTercero() != null) {

                WebElement desplegarComboTercero = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select"));
                desplegarComboTercero.click();
                Thread.sleep(1000);

                WebElement seleccionarValorTercero = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select/option[3]"));

                Thread.sleep(1000);
                seleccionarValorTercero.click();
                Thread.sleep(7000);

            }
            //Insertar Número de Documento

            if (crearOpenItemsBean.getNumDocumento() != null) {
                WebElement numDocumento = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[3]/tbody/tr/td[3]/font/input[1]"));
                numDocumento.sendKeys(crearOpenItemsBean.getNumDocumento());
            }

            if (crearOpenItemsBean.getPrimerNombre() != null) {
                Thread.sleep(2000);
                WebElement primerNombre = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[5]/tbody/tr/td[3]/font/input[1]"));
                primerNombre.sendKeys(crearOpenItemsBean.getPrimerNombre());
            }
/*            if (crearOpenItemsBean.getPrimerApellido() != null) {
                Thread.sleep(2000);
                Select primerApellido = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[3]/td/form/table[9]/tbody/tr/td[3]/font/input[1]")));
                primerApellido.selectByValue(crearOpenItemsBean.getPrimerApellido());
            }*/

            Thread.sleep(2000);

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }
        catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Crear Open Items - " + e);
        }

        //Presiono el botón Buscar
        driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]")).click();
        a.cambiarVentana(driver);
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Thread.sleep(2000);
    }


    private void BorrarFechas(Metodos a, WebDriver driver) {

        try {
            Thread.sleep(3000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Borrar fechas y procesar
            driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]")).clear();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]")).clear();
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);


            driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]")).click();
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);
        }
        catch (Exception e) {
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Crear Open Items - " + e);
        }
    }

}


