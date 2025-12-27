public class PatientList {

    Node head = null;
    Node tail = null;
    int size = 0;


    public PatientList() { // creating a list
        this.head = null;
    }

    public void addPatient(Patient data){ // adding a patient costs O(n) time complexity because for adding the tail we should go to the tail one by one as worst case.

        Node newPatient = new Node(data);

        if (head == null) { // If the list is empty, patient will be added to first place.
            head = newPatient;
            tail = newPatient;
            size++;
            return;
        }
        else { // If the list is not empty, patient will be added to the tail.
            tail.next = newPatient;
            tail = newPatient;
            size++;
        }


    }

    public Patient  findPatient(int patientId){ // finding a patient costs O(n) time complexity because we may need browse all the list for finding a patient.

        Node temp = head; // new variable "temp" is assigned for browsing the list.

        while (temp != null){
            if(temp.data.patientId == patientId){
                return  temp.data; // patient found.

            }
            temp = temp.next;
        }
      return null;
    }

    public void removePatient(int patientId){ // removing a patient costs O(n) time complexity because we may need browse all the list for finding a patient.

        if (head == null) {
            System.out.println("Patient list is already empty");
            return;
        }
        if(head.data.patientId == patientId){

            head = head.next;
            if(head == null){
                tail = null;
            }


            size--;
            System.out.println("Patient has been removed");
            return;

        }

        Node prev = head;   // "prev" variable will be used after here so the linked list become doubly linked list.
        Node temp = head.next;

        while (temp != null){

            if (temp.data.patientId == patientId){
                prev.next = temp.next;

                if(temp==tail){
                    tail = prev;
                }
                size--;
                System.out.println("Patient has been removed");
                return;
            }

            prev = temp;
            temp = temp.next;


        }


    }

    public void printPatientList(){ // printing the list costs O(n) because we browse all the list.
        Node temp = head;

        if  (head == null){
            System.out.println("Patient list is empty");
            return;
        }

        else {
            while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
        }
    }

    //                    Linked list                  Array list
    // add()                  O(n)         enqueue        O(1)
    // remove()               O(n)         dequeue        O(1)
    // find()                 O(n)         -
    // print()                O(n)         print          O(n)
    //
    // In this task, a singly linked list was preferred because the situation involves patients being dynamically added and removed from the system.
    // Linked lists offer a flexible structure when the number of elements is unknown.
    // Additionally, removing patients from the system does not occur the shifting cost, unlike array lists.
    // This is significant advantage especially for a hospital management system where patient admission and discharge procedures occur frequently.
    // In this situation, where random access in not necessary , the browsing cost of the linked list is acceptable.
    // Therefore, the goal is to better understand node based data management and reference concepts using this data structure.

}
