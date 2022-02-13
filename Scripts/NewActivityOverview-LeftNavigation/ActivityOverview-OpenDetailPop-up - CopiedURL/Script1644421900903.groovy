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

WebUI.switchToWindowIndex(1)

WebUI.delay(5)
WebUI.navigateToUrl(GlobalVariable.ActivityUrl)
WebUI.takeScreenshot()

WebUI.switchToDefaultContent()

    if (WebUI.waitForElementPresent(findTestObject('Object Repository/DetailPop-up/ExpanSection/ProductInformationExpandedSection-Exist'), 10)) {
		
        KeywordUtil.logInfo('Product Expanded Section Exist')
		
        WebUI.click(findTestObject('DetailPop-up/ExpanSection/ProductInformationExpandedSection -Exist- ClickOnExpandedView'))

        WebUI.delay(3)

        WebUI.takeScreenshot()

        	
    }
	
	
	
	
	int bookingsize = WebUI.findWebElements(findTestObject('Object Repository/DetailPop-up/ExpanSection/ProductSectionLength'), 5).size()
	
	KeywordUtil.logInfo("Size of Bookings on Product detail Pop-up: $bookingsize")
	
	for (looping=1; looping <= bookingsize; looping++) {
		
		WebUI.click(findTestObject('Object Repository/DetailPop-up/ExpanSection/ExpandProductSection', [('position') : looping]))
		WebUI.delay(3)
		WebUI.takeScreenshot()
	
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '1']), 15) == true) {
			
			WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '1']))
			WebUI.delay(3)
			WebUI.takeScreenshot()
			
		}
		
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '2']), 15) == true) {
		WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '2']))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		}
		
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '3']), 15) == true) {
		
		WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '3']))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		}
		
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '5']), 15) == true) {
		WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '5']))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		}
		
		if(WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '4']), 15) == true) {
			WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position') : '1', ('position2') : '4']))
			WebUI.delay(3)
			WebUI.takeScreenshot()
			
			}
	}
	
	
	if(WebUI.waitForElementClickable(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-ClickOnExpandView', [('position') : '1']), 15)) {
	
	int SubProductsInBookingSize = WebUI.findWebElements(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductListLength'), 5).size()
	
	KeywordUtil.logInfo("Size of Bookings on Product detail Pop-up: $SubProductsInBookingSize")
	
	
	for (sublooping=80; sublooping < SubProductsInBookingSize; sublooping++) {
		
		scrolloing = sublooping+1
		
		if (scrolloing > SubProductsInBookingSize) {
			
			scrolloing = SubProductsInBookingSize
		}
		
		KeywordUtil.logInfo("Size of subproducts: $SubProductsInBookingSize")
		
		KeywordUtil.logInfo("Size of scrolling: $scrolloing")
		
		WebUI.scrollToElement(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-ClickOnExpandView', [('position') : scrolloing]), 15)
		WebUI.delay(3)
		WebUI.takeScreenshot()		
		
		WebUI.click(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-ClickOnExpandView', [('position') : sublooping]))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details-SubProducts', [('position') : '1', ('position2') : '1']))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details-SubProducts', [('position') : '1', ('position2') : '3']))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-CloseExpandView', [('position') : '1']))
		
	}
	
	}
