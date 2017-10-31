package com.animal;
/**********************************************
* 2017-10-16 FuYu create the class
*
***********************************************/
public class Puma {
	
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.animal
	 * @author: Fu Yu  
	 * @date: 16/10/2017
	 */
	private double location[][];
	int numOfPuma;
	private double birthRate = 0.02; //b
	private double diffusionRate = 0.2; //l
	private double mortalityRate = 0.06; //m
	
	
	public Puma(){
		
		
	}

	public double[][] getLocation() {
		return location;
	}

	public void setLocation(double[][] location) {
		this.location = location;
	}

	public int getNumOfPuma() {
		return numOfPuma;
	}

	public void setNumOfPuma(int numOfPuma) {
		this.numOfPuma = numOfPuma;
	}

	public double getBirthRate() {
		return birthRate;
	}
	public void setBirthRate(double birthRate) {
		this.birthRate = birthRate;
	}
	public double getDiffusionRate() {
		return diffusionRate;
	}
	public void setDiffusionRate(double diffusionRate) {
		this.diffusionRate = diffusionRate;
	}
	public double getMortalityRate() {
		return mortalityRate;
	}
	public void setMortalityRate(double mortalityRate) {
		this.mortalityRate = mortalityRate;
	}
	
}
