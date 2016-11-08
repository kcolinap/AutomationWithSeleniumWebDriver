package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_ModosPagoTerceroBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by rmontilla on 03/11/2016.
 */
public class LBC_ModosPagoTercero {

    private final static Logger log = Logger.getLogger(LBC_ModosPagoTercero.class);

    public String nombreAutomatizacion ="LBC Modos de Pago de Terceros";

    public void testLink(LBC_ModosPagoTerceroBean lbc_ModosPagoTercerobean, int i)throws Exception {

        try {

            // Instanciando clases
            LBC_Metodos a= new LBC_Metodos();   //implementando metodos.
            LBC_MenuMantenimiento lbcMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            lbcMenuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion, i, 2);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, lbc_ModosPagoTercerobean, i);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BuscarTercero(LBC_Metodos a, WebDriver driver, LBC_ModosPagoTerceroBean lbc_ModosPagoTercerobean, int i) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (lbc_ModosPagoTercerobean.getTipoTercero() != null) {
                Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                tipoT.selectByValue(lbc_ModosPagoTercerobean.getTipoTercero());
                Thread.sleep(2000);
            }

            if (lbc_ModosPagoTercerobean.getApellido() != null ){
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                aTercero.sendKeys(lbc_ModosPagoTercerobean.getApellido());
                Thread.sleep(2000);
            }

            if (lbc_ModosPagoTercerobean.getNombre() != null){
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                nTercero.sendKeys(lbc_ModosPagoTercerobean.getNombre());
                Thread.sleep(3000);
            }

            if (lbc_ModosPagoTercerobean.getTipoDocId() != null){
                Select tipoDocId = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                tipoDocId.selectByValue(lbc_ModosPagoTercerobean.getTipoDocId());
                Thread.sleep(2000);
            }

            if (lbc_ModosPagoTercerobean.getNumDocId() != null){
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_field']"));
                cedu.sendKeys(lbc_ModosPagoTercerobean.getNumDocId());
                Thread.sleep(2000);
            }


            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(3000);

            WebElement seleccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            seleccionTercero.click();


            // Boton Editar
            WebElement btnEditar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[2]/div/form/input[1]"));
            btnEditar.click();
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Thread.sleep(4000);

            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            if (lbc_ModosPagoTercerobean.getModoPago() != null){

                Select selecpago = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/select")));

                if (lbc_ModosPagoTercerobean.getModoPago().equals("Debito Automático")){

                    selecpago.selectByValue("0");

                }

                if (lbc_ModosPagoTercerobean.getModoPago().equals("Otras Modalidades")){

                    selecpago.selectByValue("1");

                }

            }

            Thread.sleep(2000);

            //Boton Agregar
            WebElement btnAgre = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/input"));
            btnAgre.click();

            Thread.sleep(2000);


            if (lbc_ModosPagoTercerobean.getTipoCuenta() != null){

                Select tipocta = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div/div/div/select")));

                if(lbc_ModosPagoTercerobean.getTipoCuenta().equals("Ahorro")){

                    tipocta.selectByValue("442194");

                }

                if(lbc_ModosPagoTercerobean.getTipoCuenta().equals("Corriente")){

                    tipocta.selectByValue("442193");

                }

            }

            Thread.sleep(2000);

            if(lbc_ModosPagoTercerobean.getDescripcion() != null){

                WebElement des = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[1]/div/textarea"));
                des.sendKeys(lbc_ModosPagoTercerobean.getDescripcion());
                Thread.sleep(2000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);

            if(lbc_ModosPagoTercerobean.getNumCtaBco() !=null){

                WebElement ncb = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/div/div/div/input[2]"));
                ncb.sendKeys(lbc_ModosPagoTercerobean.getNumCtaBco());
                Thread.sleep(2000);
            }

            if(lbc_ModosPagoTercerobean.getCollector() !=null){

                WebElement coll = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                coll.clear();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/div/div/div/input[2]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']")).sendKeys(lbc_ModosPagoTercerobean.getCollector());
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[4]")).click();
                Thread.sleep(2000);
            }

            if(lbc_ModosPagoTercerobean.getSucursal() !=null){

                WebElement suc = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[5]/span/input[1]"));
                suc.clear();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/div/div/div/input[2]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[5]/span/input[1]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[5]/span/input[1]")).sendKeys(lbc_ModosPagoTercerobean.getSucursal());
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[4]")).click();
                Thread.sleep(2000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnGuardar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[4]/div/div[2]/input"));
            btnGuardar.click();
            Thread.sleep(1500);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);
            Thread.sleep(1000);

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            //Screenshot
           // a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

}
