package model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Save {
	
	private File ref;
	private String read;
	public static Save lod;
	
	public Save() {
		ref = new File("BaseDeDatos.txt");
	}
	
	public static Save getInstance() {
		if (lod == null) {
			lod = new Save();
			;
		}

		return lod;
	}
	
	public void saveReadableFile(Persona p) {

		try {
			chargeReadableFile();
			String data = read;
			data += p.toString();
			FileOutputStream fos = new FileOutputStream(ref);
			fos.write(data.getBytes());
			fos.close();

		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void chargeReadableFile() {

		try {
			File file = ref;
			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int reader = 0;

			while((reader = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, reader);
			}
			fis.close();
			baos.close();

			read = baos.toString();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

}
