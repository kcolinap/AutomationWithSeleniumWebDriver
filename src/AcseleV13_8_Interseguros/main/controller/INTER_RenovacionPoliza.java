package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_RenovacionPolizaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by rmontilla on 27/12/2016.
 */
public class INTER_RenovacionPoliza {

    private final static Logger log = Logger.getLogger(INTER_RenovacionPoliza.class);

    public String nombreAutomatizacion ="INTER Renovacion de Poliza";
    private WebDriver driver;

    public void testLink(INTER_RenovacionPolizaBean inter_renovacionPolizaBean, int i, String folderName){

        try {

            Metodos a = new Metodos();   //implementando metodos.
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(5000);

            m.OpePol_CotizacionSuscripcionMantenimientoPolizas(driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            BuscarPoliza(a, inter_renovacionPolizaBean, i, folderName, 3, 4, 5, 6, 7, 8, 9);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarPoliza(Metodos a, INTER_RenovacionPolizaBean inter_renovacionPolizaBean, int i, String folderName,
                             int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7){

        try {

            Thread.sleep(3000); //TipoElemento[@wicketpath='WicketpathElemento']
            //Campo del num de la poliza
            WebElement fieldNumPoliza = driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_policyNumber']"));
//          WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
            //fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());
            fieldNumPoliza.sendKeys(inter_renovacionPolizaBean.getNumPoliza());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            //Boton Buscar
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_searchForm_searchButton']")).click();

            //Thread.sleep(10000);
            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espera 1");


            //Seleccionar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_groupPolicies_resultSearchPolicyTable_1_policy']")).click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            //Boton Renovar Poliza
            driver.findElement(By.xpath("//input[@wicketpath='ConsultPolicy_ResultSearchSimplePolicy_buttonsForm_container_RenewPolicyButton']")).click();

            //Thread.sleep(5000);

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espera 2");

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_Form_continueButton']")).click();
            // Thread.sleep(15000);

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espera 3");


            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            // Boton Calcular
            driver.findElement(By.xpath("//input[@wicketpath='divCalculatePolicy_calculateForm_calculateButton']")).click();
            //Thread.sleep(5000);

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espera 4");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            // Boton Aplicar
            driver.findElement(By.xpath("//input[@wicketpath='modalWindowForm_EventSection_content_CloseForm_ApplyPolicy']")).click();
            //Thread.sleep(15000);

            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espera 5");

            // Boton Ingnorar validaciones
            //driver.findElement(By.name("ErrorDialog:content:questionForm:check")).click();
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            // Boton Continuar
            driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")).click();
            Thread.sleep(5000);

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
