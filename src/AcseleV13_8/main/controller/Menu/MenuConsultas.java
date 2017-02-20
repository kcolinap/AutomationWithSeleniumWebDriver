package AcseleV13_8.main.controller.Menu;

import AcseleV13_8.main.controller.Metodos13_8;
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

    private final static Logger log = Logger.getLogger(MenuMantenimiento.class);

    Metodos13_8 a = new Metodos13_8();

    /** Consultas **/
    public void MovimientoPolizas(){

    }

    public void EstadoCuentas(Metodos13_8 a, WebDriver driver, String nombreAutomatizacion,int numScreenShoot, int i){
        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]"));// Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[4]/div[2]"));//Mantenimiento de terceros
            Thread.sleep(1000);

            action.moveToElement(menu1).build().perform();
            action.moveToElement(menu2).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Thread.sleep(1000);
            menu2.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

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
