package br.com.fiap.curso.teste;

import br.com.fiap.curso.entities.Conteudo;
import br.com.fiap.curso.entities.Curso;
import br.com.fiap.curso.entities.Modulo;
import br.com.fiap.curso.entities.Usuario;
import br.com.fiap.curso.enums.CursoNivel;
import br.com.fiap.curso.repositories.ConteudoRepository;
import br.com.fiap.curso.repositories.CursoRepository;
import br.com.fiap.curso.repositories.ModuloRepository;
import br.com.fiap.curso.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CRUDTeste {

    @Autowired
    private ConteudoRepository conteudoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ModuloRepository moduloRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void RealizaCRUD() {

        // Criaçao da entidade Curso
        Curso javaPoo = new Curso();
        javaPoo.setDescricao("Curso de Orientação a Objetos com Java.");
        javaPoo.setNivel(CursoNivel.INICIANTE);
        javaPoo.setNome("Java POO");
        javaPoo.setPrecoOriginal(30.0);
        javaPoo.setPrecoPromocional(20.0);
        javaPoo.setUlrImagem("shorturl.at/cvIU1");

        // Criando os modulos do Curso
        Modulo moduloPrimeiroJavaPoo = new Modulo();
        moduloPrimeiroJavaPoo.setNome("Classes, Objetos e Abstração.");
        moduloPrimeiroJavaPoo.setCargaHoraria(2.0);
        Modulo moduloSegundoJavaPoo = new Modulo();
        moduloSegundoJavaPoo.setNome("Polimorfismo");
        moduloSegundoJavaPoo.setCargaHoraria(4.0);

        // Criando os conteúdos do modulo
        Conteudo conteudoModuloPrimeiroClasses = new Conteudo();
        conteudoModuloPrimeiroClasses.setDescricao("Aprendendo o que é uma classe, objeto e o pilar de abstração de POO.");
        Conteudo conteudoModuloPrimeiroHeranca = new Conteudo();
        conteudoModuloPrimeiroHeranca.setDescricao("Usando Getter e Setter para encapsular e usando extends para herança.");
        Conteudo conteudoModuloSegundoPolimorfismo = new Conteudo();
        conteudoModuloSegundoPolimorfismo.setDescricao("Utilização do Polimorfismo.");

        // Inserindo os conteudos dentro do modulo e depois inserindo o modulo ao curso
        List<Conteudo> conteudosModuloPrimeiro = new ArrayList<>();
        List<Conteudo> conteudosModuloSegundo = new ArrayList<>();
        List<Modulo> modulosJavaPoo = new ArrayList<>();
        conteudosModuloPrimeiro.add(conteudoModuloPrimeiroClasses);
        conteudosModuloPrimeiro.add(conteudoModuloPrimeiroHeranca);
        conteudosModuloSegundo.add(conteudoModuloSegundoPolimorfismo);
        moduloPrimeiroJavaPoo.setConteudos(conteudosModuloPrimeiro);
        moduloSegundoJavaPoo.setConteudos(conteudosModuloSegundo);
        modulosJavaPoo.add(moduloPrimeiroJavaPoo);
        modulosJavaPoo.add(moduloSegundoJavaPoo);
        javaPoo.setModulos(modulosJavaPoo);

        // Criando Usuario
        Usuario usuarioHenrique = new Usuario();
        List<Curso> cursos = new ArrayList<>();
        usuarioHenrique.setEmail("henrique@fiap.com");
        usuarioHenrique.setPassword("fiap123");
        usuarioHenrique.setNome("Henrique Vergara");
        cursos.add(javaPoo);
        usuarioHenrique.setCursos(cursos);

        // Salvando Usuario no Banco
        usuarioRepository.save(usuarioHenrique);
    }

}
