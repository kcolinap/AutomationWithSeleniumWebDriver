package AcseleV13_8.main.controller;


import AcseleV13_8.beans.TrazaAuditoriaExportarBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by kzambrano on 23/09/2016.
 */
public class TrazaAuditoriaExportar {

    private final static Logger log = Logger.getLogger(TrazaAuditoriaExportar.class);

    public String nombreAutomatizacion = "Traza de Auditoria Exportar Documentos";

    public void testLink (TrazaAuditoriaExportarBean trazaAuditoriaExportarBean, int i )  throws IOException, InterruptedException {

        Metodos a = new Metodos();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");
        Thread.sleep(1000);

        menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 3, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        TrazaAuditoriaExportarDocumento(driver, a, trazaAuditoriaExportarBean, i);
        Thread.sleep(2000);
    }

    public void TrazaAuditoriaExportarDocumento (WebDriver driver, Metodos a, TrazaAuditoriaExportarBean trazaAuditoriaExportarBean, int i) throws IOException, InterruptedException{

        try {

            Thread.sleep(2000);


            WebElement tipoList = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div[1]/div/div/div[3]/div/div"));
            Thread.sleep(1000);
            tipoList.click();
            Thread.sleep(1000);

            WebElement listaSelect = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td/span"));
            Thread.sleep(1000);
            listaSelect.click();
            Thread.sleep(1500);

            WebElement categoriaTraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div[1]/div/div/div[3]/div/div"));
            Thread.sleep(1000);
            categoriaTraza.click();
            Thread.sleep(1000);

            WebElement categoriaTrazaSelect = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td/span"));
            Thread.sleep(1000);
            categoriaTrazaSelect.click();
            Thread.sleep(1500);

            WebElement fechaDesdeTraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[4]/td[3]/div/div/div[3]/div/div/div[3]/div/input"));
            fechaDesdeTraza.sendKeys(trazaAuditoriaExportarBean.getFecha_Desde());
            Thread.sleep(1000);

            WebElement fechaHastaTraza = driver.findElement(By.xpath("//*[@id=\"endEventDate\"]/input"));
            Thread.sleep(1000);
            fechaHastaTraza.sendKeys(trazaAuditoriaExportarBean.getFecha_Hasta());
            Thread.sleep(1500);

            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[8]/td[3]/div/div/div/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);

            WebElement scroll = driver.findElement(By.xpath("/html/body/div[1]/div"));
            scroll.sendKeys(Keys.PAGE_DOWN);
            Thread.sleep(1500);

            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);


            WebElement exportar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span/span"));
            Thread.sleep(1000);
            exportar.click();
            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);



            WebElement btnExportar = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[5]/div/div/table/tbody/tr/td[3]/div/div[3]/div/span"));
            btnExportar.click();
            Thread.sleep(900);
            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);

            Thread.sleep(1500);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement cerrarVentana = driver.findElement(By.xpath("/html/body/div[5]/div[4]/div/div/div[4]"));
            cerrarVentana.click();

            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);
            Thread.sleep(1000);


            WebElement export= driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span"));
            export.click();
            Thread.sleep(1000);

            WebElement seleccionarTipo = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[5]/div/div/table/tbody/tr/td[3]/div/div[1]/div/div[3]/div/div"));
            seleccionarTipo.click();
            Thread.sleep(1000);
            WebElement pdf = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td"));
            pdf.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);
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

        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }



}
