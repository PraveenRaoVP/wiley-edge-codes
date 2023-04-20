public class Casting {
    public static void main(String[] args) {
        int intVariable = 9;
		double doubleVariable = intVariable; 
	
		System.out.println(intVariable);      
		System.out.println(doubleVariable); 

        int intVariable2 = (int)doubleVariable;
        System.out.println(intVariable2);
    }
}
