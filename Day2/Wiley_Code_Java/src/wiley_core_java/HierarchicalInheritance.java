package wiley_core_java;

class Truck extends Vehicle{
	public void HydraulicPump(){
		System.out.println("Hydraulic pump");
	}
}

class Bike extends Vehicle{
	public void Wheels() {
		System.out.println("Wheels");
	}
}

public class HierarchicalInheritance {
	public static void main(String[] args) {
		Bike b = new Bike();
		Truck t = new Truck();
		t.HydraulicPump();
		b.Wheels();	
	}
}
