package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_TercerosInfTecnicaBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
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
public class LBC_TercerosInfTecnica {
    private final static Logger log = Logger.getLogger(LBC_TercerosInfTecnica.class);

    public String nombreAutomatizacion = "Informacion Tecnica de LBC_Terceros";

    public void testLink(LBC_TercerosInfTecnicaBean lbcTercerosInfTecnicaBean, int i)throws Exception{

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuMantenimiento lbcMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Consulta del Tercero Creado
            lbcMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, lbcTercerosInfTecnicaBean, i); //Busqueda Tercero

            // Boton Inf Tecnica
            driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']")).click();
            Thread.sleep(20000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(LBC_Metodos a, WebDriver driver, LBC_TercerosInfTecnicaBean lbcTercerosInfTecnicaBean, int i) throws InterruptedException, IOException{

        try {

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (lbcTercerosInfTecnicaBean.getTipoTerceros() != null) {
                Thread.sleep(3000);
                Select tipoTerceros = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoTerceros.selectByValue(lbcTercerosInfTecnicaBean.getTipoTerceros());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (lbcTercerosInfTecnicaBean.getApellido() != null) {
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                apellido.sendKeys(lbcTercerosInfTecnicaBean.getApellido());
            }
            Thread.sleep(2000);

            if (lbcTercerosInfTecnicaBean.getNombre() != null) {
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                nombre.sendKeys(lbcTercerosInfTecnicaBean.getNombre());
            }
            Thread.sleep(2000);
            if (lbcTercerosInfTecnicaBean.getTipoDocIdentificacion() != null) {
                Select tipoDocIdentificacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDocIdentificacion.selectByValue(lbcTercerosInfTecnicaBean.getTipoDocIdentificacion());
            }

            Thread.sleep(2000);

            if (lbcTercerosInfTecnicaBean.getNumDocIdentificacion()!= null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                cedu.sendKeys(lbcTercerosInfTecnicaBean.getNumDocIdentificacion());
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
