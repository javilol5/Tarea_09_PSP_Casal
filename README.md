# Tarea 09 - Descargas Cuánticas

---

## 📋 Niveles Realizados

- [x] **Nivel 1:** Descargas concurrentes
- [x] **Nivel 2:** Argumentos y Monitor
- [x] **Nivel 3:** Instalador y espera con límite

---

### Pruebas del Nivel 1
Se ha ejecutado el programa tres veces para comprobar el funcionamiento de las descargas concurrentes:

| Ejecución | Descarga más lenta | Tiempo real (ms) | Suma (ms) |
| :---: | :--- | :---: | :---: |
| **1** | 3112ms | 3113ms | 6967ms |
| **2** | 3912ms | 3913ms | 11229ms |
| **3** | 4342ms | 4342ms | 14329ms |

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


---

## 🤖 Declaración de Uso de IA

---

