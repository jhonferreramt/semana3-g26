package co.edu.usa.semana3g26;

import co.edu.usa.semana3g26.modelo.Categoria;
import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.modelo.Mensajes;
import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.modelo.Reservaciones;
import co.edu.usa.semana3g26.repositorios.RepositorioCategoria;
import co.edu.usa.semana3g26.repositorios.RepositorioCliente;
import co.edu.usa.semana3g26.repositorios.RepositorioMensajes;
import co.edu.usa.semana3g26.repositorios.RepositorioOrtesis;
import co.edu.usa.semana3g26.repositorios.RepositorioReservaciones;
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
    private RepositorioCliente repoCliente;
    @Autowired
    private RepositorioCategoria repoCategoria;

    @Autowired
    private RepositorioOrtesis repoOrtesis;
     @Autowired
    private RepositorioMensajes repoMensajes;
    @Autowired
    private RepositorioReservaciones repoReservaciones;
   

    
    
    public static void main(String[] args) {
        SpringApplication.run(Semana3G26Application.class, args);
    }
    
    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            List<Cliente> ps = repoCliente.getAll();
            System.out.println("Cliente: "+ps.size());
            
            List<Categoria> cs = repoCategoria.getAll();
            System.out.println("Categorias: "+cs.size());
            
           // List<Administrativos> as = repoAdministrativos.getAll();
            //System.out.println("Administrativos: "+cs.size());
            
            List<Mensajes> ms = repoMensajes.getAll();
            System.out.println("Mensajes: "+cs.size());
            
            List<Ortesis> os = repoOrtesis.getAll();
            System.out.println("Ortesis: "+cs.size());
            
            List<Reservaciones> rs = repoReservaciones.getAll();
            System.out.println("Reservaciones: "+cs.size());
            
           // List<Score> ss = repoScore.getAll();
           // System.out.println("Score: "+cs.size());
        };
    }

}



// 1.Modelo o Entidad
// 2.Interface
// 3.Repositorio
// 4.Servicios
// 5.Controlador o Web





/*
package co.edu.usa.semana3g26;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Semana3G26Application {

	public static void main(String[] args) {
		SpringApplication.run(Semana3G26Application.class, args);
	}

}
*/