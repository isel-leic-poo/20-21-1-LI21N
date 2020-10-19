package isel.poo;

public class Str {
    private static final int MAX_DIM = 16;
    private char[] text = new char[MAX_DIM];
    private int dim = 0;

    public Str(String txt) {
        //TODO: Corrigir porque o array inicial pode não ser suficiente
        for(dim=0 ; dim < txt.length()  ; ++dim)
            text[ dim ] = txt.charAt(dim);
    }
    public Str() { }
    public void append(char c) {
        final int len = text.length;
        if (dim==len) {
            char[] big= new char[ len*2 ];          //1 TODO: Evitar a repetição destas 3 instruções
            //for (int i = 0; i < text.length; i++) big[i] = text[i];
            System.arraycopy(text, 0, big, 0, len); //2
            text = big;                             //3
        }
        text[ dim++ ] = c;
    }
    public void append(String s) {
        if (dim + s.length() > text.length) {
            int bigDim = text.length*2;
            while (bigDim < dim+s.length()) bigDim*=2;
            char[] big= new char[ bigDim ];         //1 TODO: Evitar a repetição destas 3 instruções
            System.arraycopy(text, 0, big, 0, dim); //2
            text = big;                             //3
        }
        for(int i=0 ; i<s.length() ; ++i)
            text[dim++] = s.charAt(i);  //this.append(s.charAt(i));
    }
    public void remove(int from, int to) {
        if (from<0 || to>dim)
            throw new IndexOutOfBoundsException( from<0 ? from : to );
        if (to>from) {
            for (; to < dim; ++from, ++to)
                text[from] = text[to];
            dim -= to - from;
        }
    }
    public String toString() {
        return new String(text,0,dim);
    }
    public int length() {
        return dim;
    }

    public char charAt(int idx) {
        if (idx>=dim) throw new IndexOutOfBoundsException(idx);
        return text[idx];
    }
}
