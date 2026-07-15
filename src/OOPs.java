public class OOPs {

    public static void main(String[] args) {
        Student t = new Student("Tej");
        Student t2;
        t2 = t;

        System.out.println(t2.name);

        t2.name = "Ram";

        System.out.println(t2.name);
        System.out.println(t.name);
    }
}


