package Controller;

import Model.Member;
import Model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {

    public String createUser(String userName, String password1 , String password2 , String email){
        User user = User.getUserWithUserName(userName);
        if(user!=null)
            return "user with username " + userName + " already exists!";
        if(!password1.equals(password2))
            return "Your passwords are not the same!";
        if(User.getUserWithEmail(email) !=null)
            return "User with this email already exists!";
        if(!checkMatching(email,"[\\w\\d.]+@((gmail.com)|(yahoo.com))"))
            return "Email address is invalid!";
        Member newMember = new Member(userName,password1,email);
        User.getUsers().add(newMember);
        Member.getMembers().add(newMember);
        return "user created successfully!";

    }

    public String logInUser(String userName , String password){
        User user = User.getUserWithUserName(userName);
        if(user == null)
            return "There is not any user with username: " + userName;
        if(!user.getPassword().equals(password))
            return "Username and password didn't match!";
        User.setLoggedInUser(user);
        return "user logged in successfully!";
    }





    private boolean checkMatching(String input , String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
