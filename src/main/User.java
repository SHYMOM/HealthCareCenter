public class User {
    private String name;
    private String username;
    private int age;
    private String email;
    private String address;
    private String contactNumber;
    private String password;
    private String bloodGroup;
    private String gender;
    private final String bill = "{""}";
    private final String role = "User";
    private final String appointment = "[]";
    private final String healthRecords = "[]";

    public User(String name, String username, int age, String email, String address, String contactNumber, String password, String bloodGroup, String gender) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.password = password;
        this.bloodGroup = bloodGroup;
        this.gender = gender;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String toJSON() {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"age\": " + age + ",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"address\": \"" + address + "\",\n" +
                "  \"contactNumber\": \"" + contactNumber + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"bloodGroup\": \"" + bloodGroup + "\",\n" +
                "  \"gender\": \"" + gender + "\",\n" +
                "  \"bill\": \"" + bill + "\",\n" +
                "  \"role\": \"" + role + "\",\n" +
                "  \"appointment\": " + appointment + ",\n" +
                "  \"healthRecords\": " + healthRecords + "\n" +
                "}";
    }
}
