package main.controller;

import beans.EdicionTercerosFallaBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by agil on 31/05/2016.
 */

// Cambio de Documento de Identidad por uno existente
public class EdicionTerceroFalla {


    public void testLink(EdicionTercerosFallaBean edicionTercerosFallaBean)throws Exception {

        String nombreAutomatizacion ="Edicion Terceros Falla";

        Metodos a= new Metodos();   //implementando metodos.
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[2]"));//Mantenimiento de terceros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[36]/div[2]"));//ingresar tercero
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
        menu3.click();
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarTercero(a, driver, nombreAutomatizacion, edicionTercerosFallaBean);

    }

    public void BuscarTercero(Metodos a, WebDriver driver, String nombreAutomatizacion, EdicionTercerosFallaBean edicionTercerosFallaBean)
            throws InterruptedException, IOException {
        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);
        //Tipo de tercero
        Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
        tipoT.selectByValue(edicionTercerosFallaBean.getTipoTercero());
        Thread.sleep(2000);

        //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
        WebElement cedu = driver.findElement(By.xpath("//*[@id=\"id16\"]"));
        cedu.sendKeys(edicionTercerosFallaBean.getCedula());

        // Nombre Tercero
        WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
        nTercero.sendKeys(edicionTercerosFallaBean.getNombre());

        // Apellido Tercero
        WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
        Thread.sleep(1000);
        aTercero.sendKeys(edicionTercerosFallaBean.getApellido());

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        WebElement buscar = driver.findElement(By.name("searchButton"));
        buscar.click();
        Thread.sleep(3000);



        WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
        selccionTercero.click();

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);

        // Boton Editar
        WebElement consultar = driver.findElement(By.name("associateButton"));
        consultar.click();

        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);

        // Cambiar Cedula
        driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field")).sendKeys(edicionTercerosFallaBean.getCedulaNuevo());

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        // Boton Guardar
        driver.findElement(By.name("saveButton")).click();

        Thread.sleep(3000);
        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);

    }
}
