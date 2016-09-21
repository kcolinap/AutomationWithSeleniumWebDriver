package AcseleV13_8.main.controller;

import AcseleV13_8.beans.PagoPorConceptosBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;
import sun.font.TextRecord;

import java.io.IOException;

/**
 * Created by kzambrano on 13/09/2016.
 */
public class PagoPorConceptos {

    private final static Logger log = Logger.getLogger(PagoPorConceptos.class);

    public String nombreAutomatizacion = "Pago Por Conceptos Siniestros";

    public void testLink (PagoPorConceptosBean pagoPorConceptosBean, int i )  throws IOException, InterruptedException {

        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");


        m.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion, i);

        Thread.sleep(3000);
        a.cambiarVentana(driver);


        BuscarSiniestro(driver, a, pagoPorConceptosBean, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
       // Thread.sleep(1500);
        ReservaPorConceptos (driver, a, pagoPorConceptosBean, i);
        Thread.sleep(1000);
        ReservaPorConceptosPago(driver, a, pagoPorConceptosBean, i);
        Thread.sleep(1000);
        PagarOrdenes(driver, a, pagoPorConceptosBean, i);






        //  a.changeLastWindows(driver);


    }

    public void BuscarSiniestro(WebDriver driver, Metodos a, PagoPorConceptosBean pagoPorConceptosBean, int i) throws IOException, InterruptedException{

        try {

            //
            if (pagoPorConceptosBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(pagoPorConceptosBean.getOrdenarPor());
            }

            if (pagoPorConceptosBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(pagoPorConceptosBean.getNumeroSiniestro());
            }

            //
            if (pagoPorConceptosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(pagoPorConceptosBean.getNumeroPoliza());
            }

            if (pagoPorConceptosBean.getFechaOcurrenciaSin() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(pagoPorConceptosBean.getFechaOcurrenciaSin());
            }

            if (pagoPorConceptosBean.getProducto() != null){
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/input")));
                producto.selectByValue(pagoPorConceptosBean.getProducto());
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[3]/div"));
            seleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();

            Thread.sleep(3000);

            a.changeLastWindows(driver);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);



        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ReservaPorConceptos(WebDriver driver, Metodos a, PagoPorConceptosBean pagoPorConceptosBean, int i) throws IOException, InterruptedException{

        try {
            a.changeLastWindows(driver);
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[13]/form[3]/div/input[1]"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(5000);

            if (pagoPorConceptosBean.getCobertura() != null){
                Select cobertura = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[3]/td[2]/select")));
                cobertura.selectByVisibleText(pagoPorConceptosBean.getCobertura());
            }

            Thread.sleep(1500);

            WebElement montoReserva = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[5]/td[2]/input[1]"));
            montoReserva.clear();
            Thread.sleep(1000);
            montoReserva.sendKeys(pagoPorConceptosBean.getMontoReserva());
            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[6]/td/input[1]"));
            btnAceptar.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ReservaPorConceptosPago (WebDriver driver, Metodos a, PagoPorConceptosBean pagoPorConceptosBean, int i) throws IOException, InterruptedException{

        try {
            a.changeLastWindows(driver);
            Actions action = new Actions(driver);
            Thread.sleep(1500);
            WebElement btnPago = driver.findElement(By.xpath("/html/body/div[13]/form[3]/div[2]/input[4]"));
            btnPago.click();
            Thread.sleep(6000);

         /*   WebElement scroll = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]")); // se usa para mover el scroll
            scroll.sendKeys(Keys.PAGE_DOWN);
            scroll.sendKeys(Keys.PAGE_DOWN);
            Thread.sleep(3000);
        */

            WebElement seleccionTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table[2]/tbody/tr[7]/td/input[1]"));
            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);
            Thread.sleep(1000);
            seleccionTercero.click();
            Thread.sleep(3000);

            WebElement numeroIdent = driver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr[3]/td/form/table[2]/tbody/tr/td[3]/font/input[1]"));
            numeroIdent.sendKeys(pagoPorConceptosBean.getNumeroDocIdent());
            Thread.sleep(1000);


            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr[4]/td/button[1]"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);
            Thread.sleep(1000);
            btnBuscar.click();
            Thread.sleep(8000);

            WebElement opcionTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[6]/div[1]/table/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
            opcionTercero.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAsociar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[6]/div[1]/table/tbody/tr/td/table/tbody/tr[2]/td/input"));
            Thread.sleep(1000);
            btnAsociar.click();
            Thread.sleep(5000);
            a.ScreenShotPool(driver, i, "screen12", nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement editarPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/input[2]"));
            Thread.sleep(1000);
            editarPago.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);
            Thread.sleep(2500);

            WebElement montoDelPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[3]/td[14]/input[1]"));
            montoDelPago.click();
            Thread.sleep(1000);
            montoDelPago.clear();
            Thread.sleep(1000);
            montoDelPago.sendKeys(pagoPorConceptosBean.getMontoSiniestro());
            Thread.sleep(1500);


            WebElement clickAfuera = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[2]/td[12]"));
            clickAfuera.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen14", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAcept = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[10]/td[1]/input[4]"));
            btnAcept.click();
            Thread.sleep(6000);

            WebElement seleccionarPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/input[1]"));
            seleccionarPago.click();
            Thread.sleep(2500);

            Select acciones = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            acciones.selectByValue(pagoPorConceptosBean.getSeleccioneAccion());
            Thread.sleep(2000);



         //   Thread.sleep(1000);
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

            a.ScreenShotPool(driver, i, "screen15", nombreAutomatizacion);
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void PagarOrdenes (WebDriver driver, Metodos a, PagoPorConceptosBean pagoPorConceptosBean, int i) throws IOException, InterruptedException{

        try {

            a.changeLastWindows(driver);

            Thread.sleep(2500);
            WebElement btnPagarOrdenes = driver.findElement(By.xpath("/html/body/div[15]/div[5]/form/input[3]"));
            Thread.sleep(1000);
            btnPagarOrdenes.click();
            Thread.sleep(4000);

            WebElement seleccionarPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/center/form/table/tbody/tr[6]/td[1]/input"));
            seleccionarPago.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen16", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/center/form/table/tbody/tr[7]/td/input[1]"));
            btnAceptar.click();
            Thread.sleep(3500);
            a.ScreenShotPool(driver, i, "screen17", nombreAutomatizacion);
            Thread.sleep(2000);

            WebElement btnPagos = driver.findElement(By.xpath("/html/body/div[13]/form[3]/div[2]/input[4]"));
            Thread.sleep(1000);
            btnPagos.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen18", nombreAutomatizacion);




        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
