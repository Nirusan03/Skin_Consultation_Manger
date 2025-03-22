import java.io.*;

public interface SkinConsultationManager  {
    void initialize();
    void docView(Doctor[] drList);
    void addDoctor(Doctor[] drList);
    void lNameSort(Doctor[] drList);
    void deleteDoctor(Doctor[] drList);
    void saveData(Doctor[] drList, int quit) throws IOException;

}
