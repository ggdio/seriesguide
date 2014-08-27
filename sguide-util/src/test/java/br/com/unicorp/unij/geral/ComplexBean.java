package br.com.unicorp.unij.geral;

import javax.persistence.ConstraintMode;

import br.com.devteam.sguide.bean.render.annotation.SchemaSecret;

public class ComplexBean {
	
	private String fieldA;
	private Integer fieldB;
	private Boolean fieldC;
	private SimpleBean fieldD;
	@SchemaSecret
	private ConstraintMode mode;

	public String getFieldA() {
		return fieldA;
	}

	public Integer getFieldB() {
		return fieldB;
	}

	public Boolean getFieldC() {
		return fieldC;
	}

	public SimpleBean getFieldD() {
		return fieldD;
	}

	public void setFieldA(String fieldA) {
		this.fieldA = fieldA;
	}

	public void setFieldB(Integer fieldB) {
		this.fieldB = fieldB;
	}

	public void setFieldC(Boolean fieldC) {
		this.fieldC = fieldC;
	}

	public void setFieldD(SimpleBean fieldD) {
		this.fieldD = fieldD;
	}

}