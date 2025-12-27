import java.text.SimpleDateFormat;
import java.util.Date;

public class DischargeRecord { // Stores the data.
    int patientId;
    long dischargeTime;

    public DischargeRecord(int patientId) { // Constructure has been created.
        this.patientId = patientId;
        this.dischargeTime = System.currentTimeMillis();
    }

    public String toString() { // converting the data to the string.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = sdf.format(new Date(this.dischargeTime));

        return " Patient ID:  " + this.patientId + "   Discharge Time: " + date ;
    }

}
