package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CreacionEdicionTercerosBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 07/06/2016.
 */
public class CreacionEdicionTerceros {

    private final static Logger log = Logger.getLogger(CreacionEdicionTerceros.class);

    public String nombreAutomatizacion = "Creacion y edicion Terceros";

    public void testLink(CreacionEdicionTercerosBean creacionEdicionTercerosBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Creacion del Tercero
            menuMantenimiento.MantTerc_IngresarTercero(a, driver, nombreAutomatizacion, 2);
            Thread.sleep(2000);
            a.cambiarVentana(driver); // Cambiar de ventana
            Thread.sleep(2000);
            CreacionT(a,driver, creacionEdicionTercerosBean); //Creacion Terceros
            a.regresarVentana(driver);

            // Consulta del Tercero Creado
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 3);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, creacionEdicionTercerosBean); //Busqueda Tercero
            a.regresarVentana(driver);

            // Creacion Tercero Repetido
            menuMantenimiento.MantTerc_IngresarTercero(a, driver, nombreAutomatizacion, 2);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            CreacionR(a, driver, creacionEdicionTercerosBean); // Creo Tercero Repetido
            a.regresarVentana(driver);

            // Edicion Tercero creado
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 3);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            EdicionT(a, driver, creacionEdicionTercerosBean);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void CreacionT(Metodos a, WebDriver driver, CreacionEdicionTercerosBean creacionEdicionTercerosBean) throws InterruptedException, IOException {

        //TipoElemento[@wicketpath='WicketpathElemento']
        Thread.sleep(2000);
        if (creacionEdicionTercerosBean.getTipoTercero() != null){
            Thread.sleep(2000);
            Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
            tipoTercero.selectByValue(creacionEdicionTercerosBean.getTipoTercero());
        }

        Thread.sleep(3000);
        if (creacionEdicionTercerosBean.getTipoDocIdentidad() != null) {
            Thread.sleep(2000);
            Select tipoDocIden = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDocIden.selectByValue(creacionEdicionTercerosBean.getTipoDocIdentidad());
        }

        if (creacionEdicionTercerosBean.getCedula() != null) {
            Thread.sleep(2000);
            WebElement cedula2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
            cedula2.sendKeys(creacionEdicionTercerosBean.getCedula());
            System.out.println("Ingresa la cedula del tercero");
        }

        Thread.sleep(2000);

        if (creacionEdicionTercerosBean.getNombre() != null) {
            // Nombre
            WebElement namefield = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
           /* namefield.clear();
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());
            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_etiqueta']"));
            otroElemento.click();*/
            Thread.sleep(1000);
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());

            Thread.sleep(1000);
            WebElement cedula2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
            cedula2.click();

            namefield = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
            Thread.sleep(1000);
            namefield.clear();
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());

            System.out.println("Ingresa el nombre del tercero");
        }

        Thread.sleep(2000);
        if (creacionEdicionTercerosBean.getApellido() != null) {
            // Apellido
            WebElement lastNameField = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));

           /* lastNameField.clear();
            lastNameField.sendKeys(creacionEdicionTercerosBean.getApellido());

            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_etiqueta']"));
            otroElemento.click();
            Thread.sleep(500);
            lastNameField.clear();*/
            lastNameField.click();
            Thread.sleep(2000);
            lastNameField.sendKeys(creacionEdicionTercerosBean.getApellido());
            System.out.println("Ingresa el apellido del tercero");
        }

        if (creacionEdicionTercerosBean.getNombre() != null) {
            // Nombre
            WebElement namefield = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
           /* namefield.clear();
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());
            WebElement otroElemento = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_6_fila_etiqueta']"));
            otroElemento.click();*/
            namefield.click();
            Thread.sleep(1000);
            namefield.clear();
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());

            Thread.sleep(1000);
            namefield.clear();
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());
            System.out.println("Ingresa el nombre del tercero");
        }

        // Boton Guardar
        WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
        guardar.click();

        Thread.sleep(1000);
        /** Espere **/
        WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
        while (mensajeEspera.isDisplayed()) {
            Thread.sleep(5000);
            System.out.println("Espera 1");
        }

        //Aceptar Error
        driver.findElement(By.name("AcceptButton")).click();

        Thread.sleep(2000);
        // Nombre
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).sendKeys(creacionEdicionTercerosBean.getNombre());
        System.out.println("Ingresa el nombre del tercero");

        // Apellido
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).sendKeys(creacionEdicionTercerosBean.getApellido());
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

    public void CreacionR(Metodos a, WebDriver driver, CreacionEdicionTercerosBean creacionEdicionTercerosBean) throws InterruptedException, IOException {
        //
        Thread.sleep(2000);
        if (creacionEdicionTercerosBean.getTipoTercero() != null){
            Thread.sleep(2000);
            Select tipoTercero = new Select(driver.findElement(By.name("ThirdInformationContent:ThirdInformation:thirdPartyTypes")));
            tipoTercero.selectByValue(creacionEdicionTercerosBean.getTipoTercero());
        }

        if (creacionEdicionTercerosBean.getTipoDocIdentidad() != null) {
            Thread.sleep(2000);
            Select tipoDocIden = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDocIden.selectByValue(creacionEdicionTercerosBean.getTipoDocIdentidad());
        }

        if (creacionEdicionTercerosBean.getCedula() != null) {
            Thread.sleep(2000);
            WebElement cedula2 = driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field"));
            cedula2.sendKeys(creacionEdicionTercerosBean.getCedula());
            System.out.println("Ingresa la cedula del tercero");
        }

        Thread.sleep(2000);

        if (creacionEdicionTercerosBean.getNombre() != null) {
            // Nombre
            WebElement namefield = driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field"));
            namefield.clear();
            namefield.sendKeys(creacionEdicionTercerosBean.getNombre());
            System.out.println("Ingresa el nombre del tercero");
        }

        if (creacionEdicionTercerosBean.getApellido() != null) {
            // Apellido
            WebElement lastNameField = driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field"));
            //if(lastNameField.equals("")){
            lastNameField.clear();
            lastNameField.sendKeys(creacionEdicionTercerosBean.getApellido());
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
        driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field")).sendKeys(creacionEdicionTercerosBean.getNombre());
        System.out.println("Ingresa el nombre del tercero");

        // Apellido
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).clear();
        driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field")).sendKeys(creacionEdicionTercerosBean.getApellido());
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

    public void BusquedaT(Metodos a, WebDriver driver, CreacionEdicionTercerosBean creacionEdicionTercerosBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (creacionEdicionTercerosBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            tipoT.selectByValue(creacionEdicionTercerosBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (creacionEdicionTercerosBean.getTipoDocIdentidad() != null){
            Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDoc.selectByValue(creacionEdicionTercerosBean.getTipoDocIdentidad());
        }

        if (creacionEdicionTercerosBean.getCedula() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            cedu.sendKeys(creacionEdicionTercerosBean.getCedula());
        }

        if (creacionEdicionTercerosBean.getNombre() != null) {
            WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            nTercero.sendKeys(creacionEdicionTercerosBean.getNombre());
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

    public void EdicionT(Metodos a, WebDriver driver, CreacionEdicionTercerosBean creacionEdicionTercerosBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (creacionEdicionTercerosBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            tipoT.selectByValue(creacionEdicionTercerosBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (creacionEdicionTercerosBean.getTipoDocIdentidad() != null){
            Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipoDoc.selectByValue(creacionEdicionTercerosBean.getTipoDocIdentidad());
        }

        if (creacionEdicionTercerosBean.getCedula() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            cedu.sendKeys(creacionEdicionTercerosBean.getCedula());
        }

        if (creacionEdicionTercerosBean.getNombre() != null) {
            WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            nTercero.sendKeys(creacionEdicionTercerosBean.getNombre());
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

        if (creacionEdicionTercerosBean.getCedulaNuevo() != null) {
            //WebElement cedu = getDriver().findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field"));
            cedu.clear();
            cedu.sendKeys(creacionEdicionTercerosBean.getCedulaNuevo());
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
