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

        WebUI.click(findTestObject('Object Repository/OrderPerPage/OrderPerPage_select'))
        WebUI.delay(5)

        WebUI.click(findTestObject('Object Repository/OrderPerPage/OrderPerPage-SelectOption'))
        WebUI.delay(20)
		WebUI.takeScreenshot()
		
        String SizeofPagination = WebUI.getText(findTestObject('Object Repository/PaginationCOunt/PaginationCount'))

        println(SizeofPagination)

        int paginationmaxcount = Integer.parseInt(SizeofPagination)

        KeywordUtil.logInfo("Size of Pagination: $paginationmaxcount")
		
		totalrecords = 0
		
        for (l = 1; l <= paginationmaxcount; l++) {

                if (l <= 5) {

                        paginationvalue = l

                }

                if (l > 5) {

                        paginationvalue = '4'

                }

                KeywordUtil.logInfo("Size of Pagination: $paginationvalue")

                WebUI.click(findTestObject('Object Repository/PaginationCOunt/ClickOnPagination', [('pagination'): paginationvalue]))
                WebUI.delay(20)
				WebUI.takeScreenshot()
				
				int orderListing = WebUI.findWebElements(findTestObject('Object Repository/ListingArea/RecordsInListing'), 5).size()
				
				totalrecords = totalrecords + orderListing
				
				KeywordUtil.logInfo("Total Records: $totalrecords")
        }

}

// If Record Not Exist in The List Then Need to Exit It
if (sizeoflisting < 2) {
        KeywordUtil.logInfo('No Orders Exist in Listing So All Further Cases Stopped')
}