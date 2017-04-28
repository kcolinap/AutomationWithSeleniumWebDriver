package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosInformacionFinancieraBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by cortiz on 26/04/2017.
 */
public class Asesuisa_TercerosInformacionFinanciera {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosInformacionFinanciera.class);
    public String nombreAutomatizacion = "Terceros - Informacion Financiera";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosInformacionFinancieraBean Bean, int i, String
                         folderName){
        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            menuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion,2,i,folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(500);

            //Buscar tercero
            BusquedaT(Bean,m, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(1500);

            //Llamada a metodo informacion financiera
            InformacionFinanciera(Bean, m, i, folderName, 8, 9, 10,11);
            Thread.sleep(3000);

            //Salgo de la aplicacion
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BusquedaT(Asesuisa_TercerosInformacionFinancieraBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5) {

        try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement etiqueta;

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            if (bean.getNit() != null){
                Thread.sleep(1000);
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(bean.getNit());
                Thread.sleep(1000);
                otro.click();


            }




            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            Thread.sleep(2000);
            buscar.click();

            //seleccionar tercero encontrado
            jse.executeScript("window.scrollBy(0,300)", "");
            Thread.sleep(500);
            Thread.sleep(2000);
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton consultar
            WebElement consultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_consultThirdButton']"));
            consultar.click();
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


    public void InformacionFinanciera(Asesuisa_TercerosInformacionFinancieraBean bean, Metodos m, int i, String folderName, int screen, int screen2,
                                   int screen3, int screen4 ){
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Boolean flag = true ;

            //Boton informacion financiera
            jse.executeScript("window.scrollBy(0,300)", "");

            if (bean.getPaslargoplazo() == null) {

                WebElement otros = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));


                WebElement mostrar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_formThirdFinancial_ShowButton']"));
                mostrar.click();
                jse.executeScript("window.scrollBy(0,500)", "");
                Thread.sleep(1000);
                otros = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                otros.click();
                mostrar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_formThirdFinancial_ShowButton']"));
                mostrar.click();

                Thread.sleep(1000);
                m.ScreenShotPool(driver, i, "screen" + screen4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
               flag = false ;
            }

            if (flag) {
            //if (bean.getPaslargoplazo() != null) {
            WebElement agregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_formThirdFinancial_AddButton']"));
            agregar.click();
           // }
            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));


            if (bean.getActivos() != null) {
                Thread.sleep(1000);
                WebElement activos = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_1_fila_field']"));
                activos.clear();
                activos.sendKeys(bean.getActivos());
                Thread.sleep(1000);
            }

            if (bean.getPaslargoplazo() != null) {
                Thread.sleep(1000);
                WebElement paslargo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_field']"));
                paslargo.sendKeys(bean.getPaslargoplazo());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                otro.click();
                paslargo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_field']"));
                paslargo.sendKeys(bean.getPaslargoplazo());
                Thread.sleep(1000);
            }

            if (bean.getReservadecap() != null) {
                Thread.sleep(1000);
                WebElement reserva = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_field']"));
                reserva.sendKeys(bean.getReservadecap());
                Thread.sleep(1000);
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                otro.click();
                reserva = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_field']"));
                reserva.sendKeys(bean.getReservadecap());
                Thread.sleep(1000);

            }

            if (bean.getGiro() != null) {
                Thread.sleep(1000);
                Select giro = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_8_fila_repeaterSelect_1_field']")));
                giro.selectByVisibleText(bean.getGiro());
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                Thread.sleep(1000);
                otro.click();
                giro = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_8_fila_repeaterSelect_1_field']")));
                giro.selectByVisibleText(bean.getGiro());
                Thread.sleep(1000);
            }

            if (bean.getActivosF() != null) {
                Thread.sleep(1000);
                WebElement activosF = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_1_fila_field']"));
                activosF.clear();
                activosF.sendKeys(bean.getActivosF());
                Thread.sleep(1000);
            }

            if (bean.getPasivosc() != null) {
                Thread.sleep(1000);
                WebElement pasivosc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_3_fila_field']"));
                pasivosc.sendKeys(bean.getPasivosc());
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                Thread.sleep(1000);
                otro.click();
                pasivosc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_3_fila_field']"));
                pasivosc.sendKeys(bean.getPasivosc());
                Thread.sleep(1000);
            }

            if (bean.getCapitalp() != null) {
                Thread.sleep(1000);
                WebElement capitalp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_4_fila_field']"));
                capitalp.sendKeys(bean.getCapitalp());
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                Thread.sleep(1000);
                otro.click();
                capitalp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_4_fila_field']"));
                capitalp.sendKeys(bean.getCapitalp());
                Thread.sleep(1000);
            }

            if (bean.getSuperavit() != null) {
                Thread.sleep(1000);
                WebElement superavit = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_5_fila_field']"));
                superavit.sendKeys(bean.getSuperavit());
                jse.executeScript("window.scrollBy(0,-300)", "");
                otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
                Thread.sleep(1000);
                otro.click();
                superavit = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_5_fila_field']"));
                superavit.sendKeys(bean.getSuperavit());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            m.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

           // if (bean.getPaslargoplazo() != null) {
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_saveButton']"));
            guardar.click();
            otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_FinancialInformationLabel']"));
            Thread.sleep(1000);
            otro.click();
            guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_saveButton']"));
            Thread.sleep(2000);
            guardar.click();
            Thread.sleep(4000);
           //  }

                Thread.sleep(1000);
                m.ScreenShotPool(driver, i, "screen" + screen2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);


            }



            if (bean.getActivos() == null) {

                WebElement  msgError = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_1_fila_feedbackLabel']"));
                System.out.println(msgError.getText());
                Thread.sleep(1000);
                m.ScreenShotPool(driver, i, "screen" + screen3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
