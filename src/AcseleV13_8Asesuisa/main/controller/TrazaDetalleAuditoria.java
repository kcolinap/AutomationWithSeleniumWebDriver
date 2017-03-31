package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.TrazaDetalleAuditoriaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import AcseleV13_8Asesuisa.main.controller.TrazaDetalleAuditoria;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Keys;
import org.openqa.selenium.*;

import java.io.IOException;
/**
 * Created by cortiz on 29/03/2017.
 */
public class TrazaDetalleAuditoria {

    private final static Logger log = Logger.getLogger(TrazaDetalleAuditoria.class);

    public String nombreAutomatizacion = "Traza de Auditoria";

    private WebDriver driver;

    public void testLink (TrazaDetalleAuditoriaBean trazaDetalleAuditoriaBean, int i, String folderName)  throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(3000);

            //Entrando en Menu
            menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Consultar Traza */
            ConsultarTrazaAuditoria(trazaDetalleAuditoriaBean, a, i, folderName, 3,4,5,6,7,8,9,10);

            Thread.sleep(3000);


            driver.quit();


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void  ConsultarTrazaAuditoria(TrazaDetalleAuditoriaBean bean, Metodos a, int i, String folderName, int screen, int screen2, int screen3, int screen4, int screen5, int screen6, int screen7, int screen8) {

        try {

            Thread.sleep(3000);



            if (bean.getTipoTraza() != null) {
                Thread.sleep(1000);
                WebElement tipotraza = driver.findElement(By.xpath("//*[@id=\"type\"]/div"));
                tipotraza.click();
                WebElement selectTipoTraza = null;

                for (int j = 1; j <11; j++){
                    Thread.sleep(1000);
                    selectTipoTraza = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[2]/table/tbody/tr[" + j + "]/td"));
                    System.out.println("Elemento recorrido: " + selectTipoTraza.getText());

                    if (selectTipoTraza.getText().toLowerCase().equals(bean.getTipoTraza().toLowerCase())){
                        Thread.sleep(1000);
                        selectTipoTraza.click();
                        break;
                    }

                }

            }



            if (bean.getCategoria_Traza() != null) {
                Thread.sleep(1000);
                WebElement categoriatraza = driver.findElement(By.xpath("//*[@id=\"item\"]/div"));
                categoriatraza.click();
                WebElement selectCategoria = null;



                for (int h = 1; h <11; h++) {
                    Thread.sleep(1000);
                    selectCategoria = driver.findElement(By.xpath("//*[@id=\"VAADIN_COMBOBOX_OPTIONLIST\"]/div/div[h]/table/tbody/tr[h]/td"));
                    System.out.println("Elemento recorrido: " + selectCategoria.getText());

                    if (selectCategoria.getText().toLowerCase().equals(bean.getCategoria_Traza().toLowerCase())) {
                        Thread.sleep(1000);
                        selectCategoria.click();
                        break;
                    }
                }

            }





            if (bean.getIpdesde() != null) {
                WebElement ipdesde = driver.findElement(By.xpath("//*[@id=\"ipFrom\"]"));
                ipdesde.sendKeys(bean.getIpdesde());
            }

            if (bean.getIphasta() != null) {
                WebElement iphasta = driver.findElement(By.xpath("//*[@id=\"ipTo\"]"));
                iphasta.sendKeys(bean.getIphasta());
            }


            if (bean.getUsuario() != null) {
                WebElement usuario = driver.findElement(By.xpath("//*[@id=\"user\"]"));
                usuario.sendKeys(bean.getUsuario());
            }

            if (bean.getMascaraip() != null) {
                WebElement mascaraip = driver.findElement(By.xpath("//*[@id=\"user\"]"));
                mascaraip.sendKeys(bean.getMascaraip());
            }

            if (bean.getHoradesde() != null) {
                WebElement horadesde = driver.findElement(By.xpath("//*[@id=\"startEventHour\"]"));
                horadesde.sendKeys(bean.getHoradesde());

            }

            if (bean.getHorahasta() != null) {
                WebElement horahasta = driver.findElement(By.xpath("//*[@id=\"endEventHour\"]"));
                horahasta.sendKeys(bean.getHorahasta());
            }

            if (bean.getDesde() != null) {
                WebElement desde = driver.findElement(By.xpath("//*[@id=\"startEventDate\"]/input"));
                desde.click();
                desde.sendKeys(bean.getDesde());
                Thread.sleep(500);
            }

            if (bean.getHasta() != null) {
                WebElement hasta = driver.findElement(By.xpath("//*[@id=\"endEventDate\"]/input"));
                hasta.click();
                hasta.sendKeys(bean.getHasta());
                Thread.sleep(500);
            }
            if (bean.getIdentificador() != null) {
                WebElement identificador = driver.findElement(By.xpath("//*[@id=\"identifier\"]"));
                identificador.sendKeys(bean.getIdentificador());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"horizontalButton\"]/div/div/div/span/span"));
            btnBuscar.click();
            Thread.sleep(2000);


            WebElement exportar = driver.findElement(By.xpath("//*[@id=\"horizontalButtonExport\"]/div/div/div/span/span"));
            exportar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen7, nombreAutomatizacion, folderName);
            a.cambiarVentana(driver);
            WebElement btnExportar = driver.findElement(By.xpath("//*[@id="formExportAuditTrail"]/table/tbody/tr/td[3]/div/div[3]/div/span"));
            WebElement seleccionarTipo = null;
            for  (int k= 1; k<3; k++) {
                Thread.sleep(1000);
                WebElement seleccionarTipo = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[5]/div/div/table/tbody/tr/td[3]/div/div[1]/div/div[3]/div/div"));
                if (seleccionarTipo.getText().equals("pdf")) {
                    seleccionarTipo.click();
                }
            }

/*

            WebElement scroll = driver.findElement(By.xpath("/*/
/*[@id=\"formAuditTrail\"]/table/tbody/tr[7]/td[3]"));
            scroll.sendKeys(Keys.DOWN);
            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen" + screen4, nombreAutomatizacion, folderName);
*/



          /* //busqueda de id traza
            WebElement idTraza  = driver.findElement(By.xpath("*//*//**//*[@id=\"PanelCenter\"]/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div/div"));
            idTraza.click();
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen6, nombreAutomatizacion, folderName);
            Thread.sleep(1000);
            //botòn cerrar de ventana detalle traza
            WebElement btnclose = driver.findElement(By.xpath("*//*//**//*[@id=\"layoutButton\"]/div/div/div/span"));
            btnclose.click();
*/







            WebElement msg = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div"));
            Boolean mensageID = driver.findElements(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]")).size() > 0;



            if ((mensageID) &&  msg.getText().equals("Debe seleccionar una fecha de inicio y fin")) {

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + screen2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                WebElement btnx= driver.findElement(By.id("82_window_close"));
                btnx.click();


            } else if ((mensageID) &&  msg.getText().equals("No hay resultados")){
               // No consigue tipo traza

                    System.out.println("No se encontró resultados asociados con esta búsqueda");
                    System.out.println(driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]")).getText());

                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + screen3, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    WebElement btnx= driver.findElement(By.id("82_window_close"));
                    btnx.click();
            } else { //Si consigue tipo traza
                    System.out.println("encontrado");

            }





/*

            WebElement btnExportar = driver.findElement(By.xpath("//*[@id="formExportAuditTrail"]/table/tbody/tr/td[3]/div/div[3]/div/span"));
            WebElement seleccionarTipo = null;
             for  (int k= 1; k<3; k++){
                  Thread.sleep(1000);
                  WebElement seleccionarTipo = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[5]/div/div/table/tbody/tr/td[3]/div/div[1]/div/div[3]/div/div"));
                      if (seleccionarTipo.getText().equals("pdf")){
                         seleccionarTipo.click();
                      }


             }

            Thread.sleep(1000);
            WebElement pdf = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td"));
            pdf.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);
            Thread.sleep(1000);
                btnExportar.click();
                Thread.sleep(900);
                a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);

                Thread.sleep(1500);
                a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                WebElement cerrarVentana = driver.findElement(By.xpath("//*[@id="193_window_close"]"));
                cerrarVentana.click();

                Thread.sleep(1000);

                a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            WebElement export= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span"));
            export.click();
            Thread.sleep(1000);



            WebElement btnExport = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[5]/div/div/table/tbody/tr/td[3]/div/div[3]/div/span"));
            btnExport.click();

            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement descargar = driver.findElement(By.xpath("/html/body/div[5]/div[4]/div/div/div[5]/div/div/div[2]/div/div/div/a/span"));
            descargar.click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen12", nombreAutomatizacion);
           Thread.sleep(1000);
                */


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }





    }
}
