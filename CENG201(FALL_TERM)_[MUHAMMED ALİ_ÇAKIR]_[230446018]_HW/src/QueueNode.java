public class QueueNode { // just stores data.

    TreatmentRequest data;
    QueueNode next;

    QueueNode(TreatmentRequest data){
        this.data = data;
        this.next = null;
    }

}
