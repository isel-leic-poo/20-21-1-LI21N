package isel.poo.fs;

public class TestFs {
    public static void main(String[] args) {
        Folder poo = new Folder("POO");
        File aula = new File("aula.txt",100);
        poo.add(aula);
        System.out.println(aula.getSize()); // 100
        System.out.println(aula);           // aula.txt
        System.out.println(poo.getName());  // POO
        System.out.println(poo.getSize());  // 100
        System.out.println(poo);            // POO{aula.txt}
        //System.out.println(aula.pathName()); // POO/aula.txt
    }
}
