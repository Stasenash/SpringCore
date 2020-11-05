package core.beans;

public class Client {
    private String id;
    private String fullName;
    private String city;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Client(String id, String fullName, String city) {
        this.id = id;
        this.fullName = fullName;
        this.city = city;
    }
}
