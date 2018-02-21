public class Employee {
    public String employeeID;
    public String firstName;
    public String lastName;
	public double Hrate;

    public Employee(String employeeID, String firstName, String lastName)
    {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    //this is to be used in the driver class for returning the employeeID and paycheck amount.
    public String getEmployeeID()
    {
        return employeeID;
    }

    public String printEmployee(){
        double returnrat = returnRate();
        String fullname = firstName + " " + lastName;
        String result = String.format("Employee ID: %-15d" + " Name: %-20s" + "Rate:  %2.0f", employeeID, fullname, returnrat);
        return result;
    }
    // another default string to print. this is useful when printing the attributes, so you can call only one method.
    //via polymorphism
    protected String printAttributes(){
        String def =  "employee has no attributes";
        return def;
    }
    //this sets the default rate to 0, later to be changed by the child classes
    public double returnRate()
    {
        Hrate = 0;
        return Hrate;
    }



}
