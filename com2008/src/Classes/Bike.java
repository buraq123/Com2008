package Classes;

import com2008.DBBike;

public class Bike {

	public Bike(Wheel wheel, Frameset frameset, HandleBar handleBar) {
		
		
		// TODO Auto-generated constructor stub
	}

	public void assemble() {
		DBBike dbike = new DBBike();
		dbike.save(this);
		
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Bike findOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
