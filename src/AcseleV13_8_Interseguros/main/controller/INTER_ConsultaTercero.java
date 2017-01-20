package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaTerceroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by rmontilla on 14/11/2016.
 */
public class INTER_ConsultaTercero {

    private final static Logger log = Logger.getLogger(INTER_ConsultaTercero.class);

    public String nombreAutomatizacion ="INTER Consulta Terceros";
    private WebDriver driver;

    public void testLink(INTER_ConsultaTerceroBean inter_consultaTerceroBean, int i, String folderName)throws Exception {

        try {

            // Instanciando clases
            Interseguros_Metodos a= new Interseguros_Metodos();   //implementando metodos.
            Interseguros_MenuMantenimiento interseguros_menuMantenimiento = new Interseguros_MenuMantenimiento();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            interseguros_menuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion, i, 2, folderName);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, inter_consultaTerceroBean, i, folderName);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarTercero(Interseguros_Metodos a, WebDriver driver, INTER_ConsultaTerceroBean inter_consultaTerceroBean, int i, String folderName) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (inter_consultaTerceroBean.getTipoTercero() != null) {
                Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));

                if (inter_consultaTerceroBean.getTipoTercero().equals("Persona Natural")){

                    tipoT.selectByValue("PersonaNatural");
                    Thread.sleep(2000);
                }

                else if(inter_consultaTerceroBean.getTipoTercero().equals("Persona Juridica")){

                    tipoT.selectByValue("PersonaJuridica");
                    Thread.sleep(2000);
                }

                Thread.sleep(2000);
            }

            if (inter_consultaTerceroBean.getApellido() != null ){
                WebElement aTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[7]/div/div/input[2]"));
                aTercero.sendKeys(inter_consultaTerceroBean.getApellido());
                Thread.sleep(2000);
            }

            if (inter_consultaTerceroBean.getNombre() != null){
                WebElement nTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[8]/div/div/input[2]"));
                nTercero.sendKeys(inter_consultaTerceroBean.getNombre());
                Thread.sleep(3000);
            }

            if (inter_consultaTerceroBean.getCodIdenti() != null){
                Select Cod = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[25]/div/div/input[2]")));
                Cod.selectByValue(inter_consultaTerceroBean.getCodIdenti());
                Thread.sleep(2000);
            }

            if (inter_consultaTerceroBean.getNumDocId() != null){
                WebElement cedu = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[1]/div/div/input[2]"));
                cedu.sendKeys(inter_consultaTerceroBean.getNumDocId());
                Thread.sleep(2000);
            }


            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion, folderName);

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            WebElement seleccionTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr/td[1]/div/input"));
            seleccionTercero.click();

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion, folderName);

            // Boton Consultar
            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[2]/div/form/input[2]"));
            btnConsultar.click();

            Thread.sleep(1000);
            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            //Screenshot
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion, folderName);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }

    }

}
