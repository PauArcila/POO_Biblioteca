package conexion;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import personas.Usuarie;

public class ConexionUsuarie {
		
	public Usuarie buscarUsuario(int rut, String clave){
		String ruta= Rutas.getRutaExcelUsuarios();  
		FileInputStream fileu;
		try {
			fileu = new FileInputStream(new File(ruta));
			XSSFWorkbook wbu = new XSSFWorkbook(fileu);
			XSSFSheet sheetu = wbu.getSheet("Usuarios");
			XSSFRow row;
			
			boolean more= true;
			int contador =1;
			do {
				row = sheetu.getRow(contador);
					if (row== null) {
						more = false;	
					}				
					//row.getCell(1).getNumericCellValue().equals(rut) && row.getCell(2).getNumericCellValue()).equals(clave)
					else {
						int gh = (int) row.getCell(1).getNumericCellValue();
						int fh = (int) row.getCell(2).getNumericCellValue();
						if(gh==rut && fh == Integer.parseInt(clave)) {
							Usuarie usuario = new Usuarie(rut,row.getCell(0).toString(),clave);
							return usuario;
						}
					}
			  contador++;
			} while(more);
			return null; 
		} // cierre try
		catch ( IOException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}// cierre ConexionUsuarie
}
