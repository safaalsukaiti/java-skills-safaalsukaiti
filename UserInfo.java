public class UserInfo {

    private String name;
    private int age;
    private String email;
    private boolean isActive;


    public UserInfo(String name, int age, String email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for isActive
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Method to display user information nicely formatted
    public void displayInfo() {
        System.out.println("----- User Information -----");
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Email   : " + email);
        System.out.println("Active  : " + (isActive ? "Yes" : "No"));
        System.out.println("----------------------------\n");
    }


    public static void main(String[] args) {

        UserInfo user1 = new UserInfo("Alice", 25, "alice@example.com", true);
        UserInfo user2 = new UserInfo("Bob", 30, "bob@example.com", false);
        UserInfo user3 = new UserInfo("Charlie", 22, "charlie@example.com", true);


        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();


        System.out.println("Changing Bob's status to active and age to 31...");
        user2.setActive(true);
        user2.setAge(31);
        user2.displayInfo();

        System.out.println("Charlie's email: " + user3.getEmail());
    }
}
