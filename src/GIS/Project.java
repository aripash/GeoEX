package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Project implements GIS_project{
	private MetaData Data;
	ArrayList<GIS_layer> layer;
	public Project() {
		layer=new ArrayList<GIS_layer>();
		Data=new MetaData(0,"");
	}

	public Project(Meta_data Data) {
		layer=new ArrayList<GIS_layer>();
		Data=new MetaData(Data);
	}
	public Project(GIS_project p) {
		Data=(MetaData) p.get_Meta_data();
		layer=new ArrayList<GIS_layer>();
		Iterator<GIS_layer> i=p.iterator();
		while(i.hasNext()) {
		layer.add(i.next());
		}
	}
	@Override
	public boolean add(GIS_layer e) {
		// TODO Auto-generated method stub
		return layer.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return layer.addAll(c);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		layer.clear();
		Data=null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		if(Data.equals(o))return true;
		return layer.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return layer.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return layer.isEmpty()&&Data==null;
	}

	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return layer.iterator();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		if(Data.equals(o)) {
			Data=null;
			return true;
		}
		return layer.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return layer.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return layer.retainAll(c);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return layer.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return layer.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return layer.toArray(a);
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return new MetaData(Data);
	}
	public String toString() {
		String s=Data.toString();
		Iterator<GIS_layer> i=this.iterator();
		while(i.hasNext()) {
			s+=i.next().toString();
		}
		return s;
	}

}
