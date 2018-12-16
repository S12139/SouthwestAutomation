package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageclasses.HomePage;
import pageclasses.SearchResultsPage;
import pageclasses.TripAndPriceResultsPage;
import testbase.TestBase;

public class SearchFlight extends TestBase {
	
	@Test
	public void testSearchFlight() throws InterruptedException, IOException {
		driver.get("https://www.southwest.com/");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.southwest.com/", "Not on SouthWest Website");
		
		HomePage homePage = new HomePage(driver);
		SearchResultsPage resultsPage = new SearchResultsPage(driver);
		TripAndPriceResultsPage tripAndPriceResultsPage = new TripAndPriceResultsPage(driver);
		
		//Setting date, airports on home page and clicking search
		homePage.clickOneWay();
		homePage.clickFlightsTab();
		homePage.setDepartureCity("san");
		homePage.setArrivalCity("dal");
		homePage.setDepartureDate("1/7");
		homePage.clickSearch();
		Thread.sleep(5000);
		
		//Performing validations clicking nonstop and selecting price on Search Results Page
		Assert.assertEquals(resultsPage.getFlightDate(), "Jan 07");
		Assert.assertTrue(resultsPage.validateDepartureAirport("SFO"));
		Assert.assertTrue(resultsPage.validateArrivalAirport("DAL"));
		resultsPage.clickNonstop();
		Thread.sleep(5000);
		Assert.assertTrue(resultsPage.validateNonstop());
		resultsPage.clickSelectPrice();
		Thread.sleep(2000);
		resultsPage.clickContinue();
		Thread.sleep(2000);
		
		//Validating date, price and airports on Trip and Price Results Page
		Assert.assertEquals(tripAndPriceResultsPage.getDepartureAirport(),"SFO");
		Assert.assertEquals(tripAndPriceResultsPage.getArrivalAirport(),"DAL");
		Assert.assertEquals(tripAndPriceResultsPage.getFlightPrice(),533);
		Assert.assertEquals(tripAndPriceResultsPage.getFlightDate(), "1/7");
	}
}
