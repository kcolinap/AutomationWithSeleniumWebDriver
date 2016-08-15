package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.HistorialReclamosBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 02/08/2016.
 */
public class HistorialReclamos {

    private final static Logger log = Logger.getLogger(HistorialReclamos.class);

    public String nombreAutomatizacion = "Historial Reclamos";

    public void testLink(HistorialReclamosBean historialReclamosBean,int i) throws IOException, InterruptedException {

//implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        MenuHistorialReclamos(driver, a);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
        BuscarHistorialReclamos(driver, a, historialReclamosBean);


    }

    public void MenuHistorialReclamos (WebDriver driver, Metodos a) throws InterruptedException, IOException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[13]"));//historial reclamos

        menu1.click();
        menu2.click();
        Thread.sleep(3000);
        a.ScreenShot(driver,"screen3",nombreAutomatizacion);
        menu3.click();
    }

    public void BuscarHistorialReclamos (WebDriver driver, Metodos a, HistorialReclamosBean historialReclamosBean) throws IOException, InterruptedException {
        Thread.sleep(3000);
        WebElement numeroReclamo = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr[1]/td[2]/input"));
        numeroReclamo.sendKeys(historialReclamosBean.getNumeroReclamo());

        Thread.sleep(2000);
        a.ScreenShot(driver,"screen4",nombreAutomatizacion);

        WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimHistoryScrem_01\"]"));
        btnBuscar.click();

        Thread.sleep(4000);
        a.ScreenShot(driver,"screen5",nombreAutomatizacion);



    }
}




