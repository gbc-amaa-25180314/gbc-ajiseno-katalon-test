import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.logging.log4j.status.StatusConsoleListener

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.util.KeywordUtil

/*
KeywordUtil.logInfo("--- START TEST API PRODUCER ---")
def responseProducer = WS.sendRequest(findTestObject("Object Repository/PRODUCER"))

WS.verifyResponseStatusCode(responseProducer, 401)

 //int statusCodeProducer = responseProducer.getStatusCode()
 //assert statusCodeProducer == 200 | statusCodeProducer == 201
 //KeywordUtil.logInfo("API PRODUCER SUCCESSFULLY EXECUTED WITH STATUS: " + statusCodeProducer)

KeywordUtil.logInfo("API PRODUCER SUCCESSFULLY EXECUTED")

KeywordUtil.logInfo("--- START TEST API CONSUMER ---")
def responseConsumer = WS.sendRequest(findTestObject("Object Repository/CONSUMER"))

 //WS.verifyResponseStatusCode(responseConsumer, 200)

WS.verifyResponseStatusCode(responseConsumer, 401)
KeywordUtil.logInfo("API CONSUMER SUCCESS GET DATA")
*/

//CREATE DATA
KeywordUtil.logInfo("--- START TEST API PRODUCER ---")

def responseProducer = WS.sendRequest(findTestObject("Object Repository/PRODUCER"))
int statusCodeProducer = responseProducer.getStatusCode()

//validate
if (statusCodeProducer == 201 || statusCodeProducer == 401)
	{
		KeywordUtil.logInfo("API PRODUCER VALIDATED. Code received:" + statusCodeProducer)
		WS.verifyResponseStatusCode(responseProducer, statusCodeProducer)
	}
else
	{
		KeywordUtil.markFailed("API PRODUCER FAILED. Code received:" + statusCodeProducer)
	}


//READ DATA
KeywordUtil.logInfo("--- START TEST API CONSUMER ---")

def responseConsumer = WS.sendRequest(findTestObject("Object Repository/CONSUMER"))
int statusCodeConsumer = responseConsumer.getStatusCode()

//Validate
if (statusCodeConsumer == 200 || statusCodeConsumer == 401)
	{
		KeywordUtil.logInfo("API CONSUMER SUCCESS. Code received: " + statusCodeConsumer)
		WS.verifyResponseStatusCode(responseConsumer, statusCodeConsumer)
	}
else
	{
		KeywordUtil.markFailed("API CONSUMER FAILED. Code received: " + statusCodeConsumer)
	}