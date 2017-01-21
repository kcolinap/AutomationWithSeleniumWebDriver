package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_RechazarSiniestroBean;
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
 * Created by aazuaje on 22/12/2016.
 */
public class INTER_RechazarSiniestro {

    private final static Logger log = Logger.getLogger(INTER_ReabrirSiniestro.class);

    public String nombreAutomatizacion = "Rechazar Siniestro";
    private WebDriver driver;

    public void testLink(INTER_RechazarSiniestroBean inter_rechazarSiniestroBean, int i, String folderName){

        try {

            //implementando clase de metodos
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            m.OpeSini_MantenimientoSiniestro(driver, a, nombreAutomatizacion, 3, i);
            Thread.sleep(10000);

            a.cambiarVentana(driver);
            BuscarPoliza(a, inter_rechazarSiniestroBean, i, folderName, 4);
            ResultadoBusqueda(a, inter_rechazarSiniestroBean, i, folderName, 5);
            RechazarSiniestro(a, inter_rechazarSiniestroBean, i, folderName, 6, 7);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarPoliza(Interseguros_Metodos a, INTER_RechazarSiniestroBean inter_rechazarSiniestroBean, int i, String folderName, int numScreenShoot){

        try {

            if (inter_rechazarSiniestroBean.getOrdenarPor() != null){
                Thread.sleep(1000);

                if (inter_rechazarSiniestroBean.getOrdenarPor().equals("Número de Reclamo")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td/span"));
                    ordenarPor.click();
                }

                if (inter_rechazarSiniestroBean.getOrdenarPor().equals("Producto")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                    ordenarPor.click();
                }

                if (inter_rechazarSiniestroBean.getOrdenarPor().equals("Fecha de Ocurrencia")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                    ordenarPor.click();
                }

                if (inter_rechazarSiniestroBean.getOrdenarPor().equals("Estado del siniestro")){
                    Thread.sleep(1000);
                    WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"orderBy\"]/div"));
                    btnSeleccionar1.click();
                    Thread.sleep(1000);
                    WebElement ordenarPor  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[5]/td/span"));
                    ordenarPor.click();
                }

            }

            if (inter_rechazarSiniestroBean.getNumeroSiniestro() != null){
                Thread.sleep(2000);
                WebElement numSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numSiniestro.sendKeys(inter_rechazarSiniestroBean.getNumeroSiniestro());
            }

            if (inter_rechazarSiniestroBean.getNumeroPoliza() != null){
                Thread.sleep(2000);
                WebElement numPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numPoliza.sendKeys(inter_rechazarSiniestroBean.getNumeroPoliza());
            }

            if (inter_rechazarSiniestroBean.getFechaOcurrenciaSiniestro() != null){
                Thread.sleep(2000);
                WebElement fechaOcurrenciaSiniestro  = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaOcurrenciaSiniestro.sendKeys(inter_rechazarSiniestroBean.getFechaOcurrenciaSiniestro());
            }

            String productos = "EducacionGarantizada";

            if (inter_rechazarSiniestroBean.getProducto() != null){
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

    public void ResultadoBusqueda(Interseguros_Metodos a, INTER_RechazarSiniestroBean inter_rechazarSiniestroBean, int i, String folderName, int numScreenShoot){

        try{
            Thread.sleep(1000);
            WebElement btnSeleccionarPoliza  = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[6]/td[3]/div"));
            btnSeleccionarPoliza.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            btnConsultar.click();

            Thread.sleep(15000);
            a.changeLastWindows(driver);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void RechazarSiniestro (Interseguros_Metodos a, INTER_RechazarSiniestroBean inter_rechazarSiniestroBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){
        try{

            Thread.sleep(2000);

            WebElement btnRechazar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_29\"]"));
            btnRechazar.click();
            Thread.sleep(20000);

            // Cambiar de frame
            driver.switchTo().frame("plantilla");

            Select motivoRechazo = new Select(driver.findElement(By.xpath("//*[@id=\"MotivoRechazo\"]")));
            motivoRechazo.selectByValue(inter_rechazarSiniestroBean.getMotivoRechazo());
            Thread.sleep(2000);

            if (inter_rechazarSiniestroBean.getComentariosSiniestro() != null){
                Thread.sleep(2000);
                WebElement comentarioSiniestro = driver.findElement(By.xpath("//*[@id=\"ComentariosStro\"]"));
                comentarioSiniestro.sendKeys(inter_rechazarSiniestroBean.getComentariosSiniestro());
            }

            if (inter_rechazarSiniestroBean.getNombreBeneficiario() != null){
                Thread.sleep(2000);
                WebElement nombreBeneficiario = driver.findElement(By.xpath("//*[@id=\"NombreBeneficiario\"]"));
                nombreBeneficiario.sendKeys(inter_rechazarSiniestroBean.getNombreBeneficiario());
            }

            if (inter_rechazarSiniestroBean.getDireccionBeneficiario() != null){
                Thread.sleep(2000);
                WebElement direccionBeneficiario = driver.findElement(By.xpath("//*[@id=\"DireccionBeneficiario\"]"));
                direccionBeneficiario.sendKeys(inter_rechazarSiniestroBean.getDireccionBeneficiario());
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();

            Thread.sleep(3000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/div[4]/input"));
            btnAceptar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

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
