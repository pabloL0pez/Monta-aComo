package monta�a;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			Monta�a como = new Monta�a("como.in");
			System.out.println(como.posicionCarrito().getX() + " " + como.posicionCarrito().getY());
			como.resolver();
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo...");
			e.printStackTrace();
		}
	}

}
