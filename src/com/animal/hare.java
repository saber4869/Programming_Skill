package com.animal;


public class hare {
	/**   
	 * 
	 * 
	 * 
	 * @Package: com.animal
	 * @author: Fu Yu  
	 * @date: 16/10/2017
	 */
	private double xy[][];
	int num;
	
	private double birthRate = 0.08; //r
	private double predationRate = 0.04; //a
	private double diffusionRate = 0.2; //k
	
	public hare(){
		
		
	}
	public double[][] getXy() {
		return xy;
	}
	public void setXy(double xy[][]) {
		this.xy = xy;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
