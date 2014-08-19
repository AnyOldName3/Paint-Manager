import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileIO
{
	public static String readBinFile(String filePath)
	{
		byte[] fileBytes = {00};
		try
		{
			fileBytes = Files.readAllBytes(Paths.get(filePath));
		}
		catch(IOException e)
		{
			System.err.println("Error reading Challenge:");
			e.printStackTrace();
		}
		if(fileBytes[0] != 0x7C)
			return "fail";
		String loaded = "";
		for(byte currentByte : fileBytes)
		{
			//Uses a bitmask to get around the fact that bytes are considered to be signed in Java
			int unsigned = currentByte&0xFF;
			loaded = loaded + (char)unsigned;
		}
		return loaded;
	}
	
	public static boolean writeBinFile(String filePath, String file)
	{
		char[] fileChars = file.toCharArray();
		byte[] fileBytes = new byte[fileChars.length];
		for(int i=0; i<fileChars.length; i++)
		{
			fileBytes[i] = (byte)(int)fileChars[i];
		}
		FileOutputStream outStream;
		try
		{
			outStream = new FileOutputStream(filePath);
			outStream.write(fileBytes);
			outStream.close();
		}
		catch(IOException e)
		{
			System.err.println("Error writing Challenge: ");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String readFile(String filePath)
	{
		String loaded = "";
		String NL = System.getProperty("line.separator");
		BufferedReader read = null;
		try
		{
			String loading;
			read = new BufferedReader(new FileReader(filePath));
			loaded = read.readLine();
			while((loading = read.readLine()) != null)
			{
				loaded = loaded+NL+loading;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(read != null)
				{
					read.close();
				}
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		return loaded;
	}
	
	public static boolean writeFile(String filePath, String file)
	{
		//Declares new Buffered Writer object
		BufferedWriter writer = null;
		File textFile = new File(filePath);
		try
		{
			//Sets the value of the buffered writer object, including the name of the output file
			writer = new BufferedWriter(new FileWriter(textFile));
			writer.write(file);
		}
		//Tidies up any errors occurring in the try block, and prints 'Write Error' only if there were errors
		catch(IOException e)
		{
			System.err.println("Write Error");
			return false;
		}
		finally
		{
			//Closes the writer, ending the file
			try
			{
				if(writer != null)
					writer.close();
			}
			//Prints 'A different write error' if the writer cannot be closed
			catch(IOException e)
			{
				System.err.println("A different write error");
				return false;
			}
		}
		return true;
	}
}