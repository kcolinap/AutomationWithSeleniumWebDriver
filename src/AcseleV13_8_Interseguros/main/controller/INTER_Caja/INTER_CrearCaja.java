package AcseleV13_8_Interseguros.main.controller.INTER_Caja;

import AcseleV13_8_Interseguros.beans.INTER_CajaBean;
import AcseleV13_8_Interseguros.beans.INTER_CreacionCajaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by mchurion on 25/11/2016.
 */
public class INTER_CrearCaja {

    private final static Logger log = Logger.getLogger(INTER_CrearCaja.class);

    public void CrearCaja(Interseguros_Metodos a, WebDriver driver, INTER_CajaBean interCajaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {
            Thread.sleep(2000);

            // Pantalla inicial
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            WebElement btnInsertar = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td/table/tbody/tr[2]/td/div/input"));
            btnInsertar.click();

            Thread.sleep(4000);

            // Pantalla del formulario
            if (interCajaBean.getDescripcion() != null){
                WebElement descripcion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td[2]/input"));
                descripcion.sendKeys(interCajaBean.getDescripcion());
                Thread.sleep(2000);
            }

            if (interCajaBean.getUbicacion() != null){
                WebElement ubicacion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td[2]/input"));
                ubicacion.sendKeys(interCajaBean.getUbicacion());
                Thread.sleep(2000);
            }

            if (interCajaBean.getSucursal() != null){
                Select descripcion = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[3]/td[2]/select")));
                descripcion.selectByValue(interCajaBean.getSucursal());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            btnInsertar = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/div/input[1]"));
            btnInsertar.click();


            // Pantalla inicial
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
