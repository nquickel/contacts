package contacts;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Contact {
    private String name;
    private String surname;
    private String phoneNumber;

    public Contact(String name, String surname, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        if (hasNumber()) {
            return phoneNumber;
        }
        return "[no number]";
    }

    public boolean hasNumber() {
        return phoneNumber == "" ? false : true;
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(\\+)?(\\w?)(\\(\\w{2,}\\)[\\s-]\\w{2,}|\\w{2,}[\\s-]\\(\\w{2,}\\)|\\w{2,}[\\s-]\\w{2,}|\\(\\w{2,}\\))?[\\s-]?([ -]\\w{2,})?[\\s-]?(\\w{2,}[\\s-])?(\\w{2,})?$");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}
