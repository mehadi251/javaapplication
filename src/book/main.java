package book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
public class main {
	 public static void main(String []args) throws Exception {
		 String fileName = "input.txt";
		 String file="book-info-converter.properties";
		 String s1,s2;
		 String[] splited=null;
		 BufferedReader in = null;
		 try {
		     in = new BufferedReader(new FileReader(file));
		     String read = null;
		     while ((read = in.readLine()) != null) {
		         splited = read.split("\\=");
		         for (String part : splited) {
		            // System.out.println(part);
		         }
		     }
		 } catch (IOException e) {
		     System.out.println("There was a problem: " + e);
		     e.printStackTrace();
		 } finally {
		     try {
		         in.close();
		     } catch (Exception e) {
		     }
		 }
		 
		 System.out.println(splited[1]);
		 
		  if (args.length > 0) { 
		    fileName = args[0];
		  }
		  System.out.println("Reading input ...\r\n" + 
		  		"++++");
		  System.out.println( usingBufferedReader( fileName ) );
		  System.out.println("----");
		  System.out.println("Guessing " + 
		  		"text format ...");
		  
		  
		// parsing file "JSONExample.json"
		  try {
			  
			  
	        Object obj = new JSONParser().parse(new FileReader(fileName));
	         
	        // typecasting obj to JSONObject
	        JSONObject jo = (JSONObject) obj;
	        System.out.println("The Book data is in " + 
			  		"JSON " +"format ...");
	        System.out.println(splited[1]);
	        if(splited[1].equals("json")) {
	        	System.out.println("Converting to " + 
				  		"JSON " +"format ...");
			  System.out.println("Here is the output ...\r\n" + 
				  		"++++");
	        	System.out.println( usingBufferedReader( fileName ) );
	        	 System.out.println("----");
	        	return;
	        	}
	        else {
		  System.out.println("Converting to " + 
			  		"TXT " +"format ...");
		  System.out.println("Here is the output ...\r\n" + 
			  		"++++");
	         JSONObject ji= (JSONObject)jo.get("book");
	        // getting firstName and lastName
	        String firstName = (String) ji.get("name");
	        
	         
	        System.out.println("name"+": "+firstName);
	        System.out.print("authors: ");
	        ArrayList<String> list = new ArrayList<String>();     
	        JSONArray ja = (JSONArray) ji.get("authors");
	        int len = ja.size();
	        if (ja != null) { 
	           //int len =;
	           for (int i=0;i<len;i++){ 
	            list.add(ja.get(i).toString());
	            System.out.print(list.get(i));
	            if(i==len-1)break;
	            System.out.print(", ");
	           } 
	        } 
	        String lastName = (String) ji.get("published-date");
	        System.out.println("\npublished-date"+": "+lastName);}
	}
		  catch (Exception e) {
			  System.out.println("The Book data is in " + 
				  		"TXT " +"format ...");
			  if(splited[1].equals("txt")) {
		        	System.out.println("Converting to " + 
					  		"TXT " +"format ...");
				  System.out.println("Here is the output ...\r\n" + 
					  		"++++");
		        	System.out.println( usingBufferedReader( fileName ) );
		        	 System.out.println("----");
		        	return;
		        	}
		        else {
			  System.out.println("Converting to " + 
				  		"JSON " +"format ...");
			  System.out.println("Here is the output ...\r\n" + 
				  		"++++");
		         
		  
	    }}
		  System.out.println("----");
	 }
		 
		  
	   
	 private static String usingBufferedReader(String filePath)
	    {
	        StringBuilder contentBuilder = new StringBuilder();
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
	        {
	 
	            String sCurrentLine;
	            while ((sCurrentLine = br.readLine()) != null)
	            {
	                contentBuilder.append(sCurrentLine).append("\n");
	            }
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        return contentBuilder.toString();
	    }

	 
}
