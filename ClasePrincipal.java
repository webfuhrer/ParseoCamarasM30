package paquetecamaras;

import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		ArrayList<Camara> lista_camaras=AccesoFichero.parsearCamaras();
		String html_tabla=PintaHTML.crearTablaCamaras(lista_camaras);
		AccesoFichero.grabarTabla(html_tabla);
	}

}
