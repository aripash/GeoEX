package File_format;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * this class represents the tags in a kml file and assist in class 'Csv2kml'
 *
 */
@XmlRootElement
public class Placemark {
private String name;
private String description;
private String Point;
private String time;

@XmlElement
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@XmlElement
public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

@XmlElement
public String getPoint() {
	return Point;
}

public void setPoint(String point) {
	Point = point;
}
@XmlElement
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time=time;
}


}
