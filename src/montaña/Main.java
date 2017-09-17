package montaña;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			Montaña como = new Montaña("como.in");
			System.out.println(como.posicionCarrito().getX() + " " + como.posicionCarrito().getY());
			como.resolver();
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo...");
			e.printStackTrace();
		}
	}

}
