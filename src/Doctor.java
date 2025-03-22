import java.time.LocalDate;

public class Doctor extends Person{
    private int licenseNo;
    private String specialisation;

    public int getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(int licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public void initializeDoc(){
        setFirstName("e");
        setLastName("e");
        setDob(2003, 10, 9);
        setSpecialisation("e");
        setLicenseNo(0);
        setPhoneNo(0);
    }
}
