package br.com.formento.voteNoRestaurante.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

public class FileToArrayOfBytes {
	
	public String getPathDir(String fileDir){
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(fileDir);
		
		return url.getFile(); 
	}
	
	public byte[] fileRead(String fileName) {
		FileInputStream fileInputStream = null;

		File file = new File(fileName);

		byte[] bFile = new byte[(int) file.length()];

		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

//			for (int i = 0; i < bFile.length; i++) {
//				System.out.print((char) bFile[i]);
//			}

			return bFile;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}