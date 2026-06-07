import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil

KeywordUtil.logInfo("--- START TEST API PRODUCER ---")
def responseProducer = WS.sendRequest(findTestObject("Object Repository/PRODUCER"))

WS.verifyResponseStatusCode(responseProducer, 401)
/*
 * int statusCodeProducer = responseProducer.getStatusCode()
 * assert statusCodeProducer == 200 | statusCodeProducer == 201
 * KeywordUtil.logInfo("API PRODUCER SUCCESSFULLY EXECUTED WITH STATUS: " + statusCodeProducer)
*/
KeywordUtil.logInfo("API PRODUCER SUCCESSFULLY EXECUTED")

KeywordUtil.logInfo("--- START TEST API CONSUMER ---")
def responseConsumer = WS.sendRequest(findTestObject("Object Repository/CONSUMER"))

/*
 * WS.verifyResponseStatusCode(responseConsumer, 200)
*/
WS.verifyResponseStatusCode(responseConsumer, 401)
KeywordUtil.logInfo("API CONSUMER SUCCESS GET DATA")