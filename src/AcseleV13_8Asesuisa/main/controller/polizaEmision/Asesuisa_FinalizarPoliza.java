package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizasBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by agil on 06/03/2017.
 */
public class Asesuisa_FinalizarPoliza {

    private final static Logger log = Logger.getLogger(Asesuisa_ObjetoAsegurado.class);

    public void Calcular(Metodos a, WebDriver driver, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,1000)", "");
            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));
            //a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();
            a.waitSearchWicket(driver, "Espere Calculando");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResumenAplicar(Metodos a, WebDriver driver, String nombreAutomatizacion, int i, String folderName, int numScreenShoot) {

        try {//TipoElemento[@wicketpath='WicketpathElemento']

            JavascriptExecutor jse = (JavascriptExecutor) driver;

            Thread.sleep(1000);

            //Select producto = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
            //WebElement fechaDesde = driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']"));
            //a.waitSearchWicket(driver, "Espere Nueva Unidad de Riesgo");

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnCalcular.click();
            a.waitSearchWicket(driver, "Espere Aplicando");

            Thread.sleep(2000);

            Boolean isPresent = driver.findElements(By.xpath("//input[@wicketpath='modalWindowForm_ErrorDialog_content_questionForm_check")).size() > 0;

            if (isPresent){

                WebElement ignorar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_ErrorDialog_content_questionForm_check"));
                ignorar.click();
                Thread.sleep(1000);

                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName); //screenshot2
                Toolkit.getDefaultToolkit().beep();

                WebElement btnContinuar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_ErrorDialog_content_questionForm_ignoreValidationButton"));
                btnContinuar.click();


            }



        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
