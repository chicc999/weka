package com.njust.edu.lyx.wdbc.dal.dataProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.njust.edu.lyx.wdbc.dal.dataObject.Record;

import weka.core.matrix.DoubleVector;

public class Daos {
	private ArrayList<Record> trainList = new ArrayList<Record>();
	private ArrayList<Record> testList = new ArrayList<Record>();
	private static Daos singleton;
	private String dataFilePath = "src/main/resources/wdbc.data";
	private Map<Integer, Double> maxValue = new HashMap<Integer, Double>();
	private Map<Integer, Double> minValue = new HashMap<Integer, Double>();

	public Daos() throws Exception {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(dataFilePath);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			String line = "";
			int count = 0;
			String[] arrs = null;
			while ((line = br.readLine()) != null) {
				count++;
				arrs = line.split(",");
				Record record = new Record(arrs[0], arrs[1], arrs[3], arrs[25], arrs[26]);
				for (int i = 2; i < arrs.length; i++) {

					if (maxValue.get(i)==null || Double.parseDouble(arrs[i]) > maxValue.get(i)) {
						maxValue.put(i, Double.parseDouble(arrs[i]));
					}
					if ( minValue.get(i)==null || Double.parseDouble(arrs[i]) < minValue.get(i)) {
						minValue.put(i, Double.parseDouble(arrs[i]));
					}

				}

				if (count < 400) {
					trainList.add(record);
				} else {
					testList.add(record);
				}
			}
		} finally {
			br.close();
			isr.close();
			fis.close();
		}

		for(Record record:trainList)
		{
			//TODO
			double meanTexture = Double.parseDouble(record.getMeanTexture());
			double interval = (maxValue.get(3)-minValue.get(3))/10;
			if(interval==0)
				continue;
			int newValue =(int)((meanTexture-minValue.get(3))/interval+0.5);
			Double value = newValue*interval+minValue.get(3);
			record.setMeanTexture(value.toString());
			
			meanTexture = Double.parseDouble(record.getWorstArea());
			interval = (maxValue.get(25)-minValue.get(25))/10;
			if(interval==0)
				continue;
			 newValue =(int)((meanTexture-minValue.get(25))/interval+0.5);
			value = newValue*interval+minValue.get(25);
			record.setWorstArea(value.toString());
			
			meanTexture = Double.parseDouble(record.getWorstSmoothness());
			interval = (maxValue.get(26)-minValue.get(26))/10;
			if(interval==0)
				continue;
			newValue =(int)((meanTexture-minValue.get(26))/interval+0.5);
			value = newValue*interval+minValue.get(26);
			record.setWorstSmoothness(value.toString());
		}
		
		for(Record record:testList)
		{
			//TODO
			double meanTexture = Double.parseDouble(record.getMeanTexture());
			double interval = (maxValue.get(3)-minValue.get(3))/10;
			if(interval==0)
				continue;
			int newValue =(int)((meanTexture-minValue.get(3))/interval+0.5);
			Double value = newValue*interval+minValue.get(3);
			record.setMeanTexture(value.toString());
			
			meanTexture = Double.parseDouble(record.getWorstArea());
			interval = (maxValue.get(25)-minValue.get(25))/10;
			if(interval==0)
				continue;
			 newValue =(int)((meanTexture-minValue.get(25))/interval+0.5);
			value = newValue*interval+minValue.get(25);
			record.setWorstArea(value.toString());
			
			meanTexture = Double.parseDouble(record.getWorstSmoothness());
			interval = (maxValue.get(26)-minValue.get(26))/10;
			if(interval==0)
				continue;
			newValue =(int)((meanTexture-minValue.get(26))/interval+0.5);
			value = newValue*interval+minValue.get(26);
			record.setWorstSmoothness(value.toString());
		}
	}

	public static Daos getInstance() throws Exception {
		if (singleton == null) {
			synchronized (Daos.class) {
				if (singleton == null) {
					singleton = new Daos();
				}
			}
		}
		return singleton;
	}

	public ArrayList<Record> getTrainList() {
		return trainList;
	}

	public ArrayList<Record> getTestList() {
		return testList;
	}

	public static void main(String[] args) {
		try {
			getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
