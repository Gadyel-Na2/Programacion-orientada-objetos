/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package materia;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author aldopazmendiola
 */
class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    // Constructor por defecto
    public Materia() {}

    // Constructor con parámetros
    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }

    // Constructor de copia
    public Materia(Materia otraMateria) {
        this.nombre = otraMateria.nombre;
        this.clave = otraMateria.clave;
        this.creditos = otraMateria.creditos;
        this.horasSemanales = otraMateria.horasSemanales;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public int getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(int horasSemanales) { this.horasSemanales = horasSemanales; }
}

class Profesor {
    private String nombre;
    private int numeroNomina;
    private double sueldoPorHora;
    private Materia materia;

    // Constructor por defecto
    public Profesor() {}

    // Constructor con parámetros
    public Profesor(String nombre, int numeroNomina, double sueldoPorHora, Materia materia) {
        this.nombre = nombre;
        this.numeroNomina = numeroNomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = materia;
    }

    // Constructor de copia
    public Profesor(Profesor otroProfesor) {
        this.nombre = otroProfesor.nombre;
        this.numeroNomina = otroProfesor.numeroNomina;
        this.sueldoPorHora = otroProfesor.sueldoPorHora;
        this.materia = otroProfesor.materia != null ? new Materia(otroProfesor.materia) : null;
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNumeroNomina() { return numeroNomina; }
    public void setNumeroNomina(int numeroNomina) { this.numeroNomina = numeroNomina; }
    public double getSueldoPorHora() { return sueldoPorHora; }
    public void setSueldoPorHora(double sueldoPorHora) { this.sueldoPorHora = sueldoPorHora; }
    public Materia getMateria() { return materia; }
    public void setMateria(Materia materia) { this.materia = materia; }

    // Método funcional
    public double calcularSueldoSemanal() {
        return materia != null ? sueldoPorHora * materia.getHorasSemanales() : 0;
    }
}

class Alumno {
    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso;

    // Constructor por defecto
    public Alumno() {}

    // Constructor con parámetros
    public Alumno(String matricula, String nombre, int edad, Curso curso) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    // Constructor de copia
    public Alumno(Alumno otroAlumno) {
        this.matricula = otroAlumno.matricula;
        this.nombre = otroAlumno.nombre;
        this.edad = otroAlumno.edad;
        this.curso = otroAlumno.curso != null ? new Curso(otroAlumno.curso) : null;
    }

    // Getters y setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}

class Curso {
    private String nombre;
    private List<Materia> materias = new ArrayList<>();

    // Constructor por defecto
    public Curso() {}

    // Constructor con parámetros
    public Curso(String nombre) {
        this.nombre = nombre;
    }

    // Constructor de copia
    public Curso(Curso otroCurso) {
        this.nombre = otroCurso.nombre;
        for (Materia m : otroCurso.materias) {
            this.materias.add(new Materia(m));
        }
    }

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public List<Materia> getMaterias() { return materias; }
    public void setMaterias(List<Materia> materias) { this.materias = new ArrayList<>(materias); }

    // Método funcional
    public void agregarMateria(Materia materia) {
        if (this.materias.size() < 3) {
            this.materias.add(materia);
        } else {
            System.out.println("El curso ya tiene 3 materias asignadas.");
        }
    }

    public int calcularCreditosTotales() {
        return materias.stream().mapToInt(Materia::getCreditos).sum();
    }
}

public class ProgramaEscolar {
    public static void main(String[] args) {
        // Creación de objetos Materia
        Materia matematicas = new Materia("Matemáticas", "MAT001", 5, 4);
        Materia fisica = new Materia("Física", "FIS001", 4, 3);
        Materia quimica = new Materia("Química", "QUI001", 4, 3);

        // Creación de un curso
        Curso cursoCiencias = new Curso("Ciencias Básicas");
        cursoCiencias.agregarMateria(matematicas);
        cursoCiencias.agregarMateria(fisica);
        cursoCiencias.agregarMateria(quimica);

        // Creación de profesor
        Profesor profeJuan = new Profesor("Juan Pérez", 12345, 25.0, matematicas);

        // Creación de alumno
        Alumno estudiantePedro = new Alumno("A001", "Pedro López", 18, cursoCiencias);

        // Pruebas funcionales
        System.out.println("Sueldo semanal de Juan: $" + profeJuan.calcularSueldoSemanal());
        System.out.println("Créditos totales del curso de " + estudiantePedro.getNombre() + ": " + estudiantePedro.getCurso().calcularCreditosTotales());
    }
}