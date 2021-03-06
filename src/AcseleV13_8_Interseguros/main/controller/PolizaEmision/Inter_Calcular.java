package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import AcseleV13_8_Interseguros.beans.Inter_PolizaBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Created by agil on 28/11/2016.
 */
public class Inter_Calcular {

    private final static Logger log = Logger.getLogger(Inter_Calcular.class);

    public void Calcular(Metodos a, WebDriver driver, Inter_PolizaBean interPolizaBean, String nombreAutomatizacion, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try {

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();

            a.waitSearchWicket(driver, "Espere Administracion Porpuesta de Poliza");

            Thread.sleep(6000);

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnAplicar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnAplicar.click();

            a.waitSearchWicket(driver, "Espere Administracion Porpuesta de Poliza");

            Thread.sleep(3000);

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}
