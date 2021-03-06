package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ModosdePagoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;


/**
 * Created by aandrade on 29/03/2017.
 */
public class Asesuisa_ModosdePago {

    private final static Logger log = Logger.getLogger(Asesuisa_ModosdePago.class);

    public String nombreAutomatizacion = "Asesuisa Modos de Pago";
    private WebDriver driver;

    public void testLink(Asesuisa_ModosdePagoBean bean, int i, String folderName) {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();


            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            //Ingreso a la opcion consulta de terceros
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);


            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaT(bean, a, i, folderName, 3,4,5,6,7);
            AgregarModoPago(bean, a, i, folderName,8,9,10,11,12);


            Thread.sleep(3000);


           driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
               driver.quit();
            }
        }
    }

    public void BusquedaT(Asesuisa_ModosdePagoBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5) {

        try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement etiqueta;

            //Tipo tercero
            if (bean.getTipoTercero() != null) {
                Thread.sleep(1000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(bean.getTipoTercero());
                Thread.sleep(1000);
            }

            //AseguradoAP
            if (bean.getAsegurado() != null) {
                Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                aseguradoAp.selectByValue(bean.getAsegurado());
                Thread.sleep(1000);
            }

          //  jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            buscar.click();



                Thread.sleep(2000);
                WebElement aceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_ConfirmExport_content_questionForm_confirmButton']"));
                aceptar.click();



            //seleccionar tercero encontrado

            Thread.sleep(2000);
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_11_thirdPartyRadio']"));
            selccionTercero.click();


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton editar
            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarModoPago(Asesuisa_ModosdePagoBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try{
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;


            if (bean.getMododePago() != null){
                Thread.sleep(1000);
                Select   tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_RolForm_rolComb']")));
                tipoT.selectByValue(bean.getMododePago());
                Thread.sleep(1000);

            }



            WebElement Agregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_RolForm_AddButton']"));
            Agregar.click();
            Thread.sleep(1000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



            if (bean.getMododePago().equals("0")) {
                WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_styleAcordeon_label']"));

                jse.executeScript("window.scrollBy(0,600)", "");
                    if (bean.getMarca_Tarjeta() != null) {
                        Thread.sleep(1000);
                        Select marcaT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                        marcaT.selectByValue(bean.getMarca_Tarjeta());
                        otro.click();
                        Thread.sleep(1000);



                    }

                    if (bean.getTipo_Tarjeta() != null) {
                        Thread.sleep(1000);
                        Select tipoTa = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_3_fila_repeaterSelect_1_field']")));
                        tipoTa.selectByValue(bean.getTipo_Tarjeta());
                       /* otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                        otro.click();*/
                        Thread.sleep(1000);
                    }

                    if (bean.getNro_Tarjeta() != null) {
                        Thread.sleep(1000);
                        WebElement NumTar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_4_fila_field']"));
                        NumTar.clear();
                        NumTar.sendKeys(bean.getNro_Tarjeta());
                        Thread.sleep(1000);
                    }

                    if (bean.getMes_Venc_Tar() != null) {
                        Thread.sleep(1000);
                        Select mesVencTar = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        mesVencTar.selectByValue(bean.getMes_Venc_Tar());
                        Thread.sleep(3000);
                        otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                        otro.click();
                        Thread.sleep(1000);
                        mesVencTar = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_5_fila_repeaterSelect_1_field']")));
                        mesVencTar.selectByValue(bean.getMes_Venc_Tar());
                    }

                    //jse.executeScript("hideWait()", ""); funciòn para desbloquear pantalla negra

                    if (bean.getAno_Venc_Tar() != null) {

                        Thread.sleep(1000);
                        Select anoVencTar = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_6_fila_repeaterSelect_1_field']")));
                        anoVencTar.selectByValue(bean.getAno_Venc_Tar());
                        Thread.sleep(1000);
                    }

                    if (bean.getBanco_Emi() != null) {

                        Thread.sleep(1000);
                        Select bancoE = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_7_fila_repeaterSelect_1_field']")));
                        bancoE.selectByValue(bean.getBanco_Emi());
                      /*  otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_styleAcordeon_label']"));
                        otro.click();*/
                        Thread.sleep(1000);
                    }
                        Thread.sleep(1000);
                        a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                    Thread.sleep(2000);
                    WebElement colector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                    colector.click();
                    colector.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(1000);

                    colector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                    colector.sendKeys(bean.getCollector());
                    Thread.sleep(1000);
                    colector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                    colector.sendKeys(Keys.ARROW_DOWN);
                    Thread.sleep(1000);
                    colector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                    colector.sendKeys(Keys.ENTER);
                }

            if (bean.getMododePago().equals("1")) {
                WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_styleAcordeon_label']"));

                Select tipocta = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_1_fila_repeaterSelect_1_field']")));
                tipocta.selectByValue(bean.getTipoCta());

                Thread.sleep(1000);

                Select bEmisor = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater_2_fila_repeaterSelect_1_field']")));
                bEmisor.selectByValue(bean.getBanco_Emi());

                Thread.sleep(1000);

                //Colector
                Thread.sleep(2000);
                WebElement collector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));

                collector.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(1000);

                collector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                collector.sendKeys(bean.getCollector());
                Thread.sleep(1000);
                collector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                collector.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(1000);
                collector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                collector.sendKeys(Keys.ENTER);


                //Colector
                Thread.sleep(1000);
                WebElement numCta = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_templateBasicThird_tabPanel_repeaterTab_1_SubTabsInformation_repeater2_1_fila_field']"));
                numCta.clear();
                numCta.sendKeys(bean.getNroCta());
                Thread.sleep(1000);

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }

            if (bean.getMododePago().equals("2")) {

                     //Colector
                Thread.sleep(1000);
                WebElement kollector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                kollector.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(1000);

                kollector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                kollector.sendKeys(bean.getCollector());
                Thread.sleep(1000);
                kollector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                kollector.sendKeys(Keys.ARROW_DOWN);
                Thread.sleep(1000);
                kollector = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_field_search']"));
                kollector.sendKeys(Keys.ENTER);
                //Colector

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }


                Thread.sleep(1000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"campos_obligatoriosPan\"]/h1/div/label")).click();
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_saveButton']"));
            guardar.click();
            Thread.sleep(4000);




        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }



}
