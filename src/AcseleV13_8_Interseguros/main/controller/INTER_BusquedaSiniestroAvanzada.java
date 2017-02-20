package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_BusquedaSiniestroAvanzadaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sun.awt.windows.ThemeReader;

import java.io.IOException;

/**
 * Created by aazuaje on 23/01/2017.
 */
public class    INTER_BusquedaSiniestroAvanzada {

    private final static Logger log = Logger.getLogger(INTER_BusquedaSiniestroAvanzada.class);

    public String nombreAutomatizacion = "Busqueda Siniestros Avanzada";
    private WebDriver driver;

    public void testLink (INTER_BusquedaSiniestroAvanzadaBean inter_busquedaSiniestroAvanzadaBean, int i, String folderName)  throws IOException, InterruptedException {

        try{
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.OpeSini_MantenimientoSiniestro(driver,a , nombreAutomatizacion,2, i, folderName);
            Thread.sleep(3000);
            a.cambiarVentana(driver);

            //Aqui se especifican los 3 metodos de busqueda avanzada. Por defecto se deja el primero
            BuscarSiniestro(a, inter_busquedaSiniestroAvanzadaBean, i, folderName, 3, 4, 5);
            //BuscarSiniestroPoliza (a, inter_busquedaSiniestroAvanzadaBean, i, folderName, 3, 4, 5);
            //BuscarSiniestroTercero (a, inter_busquedaSiniestroAvanzadaBean, i, folderName, 3, 4, 5);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            // Thread.sleep(1500);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BuscarSiniestro(Interseguros_Metodos a, INTER_BusquedaSiniestroAvanzadaBean inter_busquedaSiniestroAvanzadaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            Thread.sleep(1000);
            WebElement buscarAvanzado  = driver.findElement(By.xpath("//*[@id=\"buttonAdvancedSearch\"]/span/span"));
            buscarAvanzado.click();

            //
            /*if (inter_busquedaSiniestroSimpleBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("/*//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(inter_busquedaSiniestroAvanzadaBean.getOrdenarPor());
            }*/

            Thread.sleep(2000);
            //String productos = "DotalSimple";

            if (inter_busquedaSiniestroAvanzadaBean.getProducto() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoAdvancedSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(1000);
                WebElement producto  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[7]/td/span"));
                producto.click();
                //}
            }

            //String eventoSiniestros = "Fallecimiento";

            if (inter_busquedaSiniestroAvanzadaBean.getEventoSiniestro() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar1 = driver.findElement(By.xpath("//*[@id=\"comboEventoSiniestro\"]/div"));
                btnSeleccionar1.click();
                Thread.sleep(1000);
                WebElement eventoSiniestro  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td"));
                eventoSiniestro.click();
                //}
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[5]/td[3]/div"));
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

    public void BuscarSiniestroPoliza(Interseguros_Metodos a, INTER_BusquedaSiniestroAvanzadaBean inter_busquedaSiniestroAvanzadaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            Thread.sleep(1000);
            WebElement buscarAvanzado  = driver.findElement(By.xpath("//*[@id=\"buttonAdvancedSearch\"]/span/span"));
            buscarAvanzado.click();

            Thread.sleep(2000);

            //String productos = "Lima";

            if (inter_busquedaSiniestroAvanzadaBean.getOficina() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar2 = driver.findElement(By.xpath("//*[@id=\"Oficina\"]/div"));
                btnSeleccionar2.click();
                Thread.sleep(1000);
                WebElement oficina  = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[2]/td"));
                oficina.click();
                //}
            }

            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[5]/td[3]/div"));
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


    public void BuscarSiniestroTercero(Interseguros_Metodos a, INTER_BusquedaSiniestroAvanzadaBean inter_busquedaSiniestroAvanzadaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            Thread.sleep(1000);
            WebElement buscarAvanzado  = driver.findElement(By.xpath("//*[@id=\"buttonAdvancedSearch\"]/span/span"));
            buscarAvanzado.click();

            Thread.sleep(2000);

            //String terceros = "PersonaNatural";

            if (inter_busquedaSiniestroAvanzadaBean.getTipoTercero() != null){
                Thread.sleep(1000);
                WebElement btnSeleccionar3 = driver.findElement(By.xpath("/*//*[@id=\"comboThirdPartyType\"]/div"));
                btnSeleccionar3.click();
                Thread.sleep(1000);
                WebElement tipoTercero  = driver.findElement(By.xpath("/*//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[3]/td"));
                tipoTercero.click();
                //}
            }

            Thread.sleep(2000);

            if (inter_busquedaSiniestroAvanzadaBean.getApellido() != null){
                WebElement apellido = driver.findElement(By.xpath("/*//*[@id=\"Apellido\"]"));
                apellido.sendKeys(inter_busquedaSiniestroAvanzadaBean.getApellido());
            }

            Thread.sleep(1000);
            if (inter_busquedaSiniestroAvanzadaBean.getNombre() != null){
                WebElement nombre = driver.findElement(By.xpath("/*//*[@id=\"Nombre\"]"));
                nombre.sendKeys(inter_busquedaSiniestroAvanzadaBean.getNombre());
            }
            Thread.sleep(2000);

            //String rol = "Asegurado";

            if (inter_busquedaSiniestroAvanzadaBean.getRol() != null){
                Thread.sleep(3000);
                WebElement btnSeleccionar4 = driver.findElement(By.xpath("//*[@id=\"comboRol\"]/div"));
                btnSeleccionar4.click();
                Thread.sleep(1000);
                WebElement rol1  = driver.findElement(By.xpath("/*//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[4]/td/span"));
                rol1.click();
                //}
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(10000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[5]/td[3]/div"));
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

}
