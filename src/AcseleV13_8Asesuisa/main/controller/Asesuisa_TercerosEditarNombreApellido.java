package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosEditarNombreApellidoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import sun.awt.windows.ThemeReader;

import java.awt.*;
import java.io.IOException;
/**
 * Created by kcolina on 01/03/2017.
 */
public class Asesuisa_TercerosEditarNombreApellido extends Asesuisa_BuscarTerceros {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosEditarNombreApellido.class);

    public String nombreAutomatizacion = "Edicion de nombre y apellido de terceros";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosEditarNombreApellidoBean asesuisaTercerosEditarNombreApellidoBean, int i, String folderName)throws Exception{

        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento menu = new Asesuisa_MenuMantenimiento();
            Asesuisa_BuscarTerceros buscarTerceros = new Asesuisa_BuscarTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            menu.MantTerc_BuscarTercero(driver,nombreAutomatizacion, 2,i,folderName);
            Thread.sleep(1500);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Buscamos al tercero a ser editado
            buscarTerceros.BusquedaT(driver, m, asesuisaTercerosEditarNombreApellidoBean,nombreAutomatizacion,i,folderName,
                    3,4,5,6);

            Thread.sleep(600);

            //Lamada al metodo editar tercero
            EditarT(driver, asesuisaTercerosEditarNombreApellidoBean, i,folderName,7,8,9);
            Thread.sleep(1000);

            //Salimos
            driver.quit();
        }catch (Exception e){

        }
    }

    public void EditarT(WebDriver driver, Asesuisa_TercerosEditarNombreApellidoBean asesuisaTercerosEditarNombreApellidoBean,
                        int i, String folderName, int numscreen, int numScreen2, int numScreen3){

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            //Boton editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();


        }catch (Exception e){

        }

    }
}
