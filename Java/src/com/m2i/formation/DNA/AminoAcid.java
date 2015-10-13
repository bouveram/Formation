package com.m2i.formation.DNA;

public class AminoAcid {
	
	protected AminoAcid() {
	}
	
	private String longName;
	private String trigram;
	private char code;
	
	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getTrigram() {
		return trigram;
	}

	public void setTrigram(String trigram) {
		this.trigram = trigram;
	}

	public char getCode() {
		return code;
	}

	public void setCode(char code) {
		this.code = code;
	}

	public static AminoAcid factory(char code) {
		return null;
	}
}
