package enums;

public enum MyAccountSideMenuItem {

    SETTINGS("Settings"),
    TEAMS("Teams"),
    LANGUAGE("Language"),
    CONNECTIVITYTEST("Connectivity test"),
    INVITEUSERS("Invite users"),
    SUPPORT("Support"),
    FEEDBACK("Feedback"),
    LOGOUT("Log out");

    private String title;

    MyAccountSideMenuItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
