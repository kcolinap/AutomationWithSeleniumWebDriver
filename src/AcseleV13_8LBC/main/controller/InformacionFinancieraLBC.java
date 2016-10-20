package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.InformacionFinancieraLBCBean;
import AcseleV13_8LBC.main.controller.Menu.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by rmontilla on 20/10/2016.
 */
public class InformacionFinancieraLBC {

    private final static Logger log = Logger.getLogger(InformacionFinancieraLBC.class);

    public String nombreAutomatizacion = "LBC Terceros Informacion Financiera";

    public void testLink(InformacionFinancieraLBCBean informacionFinancieraLBCBean, int i)throws Exception{

        try {

            // Instanciando clases
            MetodosLBC a = new MetodosLBC();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.MantTerc_BuscarTercero(a, driver, nombreAutomatizacion, i);

            // Consulta del Tercero Creado
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);
            BusquedaT(a, driver, informacionFinancieraLBCBean); //Busqueda Tercero

            // Boton Editar
            //driver.findElement(By.xpath("//form/input")).click();
/*            driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
            Thread.sleep(3000);*/

            InfoFinanciera(a, driver, informacionFinancieraLBCBean);

            Thread.sleep(3000);
            a.ScreenShot(driver, "screen9", nombreAutomatizacion);

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void BusquedaT(MetodosLBC a, WebDriver driver, InformacionFinancieraLBCBean informacionFinancieraLBCBean) throws InterruptedException, IOException {

        try {

         //   Thread.sleep(4000);
            String title = driver.getTitle();
            System.out.println("Titulo de la pagina: " + title);

            //Tipo de tercero
            if (informacionFinancieraLBCBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
                Select tipoT = new Select(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[1]/div/div[2]/select")));
                if (informacionFinancieraLBCBean.getTipoTercero().equals("Persona Natural")) {
                    tipoT.selectByValue("NaturalPerson");
                }

                if (informacionFinancieraLBCBean.getTipoTercero().equals("Persona Juridica")) {
                    tipoT.selectByValue("LegalPerson");
                }
            }

            //    Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

            if (informacionFinancieraLBCBean.getTipoDocId() != null) {
                Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                tipoDoc.selectByValue(informacionFinancieraLBCBean.getTipoDocId());
            }

            if (informacionFinancieraLBCBean.getCedula() != null) {
                WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                cedu.sendKeys(informacionFinancieraLBCBean.getCedula());
            }

            if (informacionFinancieraLBCBean.getNombre() != null) {
                WebElement nTercero = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[2]/form/div[3]/div[1]/table/tbody/tr/td[1]/div[2]/div/div/input[2]"));
                nTercero.sendKeys(informacionFinancieraLBCBean.getNombre());
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

    public void Formulario(MetodosLBC a, WebDriver driver, InformacionFinancieraLBCBean informacionFinancieraLBCBean) throws InterruptedException {
        Thread.sleep(2000);
        try {

            if (informacionFinancieraLBCBean.getFechaExpedicionDocId() != null) {
                WebElement fecExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_1_fila_fieldDate']"));
                fecExp.click();
                Thread.sleep(2000);
                fecExp.click();
                fecExp.clear();
                fecExp.sendKeys(informacionFinancieraLBCBean.getFechaExpedicionDocId()); // Fecha expedición del documento de identificación
                Thread.sleep(2000);
            }

            WebElement lugExpOtro = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_2_fila_mandatory']"));
            if (informacionFinancieraLBCBean.getLugarExpedicionDocId() != null) {
                WebElement lugExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_2_fila_field']"));
                lugExp.click();
                Thread.sleep(2000);
                lugExp.click();
                lugExp.clear();
                lugExp.sendKeys(informacionFinancieraLBCBean.getLugarExpedicionDocId()); //Lugar de expedición del documento de identificación
                lugExpOtro.click();
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getActividadEconomica() != null) {
                Select actiEco = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                actiEco.selectByValue(informacionFinancieraLBCBean.getActividadEconomica()); // Actividad Economica CIIU
                //actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getNacionalidad() != null){
                Select naci = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_repeaterSelect_1_field']")));
                naci.selectByValue(informacionFinancieraLBCBean.getNacionalidad()); // Nacionalidad
                Thread.sleep(6000);
            }

            if (informacionFinancieraLBCBean.getActividadEconomica() != null && informacionFinancieraLBCBean.getNacionalidad() != null) {
                Select actiEco = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                Select naci = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_repeaterSelect_1_field']")));

                actiEco.selectByValue(informacionFinancieraLBCBean.getActividadEconomica()); // Actividad Economica CIIU
                naci.selectByValue(informacionFinancieraLBCBean.getNacionalidad()); // Nacionalidad
            }

            if (informacionFinancieraLBCBean.getEmpresaTrabaja() != null) {
                WebElement empTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_6_fila_field']"));
                //empTrab.click();
                Thread.sleep(2000);
                //empTrab.click();
                //empTrab.clear();
                empTrab.sendKeys(informacionFinancieraLBCBean.getEmpresaTrabaja()); // Empresa donde trabaja
                Thread.sleep(2000);
//                lugExpOtro.click();
                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getAreaTrabajo() != null) {
                WebElement areaTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_7_fila_field']"));
                Thread.sleep(2000);
                /*areaTrab.click();
                areaTrab.click();
                areaTrab.clear();*/
                areaTrab.sendKeys(informacionFinancieraLBCBean.getAreaTrabajo()); // Área
//                lugExpOtro.click();
                Thread.sleep(4000);

                Thread.sleep(2000);
            }

            if (informacionFinancieraLBCBean.getCargoTrabajo() != null) {
                WebElement cargTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_8_fila_field']"));
                cargTrab.click();
                Thread.sleep(2000);
                cargTrab.click();
                cargTrab.clear();
                cargTrab.sendKeys(informacionFinancieraLBCBean.getCargoTrabajo()); // Cargo
            }

            if (informacionFinancieraLBCBean.getDireccionLaboral() != null) {
                WebElement dirLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_9_fila_field']"));
                dirLab.click();
                Thread.sleep(2000);
                dirLab.click();
                dirLab.clear();
                dirLab.sendKeys(informacionFinancieraLBCBean.getDireccionLaboral()); // Dirección Laboral
            }

            if (informacionFinancieraLBCBean.getCiudadLaboral() != null) {
                WebElement ciuLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_10_fila_field']"));
                ciuLab.click();
                Thread.sleep(2000);
                ciuLab.click();
                ciuLab.clear();
                ciuLab.sendKeys(informacionFinancieraLBCBean.getCiudadLaboral()); // Ciudad Laboral
            }

            if (informacionFinancieraLBCBean.getTelefonoLaboral() != null) {
                WebElement telLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_11_fila_field']"));
                telLab.click();
                Thread.sleep(2000);
                telLab.click();
                telLab.clear();
                telLab.sendKeys(informacionFinancieraLBCBean.getTelefonoLaboral()); // Teléfono Laboral
            }

            if (informacionFinancieraLBCBean.getNumeroFax() != null) {
                WebElement numFax = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_12_fila_field']"));
                numFax.click();
                Thread.sleep(2000);
                numFax.click();
                numFax.clear();
                numFax.sendKeys(informacionFinancieraLBCBean.getNumeroFax()); // Número de Fax
            }

            if (informacionFinancieraLBCBean.getTelefonoFijo() != null) {
                WebElement telFij = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_13_fila_field']"));
                telFij.click();
                Thread.sleep(2000);
                telFij.click();
                telFij.clear();
                telFij.sendKeys(informacionFinancieraLBCBean.getTelefonoFijo()); // Telefono Fijo
            }

            if (informacionFinancieraLBCBean.getTelefonoCelular() != null) {
                WebElement telCel = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_14_fila_field']"));
                telCel.click();
                Thread.sleep(2000);
                telCel.click();
                telCel.clear();
                telCel.sendKeys(informacionFinancieraLBCBean.getTelefonoCelular()); // Celular
            }

            if (informacionFinancieraLBCBean.getFechaDiligencia() != null) {
                WebElement fecDili = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_15_fila_fieldDate']"));
                fecDili.click();
                Thread.sleep(2000);
                fecDili.click();
                fecDili.clear();
                fecDili.sendKeys(informacionFinancieraLBCBean.getFechaDiligencia()); // Fecha Diligenciamiento Sarlaft
            }

            if (informacionFinancieraLBCBean.getIngresosMensuales() != null) {
                WebElement ingMens = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_1_fila_field']"));
                ingMens.click();
                Thread.sleep(2000);
                ingMens.click();
                ingMens.clear();
                ingMens.sendKeys(informacionFinancieraLBCBean.getIngresosMensuales()); // Ingresos Mensuales
            }

            if (informacionFinancieraLBCBean.getOtrosIngresos() != null) {
                WebElement otrIng = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_2_fila_field']"));
                otrIng.click();
                Thread.sleep(2000);
                otrIng.click();
                otrIng.clear();
                otrIng.sendKeys(informacionFinancieraLBCBean.getOtrosIngresos()); // Otros Ingresos
            }

            if (informacionFinancieraLBCBean.getConceptoOtrosIngresos() != null) {
                WebElement conOtrIng = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_3_fila_field']"));
                conOtrIng.click();
                Thread.sleep(2000);
                conOtrIng.click();
                conOtrIng.clear();
                conOtrIng.sendKeys(informacionFinancieraLBCBean.getConceptoOtrosIngresos()); // Concepto Otros Ingresos
            }

            if (informacionFinancieraLBCBean.getEgresosMensuales() != null) {
                WebElement egrMen = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_4_fila_field']"));
                egrMen.click();
                Thread.sleep(2000);
                egrMen.click();
                egrMen.clear();
                egrMen.sendKeys(informacionFinancieraLBCBean.getEgresosMensuales()); // Egresos Mensuales
            }

            if (informacionFinancieraLBCBean.getActivos() != null) {
                WebElement act = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_5_fila_field']"));
                act.click();
                Thread.sleep(2000);
                act.click();
                act.clear();
                act.sendKeys(informacionFinancieraLBCBean.getActivos()); // Activos
            }

            if (informacionFinancieraLBCBean.getPasivos() != null) {
                WebElement pas = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_6_fila_field']"));
                pas.click();
                Thread.sleep(2000);
                pas.click();
                pas.clear();
                pas.sendKeys(informacionFinancieraLBCBean.getPasivos()); // Pasivos
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


            if (informacionFinancieraLBCBean.getVerifInformacion() != null) {
                // Verificación de la información

                WebElement verInfSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_7_fila_field_repeaterChoice_2_radio']"));
                WebElement verInfNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_7_fila_field_repeaterChoice_1_radio']"));

                String verInfo = informacionFinancieraLBCBean.getVerifInformacion().toLowerCase();
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

            obser.sendKeys(informacionFinancieraLBCBean.getObservaciones()); // Observaciones
            // Por cargo o actividad maneja recurso públicos
            if (informacionFinancieraLBCBean.getManejaRecursosPub().equals("SI") || informacionFinancieraLBCBean.getManejaRecursosPub().equals("Si")){
                manRecPubSi.click();
                Thread.sleep(2000);
                manRecPubSi.click();
            } else if (informacionFinancieraLBCBean.getManejaRecursosPub().equals("NO") || informacionFinancieraLBCBean.getManejaRecursosPub().equals("No")){
                manRecPubNo.click();
                Thread.sleep(2000);
                manRecPubNo.click();
            }
            // Por cargo ó actividad ejerce algún grado de poder público
            if (informacionFinancieraLBCBean.getEjercePoderPub().equals("SI") || informacionFinancieraLBCBean.getEjercePoderPub().equals("Si")){
                gradPodPubSi.click();
                Thread.sleep(2000);
                gradPodPubSi.click();
            } else if (informacionFinancieraLBCBean.getEjercePoderPub().equals("NO") || informacionFinancieraLBCBean.getEjercePoderPub().equals("No")){
                gradPodPubNo.click();
                Thread.sleep(2000);
                gradPodPubNo.click();
            }
            // Por su actividad u oficio goza usted de reconocimiento público general
            if (informacionFinancieraLBCBean.getReconoPubGeneral().equals("SI") || informacionFinancieraLBCBean.getReconoPubGeneral().equals("Si")){
                recPubGenSi.click();
                Thread.sleep(2000);
                recPubGenSi.click();
            } else if (informacionFinancieraLBCBean.getReconoPubGeneral().equals("NO") || informacionFinancieraLBCBean.getReconoPubGeneral().equals("No")){
                recPubGenNo.click();
                Thread.sleep(2000);
                recPubGenNo.click();
            }
            // Reporta productos en el exterior
            if (informacionFinancieraLBCBean.getReportaProdExterior().equals("SI") || informacionFinancieraLBCBean.getReportaProdExterior().equals("Si")){
                prodExtSi.click();
                Thread.sleep(2000);
                prodExtSi.click();
            } else if (informacionFinancieraLBCBean.getReportaProdExterior().equals("NO") || informacionFinancieraLBCBean.getReportaProdExterior().equals("No")){
                prodExtNo.click();
                Thread.sleep(2000);
                prodExtNo.click();
            }
            // Realiza operaciones en moneda extranjera importaciones, exportaciones, inversiones, transferencias otra cual
            if (informacionFinancieraLBCBean.getOpExtranjerasNo().equals("SI") || informacionFinancieraLBCBean.getOpExtranjerasNo().equals("Si")){
                opExtNo.click();
                Thread.sleep(2000);
                opExtNo.click();
            }
            if (informacionFinancieraLBCBean.getOpExtranjerasExporta().equals("SI") || informacionFinancieraLBCBean.getOpExtranjerasExporta().equals("Si")){
                opExtExp.click();
                Thread.sleep(2000);
                opExtExp.click();
            }
            if (informacionFinancieraLBCBean.getOpExtranjerasImporta().equals("SI") || informacionFinancieraLBCBean.getOpExtranjerasImporta().equals("Si")){
                opExtImp.click();
                Thread.sleep(2000);
                opExtImp.click();
            }
            if (informacionFinancieraLBCBean.getOpExtranjerasInversion().equals("SI") || informacionFinancieraLBCBean.getOpExtranjerasInversion().equals("Si")){
                opExtInv.click();
                Thread.sleep(2000);
                opExtInv.click();
            }
            if (informacionFinancieraLBCBean.getOpExtranjerasOtra().equals("SI") || informacionFinancieraLBCBean.getOpExtranjerasOtra().equals("Si")){
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

    public void InfoFinanciera(MetodosLBC a, WebDriver driver, InformacionFinancieraLBCBean informacionFinancieraLBCBean) throws InterruptedException, IOException {

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

            Formulario(a, driver, informacionFinancieraLBCBean);
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
