public class Pass {
    private String name;
    private int validity;
    private int tripsNumber;
    private int registrationDay;
    private int registrationMonth;

    public Pass(String name, int validity, int tripsNumber, int registrationDay, int registrationMonth)
    {
        this.name = name;
        this.validity = validity;
        this.tripsNumber = tripsNumber;
        this.registrationDay = registrationDay;
        this.registrationMonth = registrationMonth;
    }

    public String getName()
    {
        return this.name;
    }

    public int getValidity()
    {
        return this.validity;
    }

    public int getRegistrationDay()
    {
        return this.registrationDay;
    }

    public int getRegistrationMonth()
    {
        return this.registrationMonth;
    }

    public int getTripsNumber()
    {
        return this.tripsNumber;
    }

    public void setValidity( int validity)
    {
        this.validity = validity;
    }

    public void setTripsNumber( int tripsNumber)
    {
        this.tripsNumber = tripsNumber;
    }

    public void setRegistrationDay(int registrationDay) {
        this.registrationDay = registrationDay;
    }

    public void setRegistrationMonth(int registrationMonth) {
        this.registrationMonth = registrationMonth;
    }
}
