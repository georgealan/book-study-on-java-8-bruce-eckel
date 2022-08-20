package nested_classes;

//
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {
        /*
            It’s convenient to nest a class inside an interface when you create common code to
            use with all different implementations of that interface.
         */
        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }
        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
