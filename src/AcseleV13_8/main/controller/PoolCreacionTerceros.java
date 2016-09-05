package AcseleV13_8.main.controller;

import AcseleV13_8.beans.EdicionTercerosBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 07/06/2016.
 */
public class PoolCreacionTerceros {

    String nombreAutomatizacion = "Creacion y edicion Terceros";

    public void testLink(EdicionTercerosBean edicionTercerosBean, int i)throws Exception{


        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        // Creacion del Tercero
        IngresarMenuIngresarTercero(driver, a);
        Thread.sleep(2000);
        a.cambiarVentana(driver); // Cambiar de ventana
        Thread.sleep(2000);
        CreacionT(a,driver, edicionTercerosBean); //Creacion Terceros
        a.regresarVentana(driver);

        // Consulta del Tercero Creado
        IngresarMenuBuscarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, edicionTercerosBean); //Busqueda Tercero
        a.regresarVentana(driver);

        // Creacion Tercero Repetido
        IngresarMenuIngresarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        CreacionR(a, driver, edicionTercerosBean); // Creo Tercero Repetido
        a.regresarVentana(driver);

        // Edicion Tercero creado
        IngresarMenuBuscarTercero(driver, a);
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        EdicionT(a, driver, edicionTercerosBean);

    }

    public void IngresarMenuIngresarTercero(WebDriver driver, Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[2]"));//Mantenimiento de terceros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[36]/div[1]"));//ingresar tercero
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
        menu3.click();
    }

    public void IngresarMenuBuscarTercero(WebDriver driver, Metodos a) throws IOException, InterruptedException {
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[3]/div[4]"));// Mantenimiento
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[35]/div[2]"));//Mantenimiento de terceros
        WebElement menu3 = driver.findElement(By.xpath("/html/body/div[36]/div[2]"));//buscar tercero
        menu1.click();
        menu2.click();
        a.ScreenShot(driver, "screen3", nombreAutomatizacion); //screenshot2
        menu3.click();
    }

    public void CreacionT(Metodos a, WebDriver driver, EdicionTercerosBean edicionTercerosBean) throws InterruptedException, IOException {
        //
        Thread.sleep(2000);
        if (edicionTercerosBean.getTipoTercero() != null){
            Thread.sleep(2000);
            Select tipoTercero = new Select(driver.findElement(By.name("ThirdInformationContent:ThirdInformation:thirdPartyTypes")));
            tipoTercero.selectByValue(edicionTercerosBean.getTipoTercero());
        }

        if (edicionTercerosBean.getTipoDocIdentidad() != null) {
            Thread.sleep(2000);
            Select tipoDocIden = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDocIden.selectByValue(edicionTercerosBean.getTipoDocIdentidad());
        }

        if (edicionTercerosBean.getCedula() != null) {
            Thread.sleep(2000);
            WebElement cedula2 = driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field"));
            cedula2.sendKeys(edicionTercerosBean.getCedula());
            System.out.println("Ingresa la cedula del tercero");
        }

        Thread.sleep(2000);

        if (edicionTercerosBean.getNombre() != null) {
            // Nombre
            WebElement namefield = driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field"));
            namefield.clear();
            namefield.sendKeys(edicionTercerosBean.getNombre());
            System.out.println("Ingresa el nombre del tercero");
        }

        if (edicionTercerosBean.getApellido() != null) {
            // Apellido
            WebElement lastNameField = driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field"));
            //if(lastNameField.equals("")){
            lastNameField.clear();
            lastNameField.sendKeys(edicionTercerosBean.getApellido());
            System.out.println("Ingresa el apellido del tercero");
        }

        // Boton Guardar
        WebElement guardar = driver.findElement(By.name("saveButton"));
        guardar.click();

        Thread.sleep(4000);

        //Aceptar Error
        driver.findElement(By.name("AcceptButton")).click();

        Thread.sleep(2000);
        // Nombre
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).sendKeys(edicionTercerosBean.getNombre());
        System.out.println("Ingresa el nombre del tercero");

        // Apellido
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).sendKeys(edicionTercerosBean.getApellido());
        System.out.println("Ingresa el apellido del tercero");

        // Boton Guardar
        guardar = driver.findElement(By.name("saveButton"));
        guardar.click();

        Thread.sleep(4000);
        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(3000);

        System.out.println("Fin de la Creacion");
        driver.close();
    }

    public void CreacionR(Metodos a, WebDriver driver, EdicionTercerosBean edicionTercerosBean) throws InterruptedException, IOException {
        //
        Thread.sleep(2000);
        if (edicionTercerosBean.getTipoTercero() != null){
            Thread.sleep(2000);
            Select tipoTercero = new Select(driver.findElement(By.name("ThirdInformationContent:ThirdInformation:thirdPartyTypes")));
            tipoTercero.selectByValue(edicionTercerosBean.getTipoTercero());
        }

        if (edicionTercerosBean.getTipoDocIdentidad() != null) {
            Thread.sleep(2000);
            Select tipoDocIden = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDocIden.selectByValue(edicionTercerosBean.getTipoDocIdentidad());
        }

        if (edicionTercerosBean.getCedula() != null) {
            Thread.sleep(2000);
            WebElement cedula2 = driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field"));
            cedula2.sendKeys(edicionTercerosBean.getCedula());
            System.out.println("Ingresa la cedula del tercero");
        }

        Thread.sleep(2000);

        if (edicionTercerosBean.getNombre() != null) {
            // Nombre
            WebElement namefield = driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field"));
            namefield.clear();
            namefield.sendKeys(edicionTercerosBean.getNombre());
            System.out.println("Ingresa el nombre del tercero");
        }

        if (edicionTercerosBean.getApellido() != null) {
            // Apellido
            WebElement lastNameField = driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field"));
            //if(lastNameField.equals("")){
            lastNameField.clear();
            lastNameField.sendKeys(edicionTercerosBean.getApellido());
            System.out.println("Ingresa el apellido del tercero");
        }

        // Boton Guardar
        WebElement guardar = driver.findElement(By.name("saveButton"));
        guardar.click();

        Thread.sleep(4000);

        //Aceptar Error
        driver.findElement(By.name("AcceptButton")).click();

        Thread.sleep(2000);
        // Nombre
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).sendKeys(edicionTercerosBean.getNombre());
        System.out.println("Ingresa el nombre del tercero");

        // Apellido
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).sendKeys(edicionTercerosBean.getApellido());
        System.out.println("Ingresa el apellido del tercero");

        // Boton Guardar
        guardar = driver.findElement(By.name("saveButton"));
        guardar.click();

        Thread.sleep(4000);
        //Screenshot
        a.ScreenShot(driver, "Screen8", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
        Thread.sleep(3000);

        System.out.println("Fin de la Creacion");
        driver.close();
    }

    public void BusquedaT(Metodos a, WebDriver driver, EdicionTercerosBean edicionTercerosBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (edicionTercerosBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            tipoT.selectByValue(edicionTercerosBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (edicionTercerosBean.getTipoDocIdentidad() != null){
            Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDoc.selectByValue(edicionTercerosBean.getTipoDocIdentidad());
        }

        if (edicionTercerosBean.getCedula() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            cedu.sendKeys(edicionTercerosBean.getCedula());
        }

        if (edicionTercerosBean.getNombre() != null) {
            WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            nTercero.sendKeys(edicionTercerosBean.getNombre());
        }

//        if (edicionTercerosBean.getApellido() != null) {
//            WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
//            aTercero.sendKeys(edicionTercerosBean.getApellido());
//        }

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        WebElement buscar = driver.findElement(By.name("searchButton"));
        buscar.click();
        Thread.sleep(3000);



        WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
        selccionTercero.click();

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        WebElement consultar = driver.findElement(By.name("consultThirdButton"));
        consultar.click();

        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        Thread.sleep(3000);
        driver.close();
    }

    public void EdicionT(Metodos a, WebDriver driver, EdicionTercerosBean edicionTercerosBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (edicionTercerosBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            tipoT.selectByValue(edicionTercerosBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (edicionTercerosBean.getTipoDocIdentidad() != null){
            Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDoc.selectByValue(edicionTercerosBean.getTipoDocIdentidad());
        }

        if (edicionTercerosBean.getCedula() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            cedu.sendKeys(edicionTercerosBean.getCedula());
        }

        if (edicionTercerosBean.getNombre() != null) {
            WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            nTercero.sendKeys(edicionTercerosBean.getNombre());
        }

//        if (edicionTercerosBean.getApellido() != null) {
//            WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
//            aTercero.sendKeys(edicionTercerosBean.getApellido());
//        }

        //Screenshot
        a.ScreenShot(driver, "screen9", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        WebElement buscar = driver.findElement(By.name("searchButton"));
        buscar.click();
        Thread.sleep(3000);

        WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
        selccionTercero.click();

        //Screenshot
        a.ScreenShot(driver, "screen10", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        WebElement consultar = driver.findElement(By.name("consultThirdButton"));
        consultar.click();

        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen11", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        if (edicionTercerosBean.getCedulaNuevo() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field"));
            cedu.clear();
            cedu.sendKeys(edicionTercerosBean.getCedulaNuevo());
        }

        //Screenshot
        a.ScreenShot(driver, "screen12", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        // Boton Guardar
        driver.findElement(By.name("saveButton")).click();

        Thread.sleep(3000);
        //Screenshot
        a.ScreenShot(driver, "screen13", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

    }


}
