public class StaffPharmacist extends Employee
{
    protected boolean Licensed;
    private double Hrate;
    public StaffPharmacist(String employeeID, String fName, String lName)
    {
        super(employeeID, fName, lName);
        Licensed = true;
    }

    @Override
    public double returnRate()
    {
        Hrate = 40;
        return Hrate;
    }

    protected boolean getLis()
    {
        return Licensed;
    }

    @Override
    protected String printAttributes()
    {
        boolean lic = getLis();
        String printatt = String.format("     Licensed:   %-5s", lic);
        return printatt;
    }


}
