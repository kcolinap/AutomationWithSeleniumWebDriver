package AcseleV13_8Asesuisa.main.controller;

/**
 * Created by kcolina on 22/05/2017.
 */

import AcseleV13_8Asesuisa.beans.Asesuisa_TablaDinamicaExportBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Asesuisa_TablaDinamicaExport {

    private final static Logger log = Logger.getLogger(Asesuisa_TablaDinamicaExport.class);

    public String nombreAutomatizacion = " Tabla Dinamica Export";
    private WebDriver driver;
    Metodos a = new Metodos();

    public void TestLink(Asesuisa_TablaDinamicaExportBean bean, int i, String folderName){

        try {
            //Instanciando clase Menu
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();


            //Inicio de sesion
            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantGeral_TablasDinamicas(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //Buscar tabla dinamica
            BuscarTablaDinamica(driver, nombreAutomatizacion, i, folderName, bean);
            Thread.sleep(1500);

            //Salida de la funcionalidad
            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void BuscarTablaDinamica(WebDriver driver, String nombreAutomatizacion, int i, String folderName,
                                    Asesuisa_TablaDinamicaExportBean bean){

       salida:try {
            if(bean.getNombreTablaDinamica()!=null) {
                WebElement txtNombreTabla = driver.findElement(By.xpath("html/body/table/tbody/tr/td/form/table/tbody/tr[3]/td[2]/input"));
                txtNombreTabla.sendKeys(bean.getNombreTablaDinamica());
                Thread.sleep(800);

                //Pantallazo
                a.ScreenShotPool(driver, i,"screen3",nombreAutomatizacion, folderName);
                Thread.sleep(800);
            }else{
                //Pantallazo
                a.ScreenShotPool(driver, i,"screen3",nombreAutomatizacion, folderName);
                Thread.sleep(800);
            }

            //Boton enviar
            WebElement btnEnviar = driver.findElement(By.xpath("html/body/table/tbody/tr/td/form/table/tbody/tr[5]/td/input[2]"));
            btnEnviar.click();
            Thread.sleep(2000);


           //Etiqueta de resultado
           if (driver.findElements(By.xpath("html/body/table/tbody/tr[3]/td/b/span")).size()>0){
               String lblResultado = driver.findElement(By.xpath("html/body/table/tbody/tr[3]/td/b/span")).getText();

               if (lblResultado.equals("El Template no fue Encontrado")){
                   //Pantallazo
                   a.ScreenShotPool(driver, i,"screen4",nombreAutomatizacion, folderName);
                   Thread.sleep(800);

                   System.out.println("Su búsqueda no produjo ningún resultado");
                   Thread.sleep(500);
                   break salida;
               }
           }


           //Si encontro la tabla
           System.out.println("Se encontro la tabla");

           //Pantallazo
           a.ScreenShotPool(driver, i,"screen4",nombreAutomatizacion, folderName);
           Thread.sleep(800);

           //Llamada a metodo Exportar Tabla Dinamica
           ExportarTablaDinamica(driver, bean, i, folderName, nombreAutomatizacion);
           Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ExportarTablaDinamica(WebDriver driver, Asesuisa_TablaDinamicaExportBean bean, int i, String folderName,
                                      String nombreAutomatizacion){
        try{

            //Boton exportar tabla
            WebElement btnExportarTabla = driver.findElement(By.xpath("html/body/div[4]/table[1]/tbody/tr[3]/td[2]/form/input[9]"));
            btnExportarTabla.click();
            Thread.sleep(2500);

            //cambio foco de ventana
            a.changeLastWindows(driver);
            Thread.sleep(800);

            Select selectFormato = new Select(driver.findElement(By.xpath("html/body/table/tbody/tr[4]/td/select")));
            selectFormato.selectByValue(bean.getFormato());

            //Pantallazo
            a.ScreenShotPool(driver, i,"screen5",nombreAutomatizacion, folderName);
            Thread.sleep(800);

            //Boton cofnfirmar exportar
            WebElement btnConfirmarExportar = driver.findElement(By.xpath("html/body/table/tbody/tr[7]/td/input[1]"));
            btnConfirmarExportar.click();
            Thread.sleep(3500);

            //cambio foco de ventana
            a.changeLastWindows(driver);
            Thread.sleep(800);

            //Pantallazo
            a.ScreenShotPool(driver, i,"screen6",nombreAutomatizacion, folderName);
            Thread.sleep(800);

            //Label resultado
            String lblResult = driver.findElement(By.xpath("html/body/table/tbody/tr[10]/td")).getText();
            if (lblResult.equals("---- Documento generado correctamente:")){
                System.out.println("Documento generado correctamente");
            }else{
                System.out.println("Proceso de exportacion fallido");
            }





        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
