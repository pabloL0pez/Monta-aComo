package montaña;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class montañaTest {

	@Test
	public void seUbicaElCarrito() {
		try {
			Montaña como = new Montaña("como.in");
			Punto posEsperada = new Punto(10,40);
			Punto posCarrito = como.posicionCarrito();
			Assert.assertEquals(posCarrito, posEsperada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
