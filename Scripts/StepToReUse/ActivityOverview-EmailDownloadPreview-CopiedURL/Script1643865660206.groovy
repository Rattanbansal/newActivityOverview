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
	
	WebUI.switchToWindowIndex(1)
	
	WebUI.delay(5)
	WebUI.navigateToUrl(GlobalVariable.ActivityUrl)
	WebUI.takeScreenshot()
	
	WebUI.switchToDefaultContent()


	WebUI.click(findTestObject('Object Repository/Header/Preview/ClickOnPreviewIcon'))

    WebUI.delay(10)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Preview/PrintVoucher'))

    WebUI.delay(10)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Preview/ClickOnPreviewIcon'))

    WebUI.delay(10)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Preview/PrintReceipt'))

    WebUI.delay(10)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Email/ClickOnSecndEmailButton'))

    WebUI.delay(10)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Email/EmailVoucher'))

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.setText(findTestObject('Object Repository/Header/Email/InputEmails'), 
        'rattan.intersoft@gmail.com')

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Email/SendButton'))

    WebUI.delay(10)

    /// send receipt button
    WebUI.click(findTestObject('Object Repository/Header/Email/ClickOnSecndEmailButton'))

    WebUI.delay(10)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Email/EmailReceipt'))

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.setText(findTestObject('Object Repository/Header/Email/InputEmails'), 
        'rattan.intersoft@gmail.com')

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Email/SendButton'))

    WebUI.delay(10)

    ///Download Vouchers and Receipts
    WebUI.click(findTestObject('Object Repository/Header/Download/ClickOnDownloadIcon'))

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Download/DownloadVoucher'))

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Download/ClickOnDownloadIcon'))

    WebUI.delay(2)

    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/Header/Download/Downloadreceipt'))

    WebUI.delay(2)

    WebUI.takeScreenshot()