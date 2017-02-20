package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TrazaDetalleAuditoriaCajaBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by kzambrano on 21/09/2016.
 */
public class TrazaDetalleAuditoriaCaja {

    private final static Logger log = Logger.getLogger(TrazaDetalleAuditoriaCaja.class);

    public String nombreAutomatizacion = "Traza de Auditoria Aperturar Caja Generacion y detalle";

    public void testLink (TrazaDetalleAuditoriaCajaBean trazaDetalleAuditoriaCajaBean, int i )  throws IOException, InterruptedException {

        //Metodos a = new Metodos();
        Metodos13_8 a = new Metodos13_8();
        MenuOperaciones m = new MenuOperaciones();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.UAA_Caja_AperturaCaja(driver, nombreAutomatizacion, 3, i);

        Thread.sleep(3000);
        a.cambiarVentana(driver);

        GenerarTrazaAuditoriaAperturarCaja(driver, a, trazaDetalleAuditoriaCajaBean, i);
        Thread.sleep(2000);

        //a.cambiarVentana(driver);
        menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 6, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        DetalleTrazaAuditoriaAperturarCaja(driver, a, trazaDetalleAuditoriaCajaBean, i);
        Thread.sleep(2000);


    }

    public void GenerarTrazaAuditoriaAperturarCaja (WebDriver driver, Metodos13_8 a, TrazaDetalleAuditoriaCajaBean trazaDetalleAuditoriaCajaBean, int i) throws IOException, InterruptedException{

        try {

            Thread.sleep(1000);

            if (trazaDetalleAuditoriaCajaBean.getNro_Caja() != null){
                Select nro_Caja = new Select(driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]/select")));
                nro_Caja.selectByValue(trazaDetalleAuditoriaCajaBean.getNro_Caja());
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[5]/td/center/input"));
            btnAceptar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            driver.close();
            Thread.sleep(1000);

            a.changeLastWindows(driver);
            WebElement out = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[1]/td/img"));
            out.click();



    }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void DetalleTrazaAuditoriaAperturarCaja (WebDriver driver, Metodos13_8 a, TrazaDetalleAuditoriaCajaBean trazaDetalleAuditoriaCajaBean, int i) throws IOException, InterruptedException{

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
            fechaDesdeTraza.sendKeys(trazaDetalleAuditoriaCajaBean.getFecha_Desde());
            Thread.sleep(1000);

            WebElement fechaHastaTraza = driver.findElement(By.xpath("//*[@id=\"endEventDate\"]/input"));
            Thread.sleep(1000);
            fechaHastaTraza.sendKeys(trazaDetalleAuditoriaCajaBean.getFecha_Hasta());
            Thread.sleep(1500);

            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[8]/td[3]/div/div/div/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);




            for (int j = 1; j <= 1; j++){

                WebElement lista = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + j + "]/td[5]/div"));
                System.out.println("prueba-->>>>>"+lista+" => "+ lista.isEnabled());

                lista.click();
                //Thread.sleep(1000);

                if (lista.isEnabled() == true){

                    for (int k = 1; k <= 1; k++){

                        WebElement detalle = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[" + k + "]/td[1]/div/div/span/span"));

                        System.out.println("prueba-->>>>>"+detalle+" => "+ detalle.isEnabled());

                        // if (detalle.isEnabled() == true){
                        detalle.click();
                        //}
                    }

                }
                break;

                //}
            }


            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen9", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }





}
