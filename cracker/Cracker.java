package com.cs645.project1.cracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.cs645.project1.simplecracker.SimpleCracker;

public class Cracker {

	public static void main(String[] args) {
		Cracker cracker = new Cracker();
		try {
			List<String> shadowFileList = cracker.getShadowFileContents();
	         
			InputStream commonPwdsStream = SimpleCracker.class.getResourceAsStream("/common-passwords.txt");
			 
			BufferedReader commonPwdsReader = new BufferedReader(new InputStreamReader(commonPwdsStream));
	
	  
	        String commonPwdsLine;
	        
	        // outputting each line of the common pwds file.
	        while ((commonPwdsLine = commonPwdsReader.readLine()) != null) {
	                //System.out.println("commonPwdsLine: " +  commonPwdsLine);
	                
        		for(String shadowFileUserShashPwd : shadowFileList) {
        		
        	        String shadowFileShashPwd = 	shadowFileUserShashPwd.split(":")[1];
        	        String[] shadowFileUserPwd = shadowFileShashPwd.replace("$",":").split(":");
        	        String salt = shadowFileUserPwd[2];
        	       	String shadowHexPwd = shadowFileUserPwd[3];
        	        	
        	       	String commonHexPwdToCompare = MD5Shadow.crypt(commonPwdsLine, salt);
        	       	
        	      	if(shadowHexPwd.equals(commonHexPwdToCompare) ) {
    	        		System.out.println("Common Password Matches for user - " + shadowFileUserShashPwd.split(":")[0] + " : " + commonPwdsLine);
    	        		//System.out.println("Salt : " + salt + " || HexPwd : " + shadowHexPwd);
    	        		//System.out.println("HexPwdGeneratedWithSalt : " + commonHexPwdToCompare +"\n");
	    	        }
        	      }
	        }
	       
	        commonPwdsReader.close();
      
		}catch(Exception e) {
			e.printStackTrace();
		}
	} 
    
	private  List<String> getShadowFileContents() throws IOException{
		List<String> shadowFileList = new ArrayList<>();
		
		InputStream shadowStream = SimpleCracker.class.getResourceAsStream("/shadow");
	  	
		BufferedReader shadowReader = new BufferedReader(new InputStreamReader(shadowStream));
		
		 String shadowLine;
	        
        // outputting each line of the shadow simple file.
        while ((shadowLine = shadowReader.readLine()) != null) {
        	
        	shadowFileList.add(shadowLine);
        }
	    shadowReader.close();
	    
		return shadowFileList;
	}

}
