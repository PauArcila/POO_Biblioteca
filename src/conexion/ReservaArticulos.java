package conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import articulos.Articulo;
import personas.Usuarie;
public class ReservaArticulos {
	
//ESTE ES EL SINGLETON
	ArrayList<Usuarie> listUsuarie;
	private static ReservaArticulos reserva;
	private ReservaArticulos() {
	}
	
	public static ReservaArticulos getReserva() {
		if(reserva  ==null) {
			synchronized(ReservaArticulos.class) {
				if(reserva==null) {
					reserva = new ReservaArticulos();
					System.out.println("instancia creada");
				}
			}
		}else {
			System.out.println("instancia ocupada");
		}
		return reserva;
	}// Cierre getReserva
	
	public static synchronized ArrayList<Usuarie>  getReservaInstancia() {
		return getReserva().listUsuarie;
	}// FIN SINGLETON
	
	public static void reservaArticulos(String codigo) {
		String ruta = Rutas.getRutaExcelArticulos();
		
		try {
			FileInputStream file = new FileInputStream(new File(ruta));//archivo de trabajo
			XSSFWorkbook wb = new XSSFWorkbook(file);//nuevo archivo (file)
			String tipoArticulo="LIBROS";
			String tipoArticulo2="PELICULAS";
			XSSFSheet sheet = wb.getSheet(tipoArticulo);//hoja
			XSSFSheet sheetp = wb.getSheet(tipoArticulo2);//hoja
			XSSFRow row;//fila
				
			boolean more = true;
			int contador=1;
			boolean encontrado=false;

				// BUSCAR SI ES LIBRO
				do { row=sheet.getRow(contador); 
					if(row==null && more) {
						more=false;
					}
					else {
						if(row.getCell(0).toString().equals(codigo)) {
							System.out.println(tipoArticulo + " encontrado");
							encontrado=true;
							if(row.getCell(2).getBooleanCellValue()==true) {
								//System.out.println("...reservando " + tipoArticulo + "\n");
								XSSFCell cell = row.getCell(2);
		
								cell.setCellValue(false);
								FileOutputStream cierre = new FileOutputStream(ruta);
								wb.write(cierre);
								cierre.flush();
								cierre.close();
								System.out.println( tipoArticulo + " reservado");
							}
							else {
								System.out.println( tipoArticulo + " no disponible");
							}
						 more=false;
						} contador++;
					}// cierre else
				} while(more);// fin do while
				//actualizar listas
				ConexionArticulos.getArticulos();
				ConexionArticulos.getLibros();
				ConexionArticulos.getPeliculas();
	
				//BUSCAR PELICULA
				contador=1;
			
				more=true;
				do { row=sheetp.getRow(contador); 
					if(row==null && more) {
						more=false;
					}
					else {
						if(row.getCell(0).toString().equals(codigo)) {
							
							System.out.println(tipoArticulo2 + " encontrada");
							encontrado=true;
							if(row.getCell(2).getBooleanCellValue()==true) {
		
								//System.out.println("...reservando " + tipoArticulo2 + "\n");
								XSSFCell cell = row.getCell(2);
		
								cell.setCellValue(false);
								FileOutputStream cierre = new FileOutputStream(ruta);
								wb.write(cierre);
								cierre.flush();
								cierre.close();
								System.out.println( tipoArticulo2 + " reservada");	
							}
							else {
								System.out.println( tipoArticulo2 + " no disponible");
							}
							more=false;
						}
					 contador++;	
					}
					
				} while(more); // fin do while2
				//actualizar listas
				ConexionArticulos.getArticulos();
				ConexionArticulos.getLibros();
				ConexionArticulos.getPeliculas();
		
			if(!encontrado) {
				System.out.println("\nArticulo no encontrado");
			}
		
		} catch ( IOException e) {
			System.out.println(e.getMessage());
		}
	}

	

}
