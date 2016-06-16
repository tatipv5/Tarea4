/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisza
 */
public class Escritor {

    FileWriter writer;

    private void write_with_throws(String filepath, String text) throws IOException {
        File file = new File(filepath);
        if (!file.exists()) {
            file.createNewFile();
        }
        writer = new FileWriter(file);
        // Writes the content to the file
        writer.write(text);
        writer.flush();

    }

    public void write_file(String filepath, String text) {
        try {
            write_with_throws(filepath, text);
        } catch (IOException ex) {
            Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//    public void with_obj_in_file_json(String filepath, Object obj) {
//        //http://flexjson.sourceforge.net/#Serialization
//        JSONSerializer serializer = new JSONSerializer();
//        write_file(filepath, serializer.serialize(obj));
//    }

    public void with_obj_in_file_xml(String filepath, Object obj) throws FileNotFoundException {
        // https://docs.oracle.com/javase/7/docs/api/java/beans/XMLEncoder.html
        XMLEncoder e;
            e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            e.writeObject(obj);
            e.close();
    }

}
