package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Layer implements GIS_layer{
	private MetaData Data;
	private ArrayList<GIS_element> element;
	
	public Layer() {
		element=new ArrayList<GIS_element>();
	}
	public Layer(Meta_data Data) {
		Data=new MetaData(Data);
		element=new ArrayList<GIS_element>();
	}
	public Layer(GIS_layer lay) {
		Data=(MetaData) lay.get_Meta_data();
		element=new ArrayList<GIS_element>();
		Iterator<GIS_element> i=lay.iterator();
		while(i.hasNext()) {
		element.add(i.next());
		}
	}
	@Override
	public boolean add(GIS_element arg0) {
		// TODO Auto-generated method stub
		return element.add(arg0);
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> arg0) {
		// TODO Auto-generated method stub
		return element.addAll(arg0);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		element.clear();
		Data=null;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		if(Data.equals(arg0))return true;
		return element.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return element.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return element.isEmpty()&&Data==null;
	}

	@Override
	public Iterator<GIS_element> iterator() {
		// TODO Auto-generated method stub
		return element.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0.equals(Data)) {
			Data=null;
			return true;
		}
		return element.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return	element.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return element.retainAll(arg0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return element.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return element.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return element.toArray(arg0);
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return new MetaData (Data);
	}
	public String toString() {
		String s="";
		s+=Data.toString()+"\n";
		Iterator<GIS_element> i=this.iterator();
		while(i.hasNext()) {
			s+=i.next().toString();
		}
		return s;
	}
}
