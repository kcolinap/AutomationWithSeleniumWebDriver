package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.TercerosInfTecnicaLBCBean;
import AcseleV13_8LBC.main.controller.Menu.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;
/**
 * Created by aazuaje on 21/10/2016.
 */
public class TercerosInfTecnicaLBC {
    private final static Logger log = Logger.getLogger(TercerosInfTecnicaLBC.class);

    public String nombreAutomatizacion = "Informacion Tecnica de LBC_Terceros";

    public void testLink(TercerosInfTecnicaLBCBean tercerosInfTecnicaLBCBean, int i)throws Exception{

        try {

            // Instanciando clases
            MetodosLBC a = new MetodosLBC();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Consulta del Tercero Creado
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, tercerosInfTecnicaLBCBean, i); //Busqueda Tercero

            // Boton Inf Tecnica
            driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']")).click();
            Thread.sleep(20000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(MetodosLBC a, WebDriver driver, TercerosInfTecnicaLBCBean tercerosInfTecnicaLBCBean, int i) throws InterruptedException, IOException{

        try {

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosInfTecnicaLBCBean.getTipoTerceros() != null) {
                Thread.sleep(3000);
                Select tipoTerceros = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoTerceros.selectByValue(tercerosInfTecnicaLBCBean.getTipoTerceros());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (tercerosInfTecnicaLBCBean.getApellido() != null) {
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                apellido.sendKeys(tercerosInfTecnicaLBCBean.getApellido());
            }
            Thread.sleep(2000);

            if (tercerosInfTecnicaLBCBean.getNombre() != null) {
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                nombre.sendKeys(tercerosInfTecnicaLBCBean.getNombre());
            }
            Thread.sleep(2000);
            if (tercerosInfTecnicaLBCBean.getTipoDocIdentificacion() != null) {
                Select tipoDocIdentificacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDocIdentificacion.selectByValue(tercerosInfTecnicaLBCBean.getTipoDocIdentificacion());
            }

            Thread.sleep(2000);

            if (tercerosInfTecnicaLBCBean.getNumDocIdentificacion()!= null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                cedu.sendKeys(tercerosInfTecnicaLBCBean.getNumDocIdentificacion());
            }

            //Screenshot
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            //WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));/***/
            buscar.click();
            Thread.sleep(10000);

            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();
            Thread.sleep(2000);

            //Screenshot
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
