public class TreatmentQueue {

    QueueNode front = null;
    QueueNode rear = null;
    int size;

    public TreatmentQueue(){
        this.front = null;
        this.rear =null;

    }
    // Queue data structure with FIFO (First In First Out) rule will be used in this task for management of the patients who wait for treatment.

    public void enqueue(TreatmentRequest request ){ // Enqueue operation costs O(1) time complexity because it can only add a request at the rear and it does not require browsing.

        QueueNode newPatient = new QueueNode(request);

        if (front == null){
            front = newPatient;
            rear = newPatient;
        }

        else{
            rear.next = newPatient;
            rear = newPatient;
        }

        size++;
    }

    public TreatmentRequest dequeue(){ // Dequeue operation costs O(1) time complexity because it only removes the first element and does not require browsing.
        if(front == null){
            System.out.println("The treatment queue is already empty");
            return null;

        }

        TreatmentRequest removedData = front.data;


        if (front.next == null){
            front = null;
            rear = null;

            size--;
        }

        else{
            front = front.next;

            size--;
        }
    return removedData;
    }

    public int size(){ // Size method has O(1) time complexity because it returns only one value

        return size;
    }


    public void clear(){ // For clearing all the queue when it's needed.
        front = null;
        rear = null;
        size = 0;
    }

    public TreatmentRequest[] toArray(){ // will be used in sorting by severity and waiting time.
        TreatmentRequest[] array = new TreatmentRequest[size];
        QueueNode temp = front;

        int i = 0;

        while  (temp != null){
            array[i++] = temp.data;
            temp = temp.next;
        }
        return array;
    }

    public void printQueue(){ // Printing operation costs O(n) time complexity because it browses all the list.

        if(front == null){
            System.out.println("The treatment queue is empty");
            return;
        }

        else{
            QueueNode temp = front;
            while(temp != null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }


    // In this task, queue data structure was preferred.
    // Because it is important to treat the first coming patient firstly, last coming patient lastly for the justice in the hospital system.
    // " TreatmentRequest " class has been created to represent treatment requests and each request stores the patient's ID number and the time that the patient was entered the system.
    // The queue data structure has been manually prepared based on a linked list.
    // Enqueue and dequeue operations is performed using the front and rear values in the queue.
    // The enqueue operation works by adding the new treatment request to the end of the queue and only requires updating the rear value.
    // So , the time complexity of enqueue operation is O(1).
    // Similarly , the dequeue operation removes the element at the front of the queue and only require updating the front value.
    // This operation also does not require any browsing in the queue so the time complexity of dequeue operation is O(1).
    // The printQueue method , which prints all elements in the queue so method has O(n) time complexity of because it browses all nodes.
    // If a stack were used instead of a queue in this scenario , the last coming patient will be treated first so it will be unfair situation .
    // So queue data structure is the most suitable one for treatment management.


}