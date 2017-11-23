package com.output;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.Spring;

import com.algorithm.CalculateModel;

import java.awt.Color;

/**
 * This class is output section
 * which receive an 2-dimension array and convert the array to a RGB array.
 * Every element in the result array is specified to a color
 * making a colorful map to indicate the density of hare and puma.
 * @author Guo Zheng
 */	
public class WriteToPPM {
	
	int i,j;//iteration index
	private int width;//get from resultArray width
	private int height;//get from resultArray height
	private Color[][] pixelColor; //create color array to store RGB value
	
	
	
	/**
	 * This method specify the density of each pixel in a certain range to a color
	 * and create a new color array for each pixel which store its RGB value.
	 * Then write this array to a ppm file which can be displayed by a GIMP
	 * @Package: com.output
	 * @throws: IOException 
	 * @param resultArray the density of either hare or puma in a 2-dimension array
	 * @param animal hare uses pink color, puma uses blue 
	 * @param T the specific cycle that need to write to a ppm file
	 * @ @date: 31/10/2017 
	 */	
	public void WritePPM(double[][] resultArray,String animal,int T) throws IOException
	{	
		this.height = resultArray.length;
		this.width = resultArray[0].length;
		this.pixelColor = new Color[height][width];
		
		//set pink colors for hare
		Color white = Color.WHITE;		
		Color pink1 = new Color(255,217,236);	
		Color pink2 = new Color(255,149,202);
		Color pink3 = new Color(255,121,188);
		Color pink4 = new Color(255,96,175);
		Color pink5 = new Color(255,53,154);
		Color pink6 = new Color(255,0,128);
		Color pink7 = new Color(240,0,120);
		Color pink8 = new Color(217,0,108);
		Color pink9 = new Color(191,0,96);
		Color pink10 = new Color(159,0,80);
		Color pink11 = new Color(96,0,48);
		
		//set blue colors for puma
		Color blue1 = new Color(196,225,255);
		Color blue2 = new Color(151,203,255);
		Color blue3 = new Color(132,193,255);
		Color blue4 = new Color(151,203,255);
		Color blue5 = new Color(132,193,255);
		Color blue6 = new Color(102,179,255);
		Color blue7 = new Color(70,163,255);
		Color blue8 = new Color(40,148,255);
		Color blue9 = new Color(0,128,255);
		Color blue10 = new Color(0,114,227);
		Color blue11 = new Color(0,0,147);
		if(animal == "hare") 
		{
			//assign different depth of color for each pixel of hare array
			for (i = 0; i < height; i++)
			{
				for (j = 0; j < width; j++)
				{
					if(resultArray[i][j]<0.1)
					{
						pixelColor[i][j] = white;
					}
					else if(resultArray[i][j]>=0.1 && resultArray[i][j]<0.5)
					{
						pixelColor[i][j] = pink1;
					}
					else if(resultArray[i][j]>=0.5 && resultArray[i][j]<1.0)
					{
						pixelColor[i][j] = pink2;
					}
					else if(resultArray[i][j]>=1.0 && resultArray[i][j]<1.5)
					{
						pixelColor[i][j] = pink3;
					}
					else if(resultArray[i][j]>=1.5 && resultArray[i][j]<2.0)
					{
						pixelColor[i][j] = pink4;
					}
					else if(resultArray[i][j]>=2.0 && resultArray[i][j]<2.5)
					{
						pixelColor[i][j] = pink5;
					}
					else if(resultArray[i][j]>=2.5 && resultArray[i][j]<3.0)
					{
						pixelColor[i][j] = pink6;
					}
					else if(resultArray[i][j]>=3.0 && resultArray[i][j]<3.5)
					{
						pixelColor[i][j] = pink7;
					}
					else if(resultArray[i][j]>=3.5 && resultArray[i][j]<4.0)
					{
						pixelColor[i][j] = pink8;
					}
					else if(resultArray[i][j]>=4.0 && resultArray[i][j]<4.5)
					{
						pixelColor[i][j] = pink9;
					}
					else if(resultArray[i][j]>=4.5 && resultArray[i][j]<5.0)
					{
						pixelColor[i][j] = pink10;
					}
					else if(resultArray[i][j]>=5.0)
					{
						pixelColor[i][j] = pink11;
					}
					}					
				}
		}
		else
		{
			//assign different depth of color for each pixel of puma array
			for (i = 0; i < height; i++)
			{
				for (j = 0; j < width; j++)
				{
					if(resultArray[i][j]<0.1)
					{
						pixelColor[i][j] = white;
					}
					else if(resultArray[i][j]>=0.1 && resultArray[i][j]<0.5)
					{
						pixelColor[i][j] = blue1;
					}
					else if(resultArray[i][j]>=0.5 && resultArray[i][j]<1.0)
					{
						pixelColor[i][j] = blue2;
					}
					else if(resultArray[i][j]>=1.0 && resultArray[i][j]<1.5)
					{
						pixelColor[i][j] = blue3;
					}
					else if(resultArray[i][j]>=1.5 && resultArray[i][j]<2.0)
					{
						pixelColor[i][j] = blue4;
					}
					else if(resultArray[i][j]>=2.0 && resultArray[i][j]<2.5)
					{
						pixelColor[i][j] = blue5;
					}
					else if(resultArray[i][j]>=2.5 && resultArray[i][j]<3.0)
					{
						pixelColor[i][j] = blue6;
					}
					else if(resultArray[i][j]>=3.0 && resultArray[i][j]<3.5)
					{
						pixelColor[i][j] = blue7;
					}
					else if(resultArray[i][j]>=3.5 && resultArray[i][j]<4.0)
					{
						pixelColor[i][j] = blue8;
					}
					else if(resultArray[i][j]>=4.0 && resultArray[i][j]<4.5)
					{
						pixelColor[i][j] = blue9;
					}
					else if(resultArray[i][j]>=4.5 && resultArray[i][j]<5.0)
					{
						pixelColor[i][j] = blue10;
					}
					else if(resultArray[i][j]>=5.0)
					{
						pixelColor[i][j] = blue11;
					}
					}					
				}
		}
	    //specify filename by animal and cycle T
		
		String  filename = null;//String filename = "./outputlist/" + animal + "output" + T + ".ppm"; //file path on local
		if(T<1000){
			filename = "./outputlist/" + animal + "output00" + T + ".ppm";}
		else{
			filename = "./outputlist/" + animal + "output0" + T + ".ppm";
			//file path on cp-lab
		}
		//write  RGB color into PPM file
		BufferedWriter writeppm = new BufferedWriter(new FileWriter(filename));
		writeppm.write("P3");
		writeppm.newLine();
		writeppm.write(width + " " + height);
		writeppm.newLine();
		writeppm.write("255");
		writeppm.newLine();
		for(i = 0; i < pixelColor.length; i++){
			for(j = 0; j < pixelColor[i].length ; j++){
				writeppm.write(pixelColor[i][j].getRed()+" ");
				writeppm.write(pixelColor[i][j].getGreen()+" ");
				writeppm.write(pixelColor[i][j].getBlue()+"");
				if(j < pixelColor[i].length - 1)
					writeppm.write(" ");
			}
			writeppm.newLine();
		}
		writeppm.flush();
		writeppm.close();
		}
	}