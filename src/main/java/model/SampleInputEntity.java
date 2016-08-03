package model;

import lombok.Value;

@Value
public class SampleInputEntity {

	public SampleInputEntity(String[] args) {
		this.column1 = args[0];
		this.column2 = args[1];
		this.column3 = args[2];
	}
	
	private String column1;
	private String column2;
	private String column3;
}
