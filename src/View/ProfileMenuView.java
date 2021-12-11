package View;

public class ProfileMenuView {
    private static ProfileMenuView profileMenuView = new ProfileMenuView();

    public void run(){
        System.out.println("ok");
    }

    public static ProfileMenuView getProfileMenuView() {
        return profileMenuView;
    }

    private ProfileMenuView(){

    }
}
