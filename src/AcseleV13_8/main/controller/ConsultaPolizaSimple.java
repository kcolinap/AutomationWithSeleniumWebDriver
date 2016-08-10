package AcseleV13_8.main.controller;

import AcseleV13_8.beans.PolizaBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by agil on 26/05/2016.
 */
public class ConsultaPolizaSimple {

    String nombreAutomatizacion = "Consulta Poliza Simple";
    //Pliza a buscar
    //String nPoliza = "EA00222";


    public void testLink(PolizaBean polizaBean) throws Exception {

        Metodos a = new Metodos();   //implementando metodos.
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

        BuscarPolizaSimple(a, driver, polizaBean);
    }

    public void BuscarPolizaSimple(Metodos a, WebDriver driver, PolizaBean polizaBean) throws InterruptedException, IOException {

        Thread.sleep(3000);
        //Campo del num de la poliza
        WebElement fieldNumPoliza = driver.findElement(By.name("policyNumber"));
//        WebElement fieldNumPoliza = driver.findElement(By.xpath("//*[@id=\"idd\"]"));
        //fieldNumPoliza.sendKeys(nPoliza.getNumPoliza());
        fieldNumPoliza.sendKeys(polizaBean.getNumPoliza());

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        //Boton Buscar
        driver.findElement(By.name("searchButton")).click();

        Thread.sleep(10000);

        //Seleccionar Poliza
        driver.findElement(By.name("ConsultPolicy:ResultSearchSimplePolicy:groupPolicies")).click();

        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);

        //Boton Consultar Poliza
        driver.findElement(By.name("container:ConsultPolicyButton")).click();

        Thread.sleep(5000);

        System.out.println("Fin de la prueba");



    }

}
