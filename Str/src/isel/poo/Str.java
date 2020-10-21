package isel.poo;

public class Str implements CharSequence {
    private static final int MAX_DIM = 16;
    private char[] text = new char[MAX_DIM];
    private int dim = 0;

    public Str(String txt) {
        final int len = txt.length();
        if (len>MAX_DIM) expand(len);
        txt.getChars(0,len,text,0);
        dim = len;
    }
    public Str(CharSequence txt) {
        final int len = txt.length();
        if (len>MAX_DIM) expand(len);
        for(int i=0 ; i<len ; ++i) text[i] = txt.charAt(i);
        dim = len;
    }
    public Str() { }
    public void append(char c) {
        if (dim==text.length) expand(dim+1);
        text[ dim++ ] = c;
    }
    public void append(String s) {
        final int l = s.length();
        final int len = dim + l;
        if ( len > text.length) expand(len);
        s.getChars(0,l,text,dim);
        dim += l;
    }
    private void expand(int size) {
        int dim = text.length*2;
        while (dim < size) dim*=2;
        char[] big= new char[dim];
        System.arraycopy(text, 0, big, 0, this.dim);
        text = big;
    }

    public void remove(int from, int to) {
        if (from<0 || to>dim)
            throw new IndexOutOfBoundsException( from<0 ? from : to );
        if (to>from) {
            final int len = to-from;
            System.arraycopy(text,to,text,from,len);
            dim -= len;
        }
    }
    @Override
    public String toString() {  return new String(text,0,dim); }
    @Override
    public int length() { return dim; }
    @Override
    public char charAt(int idx) {
        if (idx>=dim) throw new IndexOutOfBoundsException(idx);
        return text[idx];
    }
    @Override
    public CharSequence subSequence(int start, int end) {
        Str res = new Str();
        for (int i = start; i <end ; i++)
            res.append(charAt(i));
        return res;
    }
}
