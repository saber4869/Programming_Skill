package com.animal;

public class puma {
	
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
	private double birthRate = 0.02; //b
	private double diffusionRate = 0.2; //l
	private double mortalityRate = 0.06; //m
	
	
	public puma(){
		
		
	}
	public void setnum(int num){
		this.num = num;
		
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
