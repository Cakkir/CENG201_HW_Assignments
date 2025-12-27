public class TestPatientList {

    public static void main(String[] args) {
        PatientList pl = new PatientList();

        pl.addPatient(new Patient(1,"Hasan",6,28));
        pl.addPatient(new Patient(2,"Elıf",4,46));
        pl.addPatient(new Patient(3,"Nur",7,19));
        pl.addPatient(new Patient(4,"Mematı",2,52));
        pl.addPatient(new Patient(5,"Ruzgar",7,26));

        System.out.println("--------Patient List--------");
        pl.printPatientList();

        pl.removePatient(3);
        System.out.println("patient 3 has been removed");

        Patient foundPatient = pl.findPatient(4);
        System.out.println("Searching for patient 4");

        if (foundPatient != null) {
            System.out.println("Patient found: " + foundPatient);
        }
        else {
            System.out.println("Patient not found");
        }

        System.out.println("--------Final Patient List--------");
        pl.printPatientList();

    }
}
