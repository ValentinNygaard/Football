package football;

public class MemberPlayer {
    private String firstName;
    private String lastName;
    private int age;
    private int team;

    public MemberPlayer(String firstName, String lastName, int age, int team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public int getTeam() {
        return team;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setTeam(int team) {
        this.team = team;
    }

    public String toString(){
        return String.format("%-20s%-20s%5d%5d", firstName, lastName, age, team);
    }
    public String toFileString(){
        return (firstName+","+lastName+","+age+","+team);
    }
}

