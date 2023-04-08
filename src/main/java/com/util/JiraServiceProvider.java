package com.util;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Component.FluentCreate;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraServiceProvider {
	
	public JiraClient jira;
	public String project;
	
	
	public JiraServiceProvider(String jiraUrl, String username, String password, String project) {
		BasicCredentials creds = new BasicCredentials(username, password);
		jira = new JiraClient(jiraUrl, creds);
		this.project = project;
	}
	
	
	public void createJiraTicket(String issueType, String suumary, String discription, String reporterName) throws JiraException {
		try{
			net.rcarz.jiraclient.Issue.FluentCreate fluentCreate = jira.createIssue(project, issueType);
			fluentCreate.field(Field.SUMMARY, suumary);
			fluentCreate.field(Field.DESCRIPTION, discription);
			Issue newIssue = fluentCreate.execute();
			System.out.println("new issue created in jira with ID: " + newIssue);
		} catch (JiraException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
