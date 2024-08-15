package ejercicio4;

public class TestBalanceo {

    public static void main(String[] args) {

        var balanceo = new Balanceo();

        var string1 = "{ ( ) [ ( ) ] }";
        var string2 = "{ ( ) [ ( ) }";
        var string3 = "";
        var string4 = "TU";

        if(balanceo.isBalanceado(string4)){
            System.out.println("El String esta balanceado");
        }
        else{
            System.out.println("El String esta DESbalanceado");
        }

    }
}
