public class StaffTechnician extends Employee
{
    protected boolean Degree;
    private double Hrate;

    public StaffTechnician(String employeeID, String fName, String lName)
    {

        super(employeeID, fName, lName);
        Degree = true;
    }
//as with the other sub classes, this overrides the hourly rate from the parent class.
    @Override
    public double returnRate()
    {
        Hrate = 20;
        return Hrate;
    }


    //this is sets the value of degree to true;
    protected boolean getdegree(){

        return Degree;
    }
    /* because of polymorphism, this will print the attributes unique to this subclass.  */
    @Override
    protected String printAttributes()
    {
        //this sets the value of the above function to a variable to make it easier to print.
        boolean localdegree = getdegree();
        String printatt = String.format("     Has Degree: %-4s ", localdegree);
        return printatt;
    }


}
