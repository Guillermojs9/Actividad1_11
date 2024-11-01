package com.mycompany.actividad1_11;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Actividad1_11 {

    public static void main(String[] args) {
        try {
            File inputXmlFile = new File("./ficheros/estudiantes.xml");
            File inputJsonFile = new File("./ficheros/estudiantes.json");
            JAXBContext contexto = JAXBContext.newInstance(Estudiantado.class);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            Estudiantado estudiantadoXml = (Estudiantado) unmarshaller.unmarshal(inputXmlFile);
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(inputJsonFile.getPath()));
            Estudiantado estudiantadoJson = gson.fromJson(reader, Estudiantado.class);
            System.out.println(estudiantadoXml);
            for (Estudiante e : estudiantadoXml.getEstudiantes()) {
                System.out.println(e);
            }
            System.out.println(estudiantadoJson);
        } catch (JAXBException ex) {
            Logger.getLogger(Actividad1_11.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Actividad1_11.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
