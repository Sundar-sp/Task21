package task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Q1Iframe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
		WebElement text = driver.findElement(By.xpath("//body[@id='tinymce']//child::p"));
		text.clear();
		text.sendKeys("Hello People");
		driver.switchTo().defaultContent();

		driver.close();

	}

}

Output:
"This webPage(https://the-internet.herokuapp.com/iframe) can't able to edit so exception occured."

Exception in thread "main" org.openqa.selenium.InvalidElementStateException: Unable to clear element that cannot be edited: <p>
Build info: version: '4.18.1', revision: 'b1d3319b48'
System info: os.name: 'Windows 11', os.arch: 'amd64', os.version: '10.0', java.version: '11.0.21'
Driver info: org.openqa.selenium.firefox.FirefoxDriver
Command: [87ca6101-164f-4ae4-b40a-4ada24af1416, clearElement {id=6be6aad4-b5ff-4c8b-b818-0cc1689402e9}]
Capabilities {acceptInsecureCerts: true, browserName: firefox, browserVersion: 126.0, moz:accessibilityChecks: false, moz:buildID: 20240509170740, moz:debuggerAddress: 127.0.0.1:11531, moz:geckodriverVersion: 0.34.0, moz:headless: false, moz:platformVersion: 10.0, moz:processID: 42288, moz:profile: C:\Users\Sundar\AppData\Loc..., moz:shutdownTimeout: 60000, moz:webdriverClick: true, moz:windowless: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://127.0.0.1:11531/devtoo..., se:cdpVersion: 85.0, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, userAgent: Mozilla/5.0 (Windows NT 10....}
Element: [[FirefoxDriver: firefox on windows (87ca6101-164f-4ae4-b40a-4ada24af1416)] -> xpath: //body[@id='tinymce']//child::p]
Session ID: 87ca6101-164f-4ae4-b40a-4ada24af1416
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:490)
	at org.openqa.selenium.remote.ErrorCodec.decode(ErrorCodec.java:167)
	at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:138)
	at org.openqa.selenium.remote.codec.w3c.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:50)
	at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:190)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:216)
	at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:174)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:519)
	at org.openqa.selenium.remote.RemoteWebElement.execute(RemoteWebElement.java:223)
	at org.openqa.selenium.remote.RemoteWebElement.clear(RemoteWebElement.java:129)
	at task21.Q1Iframe.main(Q1Iframe.java:21)
