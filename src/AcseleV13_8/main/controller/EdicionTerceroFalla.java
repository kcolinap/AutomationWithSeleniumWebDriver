package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EdicionTercerosFallaBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 31/05/2016.
 */
// Cambio de Documento de Identidad por uno existente
public class EdicionTerceroFalla {

    private final static Logger log = Logger.getLogger(EdicionTerceroFalla.class);

    public String nombreAutomatizacion ="Edicion LBC_Terceros Falla";

    public void testLink(EdicionTercerosFallaBean edicionTercerosFallaBean, int i)throws Exception {

        try {

            // Instanciando clases
            Metodos13_8 a= new Metodos13_8();   //implementando metodos.
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, edicionTercerosFallaBean, i);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTercero(Metodos13_8 a, WebDriver driver, EdicionTercerosFallaBean edicionTercerosFallaBean, int i) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (edicionTercerosFallaBean.getTipoTercero() != null){
                Select tipoT = new Select(driver.findElement(By.name("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(edicionTercerosFallaBean.getTipoTercero());
                Thread.sleep(1000);
            }

            if (edicionTercerosFallaBean.getTipoDocIdentidad() != null){
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(edicionTercerosFallaBean.getTipoDocIdentidad());
                Thread.sleep(1000);
            }

            if (edicionTercerosFallaBean.getCedula() != null){
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(edicionTercerosFallaBean.getCedula());
                Thread.sleep(1000);
            }

            if (edicionTercerosFallaBean.getNombre() != null){
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(edicionTercerosFallaBean.getNombre());
                Thread.sleep(3000);
            }

            if (edicionTercerosFallaBean.getApellido() != null ){
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                aTercero.sendKeys(edicionTercerosFallaBean.getApellido());
                Thread.sleep(1000);
            }

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(3000);

            WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            selccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

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
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

            // Cambiar Cedula
            if (edicionTercerosFallaBean.getCedulaNuevo() != null){
                driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field")).clear();
                driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field")).sendKeys(edicionTercerosFallaBean.getCedulaNuevo());
                Thread.sleep(2000);
            }

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);

            // Boton Guardar
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']")).click();

            Thread.sleep(3000);
            //Screenshot
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}
