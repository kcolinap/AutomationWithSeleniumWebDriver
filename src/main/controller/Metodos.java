package main.controller;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by agil on 26/05/2016.
 */
public class Metodos {



    protected ThreadLocal<WebDriver> threadDriver = null;

//    public void setUp() throws IOException, InterruptedException {
//
//      /*FirefoxProfile profile = new FirefoxProfile();
//        profile.setAlwaysLoadNoFocusLib(true);
//        profile.setEnableNativeEvents(true);
//        threadDriver = new ThreadLocal<WebDriver>();
//        threadDriver.set(new FirefoxDriver(profile));*/
//        File path = new File("C:\\gvbi3dap.default");//Buscar esta carpeta de %APPDATA%\Mozilla\Firefox\Profile\xxxx.default
//        FirefoxProfile ffp =  new FirefoxProfile(path);
//        ffp.setAlwaysLoadNoFocusLib(true);
//        ffp.setEnableNativeEvents(true);
//        threadDriver = new ThreadLocal<WebDriver>();
//        threadDriver.set(new FirefoxDriver(ffp));
//    } //Configura el driver con un perfil de firefox

    public WebDriver entrarPagina(){
        System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa19:7001/WController/");
//        WebDriver driver = new FirefoxDriver();
//        driver.get("http://qa19:7001/WController"); // lineas para usar el driver de firefox
        driver.manage().window().maximize();
        return driver;
    }

    public void ScreenShot(WebDriver getDriver, String titulo, String nombrePrueba) throws InterruptedException, IOException {
        String rutaScreen = "C:\\ScrenShots\\";
        String rutaPrueba = nombrePrueba;
        TakesScreenshot ts = (TakesScreenshot)getDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(rutaScreen + nombrePrueba + "\\" + titulo + ".png"));
        System.out.println("tomando screenshot "+titulo);
    }

    public void ScreenShotPool(WebDriver getDriver, int i, String titulo, String nombrePrueba) throws InterruptedException, IOException {
        String rutaScreen = "C:\\ScrenShots\\";
        TakesScreenshot ts = (TakesScreenshot)getDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(rutaScreen + nombrePrueba + "\\" + i + "\\" + titulo + ".png"));
        System.out.println("tomando screenshot "+titulo);
    }

    public void ValidandoSesion(WebDriver getDriver, String nombrePrueba) throws InterruptedException, IOException {

        System.out.println("Verificando si ya estaba logeado el usuario");
        if (getDriver.getTitle().equals("Acsel-e Workflow")){
            System.out.println("No estaba logeado");
        }
        else if (getDriver.findElement(By.className("CeldaEncabezado")).isDisplayed() &&
                (getDriver.findElement(By.className("CeldaEncabezado")).getText()).equals("Advertencia!")){
            System.out.println("Ya estaba logeado");
            System.out.println("Cerrando la otra sesion");
            //Screenshot
            ScreenShot(getDriver, "screen1-1", nombrePrueba);

            WebElement acep = getDriver.findElement(By.name("SecuritySubmit"));
            acep.click();
            WebElement menuUsuario = getDriver.findElement(By.xpath("/html/body/div[3]/div[5]"));
            WebElement menuSalir = getDriver.findElement(By.xpath("/html/body/div[51]/div[3]"));
            menuUsuario.click();
            menuSalir.click();
            IniciarSesion(getDriver, nombrePrueba);
        }
        System.out.println("Ahora esta logeado");
        Thread.sleep(5000);
    }

    public void IniciarSesion(WebDriver getDriver, String nombrePrueba) throws IOException, InterruptedException {
        WebElement user2 = getDriver.findElement(By.name("SecurityLogin"));
        WebElement password2= getDriver.findElement(By.name("SecurityPassword"));
        WebElement instance2= getDriver.findElement(By.name("USER_PREFERENCE_COUNTRY_NAME"));
        Select language2 = new Select(getDriver.findElement(By.name("PARAMETER_LOCALE_NAME")));
        WebElement button_sumit2 = getDriver.findElement(By.name("SecuritySubmit"));
        System.out.println("mandando user");
        user2.sendKeys("system");
        password2.sendKeys("consis");
        instance2.sendKeys("ALFA");
        language2.selectByValue("es");
        //Screenshot
        ScreenShot(getDriver, "screen1", nombrePrueba);
        /*TakesScreenshot ts = (TakesScreenshot)getDriver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String rutaScreen = "C:\\ScrenShots\\";//"./Screenshot/";
        FileUtils.copyFile(source, new File(rutaScreen + "screen1.png"));
        System.out.println("Screenshot1");*/
        button_sumit2.click();
    }

    public void cambiarVentana(WebDriver getDriver) throws InterruptedException, IOException{
        // Cambiar de ventana
        //getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
        Set<String> sid = getDriver.getWindowHandles();
        //Using iterator we can fetch the values from Set.
        Iterator<String> it = sid.iterator();
        String parentId = it.next();
        System.out.println(parentId);
        Thread.sleep(2000);
        String childId = it.next();
        System.out.println(childId);
        //swtiching control to child Window
        getDriver.switchTo().window(childId);
    }

    public void regresarVentana(WebDriver getDriver) throws InterruptedException, IOException{
        // Cambiar de ventana
        //getWindowHandles() method returns the ids of all active Windows and its return type will be a Collection Set.
        Set<String> sid = getDriver.getWindowHandles();
        //Using iterator we can fetch the values from Set.
        Iterator<String> it = sid.iterator();
        String parentId = it.next();
        System.out.println(parentId);
        Thread.sleep(2000);
//        String childId = it.next();
//        System.out.println(childId);
        //swtiching control to child Window
        getDriver.switchTo().window(parentId);
    }

    public void cambioPantalla(WebDriver driver){
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.get(driver.getCurrentUrl());
    }

    public WebDriver getDriver() {
        return threadDriver.get();
    }
}
