package pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	Actions action;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="checkbox--content-button-container")
	WebElement nonstopRadio;
	
	@FindBys({@FindBy(className="flight-stops--duration")})
	List<WebElement> nonstopFlights;
	
	@FindBy(xpath="//div[@id='air-booking-fares-0-1']/div")
	WebElement selectPrice;
	
	@FindBy(id="air-booking-product-1")
	WebElement continueButton;	
	
	@FindBy(xpath="//span[@class='calendar-strip--content calendar-strip--content_selected']/span")
	WebElement flightDate;
	
	@FindBy(xpath="//div[@class='price-matrix--stations']")
	WebElement airportDetails;
	
	public void clickNonstop() {
		action = new Actions(driver);
		action.moveToElement(nonstopRadio).click().perform();
	}

	
	public boolean validateNonstop() {		
		for(WebElement list : nonstopFlights) {			
			if(list.getText().contains("stop"))
				return false;
		}	
		
		return true;
	}
	
	public void clickSelectPrice() {
		selectPrice.click();
	}
	
	public void clickContinue() {
		continueButton.click();
	}
	
	public boolean validateDepartureAirport(String departureAirport) {
		return airportDetails.getText().contains(departureAirport);		
	}
	
	public boolean validateArrivalAirport(String arrivalAirport) {
		return airportDetails.getText().contains(arrivalAirport);		
	}
	
	public String getFlightDate() {
		return flightDate.getText();
	}
}
