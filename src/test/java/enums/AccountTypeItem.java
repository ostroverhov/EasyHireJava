package enums;

public enum AccountTypeItem {

    HIRINGMANAGER("Hiring manager"),
    APPLICANT("Applicant");

    private String title;

    AccountTypeItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
