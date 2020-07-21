package main;

import java.util.Scanner;

import conexion.ConexionArticulos;
import conexion.ReservaArticulos;
import personas.Usuarie;

public class MenuPrincipal {
	// ////////////// MENU
		public static void menuPrincipal(Usuarie usuario) {
			
			System.out.println("\n- - - - - - - - - - -  \n¿Qué desea hacer?\n");
			System.out.println("1- Reservar un artículo\n2- Buscar artículo\n0- Salir");
			String opcion;
			Scanner leerOp = new Scanner(System.in);
			opcion = leerOp.nextLine();
			System.out.println("- - - - - - - - - - - - - - - - -\n");
			
			switch(opcion) {
				case "1"://1- Reservar un artículo
					System.out.println("Ingrese código de artículo a reservar:");
					Scanner sc2 = new Scanner(System.in);
					String codigo=sc2.nextLine();
					ReservaArticulos.reservaArticulos(codigo);
					//llamada al método
					menuPrincipal(usuario); //volver al menu ppal
					break;
					
				case "2": //2- Buscar artículo
					Scanner sc = new Scanner(System.in);
					String textoABuscar="";
					System.out.print("Ingrese un nombre para buscar en la lista: ");
					textoABuscar= sc.nextLine();
					System.out.println("Buscando artículos con "+textoABuscar+" en la lista...");
					ConexionArticulos.buscarArticulos(textoABuscar.toLowerCase());
					menuPrincipal(usuario); //volver al menu ppal
					break;
					
				default:
					System.out.println("\nCerrando sesión...");
					System.out.println("Hasta luego "+usuario.getNombreUsu()); // +cli.getNombre;
					System.exit(0);
				}// cierre switch case
		}// cierre menuPrincipal
		
}// cierre clase Menu
