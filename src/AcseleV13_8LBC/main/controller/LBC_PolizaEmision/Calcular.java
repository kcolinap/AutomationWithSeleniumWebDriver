package AcseleV13_8LBC.main.controller.LBC_PolizaEmision;

import AcseleV13_8.beans.PolizaBean;
import AcseleV13_8.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by aazuaje on 28/09/2016.
 */
public class Calcular {
    private final static Logger log = Logger.getLogger(Calcular.class);

    public void Calcular(Metodos a, WebDriver driver, PolizaBean polizaBean, String nombreAutomatizacion, int i, int numScreenShoot){

        try {

            WebElement btnCalcular = driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_formCalculate_calculate']"));
            btnCalcular.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Administracion Porpuesta de Poliza");
            }

            /*Set<String> sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            String childId = it.next();
            String childId2 = it.next();
            System.out.println("Prueba " + childId);
            System.out.println("Prueba " + childId2);
            //swtiching control to child Window
            driver.switchTo().window(childId2);*/


            Thread.sleep(6000);

            WebElement btnAplicar = driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']"));
            btnAplicar.click();

            /** Espere **/
            Thread.sleep(1000);
            WebElement mensajeEspera2 = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espere Administracion Porpuesta de Poliza");
            }

            Thread.sleep(3000);

            /*sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            it = sid.iterator();
            parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            childId = it.next();
            System.out.println("Prueba " + childId);
            //swtiching control to child Window
            driver.switchTo().window(childId);*/




        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

}
