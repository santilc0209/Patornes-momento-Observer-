# 🛠️ Gestor de Productos - Patrones Memento y Observer (Java MVC + Swing)

Este proyecto es una aplicación de escritorio desarrollada en Java que implementa los patrones de diseño **Memento** y **Observer** para la gestión de productos automotrices. El sistema permite agregar, modificar y deshacer cambios en productos, manteniendo una arquitectura limpia basada en **Modelo-Vista-Controlador (MVC)**.

---

## 📌 Características Principales

- ✅ Interfaz gráfica con Java Swing.
- ✅ Agregado y modificación de productos (nombre y precio).
- ✅ Deshacer cambios mediante el patrón **Memento**.
- ✅ Actualización automática de la vista con el patrón **Observer**.
- ✅ Arquitectura escalable y mantenible con separación clara entre modelo, vista y controlador.

---

## 🧠 Patrones de Diseño Implementados

### 🔁 Memento
Permite guardar y restaurar el estado de la lista de productos. Cada vez que se realiza una acción, se guarda un memento con el estado anterior, lo que habilita la opción de **"Deshacer"**.

- `ProductoMemento`: Clase que encapsula el estado anterior.
- `ProductoModel`: Administra la creación y restauración de mementos.

### 👁️ Observer
La vista se actualiza automáticamente cada vez que el modelo sufre un cambio. Esto se logra con el patrón Observer.

- `Observer` (interfaz)
- `Vista`: Observador que implementa el método `actualizar`.
- `ProductoModel`: Sujeto observado que notifica cambios.

---

## 📐 Arquitectura MVC

- **Modelo** (`modelo/`):
  - `Caretaker.java`: Clase que gestiona el almacenamiento y recuperación de los mementos.
  - `Observable.java`: Interfaz que permite a las clases observar el modelo.
  - `Observer.java`: Interfaz implementada por las vistas para recibir actualizaciones.
  - `Producto.java`: Representación de los productos, con atributos como nombre y precio.
  - `ProductoModel.java`: Modelo que gestiona la lista de productos y los mementos.
  - `ProductoMemento.java`: Memento que guarda el estado de un producto.
  - `Subject.java`: Clase base para gestionar los observadores y notificar cambios.

- **Vista** (`vista/`):
  - `Vista.java`: Interfaz gráfica con Swing que se actualiza automáticamente con el patrón Observer.

- **Controlador** (`controlador/`):
  - `Controlador.java`: Conecta la lógica entre vista y modelo, gestionando la interacción del usuario.

- **Aplicación Principal**:
  - `App.java`: Clase principal que inicializa la aplicación.

---

## 🚀 Cómo ejecutar el proyecto

1. Asegúrate de tener instalado Java 17 o superior.
2. Clona este repositorio o descarga el código fuente.
3. Compila los archivos desde tu IDE favorito (Eclipse, IntelliJ, VS Code) o por terminal.
4. Ejecuta la clase `App.java` como programa principal.

---

## 🖼️ Capturas de pantalla *(opcional)*

> Puedes agregar aquí imágenes de la interfaz en funcionamiento.

---

## 📂 Estructura del Proyecto

co.edu.poli.corte3/ 
│ ├── controlador/ 
│ └── Controlador.java 
│ │
│ ├── modelo/  
│ ├── Producto.java  
│ ├── ProductoModel.java 
│ ├── Caretaker.java 
│ ├── Subject.java 
│ ├── Observable.java 
│ ├── ProductoMemento.java 
│ └── Observer.java 
│ │
│ └── vista/ 
│ └── Vista.java
├── App.java 



## 👨‍🎓 Autor

Desarrollado por **[Juanna Naranjo, Santiagos]** como parte del proyecto académico del curso de Ingeniería de Software 2 - Universidad Politécnico GranColombiano.

---

## 📄 Licencia

Este proyecto está bajo la Licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente.

--

## 📝 Descripción de las Clases

### **Modelo**

- **Caretaker.java**: Gestiona los mementos, almacenando y recuperando el estado de los productos para permitir el deshacer de cambios.
- **Observable.java**: Interfaz que permite a las clases ser observadas por otras.
- **Observer.java**: Interfaz que define el método `actualizar()` para notificar a las vistas cuando se producen cambios en el modelo.
- **Producto.java**: Clase que representa un producto con atributos básicos como nombre y precio.
- **ProductoModel.java**: Gestiona la lista de productos y notifica a los observadores (vistas) cuando los productos son agregados, modificados o eliminados.
- **ProductoMemento.java**: Clase que guarda el estado de un producto para poder restaurarlo más tarde, permitiendo el patrón Memento.
- **Subject.java**: Clase base para los objetos observados. Gestiona la lista de observadores y notifica cuando hay cambios en el estado.

### **Vista**

- **Vista.java**: Es la interfaz gráfica de la aplicación. Implementa el patrón Observer, actualizando la vista cada vez que el modelo cambia.

### **Controlador**

- **Controlador.java**: Actúa como intermediario entre la vista y el modelo, gestionando la lógica del negocio y la interacción del usuario.

### **Aplicación Principal**

- **App.java**: Clase principal que inicializa el sistema y la interfaz gráfica, estableciendo la conexión entre el modelo, la vista y el controlador.

---

Este `README.md` ahora está completo y actualizado con todas las clases necesarias para tu proyecto. Si necesitas agregar más detalles o alguna mejora, no dudes en indicármelo.
