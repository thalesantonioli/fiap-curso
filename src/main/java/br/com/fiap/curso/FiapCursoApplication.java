package br.com.fiap.curso;

import br.com.fiap.curso.teste.CRUDTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FiapCursoApplication {



    public static void main(String[] args) {
        SpringApplication.run(FiapCursoApplication.class, args);
    }

}

