package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_TercerosInfTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_BuscarTerceros;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

/**
 * Created by mchurion on 14/12/2016.
 */
public class INTER_TercerosInfTecnica extends Inter_BuscarTerceros {
    private final static Logger log = Logger.getLogger(INTER_TercerosInfTecnica.class);

    public String nombreAutomatizacion = "Informacion Tecnica de INTER_Terceros";
    private WebDriver driver;

    public void testLink(INTER_TercerosInfTecnicaBean interTercerosInfTecnicaBean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();
            Inter_BuscarTerceros interBuscarTerceros = new Inter_BuscarTerceros();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            // Consulta del Tercero Creado
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
           // BusquedaT(a, interTercerosInfTecnicaBean, i, folderName, 3, 4); //Busqueda Tercero

            interBuscarTerceros.BusquedaT(driver,a,interTercerosInfTecnicaBean,nombreAutomatizacion,i,folderName,3,4,5,6);
            Thread.sleep(2000);

           //Boton informacion tecnica
            InfTecnica(driver,a,i,folderName,7,8,9);
            Thread.sleep(2000);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }

    }

    public void InfTecnica(WebDriver driver, Metodos a, int i,String folderName, int screenShoot, int screenShoot2, int screenShoot3){

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try {
            WebElement btnInfTec = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']"));
            btnInfTec.click();
            Thread.sleep(5000);
            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(1500);
            a.ScreenShotPool(driver,i,"screen"+screenShoot,nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(1500);
            a.ScreenShotPool(driver,i,"screen"+screenShoot2,nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1500);
            a.ScreenShotPool(driver,i,"screen"+screenShoot3,nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

  /* *//* public void BusquedaT(Interseguros_Metodos a, INTER_TercerosInfTecnicaBean interTercerosInfTecnicaBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try {

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (interTercerosInfTecnicaBean.getTipoTerceros() != null) {
                Thread.sleep(3000);
                Select tipoTerceros = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoTerceros.selectByValue(interTercerosInfTecnicaBean.getTipoTerceros());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (interTercerosInfTecnicaBean.getNumDocIdentificacion()!= null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                cedu.sendKeys(interTercerosInfTecnicaBean.getNumDocIdentificacion());
            }
            Thread.sleep(2000);

            if (interTercerosInfTecnicaBean.getApellido() != null) {
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                apellido.sendKeys(interTercerosInfTecnicaBean.getApellido());
            }
            Thread.sleep(2000);

            if (interTercerosInfTecnicaBean.getNombre() != null) {
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nombre.sendKeys(interTercerosInfTecnicaBean.getNombre());
            }
            //Thread.sleep(2000);


            //Screenshot
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            //buscar.click();
           // Thread.sleep(10000);

            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();
            Thread.sleep(2000);

            //Screenshot
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }*/

}
