package com.njust.edu.lyx.wdbc.dal.dataObject;

import java.util.ArrayList;
import java.util.List;

public class Record {
	private String id;
	private String diagnosis;
	private String meanTexture;
	private String worstArea;
	private String worstSmoothness;
	
	
	
	public Record(String id, String diagnosis, String meanTexture, String worstArea, String worstSmoothness) {
		super();
		this.id = id;
		this.diagnosis = diagnosis;
		this.meanTexture = meanTexture;
		this.worstArea = worstArea;
		this.worstSmoothness = worstSmoothness;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getMeanTexture() {
		return meanTexture;
	}
	public void setMeanTexture(String meanTexture) {
		this.meanTexture = meanTexture;
	}
	public String getWorstArea() {
		return worstArea;
	}
	public void setWorstArea(String worstArea) {
		this.worstArea = worstArea;
	}
	public String getWorstSmoothness() {
		return worstSmoothness;
	}
	public void setWorstSmoothness(String worstSmoothness) {
		this.worstSmoothness = worstSmoothness;
	}
	
	public ArrayList<String> getAttribute()
	{
		ArrayList<String> list = new ArrayList<String>();
		//list.add(id);
		list.add(meanTexture);
		list.add(worstArea);
		list.add(worstSmoothness);
		return list;
	}
	
	@Override
	public String toString() {
		return "Record [id=" + id + ", diagnosis=" + diagnosis + ", meanTexture=" + meanTexture + ", worstArea="
				+ worstArea + ", worstSmoothness=" + worstSmoothness + "]";
	}
	
}
