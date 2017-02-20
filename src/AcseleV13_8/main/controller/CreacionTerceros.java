package AcseleV13_8.main.controller;

import AcseleV13_8.beans.CreacionTercerosBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by agil on 30/05/2016.
 */
public class CreacionTerceros {
    public String nombreAutomatizacion = "Creacion LBC_Terceros";

    public void testLink(CreacionTercerosBean creacionTercerosBean, int i)throws Exception{


        // Instanciando clases
        Metodos13_8 a = new Metodos13_8();
        MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i);
        a.ValidandoSesion(driver, nombreAutomatizacion, i);
        Thread.sleep(5000);

        //Entrando en Menu
        menuMantenimiento.MantTerc_IngresarTercero(a, driver, nombreAutomatizacion, 2);

        Thread.sleep(2000);
        a.cambiarVentana(driver); // Cambiar de ventana
        Thread.sleep(5000);

        CreacionT(a,driver, creacionTercerosBean);
        Thread.sleep(5000);
    }

    public void CreacionT(Metodos13_8 a, WebDriver driver, CreacionTercerosBean creacionTercerosBean) throws InterruptedException, IOException {

        //Select tipoTercero = new Select(driver.findElement(By.name("ThirdInformationContent:ThirdInformation:thirdPartyTypes")));
        Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
        tipoTercero.selectByValue(creacionTercerosBean.getTipoTercero());

        Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

        //Select tipoDocIden = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:1:fila:repeaterSelect:1:field")));
        Select tipoDocIden = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
        tipoDocIden.selectByValue(creacionTercerosBean.getTipoDocIdentidad());

        Thread.sleep(2000);
        //WebElement cedula2 = driver.findElement(By.name("DataTemplate:repeaterPanel1:2:fila:field"));
        WebElement cedula2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_2_fila_field']"));
        cedula2.sendKeys(creacionTercerosBean.getCedula());
        System.out.println("Ingresa la cedula del tercero");

        Thread.sleep(2000);


        // Nombre
        //WebElement namefield = driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field"));
        WebElement namefield = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
        //if(namefield.equals("")){
        namefield.clear();
        namefield.sendKeys(creacionTercerosBean.getNombre());
        System.out.println("Ingresa el nombre del tercero");

        // Apellido
        //WebElement lastNameField = driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field"));
        WebElement lastNameField = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
        //if(lastNameField.equals("")){
        lastNameField.clear();
        lastNameField.sendKeys(creacionTercerosBean.getApellido());
        System.out.println("Ingresa el apellido del tercero");
        //}
        // Estado Civil
//            Select estCivil2 = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:8:fila:repeaterSelect:1:field")));
//            estCivil2.selectByValue(civilEdo);
//            System.out.println("Seleccionar el estado civil del tercero");

        //}


//        // Sexo
//        Select sexo2 = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:16:fila:repeaterSelect:1:field")));
//        sexo2.selectByValue(sexoT);
//        // Fecha de nacimiento
//        WebElement fechaNac2 = driver.findElement(By.name("DataTemplate:repeaterPanel2:14:fila:fieldDate"));
//        fechaNac2.sendKeys(fechaNacT);
//        Thread.sleep(2000);
//        estCivil2 = new Select(driver.findElement(By.name("DataTemplate:repeaterPanel1:14:fila:repeaterSelect:1:field")));
//        estCivil2.selectByValue(civilEdo);
//        Thread.sleep(2000);

        // Boton Guardar
        //WebElement guardar = driver.findElement(By.name("saveButton"));
        WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
        guardar.click();

        //Screenshot
        a.ScreenShot(driver, "Screenshot3", nombreAutomatizacion);
        Thread.sleep(3000);

        //Aceptar Error
        //driver.findElement(By.name("AcceptButton")).click();
        driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_errorsPanel_content_errorsForm_AcceptButton']")).click();

        Thread.sleep(2000);
        // Nombre
        //namefield = driver.findElement(By.name("DataTemplate:repeaterPanel1:3:fila:field"));
        namefield = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_3_fila_field']"));
        //if(namefield.equals("")){
        namefield.clear();
        namefield.sendKeys(creacionTercerosBean.getNombre());
        System.out.println("Ingresa el nombre del tercero");

        // Apellido
        //lastNameField = driver.findElement(By.name("DataTemplate:repeaterPanel1:5:fila:field"));
        lastNameField = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_5_fila_field']"));
        //if(lastNameField.equals("")){
        lastNameField.clear();
        lastNameField.sendKeys(creacionTercerosBean.getApellido());
        System.out.println("Ingresa el apellido del tercero");

        // Boton Guardar
        //guardar = driver.findElement(By.name("saveButton"));
        guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
        guardar.click();
    }

//    public void AsignacionesVarias(Metodos a,WebDriver driver, String rolT, String direccionT) throws InterruptedException, IOException {
//        //Roles
//        Select rol2 = new Select(driver.findElement(By.name("rolComb")));
//        rol2.selectByValue(rolT);
//        WebElement agregarRoll = driver.findElement(By.id("AddButton33d"));
//        agregarRoll.click();
//        Thread.sleep(3000);
//        WebElement saveRol = driver.findElement(By.id("saveButton384"));
//        saveRol.click();
//        Thread.sleep(3000);
//
//        //Direcciones
//        WebElement agregarDireccion = driver.findElement(By.id("AddButton3a1"));
//        agregarDireccion.click();
//        Thread.sleep(4000);
//        /*Select pais = new Select(driver.findElement(By.name("//*[@id=\"field3ff\"]")));
//        pais.selectByValue("856817"); //856817:PERU*/
//        WebElement descDireccion = driver.findElement(By.name("templateBasicThird:repeaterPanel2:2:fila:field"));
//        descDireccion.sendKeys("Peru, Casa de QA");
//        Thread.sleep(2000);
//        Select codDepartamento = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:2:fila:repeaterSelect:1:field")));
//        codDepartamento.selectByValue("1119657"); //1119657:LIMA
//        Thread.sleep(2000);
//        Select codProvincia = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:2:fila:repeaterSelect:2:field")));
//        codProvincia.selectByValue("128.0"); //128.0:LIMA
//        Thread.sleep(2000);
//        Select codDistrito = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel1:2:fila:repeaterSelect:3:field")));
//        codDistrito.selectByValue("1251.0"); //1251.0:LIMA
//        Thread.sleep(2000);
//        Select tipoDireccion = new Select(driver.findElement(By.name("templateBasicThird:repeaterPanel2:4:fila:repeaterSelect:1:field")));
//        tipoDireccion.selectByValue("726417"); // 726417:Trabajo
//
//        Thread.sleep(2000);
//        WebElement guardarDireccion = driver.findElement(By.id("saveButton40d"));
//        guardarDireccion.click();
//
//        Thread.sleep(2000);
//        //Screenshot
//        a.ScreenShot(driver, "Screenshot4");
//    }
}
