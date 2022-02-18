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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
	
WebUI.scrollToElement(findTestObject('Object Repository/DetailPop-up/OrderPaymentInformation-OrderSummary-Activity/OrderSummaryPaymentActivity', [('position') : '1']), 15)
WebUI.delay(3)
WebUI.takeScreenshot()

WebUI.scrollToElement(findTestObject('Object Repository/DetailPop-up/OrderPaymentInformation-OrderSummary-Activity/OrderSummaryPaymentActivity', [('position') : '2']), 15)
WebUI.delay(3)
WebUI.takeScreenshot()


if(WebUI.waitForElementPresent(findTestObject('Object Repository/DetailPop-up/OrderPaymentInformation-OrderSummary-Activity/OrderSummaryPaymentActivity', [('position') : '3']), 15)) {
	
	WebUI.scrollToElement(findTestObject('Object Repository/DetailPop-up/OrderPaymentInformation-OrderSummary-Activity/OrderSummaryPaymentActivity', [('position') : '3']), 15)
	WebUI.delay(3)
	WebUI.takeScreenshot()
	
}



