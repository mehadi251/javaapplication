package book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class main {
	 public static void main(String []args) throws Exception {
		 String fileName = "input_txt.txt";    //input file
		 String file="book-info-converter.properties";   //configuration file
		 String[] splited=null;
		
		 BufferedReader in = null;
		 try {                                                                    // configuration
		     in = new BufferedReader(new FileReader(file));                       // file
		     String read = null;                                                  // checking
		     while ((read = in.readLine()) != null) {                             // for
		         splited = read.split("\\=");                                     // txt or
		         for (String part : splited) {                                    // json
		            
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
		 
		
		 
		  if (args.length > 0) { 
		    fileName = args[0];
		  }
		  System.out.println("Reading input ...\r\n" + 
		  		"++++");
		  System.out.println( usingBufferedReader( fileName ) );
		  System.out.println("----");
		  System.out.println("Guessing " + 
		  		"text format ...");
		  
		  
		
		  try {
			  
			  
	        Object obj = new JSONParser().parse(new FileReader(fileName));
	         
	        // typecasting obj to JSONObject
	        JSONObject jo = (JSONObject) obj;
	        System.out.println("The Book data is in " +                                               //json format
			  		"JSON " +"format ...");
	        if(splited[1].equals("json")) {                                                        // json in configuration file so
	        	System.out.println("Converting to " +                                              // do nothing
				  		"JSON " +"format ...");
			  System.out.println("Here is the output ...\r\n" + 
				  		"++++");
	        	System.out.println( usingBufferedReader( fileName ) );
	        	 System.out.println("----");
	        	return;
	        	}
	        else {                                                                              // txt in configuration file so convert json to txt
		  System.out.println("Converting to " + 
			  		"TXT " +"format ...");
		  System.out.println("Here is the output ...\r\n" + 
			  		"++++");
	         JSONObject ji= (JSONObject)jo.get("book");
	        // getting Name and others
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
	        String date = (String) ji.get("published-date");
	        System.out.println("\npublished-date"+": "+date);}
	}
		  catch (Exception e) {
			  System.out.println("The Book data is in " +                                              // input file is in txt format
				  		"TXT " +"format ...");
			  if(splited[1].equals("txt")) {														// txt in configuration file so
		        	System.out.println("Converting to " + 											// do nothing
					  		"TXT " +"format ...");
				  System.out.println("Here is the output ...\r\n" + 
					  		"++++");
		        	System.out.println( usingBufferedReader( fileName ) );
		        	 System.out.println("----");
		        	return;
		        	}
		        else {																			// json in configuration file so 
			  System.out.println("Converting to " + 											// converting txt to json
				  		"JSON " +"format ...");
			  System.out.println("Here is the output ...\r\n" + 
				  		"++++");

			  String[] splited1=null;
				 BufferedReader in1 = null;
				 book book = new book();
			     
				 try {
				     in1 = new BufferedReader(new FileReader(fileName));
				     String read = null;
				    
				     
				     while ((read = in1.readLine()) != null) {
				         splited1 = read.split("\\:");
				         if(splited1[0].equals("Name")) {
				        	 book.setName(splited1[1]);
				         }
				         else if(splited1[0].equals("Author")) {
				        	 book.setAuthors(splited1[1]);
				         }
				         else if(splited1[0].equals("Published Date")) {
				        	 book.setPublisheddate(splited1[1]);
				         }
				     }
				 } catch (IOException e1) {
				     System.out.println("There was a problem: " + e1);
				     e1.printStackTrace();
				 } finally {
				     try {
				         in1.close();
				     } catch (Exception e1) {
				     }
				 }
					
					ObjectMapper objectMapper = new ObjectMapper();
					try {
						String jsonStr = objectMapper.writeValueAsString(book);
						System.out.println(jsonStr);
					} catch (JsonProcessingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
		         
		  
	    }
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
