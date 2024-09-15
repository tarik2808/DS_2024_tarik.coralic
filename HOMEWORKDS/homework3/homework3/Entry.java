package midterm.homework3;

public class Entry implements Comparable<Entry> {
    private String surname;
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String surname, String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Entry other) {
        int surnameComparison = this.surname.compareTo(other.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Surname: %s, Name: %s, Street Address: %s, City: %s, Postcode: %s, Country: %s, Phone Number: %s",
                surname, name, streetAddress, city, postcode, country, phoneNumber);
    }
}
