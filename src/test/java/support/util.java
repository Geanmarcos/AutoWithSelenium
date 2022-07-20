package support;

import definitions.hooks;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

public class util extends hooks {
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public static Alert dialogo;

    public util() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        js = (JavascriptExecutor) driver;

    }

    public void ventanaActiva(){
        Set<String> identificadores = driver.getWindowHandles();
        for(String identificador:identificadores){
            driver.switchTo().window(identificador);
        }
    }

    public void ventanaInicial(){
        driver.close();
        driver.switchTo().window("");
    }

    public void scrollVertical(){
        js.executeScript("window.scrollBy(0,1000)");
    }

    public void aceptarDialogo(){
        dialogo = driver.switchTo().alert();
        dialogo.accept();

    }

    public void obtenerTextoDialogo(String mensaje){
        dialogo = driver.switchTo().alert();
        Assert.assertEquals(mensaje, dialogo.getText());
    }

    public static void evidencias() throws IOException {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy_HHmmssSSS");
        String path = "E:\\QA\\proyectoweb\\target\\evidencias\\";
        String nombre = formato.format(fecha)+"_evidencia.jpg";

        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File(path+nombre));
    }
}
