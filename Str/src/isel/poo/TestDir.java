package isel.poo;

public class TestDir {
    public static void main(String[] args) {
        Dir d = Dir.LEFT;
        Dir d2 = Dir.UP;
        if (d==d2) System.out.println("equal");
        System.out.println(d.toString());
        System.out.println(d.name());
        System.out.println(d2.ordinal());
        for (Dir dir : Dir.values())
            System.out.println(dir+": lin="+dir.dLin);

    }
}
