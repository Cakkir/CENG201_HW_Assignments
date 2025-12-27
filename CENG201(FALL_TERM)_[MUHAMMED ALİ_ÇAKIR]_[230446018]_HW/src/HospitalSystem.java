public class HospitalSystem {
    private PatientList patientlist;
    private TreatmentQueue treatmentqueue;
    private DischargeStack dischargestack;

    private TreatmentQueue priorityqueue;

    public HospitalSystem(){
        patientlist = new PatientList();           // The patient list has been created.
        treatmentqueue = new TreatmentQueue();    // The normal patient queue has been created.
        dischargestack = new DischargeStack();   // The patient stack has been created.
        priorityqueue = new TreatmentQueue();   // Queue for priority patients has been created.
    }

        public void addPatient(Patient patient){
            patientlist.addPatient( patient ); // adding the patient to the system.
            System.out.println( patient + " has been added to the patient list.");


        }

        public void addDischargeRecord(DischargeRecord record){
            dischargestack.push(record);
        }

        public void treatmentRequest(int patientId, boolean priority){
            Patient patient = patientlist.findPatient(patientId); // finding patient with patient ID.

            if(patient == null){
                System.out.println( "Patient with Id: " + patientId + " not found.");
                return;
            }

            TreatmentRequest request = new TreatmentRequest( patientId ,priority);

            if (priority){
                priorityqueue.enqueue( request );
                System.out.println( "Priority treatment request has been added.");
            }
            else{
                treatmentqueue.enqueue( request );
                System.out.println( " Normal treatment request has been added.");
            }
            System.out.println(" Request has been created for patient with Id: " + patientId);

        }

        public void treatmentProcess(){

            if(priorityqueue.size() == 0 && treatmentqueue.size() == 0){
                System.out.println( "Patient list is empty.");
                return;
            }
            TreatmentRequest treatedPatient ;

            if (priorityqueue.size() > 0){
                treatedPatient = priorityqueue.dequeue();
            }

            else {
                treatedPatient = treatmentqueue.dequeue();
            }

            DischargeRecord record = new DischargeRecord(treatedPatient.patientId); // new record created for the treated patient.

            dischargestack.push(record); // the new record pushed to the stack.

            System.out.println(" Patient treated and discharged.");
        }

        public void showAllStatus(){  // printing all the status: patients in the hospital, queue of patients and records of discharged patients.
            System.out.println( "------patient list------" );
            patientlist.printPatientList();

            System.out.println( "------priority treatment queue------" );
            priorityqueue.printQueue();

            System.out.println( "------normal treatment queue------" );
            treatmentqueue.printQueue();

            System.out.println( "------discharge stack------" );
            dischargestack.printStack();
        }

        public void sortBySeverity(){

            TreatmentRequest[] array = treatmentqueue.toArray();
            int n = array.length;

            for(int i = 0; i < n-1; i++){
                for(int j =0; j < n-i-1; j++){

                    Patient patient1 = patientlist.findPatient(array[j].patientId);
                    Patient patient2 = patientlist.findPatient(array[j+1].patientId);

                    if(patient1.severity < patient2.severity){
                        TreatmentRequest temp = array[j];

                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            treatmentqueue.clear();

            for(TreatmentRequest request : array){
                treatmentqueue.enqueue(request);
            }

            System.out.println("Patients sorted by severty.");
        }

        public void sortByWaitingTime(){
            TreatmentRequest[] array = treatmentqueue.toArray();
            int n = array.length;

            for(int i = 0; i < n-1; i++){

                for(int j =0; j < n-i-1; j++){

                    if(array[j].arrivalTime > array[j+1].arrivalTime){

                        TreatmentRequest temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;

                    }
                }
            }
            treatmentqueue.clear();

            for(TreatmentRequest request : array){
                treatmentqueue.enqueue(request);
            }

            System.out.println("Patients sorted by waiting time.");
        }


        // In this task, a hospital management system has been developed to manage patient enterances, treatment processes and discharge operations.
        // Many data structures are used together.
        // The patients that entered the system are stored in a singly linked list.
        // The linked list was chosen because it makes it easy to add and delete patients.
        // The insertion, deletion and browsing operations in this structure have O(n) time complexity.
        // Patients that waiting treatment are managed with using queue data structure which contains FIFO rules.
        // In this way, the patients treated in a sequence and with justice.
        // Enqueue and dequeue operations have O(n) time complexity.
        // Additionally, the system has upgraded to support priority patients.
        // Priority patients treated before normal patients.
        // Patients that who complete treatment are transferred to a stack structure.
        // The stack structure was chosen.
        // It works with LIFO rules which is suitable for the system that holds discharged patients.
        // Because last discharged patients should be more accessible compared to others.
        // Push and pop operations have O(n) time complexity.
        //
        //



}
