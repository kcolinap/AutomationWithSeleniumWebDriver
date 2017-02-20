package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TrazaDetalleAuditoriaReservaConcepBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by kzambrano on 22/09/2016.
 */
public class TrazaDetalleAuditoriaReservaConcep {

    private final static Logger log = Logger.getLogger(PagoPorConceptos.class);

    public String nombreAutomatizacion = "Traza de Auditoria Agregar Reserva por Conceptos Generacion y detalle";

    public void testLink (TrazaDetalleAuditoriaReservaConcepBean trazaDetalleAuditoriaReservaConcepBean, int i )  throws IOException, InterruptedException {

        Metodos13_8 a = new Metodos13_8();
        MenuOperaciones m = new MenuOperaciones();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(1500);
        System.out.println("prueba");


        m.OpeSini_MantenimientoSiniestro(a, driver, nombreAutomatizacion,3, i);

        Thread.sleep(3000);
        a.cambiarVentana(driver);


        BuscarSiniestro(driver, a, trazaDetalleAuditoriaReservaConcepBean, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        // Thread.sleep(1500);
        ReservaPorConceptos (driver, a, trazaDetalleAuditoriaReservaConcepBean, i);
        Thread.sleep(2000);



        //a.cambiarVentana(driver);
        menuMantenimiento.Aud_TrazasAuditoriaVaadin(driver, nombreAutomatizacion, 9, i);
        Thread.sleep(2000);
        a.cambiarVentana(driver);

        DetalleTrazaAuditoriaReservaConceptos(driver, a, trazaDetalleAuditoriaReservaConcepBean, i);
        Thread.sleep(2000);
    }

    public void BuscarSiniestro(WebDriver driver, Metodos13_8 a, TrazaDetalleAuditoriaReservaConcepBean trazaDetalleAuditoriaReservaConcepBean, int i) throws IOException, InterruptedException{

        try {

            //
            if (trazaDetalleAuditoriaReservaConcepBean.getOrdenarPor() != null){
                Select ordenarPor = new Select(driver.findElement(By.xpath("//*[@id=\"orderBy\"]/input")));
                ordenarPor.selectByValue(trazaDetalleAuditoriaReservaConcepBean.getOrdenarPor());
            }

            if (trazaDetalleAuditoriaReservaConcepBean.getNro_Siniestro() != null){
                Thread.sleep(3000);
                WebElement numeroSiniestro = driver.findElement(By.xpath("//*[@id=\"textFieldClaimNumbre\"]"));
                numeroSiniestro.sendKeys(trazaDetalleAuditoriaReservaConcepBean.getNro_Siniestro());
            }

            //
            if (trazaDetalleAuditoriaReservaConcepBean.getNro_Poliza() != null){
                Thread.sleep(2000);
                WebElement numeroPoliza = driver.findElement(By.xpath("//*[@id=\"textFieldPolicyNumber\"]"));
                numeroPoliza.sendKeys(trazaDetalleAuditoriaReservaConcepBean.getNro_Poliza());
            }

            if (trazaDetalleAuditoriaReservaConcepBean.getFecha_siniestro() != null){
                Thread.sleep(2000);
                WebElement fechaSiniestro = driver.findElement(By.xpath("//*[@id=\"dateFieldOccurrenceDate\"]/input"));
                fechaSiniestro.sendKeys(trazaDetalleAuditoriaReservaConcepBean.getFecha_siniestro());
            }

            if (trazaDetalleAuditoriaReservaConcepBean.getProducto() != null){
                Select producto = new Select(driver.findElement(By.xpath("//*[@id=\"comboProductoSimpleSearch\"]/input")));
                producto.selectByValue(trazaDetalleAuditoriaReservaConcepBean.getProducto());
            }


            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen4", nombreAutomatizacion);
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]/span/span"));//buscar siniestro
            buscar.click();

            Thread.sleep(2000);

            WebElement seleccionar = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[3]/div"));
            seleccionar.click();
            Thread.sleep(2000);
            a.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement consultar = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span/span"));
            consultar.click();

            Thread.sleep(3000);

            a.changeLastWindows(driver);
            a.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion);



        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void ReservaPorConceptos(WebDriver driver, Metodos13_8 a, TrazaDetalleAuditoriaReservaConcepBean trazaDetalleAuditoriaReservaConcepBean, int i) throws IOException, InterruptedException{

        try {
            a.changeLastWindows(driver);
            Thread.sleep(2000);
            WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[13]/form[3]/div/input[1]"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(6000);

            if (trazaDetalleAuditoriaReservaConcepBean.getCobertura() != null){
                Select cobertura = new Select(driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[3]/td[2]/select")));
                Thread.sleep(1000);
                cobertura.selectByVisibleText(trazaDetalleAuditoriaReservaConcepBean.getCobertura());
            }

            Thread.sleep(1500);

            WebElement montoReserva = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[5]/td[2]/input[1]"));
            montoReserva.clear();
            Thread.sleep(1000);
            montoReserva.sendKeys(trazaDetalleAuditoriaReservaConcepBean.getMontoReserva());
            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form[2]/center/table/tbody/tr[6]/td/input[1]"));
            btnAceptar.click();
            Thread.sleep(4000);
            a.ScreenShotPool(driver, i, "screen8", nombreAutomatizacion);
            Thread.sleep(2000);

            driver.close();
            Thread.sleep(1000);
            a.changeLastWindows(driver);
            driver.close();
            Thread.sleep(1000);
            a.changeLastWindows(driver);
            WebElement out = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/table/tbody/tr[1]/td/img"));
            out.click();


        }catch (Exception e) {
            e.printStackTrace();
            //log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void DetalleTrazaAuditoriaReservaConceptos (WebDriver driver, Metodos13_8 a, TrazaDetalleAuditoriaReservaConcepBean trazaDetalleAuditoriaReservaConcepBean, int i) throws IOException, InterruptedException{

        try {

            Thread.sleep(2000);

            WebElement tipoList = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[1]/td[3]/div/div/div[1]/div/div/div[3]/div/div"));
            Thread.sleep(1000);
            tipoList.click();
            Thread.sleep(1000);

            WebElement listaSelect = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[7]/td/span"));
            Thread.sleep(1000);
            listaSelect.click();
            Thread.sleep(1500);

            WebElement categoriaTraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div/div/div[2]/div/table/tbody/tr[2]/td[3]/div/div/div[1]/div/div/div[3]/div/div"));
            Thread.sleep(1000);
            categoriaTraza.click();
            Thread.sleep(1000);

            WebElement categoriaTrazaSelect = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[5]/td/span"));
            Thread.sleep(1000);
            categoriaTrazaSelect.click();
            Thread.sleep(1500);

            WebElement fechaDesdeTraza = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[4]/td[3]/div/div/div[3]/div/div/div[3]/div/input"));
            fechaDesdeTraza.sendKeys(trazaDetalleAuditoriaReservaConcepBean.getFecha_Desde());
            Thread.sleep(1000);

            WebElement fechaHastaTraza = driver.findElement(By.xpath("//*[@id=\"endEventDate\"]/input"));
            Thread.sleep(1000);
            fechaHastaTraza.sendKeys(trazaDetalleAuditoriaReservaConcepBean.getFecha_Hasta());
            Thread.sleep(1500);

            a.ScreenShotPool(driver, i, "screen10", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[2]/div/table/tbody/tr[8]/td[3]/div/div/div/div/span"));
            btnBuscar.click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen11", nombreAutomatizacion);

            Thread.sleep(1500);


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

            a.ScreenShotPool(driver, i, "screen12", nombreAutomatizacion);

            Thread.sleep(1000);

            WebElement maximizar = driver.findElement(By.xpath("/html/body/div[5]/div[5]/div/div/div[3]"));
            maximizar.click();
            Thread.sleep(1000);

            a.ScreenShotPool(driver, i, "screen13", nombreAutomatizacion);


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }


}
