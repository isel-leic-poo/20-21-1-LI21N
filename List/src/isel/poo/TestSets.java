package isel.poo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSets {
    public static void main(String[] args) {
        Set<String> s1 = new TreeSet<>();
        s1.add("abc");
        s1.add("xpto");
        s1.add("isel");
        s1.add("fim");
        for(String i : s1)
            System.out.println(i);
    }
}
