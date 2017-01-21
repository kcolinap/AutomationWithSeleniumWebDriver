package AcseleV13_8_Interseguros.main.controller.INTER_Caja;

import AcseleV13_8_Interseguros.beans.INTER_CajaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by mchurion on 12/12/2016.
 */
public class INTER_Caja {
    private final static Logger log = Logger.getLogger(INTER_Caja.class);

    public void AperturaCaja(Interseguros_Metodos a, WebDriver driver, INTER_CajaBean interCajaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {
            Thread.sleep(2000);

            // Pantalla inicial
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);

            // Llenado del formulario

            if (interCajaBean.getNumeroCaja() != null){
                Select numeroCaja = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]/select")));
                //numeroCaja.selectByValue(interCajaBean.getNumeroCaja());
                numeroCaja.selectByVisibleText(interCajaBean.getNumeroCaja());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040203703_cashierRegisterOpening_02\"]"));
            btnAceptar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CierreCaja(Interseguros_Metodos a, WebDriver driver, INTER_CajaBean interCajaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {
            Thread.sleep(2000);

            // Pantalla inicial
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);

            // Llenado del formulario

            if (interCajaBean.getNumeroCaja() != null){
                Select numeroCaja = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[3]/td[2]/select")));
                //numeroCaja.selectByValue(lbcCajaBean.getNumeroCaja());
                numeroCaja.selectByVisibleText(interCajaBean.getNumeroCaja());
                Thread.sleep(2000);
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_040203703_cashierRegisterClosing_02\"]"));
            btnAceptar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
