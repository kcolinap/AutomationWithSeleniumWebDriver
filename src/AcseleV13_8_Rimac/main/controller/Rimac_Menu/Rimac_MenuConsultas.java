package AcseleV13_8_Rimac.main.controller.Rimac_Menu;

import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by agil on 25/07/2016.
 */
public class Rimac_MenuConsultas {

    protected ThreadLocal<WebDriver> threadDriver = null;

    private final static Logger log = Logger.getLogger(Interseguros_MenuMantenimiento.class);

    Metodos a = new Metodos();

    /** Consultas **/
    public void MovimientoPolizas(){

    }

    public void EstadoCuentas(WebDriver driver, String nombreAutomatizacion, int numScreenShoot, int i){
        try {
            Actions action = new Actions(driver);
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]"));// Consulta
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));//Estado de Cuentas
            menu1.click();
            a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
            menu2.click();

        }catch (Exception e) {
            e.printStackTrace();
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
