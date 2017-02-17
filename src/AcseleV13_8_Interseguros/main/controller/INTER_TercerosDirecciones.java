package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TercerosDireccionesBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_BuscarTerceros;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 16/12/2016.
 */

/**
 * modified by kcolina on 17/02/2017
 * implementando herencia de la clase Inter_BuscarTerceros
 */
public class INTER_TercerosDirecciones extends Inter_BuscarTerceros{

    private final static Logger log = Logger.getLogger(INTER_TercerosDirecciones.class);

    public String nombreAutomatizacion = "Direcciones Terceros";
    private WebDriver driver;

    public void testLink(INTER_TercerosDireccionesBean interTercerosDireccionesBean, int i, String folderName){

        try {

            JavascriptExecutor jse = (JavascriptExecutor)driver;
            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();
            Inter_BuscarTerceros buscarTerceros = new Inter_BuscarTerceros();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //Lammada a metodo clase padre Inter_BuscarTerceros
            buscarTerceros.BusquedaT(driver,a,interTercerosDireccionesBean,nombreAutomatizacion,i,folderName, 3,4,5,6);

            //Boton editar
            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();
            Thread.sleep(1000);
            a.waitSearchWicket(driver, "Espere 1");

            //bloque direcciones
            Thread.sleep(2000);
            WebElement dir = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_RelationsLabel']"));
            dir.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + 7, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //BusquedaT(a, interTercerosDireccionesBean, i, folderName, 3, 4); //Busqueda Tercero
            //BotonEditar(a, i, folderName, 5);

            //Agregar Direccion
            AgregarDireccion(a, interTercerosDireccionesBean, i, folderName, 6);

            EditarDireccion(a, interTercerosDireccionesBean, i, folderName, 7);

            SeleccionarDirPrincipal(a, interTercerosDireccionesBean, i, folderName, 8);

            driver.close();
            a.regresarVentana(driver);

            //Entrando en Menu
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 9, i, folderName);
            a.cambiarVentana(driver);

            //BusquedaT(a, interTercerosDireccionesBean, i, folderName, 10, 11);
            //BotonEditar(a, i, folderName, 12);

            //driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }

    public void AgregarDireccion(Interseguros_Metodos a, INTER_TercerosDireccionesBean interTercerosDireccionesBean, int i, String folderName, int numScreenShoot){


        try {//TipoElemento[@wicketpath='WicketpathElemento']
            Thread.sleep(3000);
            // Boton Agregar Direccion
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_AddButton']")).click();
            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere 3");

            Select tipoDefault = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_4_fila_repeaterSelect_1_field']")));
            Thread.sleep(300);
            tipoDefault.selectByVisibleText("Seleccione uno");
            Thread.sleep(800);

            // Referencia Direccion
            if (interTercerosDireccionesBean.getRefDireccion() != null) {    //ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_field
                driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_field']")).sendKeys(interTercerosDireccionesBean.getRefDireccion());
                Thread.sleep(2000);
            }

            // Codigo País
            if (interTercerosDireccionesBean.getCodPais() != null) {
                Select codPais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_1_fila_repeaterSelect_1_field']")));
                codPais.selectByValue(interTercerosDireccionesBean.getCodPais()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Descripcion de la Dirección
            if (interTercerosDireccionesBean.getDescripcionDireccion() != null) {
                driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_2_fila_field']")).sendKeys(interTercerosDireccionesBean.getDescripcionDireccion());
                Thread.sleep(2000);
            }

            // Codigo Departamento
            if (interTercerosDireccionesBean.getCodDepartamento() != null) {
                Select codDepartamento = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_2_fila_repeaterSelect_1_field']")));
                codDepartamento.selectByValue(interTercerosDireccionesBean.getCodDepartamento()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Codigo Provincia
            if (interTercerosDireccionesBean.getCodProvincia() != null) {
                Select codPais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_1_fila_repeaterSelect_1_field']")));
                codPais.selectByValue(interTercerosDireccionesBean.getCodPais()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Numero de FAX
            if (interTercerosDireccionesBean.getNumFax() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_3_fila_field']")).sendKeys(interTercerosDireccionesBean.getNumFax());
                Thread.sleep(2000);
            }

            // Codigo Distrito
            if (interTercerosDireccionesBean.getCodDistrito() != null) {
                Select codDistrito = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_2_fila_repeaterSelect_3_field']")));
                codDistrito.selectByValue(interTercerosDireccionesBean.getCodDistrito()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Tipo Direccion
            if (interTercerosDireccionesBean.getTipoDireccion() != null) {
                Select tipoDireccion = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_4_fila_repeaterSelect_1_field']")));
                Thread.sleep(300);
                tipoDireccion.selectByVisibleText("Seleccione uno");//.selectByValue(interTercerosDireccionesBean.getTipoDireccion());
                Thread.sleep(800);

                Select tipoDireccion2 = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_4_fila_repeaterSelect_1_field']")));
                Thread.sleep(500);
                tipoDireccion2.selectByValue(interTercerosDireccionesBean.getTipoDireccion());
                Thread.sleep(1500);

                Select tipoDireccion3 = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_4_fila_repeaterSelect_1_field']")));
                Thread.sleep(300);
                tipoDireccion3.selectByValue(interTercerosDireccionesBean.getTipoDireccion());
                Thread.sleep(1500);
            }


            // Telefono Fijo
            if (interTercerosDireccionesBean.getTlfFijo() != null) {
                WebElement tlfFijo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_3_fila_field']"));
                Thread.sleep(300);
                tlfFijo.click();
                Thread.sleep(800);
                tlfFijo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_3_fila_field']"));
                Thread.sleep(300);
                tlfFijo.sendKeys(interTercerosDireccionesBean.getTlfFijo());
                Thread.sleep(2000);
            }

            // User Login
            if (interTercerosDireccionesBean.getUserLogin() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_5_fila_field']")).sendKeys(interTercerosDireccionesBean.getUserLogin());
                Thread.sleep(2000);
            }

            // Telefono Celular
            if (interTercerosDireccionesBean.getTlfCelular() != null) {
                WebElement tlfCelular = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']"));
                Thread.sleep(300);
                tlfCelular.clear();
                Thread.sleep(800);
                WebElement tlfFijo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_3_fila_field']"));
                Thread.sleep(300);
                tlfFijo.click();
                tlfCelular = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']"));
                Thread.sleep(800);
                tlfCelular.click();
                Thread.sleep(800);
                //tlfCelular = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']"));
                //Thread.sleep(300);
                tlfCelular = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']"));
                Thread.sleep(800);
                tlfCelular.sendKeys(interTercerosDireccionesBean.getTlfCelular());
                Thread.sleep(2000);
            }

            // Email
            if (interTercerosDireccionesBean.getEmail() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_5_fila_field']")).sendKeys(interTercerosDireccionesBean.getEmail());
                Thread.sleep(2000);
            }

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            // Boton Guardar
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']"));
            btnGuardar.click();
            a.waitSearchWicket(driver, "Espere");
            Thread.sleep(1000);
            btnGuardar.click();
            Thread.sleep(5000);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EditarDireccion(Interseguros_Metodos a, INTER_TercerosDireccionesBean interTercerosDireccionesBean, int i, String folderName, int numScreenShoot){

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);
            // Seleccionar la direccion
            WebElement direccion = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_container_ThirdAddress_1_radio']"));
            direccion.click();

            if (direccion.isSelected()) {
                // Boton Editar
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_EditButton']")).click();
                Thread.sleep(1000);

                a.waitSearchWicket(driver, "Espere 4");

                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

                // Boton Guardar
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']")).click();
                Thread.sleep(1000);

                a.waitSearchWicket(driver, "Espere 5");
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void SeleccionarDirPrincipal(Interseguros_Metodos a, INTER_TercerosDireccionesBean interTercerosDireccionesBean, int i, String folderName, int numScreenShoot){


        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Seleccionar la poliza
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_container_ThirdAddress_3_radio']")).click();
            Thread.sleep(2000);

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);

            // Boton "Definir como principal"
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_DefineMain']"));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    /*   public void BusquedaT(Interseguros_Metodos a, INTER_TercerosDireccionesBean interTercerosDireccionesBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try {

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title); // //TipoElemento[@wicketpath='WicketpathElemento']

            //Tipo de tercero

            if (interTercerosDireccionesBean.getTipoTerceros() != null) {
                Thread.sleep(3000);
                //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(interTercerosDireccionesBean.getTipoTerceros());
            }

            Thread.sleep(2000);

            if (interTercerosDireccionesBean.getNumDocIdentidad() != null) {
                //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                cedu.sendKeys(interTercerosDireccionesBean.getNumDocIdentidad());
            }

            if (interTercerosDireccionesBean.getApellidoPaterno() != null) {
                //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                apellido.sendKeys(interTercerosDireccionesBean.getApellidoPaterno());
            }

            if (interTercerosDireccionesBean.getPrimerNombre() != null) {
                //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nTercero.sendKeys(interTercerosDireccionesBean.getPrimerNombre());
            }

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            //WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }*/

  /*  public void BotonEditar(Interseguros_Metodos a, int i, String folderName, int numScreenShoot){


        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();

            Thread.sleep(1000);

            a.waitSearchWicket(driver, "Espere 1");

            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }*/
}
