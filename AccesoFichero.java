package paquetecamaras;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AccesoFichero implements Constantes{

	public static ArrayList<Camara> parsearCamaras() {
		ArrayList<Camara> lista_camaras=new ArrayList();
		//SAX Simple Api for xml
		SAXBuilder constructor=new SAXBuilder();
		try {
			Document documento_xml=constructor.build(new File(RUTA_XML));
			Element elemento_raiz=documento_xml.getRootElement();
			List<Element> lista_elem_camara=elemento_raiz.getChildren("Camara");
			for (Element camara : lista_elem_camara) {
				double latitud=Double.parseDouble(camara.getChild("Posicion").getChild("Latitud").getValue());
				double longitud=Double.parseDouble(camara.getChild("Posicion").getChild("Longitud").getValue());
				String url=camara.getChild("URL").getValue();
				Element elm_url=camara.getChild("URL");
				
				Camara c=new Camara(latitud, longitud, url);
				lista_camaras.add(c);
			}
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_camaras;
	}

	public static void grabarTabla(String html_tabla) {
		String cabecera="<html><head></head><body>";
		String pie="</body></html>";
		try {
			FileWriter escritor=new FileWriter(RUTA_HTML);
			escritor.write(cabecera+html_tabla+pie);
			escritor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
