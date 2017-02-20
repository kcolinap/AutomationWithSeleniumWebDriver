package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ConsultasOrdenesPagoBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by rmontilla on 14/09/2016.
 */
public class ConsultasOrdenesPago {

    private final static Logger log = Logger.getLogger(ConsultasOrdenesPago.class);

    public String nombreAutomatizacion = "Consulta de Ordenes de Pago";

    public void testLink(ConsultasOrdenesPagoBean consultasOrdenesPagoBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos13_8 a = new Metodos13_8();
            MenuOperaciones menuOperaciones = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion, 2, i);

            //
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaSiniestro(driver, consultasOrdenesPagoBean, a, i);
            ResultadoBusqueda(driver, consultasOrdenesPagoBean, a, i);
            ConsultaPagos(driver, consultasOrdenesPagoBean, a, i);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }



    public void BusquedaSiniestro (WebDriver driver, ConsultasOrdenesPagoBean consultasOrdenesPagoBean, Metodos13_8 a, int i) throws InterruptedException, IOException {

        try{
        if (consultasOrdenesPagoBean.getOrdenarPor() != null){
            Thread.sleep(1000);

            if (consultasOrdenesPagoBean.getOrdenarPor().equals("Número de Reclamo")){
                Thread.sleep(1000);
                WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                btnSeleccionar1.click();
                Thread.sleep(1000);
                WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                ordenarPor.click();
            }

            if (consultasOrdenesPagoBean.getOrdenarPor().equals("Producto")){
                Thread.sleep(1000);
                WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                btnSeleccionar1.click();
                Thread.sleep(1000);
                WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                ordenarPor.click();
            }

            if (consultasOrdenesPagoBean.getOrdenarPor().equals("Fecha de Ocurrencia")){
                Thread.sleep(1000);
                WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                btnSeleccionar1.click();
                Thread.sleep(1000);
                WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                ordenarPor.click();
            }

            if (consultasOrdenesPagoBean.getOrdenarPor().equals("Estado del siniestro")){
                Thread.sleep(1000);
                WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                btnSeleccionar1.click();
                Thread.sleep(1000);
                WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                ordenarPor.click();
            }

        }

        if (consultasOrdenesPagoBean.getNumSiniestro() != null){
            Thread.sleep(1000);
            WebElement numSiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
            numSiniestro.sendKeys(consultasOrdenesPagoBean.getNumSiniestro());
        }

        if (consultasOrdenesPagoBean.getNumPoliza() != null){
            Thread.sleep(1000);
            WebElement numPoliza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[8]/input"));
            numPoliza.sendKeys(consultasOrdenesPagoBean.getNumPoliza());
        }

        if (consultasOrdenesPagoBean.getFechaOcurrenciaSiniestro() != null){
            Thread.sleep(1000);
            WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[6]/div/input"));
            fechaOcurrenciaSiniestro.sendKeys(consultasOrdenesPagoBean.getFechaOcurrenciaSiniestro());


        }

        String productos = "VidaDeudoresAvVillas";

        if (consultasOrdenesPagoBean.getProducto() != null){
            //if (editarSiniestrosBean.getProducto() == productos){
            Thread.sleep(1000);
            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
            btnSeleccionar.click();
            Thread.sleep(1000);
            WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
            producto.click();
            //}
        }

        Thread.sleep(1000);
        a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

        WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div/div[3]/div/span/span"));
        btnBuscar.click();

        Thread.sleep(4000);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


    private void ResultadoBusqueda(WebDriver driver, ConsultasOrdenesPagoBean consultasOrdenesPagoBean, Metodos13_8 a, int i) {
        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void ConsultaPagos(WebDriver driver, ConsultasOrdenesPagoBean consultasOrdenesPagoBean, Metodos13_8 a, int i) {
        try{
            Thread.sleep(1000);
            WebElement btnSelecCover  = driver.findElement(By.xpath("/html/body/div[13]/form[2]/select/option"));
            btnSelecCover.click();


            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);


            WebElement btnPagos = driver.findElement(By.xpath("/html/body/div[13]/form[2]/div[3]/input[6]"));
            btnPagos.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);

            Thread.sleep(5000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);


        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }



}
