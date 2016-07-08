package main.controller;

import beans.ConsultaTercerosBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 30/05/2016.
 */
public class ConsultaTerceros {


    //Tercero a buscar
//    String tipoTercero = "PersonaNatural"; //PersonaNatural, PersonaJuridica
//    String cedula = "51800600";
//    String nombreT = "Edna";
//    String apellidoT = "Alvarez";

    //@Test
    public void testLink(ConsultaTercerosBean consultaTercerosBean)throws Exception {

        String nombreAutomatizacion ="Consulta Terceros";

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

        BuscarTercero(a, driver, nombreAutomatizacion, consultaTercerosBean);

    }

    public void BuscarTercero(Metodos a, WebDriver driver, String nombreAutomatizacion, ConsultaTercerosBean consultaTercerosBean)
                throws InterruptedException, IOException {
        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);
        //Tipo de tercero
        Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
        tipoT.selectByValue(consultaTercerosBean.getTipoTercero());
        Thread.sleep(2000);

        //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
        WebElement cedu = driver.findElement(By.xpath("//*[@id=\"id16\"]"));
        cedu.sendKeys(consultaTercerosBean.getCedula());

        WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
        nTercero.sendKeys(consultaTercerosBean.getNombre());
        WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
        aTercero.sendKeys(consultaTercerosBean.getApellido());

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        WebElement buscar = driver.findElement(By.name("searchButton"));
        buscar.click();
        Thread.sleep(3000);



        WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
        selccionTercero.click();

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);

        WebElement consultar = driver.findElement(By.name("consultThirdButton"));
        consultar.click();

        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);

    }
}
