package AcseleV13_8.main.controller;

import AcseleV13_8.beans.TercerosInfoFinancieraBean;
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

    String nombreAutomatizacion = "Terceros Informacion Financiera";

    public void testLink(TercerosInfoFinancieraBean tercerosInfoFinancieraBean, int i)throws Exception{

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
        BusquedaT(a, driver, tercerosInfoFinancieraBean); //Busqueda Tercero

        // Boton Editar
        //driver.findElement(By.xpath("//form/input")).click();
        driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']")).click();
        Thread.sleep(3000);

        InfoFinanciera(a, driver, tercerosInfoFinancieraBean);

        Thread.sleep(3000);
        a.ScreenShot(driver, "screen9", nombreAutomatizacion);


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

    public void BusquedaT(Metodos a, WebDriver driver, TercerosInfoFinancieraBean tercerosInfoFinancieraBean) throws InterruptedException, IOException{

        Thread.sleep(4000);
        String title = driver.getTitle();
        System.out.println("Titulo de la pagina: " + title);

        //Tipo de tercero
        if (tercerosInfoFinancieraBean.getTipoTercero() != null) {
            Thread.sleep(3000);
            //Select tipoT = new Select(driver.findElement(By.name("SearchContent:ThirdInformation:thirdPartyTypes")));
            Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(tercerosInfoFinancieraBean.getTipoTercero());
        }
        Thread.sleep(2000); // //TipoElemento[@wicketpath='WicketpathElemento']

        if (tercerosInfoFinancieraBean.getTipoDocId() != null){
            //Select tipoDoc = new Select(driver.findElement(By.name("templateThird:repeaterPanel1:1:fila:repeaterSelect:1:field")));
            Select tipoDoc = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
            tipoDoc.selectByValue(tercerosInfoFinancieraBean.getTipoDocId());
        }

        if (tercerosInfoFinancieraBean.getCedula() != null) {
            //WebElement cedu = driver.findElement(By.name("templateThird:repeaterPanel1:2:fila:field"));
            WebElement cedu = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
            cedu.sendKeys(tercerosInfoFinancieraBean.getCedula());
        }

        if (tercerosInfoFinancieraBean.getNombre() != null) {
            //WebElement nTercero = driver.findElement(By.name("templateThird:repeaterPanel1:3:fila:field"));
            WebElement nTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
            nTercero.sendKeys(tercerosInfoFinancieraBean.getNombre());
        }

//        if (tercerosInfoFinancieraBean.getApellido() != null) {
//            WebElement aTercero = driver.findElement(By.name("templateThird:repeaterPanel1:5:fila:field"));
            //WebElement aTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
//            aTercero.sendKeys(tercerosInfoFinancieraBean.getApellido());
//        }

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

    }

    public void Formulario(Metodos a, WebDriver driver, TercerosInfoFinancieraBean tercerosInfoFinancieraBean) throws InterruptedException {
        Thread.sleep(2000);
        try{
//            WebElement fecExp = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div/div/div/div[4]/input"));
//            WebElement lugExp = driver.findElement(By.xpath("//form/div[2]/div/div/table/tbody/tr/td/div[2]/div/div/input[2]"));
//            Select actiEco = new Select(driver.findElement(By.xpath("//div[4]/div/div/div/select")));
//            Select naci = new Select(driver.findElement(By.xpath("//div[5]/div/div/div/select")));
//            WebElement empTrab = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[6]/div/div/input[2]"));
//            WebElement areaTrab = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[7]/div/div/input[2]"));
//            WebElement cargTrab = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[8]/div/div/input[2]"));
//            WebElement dirLab = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[9]/div/div/input[2]"));
//            WebElement ciuLab = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[10]/div/div/input[2]"));
//            WebElement telLab = driver.findElement(By.xpath("//div[11]/div/div/input[2]"));
//            WebElement numFax = driver.findElement(By.xpath("//div[12]/div/div/input[2]"));
//            WebElement telFij = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[13]/div/div/input[2]"));
//            WebElement telCel = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td/div[14]/div/div/input[2]"));
//            WebElement fecDili = driver.findElement(By.xpath("//div[15]/div/div/div[4]/input"));
//            WebElement ingMens = driver.findElement(By.xpath("//form/div[2]/div/div/table/tbody/tr/td[2]/div/div/div/input[2]"));
//            WebElement otrIng = driver.findElement(By.xpath("//form/div[2]/div/div/table/tbody/tr/td[2]/div[2]/div/div/input[2]"));
//            WebElement conOtrIng = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[3]/div/div/input[2]"));
//            WebElement egrMen = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[4]/div/div/input[2]"));
//            WebElement act = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[5]/div/div/input[2]"));
//            WebElement pas = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[6]/div/div/input[2]"));
//            WebElement verInfSi = driver.findElement(By.xpath("//div[7]/div/div/div[4]/div/div[2]/div/input"));
//            WebElement verInfNo = driver.findElement(By.xpath("//div[7]/div/div/div[4]/div/div/div/input"));
//            WebElement obser = driver.findElement(By.xpath("//textarea"));
//            WebElement manRecPubSi = driver.findElement(By.xpath("//div[9]/div/div/div[4]/div/div[2]/div/input"));
//            WebElement manRecPubNo = driver.findElement(By.xpath("//div[9]/div/div/div[4]/div/div/div/input"));
//
//            WebElement gradPodPubSi = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[10]/div/div/div[4]/div/div[2]/div/input"));
//            WebElement gradPodPubNo = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[10]/div/div/div[4]/div/div/div/input"));
//
//            WebElement recPubGenSi = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[12]/div/div/div[4]/div/div[2]/div/input"));
//            WebElement recPubGenNo = driver.findElement(By.xpath("//div[2]/div/div/table/tbody/tr/td[2]/div[12]/div/div/div[4]/div/div/div/input"));
//
//            WebElement prodExtSi = driver.findElement(By.xpath("//div[13]/div/div/div[4]/div/div[2]/div/input"));
//            WebElement prodExtNo = driver.findElement(By.xpath("//div[13]/div/div/div[4]/div/div/div/input"));
//
//            WebElement opExtNo = driver.findElement(By.xpath("//div/div[4]/div/div/input"));
//            WebElement opExtExp = driver.findElement(By.xpath("//div[4]/div[2]/div/input"));
//            WebElement opExtImp = driver.findElement(By.xpath("//div[3]/div/input"));
//            WebElement opExtInv = driver.findElement(By.xpath("//div[5]/div/input"));
//            WebElement opExtOtra = driver.findElement(By.xpath("//div[4]/div/input"));

            WebElement fecExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_1_fila_fieldDate']"));
            WebElement lugExp = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_2_fila_field']"));
            Select actiEco = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
            Select naci = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_5_fila_repeaterSelect_1_field']")));
            WebElement empTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_6_fila_field']"));
            WebElement areaTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_7_fila_field']"));
            WebElement cargTrab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_8_fila_field']"));
            WebElement dirLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_9_fila_field']"));
            WebElement ciuLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_10_fila_field']"));
            WebElement telLab = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_11_fila_field']"));
            WebElement numFax = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_12_fila_field']"));
            WebElement telFij = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_13_fila_field']"));
            WebElement telCel = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_14_fila_field']"));
            WebElement fecDili = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel1_15_fila_fieldDate']"));
            WebElement ingMens = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_1_fila_field']"));
            WebElement otrIng = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_2_fila_field']"));
            WebElement conOtrIng = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_3_fila_field']"));
            WebElement egrMen = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_4_fila_field']"));
            WebElement act = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_5_fila_field']"));
            WebElement pas = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_6_fila_field']"));
            WebElement verInfSi = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_7_fila_field_repeaterChoice_2_radio']"));
            WebElement verInfNo = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_data__container__ThirdFinInfo_BasicThirdInformation_registerFormThirdAddress_templateBasicFinantial_repeaterPanel2_7_fila_field_repeaterChoice_1_radio']"));
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

            fecExp.click();
            Thread.sleep(2000);
            fecExp.click();
            fecExp.clear();
            fecExp.sendKeys(tercerosInfoFinancieraBean.getFechaExpedicionDocId()); // Fecha expedición del documento de identificación

            lugExp.click();
            Thread.sleep(2000);
            lugExp.click();
            lugExp.clear();
            lugExp.sendKeys(tercerosInfoFinancieraBean.getLugarExpedicionDocId()); //Lugar de expedición del documento de identificación

            actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
            actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
            naci.selectByValue(tercerosInfoFinancieraBean.getNacionalidad()); // Nacionalidad
            Thread.sleep(6000);
            actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
            naci.selectByValue(tercerosInfoFinancieraBean.getNacionalidad()); // Nacionalidad

//            actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
//            Thread.sleep(3000);
//            naci.selectByValue(tercerosInfoFinancieraBean.getNacionalidad()); // Nacionalidad
//            Thread.sleep(3000);
//            actiEco.selectByValue(tercerosInfoFinancieraBean.getActividadEconomica()); // Actividad Economica CIIU
//            Thread.sleep(3000);
//            naci.selectByValue(tercerosInfoFinancieraBean.getNacionalidad()); // Nacionalidad

            empTrab.click();
            Thread.sleep(2000);
            empTrab.click();
            empTrab.clear();
            empTrab.sendKeys(tercerosInfoFinancieraBean.getEmpresaTrabaja()); // Empresa donde trabaja

            areaTrab.click();
            Thread.sleep(2000);
            areaTrab.click();
            areaTrab.clear();
            areaTrab.sendKeys(tercerosInfoFinancieraBean.getAreaTrabajo()); // Área

            cargTrab.click();
            Thread.sleep(2000);
            cargTrab.click();
            cargTrab.clear();
            cargTrab.sendKeys(tercerosInfoFinancieraBean.getCargoTrabajo()); // Cargo

            dirLab.click();
            Thread.sleep(2000);
            dirLab.click();
            dirLab.clear();
            dirLab.sendKeys(tercerosInfoFinancieraBean.getDireccionLaboral()); // Dirección Laboral

            ciuLab.click();
            Thread.sleep(2000);
            ciuLab.click();
            ciuLab.clear();
            ciuLab.sendKeys(tercerosInfoFinancieraBean.getCiudadLaboral()); // Ciudad Laboral

            telLab.click();
            Thread.sleep(2000);
            telLab.click();
            telLab.clear();
            telLab.sendKeys(tercerosInfoFinancieraBean.getTelefonoLaboral()); // Teléfono Laboral

            numFax.click();
            Thread.sleep(2000);
            numFax.click();
            numFax.clear();
            numFax.sendKeys(tercerosInfoFinancieraBean.getNumeroFax()); // Número de Fax

            telFij.click();
            Thread.sleep(2000);
            telFij.click();
            telFij.clear();
            telFij.sendKeys(tercerosInfoFinancieraBean.getTelefonoFijo()); // Telefono Fijo

            telCel.click();
            Thread.sleep(2000);
            telCel.click();
            telCel.clear();
            telCel.sendKeys(tercerosInfoFinancieraBean.getTelefonoCelular()); // Celular

            fecDili.click();
            Thread.sleep(2000);
            fecDili.click();
            fecDili.clear();
            fecDili.sendKeys(tercerosInfoFinancieraBean.getFechaDiligencia()); // Fecha Diligenciamiento Sarlaft

            ingMens.click();
            Thread.sleep(2000);
            ingMens.click();
            ingMens.clear();
            ingMens.sendKeys(tercerosInfoFinancieraBean.getIngresosMensuales()); // Ingresos Mensuales

            otrIng.click();
            Thread.sleep(2000);
            otrIng.click();
            otrIng.clear();
            otrIng.sendKeys(tercerosInfoFinancieraBean.getOtrosIngresos()); // Otros Ingresos

            conOtrIng.click();
            Thread.sleep(2000);
            conOtrIng.click();
            conOtrIng.clear();
            conOtrIng.sendKeys(tercerosInfoFinancieraBean.getConceptoOtrosIngresos()); // Concepto Otros Ingresos

            egrMen.click();
            Thread.sleep(2000);
            egrMen.click();
            egrMen.clear();
            egrMen.sendKeys(tercerosInfoFinancieraBean.getEgresosMensuales()); // Egresos Mensuales

            act.click();
            Thread.sleep(2000);
            act.click();
            act.clear();
            act.sendKeys(tercerosInfoFinancieraBean.getActivos()); // Activos

            pas.click();
            Thread.sleep(2000);
            pas.click();
            pas.clear();
            pas.sendKeys(tercerosInfoFinancieraBean.getPasivos()); // Pasivos
            // Verificación de la información
            if (tercerosInfoFinancieraBean.getVerifInformacion().equals("SI") || tercerosInfoFinancieraBean.getVerifInformacion().equals("Si")){
                verInfSi.click();
                Thread.sleep(2000);
                verInfSi.click();
            } else if (tercerosInfoFinancieraBean.getVerifInformacion().equals("NO") || tercerosInfoFinancieraBean.getVerifInformacion().equals("No")){
                verInfNo.click();
                Thread.sleep(2000);
                verInfNo.click();
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

        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 23 - Terceros Informacion financiera - " + e);
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
//            log.info("Test Case 23 - Terceros Informacion financiera - " + e);
//        }
    }

    public void InfoFinanciera(Metodos a, WebDriver driver, TercerosInfoFinancieraBean tercerosInfoFinancieraBean) throws InterruptedException, IOException {

        Thread.sleep(2000);
        // Boton Agregar
        try{
            //WebElement btnAgregar = driver.findElement(By.xpath("//div[2]/div/form/div[2]/div/input"));
            WebElement btnAgregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelFinancialInformation_formThirdFinancial_AddButton']"));
            btnAgregar.click(); // Boton Agregar
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        } catch (Exception e){
            e.printStackTrace();
//             log.info(e);
            log.info("Test Case 23 - Terceros Informacion financiera - " + e);
        }

        Formulario(a, driver, tercerosInfoFinancieraBean);
        Thread.sleep(3000);
        a.ScreenShot(driver, "screen8", nombreAutomatizacion);

//        Formulario(a, driver, tercerosInfoFinancieraBean);
        Thread.sleep(3000);
        a.ScreenShot(driver, "screen8-1", nombreAutomatizacion);


        System.out.println("Fin Prueba");

    }

}
