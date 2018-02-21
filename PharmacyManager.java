public class PharmacyManager extends StaffPharmacist
{
    protected boolean Leadership;
    private double Hrate;
    public PharmacyManager(String employeeID, String fName, String lName)
    {

        super(employeeID, fName, lName);
        Leadership = true;
    }
//as in the other classes, this overrides the parent value of 0 using polymorphism



    private boolean getLeader(){

        return Leadership;
    }


    @Override
    public double returnRate()
    {
        Hrate = 50;
        return Hrate;
    }

    @Override
    protected String printAttributes()
    {
        boolean lic = getLis();
        boolean lead = getLeader();
        String printatt = String.format("     Licensed:   %-5s" + "  Leadership: %-5s", lic, lead);
        return printatt;
    }


}
