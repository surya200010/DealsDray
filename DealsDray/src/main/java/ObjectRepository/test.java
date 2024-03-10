package ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class test {

	public test(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
