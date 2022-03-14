package dzien1.przyklad4;

public class Address {
    private Integer id;
    private String street;
    private String buildingNo;
    private String apartmentNo;
    private String city;
    private String postalCode;
    private Country country;

    public Address(Integer id, String street, String buildingNo, String apartmentNo, String city, String postalCode, Country country) {
        this.id = id;
        this.street = street;
        this.buildingNo = buildingNo;
        this.apartmentNo = apartmentNo;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(String street, String buildingNo, String apartmentNo, String city, String postalCode, Country country) {
        this.street = street;
        this.buildingNo = buildingNo;
        this.apartmentNo = apartmentNo;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", buildingNo='" + buildingNo + '\'' +
                ", apartmentNo='" + apartmentNo + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country=" + country +
                '}';
    }
}
