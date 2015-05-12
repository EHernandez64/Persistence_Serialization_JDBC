//Enrique Hernandez
//CS 4311
//Exercise 6a
//2/8/2015

import java.util.Vector;
public class Observable {
	
	boolean changed = false;
	Vector<Observer> observers;
	
	public Observable(){
		observers = new Vector<Observer>();
	}
	void addObserver(Observer o){
		if(!observers.contains(o))
			observers.addElement(o);
	}
	void setChanged(){
		changed = true;
	}
	void clearBit(){
		changed = false;
	}
	void notifyObservers(){
		if(!changed){
			return;
		}
		Object [] temp;
		temp = observers.toArray();
		clearBit();
		
		for(int i = temp.length-1; i>=0; i--)
			((Observer)temp[i]).update(this, null);
		
	}
}
