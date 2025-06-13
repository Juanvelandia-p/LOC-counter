package edu.escuelaing.arsw.ASE.app;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * LineCounter es una herramienta de línea de comandos que cuenta las líneas de código en archivos Java.
 * Puede contar líneas físicas o lógicas según el modo especificado.
 * 
 * Uso:
 * java countlines [phy|loc] [archivo/directorio]
 * 
 * - phy: cuenta líneas físicas (todas las líneas, incluyendo comentarios y vacías).
 * - loc: cuenta líneas lógicas (excluye comentarios y líneas vacías).
 */

public class LineCounter {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Uso: java countlines [phy|loc] [archivo/directorio]");
            return;
        }

        String mode = args[0];
        Path path = Paths.get(args[1]);

        List<Path> files = new ArrayList<>();

        if (Files.isRegularFile(path) && path.toString().endsWith(".java")) {
            files.add(path);
        } else if (Files.isDirectory(path)) {
            files = Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .collect(Collectors.toList());
        } else {
            System.out.println("Ruta inválida o archivo no .java");
            return;
        }

        int totalLines = 0;
        for (Path file : files) {
            if (mode.equals("phy")) {
                totalLines += countPhysicalLines(file);
            } else if (mode.equals("loc")) {
                totalLines += countLogicalLines(file);
            } else {
                System.out.println("Parámetro inválido: " + mode);
                return;
            }
        }

        System.out.println("Total líneas (" + mode + "): " + totalLines);
    }

    public static int countPhysicalLines(Path file) throws IOException {
        return (int) Files.lines(file).count();
    }

    public static int countLogicalLines(Path file) throws IOException {
        boolean[] inBlockComment = {false};

        return (int) Files.lines(file)
                .map(String::trim)
                .filter(line -> {
                    if (line.isEmpty()) return false;
                    if (inBlockComment[0]) {
                        if (line.contains("*/")) {
                            inBlockComment[0] = false;
                        }
                        return false;
                    }
                    if (line.startsWith("//")) return false;
                    if (line.startsWith("/*")) {
                        if (!line.contains("*/")) {
                            inBlockComment[0] = true;
                        }
                        return false;
                    }
                    if (line.equals("}")) return false;
                    return true;
                })
                .count();
    }
}