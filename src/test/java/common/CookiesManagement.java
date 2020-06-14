package common;

import inputdata.DataSetter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utils.browsers.DriverManager;

import java.io.*;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

public class CookiesManagement {
    LoginPage loginPage;
    DataSetter dataSetter;
    DriverManager driverManager;
    WebDriverWait wait;
    File file;

    private final String CorrectUserName;
    private final String CorrectPassword;
    private final String cookieFile;

    public CookiesManagement() throws IOException {
        dataSetter = new DataSetter();

        this.CorrectUserName = dataSetter.getUsername();
        this.CorrectPassword = dataSetter.getPassword();
        this.cookieFile = "Cookie.data";
    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        loginPage = new LoginPage(driver);
        // <-----
        loginPage.login(CorrectUserName, CorrectPassword);
        wait = new WebDriverWait(driver, 20);
        return driver.manage().getCookies();
    }

    public WebDriver setAllCookies(WebDriver driver) {
        Set<Cookie> cookiesList = getAllCookies(driver);
        for (Cookie cookie : cookiesList) {

            driver.manage().addCookie(cookie);
        }
        return driver;
    }

    public File cookieRead(WebDriver driver){
        loginPage = new LoginPage(driver);
        loginPage.login(CorrectUserName, CorrectPassword);
        this.file = new File(cookieFile);
        try {
            //Delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            //loop for getting the cookie information

            for (Cookie cookie : driver.manage().getCookies()) {
                bWriter.write(cookie.getValue() + ";" + cookie.getDomain() + ";" + cookie.getPath()
                 + ";" + cookie.getExpiry() + ";" + cookie.isSecure());
                bWriter.newLine();
            }
            bWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    public WebDriver cookieWrite(WebDriver driver) {
        try {
            this.file = cookieRead(driver);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strLine, ";");

                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String  path = token.nextToken();
                    Date expiry = null;

                    String val;
                    if (!(val = token.nextToken()).equals("null"))
                    {
                        expiry = new Date(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken());

                    Cookie cookie = new Cookie(name, value, domain, path, expiry, isSecure);
                    System.out.println(cookie);
                    driver.manage().addCookie(cookie);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
}
