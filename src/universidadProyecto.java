
import java.sql.Connection;
import java.time.LocalDate;
import universidad.AccesoADatos.AlumnoData;
import universidad.AccesoADatos.Conexion;
import universidad.Entidades.Alumno;

public class universidadProyecto {

    public static void main(String[] args) {

        Alumno alu = new Alumno(30711879, "Gomez", "Gaston ", LocalDate.of(2000, 1, 25), true);
        AlumnoData alum1 = new AlumnoData();
        alum1.guardarAlumno(alu);

    }

}
