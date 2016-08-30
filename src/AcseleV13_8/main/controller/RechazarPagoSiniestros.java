package AcseleV13_8.main.controller;

import AcseleV13_8.beans.RechazarPagoSiniestrosBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by kzambrano on 10/08/2016.
 */
public class RechazarPagoSiniestros {

    private final static Logger log = Logger.getLogger(RechazarPagoSiniestros.class);

    public String nombreAutomatizacion = "Aprobar Pago Siniestros";

    public void testLink(RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        AcseleV13_8_Alfa.main.controller.Metodos a = new AcseleV13_8_Alfa.main.controller.Metodos();
        MenuOperaciones m = new MenuOperaciones();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(3000);
        System.out.println("prueba");


        m.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion);
        Thread.sleep(3000);
        a.cambiarVentana(driver);


        BuscarSiniestro(driver, a, rechazarPagoSiniestrosBean);
        Thread.sleep(3000);



        Thread.sleep(3000);
        EditarPago(driver, a, rechazarPagoSiniestrosBean);

        Thread.sleep(3000);

        CambiarEstado(driver, a, rechazarPagoSiniestrosBean);

        Thread.sleep(3000);

        SeleccionarOpcion(driver, a, rechazarPagoSiniestrosBean);


    }


    public void BuscarSiniestro(WebDriver driver, AcseleV13_8_Alfa.main.controller.Metodos a, RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean) throws IOException, InterruptedException{

        try {

            //
            if (rechazarPagoSiniestrosBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(rechazarPagoSiniestrosBean.getOrdenarPor());
            }

            if (rechazarPagoSiniestrosBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(rechazarPagoSiniestrosBean.getNumeroSiniestro());
            }

            //
            if (rechazarPagoSiniestrosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(rechazarPagoSiniestrosBean.getNumeroPoliza());
            }

            if (rechazarPagoSiniestrosBean.getFechaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(rechazarPagoSiniestrosBean.getFechaSiniestro());
            }

            if (rechazarPagoSiniestrosBean.getProducto() != null){
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/input")));
                producto.selectByValue(rechazarPagoSiniestrosBean.getProducto());
            }


            Thread.sleep(2000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[3]/div"));
            seleccionar.click();

            Thread.sleep(2000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();
    //        Thread.sleep(7000);//
    //        WebElement consultar1 = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
    //        consultar1.click();

            Thread.sleep(4000);


            /***/
      /*      Set<String> sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            String childId = it.next();
    //       String childId2 = it.next();
            System.out.println("Prueba " + childId);
    //        System.out.println("Prueba " + childId2);
            //swtiching control to child Window
           driver.switchTo().window(childId);


*/
            a.changeLastWindows(driver);

            Thread.sleep(2000);
            WebElement coberturaT = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]"));
            coberturaT.click();
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(2000);
            WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura.click();
            Thread.sleep(5000);

            WebElement crearPago = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]"));
            crearPago.click();
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(2000);


            WebElement tercero = driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]"));
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
            tercero.click();
            Thread.sleep(3000);

      /*    if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }
*/

            Thread.sleep(3000);
            WebElement nombreTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input"));
            nombreTercero.click();

            a.ScreenShot(driver, "screen9", nombreAutomatizacion);


            Thread.sleep(2000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]"));
            Thread.sleep(2000);
            btnAceptar.click();

            Thread.sleep(3000);
            WebElement ruta = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[1]/input[2]"));
            a.ScreenShot(driver, "screen10", nombreAutomatizacion);
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

            Thread.sleep(4000);




        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EditarPago (WebDriver driver, AcseleV13_8_Alfa.main.controller.Metodos a, RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean) throws IOException, InterruptedException{
        try {

            WebElement montoSiniestro = driver.findElement(By.xpath("//*[@id=\"amount1\"]"));
            montoSiniestro.clear();
            montoSiniestro.sendKeys(rechazarPagoSiniestrosBean.getMontoSiniestro());
            Thread.sleep(2000);

            WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[3]/td[11]"));
            razon.click();

            Thread.sleep(4000);

            WebElement btnAcept = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]"));
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion);
            btnAcept.click();

            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void CambiarEstado (WebDriver driver, AcseleV13_8_Alfa.main.controller.Metodos a, RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean) throws IOException, InterruptedException{

        try {

            WebElement seleccionarPago = driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]"));
            seleccionarPago.click();

            Thread.sleep(2000);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void SeleccionarOpcion (WebDriver driver, AcseleV13_8_Alfa.main.controller.Metodos a, RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean) throws IOException, InterruptedException {

        try {

            Select seleccioneAccion = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            seleccioneAccion.selectByValue(rechazarPagoSiniestrosBean.getSeleccioneAccion());
            Thread.sleep(2000);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                //Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

   //         Thread.sleep(4000);
   //         a.ScreenShot(driver, "screen12", nombreAutomatizacion);

   //         Thread.sleep(2000);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion);

        }

        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }


}