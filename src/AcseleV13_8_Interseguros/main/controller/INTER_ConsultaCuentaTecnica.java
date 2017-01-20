
package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8.beans.CreacionSiniestrosBean;
import AcseleV13_8.main.controller.Metodos;
import AcseleV13_8_Interseguros.beans.INTER_ConsultaCuentaTecnicaBean;

import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by aazuaje on 07/12/2016.
 */

public class INTER_ConsultaCuentaTecnica {

    private final static Logger log = Logger.getLogger(INTER_ConsultaCuentaTecnica.class);
    public String nombreAutomatizacion ="Consulta Cuenta Tecnica";

    public void testLink (INTER_ConsultaCuentaTecnicaBean inter_creacionListaRestrictivaBean, int i, String folderName)  throws Exception {

            //Metodos a = new Metodos();
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones m = new Interseguros_MenuOperaciones();


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1500);
            System.out.println("prueba");

            m.CoaRea_CuentasTecnicas_ConsultaCuentaTecnica(driver, nombreAutomatizacion, 3, i);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            ConsultaCuentaTecnica(driver, a, inter_creacionListaRestrictivaBean, i, folderName);


    }

    public void ConsultaCuentaTecnica(WebDriver driver, Interseguros_Metodos a, INTER_ConsultaCuentaTecnicaBean inter_consultaCuentaTecnicaBean, int i, String folderName) throws IOException, InterruptedException{

        try {
            Thread.sleep(2000);

            if (inter_consultaCuentaTecnicaBean.getReasegurador() != null){
                Thread.sleep(1000);
                WebElement reasegurador = driver.findElement(By.xpath("//*[@id=\"reinsurerName\"]"));
                reasegurador.sendKeys(inter_consultaCuentaTecnicaBean.getReasegurador());
            }

            WebElement btnBuscar = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[1]/td[2]/input[3]"));
            btnBuscar.click();

            Thread.sleep(3000);
            /*
            Set<String> sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            Iterator<String> it = sid.iterator();
            String parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            String childId = it.next();
            //String childId2 = it.next();
            System.out.println("Prueba " + childId);
            System.out.println("Prueba " + childId);
            //swtiching control to child Window
            driver.switchTo().window(childId);
            */
            Thread.sleep(2000);

            WebElement btnBusqueda = driver.findElement(By.xpath("//*[@id=\"menuOperaciones\"]/center/table/tbody/tr[1]/td/table/tbody/tr/td/table/tbody/tr[2]/td[1]/input"));


            btnBusqueda.click();
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("//*[@id=\"buttonSetTirdParty\"]"));
            btnAceptar.click();
            Thread.sleep(1000);
            /*
            sid = driver.getWindowHandles();
            //Using iterator we can fetch the values from Set.
            it = sid.iterator();
            parentId = it.next();
            System.out.println("Prueba " + parentId);
            Thread.sleep(2000);
            childId = it.next();
            System.out.println("Prueba " + childId);
            childId2 = it.next();
            System.out.println("Prueba " + childId2);
            //swtiching control to child Window
            driver.switchTo().window(childId2);
              */
            Thread.sleep(3000);


            if (inter_consultaCuentaTecnicaBean.getCorredor() != null){
                Thread.sleep(1000);
                WebElement corredor = driver.findElement(By.xpath("//*[@id=\"brokerName\"]"));
                corredor.sendKeys(inter_consultaCuentaTecnicaBean.getCorredor());
                WebElement btnBuscarDos = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[2]/td[2]/input[3]"));
                btnBuscarDos.click();
            }


            if (inter_consultaCuentaTecnicaBean.getFechaDesde() != null){
                Thread.sleep(2000);
                WebElement fechaDesde = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[3]/td[2]/input[1]"));
                fechaDesde.sendKeys(inter_consultaCuentaTecnicaBean.getFechaDesde());
            }

            if (inter_consultaCuentaTecnicaBean.getFechaHasta() != null){
                Thread.sleep(2000);
                WebElement fechaHasta = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[3]/td[4]/input[1]"));
                fechaHasta.sendKeys(inter_consultaCuentaTecnicaBean.getFechaHasta());
            }

            if (inter_consultaCuentaTecnicaBean.getTipoContrato() != null){
                Thread.sleep(2000);
                Select tipoContrato = new Select(driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[4]/td[2]/select")));
                tipoContrato.selectByValue(inter_consultaCuentaTecnicaBean.getTipoContrato());
            }

            if (inter_consultaCuentaTecnicaBean.getMoneda() != null){
                Thread.sleep(2000);
                Select moneda = new Select(driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[5]/td[2]/select")));
                moneda.selectByValue(inter_consultaCuentaTecnicaBean.getMoneda());
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver,i, "screen4",nombreAutomatizacion, folderName);

            WebElement btnConsultar = driver.findElement(By.xpath("/html/body/form/center/table/tbody/tr[6]/td/center/input"));
            btnConsultar.click();

            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
//                log.info(e);
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }


}





