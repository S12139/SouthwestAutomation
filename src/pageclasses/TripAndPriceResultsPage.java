package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAndPriceResultsPage {
	
WebDriver driver;
	
	public TripAndPriceResultsPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='flight-detail--heading-date']")
	WebElement flightDate;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[3]/span[1]")
	WebElement departureAirport;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[3]/div[3]/span[1]")
	WebElement arrivalAirport;
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[2]/span[1]/span[1]/span[2]/span[2]")
	WebElement flightPrice;
	
	public String getFlightDate() {
		return flightDate.getText().substring(0, 3);
	}
	
	public String getDepartureAirport() {
		return departureAirport.getText();
	}
	
	public String getArrivalAirport() {
		return arrivalAirport.getText();
	}
	
	public int getFlightPrice() {
		double cost = Double.parseDouble(flightPrice.getText());
		return (int)Math.round(cost);
	}
}
