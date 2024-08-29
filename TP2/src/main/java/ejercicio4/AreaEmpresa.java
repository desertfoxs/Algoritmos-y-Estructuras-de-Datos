package ejercicio4;

public class AreaEmpresa {

    private String identificacion;

    private int tardanza;

    public AreaEmpresa(String identificacion, int tardanza) {
        this.identificacion = identificacion;
        this.tardanza = tardanza;
    }

    public int getTardanza() {
        return tardanza;
    }
}
