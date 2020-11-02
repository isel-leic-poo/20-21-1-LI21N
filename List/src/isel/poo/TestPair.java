package isel.poo;

public class TestPair {
    public static void main(String[] args) {
        Pair<Integer> p1 = new Pair<>("Ano");
        p1.value = 1965;     // = Integer.valueOf(1965)
        System.out.println(p1);  // -> Ano = 2020
        Pair<Integer> p2 = new Pair<>("Idade",55);
        System.out.println(p2);
        System.out.println(p1.value + p2.value);
        Pair<String> p3 = new Pair<>("Nome","Pedro Pereira");
        System.out.println(p3);
        System.out.println("--------------");
        Pair<?>[] pairs = { p1, p2, p3, new Pair<Long>("Label",27L)};
        for( Pair<?> p : pairs )
            System.out.println(p);
    }
}
