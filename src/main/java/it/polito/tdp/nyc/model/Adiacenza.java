package it.polito.tdp.nyc.model;

public class Adiacenza implements Comparable<Adiacenza>   {

	City c1;
	City c2;
	double peso;
	public Adiacenza(City c1, City c2, double peso) {
		super();
		this.c1 = c1;
		this.c2 = c2;
		this.peso = peso;
	}
	public City getC1() {
		return c1;
	}
	public void setC1(City c1) {
		this.c1 = c1;
	}
	public City getC2() {
		return c2;
	}
	public void setC2(City c2) {
		this.c2 = c2;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	@Override
	public int compareTo(Adiacenza altra) {
		// TODO Auto-generated method stub
		return (int) (this.peso - altra.peso);
	}
	
	
	
	
}
