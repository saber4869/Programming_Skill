import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import javax.swing.Spring;

import java.awt.Color;

/**
 * This class is output section
 * which receive an 2-dimension array and convert the array to a RGB array.
 * Every element in the result array is specified to a color
 * making a colorful map to indicate the density of hare and puma.
 * @author Guo Zheng
 * @version 3.0
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
	 * @param resultArray the density of either hare or puma in a 2-dimension array
	 * @param animal hare uses pink color, puma uses blue 
	 * @param T the specific cycle that need to write to a ppm file 
	 */	
	public void WritePPM(double[][] resultArray,String animal,int T) throws IOException
	{	
		this.width = resultArray.length;
		this.height = resultArray[0].length;
		this.pixelColor = new Color[height][width];
		
		//set six pink colors for hare
		Color white = Color.WHITE;	
		Color pink1 = new Color(255,174,185);
		Color pink2 = new Color(255,174,185);
		Color pink3 = new Color(255,110,180);
		Color pink4 = new Color(238,106,167);
		Color pink5 = new Color(238,18,137);
		Color deeppink = new Color(139,10,80);
		
		//set six blue colors for puma
		Color blue1 = new Color(175,238,238);
		Color blue2 = new Color(173,216,230);
		Color blue3 = new Color(135,206,250);
		Color blue4 = new Color(0,191,255);
		Color blue5 = new Color(30,144,255);
		Color deepblue = new Color(70,130,180);
		
		if(animal == "hare") 
		{
			//assign different depth of color for each pixel of hare array
			for (i = 0; i < width; i++)
			{
				for (j = 0; j < height; j++)
				{
					if(resultArray[i][j]<0.1)
					{
						pixelColor[i][j] = white;
					}
					else if(resultArray[i][j]>=0.1 && resultArray[i][j]<0.5)
					{
						pixelColor[i][j] = pink1;
					}
					else if(resultArray[i][j]>=0.5 && resultArray[i][j]<1.5)
					{
						pixelColor[i][j] = pink2;
					}
					else if(resultArray[i][j]>=1.5 && resultArray[i][j]<2.5)
					{
						pixelColor[i][j] = pink3;
					}
					else if(resultArray[i][j]>=2.5 && resultArray[i][j]<3.5)
					{
						pixelColor[i][j] = pink4;
					}
					else if(resultArray[i][j]>=3.5 && resultArray[i][j]<4.5)
					{
						pixelColor[i][j] = pink5;
					}
					else if(resultArray[i][j]>=4.5)
					{
						pixelColor[i][j] = deeppink;
					}
					}					
				}
		}
		else
		{
			//assign different depth of color for each pixel of puma array
			for (i = 0; i < width; i++)
			{
				for (j = 0; j < height; j++)
				{
					if(resultArray[i][j]<0.1)
					{
						pixelColor[i][j] = white;
					}
					if(resultArray[i][j]>=0.1 && resultArray[i][j]<0.5)
					{
						pixelColor[i][j] = blue1;
					}
					if(resultArray[i][j]>=0.5 && resultArray[i][j]<1.5)
					{
						pixelColor[i][j] = blue2;
					}
					if(resultArray[i][j]>=1.5 && resultArray[i][j]<2.5)
					{
						pixelColor[i][j] = blue3;
					}
					if(resultArray[i][j]>=2.5 && resultArray[i][j]<3.5)
					{
						pixelColor[i][j] = blue4;
					}
					if(resultArray[i][j]>=3.5 && resultArray[i][j]<4.5)
					{
						pixelColor[i][j] = blue5;
					}
					if(resultArray[i][j]>=4.5)
					{
						pixelColor[i][j] = deepblue;
					}
					}					
				}
		}
	    //specify filename by animal and cycle
		String filename = animal + "output" + T + ".ppm";
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