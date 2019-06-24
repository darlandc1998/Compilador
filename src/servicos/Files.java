package servicos;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public final class Files {

    public static void gravarArquivo(String nomeArquivo, String textoArquivo) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(textoArquivo);
            bufferedWriter.flush();

            //Se chegou ate essa linha, conseguiu salvar o arquivo com sucesso.
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: " + ex.getMessage());
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: "
                            + ex.getMessage());
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo: "
                            + ex.getMessage());
                }
            }
        }
    }

    public static String lerArquivo(String nomeArquivo) {

        if (nomeArquivo.isEmpty()) {
            return "";
        }

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(nomeArquivo);
            bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb = new StringBuilder();

            while (bufferedReader.ready()) {
                sb.append(bufferedReader.readLine());
                sb.append("\n");
            }
            return sb.toString();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: "
                    + ex.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: "
                            + ex.getMessage());
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o arquivo: "
                            + ex.getMessage());
                }
            }
        }
        return null;
    }

    public static String abrirArquivoDialog(Component comp) {
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(comp);
        File selFile = fc.getSelectedFile();
        if (selFile == null) {
            return "";
        }
        return selFile.getAbsolutePath();
    }

    public static String salvarArquivoDialog(Component comp) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(comp) == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath() + ".txt";
        }
        return null;
    }

}
