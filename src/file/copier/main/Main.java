package file.copier.main;

import java.io.IOException;
import java.util.Scanner;

import file.copier.copy.Copier;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter name of a new file(with a extention)");
		String name = scn.nextLine();
		Copier copy = new Copier(name);
		System.out.println("Enter path :");
		String pathOldFile = scn.nextLine();
		System.out.println("Enter path :");
		String pathNewFile = scn.nextLine();
		copy.copy(pathOldFile, pathNewFile);
	}

}
