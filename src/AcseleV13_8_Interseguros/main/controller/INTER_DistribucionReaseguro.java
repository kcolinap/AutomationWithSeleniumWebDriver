package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_DistribucionReaseguroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 25/01/2017.
 */
public class INTER_DistribucionReaseguro {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroAvanzada.class);

    public String nombreAutomatizacion = "Distribucion Reaseguro";
    private WebDriver driver;

    public void testLink (INTER_DistribucionReaseguroBean inter_distribucionReaseguroBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.CoaRea_MantenimientoDistribucionReaseguro(driver, a, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            BuscarTercero(a, inter_distribucionReaseguroBean, i, folderName, 3, 4, 5);
            ResultadoBuscar (a, inter_distribucionReaseguroBean, i, folderName, 6,7,8);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);

            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarTercero(Metodos a, INTER_DistribucionReaseguroBean inter_distribucionReaseguroBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement tercero  = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[11]/a"));
            tercero.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            Select tipoTercero = new Select(driver.findElement(By.xpath("//*[@id=\"thirdPartyType\"]")));
            tipoTercero.selectByValue(inter_distribucionReaseguroBean.getTipoTercero());


            Thread.sleep(2000);
            WebElement nombreEmpresa = driver.findElement(By.xpath("//*[@id=\"NombreCompEmp\"]"));
            nombreEmpresa.sendKeys(inter_distribucionReaseguroBean.getNombreEmpresa());

            Thread.sleep(2000);
            WebElement btnBuscar  = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchformthridparty_01\"]"));
            btnBuscar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ResultadoBuscar(Metodos a, INTER_DistribucionReaseguroBean inter_distribucionReaseguroBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            Thread.sleep(1000);
            Select sucursal = new Select(driver.findElement(By.xpath("//*[@id=\"userAgency\"]")));
            sucursal.selectByValue(inter_distribucionReaseguroBean.getSucursal());

            Thread.sleep(1000);
            driver.switchTo().frame("frameData");
            Thread.sleep(1000);
            WebElement poliza  = driver.findElement(By.xpath("//*[@id=\"form1\"]/table/tbody/tr[2]/td[1]/input"));
            poliza.click();
            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement btnAceptar  = driver.findElement(By.xpath("//*[@id=\"idb_040201401_searchresult_07\"]"));
            btnAceptar.click();

            Thread.sleep(3000);
            WebElement btnDistribucion = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td[2]/input[1]"));
            btnDistribucion.click();

            Thread.sleep(2000);
            WebElement btnEjecutar  = driver.findElement(By.xpath("//*[@id=\"idb_040203107_policy_operation_01\"]"));
            btnEjecutar.click();

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnDetalles  = driver.findElement(By.xpath("//*[@id=\"idb_040203107_view_operations_01\"]"));
            btnDetalles.click();

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


}
