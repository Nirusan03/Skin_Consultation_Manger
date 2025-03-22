public class Patient extends Person{
    private int patientId;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void initializePat(){
        setFirstName("e");
        setLastName("e");
        setDob(2003, 10, 9);
        setPatientId(0);
        setPhoneNo(0);
    }
}
