package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_BusquedaSiniestroAvanzadaBean;
import AcseleV13_8_Interseguros.beans.INTER_LiquidacionCtaTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 25/01/2017.
 */
public class INTER_LiquidacionCtaTecnica {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroAvanzada.class);

    public String nombreAutomatizacion = "Liquidacion Cta Tecnica";
    private WebDriver driver;

    public void testLink (INTER_LiquidacionCtaTecnicaBean inter_liquidacionCtaTecnicaBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.CoaRea_CuentasTecnicas_LiquidacionCuentaTecnica(driver, a, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            LiquidacionCtaTecnica(a, inter_liquidacionCtaTecnicaBean, i, folderName, 3, 4, 5);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);

            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void LiquidacionCtaTecnica(Interseguros_Metodos a, INTER_LiquidacionCtaTecnicaBean inter_liquidacionCtaTecnicaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement detalle  = driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[3]/td[6]/input[2]"));
            detalle.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement detalle2  = driver.findElement(By.xpath("/html/body/center/table[2]/tbody/tr[2]/td[3]/form/input[4]"));
            detalle2.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
