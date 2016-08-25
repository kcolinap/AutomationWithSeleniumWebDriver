package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ListasRestrictivasBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by kzambrano on 25/08/2016.
 */
public class ListasRestrictivas {

    private final static Logger log = Logger.getLogger(ListasRestrictivas.class);

    public String nombreAutomatizacion = "Listas Restrictivas Coincidencias";

    public void testLink (ListasRestrictivasBean listasRestrictivasBean, int i )  throws IOException, InterruptedException {


        //Metodos a = new Metodos();
        Metodos a = new Metodos();
        MenuMantenimiento m = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(1500);
        System.out.println("prueba");

        m.AdminLisRest_CrearListasRestrictivas(a, driver, nombreAutomatizacion);

        Thread.sleep(3000);
        a.cambiarVentana(driver);


        ListasRestrictivasCrear (driver, a, listasRestrictivasBean);
        Thread.sleep(3000);
        a.regresarVentana(driver);
        Thread.sleep(1500);


        m.AdminLisRest_CoincidenciaListasRestrictivas(a, driver, nombreAutomatizacion);

        Thread.sleep(3000);
        a.cambiarVentana(driver);

        CrearCoincidencias (driver, a, listasRestrictivasBean);



    }

    public void ListasRestrictivasCrear (WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{

        try {

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);

          /*  WebElement btnAgregar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/span/span"));
            Thread.sleep(1000);
            btnAgregar.click();
            Thread.sleep(3000);
            a.ScreenShot(driver,"screen5", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement tipo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[1]/div/div/div[2]/div/div"));
            tipo.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement opcion = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td"));
            Thread.sleep(1000);
            opcion.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement nombre = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div"));
            nombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement opcionNombre = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[6]/td/span"));
            Thread.sleep(1000);
            opcionNombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);
            Thread.sleep(3000);



            //WebElement archivo = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div[3]/div/div/div[2]/form/div/input[2]"));
            WebElement archivo = driver.findElement(By.xpath("//input[2]"));



            Thread.sleep(3000);
            //archivo.sendKeys (listasRestrictivasBean.getArchivo());
            //archivo.sendKeys("C://AcseleTests//rutas//PruebaAutomatizacion.xls");
            String nombreRuta = "C:\\AcseleTests\\rutas\\";
            String nombreArchivo = "ListaOFAC.xlsx";
            archivo.sendKeys(nombreRuta+nombreArchivo);
            //archivo.sendKeys("C://AcseleTests//rutas");
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen10", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement pantalla = driver.findElement(By.xpath("//*[@id=\"fieldsListRestrictive\"]/div/div[3]/div/div/div[1]/div"));
            pantalla.click();
            Thread.sleep(5000);

            WebElement btnAceptar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/div/div/div/span/span"));
            btnAceptar.click();
            Thread.sleep(2000);

            */



            WebElement lista = driver.findElement(By.xpath("//*[@id=\"PanelCenter\"]/div[2]/div/div[3]/div/div[3]/div[1]/table/tbody/tr[6]/td[1]/div"));
            Thread.sleep(1000);
            lista.click();
            Thread.sleep(1000);
            a.ScreenShot(driver,"screen11", nombreAutomatizacion);
            Thread.sleep(1500);


            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[7]/div/div[1]/div/span/span"));
            Thread.sleep(1000);
            btnConsultar.click();
            Thread.sleep(2000);


            WebElement ultimaLista = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div/div/span/input"));
            ultimaLista.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen12", nombreAutomatizacion);
            Thread.sleep(1500);

            WebElement btnAcepts = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[3]/div/div/div[1]/div/span/span"));
            Thread.sleep(1000);
            btnAcepts.click();
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen13", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnCerrar = driver.findElement(By.xpath("/html/body/div[3]/div[8]/div/div/div[5]/div/div/div[3]/div/div/div/div/span"));
            btnCerrar.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen14", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement cerrarVentana = driver.findElement(By.xpath("//*[@id=\"46_window_close\"]"));
            cerrarVentana.click();


        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }

    }


    public void CrearCoincidencias (WebDriver driver, Metodos a, ListasRestrictivasBean listasRestrictivasBean) throws IOException, InterruptedException{


        try {

            a.changeLastWindows(driver);
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen16", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement btnAgregarCoinc = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/span"));
            btnAgregarCoinc.click();
            Thread.sleep(1000);

            a.ScreenShot(driver, "screen17", nombreAutomatizacion);
            Thread.sleep(1000);
            WebElement opcionLista = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[1]/div/div/div/table/tbody/tr/td[3]/div/div[1]/div/div/div[3]/div/div"));
            opcionLista.click();
            Thread.sleep(1000);

            WebElement listaNombre = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[6]/td"));
            Thread.sleep(1000);
            listaNombre.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen18", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement opcionCoinc = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[1]/div/div/div/table/tbody/tr/td[3]/div/div[3]/div/div/div[3]/div/div"));
            opcionCoinc.click();
            Thread.sleep(1500);

            WebElement tipoCoinc = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td/span"));
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen19", nombreAutomatizacion);
            Thread.sleep(1000);
            tipoCoinc.click();
            Thread.sleep(2000);
            a.ScreenShot(driver, "screen20", nombreAutomatizacion);

            WebElement primeraopcion = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[4]/div/select/option[1]"));
            primeraopcion.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen21", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnSeleccionar = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span/span"));
            btnSeleccionar.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen22", nombreAutomatizacion);
            Thread.sleep(1000);


            WebElement primeraop = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[4]/div/select/option[1]"));
            primeraop.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen23", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnSelec = driver.findElement(By.xpath("//*[@id=\"WControllervaadinservlet-1750660287-window-overlays\"]/div[5]/div/div/div[5]/div/div/div[1]/div/div[2]/div/div[2]/div/div[5]/div/div[1]/div/span/span"));
            btnSelec.click();
            Thread.sleep(1500);
            a.ScreenShot(driver, "screen24", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[3]/div[5]/div/div/div[5]/div/div/div[2]/div/div[1]/div/span/span"));
            Thread.sleep(1000);
            btnSalvar.click();
            Thread.sleep(2000);


            WebElement ultimaCoinc = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[1]/div"));
            ultimaCoinc.click();
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen25", nombreAutomatizacion);




        }catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);

        }

    }

}





