package AcseleV13_8LBC.main.controller.LBC_Caja;

import AcseleV13_8LBC.beans.LBC_CajaBean;
import AcseleV13_8LBC.main.controller.MetodosLBC;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 20/10/2016.
 */
public class LBC_Caja {

    private final static Logger log = Logger.getLogger(LBC_AsociarCajaConCajero.class);

    public void AperturaCaja(MetodosLBC a, WebDriver driver, LBC_CajaBean lbcCajaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {
            Thread.sleep(2000);

            // Pantalla inicial
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);

            // Llenado del formulario

            if (lbcCajaBean.getNumeroCaja() != null){
                Select numeroCaja = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]/select")));
                numeroCaja.selectByValue(lbcCajaBean.getNumeroCaja());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040203703_cashierRegisterOpening_02\"]"));
            btnAceptar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
