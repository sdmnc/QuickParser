import java.io.IOException;
import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\NT\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //   driver.manage().window().maximize();
        String username = null;
        String phonenumber = null;
        String urlTwo = null;
        String advName=null;
        String price;
        String priceCur;

        CreateFile createFile = new CreateFile();
        createFile.createFfile();
        int t=1;
        for (int i = 0; i < 2000; i++) {
            driver.get("https://www.999.md/");
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
                //  System.out.println(curUrlNewTab);



                UniqCheck urlCheck = new UniqCheck();
                boolean a = urlCheck.uniqCheck(curUrl, urlTwo);
                if (a == false) {


                    username = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/section/aside/div[1]/dl/dd/a")).getText();
                    // System.out.println(username);
                    // driver.findElement(By.xpath(" //*[@id=\"container\"]/div/section/aside/div[1]/dl/dd/a")).click();
                    //   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    phonenumber = driver.findElement(By.xpath("/html/body/div[4]/div/section/div/section/div[2]/div[1]/div[6]/div/div/dl[2]/dd/ul/li/a")).getText();

                    phonenumber = phonenumber.replaceAll(" ", "");
                    phonenumber = phonenumber.substring(1);
                    //   System.out.println(phonenumber);
                    //  driver.findElement(By.xpath(" //*[@id=\"container\"]/div/section/aside/div[1]/dl/dd/a")).click();
                    advName = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/header/h1")).getText();
                    advName = advName.replace(",", "");
                    //   System.out.println(advName);
                    try {
                        price = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/aside/div[1]/div[4]/div/ul[1]/li/span[1]")).getText();
                        priceCur = driver.findElement(By.xpath("//*[@id=\"container\"]/div/section/aside/div[1]/div[4]/div/ul[1]/li/span[2]")).getText();
                        // driver.findElement(By.class("\"item_title_price\"")).getText();
                        price = price.replaceAll(" ", "");
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        e.printStackTrace();
                        price = "N/A";
                        priceCur = "N/A";
                        // System.out.println("dogovornaia");

                    }
                    String category = driver.findElement(By.xpath("//*[@id=\"m__breadcrumbs\"]/li[3]/a/span")).getText();

                    driver.findElement(By.xpath(" //*[@id=\"container\"]/div/section/aside/div[1]/dl/dd/a")).click();
                    String regDate = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[1]/div[1]/div[3]")).getText();
                    regDate = regDate.substring(11);

                    Fwrite fwrite = new Fwrite();
                    fwrite.fwrite(username, phonenumber, advName, price, priceCur, curUrlNewTab, category, regDate);

                    //driver.close();

                }
            } // end try

            catch (org.openqa.selenium.NoSuchElementException e) {
                e.printStackTrace();

            }
            // driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[1]/a")).click();
            //driver.get("https://www.999.md");
            // driver.navigate().back();
            //driver.navigate().back();
            // driver.navigate().refresh();

            t++;
        } // end for cycle


        driver.quit();


    }// main
} //end class









