package main.controller;

import beans.CajaAperturarBean;
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
public class CajaAperturar {

    private final static Logger log = Logger.getLogger(CajaAperturar.class);

    public String nombreAutomatizacion = "Caja Aperturar";

    public void testLink(CajaAperturarBean cajaAperturarBean, int i) throws InterruptedException, IOException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Asociar caja a cajero
        MenuAperturarCaja(driver, a); //Menu Asociar caja con cajero
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        AperturarCaja(a, driver, cajaAperturarBean); //Busqueda Tercero
    }

    public void MenuAperturarCaja(WebDriver driver, Metodos a){

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operacion
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[5]"));//UAA (Administrador de Cuentas Universal)
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[13]/div[1]"));//Caja
            WebElement menu4 = driver.findElement(By.xpath("/html/body/div[14]/div[1]"));//Aperturar Caja
            menu1.click();
            menu2.click();
            menu3.click();
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            Thread.sleep(1000);
            menu4.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 28 - " + nombreAutomatizacion + " -  " + e);
        }
    }

    public void AperturarCaja(Metodos a, WebDriver driver, CajaAperturarBean cajaAperturarBean) throws InterruptedException {

        Thread.sleep(3000);
        try {

            Select numCajaSelect = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]/select")));
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[5]/td/center/input"));


            Thread.sleep(1000);
            numCajaSelect.selectByValue(cajaAperturarBean.getNumCaja());
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(2000);

            btnAceptar.click();
            Thread.sleep(5000);

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
