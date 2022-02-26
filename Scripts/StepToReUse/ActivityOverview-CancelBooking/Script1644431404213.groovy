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

KeywordUtil.logInfo("Refund Value: ${GlobalVariable.refundvalue}")

int cancelButtonSize = WebUI.findWebElements(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'), 5).size()

KeywordUtil.logInfo("Cancel Button Size: ${cancelButtonSize}")

if (cancelButtonSize == 1) 

{
                if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'), 15) == true) {
						
					WebUI.scrollToElement(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'), 15)
                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'))
                        WebUI.delay(3)
                        WebUI.takeScreenshot()

                        if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/CancelButton - OnRefundPop-up'), 15) == true) {

                                WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelButton - OnRefundPop-up'))
                                WebUI.delay(3)
                                WebUI.takeScreenshot()

                        }

                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton'))

                        if (GlobalVariable.refundvalue < 4) {

                                if (WebUI.waitForElementVisible(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']), 15) == true) {

                                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']))
                                        WebUI.delay(3)
                                        WebUI.takeScreenshot()

                                }

                        }

                        if (GlobalVariable.refundvalue <= 6 && GlobalVariable.refundvalue >= 4) {

                                if (WebUI.waitForElementVisible(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']), 15) == true) {

                                        WebUI.click(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel and Refund']))
                                        WebUI.delay(3)
                                        WebUI.takeScreenshot()

                                }

                        }

                        if (GlobalVariable.refundvalue > 6) {

                                if (WebUI.waitForElementVisible(findTestObject('Object Repository/CancelAndRefund/RefundOptionRadio'), 15) == true) {

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

if (cancelButtonSize > 1)


for (cancelbutton = 1; cancelbutton <= cancelButtonSize; cancelbutton++) {
	
	if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton - Multiple', [('position') : cancelbutton]), 15) == true) {
								
		
								WebUI.scrollToElement(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton - Multiple', [('position') : cancelbutton]), 15)
								WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton - Multiple', [('position') : cancelbutton]))
								WebUI.delay(3)
								WebUI.takeScreenshot()
		
								if (WebUI.waitForElementClickable(findTestObject('Object Repository/CancelAndRefund/CancelButton - OnRefundPop-up'), 15) == true) {
		
										WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelButton - OnRefundPop-up'))
										WebUI.delay(3)
										WebUI.takeScreenshot()
		
								}
		
								WebUI.click(findTestObject('Object Repository/CancelAndRefund/CancelBookingButton - Multiple', [('position') : cancelbutton]))
		
								if (GlobalVariable.refundvalue <= 10) {
		
										if (WebUI.waitForElementVisible(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']), 15) == true) {
		
												WebUI.click(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']))
												WebUI.delay(3)
												WebUI.takeScreenshot()
		
										}
		
								}
		
								if (GlobalVariable.refundvalue > 10 && GlobalVariable.refundvalue > 11) {
		
										if (WebUI.waitForElementVisible(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel']), 15) == true) {
		
												WebUI.click(findTestObject('Object Repository/CancelAndRefund/OptionToCancelRefund', [('option'): 'Cancel and Refund']))
												WebUI.delay(3)
												WebUI.takeScreenshot()
		
										}
		
								}
		
								if (GlobalVariable.refundvalue > 12) {
		
										if (WebUI.waitForElementVisible(findTestObject('Object Repository/CancelAndRefund/RefundOptionRadio'), 15) == true) {
		
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
