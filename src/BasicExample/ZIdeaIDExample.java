package BasicExample;

public class ZIdeaIDExample {
    int i;
    String s;
    private int prii;
    public int pubi;
//    Not allowed.
//    default int defi;

    static int si;
    private static int psi;

    void voidm(){}
    int intm(){return 0;}
    public void pubvoidm(){ }
    private void privoidm(){ }
//    Though confusing, not allowed either.
//    default void defvoidm(){}

    static void stavoim(){}

    class NormalInnerClass{}
    private class PrivateInnerClass{}
    public class PublicInnerClass{}
    static class StaticInnerClass{}
    static private class StaticPrivateInnerClass{}

}

// No such thing.
//class PrivateClass{
//}

// No such thing either.
//static class StaticClass{
//}

