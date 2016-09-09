package AcseleV13_8.main.controller;


import AcseleV13_8.beans.AprobarEnviarPagoSiniestrosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by kzambrano on 15/08/2016.
 */
public class AprobarEnviarPagoSiniestros {

    private final static Logger log = Logger.getLogger(AprobarEnviarPagoSiniestros.class);

    public String nombreAutomatizacion = "Aprobar Enviar Pago Siniestros";

    public void testLink (AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion,i);
        Thread.sleep(3000);
        a.cambiarVentana(driver);


        BuscarSiniestro(driver, a, aprobarEnviarPagoSiniestrosBean);
        Thread.sleep(3000);



        Thread.sleep(3000);
        EditarPago(driver, a, aprobarEnviarPagoSiniestrosBean);

        Thread.sleep(3000);

        CambiarEstado(driver, a, aprobarEnviarPagoSiniestrosBean);

        Thread.sleep(3000);

        SeleccionarOpcion(driver, a, aprobarEnviarPagoSiniestrosBean);

        Thread.sleep(3000);

        Sucursal (driver, a, aprobarEnviarPagoSiniestrosBean);

        Thread.sleep(3000);

        EnviarPago(driver, a, aprobarEnviarPagoSiniestrosBean);


    }


    public void BuscarSiniestro(WebDriver driver, Metodos a, AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean) throws IOException, InterruptedException{

        try {

            //
            if (aprobarEnviarPagoSiniestrosBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(aprobarEnviarPagoSiniestrosBean.getOrdenarPor());
            }

            if (aprobarEnviarPagoSiniestrosBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(aprobarEnviarPagoSiniestrosBean.getNumeroSiniestro());
            }

            //
            if (aprobarEnviarPagoSiniestrosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(aprobarEnviarPagoSiniestrosBean.getNumeroPoliza());
            }

            if (aprobarEnviarPagoSiniestrosBean.getFechaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(aprobarEnviarPagoSiniestrosBean.getFechaSiniestro());
            }

            if (aprobarEnviarPagoSiniestrosBean.getProducto() != null){
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/input")));
                producto.selectByValue(aprobarEnviarPagoSiniestrosBean.getProducto());
            }


            Thread.sleep(2000);
            a.ScreenShot(driver,"screen4",nombreAutomatizacion);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[3]/div"));
            seleccionar.click();
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();

            Thread.sleep(3000);

            a.changeLastWindows(driver);

            Thread.sleep(1000);
            WebElement coberturaT = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]"));
            coberturaT.click();
            Thread.sleep(1000);


            WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(2000);

            WebElement crearPago = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]"));
            crearPago.click();
          //Thread.sleep(3000);
          //a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(5000);


            WebElement tercero = driver.findElement(By.xpath("//*[@id=\"idb_0402006_generateClaimPayment_04\"]"));
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
            tercero.click();
            Thread.sleep(2000);

/*              if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }
*/
            WebElement nombreTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/table[2]/tbody/tr[4]/td[1]/input"));
            nombreTercero.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_resultClaimThirdParty_01\"]"));
            Thread.sleep(1000);
            btnAceptar.click();

            Thread.sleep(3500);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion);
            Thread.sleep(2000);
            WebElement ruta = driver.findElement(By.xpath("//*[@id=\"paymentTable\"]/tbody/tr/td[1]/input[2]"));
            Thread.sleep(1000);
            ruta.click();
          //  Thread.sleep(2000);
          //  a.ScreenShot(driver, "screen10", nombreAutomatizacion);



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

    public void EditarPago (WebDriver driver, Metodos a, AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean) throws IOException, InterruptedException{
        try {

            WebElement montoSiniestro = driver.findElement(By.xpath("//*[@id=\"amount1\"]"));
            montoSiniestro.clear();
        //    Thread.sleep(1000);
            montoSiniestro.sendKeys(aprobarEnviarPagoSiniestrosBean.getMontoSiniestro());
        //    Thread.sleep(1000);

            WebElement razon = driver.findElement(By.xpath("//*[@id=\"idTablePayments\"]/tbody/tr[3]/td[11]"));
            razon.click();

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen11", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement btnAcept = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimPaymentDetail_01\"]"));
            Thread.sleep(1000);
            btnAcept.click();
            Thread.sleep(2000);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void CambiarEstado (WebDriver driver, Metodos a, AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean) throws IOException, InterruptedException{

        try {

            WebElement seleccionarPago = driver.findElement(By.xpath("//*[@id=\"paymentCheck\"]"));
            Thread.sleep(1000);
            seleccionarPago.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);
            Thread.sleep(1000);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void SeleccionarOpcion (WebDriver driver, Metodos a, AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean) throws IOException, InterruptedException {

        try {

            Select seleccioneAccion = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            seleccioneAccion.selectByValue(aprobarEnviarPagoSiniestrosBean.getSeleccioneAccion());
            Thread.sleep(2000);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
        //        Thread.sleep(1000);
        //        a.ScreenShot(driver, "screen12", nombreAutomatizacion);
        //        Thread.sleep(1000);
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            //         Thread.sleep(4000);
            //         a.ScreenShot(driver, "screen12", nombreAutomatizacion);

            //         Thread.sleep(2000);




/*
            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);
*/
        }

        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }



    }

    public void  Sucursal (WebDriver driver, Metodos a, AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean) throws IOException, InterruptedException {

        try {

            Select sucursal = new Select(driver.findElement(By.xpath("//*[@id=\"divBranchOffice\"]/form/table/tbody/tr[3]/td[1]/table/tbody/tr/td[2]/select")));
            sucursal.selectByValue(aprobarEnviarPagoSiniestrosBean.getSucursal());
            Thread.sleep(2000);

            a.ScreenShot(driver, "screen13", nombreAutomatizacion);

            WebElement btnAcepSucursal = driver.findElement(By.xpath("//*[@id=\"divBranchOffice\"]/form/table/tbody/tr[5]/td/button"));
            btnAcepSucursal.click();

            Thread.sleep(2000);


            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion);


        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }
    }

    public void  EnviarPago (WebDriver driver, Metodos a, AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean) throws IOException, InterruptedException {

        try {

            WebElement enviarPago = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_23\"]"));
            enviarPago.click();
            Thread.sleep(3000);


            WebElement seleccionPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/center/form/table/tbody/tr[4]/td[1]/input"));
            seleccionPago.click();
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen15", nombreAutomatizacion);

            Thread.sleep(2000);

            WebElement bAceptar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_totalizeclaim_04\"]"));
            Thread.sleep(2000);
            bAceptar.click();
            Thread.sleep(6000);
            a.ScreenShot(driver, "screen16", nombreAutomatizacion);
            Thread.sleep(3000);

            WebElement irReclamo = driver.findElement(By.xpath("//*[@id=\"idb_0402006_totalizeclaim_01\"]"));
            irReclamo.click();
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen17", nombreAutomatizacion);
            Thread.sleep(2000);


            WebElement irReclamos = driver.findElement(By.xpath("/html/body/div[14]/div[2]/center/form/table/tbody/tr[6]/td/input[2]"));
            irReclamos.click();
            Thread.sleep(3000);

            WebElement coberT = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]"));
            coberT.click();
            Thread.sleep(2000);

            WebElement coverage = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            coverage.click();
            Thread.sleep(2000);

            WebElement pagos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_09\"]"));
            pagos.click();
            Thread.sleep(4000);
            a.ScreenShot(driver, "screen18", nombreAutomatizacion);

        }

        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}





