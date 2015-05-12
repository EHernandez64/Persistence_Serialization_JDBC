//Enrique Hernandez
//CS 4311
//Exercise 6a
//2/8/2015

//import java.util.Observable;
//import java.util.Observer;
import java.awt.*;
import java.awt.event.*;


public class ObsFrame extends Frame implements Observer, ActionListener{

	Supplier supplier;
	TextField num = new TextField(10);
	TextField name = new TextField(10);
	TextField status = new TextField(10);
	TextField city = new TextField(10);
	
	ObsFrame(Supplier su){
		supplier = su;
		//GUI
		supplier.addObserver(this);

		//Flow Layout
		FlowLayout f = new FlowLayout(FlowLayout.CENTER,20,25);
		//Lables and text fields
		Label l1 = new Label("Supplier #:");
		TextField t1 = num;
		Label l2 = new Label("Name:      ");
		TextField t2 = name;
		Label l3 = new Label("Status:    ");
		TextField t3 = status;
		Label l4 = new Label("City:      ");
		TextField t4 = city;
		//Buttons
		Button b = new Button("update");
		b.addActionListener(this);
		Button e = new Button("Exit");
		e.addActionListener(this);
		//set up GUI
		setLayout(f);
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b);
		add(e);
		setSize(250,350);
		show();
		displaySupplier();

	}
	private void displaySupplier(){
		num.setText(supplier.getNumber());

		name.setText(supplier.getName());

		status.setText(supplier.getStatus());

		city.setText(supplier.getCity());
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {

		String arg;
		arg = evt.getActionCommand();
		if(arg == "Exit") 
			System.exit(0);

		supplier.updateSupplier(num.getText(),name.getText(),
				status.getText(),city.getText());
	
	}

	@Override
	public void update(Observable o, Object arg) {
		displaySupplier();
	
	}

}
