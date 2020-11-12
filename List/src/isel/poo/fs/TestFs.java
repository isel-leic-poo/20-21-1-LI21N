package isel.poo.fs;

public class TestFs {
    public static void main(String[] args) {
        Folder root = new Folder("C:");
        root.add( new Folder("Empty") );
        Folder poo = new Folder("POO");
        root.add(poo);
        root.add(new File("file.txt",1024));
        File aula = new File("aula.txt",100);
        poo.add(aula);
        poo.add(new File("Str.java",2340));
        System.out.println(aula.getSize()); // 100
        System.out.println(aula);           // aula.txt
        System.out.println(poo.getName());  // POO
        System.out.println(root.getSize());  // 3464
        System.out.println(poo);            // POO{aula.txt,Str.java}
        System.out.println(root);           // C:{Empty{},POO{aula.txt,Str.java},file.txt}
        System.out.println(aula.pathName()); // C:/POO/aula.txt
    }
}
