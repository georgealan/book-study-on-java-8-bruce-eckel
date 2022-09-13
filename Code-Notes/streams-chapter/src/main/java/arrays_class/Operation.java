package arrays_class;

public interface Operation {
    void execute();
    static void runOps(Operation... ops) {
        for (Operation op : ops) {
            op.execute();
        }
    }
    static void show(String msg) {
        System.out.println(msg);
    }
}
