package clasefinal;

import java.util.ArrayList;

// =========================================================================
// REQUERIMIENTO 1: MODELO DE DATOS SOLICITADO (ATRIBUTOS PRIVADOS)
// =========================================================================
class Estudiante {
    private String nombre;
    private double promedio;
    private int horasDeporte = 0, horasCultura = 0, horasSalud = 0;
    private int cicloActividades = 0; 

    public Estudiante(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
    }

    public String getNombre() { return nombre; }
    public double getPromedio() { return promedio; }
    public int getHorasDeporte() { return horasDeporte; }
    public int getHorasCultura() { return horasCultura; }
    public int getHorasSalud() { return horasSalud; }
    
    public void acumularHoras(String categoria, int horas) {
        if (categoria.equals("Deporte")) horasDeporte += horas;
        if (categoria.equals("Cultura")) horasCultura += horas;
        if (categoria.equals("Salud")) horasSalud += horas;
    }

    public int getCicloActividades() { return cicloActividades; }
    public void incrementarCiclo() { this.cicloActividades++; }
    public void reiniciarCiclo() { this.cicloActividades = 0; }
    public int getTotalHoras() { return horasDeporte + horasCultura + horasSalud; }
}

class Actividad {
    private String nombre, categoria;
    private int horario, cupoMaximo;
    private boolean esAltoImpacto;
    private int sumaCalificaciones = 0, totalCalificaciones = 0;

    public Actividad(String nombre, String categoria, int horario, int cupoMaximo, boolean esAltoImpacto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.horario = horario;
        this.cupoMaximo = cupoMaximo;
        this.esAltoImpacto = esAltoImpacto;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public int getHorario() { return horario; }
    public int getCupoMaximo() { return cupoMaximo; }
    public boolean isEsAltoImpacto() { return esAltoImpacto; }

    public void calificar(int nota) {
        if (nota >= 1 && nota <= 5) { sumaCalificaciones += nota; totalCalificaciones++; }
    }
    public double getPromedioSatisfaccion() {
        return totalCalificaciones == 0 ? 0.0 : (double) sumaCalificaciones / totalCalificaciones;
    }
}

class Inscripcion {
    private Estudiante estudiante;
    private Actividad actividad;

    public Inscripcion(Estudiante estudiante, Actividad actividad) {
        this.estudiante = estudiante;
        this.actividad = actividad;
    }
    public Estudiante getEstudiante() { return estudiante; }
    public Actividad getActividadObj() { return actividad; }
}

// =========================================================================
// LOGICA DE NEGOCIO Y REGLAS BIENESTAR UNIAJC
// =========================================================================
class GestionBienestar {
    private ArrayList<Inscripcion> inscripciones = new ArrayList<>();
    private ArrayList<Estudiante> listaEspera = new ArrayList<>(); 

    public void inscribirEstudiante(Estudiante est, Actividad act) {
        System.out.println("\n-> Evaluando inscripcion de " + est.getNombre() + " en " + act.getNombre());

        if (act.isEsAltoImpacto() && est.getPromedio() < 4.0) {
            System.out.println("  RECHAZADO: Promedio insuficiente para eventos de alto impacto.");
            return;
        }

        for (Inscripcion ins : inscripciones) {
            if (ins.getEstudiante() == est && ins.getActividadObj().getHorario() == act.getHorario()) {
                System.out.println("  RECHAZADO: Cruce de horarios con " + ins.getActividadObj().getNombre());
                return;
            }
        }

        long cuposOcupados = inscripciones.stream().filter(i -> i.getActividadObj() == act).count();
        if (cuposOcupados < act.getCupoMaximo()) {
            inscripciones.add(new Inscripcion(est, act));
            System.out.println("  OK: Inscrito exitosamente.");
        } else {
            listaEspera.add(est);
            System.out.println("  INFO: Cupo lleno. Agregado a LISTA DE ESPERA.");
        }
    }

    public void cancelarInscripcion(Estudiante est, Actividad act, boolean conAntelacion) {
        System.out.println("\n-> Cancelando inscripcion de " + est.getNombre() + " en " + act.getNombre());
        Inscripcion encontrada = null;
        for (Inscripcion ins : inscripciones) {
            if (ins.getEstudiante() == est && ins.getActividadObj() == act) { encontrada = ins; break; }
        }

        if (encontrada != null) {
            inscripciones.remove(encontrada);
            System.out.println("  Estudiante retirado.");
            
            if (!conAntelacion) { 
                est.acumularHoras("Deporte", -2);
                System.out.println("  AVISO: Penalizacion de -2 horas por cancelar tarde.");
            }

            if (!listaEspera.isEmpty()) {
                Estudiante siguiente = listaEspera.remove(0);
                inscripciones.add(new Inscripcion(siguiente, act));
                System.out.println("  SISTEMA: " + siguiente.getNombre() + " pasa de la lista de espera al cupo principal.");
            }
        }
    }

    public void completarActividad(Estudiante est, Actividad act, int horas) {
        est.acumularHoras(act.getCategoria(), horas);
        est.incrementarCiclo();
        
        if (est.getCicloActividades() == 3) {
            est.acumularHoras(act.getCategoria(), 5);
            System.out.println("\n¡BONO UNIAJC!: " + est.getNombre() + " gana 5 horas extra en " + act.getCategoria());
            est.reiniciarCiclo();
        }
    }

    public void generarReporteGrado(Estudiante est) {
        System.out.println("\n==============================================");
        System.out.println("  CERTIFICADO DE GRADO UNIAJC: " + est.getNombre().toUpperCase());
        System.out.println("==============================================");
        System.out.println("  Horas Deporte: " + est.getHorasDeporte() + "/10");
        System.out.println("  Horas Cultura: " + est.getHorasCultura() + "/10");
        System.out.println("  Horas Salud:   " + est.getHorasSalud() + "/10");
        System.out.println("  Total Acumulado: " + est.getTotalHoras() + " horas.");

        if (est.getHorasDeporte() >= 10 && est.getHorasCultura() >= 10 && est.getHorasSalud() >= 10) {
            System.out.println("  ESTADO: APTO PARA GRADUACION");
        } else {
            System.out.println("  ESTADO: NO APTO (Faltan horas reglamentarias)");
        }
        System.out.println("==============================================");
    }
}

public class clasefinal {
    public static void main(String[] args) {
        GestionBienestar sistema = new GestionBienestar();

        Estudiante josep = new Estudiante("Josep", 4.5);
        Estudiante eduardo = new Estudiante("Eduardo", 3.8);
        Estudiante ana = new Estudiante("Ana", 4.2);

        Actividad futbol = new Actividad("Torneo Futbol", "Deporte", 8, 2, false);
        Actividad danza = new Actividad("Viaje Cultural", "Cultura", 8, 5, true); 
        Actividad yoga = new Actividad("Taller Salud", "Salud", 14, 10, false);

        // Ejecucion automatica de pruebas
        sistema.inscribirEstudiante(josep, futbol);
        sistema.inscribirEstudiante(eduardo, futbol);
        sistema.inscribirEstudiante(ana, futbol); 

        sistema.inscribirEstudiante(eduardo, danza); 
        sistema.inscribirEstudiante(josep, danza);    

        sistema.cancelarInscripcion(eduardo, futbol, false); 

        sistema.completarActividad(josep, futbol, 5);
        sistema.completarActividad(josep, futbol, 3);
        sistema.completarActividad(josep, futbol, 2); 

        sistema.completarActividad(josep, danza, 11);
        sistema.completarActividad(josep, yoga, 12);

        futbol.calificar(5);
        futbol.calificar(4);

        sistema.generarReporteGrado(josep);
        sistema.generarReporteGrado(eduardo);
    }
}