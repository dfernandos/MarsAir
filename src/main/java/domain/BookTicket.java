package domain;

public class BookTicket {

    private String departingDate;
    private String returningDate;
    private String promotionalCode;

    public BookTicket(){}

    public BookTicket(String departingDate, String returningDate, String promotionalCode) {
        this.departingDate = departingDate;
        this.returningDate = returningDate;
        this.promotionalCode = promotionalCode;
    }

    public BookTicket(String departingDate, String returningDate) {
        this.departingDate = departingDate;
        this.returningDate = returningDate;
    }

    public String getDepartingDate() {
        return departingDate;
    }

    public void setDepartingDate(String departingDate) {
        this.departingDate = departingDate;
    }

    public String getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }

    public String getPromotionalCode() {
        return promotionalCode;
    }

    public void setPromotionalCode(String promotionalCode) {
        this.promotionalCode = promotionalCode;
    }

    @Override
    public String toString() {
        return "BookTicket{" +
                "departingDate='" + departingDate + '\'' +
                ", returningDate='" + returningDate + '\'' +
                ", promotionalCode='" + promotionalCode + '\'' +
                '}';
    }
}
