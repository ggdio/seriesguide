package br.com.unicorp.unij.geral;

import java.io.Serializable;
import java.util.Date;

import br.com.devteam.sguide.bean.render.annotation.SchemaDescription;
import br.com.devteam.sguide.bean.render.annotation.SchemaSecret;

public class SimpleBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@SchemaDescription
	private String name;
	private Date dateOfWhatever;
	@SchemaSecret
	private int numberOfSomething;
	//Inverse relation
	private ComplexBean complexBean;

	public String getName() {
		return name;
	}

	public Date getDateOfWhatever() {
		return dateOfWhatever;
	}

	public Integer getNumberOfSomething() {
		return numberOfSomething;
	}
	
	public ComplexBean getComplexBean() {
		return complexBean;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfWhatever(Date dateOfWhatever) {
		this.dateOfWhatever = dateOfWhatever;
	}

	public void setNumberOfSomething(Integer numberOfSomething) {
		this.numberOfSomething = numberOfSomething;
	}
	
	public void setComplexBean(ComplexBean complexBean) {
		this.complexBean = complexBean;
	}

}