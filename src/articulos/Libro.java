package articulos;

public class Libro extends Articulo {
	private int cantPaginas;
	private String nombreImprenta;
	
	public Libro(String nombreArticulo, String codigoArticulo, boolean reservado, int plazoMaximo,
				 int cantPaginas, String nombreImprenta) {
		super(nombreArticulo, codigoArticulo, reservado, plazoMaximo);
		this.cantPaginas = cantPaginas;
		this.nombreImprenta = nombreImprenta;
	}

	public int getCantPaginas() {
		return cantPaginas;
	}

	public void setCantPaginas(int cantPaginas) {
		this.cantPaginas = cantPaginas;
	}

	public String getNombreImprenta() {
		return nombreImprenta;
	}

	public void setNombreImprenta(String nombreImprenta) {
		this.nombreImprenta = nombreImprenta;
	}

	@Override
	public String toString() {
		return "libro [cantPaginas=" + cantPaginas + ", nombreImprenta=" + nombreImprenta + 
				", nombreArticulo=" + nombreArticulo + ", codigoArticulo=" + codigoArticulo
				+ ", reservado=" + reservado + ", plazoMaximo=" + plazoMaximo + "]";
	}// cierre toString

}// cierre clase libro
