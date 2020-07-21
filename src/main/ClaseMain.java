package main;

import personas.Usuarie;

public class ClaseMain {

	public static void main(String[] args) {
		System.out.println("********* SISTEMA DE BIBLIOTECA *********");
		Usuarie usuario=InicioSesion.iniciarSesion();
		MenuPrincipal.menuPrincipal(usuario);
	}// cierre main
	
}// cierre ClaseMain
