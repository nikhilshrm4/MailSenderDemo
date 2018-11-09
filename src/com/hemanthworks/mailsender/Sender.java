package com.hemanthworks.mailsender;

import java.io.FileReader;
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
		Properties machines = loadMachinesUsing();
		JenkinsClient client = new JenkinsClient("Kedarnath_BuildStreet",jobOwners,machines);
		List<Job> jobs = client.getViewJobs();	
		BuildStreetReport report = new BuildStreetReport(jobs, client);
		report.prepareReport();
		OpenTextMailClient mailClient = new OpenTextMailClient("sharman@opentext.com", "bhjkbhjvgj");
	    boolean result = mailClient.sendMail("sharman@opentext.com", report.toHtml(), "Today's BuildStreet Report");
	    System.out.println(result);
		// OTCordys-IND-Kedarnath@opentext.com
	}
	
	private static Properties loadProperties()
	{
		Properties properties = new Properties();
		try
		{
			FileReader f = new FileReader("C:\\Users\\sharman\\MailSender\\src\\com\\hemanthworks\\mailsender\\JobOwners.properties");
			properties.load(f);
			return properties;
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private static Properties loadMachinesUsing()
	{
		Properties properties = new Properties();
		try
		{
			FileReader f = new FileReader("C:\\Users\\sharman\\MailSender\\src\\com\\hemanthworks\\mailsender\\MachineUsing.properties");
			properties.load(f);
			return properties;
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
