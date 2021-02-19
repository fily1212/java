public class MainStatic {
    public static void main(String[] args) {
        System.out.println(Compito.getNextId());
        Compito compito1 = new Compito();
        System.out.println(Compito.getNextId());
        Compito compito2 = new Compito();
        System.out.println(Compito.getNextId());
        System.out.println(compito1);
        System.out.println(compito2);
    }
}
