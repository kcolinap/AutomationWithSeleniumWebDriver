package AcseleV13_8.main.controller;

import AcseleV13_8.beans.BeneficiarioJuridicoATerceroNaturalBean;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 13/07/2016.
 */
public class BeneficiarioJuridicoATerceroNatural {

    private final static Logger log = Logger.getLogger(BeneficiarioJuridicoATerceroNatural.class);

    public String nombreAutomatizacion = "Beneficiario Juridico A Natural";

    public void testLink(BeneficiarioJuridicoATerceroNaturalBean beneficiarioJuridicoATerceroNaturalBean, int i) throws IOException, InterruptedException {
        //Inicio de sesión
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Consulta del Tercero Creado
        IngresarMenuBuscarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, beneficiarioJuridicoATerceroNaturalBean); //Busqueda Tercero

        // Boton Editar
        WebElement botoneditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
        botoneditar.click();
        Thread.sleep(3000);

        ValidarAsignarRol(a, driver, beneficiarioJuridicoATerceroNaturalBean); //Asignación de Rol Natural
        a.regresarVentana(driver);

        Thread.sleep(2000);
        a.cambiarVentana(driver);

    }

    public void IngresarMenuBuscarTercero(WebDriver driver, Metodos a) throws IOException, InterruptedException {

        try {
            WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
            WebElement menu2 = driver.findElement(By.xpath("/html/body/div[36]/div[2]"));//Mantenimiento de terceros
            WebElement menu3 = driver.findElement(By.xpath("/html/body/div[37]/div[2]"));//buscar tercero
            menu1.click();
            menu2.click();
            a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
            menu3.click();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Beneficiario Juridico A Terceros Natural- " + e);
        }
    }

    public void BusquedaT(Metodos a, WebDriver driver, BeneficiarioJuridicoATerceroNaturalBean beneficiarioJuridicoATerceroNaturalBean) throws InterruptedException, IOException {

        try{
            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (beneficiarioJuridicoATerceroNaturalBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(beneficiarioJuridicoATerceroNaturalBean.getTipoTercero());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (beneficiarioJuridicoATerceroNaturalBean.getTipoDocId() != null){
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(beneficiarioJuridicoATerceroNaturalBean.getTipoDocId());
            }

            if (beneficiarioJuridicoATerceroNaturalBean.getNit() != null) {
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                nit.sendKeys(beneficiarioJuridicoATerceroNaturalBean.getNit());
            }

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            // WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(3000);

            // WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            Thread.sleep(1000);
            //Screenshot
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();



        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Beneficiario Juridico A Terceros Natural - " + e);
        }

    }

    public void ValidarAsignarRol(Metodos a, WebDriver driver, BeneficiarioJuridicoATerceroNaturalBean beneficiarioJuridicoATerceroNaturalBean) throws IOException, InterruptedException {

        try {
            if (beneficiarioJuridicoATerceroNaturalBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                Select tipoRol = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_rolComb']")));
                tipoRol.selectByValue(beneficiarioJuridicoATerceroNaturalBean.getRol());
            }
            //Screenshot
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            // Boton Agregar

            WebElement botonAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_rolForm_AddButton']"));
            botonAgregar.click();
            Thread.sleep(2000);

            // Boton Guardar
            WebElement botonGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelRol_templateContainer_rolTempForm_saveButton']"));
            botonGuardar.click();
            Thread.sleep(2000);

            //Screenshot
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case ?? - Beneficiario Juridico A Natural - " + e);
        }
    }

}
