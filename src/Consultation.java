import java.time.LocalDateTime;

public class Consultation {
    static int month, date, hour, minutes;
    private double totalCost;

    private int licNo;

    private LocalDateTime consultationDate;

    private LocalDateTime consultationEntire;

    private int duration;
    private String shortNotes;

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getLicNo() {
        return licNo;
    }

    public void setLicNo(int licNo) {
        this.licNo = licNo;
    }

    public LocalDateTime getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate( int month, int date, int hour, int minutes) {
//        int year, int month, int dayOfMonth, int hour, int minute, int second)
        this.consultationDate = LocalDateTime.of(2022, month, date, hour, minutes);
        Consultation.month = month;
        Consultation.date = date;
        Consultation.hour = hour;
        Consultation.minutes = minutes;
    }
    public LocalDateTime getConsultationEntire() {
        return consultationEntire;
    }

    public void setConsultationEntire(int duration) {
        this.consultationEntire = LocalDateTime.of(2022, month, date, (hour+duration), minutes);
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String getShortNotes() {
        return shortNotes;
    }

    public void setShortNotes(String shortNotes) {
        this.shortNotes = shortNotes;
    }

    public void initializeCons(){
        setTotalCost(0.0);
        setShortNotes("");
        setLicNo(0);
        setConsultationDate(2, 1, 1, 10);
        setConsultationEntire(0);
        setDuration(0);
    }
}
