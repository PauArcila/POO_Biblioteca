package personas;

public abstract class Persona {
	protected int rut;

	public Persona(int rut) {
		this.rut = rut;
	}

	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	@Override
	public String toString() {
		return "persona [rut=" + rut + "]";
	}
	
}// cierre clase persona
