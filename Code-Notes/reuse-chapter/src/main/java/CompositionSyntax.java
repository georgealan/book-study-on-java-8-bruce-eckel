class WaterSource {
    private String s;
    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    /**
     *
     * @return
     * Aqui estamos fazendo o @Override para contar para garantir para o compilador que estamos fazendo overriding
     * propriamente, isso é opcional mas isso ajuda a verificar que você não está cometendo um erro ortográfico
     * ou errando as letras maiúsculas ou minunsculas.
     */
    @Override
    public String toString() { return s; }
}

public class CompositionSyntax {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source =  new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return
            "valve1 = " + valve1 + " " +
            "valve2 = " + valve2 + " " +
            "valve3 = " + valve3 + " " +
            "valve4 = " + valve4 + "\n" +
            "i = " + i + " " + "f = " + f + " " +
            "source = " + source;
    }

    public static void main(String[] args) {
        CompositionSyntax compositionSyntax = new CompositionSyntax();
        System.out.println(compositionSyntax);
    }
}
