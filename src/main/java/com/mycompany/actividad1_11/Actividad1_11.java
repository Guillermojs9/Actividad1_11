package com.mycompany.actividad1_11;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad1_11 {

    public static void main(String[] args) {
        try {
            File inputJsonFile = new File("./ficheros/estudiantes.json");
            ArrayList<String> estudiantesPares = new ArrayList<>();
            ArrayList<String> estudiantesImpares = new ArrayList<>();
            RandomAccessFile raf = new RandomAccessFile("./ficheros/estudiantes.dat", "rw");
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(inputJsonFile.getPath()));
            Estudiantado estudiantadoJson = gson.fromJson(reader, Estudiantado.class);
            Collections.sort(estudiantadoJson.getEstudiantes(), (Estudiante e1, Estudiante e2) -> Integer.compare(e1.getIdMatricula(), e2.getIdMatricula()));
            raf.setLength(0);
            for (Estudiante e : estudiantadoJson.getEstudiantes()) {
                raf.writeInt(e.getIdMatricula());
                escribirStringTruncado(raf, e.getNombre(), 20);
                escribirStringTruncado(raf, e.getTelefono(), 20);
                escribirStringTruncado(raf, e.getEmail(), 20);
                escribirStringTruncado(raf, e.getDireccion().getCalle(), 20);
                raf.writeInt(e.getDireccion().getNumero());
                raf.writeInt(e.getDireccion().getPiso());
                escribirStringTruncado(raf, e.getDireccion().getLetra(), 5);
                raf.writeInt(e.getDireccion().getCp());
                escribirStringTruncado(raf, e.getMatricula().getFirst().getId(), 5);
                escribirStringTruncado(raf, e.getMatricula().getFirst().getDenominacion(), 20);
                raf.writeInt(e.getMatricula().getFirst().getHoras());
                escribirStringTruncado(raf, e.getMatricula().getLast().getId(), 5);
                escribirStringTruncado(raf, e.getMatricula().getLast().getDenominacion(), 20);
                raf.writeInt(e.getMatricula().getLast().getHoras());
            }
            raf.seek(0);
            while (raf.getFilePointer() < raf.length()) {
                int idMatricula = raf.readInt();
                String nombre = readFixedString(raf, 20);
                String telefono = readFixedString(raf, 20);
                String email = readFixedString(raf, 20);
                String calle = readFixedString(raf, 20);
                int numero = raf.readInt();
                int piso = raf.readInt();
                String letra = readFixedString(raf, 5);
                int cp = raf.readInt();
                String idModulo1 = readFixedString(raf, 5);
                String denominacion1 = readFixedString(raf, 20);
                int horas1 = raf.readInt();
                String idModulo2 = readFixedString(raf, 5);
                String denominacion2 = readFixedString(raf, 20);
                int horas2 = raf.readInt();
                String registro = String.format("ID: %d, Nombre: %s, Telefono: %s, Email: %s, Direccion: %s %d, Piso: %d, Letra: %s, CP: %d, "
                        + "Modulo 1 ID: %s, Denominacion: %s, Horas: %d, Modulo 2 ID: %s, Denominacion: %s, Horas: %d",
                        idMatricula, nombre, telefono, email, calle, numero, piso, letra, cp,
                        idModulo1, denominacion1, horas1, idModulo2, denominacion2, horas2);
                if (idMatricula % 2 == 0) {
                    estudiantesPares.add(registro);
                } else {
                    estudiantesImpares.add(registro);
                }
            }
            raf.close();
            System.out.println("Registros en posiciones pares:");
            for (String estudiante : estudiantesPares) {
                System.out.println(estudiante);
            }

            System.out.println("\nRegistros en posiciones impares:");
            for (String estudiante : estudiantesImpares) {
                System.out.println(estudiante);
            }

        } catch (IOException ex) {
            Logger.getLogger(Actividad1_11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void escribirStringTruncado(RandomAccessFile raf, String valor, int length) {
        try {
            byte[] bytes = valor.getBytes(StandardCharsets.UTF_8);
            if (bytes.length > length) {
                raf.write(bytes, 0, length);
            } else {
                raf.write(bytes);
                raf.write(new byte[length - bytes.length]);
            }
        } catch (IOException ex) {
            Logger.getLogger(Actividad1_11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static String readFixedString(RandomAccessFile raf, int length) throws IOException {
        byte[] bytes = new byte[length];
        raf.readFully(bytes);
        return new String(bytes, StandardCharsets.UTF_8).trim();
    }
}
