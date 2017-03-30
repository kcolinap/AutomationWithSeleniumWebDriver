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
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Consultar Traza */
            ConsultarTrazaAuditoria(trazaDetalleAuditoriaBean, a, i, folderName, 3,4);

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

    public void  ConsultarTrazaAuditoria(TrazaDetalleAuditoriaBean bean, Metodos a, int i, String folderName, int screen, int screen2) {

        try {

            Thread.sleep(5000);

            //WebElement tipo = driver.findElement(By.xpath(""));

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
                ipdesde.click();
            }

            if (bean.getIphasta() != null) {
                WebElement iphasta = driver.findElement(By.xpath("//*[@id=\"ipTo\"]"));
                iphasta.click();
            }


            if (bean.getUsuario() != null) {
                WebElement usuario = driver.findElement(By.xpath("//*[@id=\"user\"]"));
                usuario.click();
            }

            if (bean.getMascaraip() != null) {
                WebElement mascaraip = driver.findElement(By.xpath("//*[@id=\"user\"]"));
                mascaraip.click();
            }

            if (bean.getHoradesde() != null) {
                WebElement horadesde = driver.findElement(By.xpath("//*[@id=\"startEventHour\"]"));
                horadesde.click();
            }

            if (bean.getHorahasta() != null) {
                WebElement horahasta = driver.findElement(By.xpath("//*[@id=\"endEventHour\"]"));
                horahasta.click();
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
                identificador.click();
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);


            WebElement btnBuscar = driver.findElement(By.xpath("//*[@id=\"horizontalButton\"]/div/div/div/span/span"));
            btnBuscar.click();
            Thread.sleep(2000);
            WebElement msg = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div/div"));
            Boolean mensageID = driver.findElements(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]")).size() > 0;



            if ((mensageID) &&  msg.getText().equals("Debe seleccionar una fecha de inicio y fin")) {

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                WebElement btnx= driver.findElement(By.id("82_window_close"));
                btnx.click();


            } else if ((mensageID) &&  msg.getText().equals("No hay resultados")){
               // No consigue tipo traza

                    System.out.println("No se encontró resultados asociados con esta búsqueda");
                    System.out.println(driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]")).getText());

                    Thread.sleep(1000);
                    a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    WebElement btnx= driver.findElement(By.id("82_window_close"));
                    btnx.click();
            } else { //Si consigue tipo traza
                    System.out.println("encontrado");
            }


                // No consigue tipo traza
            if (mensageID) {
                System.out.println("No se encontró resultados asociados con esta búsqueda");
                System.out.println(driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]")).getText());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + screen, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                WebElement btnx= driver.findElement(By.id("82_window_close"));
                btnx.click();
            } else { //Si consigue tipo traza
                System.out.println("encontrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }





    }
}
