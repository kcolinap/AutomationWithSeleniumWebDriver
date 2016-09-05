package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CajaAsociarBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 15/07/2016.
 */
public class CajaAsociar {

    private final static Logger log = Logger.getLogger(CajaAsociar.class);

    public String nombreAutomatizacion = "Caja Asociar";

    public void testLink(CajaAsociarBean cajaAsociarBean, int i) throws InterruptedException, IOException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        // Asociar caja a cajero
        MenuAsociarCajaCajero(driver, a); //Menu Asociar caja con cajero
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        AsociarCajaCajero(a, driver, cajaAsociarBean); //Busqueda Tercero
    }

    public void MenuAsociarCajaCajero(WebDriver driver, Metodos a){

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[7]"));//UAA (Administrador de Cuentas Universal)
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[38]/div[5]"));//Asociar Caja con Cajero
            menu1.click();
            menu2.click();
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            menu3.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 27 - " + nombreAutomatizacion + " -  " + e);
        }
    }

    public  void AsociarCajaCajero(Metodos a, WebDriver driver, CajaAsociarBean cajaAsociarBean) throws InterruptedException {

        Thread.sleep(3000);
        try {
            //Select cajeroSelect = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[1]/td[2]/select")));
            Select cajeroSelect = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[1]/td[2]/select")));
            Select numCajaSelect = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[2]/td[2]/select")));
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[3]/td/center/input"));

            Thread.sleep(1000);
            cajeroSelect.selectByValue(cajaAsociarBean.getCajero());
            Thread.sleep(1000);
            numCajaSelect.selectByValue(cajaAsociarBean.getNumCaja());
            Thread.sleep(1000);
            cajeroSelect.selectByValue(cajaAsociarBean.getCajero());
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            btnAceptar.click();
            Thread.sleep(3000);

            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 27 - " + nombreAutomatizacion + " -  " + e);
        }
    }

}
