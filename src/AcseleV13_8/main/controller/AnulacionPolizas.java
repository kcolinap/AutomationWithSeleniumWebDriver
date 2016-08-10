package AcseleV13_8.main.controller;

import AcseleV13_8.beans.AnulacionPolizaBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 26/05/2016.
 */
public class AnulacionPolizas {

    String nombreAutomatizacion ="Anulacion de Poliza";
    //Poliza a buscar
    //String nPoliza = "EA00280";

    public void testLink(AnulacionPolizaBean anulacionPolizaBean)throws Exception{


        Metodos a= new Metodos();   //implementando metodos.
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));// Operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[2]"));// Operaciones polizas
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[6]/div[6]"));// Cotización-Suscripción-Mantenimiento de Pólizas
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
        menu3.click();
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarPoliza(a, driver, anulacionPolizaBean);


    }

    public void BuscarPoliza(Metodos a, WebDriver driver, AnulacionPolizaBean anulacionPolizaBean) throws InterruptedException, IOException {

        Thread.sleep(4000);
        //Campo del num de la poliza
        WebElement fieldNumPoliza = driver.findElement(By.name("policyNumber"));
        fieldNumPoliza.sendKeys(anulacionPolizaBean.getNumPoliza());

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        //Boton Buscar
        driver.findElement(By.name("searchButton")).click();

        Thread.sleep(10000);

        //Seleccionar Poliza
        driver.findElement(By.name("ConsultPolicy:ResultSearchSimplePolicy:groupPolicies")).click();

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);

        //Boton Cancelar Poliza
        driver.findElement(By.name("container:CancelPolicyButton")).click();

        Thread.sleep(5000);

        // Seleccionar Opcion = Anular
        Select menuOpcion = new Select(driver.findElement(By.name("EventSection:content:events:repeaterSelect:1:field")));
        menuOpcion.selectByValue(anulacionPolizaBean.getOpcion());

        //Fecha

        // Select MotivoAnulacion
        Select motivoAnulacion = new Select(driver.findElement(By.name("EventSection:content:Form:templateContainer:repeaterPanel:3:fila:repeaterSelect:1:field")));
        motivoAnulacion.selectByValue(anulacionPolizaBean.getMotivoAnulacion()); //Voluntad del Tomador / Asegurado

        //Observacion
        driver.findElement(By.name("EventSection:content:Form:templateContainer:repeaterPanel:4:fila:field")).sendKeys(anulacionPolizaBean.getObservacion());

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);

        //Boton Continuar
        driver.findElement(By.name("EventSection:content:Form:continueButton")).click();

        Thread.sleep(5000);
        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        // Boton Calcular
        driver.findElement(By.name("calculate")).click();
        Thread.sleep(6000);
        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);

        // Boton Aplicar
        driver.findElement(By.name("EventSection:content:CloseForm:ApplyPolicy")).click();
        Thread.sleep(15000);
        //Screenshot
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);

        System.out.println("Fin de la prueba");

    }

}
