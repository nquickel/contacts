package contacts;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Contact {
    protected String name;
    protected String phoneNumber;
    protected LocalDateTime created;
    protected LocalDateTime modified;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
        }
    }

    public void setCreated() {
        created = LocalDateTime.now();
    }

    public void setModified() {
        modified = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        if (hasNumber()) {
            return phoneNumber;
        }
        return "[no number]";
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public boolean hasNumber() {
        return phoneNumber == "" ? false : true;
    }

    public static String formatData(Object data) {
        if (data == null) {
            return "[no data]";
        }
        return data.toString();
    }

    protected boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(\\+)?(\\w?)\\s?(\\(\\w{2,}\\)[\\s-]\\w{2,}|\\w{2,}[\\s-]\\(\\w{2,}\\)|\\w{2,}[\\s-]\\w{2,}|\\(\\w{2,}\\))?[\\s-]?([ -]\\w{2,})?[\\s-]?(\\w{2,}[\\s-])?(\\w{2,})?$");
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}