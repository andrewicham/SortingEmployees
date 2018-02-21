public class SeniorTechnician extends StaffTechnician {
    protected boolean servaward;
    private double Hrate;


    public SeniorTechnician(String employeeID, String fName, String lName) {
        super(employeeID, fName, lName);
        servaward = true;

    }

    private boolean getserv()
    {
        return servaward;
    }

    @Override
    public double returnRate()
    {
        Hrate = 25;
        return Hrate;
    }

//just like the above function, this also is overridden by the child class to add the service variable.
    @Override
    protected String printAttributes()
    {
        boolean serv = getserv();
        boolean localdegree = getdegree();
        String printatt = String.format("     Has Degree: %-4s" + "  Has Service Award: %-5s", localdegree, serv);
        return printatt;
    }


}
