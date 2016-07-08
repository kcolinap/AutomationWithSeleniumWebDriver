package main.controller;


import beans.EdicionTercerosBean;
import beans.TercerosDireccionesBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 09/06/2016.
 */
public class TercerosDirecciones {

    String nombreAutomatizacion = "Direcciones Terceros";

    public void testLink(TercerosDireccionesBean tercerosDireccionesBean, int i)throws Exception{


        //implementando clase de metodos
        Metodos a = new Metodos();
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion);
        a.ValidandoSesion(driver, nombreAutomatizacion);
        Thread.sleep(5000);

        // Consulta del Tercero Creado
        IngresarMenuBuscarTercero(driver, a); //Menu
        Thread.sleep(2000);
        a.cambiarVentana(driver);
        Thread.sleep(2000);
        BusquedaT(a, driver, tercerosDireccionesBean); //Busqueda Tercero
        BotonEditar(a, driver);
        //Agregar Direccion
        AgregarDireccion(a, driver, tercerosDireccionesBean);

        EditarDireccion(a, driver, tercerosDireccionesBean);

        SeleccionarDirPrincipal(a, driver,tercerosDireccionesBean);

        driver.close();
        a.regresarVentana(driver);

        IngresarMenuBuscarTercero(driver, a);
        a.cambiarVentana(driver);

        BusquedaT(a, driver, tercerosDireccionesBean);
        BotonEditar(a, driver);

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

    public void BusquedaT(Metodos a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title); // //TipoElemento[@wicketpath='WicketpathElemento']

        //Tipo de tercero
        if (tercerosDireccionesBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(tercerosDireccionesBean.getTipoTercero());
        }
        Thread.sleep(2000);

        if (tercerosDireccionesBean.getTipoDocId() != null){
            //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDoc.selectByValue(tercerosDireccionesBean.getTipoDocId());
        }

        if (tercerosDireccionesBean.getNumCedula() != null) {
            //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            cedu.sendKeys(tercerosDireccionesBean.getNumCedula());
        }

        if (tercerosDireccionesBean.getNombre() != null) {
            //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            nTercero.sendKeys(tercerosDireccionesBean.getNombre());
        }

//        if (edicionTercerosBean.getApellido() != null) {
//            WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
            WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(edicionTercerosBean.getApellido());
//        }

        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();

        //WebElement buscar = driver.findElement(By.name("searchButton"));
        WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
        buscar.click();
        Thread.sleep(5000);

        //WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
        WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
        selccionTercero.click();

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
/*****/


//        Thread.sleep(3000);
//        driver.close();
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

    public void BotonEditar(Metodos a, WebDriver driver) throws InterruptedException, IOException {
        WebElement editar = driver.findElement(By.name("associateButton"));
        editar.click();

        Thread.sleep(5000);

        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);
        Toolkit.getDefaultToolkit().beep();
    }

    public void AgregarDireccion(Metodos a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException {

        Thread.sleep(5000);
        // Boton Agregar Direccion
        driver.findElement(By.xpath("//div[2]/div[2]/div/div/form/div[2]/div/input")).click();
        Thread.sleep(3000);

        // Tipo Direccion
        if (tercerosDireccionesBean.getTipoDireccion() != null){
            Select tipDirecc = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            tipDirecc.selectByValue(tercerosDireccionesBean.getTipoDireccion()); //8548517=Residencia; 8548717=Correspondencia; 8548617=Comercial
            Thread.sleep(3000);
        }

        // Tipo Via
        if (tercerosDireccionesBean.getTipoVia() != null){
            Select tipVia = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:2:fila:repeaterSelect:1:field")));
            tipVia.selectByValue(tercerosDireccionesBean.getTipoVia()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
            Thread.sleep(2000);
        }

        // Numero o Nombre Via Ppal
        if (tercerosDireccionesBean.getNumNomViaPpal() != null){
            driver.findElement(By.name("templateBasicThird:repeaterPanel1:4:fila:field")).sendKeys(tercerosDireccionesBean.getNumNomViaPpal());
            Thread.sleep(2000);
        }

        // Prefijo (BIS) Via Ppal
        if (tercerosDireccionesBean.getPrefBisViaPpal() != null){
            Select preBis = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:6:fila:repeaterSelect:1:field")));
//            Select preBis = new Select(driver.findElement(By.id("id2b9")));
            preBis.selectByValue(tercerosDireccionesBean.getPrefBisViaPpal()); // 19636217=BIS
            preBis.selectByValue(tercerosDireccionesBean.getPrefBisViaPpal());
            Thread.sleep(2000);
        }

        // Letra o Número Prefijo Vía Ppal
        if (tercerosDireccionesBean.getLetraNumPrefViaPpal() != null){
            driver.findElement(By.name("templateBasicThird:repeaterPanel1:7:fila:field")).sendKeys(tercerosDireccionesBean.getLetraNumPrefViaPpal());
            Thread.sleep(2000);
        }

        // Cuadrante Via Ppal
        if (tercerosDireccionesBean.getCuadranteViaPpal() != null){
            Select cuadViaPpal = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:8:fila:repeaterSelect:1:field")));
            cuadViaPpal.selectByValue(tercerosDireccionesBean.getCuadranteViaPpal());
//            Thread.sleep(2000);
        }

        // Número Vía Generadora
        if (tercerosDireccionesBean.getNumViaGeneradora() != null){
            driver.findElement(By.name("templateBasicThird:repeaterPanel1:9:fila:field")).sendKeys(tercerosDireccionesBean.getNumViaGeneradora());
            Thread.sleep(2000);
        }

        // Pais
        if (tercerosDireccionesBean.getPais() != null){
            Select sPais = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:15:fila:repeaterSelect:1:field")));
//            sPais.selectByValue("45788717"); //45788717=Alemania
//            Thread.sleep(3000);
            sPais.selectByValue(tercerosDireccionesBean.getPais());
            Thread.sleep(3000);
        }

        // Departamento
        if (tercerosDireccionesBean.getDepartamento() != null){
            Select sDep = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:15:fila:repeaterSelect:2:field")));
            sDep.selectByValue(tercerosDireccionesBean.getDepartamento());
            //sDep.selectByVisibleText("BOGOTA");
//            Thread.sleep(2000);
        }

//        // Ciudad
//        if (tercerosDireccionesBean.getCiudad() != null){
//            Select sCiud = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:15:fila:repeaterSelect:3:field")));
//            sCiud.selectByValue(tercerosDireccionesBean.getCiudad());
//            //Thread.sleep(2000);
//        }

        // Boton Guardar
        driver.findElement(By.xpath("//div[2]/div/div[2]/input")).click();
        Thread.sleep(5000);
    }

    public void EditarDireccion(Metodos a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException {

        Thread.sleep(3000);
        // Seleccionar la poliza
        driver.findElement(By.xpath("//td/div/input")).click();

        if (driver.findElement(By.xpath("//td/div/input")).isSelected()) {
            // Boton Editar
            driver.findElement(By.xpath("//div[2]/div[2]/div/div/form/div[2]/div[2]/input")).click();
            Thread.sleep(2000);

            // Tipo Direccion
            if (tercerosDireccionesBean.getNuevoTipoDireccion() != null){
                Select tipDirecc = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
                tipDirecc.selectByValue(tercerosDireccionesBean.getNuevoTipoDireccion()); //8548517=Residencia; 8548717=Correspondencia; 8548617=Comercial
                Thread.sleep(3000);
            }

            // Tipo Via
            if (tercerosDireccionesBean.getNuevoTipoVia() != null){
                Select tipVia = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:2:fila:repeaterSelect:1:field")));
                tipVia.selectByValue(tercerosDireccionesBean.getNuevoTipoVia()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }
            /***/
            // Numero o Nombre Via Ppal
            if (tercerosDireccionesBean.getNuevoNumNomViaPpal() != null){
                driver.findElement(By.name("templateBasicThird:repeaterPanel1:4:fila:field")).sendKeys(tercerosDireccionesBean.getNuevoNumNomViaPpal());
                Thread.sleep(2000);
            }

            // Prefijo (BIS) Via Ppal
            if (tercerosDireccionesBean.getNuevoPrefBisViaPpal() != null){
                Select preBis = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:6:fila:repeaterSelect:1:field")));
                preBis.selectByValue(tercerosDireccionesBean.getNuevoPrefBisViaPpal());
                Thread.sleep(2000);
            }

            // Letra o Número Prefijo Vía Ppal
            if (tercerosDireccionesBean.getNuevoLetraNumPrefViaPpal() != null){
                driver.findElement(By.name("templateBasicThird:repeaterPanel1:7:fila:field")).sendKeys(tercerosDireccionesBean.getNuevoLetraNumPrefViaPpal());
                Thread.sleep(2000);
            }

            // Cuadrante Via Ppal
            if (tercerosDireccionesBean.getNuevoCuadranteViaPpal() != null){
                Select cuadViaPpal = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:8:fila:repeaterSelect:1:field")));
                cuadViaPpal.selectByValue(tercerosDireccionesBean.getNuevoCuadranteViaPpal());
//            Thread.sleep(2000);
            }

            // Número Vía Generadora
            if (tercerosDireccionesBean.getNuevoNumViaGeneradora() != null){
                driver.findElement(By.name("templateBasicThird:repeaterPanel1:9:fila:field")).sendKeys(tercerosDireccionesBean.getNuevoNumViaGeneradora());
                Thread.sleep(2000);
            }

            // Pais
            if (tercerosDireccionesBean.getNuevoPais() != null){
                Select sPais = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:15:fila:repeaterSelect:1:field")));
                sPais.selectByValue(tercerosDireccionesBean.getNuevoPais());
                Thread.sleep(3000);
            }

            // Departamento
            if (tercerosDireccionesBean.getNuevoDepartamento() != null){
                Select sDep = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:15:fila:repeaterSelect:2:field")));
                sDep.selectByValue(tercerosDireccionesBean.getNuevoDepartamento());
                //sDep.selectByVisibleText("BOGOTA");
//            Thread.sleep(2000);
            }

//        // Ciudad
//        if (tercerosDireccionesBean.getNuevoCiudad() != null){
//            Select sCiud = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:15:fila:repeaterSelect:3:field")));
//            sCiud.selectByValue(tercerosDireccionesBean.getNuevoCiudad());
//            //Thread.sleep(2000);
//        }

            // Boton Guardar
            driver.findElement(By.xpath("//div[2]/div/div[2]/input")).click();
            Thread.sleep(5000);
        }

        while (!driver.findElement(By.xpath("//td/div/input")).isSelected()){

        }

    }

    public void SeleccionarDirPrincipal(Metodos a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException {

        Thread.sleep(2000);

        //Seleccionar la poliza
        driver.findElement(By.xpath("//td/div/input")).click();
        Thread.sleep(2000);

        // Boton "Definir como principal"
        driver.findElement(By.xpath("//div[2]/input[2]"));
    }
}
