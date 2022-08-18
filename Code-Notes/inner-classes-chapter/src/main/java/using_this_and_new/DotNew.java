package using_this_and_new;

/*
Creating an inner class directly using .new syntax

Sometimes you want to tell some other object to create an object of one of its inner
classes. To do this, provide a reference to the other outer-class object in the new
expression, using the .new syntax, like this

 */

public class DotNew {
    public class Inner {}

    public static void main(String[] args) {
        DotNew dn = new DotNew();

        DotNew.Inner dni = dn.new Inner();
        /*
            To create an object of the inner class directly, you don’t follow the same form and
            refer to the outer class name DotNew as you might expect. Instead, use an object of the
            outer class to make an object of the inner class, as you see above. This also resolves
            the name scoping issues for the inner class, so you don’t say (indeed, you cannot say)
            dn.new DotNew.Inner().
         */
    }
}
