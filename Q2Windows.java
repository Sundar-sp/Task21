package task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q2Windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/windows");

		String originalWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Set<String> windowHandle = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(windowHandle);
		driver.switchTo().window(listWindow.get(1));

		String expectedText = "New Window";
		String actualtext = driver.findElement(By.xpath("//div[@class='example']")).getText();
		if (expectedText.contentEquals(actualtext)) {
			System.out.println("Verified '" + actualtext + "' is present in newly opened window");
		} else {
			System.out.println("Text not present");
		}
		driver.close();

		driver.switchTo().window(listWindow.get(0));
		String currectWindow = driver.getWindowHandle();
		if (originalWindow.contentEquals(currectWindow)) {
			System.out.println("Verified original window active");
		} else {
			System.out.println("original window not active");
		}
		driver.quit();
	}

}

Output:
May 27, 2024 1:43:29 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
Verified 'New Window' is present in newly opened window
Verified original window active
