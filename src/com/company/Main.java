package com.company;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.company.Const.SiteURL;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NT\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String username = null;
        String phonenumber = null;
        String urlTwo = null;

        CreateFile createFile = new CreateFile();
        createFile.createFile();
        int t=1;
        for (int i = 0; i < 3; i++) {
            driver.get(SiteURL);
            System.out.println(i);


            try {

                // driver.findElement(By.className("ls-photo_anUrl")).click();
                driver.findElement(By.xpath("/html/body/div[4]/div/section/div/div[2]/ul/li[1]/div[2]/a")).click();
                String curUrl = driver.getCurrentUrl();

                // String oldTab=curUrl;
                ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
                newTab.remove(curUrl);

                // change focus to new tab

                driver.switchTo().window(newTab.get(0));
                driver.close(); // todelete1
                driver.switchTo().window(newTab.get(1)); //todelete2

                String curUrlNewTab = driver.getCurrentUrl();

                    username = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/section/aside/div[1]/dl/dd/a")).getText();
                    phonenumber = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/section/div[2]/div[1]/div[6]/div/div/dl[2]/dd/ul/li/a")).getText();


                    Fwrite fwrite = new Fwrite();
                    fwrite.fwrite(username, phonenumber,curUrlNewTab);


            } // end try

            catch (org.openqa.selenium.NoSuchElementException e) {
                e.printStackTrace();

            }

            t++;
        } // end for cycle


        driver.quit();


    }// main
} //end class









