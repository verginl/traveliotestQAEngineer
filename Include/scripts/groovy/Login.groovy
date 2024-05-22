import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class Login {

	@Given("User berada di halaman login")
	def halaman_login() {
		WebUI.openBrowser(GlobalVariable.url)
		WebUI.click(findTestObject('Object Repository/btnCloseModal'))
		WebUI.click(findTestObject('Object Repository/btnLogin'))
	}

	@When("User input email {string} dan password {string}")
	def input_credential(String email, String password) {
		WebUI.setText(findTestObject('Object Repository/txtEmail'), email)
		WebUI.setText(findTestObject('Object Repository/txtPassword'), password)
	}

	@And("user klik button masuk")
	def klik_button_masuk() {
		WebUI.click(findTestObject('Object Repository/btnMasuk'))
	}

	@Then("Berhasil masuk ke halaman beranda")
	def halaman_beranda() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/lblName'), 10)
		WebUI.closeBrowser()
	}

	@Then("Menampilkan popup gagal login")
	def popup_gagallogin() {
		WebUI.verifyElementText(findTestObject('Object Repository/alertGagal'), "Email atau password salah")
		WebUI.closeBrowser()
	}
}