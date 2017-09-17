package montaña;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Montaña {

	private ArrayList<Integer> cimasValles; // las pares son cimas, las impares son valles
	private Carrito carrito;
	private int xCarrito;
	
	public Montaña(String path) throws FileNotFoundException {
		File file = new File(path);
		Scanner scan = new Scanner(file);
		this.cimasValles = new ArrayList<Integer>();
		int cant = scan.nextInt();
		for (int i = 0; i < cant; i++) {
			this.cimasValles.add(scan.nextInt());
		}
		this.xCarrito = scan.nextInt();
		ubicarCarrito();
		scan.close();
	}
	
	private void ubicarCarrito() {
		int yAnterior = this.cimasValles.get(0);
		int yActual = 0;
		int xCalculado = 0;
		int yCalculado = 0;
		for(int i = 1; i < this.cimasValles.size(); i++) {
			yActual = this.cimasValles.get(i);
			xCalculado += Math.abs(yAnterior - yActual);
			if(xCalculado >= this.xCarrito) {
				if(esCima(i)) {
					yCalculado = Math.abs(xCalculado - xCarrito - yActual);
				} else {
					yCalculado = Math.abs(xCalculado - xCarrito + yActual);
				}
				this.carrito = new Carrito(new Punto(this.xCarrito, yCalculado));
				return;
			}
			yAnterior = yActual;
		}
	}
	
	public void resolver() throws IOException {
		this.rodar();
		this.escribirSolucion();
	}
	
	private void rodar() {
		int yAnterior = this.posicionCarrito().getY();
		int yActual = 0;
		int desplazamiento = 0;
		for (int i = 1; i < this.cimasValles.size(); i++) {
			yActual = this.cimasValles.get(i);
			desplazamiento = Math.abs(yAnterior-yActual);
			if(esCima(i-1)) {
				this.carrito.bajar(desplazamiento);
			} else {
				this.carrito.subir(desplazamiento);
				if(this.carrito.estaDetenido() && (yActual != this.carrito.getPosicion().getY())) {
					return;
				}
			}
			yAnterior = yActual;
		}
	}
	
	private void escribirSolucion() throws IOException {
		FileWriter fw = new FileWriter("como.out");
		BufferedWriter buffer = new BufferedWriter(fw);
		buffer.write(this.carrito.getPosicion().getX() + " " + this.carrito.getPosicion().getY());
		buffer.close();
	}

	private boolean esCima(int i) {
		return i % 2 == 0;
	}
	
	public Punto posicionCarrito() {
		return this.carrito.getPosicion();
	}
}
