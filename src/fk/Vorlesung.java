package fk;

import java.util.ArrayList;

public class Vorlesung {

	private String name;
	private String fachrichtung;
	private boolean master;
	private int ects_points;
	private ArrayList<String> fachrichtungen = new ArrayList<String>();
	
	
	public Vorlesung(){
		
	}
	
	public void setArrayList (){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFachrichtung() {
		return fachrichtung;
	}

	public void setFachrichtung(String fachrichtung) {
		this.fachrichtung = fachrichtung;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	public int getEcts_points() {
		return ects_points;
	}

	public void setEcts_points(int ects_points) {
		this.ects_points = ects_points;
	}
	
	
}
