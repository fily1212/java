package soluzione;

public class Main_Soluzione {

    public static void main(String[] args) {

        List l = new Node("1N",new Node("2N",new Node("3",new Nil())));

        l = l.add("New",1);

        System.out.println(l.countEndsWith("N")); // questo dovrebbe stampare 2

        System.out.println("Inverti l'array");

        List reverse = new Nil();

                /*
        List list = l;
        while(!(list instanceof Nil)){
            reverse = reverse.add(((Node)list).getValue(),0);
//            reverse = new Node(((Node)list).getValue(),reverse);
            list = list.getNext();
        }*/



        for(List iteratore = l; iteratore instanceof Node; iteratore = iteratore.getNext()){
            // Scrivere un ciclo per invertire la lista l
            String value = ((Node) iteratore).getValue();
            reverse = new Node(value,reverse);
        }
        System.out.println(reverse);
    }
}
