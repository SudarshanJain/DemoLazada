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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String login_username = findTestData('DataFile').getObjectValue('UserName', rownum)

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.lazada.com.my/')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Page_Lazadacommy Best Online Shopping in Malaysia/a_LOGIN'))

WebUI.click(findTestObject('Object Repository/Page_Lazadacommy Online Shopping Malaysia -_7b9812/button_Google'))

WebUI.switchToWindowTitle('Sign in – Google accounts')

WebUI.setText(findTestObject('Object Repository/Page_Sign in  Google accounts/input_Lazada Firebase Production_identifier'), 
    login_username)

WebUI.click(findTestObject('null'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Sign in  Google accounts/input_Too many failed attempts_password'), 
    'B/mg2sWFA3yjfMxN2HN/7A==')

WebUI.click(findTestObject('null'))

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Page_Sign in  Google accounts/span_Yes'))

WebUI.delay(20)

WebUI.switchToWindowIndex(0)