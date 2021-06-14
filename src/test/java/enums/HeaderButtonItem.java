package enums;

public enum HeaderButtonItem {

    PRICING("Pricing"),
    JOBBOARD("Job board"),
    DEMO("Demo"),
    FORCANDIDATE("For candidate"),
    BLOG("Blog"),
    ABOUTUS("About us"),
    LOGIN("Log in");

    private String title;

    HeaderButtonItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
