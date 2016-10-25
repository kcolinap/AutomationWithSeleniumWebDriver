package AcseleV13_8LBC.main.controller.LBC_Caja;

import AcseleV13_8LBC.beans.LBC_CajaBean;
import AcseleV13_8LBC.main.controller.LBC_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 19/10/2016.
 */
public class LBC_CrearCaja {

    private final static Logger log = Logger.getLogger(LBC_CrearCaja.class);

    public void CrearCaja(LBC_Metodos a, WebDriver driver, LBC_CajaBean lbcCajaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {
            Thread.sleep(2000);

            // Pantalla inicial
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnInsertar = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/div/input"));
            btnInsertar.click();

            Thread.sleep(4000);

            // Pantalla del formulario
            if (lbcCajaBean.getDescripcion() != null){
                WebElement descripcion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td[2]/input"));
                descripcion.sendKeys(lbcCajaBean.getDescripcion());
                Thread.sleep(2000);
            }

            if (lbcCajaBean.getUbicacion() != null){
                WebElement ubicacion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td[2]/input"));
                ubicacion.sendKeys(lbcCajaBean.getUbicacion());
                Thread.sleep(2000);
            }

            if (lbcCajaBean.getSucursal() != null){
                Select descripcion = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[3]/td[2]/select")));
                descripcion.selectByValue(lbcCajaBean.getSucursal());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            btnInsertar = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/div/input[1]"));
            btnInsertar.click();


            // Pantalla inicial
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();



        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
