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
        [: ], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('SuperAdminLeftNavigation/NewActivityOverview-LeftNavigation'))

WebUI.takeScreenshot()

WebUI.switchToFrame(findTestObject('Object Repository/Iframe/NewActivityOverviewIframe'),
        5)

WebUI.delay(10)
WebUI.takeScreenshot()

// Check Any record exist in listing
int sizeoflisting = WebUI.findWebElements(findTestObject(
        'ListingArea/ListingContainsData'), 5).size()

println(sizeoflisting)

KeywordUtil.logInfo("Size of Order Listing: $sizeoflisting")

// Check Record Exist in List then Run Futher Cases
if (sizeoflisting > 2) {
        KeywordUtil.logInfo('Orders Exist in Listing')
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ClickonEyeView'))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '1']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '2']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '3']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '4']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '5']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '6']))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '7']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '8']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '9']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '10']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/SaveButton'))
		WebUI.delay(10)
		
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ClickonEyeView'))
		WebUI.delay(3)
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '1']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '2']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '3']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '7']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '8']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '9']))
		WebUI.takeScreenshot()
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/AddExtraColumns', [('position') : '10']))
		WebUI.takeScreenshot()
		
		//WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/ShowDirect'))
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/OrderPerPage', [('position') : '3']))
		
		WebUI.click(findTestObject('Object Repository/ListViewIcon/ExtraColumns/SaveButton'))
		WebUI.delay(10)
}

// If Record Not Exist in The List Then Need to Exit It
if (sizeoflisting < 2) {
        KeywordUtil.logInfo('No Orders Exist in Listing So All Further Cases Stopped')
}