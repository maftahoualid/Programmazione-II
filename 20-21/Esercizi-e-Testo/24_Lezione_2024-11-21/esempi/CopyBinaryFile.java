package it.univr.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyBinaryFile {

	public static void main(String[] args) {
		try (InputStream reader = new BufferedInputStream(new FileInputStream("/bin/ls"));
			 OutputStream writer = new BufferedOutputStream(new FileOutputStream("ls_copy"))) {

			int b;
			while ((b = reader.read()) != -1)
				writer.write(b);
		}
		catch (FileNotFoundException e) {
			System.out.println("Non trovo il file da leggere");
		}
		catch (IOException e) {
			System.out.println("I/O error");
		}
	}

}
