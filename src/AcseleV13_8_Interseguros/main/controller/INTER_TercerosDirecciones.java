package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TercerosDireccionesBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 16/12/2016.
 */
public class INTER_TercerosDirecciones {

    private final static Logger log = Logger.getLogger(INTER_TercerosDirecciones.class);

    public String nombreAutomatizacion = "Direcciones Terceros";

    public void testLink(INTER_TercerosDireccionesBean interTercerosDireccionesBean, int i)throws Exception{

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, interTercerosDireccionesBean); //Busqueda Tercero
            BotonEditar(a, driver);
            //Agregar Direccion
            AgregarDireccion(a, driver, interTercerosDireccionesBean);

            EditarDireccion(a, driver, interTercerosDireccionesBean);

            SeleccionarDirPrincipal(a, driver, interTercerosDireccionesBean);

            driver.close();
            a.regresarVentana(driver);

            //Entrando en Menu
            interMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 15, i);
            a.cambiarVentana(driver);

            BusquedaT(a, driver, interTercerosDireccionesBean);
            BotonEditar(a, driver);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BusquedaT(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean interTercerosDireccionesBean) throws InterruptedException, IOException {


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

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BotonEditar(Interseguros_Metodos a, WebDriver driver) throws InterruptedException, IOException {


        try {//TipoElemento[@wicketpath='WicketpathElemento']

            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();

            Thread.sleep(1000);

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 1");
            }

            //Screenshot
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void AgregarDireccion(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean interTercerosDireccionesBean) throws InterruptedException {


        try {//TipoElemento[@wicketpath='WicketpathElemento']
            Thread.sleep(3000);
            // Boton Agregar Direccion
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_AddButton']")).click();
            Thread.sleep(1000);

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(3000);
                System.out.println("Espera 2");
            }

            // Referencia Direccion
            if (interTercerosDireccionesBean.getRefDireccion() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_field']")).sendKeys(interTercerosDireccionesBean.getRefDireccion());
                Thread.sleep(2000);
            }

            // Codigo País
            if (interTercerosDireccionesBean.getCodPais() != null) {
                Select codPais = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_1_fila_repeaterSelect_1_field']")));
                codPais.selectByValue(interTercerosDireccionesBean.getCodPais()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Descripcion de la Dirección
            if (interTercerosDireccionesBean.getDescripcionDireccion() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_2_fila_field']")).sendKeys(interTercerosDireccionesBean.getDescripcionDireccion());
                Thread.sleep(2000);
            }

            // Codigo Departamento
            if (interTercerosDireccionesBean.getCodPais() != null) {
                Select codDepartamento = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_2_fila_repeaterSelect_1_field']")));
                codDepartamento.selectByValue(interTercerosDireccionesBean.getCodDepartamento()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Codigo Provincia
            if (interTercerosDireccionesBean.getCodProvincia() != null) {
                Select codPais = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_1_fila_repeaterSelect_1_field']")));
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
                Select codDistrito = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_2_fila_repeaterSelect_3_field']")));
                codDistrito.selectByValue(interTercerosDireccionesBean.getCodDistrito()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Tipo Direccion
            if (interTercerosDireccionesBean.getTipoDireccion() != null) {
                Select tipoDireccion = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_4_fila_repeaterSelect_1_field']")));
                tipoDireccion.selectByValue(interTercerosDireccionesBean.getTipoDireccion()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Telefono Fijo
            if (interTercerosDireccionesBean.getTlfFijo() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_3_fila_field']")).sendKeys(interTercerosDireccionesBean.getTlfFijo());
                Thread.sleep(2000);
            }

            // User Login
            if (interTercerosDireccionesBean.getUserLogin() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_5_fila_field']")).sendKeys(interTercerosDireccionesBean.getUserLogin());
                Thread.sleep(2000);
            }

            // Telefono Celular
            if (interTercerosDireccionesBean.getTlfCelular() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel2_3_fila_field']")).sendKeys(interTercerosDireccionesBean.getTlfCelular());
                Thread.sleep(2000);
            }

            // Email
            if (interTercerosDireccionesBean.getEmail() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_5_fila_field']")).sendKeys(interTercerosDireccionesBean.getEmail());
                Thread.sleep(2000);
            }

            // Boton Guardar
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']")).click();
            Thread.sleep(5000);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EditarDireccion(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean interTercerosDireccionesBean) throws InterruptedException {

        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(3000);
            // Seleccionar la direccion
            WebElement direccion = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_container_ThirdAddress_1_radio']"));
            direccion.click();

            if (direccion.isSelected()) {
                // Boton Editar
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_EditButton']")).click();
                Thread.sleep(1000);

                /** Espere **/
                WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
                while (mensajeEspera.isDisplayed()) {
                    Thread.sleep(5000);
                    System.out.println("Espera 2");
                }



                // Boton Guardar
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']")).click();
                Thread.sleep(1000);

                /** Espere **/
                mensajeEspera = driver.findElement(By.id("waitMessage"));
                while (mensajeEspera.isDisplayed()) {
                    Thread.sleep(5000);
                    System.out.println("Espera 3");
                }
            }


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void SeleccionarDirPrincipal(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean interTercerosDireccionesBean) throws InterruptedException {


        try { //TipoElemento[@wicketpath='WicketpathElemento']

            Thread.sleep(2000);

            //Seleccionar la poliza
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_container_ThirdAddress_1_radio']")).click();
            Thread.sleep(2000);

            // Boton "Definir como principal"
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_DefineMain']"));

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
