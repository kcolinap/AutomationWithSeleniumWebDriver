package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TercerosEditarNombreApellidoBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;


/**
 * Created by kcolina on 19/01/2017.
 */
public class INTER_TercerosEditarNombreApellido {

    private final static Logger Log = Logger.getLogger(INTER_TercerosEditarNombreApellido.class);

    public String nombreAutomatizacion = "Edicion de nombre y apellido de terceros";
    private WebDriver driver;

    public void testLink(INTER_TercerosEditarNombreApellidoBean inter_tercerosEditarNombreApellidoBean, int i) throws Exception{
        try{

            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento intersegurosMenuMantenimiento = new Interseguros_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(1000);

            //Ingreso a la opcion Consulta de terceros
            intersegurosMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, inter_tercerosEditarNombreApellidoBean, i);

            //Boton editar
            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();

            EditarT(a, driver, inter_tercerosEditarNombreApellidoBean, i);
            Thread.sleep(4000);

            //driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if(driver != null){
                //driver.quit();
            }
        }
    }

    public void BusquedaT(Interseguros_Metodos a, WebDriver driver, INTER_TercerosEditarNombreApellidoBean inter_tercerosEditarNombreApellidoBean, int i) throws InterruptedException, IOException{

        try{

            Thread.sleep(4000);
            WebElement title = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            //Tipo de tercero
            if(inter_tercerosEditarNombreApellidoBean.getTipoTerceros() != null){
                Thread.sleep(3000);
                Select tipoTerceros = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoTerceros.selectByValue(inter_tercerosEditarNombreApellidoBean.getTipoTerceros());
                Thread.sleep(2000);
                title.click();
            }



            if(inter_tercerosEditarNombreApellidoBean.getNumDocIdentificacion() != null){
                WebElement nroDocIden = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                nroDocIden.sendKeys(inter_tercerosEditarNombreApellidoBean.getNumDocIdentificacion());
                Thread.sleep(2000);
                title.click();
            }



            if(inter_tercerosEditarNombreApellidoBean.getApellido() != null){
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                //apellido.sendKeys(Keys.chord(Keys.CONTROL, "a"), inter_tercerosEditarNombreApellidoBean.getApellido());
                apellido.sendKeys(inter_tercerosEditarNombreApellidoBean.getApellido());
                Thread.sleep(2000);
                title.click();
            }


            if(inter_tercerosEditarNombreApellidoBean.getNombre() != null){
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                //nombre.sendKeys(Keys.chord(Keys.CONTROL, "a"), inter_tercerosEditarNombreApellidoBean.getNombre());
                nombre.sendKeys(inter_tercerosEditarNombreApellidoBean.getNombre());
                Thread.sleep(2000);
                title.click();
            }

            Thread.sleep(1000);

            //ScreenShot
            a.ScreenShotPool(driver, i, "screen2", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            //Buscar
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            //WebElement buscar2 = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(2000);
            buscar =driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();//Borrar funcion al corregirse defecto
            Thread.sleep(6000);

            //Seleccionar tercero encontrado
            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();
            Thread.sleep(2000);

            //ScreenShot
            a.ScreenShotPool(driver, i, "screen3", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void EditarT(Interseguros_Metodos a, WebDriver driver, INTER_TercerosEditarNombreApellidoBean inter_tercerosEditarNombreApellidoBean, int i) throws InterruptedException, IOException{

        try{

            Thread.sleep(2000);
            //WebElement title = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));

            // = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
            //apellido.clear();//.sendKeys(" ");

            if(inter_tercerosEditarNombreApellidoBean.getNombre() != null) {
                //WebElement title = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                //title.click();
                //Thread.sleep(100);
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                Thread.sleep(200);
                nombre.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(300);

                nombre.sendKeys("Nombre 2");
                //nombre.sendKeys(Keys.chord(Keys.ESCAPE));
                Thread.sleep(500);
                //nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));;

                //Thread.sleep(800);
                //nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));;
                //Thread.sleep(800);

                //nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));

                Thread.sleep(1500);
            }

            if(inter_tercerosEditarNombreApellidoBean.getApellido() != null) {
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                Thread.sleep(200);
                apellido.clear();
                Thread.sleep(300);

                //apellido.clear();//pellido.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                //Thread.sleep(1000);
                apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                //apellido.sendKeys(Keys.chord(Keys.BACK_SPACE));
                //Thread.sleep(800);
                //apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                //Thread.sleep(200);
                apellido.sendKeys("d");
                Thread.sleep(100);
                apellido.clear();
                Thread.sleep(100);
                apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                apellido.sendKeys("Apellido 2");
                Thread.sleep(1500);
                WebElement title = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                title.click();
            }

            //ScreenShot
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
