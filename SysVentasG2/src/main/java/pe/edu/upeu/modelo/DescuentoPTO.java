package pe.edu.upeu.modelo;

import lombok.Data;

@Data
public class DescuentoPTO {    
    public String idDesc, idProd, vigente;
    public double  montglobal, montventas0a10000, montventas10000a20000, venta;
}
