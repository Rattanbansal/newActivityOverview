package testdata

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable
import org.openqa.selenium.WebElement

public class TestDataGenerator {


	@Keyword
	public  String getRandomEmail() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String ranEmail = 'cypress'+ randomInt+'@prioticket.com';
		return ranEmail;
	}



	@Keyword
	public String getRandomNumbers() {
		Random rand = new Random();
		for (int i = 1; i<= 10; i++) {
			int resRandom = rand.nextInt((9999 - 100) + 1) + 10;
		}
	}


	@Keyword
	public  String getName() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String ranName = 'Cypress'+ randomInt;
		return ranName;
	}

	@Keyword
	protected String createRandomCode(String handleId) {
		// syntax we would like to generate is DIA123456-A1B34
		String val = "SB";

		// char (1), random A-Z
		int ranChar = 65 + (new Random()).nextInt(90-65);
		char ch = (char)ranChar;
		val += ch;

		// numbers (6), random 0-9
		Random r = new Random();
		int numbers = 100000 + (int)(r.nextFloat() * 899900);
		val += String.valueOf(numbers);

		val += "-";
		// char or numbers (5), random 0-9 A-Z
		for(int i = 0; i<6;){
			int ranAny = 48 + (new Random()).nextInt(90-65);

			if(!(57 < ranAny && ranAny<= 65)){
				char c = (char)ranAny;
				val += c;
				i++;
			}

		}

		return val;
	}

}
