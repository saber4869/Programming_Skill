package com.output;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.awt.Color;

	
public class WriteToPPM {
	
	int i,j;
	private int width;
	private int height;
	private Color[][] pixelColor; 
	
	public void WritePPM(double[][] resultArray) throws IOException
	{	
		this.width = resultArray.length;
		this.height = resultArray[0].length;
		//Color class
		this.pixelColor = new Color[height][width];
		
		Color black = Color.BLACK;	
		Color pink = Color.PINK;
		
		//assign color for each pixel
		for (i = 0; i < width; i++)
		{
			for (j = 0; j < height; j++)
			{
				if(resultArray[i][j]>1)
				{
					pixelColor[i][j] = black;
				}
				else
				{
					pixelColor[i][j] = pink;
				}
				//need to decide color
				}					
			}
	
		//write  RGB color into PPM file
		BufferedWriter writeppm = new BufferedWriter(new FileWriter(".\\outputlist\\out.ppm"));
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