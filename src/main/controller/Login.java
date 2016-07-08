package main.controller;


import org.openqa.selenium.WebDriver;

/**
 * Created by agil on 01/06/2016.
 */
public class Login {

    public void LoginA(WebDriver driver) throws Exception {

        Metodos2 m = new Metodos2();
        m.entrarPagina(driver);
        String nombreAutomatizacion = "Consulta Poliza Avanzada";
        m.IniciarSesion(driver, nombreAutomatizacion); //iniciando sesion.
        m.ValidandoSesion(driver, nombreAutomatizacion); //validando sesion.
        Thread.sleep(3000);
    }
}
