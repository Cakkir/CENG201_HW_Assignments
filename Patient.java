public class Patient {

    int patientId;
    String name;
    int severity;
    int age;


    public Patient(int patientId, String name, int severity, int age) { // Constructure has been created.
        this.patientId = patientId;
        this.name = name;
        this.severity = severity;
        this.age = age;
    }

    public String toString(){ // converting the data to the string.
        return " Patient's Id: " + this.patientId + " | Patient name: " +  this.name + " | Patient's severity:  " +  this.severity + " | Patient's age:  "+ this.age;
    }
}
