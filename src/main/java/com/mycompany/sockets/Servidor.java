/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author javier
 */
public class Servidor {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader reader = null;
        PrintWriter writer = null;

        try {

            serverSocket = new ServerSocket(5000);
            System.out.println("Servidor en espera de conexiones");

            socket = serverSocket.accept();
            System.out.println("El cliente se ha conectado");

            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            final BufferedReader finalReader = reader;
            final PrintWriter finalWriter = writer;

            //Hilo para leer mensajes del cliente
            Thread leerMensajes = new Thread(() -> {
                String mensaje;

                try {

                    while ((mensaje = finalReader.readLine()) != null) {

                        if (mensaje.equals("exit")) {
                            System.out.println("El cliente ha terminado la sesión");
                            break;
                        }
                        System.out.println("Mensaje del cliente: " + mensaje);
                        System.out.println("Respuesta para el cliente: ");

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            });

            //Hilo para enviar mensajes al cliente
            Thread enviarMensajes = new Thread(() -> {

                Scanner sc = new Scanner(System.in);

                while (true) {

                    String respuestaAlCliente = sc.nextLine();
                    finalWriter.println(respuestaAlCliente);
                }

            });

            //Iniciar ambos hilos
            leerMensajes.start();
            enviarMensajes.start();

            try {
                //Esperar a que ambos hilos terminen
                leerMensajes.join();
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            try {
                enviarMensajes.join();
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (serverSocket != null) {
                    serverSocket.close();
                }

                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el servidor: " + e.getMessage());
            }
        }
    }
}
