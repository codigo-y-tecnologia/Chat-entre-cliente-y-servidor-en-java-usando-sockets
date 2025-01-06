/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javier
 */
public class Cliente {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("127.0.0.1", 5000);
            System.out.println("Estamos conectados al servidor");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            InputStreamReader input = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(input);

            //Hilo para enviar mensajes al servidor
            Thread enviarMensajes = new Thread(() -> {

                Scanner sc = new Scanner(System.in);

                while (true) {
                    System.out.println("Envía tu mensaje al servidor (ó escribe exit para salir) : ");
                    String mensaje = sc.nextLine();
                    writer.println(mensaje);

                    if (mensaje.equals("exit")) {
                        try {
                            writer.println(mensaje);
                            writer.close();
                            socket.close();
                            System.out.println("Adiós");
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });

            //Hilo para leer mensajes del servidor
            Thread recibirMensajes = new Thread(() -> {

                String respuestaDelServidor;

                try {

                    while ((respuestaDelServidor = reader.readLine()) != null) {
                        System.out.println("Respuesta del servidor: " + respuestaDelServidor);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });

            enviarMensajes.start();
            recibirMensajes.start();

            try {
                enviarMensajes.join();
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
            try {
                recibirMensajes.join();
            } catch (InterruptedException ex) {
                System.out.println("Error: " + ex.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}
