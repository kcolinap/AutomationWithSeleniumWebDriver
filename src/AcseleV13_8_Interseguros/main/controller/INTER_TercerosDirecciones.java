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
            if (interTercerosDireccionesBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(interTercerosDireccionesBean.getTipoTercero());
            }
            Thread.sleep(2000);

            if (interTercerosDireccionesBean.getTipoDocId() != null) {
                //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(interTercerosDireccionesBean.getTipoDocId());
            }

            if (interTercerosDireccionesBean.getNumCedula() != null) {
                //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(interTercerosDireccionesBean.getNumCedula());
            }

            if (interTercerosDireccionesBean.getNombre() != null) {
                //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(interTercerosDireccionesBean.getNombre());
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

    public void AgregarDireccion(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean lbcTercerosDireccionesBean) throws InterruptedException {


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
            if (lbcTercerosDireccionesBean.getTipoDireccion() != null) {
                Select tipDirecc = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipDirecc.selectByValue(lbcTercerosDireccionesBean.getTipoDireccion()); //8548517=Residencia; 8548717=Correspondencia; 8548617=Comercial
                Thread.sleep(3000);
            }

            // Tipo Via
            if (lbcTercerosDireccionesBean.getTipoVia() != null) {
                Select tipVia = new Select(driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_3_fila_field']")));
                tipVia.selectByValue(lbcTercerosDireccionesBean.getTipoVia()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                Thread.sleep(2000);
            }

            // Numero o Nombre Via Ppal
            if (lbcTercerosDireccionesBean.getNumNomViaPpal() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']")).sendKeys(lbcTercerosDireccionesBean.getNumNomViaPpal());
                Thread.sleep(2000);
            }

            // Prefijo (BIS) Via Ppal
            if (lbcTercerosDireccionesBean.getPrefBisViaPpal() != null) {
                Select preBis = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_6_fila_repeaterSelect_1_field']")));
//            Select preBis = new Select(driver.findElement(By.id("id2b9")));
                preBis.selectByValue(lbcTercerosDireccionesBean.getPrefBisViaPpal()); // 19636217=BIS
                preBis.selectByValue(lbcTercerosDireccionesBean.getPrefBisViaPpal());
                Thread.sleep(2000);
            }

            // Letra o Número Prefijo Vía Ppal
            if (lbcTercerosDireccionesBean.getLetraNumPrefViaPpal() != null) {
                driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_7_fila_field']")).sendKeys(lbcTercerosDireccionesBean.getLetraNumPrefViaPpal());
                Thread.sleep(2000);
            }

            // Cuadrante Via Ppal
            if (lbcTercerosDireccionesBean.getCuadranteViaPpal() != null) {
                Select cuadViaPpal = new Select(driver.findElement(By.xpath("//TipoElemento[@wicketpath='WicketpathElemento']")));
                cuadViaPpal.selectByValue(lbcTercerosDireccionesBean.getCuadranteViaPpal());
//            Thread.sleep(2000);
            }

            // Número Vía Generadora
            if (lbcTercerosDireccionesBean.getNumViaGeneradora() != null) {
                driver.findElement(By.xpath("//selct[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_8_fila_repeaterSelect_1_field']")).sendKeys(lbcTercerosDireccionesBean.getNumViaGeneradora());
                Thread.sleep(2000);
            }

            // Pais
            if (lbcTercerosDireccionesBean.getPais() != null) {
                Select sPais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_1_field']")));
//            sPais.selectByValue("45788717"); //45788717=Alemania
//            Thread.sleep(3000);
                sPais.selectByValue(lbcTercerosDireccionesBean.getPais());
                Thread.sleep(3000);
            }

            // Departamento
            if (lbcTercerosDireccionesBean.getDepartamento() != null) {
                Select sDep = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_2_field']")));
                sDep.selectByValue(lbcTercerosDireccionesBean.getDepartamento());
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

    public void EditarDireccion(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean lbcTercerosDireccionesBean) throws InterruptedException {

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
                if (lbcTercerosDireccionesBean.getNuevoTipoDireccion() != null) {
                    Select tipDirecc = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                    tipDirecc.selectByValue(lbcTercerosDireccionesBean.getNuevoTipoDireccion()); //8548517=Residencia; 8548717=Correspondencia; 8548617=Comercial
                    Thread.sleep(3000);
                }

                // Tipo Via
                if (lbcTercerosDireccionesBean.getNuevoTipoVia() != null) {
                    Select tipVia = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_2_fila_repeaterSelect_1_field']")));
                    tipVia.selectByValue(lbcTercerosDireccionesBean.getNuevoTipoVia()); //19631017=Calle; 19630717=Avenida Calle; 19630517=Autopista
                    Thread.sleep(2000);
                }

                // Numero o Nombre Via Ppal
                if (lbcTercerosDireccionesBean.getNuevoNumNomViaPpal() != null) {
                    driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_4_fila_field']")).sendKeys(lbcTercerosDireccionesBean.getNuevoNumNomViaPpal());
                    Thread.sleep(2000);
                }

                // Prefijo (BIS) Via Ppal
                if (lbcTercerosDireccionesBean.getNuevoPrefBisViaPpal() != null) {
                    Select preBis = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_6_fila_repeaterSelect_1_field']")));
                    preBis.selectByValue(lbcTercerosDireccionesBean.getNuevoPrefBisViaPpal());
                    Thread.sleep(2000);
                }

                // Letra o Número Prefijo Vía Ppal
                if (lbcTercerosDireccionesBean.getNuevoLetraNumPrefViaPpal() != null) {
                    driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_7_fila_field']")).sendKeys(lbcTercerosDireccionesBean.getNuevoLetraNumPrefViaPpal());
                    Thread.sleep(2000);
                }

                // Cuadrante Via Ppal
                if (lbcTercerosDireccionesBean.getNuevoCuadranteViaPpal() != null) {
                    Select cuadViaPpal = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_8_fila_repeaterSelect_1_field']")));
                    cuadViaPpal.selectByValue(lbcTercerosDireccionesBean.getNuevoCuadranteViaPpal());
//            Thread.sleep(2000);
                }

                // Número Vía Generadora
                if (lbcTercerosDireccionesBean.getNuevoNumViaGeneradora() != null) {
                    driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_9_fila_field']")).sendKeys(lbcTercerosDireccionesBean.getNuevoNumViaGeneradora());
                    Thread.sleep(2000);
                }

                // Pais
                if (lbcTercerosDireccionesBean.getNuevoPais() != null) {
                    Select sPais = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_1_field']")));
                    sPais.selectByValue(lbcTercerosDireccionesBean.getNuevoPais());
                    Thread.sleep(3000);
                }

                // Departamento
                if (lbcTercerosDireccionesBean.getNuevoDepartamento() != null) {
                    Select sDep = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_panelAddress_BasicThirdAddressInformation_registerFormThirdAddress_templateBasicThird_repeaterPanel1_15_fila_repeaterSelect_2_field']")));
                    sDep.selectByValue(lbcTercerosDireccionesBean.getNuevoDepartamento());
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

    public void SeleccionarDirPrincipal(Interseguros_Metodos a, WebDriver driver, INTER_TercerosDireccionesBean lbcTercerosDireccionesBean) throws InterruptedException {


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
