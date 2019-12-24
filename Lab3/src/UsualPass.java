public class UsualPass extends Pass {
    private int money;
    private int price;

    UsualPass(String name, int validity, int tripsNumber, int registrationDay, int registrationMonth)
    {
        super( name,validity,tripsNumber,registrationDay, registrationMonth);
    }

    UsualPass(String name, int validity, int tripsNumber, int registrationDay, int registrationMonth, int money, int price)
    {
        super( name,validity,tripsNumber,registrationDay, registrationMonth);
        this.money= money;
        this.price = price;
        tripsNumber = tripsNumber + money/price;
        this.setTripsNumber(tripsNumber);
    }

    public void setMoney(int money) {
        this.money = money;
        this.setTripsNumber(this.getTripsNumber() + this.money/this.price);
    }

    public int getMoney()
    {
        return this.money;
    }
}
