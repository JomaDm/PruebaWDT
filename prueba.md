## 1.- Implementa una función que determine si una cadena de texto dada esta formada por caracteres únicos, considera mayúsculas, minúsculas.

```
    function hasUniqueCharacters(word) {
      let caracteres = new Set();
      for (caracter of word) {
        if (caracteres.has(caracter)) {
          return false;
        }
        caracteres.add(caracter);
      }
      return true;
    }
```

## 2.- Escribe un programa que guarde en un array e imprima los números primos dentro de un rango dado.

```
    function isPrime(number) {
      let aux = number;
      for (let i = aux - 1; i > 1; i--) {
        if (aux % i === 0) return false;
      }
      return true;
    }
    function primeNumbers(start, end) {
      let primos = [];
      start = start === 1 ? 2 : start;
      for (let i = start; i <= end; i++) {
        if (isPrime(i)) primos.push(i);
      }
      console.log(primos);
    }
```

## 3.- De las siguientes tablas realiza una consulta que obtenga:

Para los incisos referentes a la obtencion de datos se tendran en cuenta los siguientes datos en Java:

```
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

    grupoA.agregarListaAlumno(alumnos);
```

### A) El alumno con mejor promedio

Haciendo referencia al archivo de clases.java, y teniendo en cuenta que tenemos un Grupo completo de alumnos necesitariamos aplicar lo siguiente:

```
    Grupo grupoA = new Grupo(0);
    grupoA.agregarListaAlumno(listaAlumnos);
    Alumno alumnoMejorPromedio = grupoA.obtenerAlumnoPromedioMax();
```

Siendo asi, ahora tendriamos los datos del alumno con mejor promedio.

### B) Una lista de los alumnos ordenados por promedio de mayor a menor

```
    List<Alumno> promediosOrdenados = grupoA.listaPromediosOrdenados(true);
    System.out.println(promediosOrdenados);
```

### C) Una lista de los alumnos que reprobaron una materia como mínimo(Calificación menor a 6) e indica la materia.

Para el este ejecicio fue necesario agregar el siguiente registro:

```
    Alumno a4 = new Alumno("12234", "Ricardo", "Rodriguez", "Flores");
    a4.agregarCalificacion(new Calificacion("12234", 4, 3));
    a4.agregarCalificacion(new Calificacion("12234", 1, 10));
    a4.agregarCalificacion(new Calificacion("12234", 3, 10));
    alumnos.add(a4);
```

Posteriormente se manda a llamar al siguiente metodo para obtener los alumnos que reprobaron al menos alguna materia:

```
    List<Alumno> alumnosConMateriasReprobadas = grupoA.listaAlumnosMateriasReprobadas();
    System.out.println(alumnosConMateriasReprobadas);
```

### D) Realiza el diagrama Entidad-Relación de las tablas.

    archivo: Diagrama_Entidad_Relacion.png

### E) Escribe las clases en Java para representarlas.

     archivo: clases.java

## 4.- Dado el siguiente arreglo:

    let alumnos = [
      {
        nombre: 'Jesús',
        apellidoP: 'Paniagua',
        apellidoM: 'Hernández',
        parcial1: 6,
        parcial2: 5,
        parcial3: 10,
      },
      {
        nombre: 'Mauricio',
        apellidoP: 'Salgado',
        apellidoM: 'Flores',
        parcial1: 8,
        parcial2: 10,
        parcial3: 9,
      },
      {
        nombre: 'Diana',
        apellidoP: 'Lopez',
        apellidoM: 'García',
        parcial1: 6,
        parcial2: 5,
        parcial3: 0,
      },
    ];

### A) Escriba el código en javascript para que construya la siguiente tabla, resalta la fila en color rojo de los alumnos con promedio reprobatorio (menor a 6)

    archivo: prueba.html

## 5.- Conteste las siguientes preguntas:

### 1) ¿Cuál es la diferencia entre una clase y un objeto?

Un objeto es una instancia de una clase, y una clase consiste en un modelo que generalmente es una representacion.

### 2) ¿En qué consiste la arquitectura MVC?

La arquitectura MVC consiste en un modelado de 3 principios basicos "Modelo","Vista" y "Controlador", en donde el Modelo actua como las restricciones o logica de un sistema, la Vista constituye a como se vera representado el sistema a nivel visual, y el Controlador constituye en todas las adaptaciones representativas externas a nivel sistema.

### 3) ¿Para que utilizas el versionamiento en un proyecto? ¿Has utilizado alguno?

Para tener un mejor control sobre los archivos de un proyecto, este se encarga de manejar todos los cambios que hayan en un archivo o archivos y otorga la opcion de descartar los cambios o guardarlos ya sea de manera local o en algun sistema de almacenamiento. Particularmente he manejado Git/Github.

### 4) Enlista y explica al menos 3 comandos de la herramienta de versionamiento que conozcas

- git status : muestra el estatus de los archivos de un proyecto
- git commit : guarda los cambios de manera local
- git pull : descarga los cambios que hayan habido en el proyecto, en caso de no haber, no se realiza la descarga

### 5) ¿Para qué sirve la función “split()”?

Sirve para separar una cadea segun el caracter que le demos como argumento, es decir, si se desea separar por "," deberia ejecutarse de la siguiente manera:

```
    cadena.split(",");
```

### 6) Mencione al menos 3 sentencias de control de flujo.

if, for y while.

### 7) ¿Qué es un “Store Procedure” en MySQL?

### 8) ¿Qué entiendes por “framework”? ¿Cuáles conoces?

Un framework es una serie de funciones que facilitan el uso de algun lenguaje o biblioteca. En mi caso conozco varios, para Javascript, conozco NextJS (Framework de React), Vue y JQuery. Para Dart conozco Flutter y para Python conozco Flask y un poco Django.

### 9) ¿Qué IDE’s conoces? ¿Cuáles has manejado?

No he manejado muchos IDE's, ya que uso particularmente el editor de codigo Visual Studio Code, sin embargo, he usado Netbeans, Dev C++, Android Studio y Pycharm.

### 10) ¿Cuántos cuadros hay en la imagen de la derecha?
42

### 11) ¿Cuáles son tus mejores habilidades?
Aprender cosas nuevas, me gusta programar y que los proyectos que realice se usen en verdad y ayuden a las personas.

### 12) ¿Cómo te enteraste de la oferta laboral de Wundertec?

Porque un amigo me comento sobre la oferta laboral y decidi aplicar.

### 13) ¿Qué esperas de Wundertec?
Espero poder aprender y poder continuar desarrollandome profesionalmente.
