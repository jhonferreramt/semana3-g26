package co.edu.usa.semana3g26;

import co.edu.usa.semana3g26.modelo.Categoria;
import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.modelo.Mensajes;
import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.modelo.Administrativo;
import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.repositorios.RepositorioCategoria;
import co.edu.usa.semana3g26.repositorios.RepositorioCliente;
import co.edu.usa.semana3g26.repositorios.RepositorioMensajes;
import co.edu.usa.semana3g26.repositorios.RepositorioOrtesis;
import co.edu.usa.semana3g26.repositorios.RepositorioReservaciones;
import co.edu.usa.semana3g26.repositorios.RepositorioAdministrativo;
import co.edu.usa.semana3g26.repositorios.RepositorioCalificacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.usa.semana3g26"})
public class Semana3G26Application {

    @Autowired
    private RepositorioCategoria repoCategoria;
    @Autowired
    private RepositorioOrtesis repoOrtesis;
    @Autowired
    private RepositorioCliente repoCliente;
    @Autowired
    private RepositorioMensajes repoMensajes;
    @Autowired
    private RepositorioReservaciones repoReservaciones;
    @Autowired
    private RepositorioAdministrativo repoAdministrativo;
    @Autowired
    private RepositorioCalificacion repoCalificacion;

    public static void main(String[] args) {
        SpringApplication.run(Semana3G26Application.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Categoria> cs = repoCategoria.getAll();
            System.out.println("Categorias: " + cs.size());

            List<Ortesis> os = repoOrtesis.getAll();
            System.out.println("Ortesis: " + os.size());

            List<Cliente> ps = repoCliente.getAll();
            System.out.println("Cliente: " + ps.size());

            List<Mensajes> ms = repoMensajes.getAll();
            System.out.println("Mensajes: " + ms.size());

            List<Reservaciones> rs = repoReservaciones.getAll();
            System.out.println("Reservaciones: " + rs.size());

            List<Administrativo> as = repoAdministrativo.getAll();
            System.out.println("Administrativos: " + as.size());

            List<Calificacion> crs = repoCalificacion.getAll();
            System.out.println("Calificaciones: " + crs.size());
        };
    }

}

// 1.Modelo o Entidad
// 2.Interface
// 3.Repositorio
// 4.Servicios
// 5.Controlador o Web
