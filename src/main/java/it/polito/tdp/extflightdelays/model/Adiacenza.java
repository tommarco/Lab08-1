package it.polito.tdp.extflightdelays.model;

public class Adiacenza {

	private Airport a1;
	private Airport a2;
	private int distanzaMedia;
	public Adiacenza(Airport a1, Airport a2, int distanzaMedia) {
		super();
		this.a1 = a1;
		this.a2 = a2;
		this.distanzaMedia = distanzaMedia;
	}
	public Airport getA1() {
		return a1;
	}
	public void setA1(Airport a1) {
		this.a1 = a1;
	}
	public Airport getA2() {
		return a2;
	}
	public void setA2(Airport a2) {
		this.a2 = a2;
	}
	public int getDistanzaMedia() {
		return distanzaMedia;
	}
	public void setDistanzaMedia(int distanzaMedia) {
		this.distanzaMedia = distanzaMedia;
	}
	
	
	
	 
	 
}
