package montaña;

public class Carrito {

	private Punto posicion;
	private int velocidad;

	public Carrito(Punto posicion) {
		this.posicion = posicion;
	}
	
	public Punto getPosicion() {
		return this.posicion;
	}
	
	public void bajar(int desplazamiento) {
		this.velocidad += (desplazamiento - 1); // -1 por el valle
		this.posicion.desplazarX(desplazamiento);
		this.posicion.desplazarY(-desplazamiento);	
	}
	
	public void subir(int desplazamiento) {
		if(this.velocidad - desplazamiento < 0) {
			this.posicion.desplazarX(Math.abs(this.velocidad));
			this.posicion.desplazarY(Math.abs(this.velocidad));
			this.velocidad = 0;
		} else {
			this.velocidad -= desplazamiento;
			this.posicion.desplazarX(desplazamiento);
			this.posicion.desplazarY(desplazamiento);
		}
	}
	
	public boolean estaDetenido() {
		return velocidad == 0;
	}
}
