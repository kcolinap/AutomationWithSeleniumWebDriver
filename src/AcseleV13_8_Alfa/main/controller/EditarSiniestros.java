package AcseleV13_8_Alfa.main.controller;

import AcseleV13_8_Alfa.beans.CancelarPagosBean;
import AcseleV13_8_Alfa.beans.EditarSiniestrosBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
/**
 * Created by aazuaje on 15/08/2016.
 */
public class EditarSiniestros {

    private final static Logger log = Logger.getLogger(EditarSiniestros.class);

    public String nombreAutomatizacion = "Editar Siniestros";

    public void testLink(EditarSiniestrosBean editarSiniestrosBean,int i) throws IOException, InterruptedException {

        //implementando clase de metodos
        AcseleV13_8_Alfa.main.controller.Metodos a = new AcseleV13_8_Alfa.main.controller.Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        MenuCreacionSiniestro(driver, a);
        Thread.sleep(8000);
        a.cambiarVentana(driver);
//        BuscarPoliza(driver, a, cancelarPagosBean);
//        ResultadoBusqueda(driver, a, cancelarPagosBean);
//        AgregarObjetoAfectado(driver, a, cancelarPagosBean);
//        AgregarCobertura(driver, a, cancelarPagosBean);
//        AgregarRequisitos(driver, a, cancelarPagosBean);
//        AgregarPagos(driver, a, cancelarPagosBean);

    }

    public void MenuCreacionSiniestro(WebDriver driver, Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[2]"));//operacion
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[5]/div[3]"));//operaciones siniestros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[10]/div[2]"));//mantenimiento de siniestro

        menu1.click();
        menu2.click();
        Thread.sleep(2000);
        a.ScreenShot(driver,"screen3",nombreAutomatizacion);
        Thread.sleep(3000);
        menu3.click();

    }



}
