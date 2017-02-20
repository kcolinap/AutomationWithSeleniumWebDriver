package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_PagoPorConceptosBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 19/01/2017.
 */
public class INTER_PagoPorConceptos {

    private final static Logger log = Logger.getLogger(INTER_PagoPorConceptos.class);

    public String nombreAutomatizacion = "Pago Por Conceptos Siniestros";
    private WebDriver driver;

    public void testLink (INTER_PagoPorConceptosBean inter_pagoPorConceptosBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Metodos a = new Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.OpeSini_MantenimientoSiniestro(driver,a , nombreAutomatizacion,2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);


            BuscarSiniestro(a, inter_pagoPorConceptosBean, i, folderName, 3,4,5);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);
            ReservaPorConceptos (a, inter_pagoPorConceptosBean, i, folderName, 6, 7);
            Thread.sleep(1000);
            ReservaPorConceptosPago(a, inter_pagoPorConceptosBean, i, folderName, 8, 9,10,11,12,13,14);
            Thread.sleep(1000);
            PagarOrdenes(a, inter_pagoPorConceptosBean, i, folderName,15,16,17);

            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarSiniestro(Metodos a, INTER_PagoPorConceptosBean inter_pagoPorConceptosBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3) throws IOException, InterruptedException{

        try {

            //
            if (inter_pagoPorConceptosBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(inter_pagoPorConceptosBean.getOrdenarPor());
            }

            if (inter_pagoPorConceptosBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(inter_pagoPorConceptosBean.getNumeroSiniestro());
            }

            //
            if (inter_pagoPorConceptosBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(inter_pagoPorConceptosBean.getNumeroPoliza());
            }

            if (inter_pagoPorConceptosBean.getFechaOcurrenciaSin() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(inter_pagoPorConceptosBean.getFechaOcurrenciaSin());
            }

            String productos = "DotalSimple";

            if (inter_pagoPorConceptosBean.getProducto() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[7]/td/span"));
                producto.click();
                //}
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[3]/td[3]/div"));
            seleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();

            Thread.sleep(3000);

            a.changeLastWindows(driver);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);



        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ReservaPorConceptos(Metodos a, INTER_PagoPorConceptosBean inter_pagoPorConceptosBean, int i, String folderName, int numScreenShoot, int numScreenShoot2) throws IOException, InterruptedException{

        try {
            a.changeLastWindows(driver);
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[13]/form[3]/div/input[1]"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(2000);

            if (inter_pagoPorConceptosBean.getCobertura() != null){
                Select cobertura = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[3]/td[2]/select")));
                cobertura.selectByValue(inter_pagoPorConceptosBean.getCobertura());
            }

            Thread.sleep(1500);

            WebElement montoReserva = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[5]/td[2]/input[1]"));
            montoReserva.clear();
            Thread.sleep(1000);
            montoReserva.sendKeys(inter_pagoPorConceptosBean.getMontoReserva());
            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[6]/td/input[1]"));
            btnAceptar.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ReservaPorConceptosPago (Metodos a, INTER_PagoPorConceptosBean inter_pagoPorConceptosBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5, int numScreenShoot6, int numScreenShoot7) throws IOException, InterruptedException{

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
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            seleccionTercero.click();
            Thread.sleep(3000);

            WebElement numeroIdent = driver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr[3]/td/form/table[2]/tbody/tr/td[3]/font/input[1]"));
            numeroIdent.sendKeys(inter_pagoPorConceptosBean.getNumeroDocIdent());
            Thread.sleep(1000);


            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr[4]/td/button[1]"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            btnBuscar.click();
            Thread.sleep(8000);

            WebElement opcionTercero = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[6]/div[1]/table/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]"));
            opcionTercero.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnAsociar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[6]/div[1]/table/tbody/tr/td/table/tbody/tr[2]/td/input"));
            Thread.sleep(1000);
            btnAsociar.click();
            Thread.sleep(5000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

            Thread.sleep(1000);
            WebElement editarPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/input[2]"));
            Thread.sleep(1000);
            editarPago.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
            Thread.sleep(2500);

            WebElement montoDelPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[3]/td[14]/input[1]"));
            montoDelPago.click();
            Thread.sleep(1000);
            montoDelPago.clear();
            Thread.sleep(1000);
            montoDelPago.sendKeys(inter_pagoPorConceptosBean.getMontoSiniestro());
            Thread.sleep(1500);


            WebElement clickAfuera = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[2]/td[12]"));
            clickAfuera.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnAcept = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody/tr[10]/td[1]/input[4]"));
            btnAcept.click();
            Thread.sleep(6000);

            WebElement seleccionarPago = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table[2]/tbody/tr[2]/td/table/tbody/tr/td[1]/input[1]"));
            seleccionarPago.click();
            Thread.sleep(2500);

            Select acciones = new Select(driver.findElement(By.xpath("//*[@id=\"actions\"]")));
            acciones.selectByValue(inter_pagoPorConceptosBean.getSeleccioneAccion());
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

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void PagarOrdenes (Metodos a, INTER_PagoPorConceptosBean inter_pagoPorConceptosBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3) throws IOException, InterruptedException{

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
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/center/form/table/tbody/tr[7]/td/input[1]"));
            btnAceptar.click();
            Thread.sleep(3500);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(2000);

            WebElement btnPagos = driver.findElement(By.xpath("/html/body/div[13]/form[3]/div[2]/input[4]"));
            Thread.sleep(1000);
            btnPagos.click();
            Thread.sleep(3000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
