package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CumuloTerceroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

/**
 * Created by aazuaje on 10/01/2017.
 */
public class INTER_CumuloTercero {

    private final static Logger log = Logger.getLogger(INTER_CumuloTercero.class);

    public String nombreAutomatizacion = "INTER Cumulo Tercero";
    private WebDriver driver;

    public void testLink(INTER_CumuloTerceroBean inter_cumuloTerceroBean, int i, String folderName) throws IOException, InterruptedException {

        try {
            //Alert alertaJS = driver.switchTo().alert();
            //implementando clase de metodos
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(8000);

            m.Cumulos_CumulosPorTerceros(driver, nombreAutomatizacion, 3, i, folderName);
            Thread.sleep(8000);
            a.cambiarVentana(driver);
            BusquedaTerceros(a, inter_cumuloTerceroBean, i, folderName, 4, 5, 6, 7);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }


    public void BusquedaTerceros (Metodos a, INTER_CumuloTerceroBean inter_cumuloTerceroBean, int i, String folderName,
                                  int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try{

            Alert alertaJs;
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Select tipoTercero = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
            tipoTercero.selectByValue(inter_cumuloTerceroBean.getTipoTercero());

            Thread.sleep(1500);

            // Llamada a metodo Mensajes de Alerta JavaScript
             alertaJs= driver.switchTo().alert();
            MensajesAlert(alertaJs);

            Thread.sleep(1000);
            if (inter_cumuloTerceroBean.getDocumentoIdentidad() != null){
            WebElement documentoIdentidad = (driver.findElement(By.xpath("//*[@id=\"DocumentoIdentidad\"]")));
            documentoIdentidad.sendKeys(inter_cumuloTerceroBean.getDocumentoIdentidad());
                MensajesAlert(alertaJs);
            }

            Thread.sleep(2000);
            if (inter_cumuloTerceroBean.getPasaporte() != null){
                WebElement pasaporte = driver.findElement(By.xpath("//*[@id=\"Pasaporte\"]"));
                pasaporte.sendKeys(inter_cumuloTerceroBean.getPasaporte());
                MensajesAlert(alertaJs);
            }

            Thread.sleep(2000);
            if (inter_cumuloTerceroBean.getApellido() != null){
                WebElement primerApellido = driver.findElement(By.xpath("//*[@id=\"Apellido\"]"));
                primerApellido.sendKeys(inter_cumuloTerceroBean.getApellido());
                Thread.sleep(1000);
                WebElement primerNombre = driver.findElement(By.xpath("//*[@id=\"Nombre\"]"));
                primerNombre.click();
                Thread.sleep(1000);
                MensajesAlert(alertaJs);
            }

            Thread.sleep(2000);
            if (inter_cumuloTerceroBean.getNombre() != null){
                WebElement primerNombre = driver.findElement(By.xpath("//*[@id=\"Nombre\"]"));
                primerNombre.sendKeys(inter_cumuloTerceroBean.getNombre());
                Thread.sleep(1000);
                WebElement primerApellido = driver.findElement(By.xpath("//*[@id=\"Apellido\"]"));
                primerApellido.click();
                Thread.sleep(1000);
                MensajesAlert(alertaJs);
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForCumulus_01\"]"));
            btnBuscar.click();

            Thread.sleep(4000);

            WebElement btnSeleccionar = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
            btnSeleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"td_button_submit_01\"]/input"));
            btnAceptar.click();

            Thread.sleep(10000);
            /*WebElement btnmoneda = driver.findElement(By.xpath("//*[@id=\"money\"]"));
            btnmoneda.click();*/

            Select moneda = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda.selectByValue(inter_cumuloTerceroBean.getMoneda());


            /*Thread.sleep(2000);
            Select moneda2 = new Select(driver.findElement(By.xpath("//*[@id=\"money\"]")));
            moneda2.selectByValue(inter_cumuloTerceroBean.getMoneda2());*/

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }

    public void MensajesAlert(Alert alertaJS){
        try{
            //alert= driver.switchTo().alert();
            Thread.sleep(1500);
            if(ExpectedConditions.alertIsPresent()!=null) {
                Thread.sleep(1000);
                alertaJS = driver.switchTo().alert();
                alertaJS.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
