package com.animal;

/**********************************************
* 2017-10-16 FuYu create the class
*
***********************************************/
public class Hare {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.animal
	 * @author: Fu Yu  
	 * @date: 16/10/2017
	 */
	private double location[][];
	int numOfHare;
	
	private double birthRate = 0.08; //r
	private double predationRate = 0.04; //a
	private double diffusionRate = 0.2; //k
	
	public Hare(){
		
		
	}

	public double[][] getLocation() {
		return location;
	}

	public void setLocation(double[][] location) {
		this.location = location;
	}

	public int getNumOfHare() {
		return numOfHare;
	}

	public void setNumOfHare(int numOfHare) {
		this.numOfHare = numOfHare;
	}

	public double getBirthRate() {
		return birthRate;
	}
	public void setBirthRate(double birthRate) {
		this.birthRate = birthRate;
	}
	public double getPredationRate() {
		return predationRate;
	}
	public void setPredationRate(double predationRate) {
		this.predationRate = predationRate;
	}
	public double getDiffusionRate() {
		return diffusionRate;
	}
	public void setDiffusionRate(double diffusionRate) {
		this.diffusionRate = diffusionRate;
	}
	
}
