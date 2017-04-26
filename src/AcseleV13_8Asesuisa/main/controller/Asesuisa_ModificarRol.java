package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ModificarRolBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by agil on 17/04/2017.
 */
public class Asesuisa_ModificarRol {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCreacionRepetida.class);

    public String nombreAutomatizacion = "Modificar tercero - rol Asegurado";
    private WebDriver driver;

    public void testLink(Asesuisa_ModificarRolBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);



            BuscarTercero(bean, a, i, folderName, 3, 4, 5, 6);
            Thread.sleep(3000);
            EditarTercero(bean, a, i, folderName, 7, 8, 9, 10, 11, 12);



            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                 driver.quit();
            }
        }
    }

    public void BuscarTercero(Asesuisa_ModificarRolBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4){

         try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            Thread.sleep(3000);

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            if (bean.getNitBuscar() != null) {
                WebElement nit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                nit.sendKeys(bean.getNitBuscar());
                Thread.sleep(1000);
                otro.click();
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(500);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            btnBuscar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Buscando Tercero");
            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(1000);

            WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            seleccionTercero.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere: Ingresando a la edicion del Tercero");

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void EditarTercero(Asesuisa_ModificarRolBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4,
                              int numScreenShoot5, int numScreenShoot6){

        what:  try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;

            WebElement otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));

              if (bean.getFechaNacimiento() != null) {
                  WebElement campo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_fieldDate']"));
                  campo.clear();
                  campo.sendKeys(bean.getFechaNacimiento());
                  Thread.sleep(1000);
                  otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                  otro.click();
                  Thread.sleep(1000);
              }


              if (bean.getGenero() != null) {

                      Select campo = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_11_fila_repeaterSelect_1_field']")));
                      campo.selectByValue(bean.getGenero());
                      Thread.sleep(1000);
                      otro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                      otro.click();
                      Thread.sleep(1000);

              }

            if (bean.getFechaNacimiento().equals("26/04*1990")) {


                    WebElement aceptar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_errorDialog_content_questionForm_confirmButton']"));
                    aceptar.click();
            }

              //Boton guardar
              Thread.sleep(1000);
              WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
              Thread.sleep(1000);
              btnGuardar.click();
              a.waitSearchWicket(driver, "Guardando, espere");
         // } else {  System.out.println("Este tercero no tiene rol asegurado");}

















        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
}
