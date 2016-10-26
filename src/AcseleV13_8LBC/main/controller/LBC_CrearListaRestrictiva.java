package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CrearListaRestrictivaBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 25/10/2016.
 */
public class LBC_CrearListaRestrictiva {

    private final static Logger log = Logger.getLogger(LBC_CrearListaRestrictiva.class);

    public String nombreAutomatizacion = "LBC Crear Listas Resctrictiva";

    public void testLink(LBC_CrearListaRestrictivaBean lbcCrearListaRestrictivaBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuMantenimiento LBCMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            LBCMenuMantenimiento.AdminLisRest_CrearListasRestrictivas(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la lista Restrictiva */

            Thread.sleep(3000);
            CrearListaRestrictiva(a, driver, lbcCrearListaRestrictivaBean, nombreAutomatizacion, i, 3, 4, 5, 6, 7);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void CrearListaRestrictiva(LBC_Metodos a, WebDriver driver, LBC_CrearListaRestrictivaBean lbcCrearListaRestrictivaBean, String nombreAutomatizacion, int i,
                                      int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnAgregar = driver.findElement(By.xpath("//div[2]/div/div/div/div/div/span"));
            btnAgregar.click();

            Thread.sleep(4000);

            if (lbcCrearListaRestrictivaBean.getTipo() != null) {
                WebElement mostrarTipo = driver.findElement(By.xpath("//div/div/div/div/div/div/div[2]/div/div"));
                mostrarTipo.click();
                Thread.sleep(500);
                if (lbcCrearListaRestrictivaBean.getTipo().toLowerCase().equals("negra")) {
                    WebElement listaNegra = driver.findElement(By.xpath("//tr[2]/td/span"));
                    listaNegra.click();
                    Thread.sleep(1000);
                }
                else if (lbcCrearListaRestrictivaBean.getTipo().toLowerCase().equals("blanca")) {
                    WebElement listaBlanca = driver.findElement(By.xpath("//tr[3]/td"));
                    listaBlanca.click();
                    Thread.sleep(1000);
                }
            }

            if (lbcCrearListaRestrictivaBean.getNombre() != null) {
                WebElement mostrarNombre = driver.findElement(By.xpath("//div/div/div/div[2]/div/div/div[2]/div/div"));
                mostrarNombre.click();
                Thread.sleep(500);
                if (lbcCrearListaRestrictivaBean.getNombre().toLowerCase().equals("pruebalistas")) {
                    WebElement pruebaListas = driver.findElement(By.xpath("//tr[2]/td/span"));
                    pruebaListas.click();
                    Thread.sleep(1000);
                }
                if (lbcCrearListaRestrictivaBean.getNombre().toLowerCase().equals("prueba")) {
                    WebElement prueba = driver.findElement(By.xpath("//tr[3]/td/span"));
                    prueba.click();
                    Thread.sleep(1000);
                }
            }

            WebElement btnImportarArchivo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[2]/form/div/input[2]"));
            btnImportarArchivo.click();
            Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\LBC_CrearListasRestrictivas.exe");

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span/span"));
            btnAceptar.click();

            Thread.sleep(4000);

            WebElement seleccionarLista = driver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td/div"));
            seleccionarLista.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/span/span"));
            btnConsultar.click();

            Thread.sleep(2000);

            WebElement seleccionarFechaLista = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div/div/span/input"));
            seleccionarFechaLista.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAceptarConsulta = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[3]/div/div/div[1]/div/span/span"));
            btnAceptarConsulta.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            log.info("Test Case - " + nombreAutomatizacion + " - " + "Prueba Exitosa");


        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
