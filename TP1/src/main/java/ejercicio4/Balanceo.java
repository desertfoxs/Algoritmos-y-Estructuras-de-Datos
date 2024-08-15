package ejercicio4;

public class Balanceo {

    private boolean condicion1 = true;
    private boolean condicion2 = true;
    private boolean condicion3 = true;

    private PilaGenerica<String> pila = new PilaGenerica<String>();

    public boolean isBalanceado(String caracteres){

        String [] vector = caracteres.split(" ");

        for(int i = 0; i < vector.length; i++){

            if (vector[i].equals("{")){
                condicion1 = false;
                pila.apilar("{");
            }
            else if(vector[i].equals("(")){
                condicion2 = false;
                pila.apilar("(");
            }
            else if(vector[i].equals("[")){
                condicion3 = false;
                pila.apilar("[");
            }


            if (vector[i].equals("}")){
                if (!condicion1){
                    condicion1 = true;
                    pila.desapilar();
                }
                else{
                    return false;
                }
            }
            else if(vector[i].equals(")")){
                if (!condicion2){
                    condicion2 = true;
                    pila.desapilar();
                }
                else{
                    return false;
                }
            }
            else if(vector[i].equals("]")){
                if (!condicion3){
                    condicion3 = true;
                    pila.desapilar();
                }
                else{
                    return false;
                }
            }
        }

        if(pila.esVacia()){
            return true;
        }
        else{
            return false;
        }

    }

}
