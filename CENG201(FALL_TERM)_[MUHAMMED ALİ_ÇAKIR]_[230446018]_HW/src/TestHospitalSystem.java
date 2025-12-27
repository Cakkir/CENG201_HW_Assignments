public class TestHospitalSystem {
    public static void main(String[] args) {

    HospitalSystem hs = new HospitalSystem();


    hs.addPatient(new Patient(2,"Kadir",2,55));
    hs.addPatient(new Patient(8,"Burcu ",4,25));
    hs.addPatient(new Patient(4,"Mehmet ",5,35));
    hs.addPatient(new Patient(10,"Eda",10,26));
    hs.addPatient(new Patient(5,"İsmet ",4,76));
    hs.addPatient(new Patient(3,"Barış",8,17));
    hs.addPatient(new Patient(6,"Selin",7,14));
    hs.addPatient(new Patient(1,"Levent",8,22));
    hs.addPatient(new Patient(7,"Aleyna ",6,24));
    hs.addPatient(new Patient(9,"Esra ",3,42));


    hs.treatmentRequest(1,true);
    hs.treatmentRequest(2,false);
    hs.treatmentRequest(3,true);
    hs.treatmentRequest(4,false);
    hs.treatmentRequest(5,false);
    hs.treatmentRequest(6,true);
    hs.treatmentRequest(8,false);
    hs.treatmentRequest(9,false);


    hs.addDischargeRecord(new DischargeRecord(7));
    hs.addDischargeRecord(new DischargeRecord(10));


    hs.sortBySeverity();


    hs.treatmentProcess();
    hs.treatmentProcess();
    hs.treatmentProcess();
    hs.treatmentProcess();


    hs.showAllStatus();

    // Priority patient management is implemented using two separate queues (priorityqueue and treatmentqueue).
    // The treatment request enqueue operation adds the patient to the appropriate queue based on their priority status, and this operation has O(1) time complexity.
    // During the treatment process, the system first checks the priority queue; if it is not empty, it takes a patient from there.
    // Otherwise, it takes a patient from the normal queue.
    // These check and dequeue operations also have O(1) time complexity.
    // Priority patients are processed first without disrupting the FIFO structure, and the entire priority mechanism operates in constant time.
    //
    // Initially, two discharge records were added manually   (Was not wanted in task).
    // During the execution, four additional discharge records were created while processing treatment requests.
    //
    //
    // Patients are sorted with using BUBBLE SORT based on their severity level and waiting time.
    // The time complexity of the bubble sort is O(n^^2).
    // This sorting algorithm is preferred for its simplicity.
    // Bubble sort is more suitable for small data.
    // But if the number of the patients increases it becomes useless.
    // Because performance cost rises too much with increasing of patients.
    //
    // If heap based priority queue was used for priority management, access to the highest priority patient become more efficient.
    // Insertion and remove operations in heap structure have O(log n) time complexity.
    // This structure provides better performance than Bubble sort and manual priority control,especially in systems with a large number of patients.
    // In conclusion, the current solution is suitable in simplicity so heap based priority queue in larger scale systems will significantly improve performance.

    }}
