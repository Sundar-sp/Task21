package task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q3NestedFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://the-internet.herokuapp.com/nested_frames");

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));

		List<WebElement> nestedFrames = driver.findElements(By.tagName("frame"));
		if (3 == nestedFrames.size()) {
			System.out.println("3 frames are present in top frame");
		} else {
			System.out.println("3 frames not present in top frame");
		}

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-left']")));
		String leftText = driver.findElement(By.xpath("//body")).getText();
		if ("LEFT".contentEquals(leftText)) {
			System.out.println("Verified left frame has a text is " + leftText);
		} else {
			System.out.println("No text available in left frame");
		}

		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		String middleText = driver.findElement(By.xpath("//body")).getText();
		if ("MIDDLE".contentEquals(middleText)) {
			System.out.println("Verified middle frame has a text is " + middleText);
		} else {
			System.out.println("No text available in middle frame");
		}

		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-right']")));
		String rightText = driver.findElement(By.xpath("//body")).getText();
		if ("RIGHT".contentEquals(rightText)) {
			System.out.println("Verified right frame has a text is " + rightText);
		} else {
			System.out.println("No text available in right frame");
		}

		driver.switchTo().parentFrame();
		driver.switchTo().parentFrame();

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-bottom']")));
		String bottomText = driver.findElement(By.xpath("//body")).getText();
		if ("BOTTOM".contentEquals(bottomText)) {
			System.out.println("Verified bottom frame has a text is " + bottomText);
		} else {
			System.out.println("No text available in bottom frame");
		}

		driver.switchTo().defaultContent();

		String title = driver.getTitle();
		if ("Frames".contentEquals(title)) {
			System.out.println("Verified page title is " + title);
		} else {
			System.out.println("Page title is not Frames");
		}
		driver.quit();
	}

}

Output:
May 27, 2024 1:44:13 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find an exact match for CDP version 125, returning the closest version; found: 122; Please update to a Selenium version that supports CDP version 125
3 frames are present in top frame
Verified left frame has a text is LEFT
Verified middle frame has a text is MIDDLE
Verified right frame has a text is RIGHT
Verified bottom frame has a text is BOTTOM
Page title is not Frames

