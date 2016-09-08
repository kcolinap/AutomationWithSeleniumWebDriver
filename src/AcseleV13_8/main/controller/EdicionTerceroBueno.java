package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EdicionTercerosBuenosBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 31/05/2016.
 */
// Cambio de Nombre y Apellido
public class EdicionTerceroBueno {

    public String nombreAutomatizacion ="Edicion Terceros Buenos";

    public void testLink(EdicionTercerosBuenosBean edicionTercerosBuenosBean, int i)throws Exception {



        // Instanciando clases
        Metodos a= new Metodos();   //implementando metodos.
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

        Thread.sleep(1000);
        a.cambiarVentana(driver); // Cambiar de ventana

        BuscarTercero(a, driver, nombreAutomatizacion, edicionTercerosBuenosBean);

    }

    public void BuscarTercero(Metodos a, WebDriver driver, String nombreAutomatizacion, EdicionTercerosBuenosBean edicionTercerosBuenosBean)
            throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        Thread.sleep(1000);
        //Tipo de tercero
        if (edicionTercerosBuenosBean.getTipoTercero() != null){
            Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(edicionTercerosBuenosBean.getTipoTercero());
            Thread.sleep(1000);
        }

        if (edicionTercerosBuenosBean.getTipoDocIdentidad() != null){
            Select cedu = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            cedu.selectByValue(edicionTercerosBuenosBean.getTipoDocIdentidad());
            Thread.sleep(1000);
        }

        if (edicionTercerosBuenosBean.getCedula() != null){
            WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            cedu.sendKeys(edicionTercerosBuenosBean.getCedula());
            Thread.sleep(1000);
        }

        if (edicionTercerosBuenosBean.getNombre() != null){
            WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            nTercero.sendKeys(edicionTercerosBuenosBean.getNombre());
            Thread.sleep(1000);
        }

        //Screenshot
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
        buscar.click();
        Thread.sleep(3000);



        WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
        selccionTercero.click();

        //Screenshot
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);

        // Boton Editar
        WebElement consultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
        consultar.click();

        Thread.sleep(1000);
        /** Espere **/
        WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera.isDisplayed()) {
            Thread.sleep(5000);
            System.out.println("Espera 1");
        }

        //Screenshot
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);

        if (edicionTercerosBuenosBean.getNombreNuevo() != null){
            // Cambiar Nombre
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']")).clear();
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']")).sendKeys(edicionTercerosBuenosBean.getNombreNuevo());
            Thread.sleep(1000);
        }

        if (edicionTercerosBuenosBean.getApellidoNuevo() != null){
            // Cambiar Apellido
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']")).sendKeys(edicionTercerosBuenosBean.getApellidoNuevo());
            Thread.sleep(1000);
        }

        //Screenshot
        Thread.sleep(1000);
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);

        // Boton Guardar
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']")).click();

    }
}
