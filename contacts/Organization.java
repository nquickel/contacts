package contacts;

public class Organization extends Contact {
    private String address;

    public Organization(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "";
        }
        setCreated();
        setModified();
    }

    public void setAddress(String address) {
        this.address = address;
        setModified();
    }

    public String getAddress() {
        return address;
    }
}
