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

// To Launch Browser
WebUI.openBrowser('')

//To Launch Application
WebUI.navigateToUrl('https://www.lazada.com.my/')

//Validating Application Launched Successfully & has a Valid Title

String browser_title = WebUI.getWindowTitle()
if(browser_title == 'Lazada.com.my: Best Online Shopping in Malaysia'){
	System.out.println("Application Launched Successfully")
}
else{
	System.out.println("Application failed to Launch Launch")
}


//To Maximize Browser Window
WebUI.maximizeWindow()

//To Navigate Login Screen
WebUI.click(findTestObject('Page_Lazadacommy Best Online Shopping in Malaysia/a_LOGIN'))

//To Perform Google Login
WebUI.click(findTestObject('Object Repository/Page_Lazadacommy Online Shopping Malaysia -_7b9812/button_Google'))

//To Switch Control Google Login Window
WebUI.switchToWindowTitle('Sign in – Google accounts')

WebUI.setText(findTestObject('Object Repository/Page_Sign in  Google accounts/input_Lazada Firebase Production_identifier'), 
    'deepjadon20@gmail.com')

WebUI.click(findTestObject('Object Repository/dummy/Page_Sign in  Google accounts/div_Next_VfPpkd-RLmnJb'))

WebUI.setText(findTestObject('Object Repository/Page_Sign in  Google accounts/input_Too many failed attempts_password'), 
    'Secure@123')

WebUI.click(findTestObject('Object Repository/dummy/Page_Sign in  Google accounts/div_Next_VfPpkd-RLmnJb_1'))

WebUI.delay(5)

WebUI.switchToWindowIndex(0)

