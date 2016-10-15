package file.copier.copy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class Copier {
	private String nameFile;

	public Copier(String nameFile) {
		this.nameFile = nameFile;
	}

	public void copy(String oldFile, String pathCurrent) throws IOException, InterruptedException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String newFile = pathCurrent + nameFile;
		Integer integer = 0;

		try {
			fis = new FileInputStream(oldFile);
			File file = new File(newFile);
			try {
				file.createNewFile();
				System.out.println("A new file created");
			} catch (IOException e) {
				System.err.println("Cannot create new file!!!");
			}
			fos = new FileOutputStream(newFile);
			System.out.println("Oll bytes :" + fis.available());
			System.out.println("Oll bits :" + fis.available() * 8);
			System.out.println("Please wait ...");
			Thread.sleep(5000);
			System.out.println("Bytes :");
			while (fis.available() > 0) {
				integer = fis.read();
				System.out.println("[" + integer + "]");
				fos.write(integer);

			}
			System.out.println("A new file copied from old file");
		} catch (FileNotFoundException e) {
			System.err.println("Cannot read old file!!!");

		} catch (IOException e) {
			System.err.println("Cannot read old file!!!");
		}

		finally {

			fos.close();
			fis.close();
			System.out.println("All streams were closed");
		}
	}

	public void copyWithEncding(String oldFile, String pathCurrent, String encoding)
			throws InterruptedException, IOException {
		// Only if file is String type
		Charset charset = Charset.forName(encoding);

		FileInputStream fis = null;
		FileOutputStream fos = null;
		String newFile = pathCurrent + nameFile;
		int integer = 0;
		if (oldFile.endsWith(".txt")) {
			try {
				fis = new FileInputStream(oldFile);
				File file = new File(newFile);
				try {
					file.createNewFile();
					System.out.println("A new file created");
				} catch (IOException e) {
					System.err.println("Cannot create new file!!!");
				}
				fos = new FileOutputStream(newFile);
				System.out.println("Oll bytes :" + fis.available());
				System.out.println("Oll bits :" + fis.available() * 8);
				System.out.println("Please wait ...");
				Thread.sleep(5000);
				System.out.println("Bytes :");
				while (fis.available() > 0) {
					//
					integer = fis.read();
					System.out.println("[" + integer + "]");
					String str = integer + "";
					ByteBuffer byteBuffer = charset.encode(str);
					byte[] bytes = byteBuffer.array();
					fos.write(bytes);
					//
				}

				System.out.println("A new file copied from old file");
			} catch (FileNotFoundException e) {
				System.err.println("Cannot find old file!!!");

			} catch (IOException e) {
				System.err.println("Cannot read old file!!!");
			}

			finally {

				fos.close();
				fis.close();
				System.out.println("All streams were closed");
			}

		}
	}
}
