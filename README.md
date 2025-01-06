# Chat Cliente-Servidor con Sockets 💬

Este proyecto es una aplicación de chat desarrollada en Java utilizando sockets. Permite la comunicación entre un cliente y un servidor en una red local. Fue creado con **NetBeans** y está diseñado como un ejemplo educativo para entender el uso de sockets en Java.

## 📋 Características
- ✅ Comunicación en tiempo real entre cliente y servidor.
- ✅ Soporte para múltiples mensajes por sesión.
- ✅ Interfaz gráfica básica para enviar y recibir mensajes.
- ✅ Ejemplo claro del uso de `ServerSocket` y `Socket` en Java.

## 🚀 Requisitos
Antes de ejecutar el proyecto, asegúrate de tener instalado:
- **Java 21** (o compatible).
- **NetBeans IDE** (cualquier versión reciente).
- Sistema operativo: Windows, Linux o macOS.

## 🛠️ Configuración e instalación
1. Clona este repositorio:
   ```bash
   git clone https://github.com/codigo-y-tecnologia/Chat-entre-cliente-y-servidor-en-java-usando-sockets.git
2. Abre el proyecto en NetBeans.
3. Compila los archivos de código fuente:
  - Servidor_Grafico.java
  - Cliente_Grafico.java
4. Asegúrate de que las configuraciones de red sean válidas:
  - El servidor utiliza el puerto 5000 (puedes cambiarlo en el código).

## 📖 Uso
### Paso 1: Ejecutar el servidor
 1. Abre la clase Servidor_Grafico en NetBeans.
 2. Ejecuta el programa.
 3. El servidor estará escuchando conexiones en el puerto configurado.
### Paso 2: Conectar el cliente
 1. Abre la clase Cliente_Grafico en NetBeans.
 2. Ejecuta el programa.
 3. Introduce la dirección IP del servidor (o localhost si estás en la misma máquina).
 4. Escribe y envía mensajes para comunicarse con el servidor.

## 📚 Ejemplo de salida
### Cliente:
 Conectado al servidor
> Hola, servidor.
### Servidor: 
> Servidor en espera de conexiones...
> Cliente conectado...
> El cliente dice: Hola, servidor.

## 📝 Notas importantes
   - Este proyecto está diseñado para redes locales. Para usarlo en internet, se deben configurar puertos y acceso remoto.

## 🤝 Contribuir
¡Siéntete libre de abrir un issue o enviar un pull request para mejorar este proyecto!

## 🛡️ Licencia
Este proyecto está bajo la Licencia MIT. Puedes usarlo, modificarlo y compartirlo libremente.

## 🌐 Enlaces útiles
- [Documentación oficial de Java Sockets](https://docs.oracle.com/javase/tutorial/networking/sockets/)
