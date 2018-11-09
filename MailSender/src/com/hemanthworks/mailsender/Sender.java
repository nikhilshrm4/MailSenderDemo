package com.hemanthworks.mailsender;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.hemanthworks.jenkinsreport.BuildStreetReport;
import com.hemanthworks.jenkinsreport.JenkinsClient;
import com.hemanthworks.jenkinsreport.Job;


public class Sender
{
	public static void main(String[] args)
	{
		Properties jobOwners = loadProperties();
		JenkinsClient client = new JenkinsClient("Kedarnath_BuildStreet",jobOwners);
		List<Job> jobs = client.getViewJobs();	
		BuildStreetReport report = new BuildStreetReport(jobs, client);
		report.prepareReport();
		OpenTextMailClient mailClient = new OpenTextMailClient("sharman@opentext.com", "TensorFlow2017!");
	    boolean result = mailClient.sendMail("sharman@opentext.com", report.toHtml(), "Today's BuildStreet Report");
	    System.out.println(result);
		// OTCordys-IND-Kedarnath@opentext.com
	}
	
	private static Properties loadProperties()
	{
		Properties properties = new Properties();
		try
		{
			properties.load(Sender.class.getResourceAsStream("jobOwners.properties"));
			return properties;
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
