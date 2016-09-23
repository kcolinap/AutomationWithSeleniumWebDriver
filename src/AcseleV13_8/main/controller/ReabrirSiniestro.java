package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ReabrirSiniestroBean;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by aazuaje on 23/09/2016.
 */
public class ReabrirSiniestro {

    private final static Logger log = Logger.getLogger(ReabrirSiniestro.class);

    public String nombreAutomatizacion = "Reabrir Siniestro";

    public void testLink(ReabrirSiniestroBean reabrirSiniestroBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuOperaciones m = new MenuOperaciones();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        m.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion, i);
        Thread.sleep(10000);

        a.cambiarVentana(driver);
        BuscarPoliza(driver, a, reabrirSiniestroBean, i);
        ResultadoBusqueda(driver, a, reabrirSiniestroBean, i);
        ReabrirSiniestro(driver, a, reabrirSiniestroBean, i);



    }

    public void BuscarPoliza(WebDriver driver, Metodos a, ReabrirSiniestroBean reabrirSiniestroBean, int i) throws IOException, InterruptedException{

        try {

            if (reabrirSiniestroBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (reabrirSiniestroBean.getOrdenarPor() == "Número de Reclamo"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (reabrirSiniestroBean.getOrdenarPor() == "Producto"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (reabrirSiniestroBean.getOrdenarPor() == "Fecha de Ocurrencia"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (reabrirSiniestroBean.getOrdenarPor() == "Estado del siniestro"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (reabrirSiniestroBean.getNumSiniestro() != null){
                Thread.sleep(2000);
                WebElement numSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numSiniestro.sendKeys(reabrirSiniestroBean.getNumSiniestro());
            }

            if (reabrirSiniestroBean.getNumPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numPoliza.sendKeys(reabrirSiniestroBean.getNumPoliza());
            }

            if (reabrirSiniestroBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaOcurrenciaSiniestro  = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/button"));
                fechaOcurrenciaSiniestro.sendKeys(reabrirSiniestroBean.getFechaOcurrenciaSiniestro());
            }

            String productos = "VidaDeudoresAvVillas";

            if (reabrirSiniestroBean.getProducto() != null){
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
            a.ScreenShotPool(driver, i,"screen4",nombreAutomatizacion);

            WebElement btnBuscar  = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span"));
            btnBuscar.click();

            Thread.sleep(4000);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda(WebDriver driver,Metodos a, ReabrirSiniestroBean reabrirSiniestroBean, int i) throws IOException, InterruptedException{

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[10]/td[3]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(15000);
            a.changeLastWindows(driver);

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ReabrirSiniestro (WebDriver driver,Metodos a, ReabrirSiniestroBean reabrirSiniestroBean, int i) throws IOException, InterruptedException{
        try{

            Thread.sleep(2000);

            WebElement btnReabrir = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_31\"]"));
            btnReabrir.click();
            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Select motivoReapertura = new Select(driver.findElement(By.xpath("//*[@id=\"1929534\"]/td[3]/font/select")));
            motivoReapertura.selectByValue(reabrirSiniestroBean.getMotivoReapertura());
            Thread.sleep(2000);

            if (reabrirSiniestroBean.getNumSiniestro() != null){
                Thread.sleep(2000);
                WebElement comentarioSiniestro = driver.findElement(By.xpath("//*[@id=\"1929454\"]/td[3]/font/textarea"));
                comentarioSiniestro.sendKeys(reabrirSiniestroBean.getComentarioSiniestro());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(3000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[4]/input"));
            btnAceptar.click();
            Thread.sleep(15000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


}
