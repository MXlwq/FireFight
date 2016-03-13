package com.wsy.model;

public class Dispatch {
	private int DispatchId;
	private String TypeId;
	private String LevelId;
	private String FireFighterNum;
	private String Equipment;
	
	private String Frequency;
	private String Confidence;
	
	
	public int getDispatchId() {
		return DispatchId;
	}
	public void setDispatchId(int DispatchId) {
		this.DispatchId = DispatchId;
	}
	
	public String getTypeId() {
		return TypeId;
	}
	public void setTypeId(String TypeId) {
		this.TypeId= TypeId;
	}
	
	public String getLevelId() {
		return LevelId;
	}
	public void setLevelId(String LevelId) {
		this.LevelId= LevelId;
	}
	
	public String getFireFighterNum() {
		return FireFighterNum;
	}
	public void setFireFighterNum(String FireFighterNum) {
		this.FireFighterNum= FireFighterNum;
	}
	public String getEquipment() {
		return Equipment;
	}
	public void setEquipment(String Equipment) {
		this.Equipment= Equipment;
	}
	
	
	
	public String getFrequency() {
		return Frequency;
	}
	public void setFrequency(String Frequency) {
		this.Frequency = Frequency;
	}
	
	public String getConfidence() {
		return Confidence;
	}
	public void setConfidence(String Confidence) {
		this.Confidence = Confidence;
	}
	
}
