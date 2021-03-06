package AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu;

import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

/**
 * Created by agil on 25/07/2016.
 */
public class Asesuisa_MenuConsultas {

    protected ThreadLocal<WebDriver> threadDriver = null;

    private final static Logger log = Logger.getLogger(Asesuisa_MenuMantenimiento.class);

    Metodos a = new Metodos();

    /** Consultas **/
    public void MovimientoPolizas(){

    }

    public void EstadoCuentas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i, String folderName){
        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[1]"));// Consulta
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[4]/div[2]"));//Estado de Cuentas
            menu1.click();
            Thread.sleep(1000);
            action.moveToElement(menu2).build().perform();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            menu2.click();

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
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
