package clase12;

public class Estudiante {
    
    //Atributos
    private int identificacion;
    private String nombre;
    private String apellido;
    private int edad;

    //Constructor de clase
    //El constructor permite inicializar la clase
    public class Estudiante {
   
    //Atributos
    private int identificacion;
    private String nombres;
    private String apellidos;
    private int edad;
 
    //Constructor de la clase
    //El constructor permite inicializar la clase
    //El constructor se llama igual que la clase
    //la palabra reservada "this" es una autoreferencia al atributo de la clase
 
    public Estudiante(int identificacion, String nombres, String apellidos, int edad){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }
 
    //El método toString permite mostrar la información que tiene el objeto.
    public String toString(){
        return "Estudiante { identificación: " + identificacion +
               " nombres y apellidos: " + nombres + " " + apellidos +
               " edad: " + edad + "}";
    }
 
    public double calcularNotaFinal (double n1, double n2, double n3){
        double notaFinal = ((n1 * 0.30) + (n2 * 0.30) + (n3 * 0.40));
        return notaFinal;
    }
   
}
 

 
 



}