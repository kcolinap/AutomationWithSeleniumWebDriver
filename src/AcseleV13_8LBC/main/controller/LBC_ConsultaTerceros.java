package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_ConsultaTercerosBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
/**
 * Created by aazuaje on 14/10/2016.
 */
public class LBC_ConsultaTerceros {

    private final static Logger log = Logger.getLogger(LBC_ConsultaTerceros.class);

    public String nombreAutomatizacion ="Consulta Terceros";

    public void testLink(LBC_ConsultaTercerosBean lbcConsultaTercerosBean, int i)throws Exception {

        try {

            // Instanciando clases
            LBC_Metodos a= new LBC_Metodos();   //implementando metodos.
            LBC_MenuMantenimiento LBCMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            LBCMenuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion, i, 2);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, lbcConsultaTercerosBean, i);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTercero(LBC_Metodos a, WebDriver driver, LBC_ConsultaTercerosBean lbcConsultaTercerosBean, int i) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (lbcConsultaTercerosBean.getTipoTercero() != null) {
                Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                tipoT.selectByValue(lbcConsultaTercerosBean.getTipoTercero());
                Thread.sleep(2000);
            }

            if (lbcConsultaTercerosBean.getApellido() != null ){
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                aTercero.sendKeys(lbcConsultaTercerosBean.getApellido());
                Thread.sleep(2000);
            }

            if (lbcConsultaTercerosBean.getNombre() != null){
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                nTercero.sendKeys(lbcConsultaTercerosBean.getNombre());
                Thread.sleep(3000);
            }

            if (lbcConsultaTercerosBean.getTipoDocId() != null){
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(lbcConsultaTercerosBean.getTipoDocId());
                Thread.sleep(2000);
            }

            if (lbcConsultaTercerosBean.getNumDocId() != null){
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                cedu.sendKeys(lbcConsultaTercerosBean.getNumDocId());
                Thread.sleep(2000);
            }


            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(3000);

            WebElement seleccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            seleccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

            // Boton Consultar
            WebElement btnConsultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_consultThirdButton']"));
            btnConsultar.click();

            Thread.sleep(1000);
            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            //Screenshot
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}