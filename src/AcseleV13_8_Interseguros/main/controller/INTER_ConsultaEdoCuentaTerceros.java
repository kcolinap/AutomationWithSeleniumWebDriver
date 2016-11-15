package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_ConsultaEdoCuentaTercerosBean;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

/**
 * Created by aazuaje on 15/11/2016.
 */
public class INTER_ConsultaEdoCuentaTerceros {

    public String nombreAutomatizacion ="Estado de Cuentas";
    //Pliza a buscar
    //String nPoliza = "EA00222";
    //String fechaEm = "17-12-2015";


    public void testLink(INTER_ConsultaEdoCuentaTercerosBean inter_consultaEdoCuentaTercerosBean, int i)throws Exception {

        Interseguros_Metodos a= new Interseguros_Metodos();   //implementando metodos.
        WebDriver driver = a.entrarPagina();
        a.IniciarSesion(driver, nombreAutomatizacion, i); //iniciando sesion.
        a.ValidandoSesion(driver, nombreAutomatizacion, i); //validando sesion.
        Thread.sleep(3000);

        //Entrando en Menu
        WebElement menu1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]"));// Consultas
        WebElement menu2 = driver.findElement(By.xpath("/html/body/div[2]/div[2]"));// Estado de Cuentas
        menu1.click();
        a.ScreenShot(driver, "screen2", nombreAutomatizacion); //screenshot2
        menu2.click();
        a.cambiarVentana(driver); // Cambiar de ventana

        INTER_ConsultaEdoCuentaTerceros(a, driver, inter_consultaEdoCuentaTercerosBean);
    }

    public void INTER_ConsultaEdoCuentaTerceros(Interseguros_Metodos a, WebDriver driver, INTER_ConsultaEdoCuentaTercerosBean inter_consultaEdoCuentaTercerosBean) throws InterruptedException, IOException {

        Thread.sleep(3000);

        //Screenshot
        a.ScreenShot(driver, "screen3", nombreAutomatizacion);

        // Select del Tipo de Tercero
        //Select tipoTercero = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
        Select tipoTercero = new Select(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td/form/table/tbody/tr[1]/td[2]/select")));
        tipoTercero.selectByValue(inter_consultaEdoCuentaTercerosBean.getTipoTercero());
        Thread.sleep(12000);

        // Num Documento Identificacion
//        WebElement numDocIdent = driver.findElement(By.name("DocumentoIdentidad"));
        WebElement numDocIdent = driver.findElement(By.name("//*[@id=\"1932174\"]/td[3]/input[1]"));
        numDocIdent.sendKeys(inter_consultaEdoCuentaTercerosBean.getNumDocIdent());

        // Primer Apellido
//        WebElement priApellido = driver.findElement(By.name("Apellido"));
        WebElement priApellido = driver.findElement(By.name("//*[@id=\"1931454\"]/td[3]/input[1]"));
        priApellido.sendKeys(inter_consultaEdoCuentaTercerosBean.getApellido());
        //Screenshot
        a.ScreenShot(driver, "screen4", nombreAutomatizacion);
        Thread.sleep(1000);

        // Primer Nombre
//        WebElement priNombre = driver.findElement(By.name("Nombre"));
        WebElement priNombre = driver.findElement(By.name("//*[@id=\"3541054\"]/td[3]/input[1]"));
        priNombre.sendKeys(inter_consultaEdoCuentaTercerosBean.getNombre());



        // Boton Buscar
//        driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"idb_0402036_ThirdPartySearchForStatementAccount_01\"]")).click();
        Thread.sleep(7000);

        /***/
        // Seleccionar el Tercero Buscado
//        driver.findElement(By.name("ThirdPartyID")).click();
        driver.findElement(By.name("/html/body/table[2]/tbody/tr/td/table/tbody/tr[1]/td[1]/input[1]")).click();
        //Screenshot
        a.ScreenShot(driver, "screen5", nombreAutomatizacion);
        Thread.sleep(1000);
        // Boton Aceptar
//        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();
        driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr[2]/td/input")).click();
        Thread.sleep(5000);

        /***/
        //Borrar Fecha inicial y final
//        driver.findElement(By.name("startdateShow")).clear();
        driver.findElement(By.name("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[5]/td[2]/input[1]")).clear();
//        driver.findElement(By.name("enddateShow")).clear();
        driver.findElement(By.name("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[6]/td[2]/input[1]")).clear();

        // Moneda
//        Select moneda = new Select(driver.findElement(By.name("currencyID")));
        Select moneda = new Select(driver.findElement(By.name("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[7]/td[2]/select")));
        moneda.selectByValue(inter_consultaEdoCuentaTercerosBean.getMoneda());

        // Producto
//        Select producto = new Select(driver.findElement(By.name("productID")));
        /*Select producto = new Select(driver.findElement(By.name("/html/body/center[1]/table/tbody/tr[3]/td/table[1]/tbody/tr[8]/td[2]/select")));
        producto.selectByValue(inter_consultaEdoCuentaTercerosBean.getProducto());*/

        /*// Num Poliza
//        WebElement numeroPolza = driver.findElement(By.name("policyId"));
        WebElement numeroPolza = driver.findElement(By.name("//input[@wicketpath='WicketpathElemento']"));
        //numeroPolza.sendKeys(inter_consultaEdoCuentaTercerosBean.getNumPoliza());*/

        //Screenshot
        a.ScreenShot(driver, "screen6", nombreAutomatizacion);
        Thread.sleep(1000);

        // Boton Enviar
//        driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"idb_0402037_SearchConf_01\"]")).click();
        Thread.sleep(5000);


        //Screenshot
        a.ScreenShot(driver, "screen7", nombreAutomatizacion);

        System.out.println("Fin del Test");

    }
}
