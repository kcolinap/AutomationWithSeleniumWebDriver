package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ConsultaTercerosBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 30/05/2016.
 */

public class ConsultaTerceros {

    private final static Logger log = Logger.getLogger(ConsultaTerceros.class);

    public String nombreAutomatizacion ="Consulta Terceros";

    public void testLink(ConsultaTercerosBean consultaTercerosBean, int i)throws Exception {

        try {

            // Instanciando clases
            Metodos a= new Metodos();   //implementando metodos.
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(a,driver,nombreAutomatizacion, 2);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, consultaTercerosBean, i);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTercero(Metodos a, WebDriver driver, ConsultaTercerosBean consultaTercerosBean, int i) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (consultaTercerosBean.getTipoTercero() != null) {
                Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                tipoT.selectByValue(consultaTercerosBean.getTipoTercero());
                Thread.sleep(1000);
            }

            if (consultaTercerosBean.getTipoDocId() != null){
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(consultaTercerosBean.getTipoDocId());
                Thread.sleep(1000);
            }

            if (consultaTercerosBean.getCedula() != null){
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(consultaTercerosBean.getCedula());
                Thread.sleep(1000);
            }

            if (consultaTercerosBean.getNombre() != null){
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(consultaTercerosBean.getNombre());
                Thread.sleep(3000);
            }

            if (consultaTercerosBean.getApellido() != null ){
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                aTercero.sendKeys(consultaTercerosBean.getApellido());
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
