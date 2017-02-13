package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CerrarSiniestroBean;
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
 * Created by aazuaje on 28/12/2016.
 */
public class INTER_CerrarSiniestro {

    private final static Logger log = Logger.getLogger(INTER_CerrarSiniestro.class);
    private WebDriver driver;

    public String nombreAutomatizacion = "Cerrar Siniestro";

    public void testLink(INTER_CerrarSiniestroBean inter_cerrarSiniestroBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            //implementando clase de metodos
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            m.OpeSini_MantenimientoSiniestro(driver,a , nombreAutomatizacion,2, i, folderName);
            Thread.sleep(10000);

            a.cambiarVentana(driver);
            BuscarPoliza(a, inter_cerrarSiniestroBean, i, folderName,3 );
            ResultadoBusqueda(a, inter_cerrarSiniestroBean, i, folderName,4 );
            CerrarSiniestro(a, inter_cerrarSiniestroBean, i, folderName, 5, 6);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarPoliza(Interseguros_Metodos a, INTER_CerrarSiniestroBean inter_cerrarSiniestroBean, int i, String folderName, int numScreenShoot) throws IOException, InterruptedException{

        try {

            if (inter_cerrarSiniestroBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (inter_cerrarSiniestroBean.getOrdenarPor() == "Número de Reclamo"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (inter_cerrarSiniestroBean.getOrdenarPor() == "Producto"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (inter_cerrarSiniestroBean.getOrdenarPor() == "Fecha de Ocurrencia"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (inter_cerrarSiniestroBean.getOrdenarPor() == "Estado del siniestro"){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (inter_cerrarSiniestroBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numSiniestro.sendKeys(inter_cerrarSiniestroBean.getNumeroSiniestro());
            }

            if (inter_cerrarSiniestroBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numPoliza.sendKeys(inter_cerrarSiniestroBean.getNumeroPoliza());
            }

            if (inter_cerrarSiniestroBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaOcurrenciaSiniestro  = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaOcurrenciaSiniestro.sendKeys(inter_cerrarSiniestroBean.getFechaOcurrenciaSiniestro());
            }

            String productos = "EducacionGarantizada";

            if (inter_cerrarSiniestroBean.getProducto() != null){
                //if (editarSiniestrosBean.getProducto() == productos){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[8]/td/span"));
                producto.click();
                //}
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnBuscar  = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));
            btnBuscar.click();

            Thread.sleep(4000);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ResultadoBusqueda(Interseguros_Metodos a, INTER_CerrarSiniestroBean inter_cerrarSiniestroBean, int i, String folderName,  int numScreenShoot2) throws IOException, InterruptedException{

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[6]/td[3]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(15000);
            a.changeLastWindows(driver);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void CerrarSiniestro(Interseguros_Metodos a, INTER_CerrarSiniestroBean inter_cerrarSiniestroBean, int i, String folderName, int numScreenShoot3, int numScreenShoot4) throws IOException, InterruptedException{
        try{

            Thread.sleep(2000);
            // Xpath viejo //*[@id="idb_0402006_structure_29"]
            WebElement btnRechazar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_07\"]"));
            btnRechazar.click();
            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Select motivoCierre = new Select(driver.findElement(By.xpath("//*[@id=\"MotivoRechazo\"]")));
            motivoCierre.selectByValue(inter_cerrarSiniestroBean.getMotivoCierre());
            Thread.sleep(2000);

            if (inter_cerrarSiniestroBean.getComentariosSiniestro() != null){
                Thread.sleep(2000);
                WebElement comentarioSiniestro = driver.findElement(By.xpath("//*[@id=\"ComentariosStro\"]"));
                comentarioSiniestro.sendKeys(inter_cerrarSiniestroBean.getComentariosSiniestro());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(3000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[4]/input"));
            btnAceptar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }

            if (ExpectedConditions.alertIsPresent() != null) {
                Thread.sleep(1000);
                Alert alert = driver.switchTo().alert();
                alert.accept();
                Thread.sleep(1000);
                driver.switchTo().defaultContent();
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }




}
