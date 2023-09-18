package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        //Seta a inicialização do ChromeDriver, necessário instalar e apontar o caminho
        System.setProperty("webdriver.chrome.driver","Caminho + \\chromedriver.exe");
        var driverOptions = new ChromeOptions();
        driverOptions.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(driverOptions);
        driver.get("https://google.com");

        //Cria um novo arquivo texto e prepara ele para ser escrito, necessáriuo apontar o caminho
        java.io.File diretorio = new java.io.File("Caminho + \\courses.txt");
        FileWriter fileWriter = new FileWriter(diretorio, false);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        //Pega o elemento de pesquisa e envia os dados para pesquisar
        WebElement search = driver.findElement(By.id("APjFqb"));
        search.sendKeys("cursos java");
        search.submit();

        //cria uma lista de elementos, pega o texto do html e insere no txt
        List<WebElement> courses = driver.findElements(By.className("v5yQqb"));
        for (int i = 0; i <= courses.size(); i++){
            var nameCourse = courses.get(i).getAttribute("innerText");
            printWriter.println(nameCourse);
            printWriter.flush();
        }

        printWriter.close();
    }
}