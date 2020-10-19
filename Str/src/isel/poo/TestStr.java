package isel.poo;

public class TestStr {
    public static void main(String[] args) {
        Str s1 = new Str("abc");
        s1.append('d');
        System.out.println(s1);
        s1.append('x');
        System.out.println(s1);
        for (int i=0 ; i<30 ; i++)
            s1.append((char)('A'+i));
        System.out.println(s1);

        Str s2 = new Str("xpto");
        System.out.println(s2);
        s2.append("abc");
        System.out.println(s2); // ->xptoabc
        s2.remove(2,4);
        System.out.println(s2); // ->xpabc
        System.out.println(s2.length()); // ->5
        System.out.println(s2.charAt(2)); // ->a

        Str s3 = new Str();
        System.out.println("|"+s3+"|");  // -> ||
    }
}
