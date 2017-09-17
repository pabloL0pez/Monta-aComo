package montaña;

public class Punto {

	private int x;
	private int y;
	
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void desplazarX(int x) {
		this.x += x;
	}
	
	public void desplazarY(int y) {
		this.y += y;
	}

	@Override
	public boolean equals(Object obj) {
		final Punto punto = (Punto) obj;
		if (this.x == punto.getX() && this.y == punto.getY())
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
