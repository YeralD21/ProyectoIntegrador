package pe.edu.upeu.app;

import java.io.Console;
import java.util.Scanner;

import pe.edu.upeu.dao.CategoriaDao;
import pe.edu.upeu.dao.ClienteDao;

import pe.edu.upeu.dao.MarcaDao;
import pe.edu.upeu.dao.ProductoDao;
import pe.edu.upeu.dao.UsuarioDao;
import pe.edu.upeu.dao.VentaDao;
import pe.edu.upeu.modelo.UsuarioTO;
import pe.edu.upeu.util.LeerTeclado;

public class MenuOpciones {
    Scanner sc=new Scanner (System.in);
    LeerTeclado leerT = new LeerTeclado();
    UsuarioTO uTo = new UsuarioTO();
    Console cons = System.console();

    public void login() {
        System.out.println("************Bienvenidos al Sistema de Ventas*************");
        System.out.println("****************Valide sus credenciales***************");
        uTo.usuario = leerT.leer("", "Ingrese su usuario");
        System.out.println("Ingrese su clave:");
        char[] clavex = cons.readPassword();
        uTo.clave = String.valueOf(clavex);
        if (new UsuarioDao().login(uTo.getUsuario(), new UsuarioDao().getMD5EncryptedValue(uTo.getClave()))) {
            menuPrincipal();
        } else {
            System.out.println("Intente Nuevamente!! sus credenciales son invalidos!");
            login();
        }
    }
    
    public void menuPrincipal() {
        System.out.println("------------------------------------Sistema de Ventas------------------------------");
    
        String menu = "";
        menu += "1=Registro de Usuario\n";
        menu += "2=Listar Usuarios\n";
        menu += "3=Crear Categoria\n4=Listar Categoria\n"+"5=Editar Categoria\n6=Elminar Categoria\n";
        menu += "7=Crear Marca\n8=Listar Marca\n"+"9=Editar Marca\n10=Eleminar Marca";
        menu += "11=Crear Cliente\n12=Crear Producto\n13=Listar Productos\n";
        menu +="14=Registro Ventas\n15=Reporte de Ventas\n16=DescuentoCantidad";
        System.out.println(menu);
        int opciones = sc.nextInt();
        do {
            switch (opciones) {
                case 1: new UsuarioDao().crearUsuarios();   break;
                case 2: new UsuarioDao().listarUsuarios();   break;
                case 3: new CategoriaDao().crearCategoria(); break;
                case 4: new CategoriaDao().listarCategoria(); break;
                case 5: new CategoriaDao().modificarCategoria();     break;
                case 6: new CategoriaDao().eliminarCategoria();     break;
                case 7: new MarcaDao().crearMarca(); break;
                case 8: new MarcaDao().listarMarca();     break;
                case 9: new MarcaDao().modificarMarca();    break;
                case 10: new MarcaDao().eliminarMarca();     break;
                case 11: new ClienteDao().crearCliente(); break;
                case 12: new ProductoDao().crearProducto(); break;
                case 13: new ProductoDao().reportarProductos(); break;
                case 14: new VentaDao().registroVentaGeneral();break;
                case 15: new VentaDao().reporteVentasRangoFecha();break;
                
                default: System.out.println("Opcion Invalida!"); break;
            }
            String continuar=leerT.leer("",
             "Desea Continuar? S=Si/N=No").toUpperCase().charAt(0)=='S'?"S":"N";
            if (continuar.charAt(0)=='S') {
                opciones=leerT.leer(0, "Eliga una operacion:\n"+menu);
            }else{opciones=0;}
        } while (opciones != 0);
    }



}