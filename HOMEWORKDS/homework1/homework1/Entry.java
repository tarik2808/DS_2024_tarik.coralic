package midterm.homework1;

public class Entry implements Comparable<Entry> {
    private String name;
    private String address;
    private String city;
    private String zipCode;
    private String country;
    private String phoneNumber;


    public Entry(String name, String address, String city, String zipCode, String country, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }



    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + ";" + address + ";" + city + ";" + zipCode + ";" + country + ";" + phoneNumber;
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }
}
