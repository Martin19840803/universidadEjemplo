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
    private AlumnoData alumno = new AlumnoData();
    private MateriaData materia = new MateriaData();
    public InscripcionData() {

        con = Conexion.conexionDB();
    }
    
                    //GUARDAR INSCRIPCION    
public void guardarInscripcion(Inscripcion insc) {
    
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getAlumno().getIdAlumno());
            ps.setInt(2, insc.getMateria().getIdMateria());
            ps.setDouble(3, insc.getNota());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción Registrada");
            }   
    ps.close();
               
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al guardar la inscripción: " + ex.getMessage());
    }
}
  

                    //OBTENER INSCRIPCIONES
public List<Inscripcion> obtenerInscripciones() {
    List<Inscripcion> inscripciones = new ArrayList<>();
    String sql = "SELECT idInscripcion, idAlumno, idMateria, nota FROM inscripcion";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Inscripcion insc = new Inscripcion();
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
          
            
          Alumno alu = alumno.buscarAlumno(rs.getInt("idAlumno"));
          Materia mat = materia.buscarMateria(rs.getInt("idMateria"));
          insc.setAlumno(alu);
          insc.setMateria(mat);
          insc.setNota(rs.getDouble("nota"));
          inscripciones.add(insc);
        }

        ps.close();
       
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener las inscripciones: " + ex.getMessage());
    }

    return inscripciones;
}

 
    
                    //OBTENER INCRIPCIONES POR ALUMNO    
public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlum) {
    List<Inscripcion> inscripciones = new ArrayList<>();
    String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlum);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Inscripcion insc = new Inscripcion();
            insc.setIdInscripcion(rs.getInt("idInscripcion"));
          
            
          Alumno alu = alumno.buscarAlumno(rs.getInt("idAlumno"));
          Materia mat = materia.buscarMateria(rs.getInt("idMateria"));
          insc.setAlumno(alu);
          insc.setMateria(mat);
          insc.setNota(rs.getDouble("nota"));
          inscripciones.add(insc);
        }

        ps.close();
       
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener las inscripciones: " + ex.getMessage());
    }

    return inscripciones;
}
    

                        //OBTENER MATERIA CURSADAS
    
 public List<Materia> obtenerMateriasCursadas(int id) {
    ArrayList<Materia> materias = new ArrayList<Materia>();

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
public void borrarInscripcionMateriaPorAlumno(int idAlumno, int idMateria) {
    String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAlumno);
        ps.setInt(2, idMateria);
        int fila = ps.executeUpdate();
        
        if (fila > 0) {
            JOptionPane.showMessageDialog(null, "Inscripciones borradas con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron inscripciones para borrar");
        }
        
        ps.close();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al borrar las inscripciones: " + ex.getMessage());
    }
}



                        //ACTUALIZAR NOTA
public void actualizarNota(Inscripcion insc) {
    String sql = "UPDATE inscripcion SET nota = ? WHERE idInscripcion = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, insc.getNota());
        ps.setInt(2, insc.getIdInscripcion());
        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Nota actualizada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la inscripción para actualizar");
        }
        
        ps.close();
        
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la nota: " + ex.getMessage());
    }
}


                        //OBTENER ALUMNOS POR MATERIA        


                



