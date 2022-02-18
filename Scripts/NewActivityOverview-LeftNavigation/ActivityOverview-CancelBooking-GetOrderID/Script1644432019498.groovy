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

                

				String orderId = WebUI.findWebElement(findTestObject('Object Repository/GetOrderID/GetOrderID', [('position') : refund])).getAttribute('data-order_id')
				
				GlobalVariable.orderId = orderId
				
				KeywordUtil.logInfo("Order ID: $orderId")

        }


