package AcseleV13_8.main.controller;
import AcseleV13_8.beans.ReabrirSiniestroBean;
import AcseleV13_8.beans.ValidacionSimbolosBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
/**
 * Created by aazuaje on 04/10/2016. public void BuscarPoliza(WebDriver driver, Metodos a, ReabrirSiniestroBean reabrirSiniestroBean, int i) throws IOException, InterruptedException{

 */
public class ValidacionSimbolos {

    private final static Logger log = Logger.getLogger(ReabrirSiniestro.class);

    public String nombreAutomatizacion = "Validacion Simbolos";

    public void testLink(ReabrirSiniestroBean reabrirSiniestroBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        Metodos a = new Metodos();
        MenuConfiguracion menuConfiguracion = new MenuConfiguracion();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        menuConfiguracion.MantenimientoProducto(driver, nombreAutomatizacion, 2);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);


        //IngresarProductTool(driver,a ,validacionSimbolosBean, i, 3);
        Thread.sleep(1000);
        //ImportTablaDinamica(a, driver, usoTablasDinamicasImportadasBean);
        Thread.sleep(1000);
        driver.close();



    }

    public void IngresarProductTool(WebDriver driver, Metodos a, ValidacionSimbolosBean validacionSimbolosBean, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5) throws IOException, InterruptedException{


        try {

            Thread.sleep(7000);
            WebElement seleccionProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li/div/a/span"));
            seleccionProducto.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement pestanaProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span"));
            pestanaProducto.click();

            Thread.sleep(2000);
            WebElement expandirCarpetaProducto1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/div/img[1]"));
            expandirCarpetaProducto1.click();

            Thread.sleep(2000);
            WebElement expandirCarpetaProducto2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/div/img[1]"));
            expandirCarpetaProducto2.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaPlanes = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/div/img[1]"));
            expandirCarpetaPlanes.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaPlVDeudoresVillas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/div/img[1]"));
            expandirCarpetaPlVDeudoresVillas.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaObjetosAsegurados = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/div/img[1]"));
            expandirCarpetaObjetosAsegurados.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaOaVDeudoresVillas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/div/img[1]"));
            expandirCarpetaOaVDeudoresVillas.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaCoberturas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/div/img[1]"));
            expandirCarpetaCoberturas.click();

            Thread.sleep(1000);
            WebElement seleccionarDesaparicionForzada = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/ul/li[1]/div/a/span"));
            seleccionarDesaparicionForzada.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            //WebElement btnEditar = driver.findElement(By.xpath(""));
            WebElement btnEditar = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/div/div/div/div/table/tbody/tr[4]/td/div/div/div/img"));
            btnEditar.click();

            Thread.sleep(3000);

            Thread.sleep(1000);
            WebElement seleccionFormula = driver.findElement(By.xpath("//div[18]/table/tbody/tr/td[4]/div"));
            seleccionFormula.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnEditarFormula = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td[2]/em/button"));
            btnEditarFormula.click();

            Thread.sleep(4000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);
            //WebElement campoFormula = driver.findElement(By.xpath("//div[24]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/form/table/tbody[2]/tr[2]/td/textarea"));
            WebElement campoFormula = driver.findElement(By.xpath("//*[@id=\"isc_3R\"]"));
            campoFormula.clear();
            //campoFormula.sendKeys(validacionSimbolosBean.getFormula());

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            //WebElement btnAceptar = driver.findElement(By.xpath("//div[20]/div/div[2]/div/div/div/div[2]/div/div/div/table/tbody/tr/td"));
            WebElement btnAceptar = driver.findElement(Sc.locator("scLocator=//IButton[ID=\"isc_OID_77\"]/"));
            btnAceptar.click();

            WebElement btnCancelar = driver.findElement(Sc.locator("scLocator=//IButton[ID=\"isc_OID_78\"]/"));
            btnCancelar.click();

            Thread.sleep(2000);

            WebElement btnSalvar = driver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button"));
            btnSalvar.click();





        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}




