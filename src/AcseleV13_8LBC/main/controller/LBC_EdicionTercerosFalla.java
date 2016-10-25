package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_EdicionTercerosFallaBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 15/10/2016.
 */
public class LBC_EdicionTercerosFalla {

    private final static Logger log = Logger.getLogger(LBC_EdicionTercerosFalla.class);

    public String nombreAutomatizacion ="Edicion Terceros LBC";

    public void testLink(LBC_EdicionTercerosFallaBean lbcEdicionTercerosFallaBean, int i)throws Exception {

        try {

            // Instanciando clases
            LBC_Metodos a= new LBC_Metodos();   //implementando metodos.
            LBC_MenuMantenimiento LBCMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            LBCMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, lbcEdicionTercerosFallaBean, i);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTercero(LBC_Metodos a, WebDriver driver, LBC_EdicionTercerosFallaBean lbcEdicionTercerosFallaBean, int i) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (lbcEdicionTercerosFallaBean.getTipoTercero() != null){
                Select tipoT = new Select(driver.findElement(By.name("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(lbcEdicionTercerosFallaBean.getTipoTercero());
                Thread.sleep(1000);
            }
            if (lbcEdicionTercerosFallaBean.getApellido() != null ){
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                aTercero.sendKeys(lbcEdicionTercerosFallaBean.getApellido());
                Thread.sleep(1000);
            }

            if (lbcEdicionTercerosFallaBean.getNombre() != null){
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(lbcEdicionTercerosFallaBean.getNombre());
                Thread.sleep(3000);
            }


            if (lbcEdicionTercerosFallaBean.getTipoDocId() != null){
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(lbcEdicionTercerosFallaBean.getTipoDocId());
                Thread.sleep(1000);
            }

            if (lbcEdicionTercerosFallaBean.getNumDocId() != null){
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(lbcEdicionTercerosFallaBean.getNumDocId());
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
            if (lbcEdicionTercerosFallaBean.getNumDocId() != null){
                driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field")).clear();
                driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field")).sendKeys(lbcEdicionTercerosFallaBean.getNumDocId());
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
