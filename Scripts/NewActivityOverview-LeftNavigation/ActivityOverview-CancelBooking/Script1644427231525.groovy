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

        int SizeofActiveBookings = WebUI.findWebElements(findTestObject('Object Repository/CancelAndRefund/OrderListWithoutRefundedStatus'), 5).size()

        KeywordUtil.logInfo("Size of Active Bookings: $SizeofActiveBookings")

        for (refund = 1; refund < SizeofActiveBookings; refund++) {

                if (refund == 1) {

                        refund = SizeofActiveBookings
                }

                KeywordUtil.logInfo("Size of refund booking: $refund")

                WebUI.scrollToElement(findTestObject('Object Repository/CancelAndRefund/OrderListWithoutRefundedStatus - Click', [('position'): refund]), 15)
                WebUI.takeScreenshot()

                WebUI.click(findTestObject('Object Repository/CancelAndRefund/OrderListWithoutRefundedStatus - Click', [('position'): refund]))
                WebUI.takeScreenshot()

                if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'), 15) == true) {

                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'))
                        WebUI.delay(3)
                        WebUI.takeScreenshot()

                        if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/CancelButton - OnRefundPop-up'), 15) == true) {

                                WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelButton - OnRefundPop-up'))
                                WebUI.delay(3)
                                WebUI.takeScreenshot()

                        }

                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'))

                        if (refund < 4) {

                                if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']), 15) == true) {

                                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']))
                                        WebUI.delay(3)
                                        WebUI.takeScreenshot()

                                }

                        }

                        if (refund <= 6 && refund >= 4) {

                                if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']), 15) == true) {

                                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel and Refund']))
                                        WebUI.delay(3)
                                        WebUI.takeScreenshot()

                                }

                        }

                        if (refund > 6) {

                                if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/RefundOptionRadio'), 15) == true) {

                                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/RefundOptionRadio'))
                                        WebUI.delay(3)
                                        WebUI.takeScreenshot()

                                }

                        }
						
						
						WebUI.setText(findTestObject('Object Repository/CancelAndRefund/ReasonForCancellation'), GlobalVariable.CancellationReason)
						
						
						WebUI.click(findTestObject('Object Repository/CancelAndRefund/ConfirmCancellationButton'))
						WebUI.delay(3)
						WebUI.takeScreenshot()

                }

        }

}

// If Record Not Exist in The List Then Need to Exit It
if (sizeoflisting < 2) {
        KeywordUtil.logInfo('No Orders Exist in Listing So All Further Cases Stopped')
}