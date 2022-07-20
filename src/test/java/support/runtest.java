package support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "E:\\QA\\proyectoweb\\src\\test\\resources\\features",
glue = "definitions",
tags = "@regresion",
plugin = {"html:E:\\QA\\proyectoweb\\target\\cucumber-report\\index.html","json:E:\\QA\\proyectoweb\\target\\cucumber-report\\cucumber.json"})
public class runtest {
}
