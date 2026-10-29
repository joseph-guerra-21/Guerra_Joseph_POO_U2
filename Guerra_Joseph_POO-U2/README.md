# Proyecto audiovisual — POO Unidad 2

Autor: Joseph Guerra.

Proyecto Java que aplica herencia, encapsulamiento, polimorfismo
y relaciones entre objetos.

## Requisitos

- JDK 25.
- Eclipse IDE con soporte para Java.
- Codificación UTF-8.

## Instalación

1. Descargar este repositorio desde Code → Download ZIP y descomprimirlo.
2. En Eclipse, seleccionar File → Import →
   General → Existing Projects into Workspace.
3. Seleccionar la carpeta que contiene el archivo .project.
4. Pulsar Finish.
5. Comprobar que el proyecto tiene configurado un JDK 25.

## Estructura

- src/uni1a: ContenidoAudiovisual y sus cinco subclases.
- src/un1a: Actor, Temporada e Investigador.
- src/poo: clase ejecutable PruebaRelaciones.

## Clases y relaciones

ContenidoAudiovisual es una clase abstracta.

Pelicula, SerieDeTV, Documental, PodcastEducativo y ClaseVirtual
heredan de ContenidoAudiovisual.

- Agregación: Pelicula reúne actores que pueden compartirse
  con otras películas.
- Composición: SerieDeTV crea y administra sus temporadas.
- Asociación: Documental puede tener un investigador.
- Asociación: PodcastEducativo puede tener un investigador asesor.
- Asociación: ClaseVirtual puede tener un investigador instructor.

## Ejecución y pruebas

1. Abrir src/poo/PruebaRelaciones.java.
2. Hacer clic derecho → Run As → Java Application.
3. Consultar la salida en Console.

Resultado esperado al finalizar:

PRUEBAS SUPERADAS: 15

Las comprobaciones incluyen agregar y retirar actores,
evitar duplicados, crear y retirar temporadas, asignar y
desvincular investigadores, asesores e instructores,
y rechazar una materia vacía.

También se recorren cinco contenidos mediante referencias
de tipo ContenidoAudiovisual para demostrar el polimorfismo.

## Proyecto de origen

Este trabajo amplía el proyecto educativo:
https://github.com/CS-Programacion-Orientada-Objetos/poo_unidad1