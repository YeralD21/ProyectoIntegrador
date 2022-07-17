package pe.edu.upeu.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class LeerArchivo {
    
    private static final String TABLA_VENTADETALLE = null;
    public static Path CAMINO;  
    
    public LeerArchivo(String name) {
        String ruta=crearCarpetaRaiz("data").getAbsolutePath();
        CAMINO = Paths.get(ruta+"/"+name);
        crear();
    }    

    public static File crearCarpetaRaiz(String nombreCarpeta){
        File newFolder = new File(nombreCarpeta);
        if(!newFolder.exists() && !newFolder.isDirectory()){
            newFolder.mkdirs();
        }
        return newFolder;
    }
    
    
	public void crear()  {
        try {
            if(!CAMINO.toFile().exists() && !CAMINO.toFile().isFile()){
                CAMINO.toFile().createNewFile();
        }          
        } catch (IOException e) {
            e.getMessage();
        }          		
	}

	
	public void escribir(List lista) throws IOException {		
            if(CAMINO.toFile().exists() && CAMINO.toFile().isFile()){
                 Files.write(CAMINO, lista);
            }else{
                crear();
            }                
	}

	
	public List leer() throws IOException {	    
            if(CAMINO.toFile().exists() && CAMINO.toFile().isFile()){
                 return Files.readAllLines(CAMINO);
            }else{
                crear();
            return null;
            }             
	}  
    


    public File ubicarRutaPDF(String nombreCap, String filex) {
    File ruta= crearCarpetaRaiz(nombreCap);
    return new File(ruta.getAbsolutePath()+"/"+filex);
    }

    public LeerArchivo(){}
    public void generarPDFReporte() {
        Document document = new Document();
        try {
        PdfWriter.getInstance(document, 
        new FileOutputStream(new LeerArchivo().ubicarRutaPDF("reportes","Reporte.pdf")));
        //open
        document.open();
        Font f = new Font();
        f.setStyle(Font.BOLD);
        f.setSize(8);
        Paragraph p = new Paragraph("",f);
        p.add("Reporte de Ventas");
        p.setAlignment(Element.ALIGN_CENTER);
        p.setSpacingAfter(5);
        document.add(p);

        /**LeerArchivo leerA=new LeerArchivo(TABLA_VENTADETALLE);
        Object[][] dataDV=listarContenido(leerA);
        String[] headerTitle={"Id", "Id venta", "Id Producto","Desc.","PU", "Cant", "Total"};
        PdfPTable table = new PdfPTable(headerTitle.length);
        PdfPCell c1;
        for (int i = 0; i < headerTitle.length; i++) {
        c1 = new PdfPCell(new Phrase(headerTitle[i]));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        }
        table.setHeaderRows(1);
        for (int i = 0; i < dataDV.length; i++) {
        for (int c = 0; c < dataDV[0].length; c++) {
        table.addCell(String.valueOf(dataDV[i][c]));
        }
        }
        document.add(table); **/
        
        //close
        document.close();
        System.out.println("Done");
        } catch (FileNotFoundException | DocumentException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
        }

    private Object[][] listarContenido(LeerArchivo leerA) {
        return null;
    }
    

    
}