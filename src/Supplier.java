
//Enrique Hernandez
//CS 4311
//Exercise 6b
//2/12/2015

//Made my own classes so don't need these imports
//import java.util.Observable;
//import java.util.Observer;
import java.sql.*;
import java.io.*;

public class Supplier extends Observable {

	String number;
	String name;
	String status;
	String city;
	Supp supp;
	//Using persistence not database so storing in S1 or S2
	//DataBase db;
	
	Supplier(String aNumber){
		number = aNumber;
		//db = new DataBase("SuppDB");
		supp = new Supp(aNumber);
		loadSupplier();
	}
	String getNumber(){
		return number;
	}
	String getName(){
		return name;
	}
	String getStatus(){
		return status;
	}
	String getCity(){
		return city;
	}
	
	void updateSupplier(String aNumber, String aName, String aStatus, String aCity){
		number = aNumber;
		name = aName;
		status = aStatus;
		city = aCity;
		setChanged();
		notifyObservers();
		storeSupplier();
	}
	
	private void loadSupplier(){

		try {
			//Load data from S1.dat or S2.dat
			FileInputStream f = new FileInputStream(supp.number + ".dat");
			ObjectInputStream in = new ObjectInputStream (f);
			supp = (Supp) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
	}
	private void storeSupplier(){

		try {
			//Store data into S1.dat or S2.dat
			FileOutputStream f = new FileOutputStream(supp.number + ".dat");
			ObjectOutputStream out = new ObjectOutputStream (f);
			out.writeObject(supp);
			out.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
