package paquetecamaras;

public class Camara {
private double latitud, longitud;
private String url;
public Camara(double latitud, double longitud, String url) {
	super();
	this.latitud = latitud;
	this.longitud = longitud;
	this.url = url;
}
public double getLatitud() {
	return latitud;
}
public void setLatitud(double latitud) {
	this.latitud = latitud;
}
public double getLongitud() {
	return longitud;
}
public void setLongitud(double longitud) {
	this.longitud = longitud;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

public String crearFilaTabla()
{
	String fila="<tr><td>"+latitud+"</td><td>"+longitud+
			"</td><td><img src='http://"+url+"'></td></tr>";
	return fila;
}

}
