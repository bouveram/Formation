package com.m2i.formation.DNA;

public class Codon {
	
	private RNABase[] rnaBases = new RNABase[3];

	public RNABase[] getRnaBases() {
		return rnaBases;
	}
	
	private AminoAcid aminoAcid;

	public AminoAcid getAminoAcid() {
		return aminoAcid;
	}

	public void setAminoAcid(AminoAcid aminoAcid) {
		this.aminoAcid = aminoAcid;
	}
	
	
}
