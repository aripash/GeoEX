package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class Element implements GIS_element {
	private Point3D Geom;
	private MetaData Data;
	
	public Element(Point3D gps) {
		this.Geom=new Point3D(Geom);
	}
	public Element(Point3D gps,Meta_data Data) {
		this.Geom=new Point3D(Geom);
		this.Data=new MetaData(Data);
	}
	public Element(GIS_element el) {
		this.Geom=(Point3D) el.getGeom();
		this.Data=(MetaData) el.getData();
	}
	@Override
	public Geom_element getGeom() {
		// TODO Auto-generated method stub
		return Geom;
	}

	@Override
	public Meta_data getData() {
		// TODO Auto-generated method stub
		return new MetaData (Data);
	}

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		
	}
	public String toString() {
		String s="";
		s+=Data.toString();
		s+=Geom.toString()+"\n";
		return s;
	}

}
