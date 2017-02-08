package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_ValidarOpenItemBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuConsultas;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by kcolina on 26/01/2017.
 */
public class INTER_ValidarOpenItem {

    public final static Logger Log = Logger.getLogger(INTER_ValidarOpenItem.class);
    public String nombreAutomatizacion = "Validacion de codigo Open Item";
    private WebDriver driver;

    public void testLink(INTER_ValidarOpenItemBean inter_validarOpenItemBean, int i, String folderName){

        try{

            //Instanciando las clases a utilizar
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones menuOperaciones = new Interseguros_MenuOperaciones();
            Interseguros_MenuConsultas menuConsultas = new Interseguros_MenuConsultas();
            /*Inter_PrePoliza interPrePoliza = new Inter_PrePoliza();
            Inter_InformacionGeneralPoliza interInformacionGeneralPoliza = new Inter_InformacionGeneralPoliza();
            Inter_Contratante interContratante = new Inter_Contratante();
            Inter_UnidadesRiesgo interUnidadesRiesgo = new Inter_UnidadesRiesgo();
            Inter_ObjetosAsegurados interObjetosAsegurados = new Inter_ObjetosAsegurados();
            Inter_Asegurado interAsegurado = new Inter_Asegurado();
            Inter_Beneficiario interBeneficiario = new Inter_Beneficiario();
            Inter_Calcular interCalcular = new Inter_Calcular();
            Inter_Validar interValidar = new Inter_Validar();*/

            //Inicia y valida la sesion
            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(2000);

            //Entrando a opcion: operacion->operacionesPoliza->crear
            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(100);
            a.cambiarVentana(driver);
            Thread.sleep(1000);

            CrearPoliza(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName);

        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test case - " + nombreAutomatizacion + " - " + e);
            if (driver!=null){
                driver.quit();
            }
        }
    }

    //En este metodo se crean los objetos de creacion de poliza
    public void CrearPoliza(Interseguros_Metodos a, WebDriver driver, INTER_ValidarOpenItemBean inter_validarOpenItemBean, String nombreAutomatizacion, int i, String folderName){

        try{

            //Instanciando las clases de creacion de poliza
            Inter_PrePoliza interPrePoliza = new Inter_PrePoliza();
            Inter_InformacionGeneralPoliza interInformacionGeneralPoliza = new Inter_InformacionGeneralPoliza();
            Inter_Contratante interContratante = new Inter_Contratante();
            Inter_UnidadesRiesgo interUnidadesRiesgo = new Inter_UnidadesRiesgo();
            Inter_ObjetosAsegurados interObjetosAsegurados = new Inter_ObjetosAsegurados();
            Inter_Asegurado interAsegurado = new Inter_Asegurado();
            //Inter_Beneficiario interBeneficiario = new Inter_Beneficiario();
            Inter_Calcular interCalcular = new Inter_Calcular();
            Inter_Validar interValidar = new Inter_Validar();

            //Creacion de la poliza
            interPrePoliza.AdministracionPropuestaPoliza(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);

            interPrePoliza.EvAplicar(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 4);

            if (inter_validarOpenItemBean.getProducto().equals("DotalSimple")){

                //Llenar campos de informacion general
                interInformacionGeneralPoliza.InformacionGeneralDotalSimple(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 5, 6, 7);
                Thread.sleep(2000);

                //Agregar contratante
                interContratante.AgregarContratante(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 8, 9);
                Thread.sleep(2000);

                //Unidades de riesgo
                interUnidadesRiesgo.UnidadesRiesgo1DotalSimple(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 10);
                Thread.sleep(2000);

                //Objetos asegurados
                interObjetosAsegurados.ObjetoAsegurado1_DotalSimple(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 11, 12, 13);
                Thread.sleep(2000);

                //Agregar asegurado
                interAsegurado.AgregarAsegurado1_DotalSimple(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, 14);
                Thread.sleep(2000);

                //Boton calcular
                interCalcular.Calcular(a, driver, inter_validarOpenItemBean, nombreAutomatizacion, i, folderName, -5000, 15, 16);
                Thread.sleep(2000);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
