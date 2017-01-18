package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ModosPagoTerceroBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import oracle.net.aso.e;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by mchurion on 09/01/2017.
 */
public class INTER_ModosPagoTercero {
    private final static Logger log = Logger.getLogger(INTER_ModosPagoTercero.class);

    public String nombreAutomatizacion ="INTER Modos de Pago de Terceros";

    public void testLink(INTER_ModosPagoTerceroBean interModosPagoTercerobean, int i)throws Exception {

        try {

            // Instanciando clases
            Interseguros_Metodos a= new Interseguros_Metodos();   //implementando metodos.
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
            a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
            Thread.sleep(3000);

            //Entrando en Menu
            interMenuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion, i, 2);

            Thread.sleep(1000);
            a.cambiarVentana(driver); // Cambiar de ventana

            BuscarTercero(a, driver, interModosPagoTercerobean, i);

            SelecionTercero(a, driver, interModosPagoTercerobean, i);

            AgregarModoDePago(a, driver, interModosPagoTercerobean, i);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }



    public void BuscarTercero(Interseguros_Metodos a, WebDriver driver, INTER_ModosPagoTerceroBean interModosPagoTercerobean, int i) throws InterruptedException, IOException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            Thread.sleep(1000);
            //Tipo de tercero
            if (interModosPagoTercerobean.getTipoTercero() != null) {
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(interModosPagoTercerobean.getTipoTercero());
                Thread.sleep(2000);
            }
            //Select tipoTerceroSelect = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));

            if (interModosPagoTercerobean.getNumDocId() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                cedu.sendKeys(interModosPagoTercerobean.getNumDocId());
                Thread.sleep(2000);
            }

            if (interModosPagoTercerobean.getApellido() != null) {
                WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                aTercero.sendKeys(interModosPagoTercerobean.getApellido());
                Thread.sleep(2000);
            }

            if (interModosPagoTercerobean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nTercero.sendKeys(interModosPagoTercerobean.getNombre());
                Thread.sleep(2000);
            }

            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(2000);

            //Screenshot
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
            Thread.sleep(1000);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    private void SelecionTercero(Interseguros_Metodos a, WebDriver driver, INTER_ModosPagoTerceroBean interModosPagoTercerobean, int i) throws InterruptedException, IOException {

        try {
            //Seleccionar Tercero
            WebElement seleccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            seleccionTercero.click();

            // Boton Editar
            WebElement btnEditar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[2]/div/form/input[1]"));
            btnEditar.click();
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Thread.sleep(3000);

            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
    private void AgregarModoDePago(Interseguros_Metodos a, WebDriver driver, INTER_ModosPagoTerceroBean interModosPagoTercerobean, int i)  throws InterruptedException, IOException  {
        try {

            //Tipo de Pago
            if (interModosPagoTercerobean.getModoPago() != null) {
                Select tipoP = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_RolForm_rolComb']")));
                tipoP.selectByValue(interModosPagoTercerobean.getModoPago());
                Thread.sleep(2000);
            }

            //Boton Agregar
            WebElement btnAgre = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/input"));
            btnAgre.click();
            Thread.sleep(2000);

            //Tipo de Pago
            if (interModosPagoTercerobean.getModoPago() != null) {
                Select tipoP = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_RolForm_rolComb']")));
                tipoP.selectByValue(interModosPagoTercerobean.getModoPago());
                Thread.sleep(2000);
            }

            //Evaluación de Riesgo
            if (interModosPagoTercerobean.getEvaluacionRiesgo() != null) {
                WebElement riesgo = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_field']"));
                riesgo.sendKeys(interModosPagoTercerobean.getEvaluacionRiesgo());
                Thread.sleep(2000);
            }

            //Seleccionar Collector
            if (interModosPagoTercerobean.getColector() != null) {
                WebElement colec = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                colec.clear();
                colec.sendKeys(interModosPagoTercerobean.getColector());
                Thread.sleep(1000);
            }
/*            //Boton buscar
            WebElement busca = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[3]/div"));
            busca.click();
            Thread.sleep(2000);

            Thread.sleep(1000);*/
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);

                //botón Guardar
                WebElement btnGuardar = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[4]/div/div[2]/input"));
                btnGuardar.click();
                Thread.sleep(1500);

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



/*            if (interModosPagoTercerobean.getTipoCuenta() != null){

                Select tipocta = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div/div/div/select")));

                if(interModosPagoTercerobean.getTipoCuenta().equals("Ahorro")){

                    tipocta.selectByValue("442194");

                }

                if(interModosPagoTercerobean.getTipoCuenta().equals("Corriente")){

                    tipocta.selectByValue("442193");

                }

            }

            Thread.sleep(2000);*/
    }
/*            if(interModosPagoTercerobean.getDescripcion() != null){

                WebElement des = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[1]/div/textarea"));
                des.sendKeys(interModosPagoTercerobean.getDescripcion());
                Thread.sleep(2000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);

            if(interModosPagoTercerobean.getNumCtaBco() !=null){

                WebElement ncb = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/div/div/div/input[2]"));
                ncb.sendKeys(interModosPagoTercerobean.getNumCtaBco());
                Thread.sleep(2000);
            }

            if(interModosPagoTercerobean.getCollector() !=null){

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

            if(interModosPagoTercerobean.getSucursal() !=null){

                WebElement suc = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[5]/span/input[1]"));
                suc.clear();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr/td[1]/div/div/div/input[2]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[5]/span/input[1]")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div[3]/div[6]/div/div[2]/div[2]/div[1]/div/form/div[3]/div[2]/div[5]/span/input[1]")).sendKeys(interModosPagoTercerobean.getSucursal());
                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[4]")).click();
                Thread.sleep(2000);
            }*/



    }

