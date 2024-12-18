import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys

WebUI.comment('Make Appointment - with input mandatory field')

WebUI.openBrowser(GlobalVariable.G_SiteURL)

WebUI.callTestCase(findTestCase('Step Login/Login'), [('Username') : 'John Doe', ('Password') : 'ThisIsNotAPassword'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Input semua data')


WebUI.selectOptionByLabel(findTestObject('Page_CuraAppointment/lst_Facility'), 'Seoul CURA Healthcare Center', false)

WebUI.check(findTestObject('Page_CuraAppointment/chk_Readmission'))

WebUI.check(findTestObject('Page_CuraAppointment/chk_None'))

WebUI.setText(findTestObject('Page_CuraAppointment/txt_Comment'), 'Semoga jadwal tidak bentrok')

WebUI.click(findTestObject('Page_CuraAppointment/btn_BookAppointment'))

WebUI.comment('Menampilkan error message, mandatory field harus diiisi')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CURA Healthcare Service/datepicker datepicker-dropdown'), 
    0)

WebUI.closeBrowser()
