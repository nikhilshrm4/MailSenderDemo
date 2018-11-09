package com.hemanthworks.jenkinsreport;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastBuild {
	protected String builtOn;
	
	public LastBuild() {
		// empty construtor
	}

	public String getBuiltOn() {
		return builtOn;
	}

	public void setBuiltOn(String builtOn) {
		this.builtOn = builtOn;
	}
}
