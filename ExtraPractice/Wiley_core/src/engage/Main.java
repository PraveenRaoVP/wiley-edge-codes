// You are using Java
package engage;
import java.util.Scanner;
class Department{
    private String departmentName;
    private Staff staff;
    public void displayStaff(){
    	Staff s = getStaff();
        System.out.println(s.getStaffName()+" is working in the "+this.departmentName+" as "+s.getDesignation());
    }
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
    
}

class Staff{
    private String staffName;
    private String designation;
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
    public Staff(String name, String desig) {
    	this.staffName = name;
    	this.designation = desig;
    }
}

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String desig = sc.nextLine();
        String dept = sc.nextLine();
        Department department = new Department();
        Staff staff = new Staff(name,desig);
        department.setStaff(staff);
        department.setDepartmentName(dept);
        department.displayStaff();
    }
}