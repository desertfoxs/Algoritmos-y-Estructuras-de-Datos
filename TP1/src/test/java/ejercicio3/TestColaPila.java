package ejercicio3;

public class TestColaPila {

    public static void main(String[] args) {

        testPila();
        testCola();

    }

    private static void testPila() {

        var pila = new PilaGenerica<Integer>();
        pila.apilar(5);
        pila.apilar(8);
        pila.apilar(10);

        System.out.println("Pila:");

        while(!pila.esVacia()) {
            System.out.println(pila.desapilar());
        }
    }

    private static void testCola() {

        var cola = new ColaGenerica<Integer>();
        cola.encolar(1);
        cola.encolar(7);
        cola.encolar(6);

        System.out.println("Cola:");
        while (!cola.esVacia()){
            System.out.println(cola.desencolar());
        }
    }

}
