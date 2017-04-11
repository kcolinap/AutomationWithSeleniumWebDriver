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

    public void testLink(Asesuisa_TercerosDireccionesBean asesuisaTercerosDireccionesBean, int i, String folderName){

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
            buscarTerceros.BusquedaT(driver, m, asesuisaTercerosDireccionesBean, nombreAutomatizacion, i, folderName, 3,4,5,6, 7);
            Thread.sleep(1500);

            //Llamada a metodo agregar direccion
            AgregarDirTerceroNatural(driver, m, asesuisaTercerosDireccionesBean,i,folderName,8,9, 10);
            Thread.sleep(1500);

            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void AgregarDirTerceroNatural(WebDriver driver, Metodos m,
                                         Asesuisa_TercerosDireccionesBean asesuisaTercerosDireccionesBean, int i,
                                         String folderName, int screen, int screen2, int screen3){
        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //Boton editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            Thread.sleep(2000);

            //ejecutar scroll
            jse.executeScript("window.scrollBy(0,1500)", "");
            Thread.sleep(1500);

            //ScreenShot para capturar direcciones actuales
            m.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton agregar direccion
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_AddButton']"));
            btnAgregar.click();
            Thread.sleep(1200);

            jse.executeScript("window.scrollBy(0,290)", "");
            Thread.sleep(1500);

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

            if (asesuisaTercerosDireccionesBean.getDirCompleta()!=null){
                WebElement dirCompleta = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_textAreaPanel_wrapperRepeater_2_textarea_field']"));
                dirCompleta.click();
                dirCompleta.sendKeys(asesuisaTercerosDireccionesBean.getDirCompleta());
                Thread.sleep(1500);
            }
            //////////////////////////////////////////////////
            //  FIN LLENADO DE FORMULARIO DIRECCIONES
            /////////////////////////////////////////////////

            //ScreenShoot para capturar informacion ingresada
            m.ScreenShotPool(driver, i, "screen" + screen2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton guardar
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']"));
            guardar.click();
            m.waitSearchWicket(driver,"Guardando direccion");
            Thread.sleep(500);


            //ScreenShoot para capturar nuevo bloque de direcciones
            m.ScreenShotPool(driver, i, "screen" + screen3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
