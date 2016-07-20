package main.controller;

import beans.CerrarCajaBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 18/07/2016.
 */
public class CerrarCaja {

    private final static Logger log = Logger.getLogger(CerrarCaja.class);

    public String nombreAutomatizacion = "CerrarCaja";

    public void testLink(CerrarCajaBean cerrarCajaBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        //Cierre de Caja
        IngresarMenuCierreCaja(driver, a); //Menu
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td/input")).click();
        a.cambiarVentana(driver);
        Thread.sleep(3000);

        //Seleccion y Cierre de Caja
        SeleccionCierreCaja(a, driver, cerrarCajaBean); //Menu
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td/input")).click();
        a.cambiarVentana(driver);
        Thread.sleep(3000);
    }

    public void IngresarMenuCierreCaja(WebDriver driver, Metodos a) throws IOException, InterruptedException {

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operaciones
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[5]"));//UAA (Administrador de Cuentas Universal)
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[13]/div[1]"));//Caja
            WebElement menu4 = driver.findElement(By.xpath("/html/body/div[14]/div[12]"));//Cierre de Caja
            menu1.click();
            menu2.click();
            menu3.click();
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            menu4.click();

        } catch (Exception e) {
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Cerrar Caja- " + e);
        }
    }

    public void SeleccionCierreCaja(Metodos a, WebDriver driver, CerrarCajaBean cerrarCajaBean) throws InterruptedException, IOException {

        try {
            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            if (cerrarCajaBean.getCajaAbierta() != null) {
                Select cajaAbierta = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[3]/td[2]/select")));
                cajaAbierta.selectByValue(cerrarCajaBean.getCajaAbierta());
            }

            Thread.sleep(2000);
            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e) {
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Cerrar Caja - " + e);
        }
    }
}