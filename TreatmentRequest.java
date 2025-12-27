import java.text.SimpleDateFormat;
import java.util.Date;

public class TreatmentRequest { // stores the data.

    public int patientId;
    long arrivalTime;
    public boolean priority = false;

    public TreatmentRequest(int patientId, boolean priority) { // Constructure has been created which requires patient ID and priority level.
        this.patientId = patientId;
        this.arrivalTime = System.currentTimeMillis();
        this.priority = priority;
    }

    public String toString() { // converting the data to the string.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = sdf.format(new Date(arrivalTime));

        return " Patient's Id:  " + patientId + " | Patient's Priority: " + priority + " | Date: " + date;  // output format.
    }

}
