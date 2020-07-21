package articulos;

public abstract class Articulo {
	//protected String tipoArticulo; // tipo = libro o película
	protected String nombreArticulo; // = título de libro o película
	protected String codigoArticulo;// = identificador para reservarlo
	protected boolean reservado; // flag para determinar si está reservado o no
	protected int plazoMaximo; // días que dura el préstamo
	
	public Articulo(String nombreArticulo, String codigoArticulo, boolean reservado, int plazoMaximo) {
		this.nombreArticulo = nombreArticulo;
		this.codigoArticulo = codigoArticulo;
		this.reservado = reservado;
		this.plazoMaximo = plazoMaximo;
	}

	
	public String getNombreArticulo() {
		return nombreArticulo;
	}

	public void setNombreArticulo(String nombreArticulo) {
		this.nombreArticulo = nombreArticulo;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public boolean reservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public int getPlazoMaximo() {
		return plazoMaximo;
	}

	public void setPlazoMaximo(int plazoMaximo) {
		this.plazoMaximo = plazoMaximo;
	}

	@Override
	public String toString() {
		return "articulo [nombreArticulo=" + nombreArticulo + ", codigoArticulo="
				+ codigoArticulo + ", reservado=" + reservado + ", plazoMaximo=" + plazoMaximo + "]";
	}// cierre toString
	
}// cierre clase articulo
