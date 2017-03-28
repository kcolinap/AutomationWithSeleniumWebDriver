package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroBusquedaSimpleBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

/**
 * Created by kcolina on 16/03/2017.
 */
public class Asesuisa_SiniestroBusquedaSimple {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBusquedaSimple.class);
/*
    public String nombreAutomatizacion = "Busqueda simple de siniestro";
    private WebDriver driver;

    public void testLink(Asesuisa_SiniestroBusquedaSimpleBean asesuisaSiniestroBusquedaSimpleBean, int i,
                         String folderName){
        try {

            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion Mantenimiento de Siniestro
            menuOperaciones.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            BuscarSiniestro(driver, nombreAutomatizacion, 3,4,5,folderName);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarSiniestro(WebDriver driver, String nombreAutomatizacion,
                                Asesuisa_SiniestroBusquedaSimpleBean asesuisaSiniestroBusquedaSimpleBean, int screen1,
                                int screen2, int screen3, String folderName){
        try {

            //Capturar los campos con los que se realizara la busqueda
            if (asesuisaSiniestroBusquedaSimpleBean.getOrdenarPor()!=null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(asesuisaSiniestroBusquedaSimpleBean.getOrdenarPor());
                Thread.sleep(800);
            }

            if (asesuisaSiniestroBusquedaSimpleBean.getNroSiniestro()!=null){
                WebElement nroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                nroSiniestro.sendKeys(asesuisaSiniestroBusquedaSimpleBean.getNroSiniestro());
                Thread.sleep(800);
            }

            if (asesuisaSiniestroBusquedaSimpleBean.getFechaOcurrencia()!=null){
                WebElement fechaOcurrencia = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaOcurrencia.sendKeys(asesuisaSiniestroBusquedaSimpleBean.getFechaOcurrencia());
                Thread.sleep(800);
            }

            if (asesuisaSiniestroBusquedaSimpleBean.getNroPoliza()!=null){
                WebElement nroPoliza = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                nroPoliza.sendKeys(asesuisaSiniestroBusquedaSimpleBean.getNroPoliza());
                Thread.sleep(800);
            }

            if (asesuisaSiniestroBusquedaSimpleBean.getProducto()!=null){
                WebElement producto, btnSeleccionar;
                btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/div"));
                btnSeleccionar.click();
                Thread.sleep(500);
                producto = driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/input"));
                producto.s
            }
        }
    }*/
}
