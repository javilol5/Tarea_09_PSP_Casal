# Tarea 09 - Descargas Cuánticas

---

## 📋 Niveles Realizados

- [x] **Nivel 1:** Descargas concurrentes
- [x] **Nivel 2:** Argumentos y Monitor
- [x] **Nivel 3:** Instalador y espera con límite

---

# Nivel 1 - Descargas concurrentes

En este nivel se implementan cuatro descargas que se ejecutan de forma **concurrente mediante hilos**.

El programa:

- Muestra el progreso de cada descarga en intervalos del **10 %**.
- Indica cuándo termina cada descarga.
- Muestra cuánto tiempo ha tardado cada descarga.
- Avisa cuando han terminado todas las descargas.
- Calcula el tiempo total real de ejecución.
- Calcula cuánto tardaría el programa si las descargas se ejecutasen de forma secuencial.

## 📊 Pruebas realizadas

Se ejecutó el programa tres veces para comprobar el funcionamiento de las descargas concurrentes.

| Ejecución | Descarga más lenta | Tiempo real (ms) | Suma de tiempos (ms) |
|:---:|:---:|---:|---:|
| **1** | 3112 ms | 3113 ms | 6967 ms |
| **2** | 3912 ms | 3913 ms | 11229 ms |
| **3** | 4342 ms | 4342 ms | 14329 ms |

### ❓ Preguntas Frecuentes

> **¿Por qué el tiempo real es mucho menor que la suma?**

> El tiempo real es mucho menor porque las descargas se ejecutan **simultáneamente** en diferentes hilos. Mientras una descarga espera mediante `Thread.sleep()`, las demás continúan ejecutándose. Por eso, el tiempo real se aproxima al de la descarga que más tarda, a diferencia de la suma.

> **¿Qué pasa si hacemos `start()` y `join()` dentro del mismo bucle?**

> Si ejecutamos:
> ```java
> for (int i = 0; i < descargas.length; i++) {
>     descargas[i].start();
>     descargas[i].join();
> }
> ```
> El programa esperará a que termine una descarga antes de continuar con la siguiente. Las descargas **dejan de ejecutarse de forma concurrente** y el tiempo real se aproximará a la suma de los tiempos individuales.
> *Resultado de la prueba:* Tiempo real obtenido: `12232 ms`


## Codigo Nivel 1

![](/images/codigo1.png)
---
# Nivel 2 - Argumentos y Monitor

En este nivel se mantiene el funcionamiento del **Nivel 1**, pero se añade un **monitor** para controlar el estado de las descargas y saber cuántas quedan por finalizar.

El programa:

- Ejecuta las descargas de forma concurrente.
- Muestra el progreso de cada descarga en intervalos del **10 %**.
- Indica cuándo termina cada descarga y cuánto tiempo ha tardado.
- Utiliza un **monitor** para controlar las descargas pendientes.
- Avisa cuando todas las descargas han finalizado.

## Codigo Nivel 2

Hace lo mismo que en el Nivel 1, implementando:
- [Monitor] que muestra cuantas descargas quedan

![](/images/codigo2.png)
---
El programa también puede ejecutarse directamente desde la terminal, pasando los nombres de los hilos como argumentos:

```bash
java .\GestorDescargas.java hilo1 hilo2 hilo3 hilo4
```
![](/images/codigoTerminal2.png)
---

# Nivel 3 - Instalador y espera con límite

En este nivel se amplía el funcionamiento del **Nivel 2**, añadiendo un sistema de espera con límite y un **Instalador**.

El programa incorpora:

- Un `Main` que controla el estado de las descargas.
- Comprueba si `meditacion.mp4` y `mantras.mp3` han terminado.
- Utiliza una espera con límite para controlar cuánto tiempo se espera a determinadas descargas.
- El `Instalador` se ejecuta cuando el `Main` ha terminado.
- Muestra un mensaje indicando cuándo finaliza la instalación.

## Codigo Nivel 3

![](/images/codigo3.png)





---


# 📌 Conclusiones

Con esta práctica se han trabajado diferentes conceptos de **programación concurrente en Java**:

- Creación y ejecución de hilos mediante `Thread`.
- Uso de `start()` para iniciar hilos.
- Uso de `join()` para esperar a que un hilo termine.
- Ejecución concurrente frente a ejecución secuencial.
- Medición y comparación de tiempos de ejecución.
- Uso de monitores para controlar varias tareas.
- Paso de argumentos desde la terminal.
- Coordinación entre diferentes hilos.
- Control de la finalización de tareas.
- Uso de esperas con límite.
- Coordinación entre el `Main` y el `Instalador`.

La práctica permite comprobar cómo la programación concurrente puede reducir considerablemente el tiempo total de ejecución cuando varias tareas pueden realizarse simultáneamente.

---

# 🤖 Declaración de uso de IA

Para la realización de esta práctica se ha utilizado **inteligencia artificial como herramienta de apoyo** para:

- Resolver dudas sobre programación concurrente en Java.
- Comprender el funcionamiento de `Thread`, `start()` y `join()`.
- Revisar y corregir errores en el código.
- Mejorar la documentación del proyecto.

![](/images/ia.png)
---



