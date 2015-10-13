package com.m2i.formation.DNA;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private List<Protein> genome = new ArrayList<Protein>();
	private List<DNA> chromosomes = new ArrayList<DNA>();
	private List<RNA> rnas = new ArrayList<RNA>();
	
	public List<Protein> getGenome() {
		return genome;
	}	
	public List<DNA> getChromosomes() {
		return chromosomes;
	}
	public List<RNA> getRnas() {
		return rnas;
	}
	
	public void traduction() {
		
	}
	
	public void transcription() {
		
	}
	
}
