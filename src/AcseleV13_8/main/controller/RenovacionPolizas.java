package AcseleV13_8.main.controller;

import AcseleV13_8.beans.RenovacionPolizaBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by agil on 27/05/2016.
 */
public class RenovacionPolizas {

    String nombreAutomatizacion ="Renovacion de Poliza";
    //Pliza a buscar
    //String nPoliza = "F004"; //F0003, K514, D21, D22, K512, K510, LR270401, ED250406

    public void testLink(RenovacionPolizaBean renovacionPolizaBean)throws Exception{


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

        BuscarPoliza(a, driver, renovacionPolizaBean);


    }

    public void BuscarPoliza(Metodos a, WebDriver driver, RenovacionPolizaBean renovacionPolizaBean) throws InterruptedException, IOException {

        Thread.sleep(3000);
        //Campo del num de la poliza
        WebElement fieldNumPoliza = driver.findElement(By.name("policyNumber"));
//        WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
        //fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());
        fieldNumPoliza.sendKeys(renovacionPolizaBean.getNumPoliza());

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        //Boton Buscar
        driver.findElement(By.name("searchButton")).click();

        Thread.sleep(10000);

        //Seleccionar Poliza
        driver.findElement(By.name("ConsultPolicy:ResultSearchSimplePolicy:groupPolicies")).click();

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);

        //Boton Renovar Poliza
        driver.findElement(By.name("container:RenewPolicyButton")).click();

        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        // Boton Continuar
        driver.findElement(By.name("EventSection:content:Form:continueButton")).click();
        Thread.sleep(15000);

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        // Boton Calcular
        driver.findElement(By.xpath("//*[@id=\"id56\"]")).click();
        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        // Boton Aplicar
        driver.findElement(By.name("EventSection:content:CloseForm:ApplyPolicy")).click();
        Thread.sleep(15000);


        // Boton Ingnorar validaciones
        //driver.findElement(By.name("ErrorDialog:content:questionForm:check")).click();
        //Screenshot
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);
        Thread.sleep(1000);
        // Boton Continuar
        driver.findElement(By.name("ErrorDialog:content:questionForm:ignoreValidationButton")).click();
        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen9", nombreAutomatizacion);

    }
}
