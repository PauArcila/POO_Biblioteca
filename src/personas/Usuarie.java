package personas;

public class Usuarie extends Persona  {
	private String nombreUsu;
	private String clave;
	
	public Usuarie(int rut, String nombreUsu, String clave) {
		super(rut);
		this.nombreUsu = nombreUsu;
		this.clave = clave;
	}

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String toString() {
		return "usuarie [nombreUsu=" + nombreUsu + ", clave=" + clave + ", rut=" + rut + "]";
	}// cierre toString
	
}// cierre clase usuarie
