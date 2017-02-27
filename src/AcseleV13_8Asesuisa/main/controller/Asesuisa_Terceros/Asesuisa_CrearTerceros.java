package AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

/**
 * Created by kcolina on 24/02/2017.
 */
public class Asesuisa_CrearTerceros {

    private final static Logger log = Logger.getLogger(Asesuisa_CrearTerceros.class);


    public void CrearTerceroNatural(WebDriver driver, Metodos m, Asesuisa_TercerosBean asesuisaTercerosBean, String nombreAutomatizacion, 
                                    String folderName, int i, int screen1, int screen2, int screen3, int screen4){
        
        try {
            Thread.sleep(1000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            WebElement etiqueta;

            //Tipo tercero
            if (asesuisaTercerosBean.getTipoTercero() != null) {
                Thread.sleep(1000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(asesuisaTercerosBean.getTipoTercero());
                Thread.sleep(2000);
            }

            //AseguradoAP
            if (asesuisaTercerosBean.getAseguradoAp() != null){
                Select aseguradoAp = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_field']")));
                aseguradoAp.selectByValue(asesuisaTercerosBean.getAseguradoAp());
                Thread.sleep(1000);
            }

            //Primer Nombre
            if(asesuisaTercerosBean.getPrimerNombre() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement primerNombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                primerNombre.clear();
                Thread.sleep(600);
                primerNombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                primerNombre.click();
                Thread.sleep(600);
                primerNombre.sendKeys(asesuisaTercerosBean.getPrimerNombre());
                Thread.sleep(1000);
            }

            //Segundo nombre
            if(asesuisaTercerosBean.getSegundoNombre() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement segundoNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                segundoNombre.clear();
                Thread.sleep(600);
                segundoNombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_2_fila_field']"));
                segundoNombre.click();
                Thread.sleep(600);
                segundoNombre.sendKeys(asesuisaTercerosBean.getSegundoNombre());
                Thread.sleep(1000);
            }

            //Primer apellido
            if(asesuisaTercerosBean.getPrimerApellido() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement primerApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                primerApellido.clear();
                Thread.sleep(600);
                primerApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_2_fila_field']"));
                primerApellido.click();
                Thread.sleep(600);
                primerApellido.sendKeys(asesuisaTercerosBean.getPrimerApellido());
                Thread.sleep(1000);
            }

            //Segundo apellido
            if(asesuisaTercerosBean.getSegundoApellido() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement segundoApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                segundoApellido.clear();
                Thread.sleep(600);
                segundoApellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_3_fila_field']"));
                segundoApellido.click();
                Thread.sleep(600);
                segundoApellido.sendKeys(asesuisaTercerosBean.getSegundoApellido());
                Thread.sleep(1000);
            }

            //Nacionalidad
            if(asesuisaTercerosBean.getNacionalidad() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_3_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select nacionalidad = new Select (driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_3_fila_repeaterSelect_1_field']")));
                //nacionalidad.clear();
                Thread.sleep(400);
                nacionalidad.selectByValue(asesuisaTercerosBean.getNacionalidad());
                Thread.sleep(1000);
            }

            //Pais de origen
            if(asesuisaTercerosBean.getPaisOrigen() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select paisOrigen = new Select (driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_4_fila_repeaterSelect_1_field']")));
                //nacionalidad.clear();
                Thread.sleep(400);
                paisOrigen.selectByValue(asesuisaTercerosBean.getPaisOrigen());
                Thread.sleep(1000);
            }

            //Edad persona natural
            if(asesuisaTercerosBean.getEdadPersonaNatural() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement edadPnatural = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                edadPnatural.clear();
                Thread.sleep(600);
                edadPnatural = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_5_fila_field']"));
                edadPnatural.click();
                Thread.sleep(600);
                edadPnatural.sendKeys(asesuisaTercerosBean.getEdadPersonaNatural());
                Thread.sleep(1000);
            }

            //Fecha nacimiento
            if(asesuisaTercerosBean.getFechaNacimiento() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_fieldDate']"));
                fechaNacimiento.clear();
                Thread.sleep(600);
                fechaNacimiento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_4_fila_fieldDate']"));
                fechaNacimiento.click();
                Thread.sleep(600);
                fechaNacimiento.sendKeys(asesuisaTercerosBean.getFechaNacimiento());
                Thread.sleep(1000);
            }

            //Numero DUI
            if(asesuisaTercerosBean.getNumeroDUI() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_6_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement numeroDui = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_6_fila_field']"));
                numeroDui.clear();
                Thread.sleep(600);
                numeroDui = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_6_fila_field']"));
                numeroDui.click();
                Thread.sleep(600);
                numeroDui.sendKeys(asesuisaTercerosBean.getNumeroDUI());
                Thread.sleep(1000);
            }

            //Numero NIT
            if(asesuisaTercerosBean.getNumeroNIT() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_5_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement numeroNit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_5_fila_field']"));
                numeroNit.clear();
                Thread.sleep(600);
                numeroNit = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_5_fila_field']"));
                numeroNit.click();
                Thread.sleep(600);
                numeroNit.sendKeys(asesuisaTercerosBean.getNumeroNIT());
                Thread.sleep(1000);
            }

            //Numero documento
            if(asesuisaTercerosBean.getNumeroDocumento() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement numeroDocumento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                numeroDocumento.clear();
                Thread.sleep(600);
                numeroDocumento = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                numeroDocumento.click();
                Thread.sleep(600);
                numeroDocumento.sendKeys(asesuisaTercerosBean.getNumeroDocumento());
                Thread.sleep(1000);
            }

            //Tipo documento de identificacion
            if(asesuisaTercerosBean.getTipoDocumentoIdentificacion() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_6_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select tipoDocumento = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_6_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                tipoDocumento.selectByValue(asesuisaTercerosBean.getTipoDocumentoIdentificacion());
                Thread.sleep(1000);
            }

            //Numero NUP
            if(asesuisaTercerosBean.getNumeroNUP() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement numeroNUP = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_field']"));
                numeroNUP.clear();
                Thread.sleep(600);
                numeroNUP = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_7_fila_field']"));
                numeroNUP.click();
                Thread.sleep(600);
                numeroNUP.sendKeys(asesuisaTercerosBean.getNumeroNUP());
                Thread.sleep(1000);
            }

            //Correo principal
            if(asesuisaTercerosBean.getCorreoElectronicoPrincipal() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement correoP = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                correoP.clear();
                Thread.sleep(600);
                correoP = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                correoP.click();
                Thread.sleep(600);
                correoP.sendKeys(asesuisaTercerosBean.getCorreoElectronicoPrincipal());
                Thread.sleep(1000);
            }

            //Correo opcional
            if(asesuisaTercerosBean.getCorreoElectronicoOpcional() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_8_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement correoO = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_8_fila_field']"));
                correoO.clear();
                Thread.sleep(600);
                correoO = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_8_fila_field']"));
                correoO.click();
                Thread.sleep(600);
                correoO.sendKeys(asesuisaTercerosBean.getCorreoElectronicoOpcional());
                Thread.sleep(1000);
            }

            //Usuario
            if(asesuisaTercerosBean.getUsuario() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_9_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement usuario = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_9_fila_field']"));
                usuario.clear();
                Thread.sleep(600);
                usuario = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_9_fila_field']"));
                usuario.click();
                Thread.sleep(600);
                usuario.sendKeys(asesuisaTercerosBean.getUsuario());
                Thread.sleep(1000);
            }

            //Facebook
            if(asesuisaTercerosBean.getIdFacebook() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_9_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement facebook = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_9_fila_field']"));
                facebook.clear();
                Thread.sleep(600);
                facebook = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_9_fila_field']"));
                facebook.click();
                Thread.sleep(600);
                facebook.sendKeys(asesuisaTercerosBean.getIdFacebook());
                Thread.sleep(1000);
            }

            //linkedin
            if(asesuisaTercerosBean.getIdLinkedin() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_10_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement linkedin = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_10_fila_field']"));
                linkedin.clear();
                Thread.sleep(600);
                linkedin = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_10_fila_field']"));
                linkedin.click();
                Thread.sleep(600);
                linkedin.sendKeys(asesuisaTercerosBean.getIdLinkedin());
                Thread.sleep(1000);
            }

            //Twitter
            if(asesuisaTercerosBean.getIdTwitter() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_10_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement twitter = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_10_fila_field']"));
                twitter.clear();
                Thread.sleep(600);
                twitter = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_10_fila_field']"));
                twitter.click();
                Thread.sleep(600);
                twitter.sendKeys(asesuisaTercerosBean.getIdTwitter());
                Thread.sleep(1000);
            }

            //estado civil
            if(asesuisaTercerosBean.getEstadoCivil() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_11_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select estadoCivil = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_11_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                estadoCivil.selectByValue(asesuisaTercerosBean.getEstadoCivil());
                Thread.sleep(1000);
            }

            //Nivel de estudios
            if(asesuisaTercerosBean.getNivelEstudio() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_12_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select nivelEstudio = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_12_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                nivelEstudio.selectByValue(asesuisaTercerosBean.getNivelEstudio());
                Thread.sleep(1000);
            }

            //genero
            if(asesuisaTercerosBean.getGenero() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_11_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select genero = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_11_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                genero.selectByValue(asesuisaTercerosBean.getGenero());
                Thread.sleep(1000);
            }

            //Numero de hijos
            if(asesuisaTercerosBean.getNumeroHijos() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_12_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select numeroHijos = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_12_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                numeroHijos.selectByValue(asesuisaTercerosBean.getNumeroHijos());
                Thread.sleep(1000);
            }

            //Ocupacion
            if(asesuisaTercerosBean.getOcupacion() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_13_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select ocupacion = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_13_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                ocupacion.selectByValue(asesuisaTercerosBean.getOcupacion());
                Thread.sleep(1000);
            }

            //telefono domicilio
            if(asesuisaTercerosBean.getTlfDomicilio() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_13_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement tlfDomicilio = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_13_fila_field']"));
                tlfDomicilio.clear();
                Thread.sleep(600);
                tlfDomicilio = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_13_fila_field']"));
                tlfDomicilio.click();
                Thread.sleep(600);
                tlfDomicilio.sendKeys(asesuisaTercerosBean.getTlfDomicilio());
                Thread.sleep(1000);
            }

            //Numero registro contribuyente
            if(asesuisaTercerosBean.getNumeroRegistroContribuyente() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_14_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement nroContribuyente = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_14_fila_field']"));
                nroContribuyente.clear();
                Thread.sleep(600);
                nroContribuyente = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_14_fila_field']"));
                nroContribuyente.click();
                Thread.sleep(600);
                nroContribuyente.sendKeys(asesuisaTercerosBean.getNumeroRegistroContribuyente());
                Thread.sleep(1000);
            }

            //celular
            if(asesuisaTercerosBean.getNumeroCelular() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_14_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement celular = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_14_fila_field']"));
                celular.clear();
                Thread.sleep(600);
                celular = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_14_fila_field']"));
                celular.click();
                Thread.sleep(600);
                celular.sendKeys(asesuisaTercerosBean.getNumeroCelular());
                Thread.sleep(1000);
            }

            //Categoria contribuyente
            if(asesuisaTercerosBean.getCategoriaContribuyente() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_15_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select categoriaContribuyente = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_15_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                categoriaContribuyente.selectByValue(asesuisaTercerosBean.getCategoriaContribuyente());
                Thread.sleep(1000);
            }

            //Nivel salarial
            if(asesuisaTercerosBean.getNivelSalarial() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_16_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select nivelSalarial = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_16_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                nivelSalarial.selectByValue(asesuisaTercerosBean.getNivelSalarial());
                Thread.sleep(1000);
            }

            //Categoria de empresa
            if(asesuisaTercerosBean.getCategoriaEmpresa() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_17_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select categoriaEmpresa = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_17_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                categoriaEmpresa.selectByValue(asesuisaTercerosBean.getCategoriaEmpresa());
                Thread.sleep(1000);
            }

            //Giro o actividad economica
            if(asesuisaTercerosBean.getActividadEconomica() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_15_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select actividadEconomica = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_15_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                actividadEconomica.selectByValue(asesuisaTercerosBean.getActividadEconomica());
                Thread.sleep(1000);
            }

            //Tipo empresa
            if(asesuisaTercerosBean.getTipoEmpresa() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_16_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select tipoEmpresa = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_16_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                tipoEmpresa.selectByValue(asesuisaTercerosBean.getTipoEmpresa());
                Thread.sleep(1000);
            }

            //Exento IVA
            if(asesuisaTercerosBean.getExentoIVA() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_17_fila_repeaterSelect_1_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                Select exentoIva = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_17_fila_repeaterSelect_1_field']")));
                Thread.sleep(400);
                exentoIva.selectByValue(asesuisaTercerosBean.getExentoIVA());
                Thread.sleep(1000);
            }

            //Codigo identificador
            if(asesuisaTercerosBean.getCodigoIdentificador() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_18_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_18_fila_field']"));
                codigoIdentificador.clear();
                Thread.sleep(600);
                codigoIdentificador = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel2_18_fila_field']"));
                codigoIdentificador.click();
                Thread.sleep(600);
                codigoIdentificador.sendKeys(asesuisaTercerosBean.getCodigoIdentificador());
                Thread.sleep(1000);
            }

            //Login
            if(asesuisaTercerosBean.getLogin() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_18_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement login = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_18_fila_field']"));
                login.clear();
                Thread.sleep(600);
                login = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_18_fila_field']"));
                login.click();
                Thread.sleep(600);
                login.sendKeys(asesuisaTercerosBean.getLogin());
                Thread.sleep(1000);
            }

            //Numero documento de identificacion
            if(asesuisaTercerosBean.getNumeroDocumentoIdentificacion() != null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_etiqueta']"));
                etiqueta.click();
                Thread.sleep(1000);
                WebElement documentoIdentificacion = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                documentoIdentificacion.clear();
                Thread.sleep(600);
                documentoIdentificacion = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_19_fila_field']"));
                documentoIdentificacion.click();
                Thread.sleep(600);
                documentoIdentificacion.sendKeys(asesuisaTercerosBean.getNumeroDocumentoIdentificacion());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(2000);
            m.ScreenShotPool(driver, i, "screen" + screen1, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            m.ScreenShotPool(driver, i, "screen" + screen2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            m.ScreenShotPool(driver, i, "screen" + screen3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();


            //Boton guardar
            Thread.sleep(1000);
            WebElement btnGuardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_saveButton']"));
            Thread.sleep(1000);
            btnGuardar.click();

        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void ValidarCreacionTercero(WebDriver driver, String nombreAutomatizacion){

        Boolean aseguradoAP = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel1_1_fila_repeaterSelect_1_feedbackLabel']")).isDisplayed();
        Boolean fechaNac = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformation_templateContainer_formThirdBasic_DataTemplate_repeaterPanel2_4_fila_feedbackLabel']")).isDisplayed();

        if (aseguradoAP && fechaNac ){
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: Los campos marcados con * son obligatorios");
        }else if (aseguradoAP){
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: Debe seleciconar una opcion");
        }else if (fechaNac){
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba Fallida: La fecha de nacimiento es obligatoria");
        }else{
            log.error("Test Case - " + nombreAutomatizacion + " - " + "Prueba exitosa");
        }

    }
}
