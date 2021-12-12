import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class clases {

  public static void main(String[] args) {
    Grupo grupoA = new Grupo(0);
    List<Alumno> alumnos = new ArrayList<Alumno>();

    Alumno a1 = new Alumno("1234", "Luis", "Rodriguez", "Flores");
    a1.agregarCalificacion(new Calificacion("1234", 1, 8));
    a1.agregarCalificacion(new Calificacion("1234", 2, 8));
    a1.agregarCalificacion(new Calificacion("1234", 3, 9));
    alumnos.add(a1);

    Alumno a2 = new Alumno("1233", "Carlos", "Rodriguez", "Flores");
    a2.agregarCalificacion(new Calificacion("1233", 4, 10));
    a2.agregarCalificacion(new Calificacion("1233", 1, 9));
    a2.agregarCalificacion(new Calificacion("1233", 3, 9));
    alumnos.add(a2);

    Alumno a3 = new Alumno("1223", "Juan", "Rodriguez", "Flores");
    a3.agregarCalificacion(new Calificacion("1223", 4, 10));
    a3.agregarCalificacion(new Calificacion("1223", 1, 10));
    a3.agregarCalificacion(new Calificacion("1223", 3, 10));
    alumnos.add(a3);

    Alumno a4 = new Alumno("12234", "Ricardo", "Rodriguez", "Flores");
    a4.agregarCalificacion(new Calificacion("12234", 4, 3));
    a4.agregarCalificacion(new Calificacion("12234", 1, 10));
    a4.agregarCalificacion(new Calificacion("12234", 3, 10));
    alumnos.add(a4);

    grupoA.agregarListaAlumno(alumnos);

    System.out.println("Promedios ordenados:");
    List<Alumno> promediosOrdenados = grupoA.listaPromediosOrdenados(true);
    System.out.println(promediosOrdenados);
    System.out.println("Alumno con mejor promedio:");
    Alumno alumnoMejorPromedio = grupoA.obtenerAlumnoPromedioMax();
    System.out.println(alumnoMejorPromedio);
    System.out.println("Alumnos con materias reprobadas:");
    List<Alumno> alumnosConMateriasReprobadas = grupoA.listaAlumnosMateriasReprobadas();
    System.out.println(alumnosConMateriasReprobadas);
  }
}

class Grupo {
  private int idGrupo;
  private List<Alumno> alumnos = new ArrayList<Alumno>();

  public Grupo(int idGrupo) {
    this.idGrupo = idGrupo;
  }

  public void agregarListaAlumno(List<Alumno> alumnos) {
    this.alumnos = alumnos;
  }

  public void addAlumnos(Alumno alumno) {
    this.alumnos.add(alumno);
  }

  public void removeAlumnos(Alumno alumno) {
    this.alumnos.remove(alumno);
  }

  public Integer numeroDeAlumnos() {
    return alumnos.size();
  }

  public List<Alumno> listaAlumnosMateriasReprobadas() {
    List<Alumno> alumnosRepr = new ArrayList<Alumno>();
    for (Alumno alumno : this.alumnos) {
      List<Calificacion> calificaciones = alumno.filtrarMaterias(false);
      if (calificaciones.size() > 0) {
        alumnosRepr.add(alumno);
      }
    }
    return alumnosRepr;
  }

  private List<Double> obtenerListaPromedios() {
    List<Double> promedios = new ArrayList<Double>();

    for (Alumno alumnos : this.alumnos) {
      promedios.add(alumnos.obtenerPromedio());
    }
    return promedios;
  }

  public List<Alumno> listaPromediosOrdenados(boolean mayorAMenor) {
    List<Alumno> alumnosOrdenados = this.alumnos;

    // System.out.println(alumnosOrdenados);
    alumnosOrdenados.sort(new Comparator<Alumno>() {
      @Override
      public int compare(Alumno a1, Alumno a2) {
        double promedio1 = a1.obtenerPromedio();
        double promedio2 = a2.obtenerPromedio();

        if (mayorAMenor) {
          if (promedio1 > promedio2) {
            return -1;
          }
          return 1;
        }
        if (promedio1 < promedio2) {
          return -1;
        }
        return 1;
      }
    });
    return alumnosOrdenados;
  }

  public Alumno obtenerAlumnoPromedioMax() {
    List<Double> promedios = this.obtenerListaPromedios();

    Double max = promedios.get(0);
    int index = 0;

    for (int i = 0; i < promedios.size(); i++) {
      double promedio = promedios.get(i);
      if (max < promedio) {
        max = promedio;
        index = i;
      }
    }
    return this.alumnos.get(index);
  }
}

class Alumno {
  private String curp;
  private String nombre;
  private String apellidoP;
  private String apellidoM;
  protected List<Calificacion> calificaciones = new ArrayList<Calificacion>();

  public Alumno(String curp, String nombre, String apellidoP, String apellidoM) {
    this.curp = curp;
    this.nombre = nombre;
    this.apellidoP = apellidoP;
    this.apellidoM = apellidoM;
  }

  public List<Calificacion> filtrarMaterias(boolean aprobadas) {
    List<Calificacion> calificacionesFiltradas = new ArrayList<Calificacion>();
    for (Calificacion calf : this.calificaciones) {
      double calificacion = calf.getCalificacion();
      if (aprobadas && calificacion >= 6) {
        calificacionesFiltradas.add(calf);
      } else if (!aprobadas && calificacion < 6) {
        calificacionesFiltradas.add(calf);
      }
    }
    return calificacionesFiltradas;
  }

  public List<Calificacion> obtenerCalificaciones() {
    return this.calificaciones;
  }

  public double obtenerPromedio() {
    int aux = 0;
    for (Calificacion calf : this.calificaciones) {
      aux += calf.getCalificacion();
    }
    return (double) aux / this.calificaciones.size();
  }

  public void agregarCalificacion(Calificacion calf) {
    this.calificaciones.add(calf);
  }

  public boolean equals(Alumno alumno) {
    return this.curp == alumno.curp && this.nombre == alumno.nombre && this.apellidoP == alumno.apellidoP
        && this.apellidoM == alumno.apellidoM;
  }

  @Override
  public String toString() {
    String repr = "Nombre: " + this.nombre + " Apellidos: " + this.apellidoP + " " + this.apellidoM;
    for (Calificacion calificacion : this.calificaciones) {
      repr += "\n" + calificacion;
    }
    repr += "\nPromedio: " + String.format("%.2f", this.obtenerPromedio());
    return repr;
  }
}

class Calificacion {
  private String curp;
  protected Integer idMateria;
  protected Integer calificacion;

  public Calificacion(String curp, Integer idMateria, Integer calificacion) {
    this.curp = curp;
    this.idMateria = idMateria;
    this.calificacion = calificacion;
  }

  public double getCalificacion() {
    return this.calificacion;
  }

  @Override
  public String toString() {
    String repr = "Materia: " + Materia.idMateria(idMateria).getNombre() + " calificacion: " + this.calificacion;
    return repr;
  }
}

class Materia {
  private Integer idMateria;
  protected String materia;

  public Materia(Integer idMateria, String materia) {
    this.idMateria = idMateria;
    this.materia = materia;
  }

  public Integer getId() {
    return this.idMateria;
  }

  public String getNombre() {
    return this.materia;
  }

  public static List<Materia> listaMaterias() {
    List<Materia> listaMaterias = new ArrayList<Materia>();
    listaMaterias.add(new Materia(1, "Matematicas"));
    listaMaterias.add(new Materia(2, "Geografia"));
    listaMaterias.add(new Materia(3, "Ciencias"));
    listaMaterias.add(new Materia(4, "Musica"));
    return listaMaterias;
  }

  public static Materia idMateria(Integer idMateria) {
    List<Materia> listaMaterias = Materia.listaMaterias();
    for (Materia materia : listaMaterias) {
      if (idMateria == materia.getId()) {
        return materia;
      }
    }
    return null;
  }
}