package PracticaMaven.PracticaMaven;

import baseDeDatos.Modelo;
import controlador.Controlador;
import vista.Vista;

public class Main 
{
    public static void main( String[] args )
    {
        Vista vista = new Vista(); 
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
    }
}
