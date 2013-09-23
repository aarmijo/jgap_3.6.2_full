package org.epes.vcn.datamine;

/*
 Write byte array to a file using FileOutputStream
 */

import java.io.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

public class FileWriter {

	public static void write(ArrayList<Content> contentList) throws IOException {

		Logger logger = Logger.getLogger(FileWriter.class.getName());
		logger.setLevel(Level.INFO);
		
		for (Content content : contentList) {
			
			if (content.getMimeType().equals(MimeTypes.PLAIN_TEXT)) {

				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				
				// delete files
				FileUtils.deleteDirectory(new File("data//txt"));
				
				String strFilePath = "data//txt//mining_" + content.getName() + "_" + timeStamp + ".txt";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			} else if (content.getMimeType().equals(MimeTypes.MS_EXCEL)) {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				
				// delete files
				FileUtils.deleteDirectory(new File("data//xls"));
				
				String strFilePath = "data//xls//mining_" + content.getName() + "_" + timeStamp + ".xls";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			} else if (content.getMimeType().equals(MimeTypes.Adobe_PDF)) {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				
				// delete files
				FileUtils.deleteDirectory(new File("data//pdf"));				
				
				String strFilePath = "data//pdf//mining_" + content.getName() + "_" + timeStamp + ".pdf";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			} else if (content.getMimeType().equals(MimeTypes.HTML)) {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				
				// delete files
				FileUtils.deleteDirectory(new File("data//html"));	
				
				String strFilePath = "data//html//mining_" + content.getName() + "_" + timeStamp + ".html";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
				
			}  else {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				
				// delete files
				FileUtils.deleteDirectory(new File("data//raw"));	
				
				String strFilePath = "data//raw//mining_" + content.getName() + "_" + timeStamp + ".raw";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			}

		}	
	}
	
	public static void write(ArrayList<Content> contentList, String filePath) throws IOException {

		Logger logger = Logger.getLogger(FileWriter.class.getName());
		logger.setLevel(Level.INFO);
		
		// delete filepath files
		FileUtils.deleteDirectory(new File(filePath));
		
		for (Content content : contentList) {
			
			if (content.getMimeType().equals(MimeTypes.PLAIN_TEXT)) {

				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				String strFilePath = filePath + "//" + "txt.mining_" + content.getName() + "_" + timeStamp + ".txt";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			} else if (content.getMimeType().equals(MimeTypes.MS_EXCEL)) {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				String strFilePath = filePath + "//" + "xls.mining_" + content.getName() + "_" + timeStamp + ".xls";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			} else if (content.getMimeType().equals(MimeTypes.Adobe_PDF)) {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				String strFilePath = filePath + "//" + "pdf.mining_" + content.getName() + "_" + timeStamp + ".pdf";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			} else if (content.getMimeType().equals(MimeTypes.HTML)) {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				String strFilePath = filePath + "//" + "html.mining_" + content.getName() + "_" + timeStamp + ".html";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
				
			}  else {
				
				Date date= new Date();	
				String timeStamp = DateFormat.getDateTimeInstance().format(date).replace(":", ".");
				//String timeStamp = new Timestamp(date.getTime()).toString().replace(":", ".");
				String strFilePath = filePath + "//" + "raw.mining_" + content.getName() + "_" + timeStamp + ".raw";
				try {
					FileOutputStream fos = new FileOutputStream(strFilePath);					

					/*
					 * To write byte array to a file, use void write(byte[]
					 * bArray) method of Java FileOutputStream class.
					 * 
					 * This method writes given byte array to a file.
					 */

					fos.write(content.getContent());

					logger.info("The next file was written: " + strFilePath);
					
					/*
					 * Close FileOutputStream using, void close() method of
					 * Java FileOutputStream class.
					 */

					fos.close();

				} catch (FileNotFoundException ex) {
					System.out.println("FileNotFoundException : " + ex);
				} catch (IOException ioe) {
					System.out.println("IOException : " + ioe);
				}
			}

		}	
	}
}
