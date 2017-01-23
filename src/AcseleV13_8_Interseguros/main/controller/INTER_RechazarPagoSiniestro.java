package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_RechazarPagoSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 21/01/2017.
 */
public class INTER_RechazarPagoSiniestro {

    private final static Logger log = Logger.getLogger(INTER_RechazarPagoSiniestro.class);

    public String nombreAutomatizacion = "Rechazar Pago Siniestros";
    private WebDriver driver;

    public void testLink (INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.OpeSini_MantenimientoSiniestro(driver,a , nombreAutomatizacion,3, i);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            BuscarSiniestro(a, inter_rechazarPagoSiniestroBean, i, folderName);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);
            SiniestroEncontrado(a, inter_rechazarPagoSiniestroBean, i, folderName);
            Thread.sleep(1000);
            EditarPago(a, inter_rechazarPagoSiniestroBean, i, folderName);
            Thread.sleep(1000);
            CambiarEstado(a, inter_rechazarPagoSiniestroBean, i, folderName);
            Thread.sleep(1000);
            SeleccionarOpcion(a, inter_rechazarPagoSiniestroBean, i, folderName);


            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarSiniestro(Interseguros_Metodos a, INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean, int i, String folderName) throws IOException, InterruptedException{

        try {

            Thread.sleep(2000);
            /*if (inter_rechazarPagoSiniestroBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id="VAADIN_COMBOBOX_OPTIONLIST"]/div/div[2]/table/tbody/tr[3]/td")));
                ordenarPor.selectByValue(inter_rechazarPagoSiniestroBean.getOrdenarPor());
            }*/

            if (inter_rechazarPagoSiniestroBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(inter_rechazarPagoSiniestroBean.getNumeroSiniestro());
            }

            if (inter_rechazarPagoSiniestroBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(inter_rechazarPagoSiniestroBean.getNumeroPoliza());
            }

            if (inter_rechazarPagoSiniestroBean.getFechaOcurrenciaSin() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(inter_rechazarPagoSiniestroBean.getFechaOcurrenciaSin());
            }

            String productos = "DotalSimple";

            if (inter_rechazarPagoSiniestroBean.getProducto() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[7]/td/span"));
                producto.click();
                //}
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion, folderName);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[3]/td[3]/div"));
            seleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();

            Thread.sleep(3000);

            a.changeLastWindows(driver);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion, folderName);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void SiniestroEncontrado(Interseguros_Metodos a, INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean, int i, String folderName) throws IOException, InterruptedException{ // dentro de la pantalla del siniestro
        a.changeLastWindows(driver);

        try {

            Thread.sleep(2000);
            WebElement coberturaT = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]"));
            coberturaT.click();
            Thread.sleep(1000);
            WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion, folderName);
            Thread.sleep(3000);

            WebElement crearPago = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]"));
            crearPago.click();
            Thread.sleep(2000);


            Thread.sleep(2000);
            WebElement tercero = driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            tercero.click();
            Thread.sleep(3000);


    /*      if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

*/
            WebElement nombreTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input"));
            Thread.sleep(1000);
            nombreTercero.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]"));
            Thread.sleep(1000);
            btnAceptar.click();

            Thread.sleep(3000);
            WebElement ruta = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[1]/input[2]"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            ruta.click();


            /***********************/
/*          for (int i = 10; i == 0; i--){
                WebElement rutas = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr[" + i + "]/td[1]/input[2]"));
                if (rutas.isEnabled() == true){
                    rutas.click();
                }
            }
*/

            Thread.sleep(3000);




        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EditarPago (Interseguros_Metodos a, INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean, int i, String folderName) throws IOException, InterruptedException{
        try {

            WebElement montoSiniestro = driver.findElement(By.xpath("/*//*[@id=\"amount1\"]"));
            montoSiniestro.clear();
            montoSiniestro.sendKeys(inter_rechazarPagoSiniestroBean.getMontoSiniestro());
            Thread.sleep(2000);

            WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[3]/td[11]"));
            razon.click();

            Thread.sleep(4000);

            WebElement btnAcept = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]"));
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion, folderName);
            btnAcept.click();

            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void CambiarEstado (Interseguros_Metodos a, INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean, int i, String folderName) throws IOException, InterruptedException{

        try {

            WebElement seleccionarPago = driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]"));
            seleccionarPago.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i,  "screen12", nombreAutomatizacion, folderName);
            Thread.sleep(2000);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void SeleccionarOpcion (Interseguros_Metodos a, INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            Select seleccioneAccion = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            seleccioneAccion.selectByValue(inter_rechazarPagoSiniestroBean.getSeleccioneAccion());
            Thread.sleep(2000);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                //Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            //         Thread.sleep(4000);
            //         a.ScreenShotPool(driver, "screen12", nombreAutomatizacion);

            //         Thread.sleep(2000);

        /*    if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }
*/
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion, folderName);

        }

        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }



}
