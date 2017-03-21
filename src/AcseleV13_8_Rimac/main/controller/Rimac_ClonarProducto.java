package AcseleV13_8_Rimac.main.controller;

import AcseleV13_8_Rimac.beans.Rimac_ClonarProductoBean;
import AcseleV13_8_Rimac.main.controller.Rimac_Menu.Rimac_MenuConfiguracion;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

/**
 * Created by agil on 17/03/2017.
 */
public class Rimac_ClonarProducto {
    private final static Logger log = Logger.getLogger(Rimac_ClonarProducto.class);

    public String nombreAutomatizacion = "Clonar producto";
    private WebDriver driver;

    public void testLink(Rimac_ClonarProductoBean rimacClonarProductoBeanBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Rimac_MenuConfiguracion rimacMenuConfiguracion = new Rimac_MenuConfiguracion();


            driver = a.entrarPagina(a.UrlRimac());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(3000);

            //Entrando en Menu configuracion 'NuevoMantenimientoproducto'
            rimacMenuConfiguracion.NuevoMantenimientoProducto(driver, nombreAutomatizacion,2,i,folderName);//, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);


            Thread.sleep(4000);
            ClonarProducto(a, driver, rimacClonarProductoBeanBean, nombreAutomatizacion, i, folderName, 3, 4, 5);

            driver.quit();


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    //Metodo para clonaciopn del producto
    public void ClonarProducto(Metodos a, WebDriver driver, Rimac_ClonarProductoBean rimacClonarProductoBean,
                               String nombreAutomatizacion, int i, String folderName, int screen1, int screen2, int screen3){

        try {
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement producto, aux, txtNombre;
            Actions action = new Actions(driver);

            for(int j=1; j<500;j++){
                producto = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li["+j+"]/div/a/span"));
                if (producto.getText().equals(rimacClonarProductoBean.getNombreProducto())){
                    j+=17;
                    aux = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li["+j+"]/div/a/span"));
                    //System.out.println("Encontre el producto");
                    action.moveToElement(aux).perform();
                    Thread.sleep(500);
                    producto.click();
                    break;
                }
            }
            //pantallazo
            a.ScreenShotPool(driver,i,"screen"+screen1,nombreAutomatizacion,folderName);
            Thread.sleep(800);
            //Menu migracion

            WebElement menu1 = driver.findElement(By.xpath("html/body/div[1]/div/div/div/div/div/table[1]/tbody/tr/td[1]/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button"));//Migracion
            Thread.sleep(1000);
            action.moveToElement(menu1).build().perform();
            Thread.sleep(700);
            menu1.click();
            Thread.sleep(500);
            WebElement menu2 = driver.findElement(By.xpath("html/body/div[5]/ul/li[11]"));//clonar
            Thread.sleep(1000);
            action.moveToElement(menu2).build().perform();
            Thread.sleep(700);
            a.ScreenShotPool(driver, i, "screen" + screen2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            menu2.click();

            //Ingreso del nombre del producto clonado
            Thread.sleep(1500);
            txtNombre = driver.findElement(By.xpath("html/body/div[9]/div[2]/div[1]/div/div/div/div/div/div/div/div/div[1]/form/div/div[1]/input"));
            txtNombre.sendKeys(rimacClonarProductoBean.getNombreProductoClonado());
            Thread.sleep(1000);
            a.ScreenShotPool(driver,i,"screen"+screen3,nombreAutomatizacion,folderName);
            Thread.sleep(800);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
