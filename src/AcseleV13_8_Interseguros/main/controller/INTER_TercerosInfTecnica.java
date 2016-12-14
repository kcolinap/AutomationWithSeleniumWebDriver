package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_TercerosInfTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 14/12/2016.
 */
public class INTER_TercerosInfTecnica {
    private final static Logger log = Logger.getLogger(INTER_TercerosInfTecnica.class);

    public String nombreAutomatizacion = "Informacion Tecnica de INTER_Terceros";

    public void testLink(INTER_TercerosInfTecnicaBean interTercerosInfTecnicaBean, int i)throws Exception{

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Consulta del Tercero Creado
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, interTercerosInfTecnicaBean, i); //Busqueda Tercero

            // Boton Inf Tecnica
            driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']")).click();
            Thread.sleep(20000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(Interseguros_Metodos a, WebDriver driver, INTER_TercerosInfTecnicaBean interTercerosInfTecnicaBean, int i) throws InterruptedException, IOException {

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

            if (interTercerosInfTecnicaBean.getApellido() != null) {
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                apellido.sendKeys(interTercerosInfTecnicaBean.getApellido());
            }
            Thread.sleep(2000);

            if (interTercerosInfTecnicaBean.getNombre() != null) {
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                nombre.sendKeys(interTercerosInfTecnicaBean.getNombre());
            }
            Thread.sleep(2000);
            if (interTercerosInfTecnicaBean.getTipoDocIdentificacion() != null) {
                Select tipoDocIdentificacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDocIdentificacion.selectByValue(interTercerosInfTecnicaBean.getTipoDocIdentificacion());
            }

            Thread.sleep(2000);

            if (interTercerosInfTecnicaBean.getNumDocIdentificacion()!= null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                cedu.sendKeys(interTercerosInfTecnicaBean.getNumDocIdentificacion());
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
