public class TestTreatmentQueue {
    public static void main(String[] args) {

        TreatmentQueue q = new TreatmentQueue();

        q.enqueue(new TreatmentRequest(1,false));
        q.enqueue(new TreatmentRequest(2,true));
        q.enqueue(new TreatmentRequest(3,true));
        q.enqueue(new TreatmentRequest(4,false));
        q.enqueue(new TreatmentRequest(5,false));
        q.enqueue(new TreatmentRequest(6,true));
        q.enqueue(new TreatmentRequest(7,false));
        q.enqueue(new TreatmentRequest(8,true));


        System.out.println(" ------ TreatmentQueue ------");
        q.printQueue();

        q.dequeue();
        q.dequeue();
        q.dequeue();
        System.out.println(" 3 Patient has been dequeued ");

        System.out.println(" ------ Final TreatmentQueue ------");
        q.printQueue();

    }
}
