
public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String chromeKey = "webdriver.chrome.driver";
		String chromeDriverPath = "./Workspace/Gmail/drivers/chromedriver.exe";
		
		System.setProperty(chromeKey, chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
	}

}
