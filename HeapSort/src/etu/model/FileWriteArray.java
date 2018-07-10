package etu.model;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteArray {

	public static void init(String str, int count) throws IOException {
		DataOutputStream  outputStream = new DataOutputStream( new FileOutputStream("resource/say.dat", false));
		String size = count + "\n";
		outputStream.writeBytes(size);
		outputStream.writeBytes(str);
		outputStream.flush();
		outputStream.close();
	}

}
