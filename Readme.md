# Westminster Skin Consultation Management System

## Project Description
This project is a **Java-based desktop application** designed to manage a **skin consultation clinic** efficiently. It allows clinic staff to add, view, and remove doctors, as well as manage patient consultations via a **Command-Line Interface (CLI)** and **Graphical User Interface (GUI)**.

The system ensures that:
- Doctors can be registered, removed, and listed.
- Consultations can be scheduled while checking for conflicts.
- All data is stored in static arrays and optionally saved to a text file.

> Developed as part of coursework for the Westminster University Java OOP module.

---

## Project Structure
```
├── Doctor.java
├── Patient.java
├── Person.java
├── Consultation.java
├── SkinConsultationManager.java
├── WestminsterSkinConsultation.java
├── Run.java
├── GUI_ViewDoctors.java
├── GUI_ViewConsultation.java
├── GUI_AddConsultation.java
├── GUI_EditConsultation.java
├── GUI_DeleteConsultation.java
├── WestminsterFile_W1867405.txt (generated file)
```

---

## Key Features

### Doctor Management
- Add new doctors with validation.
- View doctors sorted by last name.
- Delete a doctor using license number.
- Store and retrieve doctor data to/from a file.

### Patient and Consultation Management
- Add consultations using a GUI.
- Automatically reassign to an available doctor if a time conflict occurs.
- View all consultations in a GUI table.
- Support for editing and deleting consultations (via dedicated GUI).

### GUI Support
- GUI built with Java Swing.
- `GUI_ViewDoctors`: Displays all registered doctors.
- `GUI_ViewConsultation`: Displays consultations and related patients.
- `GUI_AddConsultation`: Form to book a consultation.
- `GUI_EditConsultation`: Placeholder form to modify a consultation.
- `GUI_DeleteConsultation`: Placeholder form to delete a consultation.

---

## How to Run
### Requirements:
- Java JDK 8 or above
- Any Java IDE (e.g., IntelliJ, Eclipse, BlueJ) or terminal support

### CLI Mode:
1. Compile the code:
    ```bash
    javac *.java
    ```
2. Run the main program:
    ```bash
    java Run
    ```
3. Follow the on-screen menu to manage doctors and launch GUI.

### GUI Mode:
- From the CLI menu, select `U` to launch the GUI application.

---

## Explanation of Key Classes

### `Doctor` / `Patient` / `Person`
- `Person`: Base class for `Doctor` and `Patient`.
- `Doctor`: Adds fields like `licenseNo`, `specialisation`.
- `Patient`: Adds field `patientId`.

### `Consultation`
- Stores info like doctor license, time, date, duration, notes.
- Uses `LocalDateTime` for scheduling.

### `WestminsterSkinConsultation`
- Implements `SkinConsultationManager` interface.
- Manages doctor and consultation logic.

### `Run`
- Entry point for CLI operations.

### GUI Classes
- Use `JTable`, `JFrame`, `JButton`, and `JTextField` to create a Swing-based interface.

---

## File Output
- Consultations and doctor data are saved to `WestminsterFile_W1867405.txt` when the user chooses to save or quit.

---

## Future Improvements
- Hook GUI edit/delete consultation forms with working logic.
- Replace static arrays with dynamic structures or a database.
- Add data encryption and login for secure access.

---

## License
This project is for educational purposes only.