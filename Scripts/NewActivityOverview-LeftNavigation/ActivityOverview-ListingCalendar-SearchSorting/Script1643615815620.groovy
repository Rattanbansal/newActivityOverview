import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.sql.Connection as Connection
import java.sql.ResultSet as ResultSet
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.callTestCase(findTestCase('LoginWithSuperAdmin/SuperAdmin-Login'), 
    [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('SuperAdminLeftNavigation/NewActivityOverview-LeftNavigation'))

WebUI.takeScreenshot()

WebUI.switchToFrame(findTestObject('Object Repository/Iframe/NewActivityOverviewIframe'), 
    5)



WebUI.delay(20)
WebUI.takeScreenshot()

// Check Any record exist in listing
int sizeoflisting = WebUI.findWebElements(findTestObject(
        'ListingArea/ListingContainsData'), 5).size()

println(sizeoflisting)

KeywordUtil.logInfo("Size of Order Listing: $sizeoflisting")

// Check Record Exist in List then Run Futher Cases
if (sizeoflisting > 2) {
    KeywordUtil.logInfo('Orders Exist in Listing')
	
	
	
	
	WebUI.click(findTestObject('Object Repository/CalendarObjects/ClickCalendar'))
	WebUI.delay(20)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/CalendarObjects/CalendarOptions-Select'))
	WebUI.delay(5)
	WebUI.click(findTestObject('Object Repository/CalendarObjects/CalendarOptions-SelectOptions', [('types') : 'Custom']))
	WebUI.delay(5)
	
	WebUI.sendKeys(findTestObject('Object Repository/CalendarObjects/InputStartDate'), Keys.chord(Keys.CONTROL + 'a'))
	WebUI.setText(findTestObject('Object Repository/CalendarObjects/InputStartDate'), GlobalVariable.start_date)
	WebUI.delay(5)
	WebUI.sendKeys(findTestObject('Object Repository/CalendarObjects/InputEndDate'), Keys.chord(Keys.CONTROL + 'a'))
	WebUI.setText(findTestObject('Object Repository/CalendarObjects/InputEndDate'), GlobalVariable.end_date)
	WebUI.delay(5)
	
	WebUI.click(findTestObject('Object Repository/CalendarObjects/DoneButton'))
	WebUI.delay(20)
	
    WebUI.click(findTestObject('Object Repository/ListingArea/Search/InputSearch'))

    WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext1}")
	
	WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
	
	WebUI.delay(20)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext2}")
	
	WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
	
	WebUI.delay(20)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext3}")
	
	WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
	
	
	WebUI.delay(20)
	WebUI.takeScreenshot()
	int searchlistingsize = WebUI.findWebElements(findTestObject('Object Repository/ListingArea/Search/SearchResultList'), 5).size()
	
	KeywordUtil.logInfo("Size of Search Listing: $searchlistingsize")
	
	for (m=1; m <= searchlistingsize; m++ ) {
		
		
		WebUI.click(findTestObject('Object Repository/ListingArea/Search/SearchCancelButton', [("position") : '1']))
		WebUI.delay(20)
		WebUI.takeScreenshot()
	}
	
		WebUI.click(findTestObject('Object Repository/ListingArea/Search/InputSearch'))
	
		WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext1}")
		
		WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
		
		WebUI.delay(20)
		WebUI.takeScreenshot()
		WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext2}")
		
		WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
		
		WebUI.delay(20)
		WebUI.takeScreenshot()
		WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext3}")
		
		WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
		
		
		WebUI.delay(20)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/ListingArea/Search/ClearSearch'))
	
		
		//Sorting of Orders
		
		WebUI.delay(20)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
		
		WebUI.delay(5)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '1']))
		
		WebUI.delay(20)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
		
		WebUI.delay(5)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '2']))
		
		WebUI.delay(20)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
		
		WebUI.delay(5)
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '3']))
		WebUI.delay(20)
		WebUI.takeScreenshot()
		
			WebUI.click(findTestObject('Object Repository/ListingArea/Search/InputSearch'))
		
			WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext1}")
			
			WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
			
			WebUI.delay(20)
			
			WebUI.delay(20)
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
			
			WebUI.delay(5)
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '1']))
			
			WebUI.delay(20)
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
			
			WebUI.delay(5)
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '2']))
			
			WebUI.delay(20)
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
			
			WebUI.delay(5)
			WebUI.takeScreenshot()
			WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '3']))
			WebUI.delay(20)
			WebUI.takeScreenshot()
			
				WebUI.click(findTestObject('Object Repository/ListingArea/Search/InputSearch'))
			
				WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext2}")
				
				WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
				
				WebUI.delay(20)
				
				WebUI.delay(20)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
				
				WebUI.delay(5)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '1']))
				
				WebUI.delay(20)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
				
				WebUI.delay(5)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '2']))
				
				WebUI.delay(20)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
				
				WebUI.delay(5)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '3']))
				WebUI.delay(20)
				WebUI.takeScreenshot()
				
					WebUI.click(findTestObject('Object Repository/ListingArea/Search/InputSearch'))
				
					WebUI.setText(findTestObject('Object Repository/ListingArea/Search/InputSearch'), "${searchtext3}")
					
					WebUI.sendKeys(findTestObject('Object Repository/ListingArea/Search/InputSearch'),Keys.chord(Keys.ENTER))
					
					WebUI.delay(20)
					
					WebUI.delay(20)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
					
					WebUI.delay(5)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '1']))
					
					WebUI.delay(20)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
					
					WebUI.delay(5)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '2']))
					
					WebUI.delay(20)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/Sorting/SortingSelect'))
					
					WebUI.delay(5)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/Sorting/SortingSelectOption', [("position1") : '3']))
					WebUI.delay(20)
					WebUI.takeScreenshot()
					
					WebUI.delay(20)
					WebUI.takeScreenshot()
					WebUI.click(findTestObject('Object Repository/ListingArea/Search/ClearSearch'))
			
}

// If Record Not Exist in The List Then Need to Exit It
if (sizeoflisting < 2) {
    KeywordUtil.logInfo('No Orders Exist in Listing So All Further Cases Stopped')
}

