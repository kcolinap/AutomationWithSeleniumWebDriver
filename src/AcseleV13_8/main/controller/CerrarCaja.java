package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CerrarCajaBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        //Cierre de Caja
        //IngresarMenuCierreCaja(driver, a); //Menu
        m.UAA_Caja_CierreCaja(driver,a,nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(3000);


        //Seleccion y Cierre de Caja
        SeleccionCierreCaja(a, driver, cerrarCajaBean); //Menu
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td/input")).click();
        Thread.sleep(3000);
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
    }

    public void SeleccionCierreCaja(Metodos a, WebDriver driver, CerrarCajaBean cerrarCajaBean) throws InterruptedException, IOException {

        try {
            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            if (cerrarCajaBean.getCajaAbierta() != null) {
                Select cajaAbierta = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[2]/select")));
                cajaAbierta.selectByVisibleText(cerrarCajaBean.getCajaAbierta());
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