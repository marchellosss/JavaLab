public class Journal {
    private String name;
    private String surname;
    private int birthday;
    private int birthmonth;
    private int birthyear;
    private String phoneNumber;
    private String streetName;
    private int houseNumber;
    private int apartmentNumber;

    public int getBirthday() {
        return birthday;
    }

    public int getBirthmonth() {
        return birthmonth;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getName() {
        return name;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSurname() {
        return surname;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public void setBirthmonth(int birthmonth) {
        this.birthmonth = birthmonth;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
}
