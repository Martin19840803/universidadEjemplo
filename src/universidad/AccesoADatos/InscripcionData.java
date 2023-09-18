package universidad.AccesoADatos;

import universidad.Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import universidad.Entidades.Alumno;
import universidad.Entidades.Materia;

public class InscripcionData {

    private Connection con = null;

    public InscripcionData() {

        con = Conexion.conexionDB();
    }
    
                    //GUARDAR INSCRIPCION    
public void guardarInscripcion(Inscripcion inscripcion) {
    try {
        String sql = "INSERT INTO inscripcion (nota, alumno, materia) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            
            ps.setDouble(1, inscripcion.getNota());
            ps.setString(2, inscripcion.getAlumno().getNombre());
            ps.setString(3, inscripcion.getMateria().getNombre());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción guardada con éxito");
                
                
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idInscripcionGenerado = generatedKeys.getInt(1);
                        inscripcion.setIdInscripcion(idInscripcionGenerado);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la inscripción");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar la inscripción: " + ex.getMessage());
    }
}
    

                    //OBTENER INSCRIPCIONES
public List<Inscripcion> obtenerInscripciones(int id) {
    List<Inscripcion> inscripciones = new ArrayList<>();

    try {
        String sql = "SELECT idInscripcion, nota, alumno, materia FROM inscripcion WHERE idAlumno = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Inscripcion inscripcion = new Inscripcion();
                    inscripcion.setIdInscripcion(rs.getInt("idInscripcion"));
                    inscripcion.setNota(rs.getDouble("nota"));
                    
                    Alumno alumno = new Alumno();
                    alumno.setNombre(rs.getString("alumno"));
                    inscripcion.setAlumno(alumno);
                    
                    Materia materia = new Materia();
                    materia.setNombre(rs.getString("materia"));
                    inscripcion.setMateria(materia);

                    inscripciones.add(inscripcion);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener inscripciones: " + ex.getMessage());
    }
    return inscripciones;
}


 
    
                    //OBTENER INCRIPCIONES POR ALUMNO    
public List<Materia> obtenerMateriasPorAlumno(int idAlumno) {
    List<Materia> materiasPorAlumno = new ArrayList<>();
    
    // Obtener las inscripciones del alumno
    List<Inscripcion> inscripciones = obtenerInscripciones(idAlumno);
    
    // Crear un conjunto para almacenar materias únicas
    Set<Materia> materiasUnicas = new HashSet<>();
    
    // Iterar sobre las inscripciones y agregar las materias al conjunto
    for (Inscripcion inscripcion : inscripciones) {
        Materia materia = inscripcion.getMateria();
        materiasUnicas.add(materia);
    }
    
    // Convertir el conjunto de materias únicas nuevamente a una lista
    materiasPorAlumno.addAll(materiasUnicas);
    
    return materiasPorAlumno;
}    
    

                        //OBTENER MATERIA CURSADAS
    
 public List<Materia> obtenerMateriasCursadas(int id) {
    List<Materia> materias = new ArrayList<Materia>();

    try {
        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion, Materia WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Materia materia = new Materia();
            materia.setIdMateria(rs.getInt("idMateria"));
            materia.setNombre(rs.getString("nombre"));
            materia.setAnio(rs.getInt("anio"));
            materias.add(materia);
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener Inscripciones " + ex.getMessage());
    }
    
    return materias;
}
                        //OBTENER MATERIAS NO CURSADAS
 
public List<Materia> obtenerMateriasNoCursadas(int id) {
    List<Materia> materiasNoCursadas = new ArrayList<>();

    try {
        String sql = "SELECT Materia.idMateria, Materia.nombre, Materia.anio " +
                     "FROM Materia " +
                     "LEFT JOIN inscripcion ON Materia.idMateria = inscripcion.idMateria " +
                     "AND inscripcion.idAlumno = ? " +
                     "WHERE inscripcion.idMateria IS NULL";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Materia materia = new Materia();
                    materia.setIdMateria(rs.getInt("idMateria"));
                    materia.setNombre(rs.getString("nombre"));
                    materia.setAnio(rs.getInt("anio"));
                    materiasNoCursadas.add(materia);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener materias no cursadas: " + ex.getMessage());
    }
    return materiasNoCursadas;
} 
 
                        //BORRAR INSCRIPCION MATERIA POR ALUMNO
public void borrarInscripcionPorMateriaYAlumno(Inscripcion inscripcion) {
    try {
        String sql = "DELETE FROM inscripcion WHERE alumno = ? AND materia = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, inscripcion.getAlumno().getNombre());
            ps.setString(2, inscripcion.getMateria().getNombre());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción eliminada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la inscripción para eliminar");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar la inscripción: " + ex.getMessage());
    }
}


                        //ACTUALIZAR NOTA
public void actualizarNotaDeInscripcion(Inscripcion inscripcion) {
    try {
        String sql = "UPDATE inscripcion SET nota = ? WHERE idInscripcion = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getIdInscripcion());
            
            int filasAfectadas = ps.executeUpdate();
            
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la inscripción para actualizar la nota");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la nota de la inscripción: " + ex.getMessage());
    }
}


                        //OBTENER ALUMNOS POR MATERIA        
public List<Alumno> obtenerAlumnosPorMateria(String nombreMateria) {
    List<Alumno> alumnosPorMateria = new ArrayList<>();

    try {
        String sql = "SELECT DISTINCT inscripcion.alumno FROM inscripcion " +
                     "WHERE inscripcion.materia = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreMateria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String nombreAlumno = rs.getString("alumno");
                    Alumno alumno = new Alumno(nombreAlumno);
                    alumnosPorMateria.add(alumno);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia: " + ex.getMessage());
    }
    return alumnosPorMateria;
}


}

                



