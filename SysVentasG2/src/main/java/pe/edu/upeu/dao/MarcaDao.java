package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.MarcaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class MarcaDao extends AppCrud{
    LeerArchivo leerA;
    LeerTeclado leerT=new LeerTeclado();
    UtilsX util=new UtilsX();
    MarcaTO mTo;
    final static String TABLA_MARCA="Marca.txt";

    public void crearMarca() {
      mTo=new MarcaTO();
      leerA=new LeerArchivo(TABLA_MARCA);
      String idM=generarId(leerA, 0, "M", 1);
      mTo.setIdMarca(idM);
      mTo.setNombre(leerT.leer("", "Ingrese nombre Marca"));
      leerA=new LeerArchivo(TABLA_MARCA);
      agregarContenido(leerA, mTo);
    }

      public void listarMarca() {
        leerA=new LeerArchivo(TABLA_MARCA);
        Object[][] dataC=listarContenido(leerA);
        System.out.println("Id/Cat\tNombre Categoria");
        for (int i = 0; i < dataC.length; i++) {
          System.out.println(dataC[1][0]+"\t"+dataC[i][1]);
          
        }  
    }    

    public void modificarMarca() {
      leerA=new LeerArchivo(TABLA_MARCA);
      MarcaTO ma=new MarcaTO();

      String idM=leerT.leer("", "Ingrese Id Marca a Modificar");
      ma.setNombre(leerT.leer("", "Ingrese nuevo nombre Marca"));

      editarRegistro(leerA, 0, idM, ma);
      
    }

    public void eliminarMarca() {
      leerA=new LeerArchivo(TABLA_MARCA);
      String idM=leerT.leer("", "Ingrese Id Marca a Eliminar (M1,M2...)");
      eliminarRegistros(leerA, 0, idM);
    }

}
