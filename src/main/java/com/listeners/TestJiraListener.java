package com.listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.util.JiraPolicy;
import com.util.JiraServiceProvider;

import net.rcarz.jiraclient.JiraException;

public class TestJiraListener implements ITestListener{
	
	
	
	//@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void onTestFailure(ITestResult result) {

		JiraPolicy jiraPolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class);
		boolean isTicketReady = jiraPolicy.logTicketReady();
		if(isTicketReady) {
			//raise  jira ticket
			System.err.println("is ticket ready for JIRA: " + isTicketReady);
			JiraServiceProvider jiraSp = new JiraServiceProvider("https://naveenautomationlabs.atlassion.net", 
					"naveenanimation20@gmail.com", "", "TA");
			String issueSUmmary = result.getMethod().getConstructorOrMethod().getMethod().getName() + "got failed due to some assertion or exception";
			String issueDiscription = result.getThrowable().getMessage() + "\n";
			issueDiscription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
			try {
				jiraSp.createJiraTicket("Bug", issueSUmmary, issueDiscription, "Naveen");
			} catch (JiraException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	//@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	//@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
	
	
	
	

}
