package br.com.fiap.curso.teste;

import br.com.fiap.curso.entities.*;
import br.com.fiap.curso.enums.CursoNivel;
import br.com.fiap.curso.repositories.ConteudoRepository;
import br.com.fiap.curso.repositories.CursoRepository;
import br.com.fiap.curso.repositories.ModuloRepository;
import br.com.fiap.curso.repositories.UsuarioRepository;
import br.com.fiap.curso.services.CarrinhoService;
import br.com.fiap.curso.services.CursoService;
import br.com.fiap.curso.services.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CRUDTeste {

    Logger log = LoggerFactory.getLogger(CRUDTeste.class);

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CarrinhoService carrinhoService;

    @PostConstruct
    public void RealizaCRUD() {

      // CREATE
        // dispara  o método para criar os cursos Java Poo e Banco de Dados.
        criaCursos();
        // dispara  o método para persistir os usuarios na base de Dados.
        criaUsuarios();
        // dispara o método para persistir um carrinho de compra e seus respectivos dados na base de Dados.
        criaCarrinho();

      // READ
        // Procurar um usuario pelo email
        Usuario findUsuario = usuarioService.findByEmail("henrique@fiap.com");
        log.info("Usuario lido da base: " + findUsuario.toString());

        // Procura os carrinhos do usuario Anderson
        Usuario findUsuarioAnderson = usuarioService.findByEmail("anderson@fiap.com");
        List<Carrinho> carrinhos = carrinhoService.findByUsuario(findUsuarioAnderson);
        log.info("Preço total carrinho de Anderson R$" + carrinhos.get(0).getPrecoTotal());

      // UPDATE
         // Atualizando email do usuário
         Usuario findHenrique = usuarioService.findByNome("Henrique Vergara");
         log.info("Email antes do update:"+ findHenrique.getEmail());
         findHenrique.setEmail("henriquevergara@fiap.com");
         usuarioService.update(findHenrique);
         Usuario findHenriqueUpdate = usuarioService.findByNome("Henrique Vergara");
         log.info("Email após update:" + findHenriqueUpdate.getEmail());

      // DELETE
        // Deletando o usuario Thalles
        Usuario findThalles = usuarioService.findByNome("Thalles Antonioli");
        usuarioService.delete(findThalles.getId());
        
    }

    private void criaCursos(){

        // Instanciando os cursos que desejamos criar
        Curso javaPoo = new Curso();
        javaPoo.setDescricao("Curso de Orientação a Objetos com Java.");
        javaPoo.setNivel(CursoNivel.INICIANTE);
        javaPoo.setNome("Java POO");
        javaPoo.setPrecoOriginal(30.0);
        javaPoo.setPrecoPromocional(20.0);
        javaPoo.setUlrImagem("shorturl.at/cvIU1");

        Curso bancoDados = new Curso();
        bancoDados.setDescricao("Curso de Banco de Dados Relacional");
        bancoDados.setNivel(CursoNivel.INTERMEDIARIO);
        bancoDados.setNome("Banco de Dados Relacional");
        bancoDados.setPrecoOriginal(40.0);
        bancoDados.setPrecoPromocional(25.0);
        bancoDados.setUlrImagem("www.oracle.com.br");

        // Instanciamos os módulos que serão inseridos nos cursos
        Modulo moduloPrimeiroJavaPoo = new Modulo();
        moduloPrimeiroJavaPoo.setNome("Classes, Objetos e Abstração.");
        moduloPrimeiroJavaPoo.setCargaHoraria(2.0);
        Modulo moduloSegundoJavaPoo = new Modulo();
        moduloSegundoJavaPoo.setNome("Polimorfismo");
        moduloSegundoJavaPoo.setCargaHoraria(4.0);

        Modulo moduloPrimeiroBd = new Modulo();
        moduloPrimeiroBd.setNome("Aprendendo as regras de normalização.");
        moduloPrimeiroBd.setCargaHoraria(5.0);
        Modulo moduloSegundoBd= new Modulo();
        moduloSegundoBd.setNome("Aprendendo modelagem.");
        moduloSegundoBd.setCargaHoraria(6.0);

        // Instanciamos os conteudos que serão inseridos nos modulos
        Conteudo conteudoModuloPrimeiroClasses = new Conteudo();
        conteudoModuloPrimeiroClasses.setDescricao("Aprendendo o que é uma classe, objeto e o pilar de abstração de POO.");
        Conteudo conteudoModuloPrimeiroHeranca = new Conteudo();
        conteudoModuloPrimeiroHeranca.setDescricao("Usando Getter e Setter para encapsular e usando extends para herança.");
        Conteudo conteudoModuloSegundoPolimorfismo = new Conteudo();
        conteudoModuloSegundoPolimorfismo.setDescricao("Utilização do Polimorfismo.");

        Conteudo conteudoModuloPrimeiroBd = new Conteudo();
        conteudoModuloPrimeiroBd.setDescricao("Normalização é o processo de modelar o banco de dados projetando a forma como as informações serão armazenadas.");
        Conteudo conteudoModuloSegundoBd = new Conteudo();
        conteudoModuloSegundoBd.setDescricao("Primeira, segunda, terceira forma normal.");
        Conteudo conteudoModuloPrimeiroModelagem = new Conteudo();
        conteudoModuloPrimeiroModelagem.setDescricao("Utilização da modelagem.");

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

        // Persistindo o Curso Java Poo na base, junto com os seus respectivos modulos e conteudos.
        cursoService.create(javaPoo);

        List<Conteudo> conteudosModuloPrimeiroBd = new ArrayList<>();
        List<Conteudo> conteudosModuloSegundoBd = new ArrayList<>();
        List<Modulo> modulosBd = new ArrayList<>();
        conteudosModuloPrimeiroBd.add(conteudoModuloPrimeiroBd);
        conteudosModuloPrimeiro.add(conteudoModuloSegundoBd);
        conteudosModuloSegundoBd.add(conteudoModuloPrimeiroModelagem);
        moduloPrimeiroBd.setConteudos(conteudosModuloPrimeiroBd);
        moduloSegundoBd.setConteudos(conteudosModuloSegundoBd);
        modulosBd.add(moduloPrimeiroBd);
        modulosBd.add(moduloSegundoBd);
        bancoDados.setModulos(modulosBd);

        // Persistindo o Curso Banco de Dados Relacional na base, junto com os seus respectivos modulos e conteudos.
        cursoService.create(bancoDados);


    }

    private void criaUsuarios(){

        // Criação do usuário Henrique e preenchimento das suas respectivas informações
        Usuario usuarioHenrique = new Usuario();
        List<Curso> cursos = new ArrayList<>();
        usuarioHenrique.setEmail("henrique@fiap.com");
        usuarioHenrique.setPassword("fiap123");
        usuarioHenrique.setNome("Henrique Vergara");

        // Utilizar o método findByNome para buscar o curso de Java para vincular ao usuario Henrique.
        Curso javaPoo = cursoService.findByNome("Java POO");
        cursos.add(javaPoo);
        usuarioHenrique.setCursos(cursos);

        // Persistindo o usuário Henrique na Base.
        usuarioService.create(usuarioHenrique);

        // Criação do usuário Henrique e preenchimento das suas respectivas informações
        Usuario usuarioAnderson = new Usuario();
        usuarioAnderson.setEmail("anderson@fiap.com");
        usuarioAnderson.setPassword("java123");
        usuarioAnderson.setNome("Anderson Yonei");

        // Persistindo o usuário Anderson na Base.
        usuarioService.create(usuarioAnderson);

        // Criação do usuário Thalles e preenchimento das suas respectivas informações
        Usuario usuarioThalles = new Usuario();
        usuarioThalles.setEmail("thalles@fiap.com");
        usuarioThalles.setPassword("ux123");
        usuarioThalles.setNome("Thalles Antonioli");
        List<Curso> cursosThalles = new ArrayList<>();
        Curso bd = cursoService.findByNome("Banco de Dados Relacional");
        cursosThalles.add(bd);
        usuarioThalles.setCursos(cursosThalles);

        // Persistindo o usuário Thalles na Base.
        usuarioService.create(usuarioThalles);
    }

    private void criaCarrinho(){

        Carrinho carrinhoDeAnderson = new Carrinho();

        // Buscando usuario Anderson no BD
        Usuario anderson = usuarioService.findByNome("Anderson Yonei");

        // Buscando os cursos que Anderson deseja comprar
        List<Curso> cursosComprados = new ArrayList<>();

        Curso cursoJava = cursoService.findByNome("Java POO");
        Curso cursoBd = cursoService.findByNome("Banco de Dados Relacional");

        cursosComprados.add(cursoJava);
        cursosComprados.add(cursoBd);

        carrinhoDeAnderson.setUsuario(anderson);
        carrinhoDeAnderson.setCursos(cursosComprados);
        carrinhoDeAnderson.setPrecoTotal(100);

        // Salvando carrinho na base de dados
        carrinhoService.create(carrinhoDeAnderson);

    }

}
