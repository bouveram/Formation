package com.m2i.formation.DNA;

import java.util.ArrayList;
import java.util.List;

public class DNA extends Strand {

	private List<DNABase>dnaBases = new ArrayList<DNABase>();
	
	public List<DNABase> getDnaBases() {
		return dnaBases;
	}

	public DNA transposition() {
		return null;
	}
}
