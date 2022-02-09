package Controller;

import Main.Main;
import Model.User;

public class ProfileMenuController {

    public String changePassword(String oldPassword , String newPassword){
        User user = User.getLoggedInUser();
        if(!user.getPassword().equals(oldPassword))
            return "wrong old password!";
        if(oldPassword.equals(newPassword))
            return "please type a new password!";
        if(newPassword.length()<8 || !Main.checkMatching(newPassword,".*\\d.*") || !Main.checkMatching(newPassword,".*[A-Z].*"))
            return "Please Choose A strong Password (Containing at least 8 characters including 1 digit and 1 Capital Letter)";
        user.setPassword(newPassword);
        return "password changed successfully!";
    }

    public String changeUsername(String newUsername){
        User user = User.getLoggedInUser();
        if(newUsername.length()<4)
            return "Your new username must include at least 4 characters!";
        if(user.getUsername().equals(newUsername))
            return "you already have this username!";
        if(User.getUserWithUserName(newUsername) !=null)
            return "username already taken!";
        if(!Main.checkMatching(newUsername,"[\\d\\w_]+"))
            return "New username contains Special Characters! Please try again";
        user.setUsername(newUsername);
        return "username changed successfully!";

    }


}
