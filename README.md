# Gestión de Productos - Patrón Memento y Observer

Este proyecto es una aplicación de escritorio en Java que implementa los patrones de diseño **Memento** y **Observer**. El propósito de la aplicación es gestionar productos, permitiendo agregar, modificar, y deshacer cambios en una lista de productos. La interfaz de usuario se actualiza automáticamente mediante el patrón Observer, mientras que el patrón Memento guarda el estado de los productos para poder deshacer cambios.

## Patrones de Diseño Implementados

### 1. **Patrón Memento**
El patrón **Memento** permite almacenar el estado interno de un objeto sin exponer su estructura. En este proyecto, el patrón Memento se utiliza para almacenar el estado de la lista de productos. Cada vez que se agrega o modifica un producto, el estado anterior se guarda en un objeto `Memento`. Si el usuario desea deshacer una acción, el estado se puede restaurar utilizando el `Memento` guardado previamente.

**Clases relacionadas con el patrón Memento:**
- `Memento`: Esta clase encapsula el estado de los productos y proporciona una manera de restaurar ese estado.
- `Controlador`: Guarda el estado de los productos antes de realizar cualquier cambio y restaura el estado anterior cuando se deshace una acción.

### 2. **Patrón Observer**
El patrón **Observer** permite a un objeto (el sujeto) notificar a otros objetos (observadores) sobre cambios en su estado. En este proyecto, el patrón Observer se utiliza para que la interfaz de usuario (Vista) se actualice automáticamente cada vez que la lista de productos cambia. La clase `Vista` actúa como un observador y se actualiza cuando el controlador realiza un cambio en los productos.

**Clases relacionadas con el patrón Observer:**
- `Observable`: Esta clase mantiene una lista de observadores (en este caso, la `Vista`) y los notifica cuando ocurre un cambio.
- `Vista`: Implementa la interfaz `Observer` y actualiza la lista visual de productos cuando se recibe una notificación de cambio.
- `Controlador`: Controla las acciones del usuario, como agregar y modificar productos, y notifica a los observadores cuando se realizan cambios.

## Características

- **Agregar Producto**: Permite agregar nuevos productos a la lista ingresando su nombre y precio.
- **Modificar Producto**: Permite modificar un producto ya existente seleccionándolo de la lista.
- **Deshacer Cambios**: Permite deshacer la última modificación realizada en la lista de productos.

## Requisitos

- Java 8 o superior
- IDE recomendado: IntelliJ IDEA, Eclipse o cualquier otro que soporte Java

## Instrucciones de Uso

### 1. Clonación del repositorio
Para clonar este proyecto en tu máquina local, usa el siguiente comando en tu terminal o línea de comandos:

```bash
git clone https://github.com/tu-usuario/gestion-productos.git
