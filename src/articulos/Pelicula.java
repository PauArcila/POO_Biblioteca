package articulos;

public class Pelicula extends Articulo {
	private int duracion; // duración de la película en segundos
	private String calidad; // calidad por ejemplo 4K
	
	public Pelicula(String nombreArticulo, String codigoArticulo, boolean reservado, int plazoMaximo,
			        int duracion, String calidad) {
		super(nombreArticulo, codigoArticulo, reservado, plazoMaximo);
		this.duracion = duracion;
		this.calidad = calidad;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	@Override
	public String toString() {
		return "pelicula [duracion=" + duracion + ", calidad=" + calidad + 
				", nombreArticulo=" + nombreArticulo + ", codigoArticulo=" + codigoArticulo + ", reservado="
				+ reservado + ", plazoMaximo=" + plazoMaximo + "]";
	}// cierre toString

}// cierre clase pelicula
