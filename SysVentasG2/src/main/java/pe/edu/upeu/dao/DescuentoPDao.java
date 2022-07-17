package pe.edu.upeu.dao;

import java.util.Scanner;

import pe.edu.upeu.crud.AppCrud;
import pe.edu.upeu.modelo.DescuentosTO;
import pe.edu.upeu.util.LeerArchivo;
import pe.edu.upeu.util.LeerTeclado;
import pe.edu.upeu.util.UtilsX;


    public class DescuentoPDao extends AppCrud{
        LeerArchivo leerA;
        LeerTeclado leerT=new LeerTeclado();
        UtilsX util=new UtilsX();
        DescuentosTO dTo;
        final static String TABLA_DESCUENTO="Descuentos.txt";
        public void DescuentoPrDao () {
            
            Scanner lt = new Scanner(System.in);
            int i, n, ventas0a10000, ventas10000a20000;
            double montglobal, montventas0a10000, montventas10000a20000, venta;
            ventas0a10000 = 0;
            ventas10000a20000 = 0;
            montventas0a10000 = 0;
            montventas10000a20000 = 0;
            montglobal = 0;
            System.out.println("Ingrese el valor de n: ");
            n = lt.nextInt();
            lt.nextLine();
            for (i=1; i<=n; i++) {
                System.out.print("PROCESO " + i);
                System.out.println("Ingrese el valor de venta:");
                venta = lt.nextDouble();
                lt.nextLine();
                if(venta<=10000)
                {
                    ventas0a10000=ventas0a10000+1;
                    montventas0a10000=montventas0a10000+venta;
                }
                if(venta>100&&venta<=600)
                {
                    ventas10000a20000=ventas10000a20000+1;
                    montventas10000a20000=montventas10000a20000+venta;
                }
                montglobal=montglobal+venta;
                System.out.println();
            }
            System.out.println("Valor de ventas de 0 a 10000: " + ventas0a10000);
            System.out.println("Valor de ventas de 10000 a 20000: " + ventas10000a20000);
            System.out.println("Valor de monto ventas de 0 a 10000: " + montventas0a10000);
            System.out.println("Valor de monto ventas de 10000 a 20000: " + montventas10000a20000);
            System.out.println("Valor de monto global: " + montglobal);
            }
        
        }
    
    
