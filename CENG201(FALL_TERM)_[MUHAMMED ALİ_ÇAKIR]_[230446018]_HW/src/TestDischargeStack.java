public class TestDischargeStack {
    public static void main(String[] args) {

        DischargeStack s = new DischargeStack();

        s.push(new DischargeRecord(1));
        s.push(new DischargeRecord(2));
        s.push(new DischargeRecord(3));
        s.push(new DischargeRecord(4));
        s.push(new DischargeRecord(5));

        System.out.println("----- Discharge Stack ------");
        s.printStack();

        s.pop();
        s.pop();

        System.out.println("3 Patient has been removed. ");

        System.out.println("----- Discharge Stack ------");
        s.printStack();

    }
}
