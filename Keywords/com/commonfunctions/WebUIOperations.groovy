package com.commonfunctions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

//import internal.GlobalVariable

//incomplete code - check later
public class WebUIOperations {

	@Keyword
	public static String randomString(String chars, int length) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<length; i++) {
			sb.append(chars.charAt(rand.nextInt(chars.length())));
		}
		//println (sb.toString());
		return sb.toString();

	}
	@Keyword
	public static void fnVerifyMsg1 (String sExpectedText, Boolean isRegEx) {

		def sActualText = WebUI.getText(findTestObject('ObjSaveProposal/td_ProposalText'))
		sActualText = sActualText.trim()
		System.out.println(sActualText)

		WebUI.comment('Captured Text: ' + sActualText)
		WebUI.verifyMatch(sActualText, sExpectedText, isRegEx, FailureHandling.CONTINUE_ON_FAILURE)

		//	KeywordLogger log = new KeywordLogger()
		//log.logPassed("Proposal Msg Generated : " +  GlobalVariable.ProposalNumber)

	}

	@Keyword
	public static void fnVerifyvalue1 (String sActualText,String sExpectedText, Boolean isRegEx) {
		sActualText = sActualText.trim()
		System.out.println(sActualText)
		//def sActualText = WebUI.getText(findTestObject('ObjSaveProposal/td_ProposalText'))
		WebUI.comment('Captured Text: ' + sActualText)
		WebUI.verifyMatch(sActualText, sExpectedText, isRegEx, FailureHandling.CONTINUE_ON_FAILURE)

	}

	@Keyword
	public static void fnVerifyObjectvalue (String oActualObject,String sExpectedText, Boolean isRegEx) {
		def sActualText = WebUI.getText(findTestObject(oActualObject))
		sActualText = sActualText.trim()
		System.out.println(sActualText)
		WebUI.comment('Captured Text: ' + sActualText)
		def stacheck = WebUI.verifyMatch(sActualText, sExpectedText, isRegEx, FailureHandling.CONTINUE_ON_FAILURE)

		if (stacheck == false) {
			//GlobalVariable.STATUS = 'FAILED'
		}

	}

	@Keyword
	public static void fnVerifyMessage (String sExpectedText, Boolean isRegEx) {
		def sActualText = WebUI.getText(findTestObject('ObjSaveProposal/td_ProposalText'))
		//def sActualText = WebUI.getText(findTestObject(oActualObject))
		sActualText = sActualText.trim()
		System.out.println(sActualText)
		WebUI.comment('Captured Text: ' + sActualText)
		def stacheck = WebUI.verifyMatch(sActualText, sExpectedText, isRegEx, FailureHandling.CONTINUE_ON_FAILURE)

		if (stacheck == false) {

			//GlobalVariable.STATUS = 'FAILED'
		}


	}


	@Keyword
	public static void TestMethodval(String dynamicId) {
		String xpath = ('//*[@value="' + dynamicId) + '"]'
		TestObject to = new TestObject('objectName')
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		WebUI.click(to)
	}


	@Keyword
	public static void TestMethodtext(def dynamicId) {
		//String xpath = ('//*[@text()="' + dynamicId) + '"]'

		String xpath = ('//*[@text()="' + dynamicId + '"' + 'or . = "' + dynamicId) + '"]'
		TestObject to = new TestObject('objectName')
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		WebUI.click(to)
	}

	/**
	 * Click text
	 * @param to Katalon text
	 */
	@Keyword
	def clickText(String text) {
		try {
			String xpath_text = ("//*[contains(text(),\'"+text+"\')]")

			TestObject to_text = new TestObject('text_to_click')

			to_text.addProperty('xpath', ConditionType.EQUALS, xpath_text)




			KeywordUtil.logInfo("Clicking element")
			WebUI.click(to_text)
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}

	}



	@Keyword
	def clickUsingJS(TestObject to, int timeout)
	{
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = WebUiCommonHelper.findWebElement(to, timeout)
		JavascriptExecutor executor = ((driver) as JavascriptExecutor)
		executor.executeScript('arguments[0].click()', element)
	}

}
