package pattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry {
	private String name;
	private ArrayList<Entry> dir = new ArrayList<Entry>();
	
	public Directory(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
//		int size = 0;
//		Iterator<Entry> it = dir.iterator();
//		while(it.hasNext()){
//			Entry entry = it.next();
//			size += entry.getSize();
//		}
//		return size;
		SizeVisitor v = new SizeVisitor();
		v.visit(this);
		return v.getSize();
	}
	
	public Entry add(Entry entry) {
		dir.add(entry);
		return this;
	}

	public Iterator<Entry> iterator() {
		return dir.iterator();
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
