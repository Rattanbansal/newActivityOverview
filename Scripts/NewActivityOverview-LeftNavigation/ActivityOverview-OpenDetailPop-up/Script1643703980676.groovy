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

    WebUI.click(findTestObject('Object Repository/OrderPerPage/OrderPerPage_select'))
    WebUI.delay(5)

    WebUI.click(findTestObject('Object Repository/OrderPerPage/OrderPerPage-SelectOption'))
    WebUI.delay(20)
    WebUI.takeScreenshot()

    String SizeofPagination = WebUI.getText(findTestObject('Object Repository/PaginationCOunt/PaginationCount'))

    println(SizeofPagination)

    int paginationmaxcount = Integer.parseInt(SizeofPagination)
	
	paginationmaxcount = GlobalVariable.pagination

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

        int RecordsinListing = WebUI.findWebElements(findTestObject('Object Repository/ListingArea/RecordsInListing'), 5).size()

        KeywordUtil.logInfo("Size of Active Bookings: $RecordsinListing")

        for (refund = 1; refund < RecordsinListing; refund++) {

            if (refund == 1) {

                refund = RecordsinListing
            }

            GlobalVariable.refundvalue = refund

            KeywordUtil.logInfo("Size of refund booking: $refund")

            WebUI.scrollToElement(findTestObject('Object Repository/ListingArea/ClickondetailPOp-up', [('position'): refund]), 15)
            WebUI.takeScreenshot()

            String orderId = WebUI.findWebElement(findTestObject('Object Repository/GetOrderID/GetOrderID', [('position'): refund])).getAttribute('data-order_id')

            GlobalVariable.orderId = orderId

            KeywordUtil.logInfo("Order ID: $orderId")

           WebUI.click(findTestObject('Object Repository/GetOrderID/GetOrderID', [('position'): refund]))

            WebUI.delay(20)

            WebUI.takeScreenshot()

            if (WebUI.waitForElementPresent(findTestObject('Object Repository/DetailPop-up/ExpanSection/ProductInformationExpandedSection-Exist'), 10)) {

                KeywordUtil.logInfo('Product Expanded Section Exist')

                WebUI.click(findTestObject('DetailPop-up/ExpanSection/ProductInformationExpandedSection -Exist- ClickOnExpandedView'))

                WebUI.delay(3)

                WebUI.takeScreenshot()

            }

            int bookingsize = WebUI.findWebElements(findTestObject('Object Repository/DetailPop-up/ExpanSection/ProductSectionLength'), 5).size()

            KeywordUtil.logInfo("Size of Bookings on Product detail Pop-up: $bookingsize")

            for (looping = 1; looping <= bookingsize; looping++) {

                WebUI.click(findTestObject('Object Repository/DetailPop-up/ExpanSection/ExpandProductSection', [('position'): looping]))
                WebUI.delay(3)
                WebUI.takeScreenshot()

                if (WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '1']), 15) == true) {

                    WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '1']))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                }

                if (WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '2']), 15) == true) {
                    WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '2']))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                }

                if (WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '3']), 15) == true) {

                    WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '3']))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                }

                if (WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '5']), 15) == true) {
                    WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '5']))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                }
				
				if (WebUI.waitForElementVisible(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '4']), 15) == true) {
					WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details', [('position'): '1', ('position2'): '4']))
					WebUI.delay(3)
					WebUI.takeScreenshot()

				}
				
				
            }

            if (WebUI.waitForElementClickable(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-ClickOnExpandView', [('position'): '1']), 15)) {

                int SubProductsInBookingSize = WebUI.findWebElements(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductListLength'), 5).size()

                KeywordUtil.logInfo("Size of Bookings on Product detail Pop-up: $SubProductsInBookingSize")

                for (sublooping = 79; sublooping < SubProductsInBookingSize; sublooping++) {

                    scrolloing = sublooping + 1

                    if (scrolloing > SubProductsInBookingSize) {

                        scrolloing = SubProductsInBookingSize
                    }

                    KeywordUtil.logInfo("Size of subproducts: $SubProductsInBookingSize")

                    KeywordUtil.logInfo("Size of scrolling: $scrolloing")

                    WebUI.scrollToElement(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-ClickOnExpandView', [('position'): scrolloing]), 15)
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                    WebUI.click(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-ClickOnExpandView', [('position'): sublooping]))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                    WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details-SubProducts', [('position'): '1', ('position2'): '1']))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                    WebUI.click(findTestObject('Object Repository/DetailPop-up/InformationSection/Details-SubProducts', [('position'): '1', ('position2'): '3']))
                    WebUI.delay(3)
                    WebUI.takeScreenshot()

                    WebUI.click(findTestObject('Object Repository/DetailPop-up/ExpanSection/SubProductList-CloseExpandView', [('position'): '1']))

                }

            }

			WebUI.callTestCase(findTestCase('Test Cases/StepToReUse/StepTOCopyURLAndAddAnotherTab'),
				[: ], FailureHandling.CONTINUE_ON_FAILURE)
			
			WebUI.callTestCase(findTestCase('Test Cases/NewActivityOverview-LeftNavigation/ActivityOverview-OpenDetailPop-up - CopiedURL'),
				[: ], FailureHandling.CONTINUE_ON_FAILURE)
			
		 WebUI.switchToWindowIndex(0)
		 
		 WebUI.delay(13)
		 
		 WebUI.switchToFrame(findTestObject('Object Repository/Iframe/NewActivityOverviewIframe'), 5)
		 
		 WebUI.click(findTestObject('Object Repository/DetailPop-up/Backbutton/BackButtonToListing'))
		 
		 WebUI.delay(13)
			
        }
		
		
    }
}

// If Record Not Exist in The List Then Need to Exit It
if (sizeoflisting < 2) {
    KeywordUtil.logInfo('No Orders Exist in Listing So All Further Cases Stopped')
}