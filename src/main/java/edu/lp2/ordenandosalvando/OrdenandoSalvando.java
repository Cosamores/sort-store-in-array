package edu.lp2.ordenandosalvando;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cg3017311
 */
public class OrdenandoSalvando {

    public static void main(String[] args) throws IOException {
        int N[] = new int[]{100};
        String array[];

        for (int i = 0; i < 1; i++) {
            dirPasta(N[i]);
        }
    }

    private static void dirPasta(int x) throws IOException {
        String dirName = String.valueOf(x);
        
        Files.list(new File(dirName).toPath())
                .limit(10)
                .forEach(path -> {
            try {
                String pathString = String.valueOf(path);
                
                String pasta = String.valueOf(pathString.split("\\\\")[0]);
                String arquivo = String.valueOf(pathString.split("\\\\")[1]);
                System.out.println("Pasta: " + pasta);
                
                System.out.println("Lendo o arquivo: " + arquivo);
                
                BufferedReader buffRead = null ;
                
                try {
                    
                    buffRead = new BufferedReader(new FileReader(pasta + "\\" + arquivo));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(OrdenandoSalvando.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String linha = buffRead.readLine();
                List<String> numeros = new ArrayList<String>();
                int cont = 0; 
                while(linha != null){
                    numeros.add(linha);
                    linha = buffRead.readLine();
                    cont++;       
                }
                buffRead.close();
                System.out.println(numeros);
            } catch (IOException ex) {
                Logger.getLogger(OrdenandoSalvando.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                });
        }
    
    
    
    
    public static void writeFiles() {
    
    }
}




                    