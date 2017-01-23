package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_PrevisualizacionCuentaTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by aazuaje on 09/12/2016.
 */
public class INTER_PrevisualizacionCuentaTecnica {

    private final static Logger log = Logger.getLogger(INTER_PrevisualizacionCuentaTecnica.class);

    public String nombreAutomatizacion ="Previsualizacion Cuenta Tecnica";
    private WebDriver driver;

    public void testLink (INTER_PrevisualizacionCuentaTecnicaBean inter_previsualizacionCuentaTecnicaBean, int i, String folderName){

        try {

            //Metodos a = new Metodos();
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();


            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.CoaRea_CuentasTecnicas_PrevisualizacionCuentasTecnicas(driver, nombreAutomatizacion, 3, i);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            PrevisualizacionCuentaTecnica(a, inter_previsualizacionCuentaTecnicaBean, i, folderName, 4, 5, 6, 7);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }


    }

    public void PrevisualizacionCuentaTecnica(Interseguros_Metodos a, INTER_PrevisualizacionCuentaTecnicaBean inter_previsualizacionCuentaTecnicaBean, int i, String folderName,
                                              int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

        try {
            Thread.sleep(2000);

            if (inter_previsualizacionCuentaTecnicaBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[3]/td[2]/input[1]"));
                fechaDesde.sendKeys(inter_previsualizacionCuentaTecnicaBean.getFechaDesde());
            }

            if (inter_previsualizacionCuentaTecnicaBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[3]/td[4]/input[1]"));
                fechaHasta.sendKeys(inter_previsualizacionCuentaTecnicaBean.getFechaHasta());
            }

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            WebElement seleccReasegurador = driver.findElement(By.xpath("//*[@id=\"centerPanel\"]/div[2]/div/div[9]/div/div/div/div[3]/div[1]/table/tbody/tr[1]/td[4]/div"));
            seleccReasegurador.click();

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);

            Thread.sleep(2000);

            WebElement btnConsultar = driver.findElement(By.xpath("//*[@id=\"btnQueryPCT\"]/span/span"));
            btnConsultar.click();

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);

            Thread.sleep(2000);

            WebElement btnDetalle = driver.findElement(By.xpath("//*[@id=\"centerPanel\"]/div[2]/div/div[5]/div/div/div/div[3]/div[1]/table/tbody/tr[1]/td[3]/div/div/div[1]/div/span/span"));
            btnDetalle.click();

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}