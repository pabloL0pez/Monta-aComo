package monta�a;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class monta�aTest {

	@Test
	public void seUbicaElCarrito() {
		try {
			Monta�a como = new Monta�a("como.in");
			Punto posEsperada = new Punto(10,40);
			Punto posCarrito = como.posicionCarrito();
			Assert.assertEquals(posCarrito, posEsperada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
