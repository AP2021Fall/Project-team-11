package Model;

import java.util.ArrayList;

public class Member extends User{
    private static ArrayList<Member> members = new ArrayList<>();

    public static ArrayList<Member> getMembers() {
        return members;
    }

    public Member(String username, String password, String emailAddress) {
        super(username, password, emailAddress);
    }

    public void addTask(Task task){
        tasks.add(task);
    }
}
