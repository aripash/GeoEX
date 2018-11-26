	package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter {
	public MyCoords(){
		
	}
	public double conM2C(double x) {
		x/=6371000;
		x=Math.asin(x);
		x/=Math.PI;
		x*=180;
		return x;
	}
	public double conC2M(double x1,double x2) {
		double ans=x2-x1;
		ans=(ans*Math.PI)/180;
		ans=(Math.sin(ans))*6371000;
		return ans;
	}
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		Point3D newP=new Point3D(gps);
		newP.add(
				this.conM2C(local_vector_in_meter.x()),
				this.conM2C(local_vector_in_meter.y())/(Math.cos((gps.x()*Math.PI)/180)),
				local_vector_in_meter.z());
		return newP;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {	
		// TODO Auto-generated method stub
		Point3D dis=this.vector3D(gps0, gps1);
		double ans=(dis.x()*dis.x())+
				   (dis.y()*dis.y())+
				    dis.z()*dis.z();
		return Math.sqrt(ans);
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		double metx=conC2M(gps0.x(),gps1.x());
		double mety=conC2M(gps0.y(),gps1.y())*Math.cos(gps0.x()*Math.PI/180);
		double metz=gps1.z()-gps0.z();
		return new Point3D(metx,mety,metz);
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {  
		// TODO Auto-generated method stub
		double []ans=new double[3];
		ans[2]=this.distance3d(gps0, gps1);
		ans[1]=Math.asin((gps1.z()-gps0.z())/ans[2]);
		ans[1]=ans[1]/Math.PI*180;
		Point3D temp=this.vector3D(gps0, gps1);
		double deg=Math.atan(temp.x()/temp.y());
		deg=deg/Math.PI*180;
		ans[0]=deg;
		return ans;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return valid(p.x(),'x')&&valid(p.y(),'y')&&valid(p.z(),'z');
	}
	public boolean valid(double a,char c) {
		switch(c){
		case 'x':return a<90&&a>-90;
		case 'y':return a<180&&a>-180;
		case 'z':return a>-450;
		}
		return false;
	}

}
