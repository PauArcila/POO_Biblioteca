package main;

import java.util.Scanner;

import conexion.ConexionArticulos;
import conexion.ReservaArticulos;
import personas.Usuarie;

public class MenuPrincipal {
	// ////////////// MENU
		public static void menuPrincipal(Usuarie usuario) {
			
			System.out.println("\n- - - - - - - - - - -  \n�Qu� desea hacer?\n");
			System.out.println("1- Reservar un art�culo\n2- Buscar art�culo\n0- Salir");
			String opcion;
			Scanner leerOp = new Scanner(System.in);
			opcion = leerOp.nextLine();
			System.out.println("- - - - - - - - - - - - - - - - -\n");
			
			switch(opcion) {
				case "1"://1- Reservar un art�culo
					System.out.println("Ingrese c�digo de art�culo a reservar:");
					Scanner sc2 = new Scanner(System.in);
					String codigo=sc2.nextLine();
					ReservaArticulos.reservaArticulos(codigo);
					//llamada al m�todo
					menuPrincipal(usuario); //volver al menu ppal
					break;
					
				case "2": //2- Buscar art�culo
					Scanner sc = new Scanner(System.in);
					String textoABuscar="";
					System.out.print("Ingrese un nombre para buscar en la lista: ");
					textoABuscar= sc.nextLine();
					System.out.println("Buscando art�culos con "+textoABuscar+" en la lista...");
					ConexionArticulos.buscarArticulos(textoABuscar.toLowerCase());
					menuPrincipal(usuario); //volver al menu ppal
					break;
					
				default:
					System.out.println("\nCerrando sesi�n...");
					System.out.println("Hasta luego "+usuario.getNombreUsu()); // +cli.getNombre;
					System.exit(0);
				}// cierre switch case
		}// cierre menuPrincipal
		
}// cierre clase Menu
