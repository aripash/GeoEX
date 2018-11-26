package GIS;

import Geom.Point3D;

public class MetaData implements Meta_data{
	private long UTC;
	private Point3D Orientation;
	private String data;
	public MetaData(long UTC,String data) {
		this.UTC=UTC;
		this.data=data;
	}
	public MetaData(Meta_data Mdata) {
		// TODO Auto-generated constructor stub
		this.UTC=Mdata.getUTC();
		this.data=Mdata.toString();
		Orientation=new Point3D(Mdata.get_Orientation());
	}

	@Override
	public long getUTC() {
		// TODO Auto-generated method stub
		return UTC;
	}

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return new Point3D(Orientation);
	}
	public String toSTring() {
		return data;
	}
	public boolean Equals(Meta_data Mdata) {
		return (this.toString().equalsIgnoreCase(Mdata.toString())&&UTC==Mdata.getUTC());
	}
}
