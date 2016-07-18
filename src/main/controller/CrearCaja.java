package main.controller;

import beans.CrearCajaBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 14/07/2016.
 */
public class CrearCaja {

    private final static Logger log = Logger.getLogger(CrearCaja.class);

    public String nombreAutomatizacion = "Crear Caja";

    public void testLink(CrearCajaBean crearCajaBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(4000);

        // Consulta Caja
        IngresarMenuConsultarCaja(driver, a); //Menu
        Thread.sleep(2000);
        //Insertar(a, driver, crearCajaBean); //Crear nueva caja

        // Insertar Caja
/*        WebElement botoneditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
        botoneditar.click();*/
        driver.findElement(By.name("//*[@id=\"idb_040203703_casierRegisterMaintenance_03\"]")).click();
        Thread.sleep(3000);
        a.cambiarVentana(driver);
        Thread.sleep(3000);
        InsertarDatosCaja(a, driver, crearCajaBean); //Insertar Datos de Caja


    }

    public void IngresarMenuConsultarCaja(WebDriver driver, Metodos a) throws IOException, InterruptedException {

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[7]"));//Administrador de Cuentas Universal
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[38]/div[4]"));//Consultar Cajas
            menu1.click();
            menu2.click();
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            menu3.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Crear Caja- " + e);
        }
    }

    public void InsertarDatosCaja(Metodos a, WebDriver driver, CrearCajaBean crearCajaBean) throws InterruptedException, IOException {

        try{
            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            if (crearCajaBean.getDescripcion() != null) {
                WebElement descripcion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[1]/td[2]/input"));
                descripcion.sendKeys(crearCajaBean.getDescripcion());
            }
            if (crearCajaBean.getUbicacion() != null) {
                WebElement ubicacion = driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[2]/td[2]/input"));
                ubicacion.sendKeys(crearCajaBean.getUbicacion());
            }
            //Seleccionar Sucursal

            if (crearCajaBean.getSucursal() != null) {
                Thread.sleep(3000);
                Select tipoSucursal = new Select(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/table/tbody/tr[3]/td[2]/select")));
                tipoSucursal.selectByValue(crearCajaBean.getSucursal()); 
            }
            Thread.sleep(2000);

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Crear Caja - " + e);
        }

    }



}

