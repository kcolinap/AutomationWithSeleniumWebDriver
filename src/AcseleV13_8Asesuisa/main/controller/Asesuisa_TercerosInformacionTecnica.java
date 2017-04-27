package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosInformacionTecnicaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by kcolina on 06/03/2017.
 */
public class Asesuisa_TercerosInformacionTecnica {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosInformacionTecnica.class);
    public String nombreAutomatizacion = "Terceros - Informacion Tecnica";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosInformacionTecnicaBean bean, int i, String
                         folderName){
        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();
            //Asesuisa_BuscarTerceros buscarTerceros = new Asesuisa_BuscarTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion, i, folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            menuMantenimiento.MantTerc_BuscarTercero(driver,nombreAutomatizacion,2,i,folderName);
            Thread.sleep(1000);
            m.cambiarVentana(driver);
            Thread.sleep(500);

            //Evaluo el tipo de busqueda
            if (bean.getTipoBusqueda().equals("0")){
                BusquedaL(driver, m, bean,nombreAutomatizacion,i,folderName);
                Thread.sleep(1500);
            }else{
                BusquedaT(driver, m, bean,nombreAutomatizacion,i,folderName);
                Thread.sleep(1500);

                //Llamada a metodo informacion tecnica
                InformacionTecnica(driver, m, i, folderName,1);
                Thread.sleep(1000);
            }
            //Buscar tercero
            //buscarTerceros.BusquedaT(driver, m, asesuisaTercerosInformacionTecnicaBean,nombreAutomatizacion,i,folderName, 3,4,5,6, 7);
            /*BusquedaT(driver, m, bean,nombreAutomatizacion,i,folderName);
            Thread.sleep(1500);*/

            //Fin de la prueba
            //System.out.println("Fin de la prueba!!!");
            //Salgo de la aplicacion
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BusquedaT(WebDriver driver, Metodos m,
                          Asesuisa_TercerosInformacionTecnicaBean bean, String nombreAutomatizacion, int i,
                          String folderName){
        busqueda: try {

            int tipoTercero=0;
            Select tipoT;
            WebElement etiqueta, btnBuscar, optTercero;

            if ( (bean.getTipoTercero() != null) &&
                    (bean.getTipoTercero().equals("NaturalPerson")) ) {
                tipoTercero = 1;
            }else if  ( (bean.getTipoTercero() != null) &&
                    (bean.getTipoTercero().equals("LegalPerson")) ){
                tipoTercero=2;
            }

            //Establecer tipo tercero
            Thread.sleep(1000);
            tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(bean.getTipoTercero());
            m.waitSearchWicket(driver,". Estableciendo tercero");
            Thread.sleep(1000);

            switch (tipoTercero){
                case 1:
                    //Primer Nombre
                    if(  (bean.getPrimerNombre() != null) && (bean.getPrimerApellido() != null)  ){

                        ///llenar nombre
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement primerNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                        primerNombre.clear();
                        Thread.sleep(600);
                        primerNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                        primerNombre.click();
                        Thread.sleep(600);
                        primerNombre.sendKeys(bean.getPrimerNombre());
                        Thread.sleep(1000);

                        //LLenar apellido
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement primerApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                        primerApellido.clear();
                        Thread.sleep(600);
                        primerApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                        primerApellido.click();
                        Thread.sleep(600);
                        primerApellido.sendKeys(bean.getPrimerApellido());
                        Thread.sleep(1000);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                        Thread.sleep(900);
                    }


                    //Numero y tipo documento
                    if(  (bean.getNumeroDocumento() != null) && (bean.getTipoDocumentoIdentificacion() != null) ){

                        //Seleccionar tipo de documento
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_6_fila_repeaterSelect_1_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        Select tipoDocumento = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                        Thread.sleep(400);
                        tipoDocumento.selectByValue(bean.getTipoDocumentoIdentificacion());
                        Thread.sleep(1000);

                        //Numero del documento
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement numeroDocumento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                        numeroDocumento.clear();
                        Thread.sleep(600);
                        numeroDocumento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                        numeroDocumento.click();
                        Thread.sleep(600);
                        numeroDocumento.sendKeys(bean.getNumeroDocumento());
                        Thread.sleep(1000);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                        Thread.sleep(900);
                    }

                    //Codigo identificador
                    if (bean.getCodigoIdentificador() != null){
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                        codigoIdentificador.clear();
                        Thread.sleep(600);
                        codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                        codigoIdentificador.click();
                        Thread.sleep(600);
                        codigoIdentificador.sendKeys(bean.getCodigoIdentificador());
                        Thread.sleep(1000);

                        if (( (bean.getPrimerNombre() == null )
                                || (bean.getPrimerApellido() == null)  )){
                            //Pantallazo
                            m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                            Thread.sleep(900);
                        }
                    }

                    break;
                case 2:
                    //Codigo identificador
                    if (bean.getCodigoIdentificador() != null){
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_12_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_12_fila_field']"));
                        codigoIdentificador.clear();
                        Thread.sleep(600);
                        codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_12_fila_field']"));
                        codigoIdentificador.click();
                        Thread.sleep(600);
                        codigoIdentificador.sendKeys(bean.getCodigoIdentificador());
                        Thread.sleep(1000);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                        Thread.sleep(900);

                        /*if (( (bean.getPrimerNombre() == null )
                                || (bean.getPrimerApellido() == null)  )){
                            //Pantallazo
                            m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                            Thread.sleep(900);
                        }*/
                    }

                    //razon social
                    if (bean.getRazonSocial() != null){
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement razonSocial = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                        razonSocial.clear();
                        Thread.sleep(600);
                        razonSocial = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_1_fila_field']"));
                        razonSocial.click();
                        Thread.sleep(600);
                        razonSocial.sendKeys(bean.getRazonSocial());
                        Thread.sleep(1000);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                        Thread.sleep(900);
                    }

                    //NRC
                    if (bean.getNroNRC() != null){
                        etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_etiqueta']"));
                        etiqueta.click();
                        Thread.sleep(1000);
                        WebElement nroNrc = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_field']"));
                        nroNrc.clear();
                        Thread.sleep(600);
                        nroNrc = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_field']"));
                        nroNrc.click();
                        Thread.sleep(600);
                        nroNrc.sendKeys(bean.getNroNRC());
                        Thread.sleep(1000);

                        //Pantallazo
                        m.ScreenShotPool(driver,i,"screen3",nombreAutomatizacion,folderName);
                        Thread.sleep(900);
                    }
                    break;
                default:
                    break;
            }

            //Boton buscar
            do{
                btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
                btnBuscar.click();
                m.waitSearchWicket(driver,". Buscando tercero");
                Thread.sleep(600);
            }while(driver.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table")).size()==0);

            //Bajar el scroll
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,600)", "");
            Thread.sleep(500);

            //Seleccionar tercero
            optTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
            optTercero.click();
            Thread.sleep(600);
            System.out.println("/////////////////////////////////////");
            System.out.println("Tercero seleccionado: ");
            System.out.println("Nombre: "+driver.findElement(By.xpath("//span[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_name']")).getText());
            System.out.println("Codigo identificador: "+driver.findElement(By.xpath("//span[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_codifierCode']")).getText());
            System.out.println("/////////////////////////////////////");

            //Pantallazo
            m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
            Thread.sleep(900);
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void  BusquedaL(WebDriver driver, Metodos m, Asesuisa_TercerosInformacionTecnicaBean bean,
                           String nombreAutomatizacion, int i, String folderName){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            int tipoTercero=0;
            Select tipoT;
            WebElement etiqueta, btnBuscar, optTercero;

            if ( (bean.getTipoTercero() != null) &&
                    (bean.getTipoTercero().equals("NaturalPerson")) ) {
                tipoTercero = 1;
            }else if  ( (bean.getTipoTercero() != null) &&
                    (bean.getTipoTercero().equals("LegalPerson")) ){
                tipoTercero=2;
            }

            //Establecer tipo tercero
            Thread.sleep(1000);
            tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
            tipoT.selectByValue(bean.getTipoTercero());
            m.waitSearchWicket(driver,". Estableciendo tercero");
            Thread.sleep(1000);

            //Boton buscar
            do{
                btnBuscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
                btnBuscar.click();
                m.waitSearchWicket(driver,". Buscando tercero");
                Thread.sleep(600);
            }while(driver.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table")).size()==0);




            if(driver.findElements(By.className("w_windowMessage")).size()>0){
                WebElement aceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_ConfirmExport_content_questionForm_confirmButton']"));

                //Pantallazo
                m.ScreenShotPool(driver, i,"screen3",nombreAutomatizacion,folderName);
                Thread.sleep(1000);

                aceptar.click();
                Thread.sleep(1500);
            }

            //Recorrer los terceros encontrados hasta encontrar uno habilitado(Si aplica)
            int nroFilas = driver.findElements(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr")).size();
            String lblStatus = "", lblCodigo;

            WebElement btnAceptar, btnInfTecnica;

            for (int k = 0; k < nroFilas; k++) {
                //lblStatus = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[4]/div/span")).getText();
                //lblCodigo = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[3]/div/span")).getText();
                optTercero = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[1]/div/div/div[2]/div[1]/div/div/div[4]/div[1]/div[1]/table/tbody/tr[" + (k + 1) + "]/td[1]/div/input"));
                optTercero.click();
                Thread.sleep(1000);

                jse.executeScript("window.scrollBy(0,600)", "");
                Thread.sleep(500);

                //Pantallazo
                m.ScreenShotPool(driver,i,"screen4",nombreAutomatizacion,folderName);
                Thread.sleep(1000);

                //Boton informacion tecnica
                btnInfTecnica = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']"));
                btnInfTecnica.click();
                m.waitSearchWicket(driver, "Consultando informacion tecnica");

                if (driver.findElements(By.className("w_windowMessage")).size()>0) {
                    Thread.sleep(500);
                    btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_errorMessage_content_questionForm_confirmButton']"));
                    btnAceptar.click();
                    m.waitSearchWicket(driver,"");
                }else{
                    System.out.println("Tercero seleccionado: ");
                    System.out.println("Nombre: " + (driver.findElement(By.xpath("//label[@wicketpath='ThirdInformationContent_descriptionThird']")).getText()));
                    System.out.println("Codigo Identificador: " + (driver.findElement(By.xpath("//label[@wicketpath='ThirdInformationContent_codIdentifierThird']")).getText()));

                    jse.executeScript("window.scrollBy(0,-6000)", "");
                    Thread.sleep(500);

                    m.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    jse.executeScript("window.scrollBy(0,600)", "");
                    Thread.sleep(500);

                    m.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    jse.executeScript("window.scrollBy(0,600)", "");
                    Thread.sleep(500);

                    m.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    Thread.sleep(1000);

                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void InformacionTecnica(WebDriver driver, Metodos m, int i, String folderName, int modo){
        try {

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            switch (modo) {

                case 1:
                    //Boton informacion tecnica
                    WebElement btnInfTecnica = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_technicalDataButton']"));
                    btnInfTecnica.click();
                    m.waitSearchWicket(driver, "Consultando informacion tecnica");

                    if (driver.findElements(By.className("w_windowMessage")).size() > 0) {
                        m.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                    } else {

                        jse.executeScript("window.scrollBy(0,-6000)", "");
                        Thread.sleep(500);

                        m.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                        jse.executeScript("window.scrollBy(0,600)", "");
                        Thread.sleep(500);

                        m.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion, folderName);
                        Thread.sleep(1000);

                        jse.executeScript("window.scrollBy(0,600)", "");
                        Thread.sleep(500);

                        m.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion, folderName);
                        Thread.sleep(1000);
                    }
                    break;
                case 2:
                    jse.executeScript("window.scrollBy(0,-6000)", "");
                    Thread.sleep(500);

                    m.ScreenShotPool(driver, i, "screen5", nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    jse.executeScript("window.scrollBy(0,600)", "");
                    Thread.sleep(500);

                    m.ScreenShotPool(driver, i, "screen6", nombreAutomatizacion, folderName);
                    Thread.sleep(1000);

                    jse.executeScript("window.scrollBy(0,600)", "");
                    Thread.sleep(500);

                    m.ScreenShotPool(driver, i, "screen7", nombreAutomatizacion, folderName);
                    Thread.sleep(1000);
                    break;
            }


        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
