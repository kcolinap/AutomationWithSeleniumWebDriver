package AcseleV13_8LBC.main.controller;


import AcseleV13_8LBC.beans.TercerosDireccionesBean;
import AcseleV13_8LBC.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by mchurion on 09/06/2016.
 */
public class LBC_TercerosDirecciones {

    private final static Logger log = Logger.getLogger(LBC_TercerosDirecciones.class);

    public String nombreAutomatizacion = "Direcciones Terceros";

    public void testLink(TercerosDireccionesBean tercerosDireccionesBean, int i)throws Exception{

        try {

            // Instanciando clases
            MetodosLBC a = new MetodosLBC();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 2, i);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, tercerosDireccionesBean); //Busqueda Tercero
            BotonEditar(a, driver);
            //Agregar Direccion
            AgregarDireccion(a, driver, tercerosDireccionesBean);

            EditarDireccion(a, driver, tercerosDireccionesBean);

            SeleccionarDirPrincipal(a, driver, tercerosDireccionesBean);

            driver.close();
            a.regresarVentana(driver);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, 15, i);
            a.cambiarVentana(driver);

            BusquedaT(a, driver, tercerosDireccionesBean);
            BotonEditar(a, driver);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BusquedaT(MetodosLBC a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException, IOException{

        try {

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

            if (tercerosDireccionesBean.getTipoDocId() != null) {
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

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BotonEditar(MetodosLBC a, WebDriver driver) throws InterruptedException, IOException {

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

    public void AgregarDireccion(MetodosLBC a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException {

        try {//TipoElemento[@wicketpath='WicketpathElemento']
            Thread.sleep(5000);
            // Boton Agregar Direccion
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_formThirdAddress_AddButton']")).click();
            Thread.sleep(1000);

            /** Espere **/
            WebElement mensajeEspera = driver.findElement(By.id("waitMessage"));
            while (mensajeEspera.isDisplayed()) {
                Thread.sleep(5000);
                System.out.println("Espera 2");
            }

            // Tipo Direccion
            if (tercerosDireccionesBean.getTipoDireccion() != null) {
                Select tipDirecc = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipDirecc.selectByValue(tercerosDireccionesBean.getTipoDireccion()); //8548517=Residencia; 8548717=Correspondencia; 8548617=Comercial
                Thread.sleep(3000);
            }

            // Tipo Via
            if (tercerosDireccionesBean.getTipoVia() != null) {
                Select tipVia = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_3_fila_field']")));
                tipVia.selectByValue(tercerosDireccionesBean.getTipoVia()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Numero o Nombre Via Ppal
            if (tercerosDireccionesBean.getNumNomViaPpal() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']")).sendKeys(tercerosDireccionesBean.getNumNomViaPpal());
                Thread.sleep(2000);
            }

            // Prefijo (BIS) Via Ppal
            if (tercerosDireccionesBean.getPrefBisViaPpal() != null) {
                Select preBis = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_6_fila_repeaterSelect_1_field']")));
//            Select preBis = new Select(driver.findElement(By.id("id2b9")));
                preBis.selectByValue(tercerosDireccionesBean.getPrefBisViaPpal()); // 19636217=BIS
                preBis.selectByValue(tercerosDireccionesBean.getPrefBisViaPpal());
                Thread.sleep(2000);
            }

            // Letra o Número Prefijo Vía Ppal
            if (tercerosDireccionesBean.getLetraNumPrefViaPpal() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_7_fila_field']")).sendKeys(tercerosDireccionesBean.getLetraNumPrefViaPpal());
                Thread.sleep(2000);
            }

            // Cuadrante Via Ppal
            if (tercerosDireccionesBean.getCuadranteViaPpal() != null) {
                Select cuadViaPpal = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
                cuadViaPpal.selectByValue(tercerosDireccionesBean.getCuadranteViaPpal());
//            Thread.sleep(2000);
            }

            // Número Vía Generadora
            if (tercerosDireccionesBean.getNumViaGeneradora() != null) {
                driver.findElement(By.xpath("//selct[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_8_fila_repeaterSelect_1_field']")).sendKeys(tercerosDireccionesBean.getNumViaGeneradora());
                Thread.sleep(2000);
            }

            // Pais
            if (tercerosDireccionesBean.getPais() != null) {
                Select sPais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_1_field']")));
//            sPais.selectByValue("45788717"); //45788717=Alemania
//            Thread.sleep(3000);
                sPais.selectByValue(tercerosDireccionesBean.getPais());
                Thread.sleep(3000);
            }

            // Departamento
            if (tercerosDireccionesBean.getDepartamento() != null) {
                Select sDep = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_2_field']")));
                sDep.selectByValue(tercerosDireccionesBean.getDepartamento());
                //sDep.selectByVisibleText("BOGOTA");
//            Thread.sleep(2000);
            }

//        // Ciudad
//        if (tercerosDireccionesBean.getCiudad() != null){
//            Select sCiud = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
//            sCiud.selectByValue(tercerosDireccionesBean.getCiudad());
//            //Thread.sleep(2000);
//        }

            // Boton Guardar
            driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_saveButton']")).click();
            Thread.sleep(5000);

        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void EditarDireccion(MetodosLBC a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException {

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

                // Tipo Direccion
                if (tercerosDireccionesBean.getNuevoTipoDireccion() != null) {
                    Select tipDirecc = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                    tipDirecc.selectByValue(tercerosDireccionesBean.getNuevoTipoDireccion()); //8548517=Residencia; 8548717=Correspondencia; 8548617=Comercial
                    Thread.sleep(3000);
                }

                // Tipo Via
                if (tercerosDireccionesBean.getNuevoTipoVia() != null) {
                    Select tipVia = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_2_fila_repeaterSelect_1_field']")));
                    tipVia.selectByValue(tercerosDireccionesBean.getNuevoTipoVia()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                    Thread.sleep(2000);
                }

                // Numero o Nombre Via Ppal
                if (tercerosDireccionesBean.getNuevoNumNomViaPpal() != null) {
                    driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']")).sendKeys(tercerosDireccionesBean.getNuevoNumNomViaPpal());
                    Thread.sleep(2000);
                }

                // Prefijo (BIS) Via Ppal
                if (tercerosDireccionesBean.getNuevoPrefBisViaPpal() != null) {
                    Select preBis = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_6_fila_repeaterSelect_1_field']")));
                    preBis.selectByValue(tercerosDireccionesBean.getNuevoPrefBisViaPpal());
                    Thread.sleep(2000);
                }

                // Letra o Número Prefijo Vía Ppal
                if (tercerosDireccionesBean.getNuevoLetraNumPrefViaPpal() != null) {
                    driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_7_fila_field']")).sendKeys(tercerosDireccionesBean.getNuevoLetraNumPrefViaPpal());
                    Thread.sleep(2000);
                }

                // Cuadrante Via Ppal
                if (tercerosDireccionesBean.getNuevoCuadranteViaPpal() != null) {
                    Select cuadViaPpal = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_8_fila_repeaterSelect_1_field']")));
                    cuadViaPpal.selectByValue(tercerosDireccionesBean.getNuevoCuadranteViaPpal());
//            Thread.sleep(2000);
                }

                // Número Vía Generadora
                if (tercerosDireccionesBean.getNuevoNumViaGeneradora() != null) {
                    driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_9_fila_field']")).sendKeys(tercerosDireccionesBean.getNuevoNumViaGeneradora());
                    Thread.sleep(2000);
                }

                // Pais
                if (tercerosDireccionesBean.getNuevoPais() != null) {
                    Select sPais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_1_field']")));
                    sPais.selectByValue(tercerosDireccionesBean.getNuevoPais());
                    Thread.sleep(3000);
                }

                // Departamento
                if (tercerosDireccionesBean.getNuevoDepartamento() != null) {
                    Select sDep = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_2_field']")));
                    sDep.selectByValue(tercerosDireccionesBean.getNuevoDepartamento());
                    //sDep.selectByVisibleText("BOGOTA");
//            Thread.sleep(2000);
                }

//        // Ciudad
//        if (tercerosDireccionesBean.getNuevoCiudad() != null){
//            Select sCiud = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
//            sCiud.selectByValue(tercerosDireccionesBean.getNuevoCiudad());
//            //Thread.sleep(2000);
//        }

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

    public void SeleccionarDirPrincipal(MetodosLBC a, WebDriver driver, TercerosDireccionesBean tercerosDireccionesBean) throws InterruptedException {

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
