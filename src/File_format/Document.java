package File_format;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *this class is used to represent a KML document and assist in class 'Csv2kml'
 */
@XmlRootElement
public class Document {
private Collection<Placemark> placemarks;
private String name;

@XmlElement
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
	this.name+=".kml";
}

@XmlElement
public Collection<Placemark> getPlacemark() {
	return placemarks;
}

public void setPlacemark(Collection<Placemark> placemarks) {
	this.placemarks = placemarks;
}

}
