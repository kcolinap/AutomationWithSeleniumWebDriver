package AcseleV13_8_Alfa.main.controller.Menu;

import AcseleV13_8_Alfa.main.controller.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by agil on 25/07/2016.
 */
public class MenuConsultas {

    protected ThreadLocal<WebDriver> threadDriver = null;

    private final static Logger log = Logger.getLogger(MenuOperaciones.class);

    Metodos a = new Metodos();
    /** Consultas **/
    public void MovimientoPolizas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot){

        try{
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]"));// Consultas
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[4]/div[1]"));// Movimiento de Polizas
            action.moveToElement(menu1).build().perform();
            action.moveToElement(menu2).build().perform();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen" + numScreenShoot, nombreAutomatizacion); //screenshot2
            menu2.click();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EstadoCuentas(){

    }

    public void RecuperacionSeguimientoPrimas(){

    }

    public void HerramientaServicioContratante(){

    }

    public void NuevaOpcionCustomerServices(){

    }

    public void ConsultaPolizasEvento(){

    }
}
