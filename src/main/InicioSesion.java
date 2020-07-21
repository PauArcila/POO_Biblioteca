package main;

import java.util.Scanner;

import conexion.ConexionUsuarie;
import personas.Usuarie;

public class InicioSesion {
/////////////// LOGIN
	public static Usuarie iniciarSesion() {
		//String nombreUsu="";
		Scanner sc = new Scanner(System.in); Scanner sc1 = new Scanner(System.in);
		String clave="";
		int rut=0;
		
		System.out.print("\nIngrese su rut: ");
		rut = sc.nextInt();
		System.out.print("Ingrese su clave: ");
		clave = sc1.nextLine();
		ConexionUsuarie conexion1 = new ConexionUsuarie();
		Usuarie user = conexion1.buscarUsuario(rut, clave.toLowerCase());//      
		if(user==null) {
				System.out.println("Usuario no encontrado, reintente");
				iniciarSesion();
			}
			else {
				System.out.println("\nBienvenido/a "+ user.getNombreUsu());
			}	
		return user;
	}// cierre login
	
	public static String getNombreUsu(Usuarie usu) {
		return iniciarSesion().getNombreUsu();
	}
	
}//CIERRE CLASE INICIO SESION
