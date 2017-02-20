package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CajaAsociarBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
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
        Metodos13_8 a = new Metodos13_8();
        MenuMantenimiento m = new MenuMantenimiento();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        // Asociar caja a cajero
        m.UAA_AsociarCajaCajero (driver,i,a,nombreAutomatizacion);
        Thread.sleep(4000);
        a.cambiarVentana(driver);
        Thread.sleep(4000);
        AsociarCajaCajero(a, driver, cajaAsociarBean, i); //Busqueda Tercero
    }

    public  void AsociarCajaCajero(Metodos13_8 a, WebDriver driver, CajaAsociarBean cajaAsociarBean, int i ) throws InterruptedException {

        Thread.sleep(3000);
        try {
            //Select cajeroSelect = new Select(driver.findElement(By.xpath("/html/body/center/form/table[1]/tbody/tr[1]/td[2]/select")));
            Thread.sleep(2000);
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

            a.ScreenShotPool(driver,i, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            btnAceptar.click();
            Thread.sleep(3000);

            a.ScreenShotPool(driver,i, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 27 - " + nombreAutomatizacion + " -  " + e);
        }
    }

}
