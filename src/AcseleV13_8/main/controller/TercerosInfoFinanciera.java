package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosInfoFinancieraBean;
import AcseleV13_8.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by agil on 21/06/2016.
 */
public class TercerosInfoFinanciera {

    private final static Logger log = Logger.getLogger(TercerosInfoFinanciera.class);

    public String nombreAutomatizacion = "LBC_Terceros Informacion Financiera";

    public void testLink(TercerosInfoFinancieraBean tercerosInfoFinancieraBean, int i)throws Exception{

        try {

            // Instanciando clases
            Metodos13_8 a = new Metodos13_8();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, 2);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, tercerosInfoFinancieraBean); //Busqueda Tercero

            // Boton Editar
            //driver.findElement(By.xpath("//form/input")).click();
            driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
            Thread.sleep(3000);

            InfoFinanciera(a, driver, tercerosInfoFinancieraBean);

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(Metodos13_8 a, WebDriver driver, TercerosInfoFinancieraBean tercerosInfoFinancieraBean) throws InterruptedException, IOException{

        try {

            Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (tercerosInfoFinancieraBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(tercerosInfoFinancieraBean.getTipoTercero());
            }
            Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (tercerosInfoFinancieraBean.getTipoDocId() != null) {
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(tercerosInfoFinancieraBean.getTipoDocId());
            }

            if (tercerosInfoFinancieraBean.getCedula() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(tercerosInfoFinancieraBean.getCedula());
            }

            if (tercerosInfoFinancieraBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                nTercero.sendKeys(tercerosInfoFinancieraBean.getNombre());
            }

            //Screenshot
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

            //WebElement buscar = driver.findElement(By.name("searchButton"));
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(5000);

            //WebElement selccionTercero = driver.findElement(By.name("SearchContent:ThirdInformation:showDetailSearchTable:proof:ThirdPartyRadioGroup"));
            WebElement selccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            selccionTercero.click();

            //Screenshot
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Formulario(Metodos13_8 a, WebDriver driver, TercerosInfoFinancieraBean tercerosInfoFinancieraBean) throws InterruptedException {
        Thread.sleep(2000);
        try {

            if (tercerosInfoFinancieraBean.getFechaExpedicionDocId() != null) {
                WebElement fecExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_1_fila_fieldDate']"));
                fecExp.click();
                Thread.sleep(2000);
                fecExp.click();
                fecExp.clear();
                fecExp.sendKeys(tercerosInfoFinancieraBean.getFechaExpedicionDocId()); // Fecha expedición del documento de identificación
                Thread.sleep(2000);
            }

            WebElement lugExpOtro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_2_fila_mandatory']"));
            if (tercerosInfoFinancieraBean.getLugarExpedicionDocId() != null) {
                WebElement lugExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_2_fila_field']"));
                lugExp.click();
                Thread.sleep(2000);
                lugExp.click();
                lugExp.clear();
                lugExp.sendKeys(tercerosInfoFinancieraBean.getLugarExpedicionDocId()); //Lugar de expedición del documento de identificación
                lugExpOtro.click();
                Thread.sleep(2000);
            }

            if (tercerosInfoFinancieraBean.getActividadEconomica() != null) {
                Select actiEco = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
                //actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
                Thread.sleep(2000);
            }

            if (tercerosInfoFinancieraBean.getNacionalidad() != null){
                Select naci = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_repeaterSelect_1_field']")));
                naci.selectByValue(tercerosInfoFinancieraBean.getNacionalidad()); // Nacionalidad
                Thread.sleep(6000);
            }

            if (tercerosInfoFinancieraBean.getActividadEconomica() != null && tercerosInfoFinancieraBean.getNacionalidad() != null) {
                Select actiEco = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                Select naci = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_repeaterSelect_1_field']")));

                actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
                naci.selectByValue(tercerosInfoFinancieraBean.getNacionalidad()); // Nacionalidad
            }

            if (tercerosInfoFinancieraBean.getEmpresaTrabaja() != null) {
                WebElement empTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_6_fila_field']"));
                //empTrab.click();
                Thread.sleep(2000);
                //empTrab.click();
                //empTrab.clear();
                empTrab.sendKeys(tercerosInfoFinancieraBean.getEmpresaTrabaja()); // Empresa donde trabaja
                Thread.sleep(2000);
//                lugExpOtro.click();
                Thread.sleep(2000);
            }

            if (tercerosInfoFinancieraBean.getAreaTrabajo() != null) {
                WebElement areaTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_7_fila_field']"));
                Thread.sleep(2000);
                /*areaTrab.click();
                areaTrab.click();
                areaTrab.clear();*/
                areaTrab.sendKeys(tercerosInfoFinancieraBean.getAreaTrabajo()); // Área
//                lugExpOtro.click();
                Thread.sleep(4000);

                Thread.sleep(2000);
            }

            if (tercerosInfoFinancieraBean.getCargoTrabajo() != null) {
                WebElement cargTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_8_fila_field']"));
                cargTrab.click();
                Thread.sleep(2000);
                cargTrab.click();
                cargTrab.clear();
                cargTrab.sendKeys(tercerosInfoFinancieraBean.getCargoTrabajo()); // Cargo
            }

            if (tercerosInfoFinancieraBean.getDireccionLaboral() != null) {
                WebElement dirLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_9_fila_field']"));
                dirLab.click();
                Thread.sleep(2000);
                dirLab.click();
                dirLab.clear();
                dirLab.sendKeys(tercerosInfoFinancieraBean.getDireccionLaboral()); // Dirección Laboral
            }

            if (tercerosInfoFinancieraBean.getCiudadLaboral() != null) {
                WebElement ciuLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_10_fila_field']"));
                ciuLab.click();
                Thread.sleep(2000);
                ciuLab.click();
                ciuLab.clear();
                ciuLab.sendKeys(tercerosInfoFinancieraBean.getCiudadLaboral()); // Ciudad Laboral
            }

            if (tercerosInfoFinancieraBean.getTelefonoLaboral() != null) {
                WebElement telLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_11_fila_field']"));
                telLab.click();
                Thread.sleep(2000);
                telLab.click();
                telLab.clear();
                telLab.sendKeys(tercerosInfoFinancieraBean.getTelefonoLaboral()); // Teléfono Laboral
            }

            if (tercerosInfoFinancieraBean.getNumeroFax() != null) {
                WebElement numFax = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_12_fila_field']"));
                numFax.click();
                Thread.sleep(2000);
                numFax.click();
                numFax.clear();
                numFax.sendKeys(tercerosInfoFinancieraBean.getNumeroFax()); // Número de Fax
            }

            if (tercerosInfoFinancieraBean.getTelefonoFijo() != null) {
                WebElement telFij = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_13_fila_field']"));
                telFij.click();
                Thread.sleep(2000);
                telFij.click();
                telFij.clear();
                telFij.sendKeys(tercerosInfoFinancieraBean.getTelefonoFijo()); // Telefono Fijo
            }

            if (tercerosInfoFinancieraBean.getTelefonoCelular() != null) {
                WebElement telCel = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_14_fila_field']"));
                telCel.click();
                Thread.sleep(2000);
                telCel.click();
                telCel.clear();
                telCel.sendKeys(tercerosInfoFinancieraBean.getTelefonoCelular()); // Celular
            }

            if (tercerosInfoFinancieraBean.getFechaDiligencia() != null) {
                WebElement fecDili = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_15_fila_fieldDate']"));
                fecDili.click();
                Thread.sleep(2000);
                fecDili.click();
                fecDili.clear();
                fecDili.sendKeys(tercerosInfoFinancieraBean.getFechaDiligencia()); // Fecha Diligenciamiento Sarlaft
            }

            if (tercerosInfoFinancieraBean.getIngresosMensuales() != null) {
                WebElement ingMens = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_1_fila_field']"));
                ingMens.click();
                Thread.sleep(2000);
                ingMens.click();
                ingMens.clear();
                ingMens.sendKeys(tercerosInfoFinancieraBean.getIngresosMensuales()); // Ingresos Mensuales
            }

            if (tercerosInfoFinancieraBean.getOtrosIngresos() != null) {
                WebElement otrIng = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_2_fila_field']"));
                otrIng.click();
                Thread.sleep(2000);
                otrIng.click();
                otrIng.clear();
                otrIng.sendKeys(tercerosInfoFinancieraBean.getOtrosIngresos()); // Otros Ingresos
            }

            if (tercerosInfoFinancieraBean.getConceptoOtrosIngresos() != null) {
                WebElement conOtrIng = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_3_fila_field']"));
                conOtrIng.click();
                Thread.sleep(2000);
                conOtrIng.click();
                conOtrIng.clear();
                conOtrIng.sendKeys(tercerosInfoFinancieraBean.getConceptoOtrosIngresos()); // Concepto Otros Ingresos
            }

            if (tercerosInfoFinancieraBean.getEgresosMensuales() != null) {
                WebElement egrMen = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_4_fila_field']"));
                egrMen.click();
                Thread.sleep(2000);
                egrMen.click();
                egrMen.clear();
                egrMen.sendKeys(tercerosInfoFinancieraBean.getEgresosMensuales()); // Egresos Mensuales
            }

            if (tercerosInfoFinancieraBean.getActivos() != null) {
                WebElement act = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_5_fila_field']"));
                act.click();
                Thread.sleep(2000);
                act.click();
                act.clear();
                act.sendKeys(tercerosInfoFinancieraBean.getActivos()); // Activos
            }

            if (tercerosInfoFinancieraBean.getPasivos() != null) {
                WebElement pas = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_6_fila_field']"));
                pas.click();
                Thread.sleep(2000);
                pas.click();
                pas.clear();
                pas.sendKeys(tercerosInfoFinancieraBean.getPasivos()); // Pasivos
            }

            WebElement obser = driver.findElement(By.xpath("//textarea[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_8_fila_field']"));
            WebElement manRecPubSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_9_fila_field_repeaterChoice_2_radio']"));
            WebElement manRecPubNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_9_fila_field_repeaterChoice_1_radio']"));

            WebElement gradPodPubSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_10_fila_field_repeaterChoice_2_radio']"));
            WebElement gradPodPubNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_10_fila_field_repeaterChoice_1_radio']"));

            WebElement recPubGenSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_12_fila_field_repeaterChoice_2_radio']"));
            WebElement recPubGenNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_12_fila_field_repeaterChoice_1_radio']"));

            WebElement prodExtSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_13_fila_field_repeaterChoice_2_radio']"));
            WebElement prodExtNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_13_fila_field_repeaterChoice_1_radio']"));

            WebElement opExtNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_14_fila_Group_SecondRepeater_4_checked']"));
            WebElement opExtExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_14_fila_Group_FirstRepeater_1_checked']"));
            WebElement opExtImp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_14_fila_Group_SecondRepeater_2_checked']"));
            WebElement opExtInv = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_14_fila_Group_FirstRepeater_3_checked']"));
            WebElement opExtOtra = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_14_fila_Group_FirstRepeater_5_checked']"));


            if (tercerosInfoFinancieraBean.getVerifInformacion() != null) {
                // Verificación de la información

                WebElement verInfSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_7_fila_field_repeaterChoice_2_radio']"));
                WebElement verInfNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_7_fila_field_repeaterChoice_1_radio']"));

                String verInfo = tercerosInfoFinancieraBean.getVerifInformacion().toLowerCase();
                if (/*tercerosInfoFinancieraBean.getVerifInformacion().equals("SI") || tercerosInfoFinancieraBean.getVerifInformacion().equals("Si")
                        ||*/ verInfo.equals("si")) {
                    verInfSi.click();
                    Thread.sleep(2000);
                    verInfSi.click();
                } else if (verInfo.equals("no") /*tercerosInfoFinancieraBean.getVerifInformacion().equals("NO") || tercerosInfoFinancieraBean.getVerifInformacion().equals("No")
                        || tercerosInfoFinancieraBean.getVerifInformacion().equals("no")*/) {
                    verInfNo.click();
                    Thread.sleep(2000);
                    verInfNo.click();
                }
            }

            obser.sendKeys(tercerosInfoFinancieraBean.getObservaciones()); // Observaciones
            // Por cargo o actividad maneja recurso públicos
            if (tercerosInfoFinancieraBean.getManejaRecursosPub().equals("SI") || tercerosInfoFinancieraBean.getManejaRecursosPub().equals("Si")){
                manRecPubSi.click();
                Thread.sleep(2000);
                manRecPubSi.click();
            } else if (tercerosInfoFinancieraBean.getManejaRecursosPub().equals("NO") || tercerosInfoFinancieraBean.getManejaRecursosPub().equals("No")){
                manRecPubNo.click();
                Thread.sleep(2000);
                manRecPubNo.click();
            }
            // Por cargo ó actividad ejerce algún grado de poder público
            if (tercerosInfoFinancieraBean.getEjercePoderPub().equals("SI") || tercerosInfoFinancieraBean.getEjercePoderPub().equals("Si")){
                gradPodPubSi.click();
                Thread.sleep(2000);
                gradPodPubSi.click();
            } else if (tercerosInfoFinancieraBean.getEjercePoderPub().equals("NO") || tercerosInfoFinancieraBean.getEjercePoderPub().equals("No")){
                gradPodPubNo.click();
                Thread.sleep(2000);
                gradPodPubNo.click();
            }
            // Por su actividad u oficio goza usted de reconocimiento público general
            if (tercerosInfoFinancieraBean.getReconoPubGeneral().equals("SI") || tercerosInfoFinancieraBean.getReconoPubGeneral().equals("Si")){
                recPubGenSi.click();
                Thread.sleep(2000);
                recPubGenSi.click();
            } else if (tercerosInfoFinancieraBean.getReconoPubGeneral().equals("NO") || tercerosInfoFinancieraBean.getReconoPubGeneral().equals("No")){
                recPubGenNo.click();
                Thread.sleep(2000);
                recPubGenNo.click();
            }
            // Reporta productos en el exterior
            if (tercerosInfoFinancieraBean.getReportaProdExterior().equals("SI") || tercerosInfoFinancieraBean.getReportaProdExterior().equals("Si")){
                prodExtSi.click();
                Thread.sleep(2000);
                prodExtSi.click();
            } else if (tercerosInfoFinancieraBean.getReportaProdExterior().equals("NO") || tercerosInfoFinancieraBean.getReportaProdExterior().equals("No")){
                prodExtNo.click();
                Thread.sleep(2000);
                prodExtNo.click();
            }
            // Realiza operaciones en moneda extranjera importaciones, exportaciones, inversiones, transferencias otra cual
            if (tercerosInfoFinancieraBean.getOpExtranjerasNo().equals("SI") || tercerosInfoFinancieraBean.getOpExtranjerasNo().equals("Si")){
                opExtNo.click();
                Thread.sleep(2000);
                opExtNo.click();
            }
            if (tercerosInfoFinancieraBean.getOpExtranjerasExporta().equals("SI") || tercerosInfoFinancieraBean.getOpExtranjerasExporta().equals("Si")){
                opExtExp.click();
                Thread.sleep(2000);
                opExtExp.click();
            }
            if (tercerosInfoFinancieraBean.getOpExtranjerasImporta().equals("SI") || tercerosInfoFinancieraBean.getOpExtranjerasImporta().equals("Si")){
                opExtImp.click();
                Thread.sleep(2000);
                opExtImp.click();
            }
            if (tercerosInfoFinancieraBean.getOpExtranjerasInversion().equals("SI") || tercerosInfoFinancieraBean.getOpExtranjerasInversion().equals("Si")){
                opExtInv.click();
                Thread.sleep(2000);
                opExtInv.click();
            }
            if (tercerosInfoFinancieraBean.getOpExtranjerasOtra().equals("SI") || tercerosInfoFinancieraBean.getOpExtranjerasOtra().equals("Si")){
                opExtOtra.click();
                Thread.sleep(2000);
                opExtOtra.click();
            }

            //Thread.sleep(2000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

        //Boton Guardar
//        try {
//            WebElement btnGuardar = driver.findElement(By.xpath("//div[2]/div/div[2]/input"));
//            btnGuardar.click();
//            Thread.sleep(2000);
//
//        } catch (Exception e){
//            e.printStackTrace();
////             log.info(e);
//            log.info("Test Case 23 - LBC_Terceros Informacion financiera - " + e);
//        }
    }

    public void InfoFinanciera(Metodos13_8 a, WebDriver driver, TercerosInfoFinancieraBean tercerosInfoFinancieraBean) throws InterruptedException, IOException {

        try {

            Thread.sleep(2000);
            // Boton Agregar
            try {
                //WebElement btnAgregar = driver.findElement(By.xpath("//div[2]/div/form/div[2]/div/input"));
                WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_formThirdFinancial_AddButton']"));
                btnAgregar.click(); // Boton Agregar
                a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            } catch (Exception e) {
                e.printStackTrace();
//             log.info(e);
                log.info("Test Case 23 - LBC_Terceros Informacion financiera - " + e);
            }

            Formulario(a, driver, tercerosInfoFinancieraBean);
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen8", nombreAutomatizacion);

//        Formulario(a, driver, tercerosInfoFinancieraBean);
            Thread.sleep(3000);
            a.ScreenShot(driver, "screen8-1", nombreAutomatizacion);


            System.out.println("Fin Prueba");

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
