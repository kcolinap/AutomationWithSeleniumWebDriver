package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.GeneracionDocumentosSiniestrosBean;
import AcseleV13_8_Alfa.main.controller.Menu.MenuOperaciones;
//import org.apache.commons.collections.StaticBucketMap;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
//import org.openqa.selenium.support.ui.Select;

/**
 * Created by rmontilla on 26/09/2016.
 */
public class GeneracionDocumentosSiniestros {

    private final static Logger log = Logger.getLogger(GeneracionDocumentosSiniestros.class);

    public String nombreAutomatizacion = "Generación de documentos en Siniestros";

    public void testLink(GeneracionDocumentosSiniestrosBean generacionDocumentosSiniestrosBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuOperaciones menuOperaciones = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion);

            a.ValidandoSesion(driver, nombreAutomatizacion);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion);

            //
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaSiniestro(driver, generacionDocumentosSiniestrosBean, a, i);
            ResultadoBusqueda(driver, generacionDocumentosSiniestrosBean, a, i);
            GeneracionDocumento(driver, generacionDocumentosSiniestrosBean, a, i);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BusquedaSiniestro (WebDriver driver, GeneracionDocumentosSiniestrosBean generacionDocumentosSiniestrosBean, Metodos a, int i) throws InterruptedException, IOException {

        try{
            if (generacionDocumentosSiniestrosBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (generacionDocumentosSiniestrosBean.getOrdenarPor().equals("Número de Reclamo")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (generacionDocumentosSiniestrosBean.getOrdenarPor().equals("Producto")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (generacionDocumentosSiniestrosBean.getOrdenarPor().equals("Fecha de Ocurrencia")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (generacionDocumentosSiniestrosBean.getOrdenarPor().equals("Estado del siniestro")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (generacionDocumentosSiniestrosBean.getNumSiniestro() != null){
                Thread.sleep(1000);
                WebElement numSiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                numSiniestro.sendKeys(generacionDocumentosSiniestrosBean.getNumSiniestro());
            }

            if (generacionDocumentosSiniestrosBean.getNumPoliza() != null){
                Thread.sleep(1000);
                WebElement numPoliza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[8]/input"));
                numPoliza.sendKeys(generacionDocumentosSiniestrosBean.getNumPoliza());
            }

            if (generacionDocumentosSiniestrosBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(1000);
                WebElement fechaOcurrenciaSiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[6]/div/input"));
                fechaOcurrenciaSiniestro.sendKeys(generacionDocumentosSiniestrosBean.getFechaOcurrenciaSiniestro());


            }

            String productos = "VidaDeudoresAvVillas";

            if (generacionDocumentosSiniestrosBean.getProducto() != null){
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
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);

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

    private void ResultadoBusqueda(WebDriver driver, GeneracionDocumentosSiniestrosBean generacionDocumentosSiniestrosBean, Metodos a, int i) {
        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);


        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void GeneracionDocumento(WebDriver driver, GeneracionDocumentosSiniestrosBean generacionDocumentosSiniestrosBean, Metodos a, int i) {
        try{
            Thread.sleep(15000);
            WebElement btnSeleccionarCover  = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            btnSeleccionarCover.click();

            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion);

            WebElement btnDocumentos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_27\"]"));
            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion);
            btnDocumentos.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);


            Thread.sleep(1000);
            WebElement btnDoc = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[2]/td[2]/input"));
            btnDoc.click();

            Thread.sleep(3000);
            a.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion);

            Thread.sleep(1000);
            WebElement btnSubmit = driver.findElement(By.xpath("//*[@id=\"idb_0402006_menuCorrespondence_01\"]"));
            btnSubmit.click();

            Thread.sleep(15000);
            a.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion);

            Thread.sleep(2000);
            WebElement btnDocpdf = driver.findElement(By.xpath("/html/body/center/a"));
            btnDocpdf.click();

            Thread.sleep(1000);
            a.changeLastWindows(driver);
        }
        catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
