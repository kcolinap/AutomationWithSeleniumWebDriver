package AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros;

import AcseleV13_8Asesuisa.beans.ASESUISA_TercerosBean;
import metodo.Metodos;

import org.apache.log4j.Logger;
import org.apache.xpath.operations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.String;

/**
 * Created by kcolina on 21/02/2017.
 */
public class ASESUISA_BuscarTerceros {

    private final static Logger log = Logger.getLogger(ASESUISA_BuscarTerceros.class);

    public void BusquedaT(WebDriver driver, Metodos a, ASESUISA_TercerosBean asesuisaTercerosBean, String nombreAutomatizacion,
                          int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3,
                          int numScreenShoot4){

        try{

            Thread.sleep(3000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            //Tipo tercero
            if (asesuisaTercerosBean.getTipoTercero() != null) {
                Thread.sleep(3000);
                Select tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoT.selectByValue(asesuisaTercerosBean.getTipoTercero());
                Thread.sleep(500);
            }
        }catch (Exception e){

        }
    }
}
