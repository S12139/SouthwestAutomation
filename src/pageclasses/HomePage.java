package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="trip-type-one-way")
	WebElement oneWayRadio;
		
	@FindBy(id="booking-form--flight-tab")
	WebElement flightsTab;
	
	@FindBy(id="booking-form--hotel-tab")
	WebElement hotelsTab;
	
	@FindBy(id="booking-form--car-tab")
	WebElement carsTab;
	
	@FindBy(id="booking-form--vacations-tab")
	WebElement vacationsTab;
	
	@FindBy(id="air-city-departure")
	WebElement departureCityText;
	
	@FindBy(id="air-city-arrival")
	WebElement arrivalCityText;

	@FindBy(id="air-city-departure-menu-item3")
	WebElement departureCityMenuItem;	
	
	@FindBy(id="air-city-arrival-menu-item0")
	WebElement arrivalCityMenuItem;
	
	@FindBy(id="air-date-departure")
	WebElement departureDate;
	
	@FindBy(id="jb-booking-form-submit-button")
	WebElement searchButton;
	
	public void clickOneWay() {
		oneWayRadio.click();
	}

	public void clickFlightsTab() {
		flightsTab.click();
	}
	
	public void clickHotelsTab() {
		hotelsTab.click();
	}
	
	public void clickCarsTab() {
		carsTab.click();
	}
	
	public void clickVacationsTab() {
		vacationsTab.click();
	}
	
	public void setDepartureCity(String departureCity) throws InterruptedException {
		departureCityText.click();
		departureCityText.sendKeys(departureCity);
		Thread.sleep(500);
		departureCityMenuItem.click();		
	}
	
	public void setArrivalCity(String arrivalCity) throws InterruptedException {
		arrivalCityText.click();
		arrivalCityText.sendKeys(arrivalCity);
		Thread.sleep(500);
		arrivalCityMenuItem.click();		
	}
	
	public void setDepartureDate(String departDate) throws InterruptedException {
		departureDate.click();
		departureDate.clear();
		departureDate.sendKeys(departDate);
	}
	
	public void clickSearch() {
		searchButton.click();
	}
}
