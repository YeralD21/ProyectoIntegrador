package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.CategoriaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class CategoriaDao extends AppCrud {
    LeerArchivo leerA;
    LeerTeclado leerT=new LeerTeclado();
    UtilsX util=new UtilsX();
    CategoriaTO cTo;
    final static String TABLA_CATEGORIA="Categoria.txt";

    public void crearCategoria() {
      cTo=new CategoriaTO();
      leerA=new LeerArchivo(TABLA_CATEGORIA);
      String idC=generarId(leerA, 0, "C", 1);
      cTo.setIdCate(idC);
      cTo.setNombre(leerT.leer("", "Ingrese nombre categoria"));
      leerA=new LeerArchivo(TABLA_CATEGORIA);
      agregarContenido(leerA, cTo);
    }

    public void listarCategoria() {
      leerA=new LeerArchivo(TABLA_CATEGORIA);
      Object[][] dataC=listarContenido(leerA);
      System.out.println("Id/Cat\tNombre Categoria");
      for (int i = 0; i < dataC.length; i++) {
        System.out.println(dataC[1][0]+"\t"+dataC[i][1]);
        
      }
    }
  
    public void modificarCategoria() {
      leerA=new LeerArchivo(TABLA_CATEGORIA);
      CategoriaTO ca=new CategoriaTO();

      String idC=leerT.leer("", "Ingrese Id Categoria a Modificar");
      ca.setNombre(leerT.leer("", "Ingrese nuevo nombre Categoria"));

      editarRegistro(leerA, 0, idC, ca);
      
    }

    public void eliminarCategoria() {
      leerA=new LeerArchivo(TABLA_CATEGORIA);
      String idC=leerT.leer("", "Ingrese Id Categoria a Eliminar(C1,C2...)");
      eliminarRegistros(leerA, 0, idC);
    }


}
