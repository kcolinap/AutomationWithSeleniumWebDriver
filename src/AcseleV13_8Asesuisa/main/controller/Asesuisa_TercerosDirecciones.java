package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosDireccionesBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
/**
 * Created by kcolina on 03/03/2017.
 */
public class Asesuisa_TercerosDirecciones {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosDirecciones.class);
    public String nombreAutomatizacion = "Terceros - direcciones";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosDireccionesBean bean, int i, String folderName){

        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();
            Asesuisa_BuscarTerceros buscarTerceros = new Asesuisa_BuscarTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            menuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion,2,i,folderName);
            Thread.sleep(1200);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Buscar tercero
            buscarTerceros.BusquedaT(driver, m, bean, nombreAutomatizacion, i, folderName, 3,4,5,6, 7);
            Thread.sleep(1500);

            if ( (bean.getPais()==null) || (bean.getDpto()==null) || (bean.getMunicipio()==null) ) {
                Consulta(driver, m, bean, i, folderName);
            }else {

                if ((driver.findElements(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_errorSection_errorForm_errorMessage']")).size() > 0) &&
                        (driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_errorSection_errorForm_errorMessage']")).getText().equals("No se encontró ningún Tercero con estas características"))) {
                } else {
                    //Llamada a metodo agregar direccion
                    AgregarDirTercero(driver, m, bean, i, folderName, 8, 9, 10);
                    Thread.sleep(1500);
                }
            }


            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void AgregarDirTercero(WebDriver driver, Metodos m,
                                         Asesuisa_TercerosDireccionesBean asesuisaTercerosDireccionesBean, int i,
                                         String folderName, int screen, int screen2, int screen3){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
           /* int tipoTercero=0;

            if ( (asesuisaTercerosDireccionesBean.getTipoTercero() != null) &&
                    (asesuisaTercerosDireccionesBean.getTipoTercero().equals("NaturalPerson")) ) {
                tipoTercero = 0;
            }else if  ( (asesuisaTercerosDireccionesBean.getTipoTercero() != null) &&
                    (asesuisaTercerosDireccionesBean.getTipoTercero().equals("LegalPerson")) ){
                tipoTercero=1;
            }

            switch (tipoTercero){
                case 0:

                    break;
            }*/

            //Boton editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            Thread.sleep(500);
            m.waitSearchWicket(driver, ". Entrando en modo edicion");

            if ( (asesuisaTercerosDireccionesBean.getTipoTercero() != null) &&
                    (asesuisaTercerosDireccionesBean.getTipoTercero().equals("NaturalPerson")) ) {
                //ejecutar scroll
                jse.executeScript("window.scrollBy(0,1500)", "");
                Thread.sleep(1500);
            }else if  ( (asesuisaTercerosDireccionesBean.getTipoTercero() != null) &&
                    (asesuisaTercerosDireccionesBean.getTipoTercero().equals("LegalPerson")) ){
                //ejecutar scroll
                jse.executeScript("window.scrollBy(0,1000)", "");
                Thread.sleep(1500);
            }


            //ScreenShot para capturar direcciones actuales
            m.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton agregar direccion
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_AddButton']"));
            btnAgregar.click();
            Thread.sleep(1200);

           /* jse.executeScript("window.scrollBy(0,290)", "");
            Thread.sleep(1500);*/

            ///////////////////////////////////////////
            //LLenado del formulario direcciones
            //////////////////////////////////////////////

            if (asesuisaTercerosDireccionesBean.getPais()!=null){
                Select pais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                pais.selectByValue(asesuisaTercerosDireccionesBean.getPais());
                Thread.sleep(1500);
            }

            if (asesuisaTercerosDireccionesBean.getDpto()!=null){
                Select dpto = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_1_fila_repeaterSelect_1_field']")));
                dpto.selectByValue(asesuisaTercerosDireccionesBean.getDpto());
                Thread.sleep(1500);
            }

            if (asesuisaTercerosDireccionesBean.getMunicipio()!=null){
                Select municipio = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_1_fila_repeaterSelect_2_field']")));
                municipio.selectByValue(asesuisaTercerosDireccionesBean.getMunicipio());
                Thread.sleep(1500);
            }

            if (asesuisaTercerosDireccionesBean.getAvenida()!=null){
                WebElement avenida = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_textAreaPanel_wrapperRepeater_1_textarea_field']"));
                avenida.click();
                avenida.sendKeys(asesuisaTercerosDireccionesBean.getAvenida());
                Thread.sleep(1500);
            }

            if (  (driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_textAreaPanel_wrapperRepeater_2_textarea_field']")).isEnabled())  ){
                if (asesuisaTercerosDireccionesBean.getDirCompleta()!=null){
                    WebElement dirCompleta = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                    dirCompleta.click();
                    dirCompleta.sendKeys(asesuisaTercerosDireccionesBean.getDirCompleta());
                    Thread.sleep(1500);
                }
            }

            //////////////////////////////////////////////////
            //  FIN LLENADO DE FORMULARIO DIRECCIONES
            /////////////////////////////////////////////////

            //ScreenShoot para capturar informacion ingresada
            m.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(600);

            //Boton guardar
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']"));
            guardar.click();
            m.waitSearchWicket(driver,". Guardando direccion");
            Thread.sleep(500);


            //ScreenShoot para capturar nuevo bloque de direcciones
            m.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(600);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void Consulta(WebDriver driver, Metodos m, Asesuisa_TercerosDireccionesBean bean, int i, String folderName){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //Boton de consulta
            WebElement btnConsultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_consultThirdButton']"));
            btnConsultar.click();
            m.waitSearchWicket(driver, ". Entrando modo consulta");

            //pantallazo
            m.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion,folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(600);

            if ( (bean.getTipoTercero() != null) &&
                    (bean.getTipoTercero().equals("NaturalPerson")) ) {
                //ejecutar scroll
                jse.executeScript("window.scrollBy(0,1500)", "");
                Thread.sleep(1500);
            }else if  ( (bean.getTipoTercero() != null) &&
                    (bean.getTipoTercero().equals("LegalPerson")) ){
                //ejecutar scroll
                jse.executeScript("window.scrollBy(0,1000)", "");
                Thread.sleep(1500);
            }

            //pantallazo
            m.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion,folderName);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(600);

        }catch (Exception e){
        e.printStackTrace();
    }
    }
}
