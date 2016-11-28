package AcseleV13_8_Interseguros.main.controller.PolizaEmision;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by agil on 28/11/2016.
 */
public class Inter_Validar {

    private final static Logger log = Logger.getLogger(Inter_Validar.class);

    public void ValidarEmisionPoliza(WebDriver driver, String nombreAutomatizacion){

        // Validacion de la prueba
        Boolean polizaExitosa = driver.findElements(By.xpath("//span[@wicketpath='modalWindowForm_EventSection_content_message']")).size() > 0;
        WebElement polizaExitosaText = driver.findElement(By.xpath("//span[@wicketpath='modalWindowForm_EventSection_content_message']"));

        if (polizaExitosa && polizaExitosaText.getText().equals("PÓLIZA APLICADA SATISFACTORIAMENTE")){
            log.info("Test Case - " + nombreAutomatizacion + " - " + "Prueba Exitosa");
        }
        else {
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida");
        }
    }
}
