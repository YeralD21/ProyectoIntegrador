package pe.edu.upeu.dao;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.DescuentosTO;
import pe.edu.upeu.modelo.MarcaTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;

public class DescuentoDao extends AppCrud{
    LeerArchivo leerA;
    LeerTeclado leerT=new LeerTeclado();
    UtilsX util=new UtilsX();
    DescuentosTO dTo;
    final static String TABLA_DESCUENTO="Descuentos.txt";
    /* Ga*/
    public void CrearDescuentos() {
        dTo=new DescuentosTO();
        String idD=generarId(leerA, 0, "D", 0);
      dTo.setIdDesc(idD);
      dTo.setIdDesc(leerT.leer("", "Descuento: "));
      leerA=new LeerArchivo(TABLA_DESCUENTO);
      agregarContenido(leerA, dTo);

    }

}
