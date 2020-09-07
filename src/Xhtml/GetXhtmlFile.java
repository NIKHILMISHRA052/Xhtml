package Xhtml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;





public class GetXhtmlFile {
	
	public static void main(String[] args) throws Exception {
		//Map<String, String> topicMap = new HashMap<String, String>();
		Map<Integer, String> guidelineMap = new HashMap<Integer, String>();
		Map<String, Integer> data = new HashMap<String, Integer>();
		//Map<Object,ArrayList<Object>> data = new HashMap<>();
		Map<Integer, String> url = new HashMap<Integer, String>();
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tgl_digiedit_qa", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select book_id, chapter_id from `tbl_title_url`");
			while (rs.next())
				data.put(rs.getString(1), rs.getInt(2));
				//data.put(rs.getObject(Int(2)), value)
			//url.put(rs.getInt(2), rs.getString(3)); 
			//while (rs.next())
				//data.put(rs.getString(1), rs.getInt(2));
			//url.put(rs.getInt(2), rs.getString(3)); 
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}*/
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tgl_digiedit_qa", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select chapter_id, url from `tbl_title_url`");
			while (rst.next())
				url.put(rst.getInt(2),rst.getString(1) );
				//data.put(rs.getObject(Int(2)), value)
			//url.put(rs.getInt(2), rs.getString(3)); 
			//while (rs.next())
				//data.put(rs.getString(1), rs.getInt(2));
			//url.put(rs.getInt(2), rs.getString(3)); 
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}*/
		/*guidelineMap.put(901, "Antibiotic");
		guidelineMap.put(966,"Diabetes");
		guidelineMap.put(967,"Sexual and Reproductive Health");
		guidelineMap.put(902,"Bone and Metabolism");
		guidelineMap.put(969, "Ulcer and Wound Management");
		guidelineMap.put(903, "Oral and Dental");
		guidelineMap.put(981, "Other");
		guidelineMap.put(982, "Fatigue");
		guidelineMap.put(984, "Toxicology and Wilderness");
		guidelineMap.put(988, "Respiratory");
		guidelineMap.put(991, "Analgesic");
		guidelineMap.put(993, "Psychotropic");
		guidelineMap.put(994, "Cardiovascular");
		guidelineMap.put(995, "Neurology");
		guidelineMap.put(996, "Rheumatology");
		guidelineMap.put(997, "Palliative Care");
		guidelineMap.put(998, "Gastrointestinal");
		guidelineMap.put(999, "Dermatology");
		guidelineMap.put(2000, "Quicklinks");*/

		try {
			//Source Xhtml = null;

			//Source Xhtmlfile = new StreamSource(new File("D:\\digi content\\tgl\\digiEdit"));
			

		//	TransformerFactory tFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl",
				//	XhtmlRead.class.getClassLoader());
		//	Transformer transformer = tFactory.newTransformer(Xhtmlfile);

			//File folder = new File("D:\\digi content\\tgl\\digiEdit\\");
			File folder = new File("G:\\xhmlcontent\\");
			File[] listOfFiles1 = folder.listFiles();
			

			for (int j = 0; j < listOfFiles1.length; j++) {
				String nee=listOfFiles1[j].getAbsolutePath();
				String pathreplace=nee+"\\";
			    pathreplace=nee.replace("xhmlcontent", "digi content");
			    pathreplace=pathreplace+"\\";
				//File pathreplacedir=new File(pathreplace);
				//String fileName = nee.substring(nee.lastIndexOf("/"));
				String nam = new File(nee).getName();

				File[] listOfFiles = listOfFiles1[j].listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
					String neee=listOfFiles[i].getAbsolutePath();
					String na = new File(neee).getName();
					
					File[] listOfFiles2 = listOfFiles[i].listFiles();
					/*for(int k = 0; k < listOfFiles2.length; k++) {
						File[] listOfFiles3 = listOfFiles[k].listFiles(); 
						for(int l = 0; l < listOfFiles3.length; l++){*/
							String ne=neee+ File.separator +"digieditcontent";
							File directory=new File(ne);
						    int fileCount=directory.list().length;
						    
						   
					
					if (directory.exists()) {
							String[] fileList=directory.list();
					
						    for(String name:fileList){
					            System.out.println(name);
					            
					            String namenew=name;
					          String create_filename ="B".concat(nam).concat("_C").concat(na).concat(".xhtml");
					          System.out.println(create_filename);
					          if(namenew.equals(create_filename)){
					        	  
					        	  File newdirectory=new File(pathreplace);
					        	  Path filePath = Paths.get(pathreplace); 
					        	  File filePathdirectory=new File(pathreplace);
					        	  copyFile(directory,filePathdirectory,create_filename);
					        	  
					        	  if(filePathdirectory.list().length>0){
					        		   rename(nam,na,filePathdirectory);
					        	  }
					        	  break;
					        	  
					        	  
					        	 /* InputStream inStream = null;
					        	    OutputStream outStream = null;

				                 System.out.println("Directory created successfully");
					        	  
					        	  if(filePathdirectory.exists()){
					        		  Path filePath1 = Paths.get(ne+"/"+namenew); 
					        		  File afile = new File(filePath.toString());
					        	        File bfile = new File(.toString()+"\\");
					        		  inStream = new FileInputStream(bfile);
					        	        outStream = new FileOutputStream(afile);

					        	        byte[] buffer = new byte[1024];

					        	        int length;
					        	        //copy the file content in bytes 
					        	        while ((length = inStream.read(buffer)) > 0) {
					        	            outStream.write(buffer, 0, length);
					        	        }

					        	        inStream.close();
					        	        outStream.close();  
					            	 // Files.copy(filePath1, filePath);
					                 System.out.println("Directory created successfully");
					        	  }
					        	  else{
					        	  boolean bool = filePathdirectory.mkdir();
					              if(bool){
					            	  Path filePath1 = Paths.get(ne+"/"+namenew); 
					        		  File afile = new File(filePath.toString());
					        	        File bfile = new File(filePath1.toString());
					        		  inStream = new FileInputStream(afile);
					        	        outStream = new FileOutputStream(bfile);

					        	        byte[] buffer = new byte[1024];

					        	        int length;
					        	        //copy the file content in bytes 
					        	        while ((length = inStream.read(buffer)) > 0) {
					        	            outStream.write(buffer, 0, length);
					        	        }

					        	        inStream.close();
					        	        outStream.close();  
					            	 // Files.copy(filePath1, filePath);
					                 System.out.println("Directory created successfully");
					              }else{
					                 System.out.println("Sorry couldn�t create specified directory");
					              }
					        	  
					        	
					        	  
					        	  
					        	  }*/
					        
					          }
					         /* else if(namenew.equals("Images")){
					        	  File directory1=new File(ne+"/"+namenew);
					        	 // directory1.delete();
					        	  
					        	  deleteDirectorys(directory1);

					        	  
					          }
					          else{
					        	  Path filePath = Paths.get(directory+"/"+namenew); 
					        	  Files.delete(filePath);
					          }*/
					          
					        }		

						
					
				
				}
				}
			}
			System.out.println(" ---------------  Done Transformation for All files ----------------");
		}

		catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static void deleteDirectory(String file) {
		File directory = new File(file);
		File[] children = directory.listFiles(); 
		for (File child : children) {
			System.out.println(child.getAbsolutePath()); } 
	 boolean result = directory.delete(); 
	 if (result) { 
		 System.out.printf("Directory '%s' is successfully deleted", directory.getAbsolutePath()); } 
	 else { System.out.printf("Failed to delete directory '%s' %n", directory.getAbsolutePath()); } }

	
	 public static boolean deleteDirectorys(File directory1) {
	        if (directory1.isDirectory()) {
	            File[] children = directory1.listFiles();
	            for (int i = 0; i < children.length; i++) {
	                boolean success = deleteDirectorys(children[i]);
	                if (!success) {
	                    return false;
	                }
	            }
	        }

	        // either file or an empty directory
	        System.out.println("removing file or directory : " + directory1.getName());
	        return directory1.delete();
	    }
	 
	 public static void copyFile(File src, File dest,String create_filename)throws IOException{
			InputStream in  = null;
			OutputStream out = null;
			try{
				if(src.isDirectory()){

		    		//if directory not exists, create it
		    		if(!dest.exists()){
		    		   dest.mkdir();
		    		  // System.out.println("Directory copied from "    + src + "  to " + dest);
		    		}

		    		//list all the directory contents
		    		String files[] = src.list();
		    		for (String file : files) {
		    			for(String files_Name : files){
		    				if(files_Name.equalsIgnoreCase(create_filename)){
		    					File srcFile = new File(src, files_Name);
		    		    		   File destFile = new File(dest, files_Name);
		    		    		  
		    		    		   copyFolder(srcFile,destFile);
		    		    		   break;
		 	    		   }
		    				
		    			}  
		    			break;
		    		}

		    	}else{
		    		//if file, then copy it
		    		//Use bytes stream to support all file types
		    		    in = new FileInputStream(src);
		    	        out = new FileOutputStream(dest);

		    	        byte[] buffer = new byte[51200]; // 50 MB

		    	        int length;
		    	        //copy the file content in bytes
		    	        
		    	        while ((length = in.read(buffer)) > 0){
		    	    	   out.write(buffer, 0, length);
		    	        }

		    	       
		    	        in.close();
		    	        out.close();
		    	       // System.out.println("File copied from " + src + " to " + dest);
		    	}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(in != null){
						in.close();
					}
					if(out !=null){
						out.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		    	
		}
	 public static void copyFolder(File src, File dest)throws IOException{
			InputStream in  = null;
			OutputStream out = null;
			try{
				if(src.isDirectory()){

		    		//if directory not exists, create it
		    		if(!dest.exists()){
		    		   dest.mkdir();
		    		  // System.out.println("Directory copied from "    + src + "  to " + dest);
		    		}

		    		//list all the directory contents
		    		String files[] = src.list();

		    		for (String file : files) {
		    		   //construct the src and dest file structure
		    		   File srcFile = new File(src, file);
		    		   File destFile = new File(dest, file);
		    		  
		    		  
		    			 //recursive copy
			    		   copyFolder(srcFile,destFile);
		    		   
		    		   
		    		}

		    	}else{
		    		//if file, then copy it
		    		//Use bytes stream to support all file types
		    		    in = new FileInputStream(src);
		    	        out = new FileOutputStream(dest);

		    	        byte[] buffer = new byte[51200]; // 50 MB

		    	        int length;
		    	        //copy the file content in bytes
		    	        while ((length = in.read(buffer)) > 0){
		    	    	   out.write(buffer, 0, length);
		    	        }

		    	        in.close();
		    	        out.close();
		    	       // System.out.println("File copied from " + src + " to " + dest);
		    	}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(in != null){
						in.close();
					}
					if(out !=null){
						out.close();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				
			}
		    	
		}
     public static void rename(String nam,String na,File filePathdirectory)throws IOException{
    	// Map<String, Integer> data = new HashMap<String, Integer>();
 		//Map<Object,ArrayList<Object>> data = new HashMap<>();
 		//Map<Integer, String> url = new HashMap<Integer, String>();
    	 String  firstNamew ="null";
 		try {
 			Class.forName("com.mysql.jdbc.Driver");
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
 			Statement stmt = con.createStatement();
 			ResultSet rs = stmt.executeQuery("SELECT url FROM `tbl_title_url` WHERE book_id="+nam+"  AND chapter_id="+na+" ");
 		    
			while (rs.next())
				 firstNamew = rs.getString(1);
			if(filePathdirectory.list().length>0){
				String[] fileList=filePathdirectory.list();
				
			    for(String name:fileList){
		            System.out.println(name);
		            
		            String namenew=name;
		          String create_filename ="B".concat(nam).concat("_C").concat(na).concat(".xhtml");
		          System.out.println(create_filename);
		          if(namenew.equals(create_filename)){
		        	  
		        	  File f1 = new File(filePathdirectory.toString().concat("\\").concat(create_filename));
		        	  File f2 = new File(filePathdirectory.toString().concat("\\").concat(firstNamew).concat(".xhtml"));
		        	  boolean b = f1.renameTo(f2);
		        	  
		        	  if(b==true){
		        		  System.out.println(create_filename);
		        	  }
		        	  
		        	  
		        	  }
		          }
				
			}
			
			
 				//data.put(rs.getString(1), rs.getInt(2));
 				//data.put(rs.getObject(Int(2)), value)
 			//url.put(rs.getInt(2), rs.getString(3)); 
 			//while (rs.next())
 				//data.put(rs.getString(1), rs.getInt(2));
 			//url.put(rs.getInt(2), rs.getString(3)); 
 			
 			con.close();
 		} catch (Exception e) {
 			System.out.println(e);
 		}
    	 
     }
}
