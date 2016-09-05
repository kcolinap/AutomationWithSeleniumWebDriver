package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EdicionTercerosBuenosBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 31/05/2016.
 */
// Cambio de Nombre y Apellido
public class EdicionTerceroBueno {

    public String nombreAutomatizacion ="Edicion Terceros Buenos";

    public void testLink(EdicionTercerosBuenosBean edicionTercerosBuenosBean, int i)throws Exception {



        // Instanciando clases
        Metodos a= new Metodos();   //implementando metodos.
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

        Thread.sleep(1000);
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarTercero(a, driver, nombreAutomatizacion, edicionTercerosBuenosBean);

    }

    public void BuscarTercero(Metodos a, WebDriver driver, String nombreAutomatizacion, EdicionTercerosBuenosBean edicionTercerosBuenosBean)
            throws InterruptedException, IOException {
        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);
        //Tipo de tercero
        Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
        tipoT.selectByValue(edicionTercerosBuenosBean.getTipoTercero());
        Thread.sleep(2000);

        //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
        WebElement cedu = driver.findElement(By.xpath("//*[@id=\"id16\"]"));
        cedu.sendKeys(edicionTercerosBuenosBean.getCedula());

        WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
        nTercero.sendKeys(edicionTercerosBuenosBean.getNombre());
        /*WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
        aTercero.sendKeys(edicionTercerosBuenosBean.getApellido());*/

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

        // Cambiar Nombre
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).sendKeys(edicionTercerosBuenosBean.getNombreNuevo());

        // Cambiar Apellido
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).sendKeys(edicionTercerosBuenosBean.getApellidoNuevo());

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        // Boton Guardar
        driver.findElement(By.name("saveButton")).click();

    }
}
