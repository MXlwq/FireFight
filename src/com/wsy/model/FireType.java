package com.wsy.model;

public class FireType {
	private int Firetypeid;
	private String FiretypeName;
	private String ComburentId;
	private String Frequency;
	private String Confidence;

	public int getFiretypeid() {
		return Firetypeid;
	}

	public void setFiretypeid(int Firetypeid) {
		this.Firetypeid = Firetypeid;
	}

	public String getComburentId() {
		return ComburentId;
	}

	public void setComburentId(String ComburentId) {
		this.ComburentId = ComburentId;
	}

	public String getFiretypeName() {
		return FiretypeName;
	}

	public void setFiretypeName(String FiretypeName) {
		this.FiretypeName = FiretypeName;
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
