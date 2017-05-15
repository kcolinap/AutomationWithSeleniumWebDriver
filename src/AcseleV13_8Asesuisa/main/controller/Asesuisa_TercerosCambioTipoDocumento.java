package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCambioTipoDocumentoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import sun.awt.windows.ThemeReader;

import java.awt.*;
/**
 * Created by kcolina on 18/04/2017.
 */
public class Asesuisa_TercerosCambioTipoDocumento {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosCambioTipoDocumento.class);

    public String nombreAutomatizacion = "Cambio de documento Tercero";
    private WebDriver driver;
    public String identi="";
    public boolean existeTercero=false;
    public boolean status=true;

    public void testLink(Asesuisa_TercerosCambioTipoDocumentoBean bean, int i, String folderName){

        salidaTryPrincipal: try {

            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento asesuisaMenuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver, nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            asesuisaMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion,2,i,folderName);

            Thread.sleep(2000);
            m.cambiarVentana(driver);
            Thread.sleep(2000);

            //Buscar tercero
            TipoBusqueda(driver, m, bean, folderName, i);
            Thread.sleep(1000);

            if (existeTercero){

            }else if (!status) {
                break salidaTryPrincipal;
            }else{
                System.out.println("Vuelvo a busqueda para consultar los cambios en tercero");

                //Vuelvo a busqueda para consultar los cambios en tercero
                WebElement btnVolver, txtCodIdenti, txtaux;
                btnVolver = driver.findElement(By.xpath("//span[@wicketpath='ThirdInformationContent_panelInformationAndReturnPage_form_editValidity_editValidityLabel']"));
                btnVolver.click();
                m.waitSearchWicket(driver, ". Volviendo a busqueda");
                Thread.sleep(1000);

                txtCodIdenti = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                txtCodIdenti.sendKeys(identi);
                Thread.sleep(1500);
                txtaux = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_19_fila_field']"));
                txtaux.click();
                m.waitSearchWicket(driver, ". Validando");

                //Btn Buscar
                WebElement btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
                btnBuscar.click();
                m.waitSearchWicket(driver, ". Buscando tercero");
                Thread.sleep(400);

                WebElement opt = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
                opt.click();
                Thread.sleep(1000);

                //Pantallazo
                m.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion,folderName);
                Thread.sleep(800);

                //Consultar
                WebElement btnConsultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_consultThirdButton']"));
                btnConsultar.click();
                m.waitSearchWicket(driver, ". Entrando modo consulta");

                //Pantallazo
                m.ScreenShotPool(driver,i,"screen8",nombreAutomatizacion,folderName);
                Thread.sleep(800);

            }

            System.out.println("Fin de la prueba");
            Thread.sleep(2000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void TipoBusqueda(WebDriver driver, Metodos m, Asesuisa_TercerosCambioTipoDocumentoBean bean,
                             String folderName, int i){
        try{

            int scenarioBusqueda;
            if ( (bean.getPrimerApellido()==null) &&
                    (bean.getNumeroDocumento()==null) && (bean.getCodigoIdentificador()==null)){
                scenarioBusqueda=1;
            }else{
                //Evaluo tipo tercero
                if(bean.getTipoTercero()!=null){
                    Thread.sleep(500);
                    Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                    tipoT.selectByValue(bean.getTipoTercero());
                    Thread.sleep(1000);
                }

                //Evaluo si hay primer nombre
                if (bean.getPrimerNombre()!=null){

                }

                if (bean.getCodigoIdentificador()!=null){

                }
                scenarioBusqueda=2;
            }

            int nroAux;
            switch (scenarioBusqueda){
                case 1:

                    if (bean.getNumeroDocumentoN()==null){//Busqueda general, sin campo especxifico, solo tipo documento
                        BusquedaCaseGeneral(driver, m, bean, folderName, i, 1);
                    }else if ((bean.getNumeroDocumentoN()!=null)){
                        BusquedaCaseGeneral(driver, m, bean, folderName, i, 2);
                    } /*else if ((bean.getNumeroDocumentoN()!=null) && (bean.getCodigoIdentificador()!=null)) {
                        BusquedaCaseGeneral(driver, m, bean, folderName, i, 3);
                    }*/
                    break;
                case 2:
                    if (  (bean.getCodigoIdentificador()!=null)  && ( (bean.getPrimerNombre()==null) ||
                            (bean.getPrimerApellido()==null) )) {//Busqueda por codigo identificador. Nro existente
                        BusquedaCaseGeneral(driver, m, bean, folderName, i, 3);
                    }else if((bean.getCodigoIdentificador()!=null) && ( (bean.getPrimerNombre()!=null) ||
                            (bean.getPrimerApellido()!=null) ) && (bean.getNumeroDocumentoN()!=null)) {//busqueda por nombre y/o apellido. Nro existente
                        BusquedaCaseGeneral(driver, m, bean, folderName, i, 3);
                    }else if((bean.getCodigoIdentificador()!=null) && ( (bean.getPrimerNombre()!=null) ||
                            (bean.getPrimerApellido()!=null) ) && (bean.getNumeroDocumentoN()==null)) {//busqueda por nombre y/o apellido. Nro NO existente
                        BusquedaCaseGeneral(driver, m, bean, folderName, i, 4);
                    }
                    break;
                default:
                    break;
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void BusquedaCaseGeneral(WebDriver driver, Metodos m, Asesuisa_TercerosCambioTipoDocumentoBean bean,
                                    String folderName, int i, int testCase){
        int nroAux, nro;
        WebElement txtNroDoc, txtAux, txtAux2, btnGuardar;
        String tipoA = "", nombreDoc = "", nroDoc="";

        salidaTry: try {
            WebElement btnEditar;
            switch (testCase){
                case 1://cambio de tipo documento
                    Busqueda(driver, m, bean, folderName, 1, i, 3, 4, 5);

                    //Boton editar
                    btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
                    btnEditar.click();
                    m.waitSearchWicket(driver,". Entrando en modo edicion");
                    Thread.sleep(1000);

                    //pantallazo

                    if (bean.getTipoDocumento()!=null) {
                        //String tipoA = "", nombreDoc = "";
                        tipoA = driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")).getAttribute("value");

                        Select tipoD = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                        if (tipoA.equals("844135")) {
                            nombreDoc="N° de Pasaporte";
                            System.out.println("Tipo documento actual: "+nombreDoc);
                            Thread.sleep(1000);
                            tipoD.selectByValue("844136");
                            Thread.sleep(500);
                            nombreDoc="";
                            nombreDoc="N° de Carnet de Residencia";
                        } else if (tipoA.equals("844136")){
                            nombreDoc="N° de Carnet de Residencia";
                            System.out.println("Tipo documento actual: "+nombreDoc);
                            Thread.sleep(1000);
                            tipoD.selectByValue("844135");
                            Thread.sleep(500);
                            nombreDoc="";
                            nombreDoc="N° de Pasaporte";
                        }


                        //pantallazo


                        //Boton guardar
                        btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
                        btnGuardar.click();
                        m.waitSearchWicket(driver, ". Guardando cambios");
                        Thread.sleep(1000);
                        System.out.println("El tipo de documento ha sido cambiado correctamente a "+nombreDoc);
                    }
                    break;
                case 2://Cambio de tipo y numero
                    Busqueda(driver, m, bean, folderName, 1, i, 3, 4, 5);

                    //Boton editar
                    btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
                    btnEditar.click();
                    m.waitSearchWicket(driver,". Entrando en modo edicion");
                    Thread.sleep(1000);

                    //pantallazo

                    if (bean.getTipoDocumento()!=null) {
                        //int nro;
                        //String tipoA = "", nombreDoc = "", nroDoc="";
                        tipoA = driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")).getAttribute("value");

                        Select tipoD = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                        if (tipoA.equals("844135")) {
                            nombreDoc="N° de Pasaporte";
                            nroDoc= driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']")).getAttribute("value");
                            System.out.println("Tipo documento actual: "+nombreDoc);
                            System.out.println("Numer documento actual: "+nroDoc);
                            Thread.sleep(1000);
                            tipoD.selectByValue("844136");
                            Thread.sleep(2000);
                            nombreDoc="";nroDoc="";
                            nombreDoc="N° de Carnet de Residencia";
                            //nroDoc=bean.getNumeroDocumentoN();
                            for(int ram=0; ram<8; ram++){
                                nro=GeneraNumero();
                                nroDoc+=String.valueOf(nro);
                            }

                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));

                            Thread.sleep(2000);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            Thread.sleep(600);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.click();
                            m.waitSearchWicket(driver, ". Refrescando");
                            Thread.sleep(2000);
                            txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                            txtAux.click();
                            Thread.sleep(500);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            Thread.sleep(400);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(Keys.chord(Keys.BACK_SPACE));
                            Thread.sleep(400);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            Thread.sleep(200);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(nroDoc);
                            Thread.sleep(500);
                            txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                            txtAux.click();
                            Thread.sleep(500);
                        } else if (tipoA.equals("844136")){
                            nombreDoc="N° de Carnet de Residencia";
                            nroDoc= driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']")).getAttribute("value");
                            System.out.println("Tipo documento actual: "+nombreDoc);
                            System.out.println("Numer documento actual: "+nroDoc);
                            Thread.sleep(1000);
                            tipoD.selectByValue("844135");
                            Thread.sleep(20000);
                            nombreDoc="";nroDoc="";
                            nombreDoc="N° de Pasaporte";
                            for(int ram=0; ram<8; ram++){
                                nro=GeneraNumero();
                                nroDoc+=String.valueOf(nro);
                            }
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));

                            Thread.sleep(2000);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            Thread.sleep(600);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.click();
                            m.waitSearchWicket(driver, ". Refrescando");
                            Thread.sleep(2000);
                            txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                            txtAux.click();
                            Thread.sleep(1000);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                            Thread.sleep(600);
                            txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                            txtNroDoc.sendKeys(nroDoc);
                            //System.out.println(nroDoc);
                        }


                        //pantallazo


                        //Boton guardar

                        btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
                        Thread.sleep(1500);
                        btnGuardar.click();
                        m.waitSearchWicket(driver, ". Guardando cambios");
                        Thread.sleep(1000);
                        System.out.println("El tipo de documento ha sido cambiado correctamente a "+nombreDoc);
                        System.out.println("El numero de documento ha sido cambiado correctamente a "+nroDoc);
                    }
                    break;
                case 3:
                    Busqueda(driver, m, bean, folderName, 2, i, 3, 4, 5);
                    if(!status){
                        status=false;
                        break salidaTry;
                    }
                    //Boton editar
                    btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
                    btnEditar.click();
                    m.waitSearchWicket(driver,". Entrando en modo edicion");
                    Thread.sleep(1000);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion,folderName);

                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));

                    Thread.sleep(2000);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(600);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.click();
                    m.waitSearchWicket(driver, ". Refrescando");
                    Thread.sleep(2000);
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();
                    Thread.sleep(500);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(400);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.BACK_SPACE));
                    Thread.sleep(400);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(200);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(bean.getNumeroDocumentoN());
                    Thread.sleep(1000);
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();
                    Thread.sleep(500);
                   /* txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();*/
                    Thread.sleep(800);
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();
                    Thread.sleep(800);
                    txtAux2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                    txtAux2.click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion,folderName);
                    //Boton guardar

                    btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
                    Thread.sleep(1500);
                    btnGuardar.click();
                    m.waitSearchWicket(driver, ". Guardando cambios");
                    Thread.sleep(2000);

                    //Compruebo mensaje de error
                    if (driver.findElements(By.className("w_windowMessage")).size()>0){
                        //pantallazo
                        m.ScreenShotPool(driver,i,"screen7",nombreAutomatizacion,folderName);
                        System.out.println("El Nro° de documento: "+bean.getNumeroDocumentoN()+", ya se encuentra registrado");
                        existeTercero=true;

                    }
                    break;
                case 4:

                    Busqueda(driver, m, bean, folderName, 2, i, 3, 4, 5);

                    //Boton editar
                    btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
                    btnEditar.click();
                    m.waitSearchWicket(driver,". Entrando en modo edicion");
                    Thread.sleep(1000);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen5",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));

                    for(int ram=0; ram<8; ram++){
                        nro=GeneraNumero();
                        nroDoc+=String.valueOf(nro);
                    }

                    Thread.sleep(2000);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(600);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.click();
                    m.waitSearchWicket(driver, ". Refrescando");
                    Thread.sleep(2000);
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();
                    Thread.sleep(500);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(400);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.BACK_SPACE));
                    Thread.sleep(400);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(200);
                    txtNroDoc = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    txtNroDoc.sendKeys(nroDoc);
                    Thread.sleep(1000);
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();
                    Thread.sleep(500);
                   /* txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();*/
                    Thread.sleep(800);
                    txtAux = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_7_fila_field']"));
                    txtAux.click();
                    Thread.sleep(800);
                    txtAux2 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                    txtAux2.click();
                    Thread.sleep(800);

                    //Pantallazo
                    m.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Boton guardar

                    btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
                    Thread.sleep(1500);
                    btnGuardar.click();
                    m.waitSearchWicket(driver, ". Guardando cambios");
                    Thread.sleep(2000);

                    //Compruebo mensaje de error
                    if (driver.findElements(By.className("w_windowMessage")).size()>0){
                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen6",nombreAutomatizacion,folderName);
                        Thread.sleep(800);

                        System.out.println("El Nro° de documento: "+bean.getNumeroDocumentoN()+", ya se encuentra registrado");
                        existeTercero=true;

                    }
                    break;
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void Busqueda(WebDriver driver, Metodos m, Asesuisa_TercerosCambioTipoDocumentoBean bean,
                                String folderName, int tipoB, int i, int screen1, int screen2, int screen3){
        //int aux = 0;
        String codIdenti="";
        WebElement btnBuscar;
        WebElement optTercero;

        salidaTry: try {
            switch (tipoB) {
                case 1:
                    //Boton buscar
                    btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
                    btnBuscar.click();
                    m.waitSearchWicket(driver, ". Buscando tercero");
                    Thread.sleep(400);


                    //Evaluo si se despliega el dialogo
                    if (driver.findElements(By.className("w_windowMessage")).size() > 0) {
                        WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_ConfirmExport_content_questionForm_confirmButton']"));
                        btnAceptar.click();
                        Thread.sleep(1000);
                    }

                    //Recorrer los terceros encontrados hasta encontrar uno habilitado(Si aplica)
                    int nroFilas = driver.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr")).size();
                    String lblStatus = "", lblCodigo;

                    for (int k = 0; k < nroFilas; k++) {
                        lblStatus = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[4]/div/span")).getText();
                        lblCodigo = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[3]/div/span")).getText();
                        if ((lblStatus.equals("Habilitado")) && (lblCodigo != null)) {
                            optTercero = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[1]/div/input"));
                            optTercero.click();
                            Thread.sleep(1000);
                            System.out.println("Tercero seleccionado: ");
                            System.out.println("Nombre: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[2]/div/span")).getText()));
                            System.out.println("Codigo Identificador: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[3]/div/span")).getText()));
                            //aux = k;
                            codIdenti = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[3]/div/span")).getText();
                            identi = codIdenti;
                            break;
                        }
                    }

                    //Pantallazo
                    //m.ScreenShotPool(driver,);
                    break;
                case 2:

                    //Valido si hay nombre
                    if (bean.getPrimerNombre()!=null){
                        WebElement txtNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                        txtNombre.sendKeys(bean.getPrimerNombre());
                        Thread.sleep(1000);
                        txtNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                        txtNombre.sendKeys(Keys.chord(Keys.TAB));
                        Thread.sleep(600);
                    }

                    //Valido si hay apellido
                    if (bean.getPrimerApellido()!=null){
                        WebElement txtApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                        txtApellido.sendKeys(bean.getPrimerApellido());
                        Thread.sleep(1000);
                        txtApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                        txtApellido.sendKeys(Keys.chord(Keys.TAB));
                        Thread.sleep(600);
                    }

                    //PANTALLAZO para capturar nombre apellido
                    m.ScreenShotPool(driver,i,"screen"+screen1,nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    //Escribo el codigo identificador
                    if (bean.getCodigoIdentificador()!=null){
                        WebElement txtCodI = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                        txtCodI.sendKeys(bean.getCodigoIdentificador());
                        Thread.sleep(2000);
                    }


                    //Boton buscar
                    boolean existe;
                    do{
                        btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
                        btnBuscar.click();
                        m.waitSearchWicket(driver, ". Buscando tercero");
                        Thread.sleep(400);

                    }while (driver.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table")).size()==0);

                    Thread.sleep(1500);

                    //Evaluo si el tercero esta habiliutado, si no esta, lo habilito
                    //si esta deshabilitado falla la prueba
                    boolean statusLabel = driver.findElement(By.xpath("//span[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_status']")).getText().equals("Deshabilitado");
                    if (statusLabel){
                        System.out.println("El tercero se encuentra deshabilitado. No se puede continuar con la operacion");
                        status=false;
                        break salidaTry;
                    }

                    optTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
                    optTercero.click();
                    Thread.sleep(1500);

                    //PANTALLAZO
                    m.ScreenShotPool(driver,i,"screen"+screen2,nombreAutomatizacion,folderName);
                    Thread.sleep(800);

                    System.out.println("Tercero seleccionado: ");
                    System.out.println("Nombre: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr/td[2]/div/span")).getText()));
                    System.out.println("Codigo Identificador: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr/td[3]/div/span")).getText()));
                    identi=bean.getCodigoIdentificador();
                    break;
                //case 3:
            }
        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }

            //aux += 1;
    }
           /* //pantallazo
            //Boton Consultar
            WebElement btnConsultar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_consultThirdButton']"));
            btnConsultar.click();
            m.waitSearchWicket(driver,". Consultando");
            Thread.sleep(500);

            //pantallazo


            String nroDocto1 = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']")).getAttribute("value");
            System.out.println("nro documento copiado: "+nroDocto1);

            //Vuelvo a consulta
            WebElement btnVolver = driver.findElement(By.xpath("//span[@wicketpath='ThirdInformationContent_panelInformationAndReturnPage_form_editValidity_editValidityLabel']"));
            btnVolver.click();
            m.waitSearchWicket(driver,". Volviendo a busqueda");


            //Seleccionar otro tercero
            for (int k=aux; k<nroFilas; k++){
                lblStatus=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[4]/div/span")).getText();
                lblCodigo = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[3]/div/span")).getText();
                if ((lblStatus.equals("Habilitado")) && (!(lblCodigo.equals("")))){
                    optTercero=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[1]/div/input"));
                    optTercero.click();
                    Thread.sleep(1000);
                    System.out.println("Tercero a editar  seleccionado: ");
                    System.out.println("Nombre: " + (driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[2]/div/span")).getText()));
                    System.out.println("Codigo Identificador: "+(driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr["+(k+1)+"]/td[3]/div/span")).getText()));
                    break;
                }
                lblStatus="";lblCodigo="";
            }

            //Boton editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            m.waitSearchWicket(driver, ". Entrando a modo edicion");

            if (bean.getTipoDocumento()!=null){
                Thread.sleep(500);
                Select tipoD = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                tipoD.selectByValue(bean.getTipoDocumento());
                Thread.sleep(1000);
            }


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }*/

    public int GeneraNumero(){
        double dou;

        dou=(Math.random()* 8 + 1);
        int nro = (int)(dou);
        return nro;
    }
}
