package conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import articulos.Articulo;
import articulos.Libro;
import articulos.Pelicula;

public class ConexionArticulos { // Lectura de archivo excel

	public static void buscarArticulos(String texto){
					
		System.out.println("\nPELICULAS:"); // Imprimir Peliculas
		ArrayList<Pelicula> peliculas = getPeliculas();	
		//System.out.println("elementos en peliculas: "+peliculas.size());//BORRAR
				String cadena1=""; boolean encuentra=false;
				for (int j=0; j<peliculas.size(); j++) {// Imprime todos los títulos encontrados
					if ( (peliculas.get(j).getNombreArticulo().toLowerCase().contains(texto)) ){
						System.out.print("* Título: "+peliculas.get(j).getNombreArticulo());
						for(int a=0;a<45-peliculas.get(j).getNombreArticulo().length();a++) {System.out.print(" ");}// rellenar con espacios para vista homogénea
						System.out.print(" * Código: "+peliculas.get(j).getCodigoArticulo());
						System.out.print(" * Duración: "+peliculas.get(j).getDuracion());
						System.out.print(" * Calidad: "+peliculas.get(j).getCalidad());
						System.out.print(" * Plazo: "+peliculas.get(j).getPlazoMaximo());
						System.out.println(" * Reservado: "+(peliculas.get(j).reservado()?"No": "Sí"));
						cadena1=""; encuentra=true;
					}
					else if(!encuentra){cadena1="Sin resultados.";}
				}// cierre for
				System.out.println(cadena1);
			
			System.out.println("\nLIBROS:");// Imprimir Libros
			ArrayList<Libro> libros = getLibros();
			//System.out.println("elementos en libros: "+libros.size());//BORRAR
				String cadena2=""; boolean hay=false;
				for (int i=0; i<libros.size(); i++) {// Imprime todos los títulos encontrados
					if (libros.get(i).getNombreArticulo().toLowerCase().contains(texto) ) {
						System.out.print("* Título: "+libros.get(i).getNombreArticulo());
						for(int b=0;b<65-libros.get(i).getNombreArticulo().length();b++) {System.out.print(" ");}// rellenar columna con espacios para vista homogénea
						System.out.print(" * Código: "+libros.get(i).getCodigoArticulo());
						System.out.print(" * Páginas: "+libros.get(i).getCantPaginas());
						System.out.print(" * Imprenta: "+libros.get(i).getNombreImprenta());
						System.out.print(" * Plazo: "+libros.get(i).getPlazoMaximo());
						System.out.println(" * Reservado: "+(libros.get(i).reservado()?"No": "Sí"));
						cadena2=""; hay=true;
					}
					else if (!hay){cadena2="Sin resultados.";}
				}// cierre for
				System.out.println(cadena2);
				
		System.out.println("\nBúsqueda finalizada.");	
	}// cierre metodo buscarArticulos
	
	public static ArrayList<Articulo> getArticulos() {
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		articulos.addAll(getPeliculas());
		articulos.addAll(getLibros());
		return articulos;
	} // cierre getArticulos

	public static ArrayList<Libro> getLibros() {
		try {
			ArrayList<Libro> articulos = new ArrayList<Libro>();
			String ruta = Rutas.getRutaExcelArticulos();
					
			FileInputStream file = new FileInputStream(new File(ruta));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("LIBROS");
			XSSFRow row;
			boolean more = true;
			int contador = 1;

			do {
				row = sheet.getRow(contador);
				if (row == null) {
					more = false;
				} 
				else { // CODIGO 0 NOMBRE 1 FLAG 2 PAGINAS 3 IMPRENTA 4 PLAZO 5
					Libro libro = new Libro(row.getCell(1).toString(), row.getCell(0).toString(),
							(row.getCell(2).getBooleanCellValue()), (int) row.getCell(5).getNumericCellValue(),
							(int) row.getCell(3).getNumericCellValue(), row.getCell(4).toString());
					articulos.add(libro);
					contador++;
				}
			} while (more);

			return articulos;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static ArrayList<Pelicula> getPeliculas() {
		ArrayList<Pelicula> articulos = new ArrayList<Pelicula>();
		String ruta = Rutas.getRutaExcelArticulos();
		try {
			FileInputStream file = new FileInputStream(new File(ruta));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("PELICULAS");
			XSSFRow row;
			boolean more = true;
			int contador = 1;

			do {
				row = sheet.getRow(contador);
				if (row == null) {
					more = false;
				} 
				else {// CODIGO 0 NOMBRE 1 FLAG 2 DURACION 3 CALIDAD 4 PLAZO 5
					Pelicula pelicula = new Pelicula(row.getCell(1).toString(), row.getCell(0).toString(),
							row.getCell(2).getBooleanCellValue(), (int) row.getCell(5).getNumericCellValue(),
							(int) row.getCell(3).getNumericCellValue(), row.getCell(4).toString());
					articulos.add(pelicula);
					contador++;
				}
			} while (more);
			return articulos;
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}// cierre catch
		
	}// CIERRE GET PELICULAS
	
}// CIERRE CLASE ConexionArticulos
