package br.com.jpa.exemple.jpaexemple;

import br.com.jpa.exemple.jpaexemple.model.*;
import br.com.jpa.exemple.jpaexemple.repository.EnderecoRepository;
import br.com.jpa.exemple.jpaexemple.repository.PessoaRepository;
import br.com.jpa.exemple.jpaexemple.repository.TelefoneRepository;
import br.com.jpa.exemple.jpaexemple.repository.TrabalhoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaExempleApplicationTests {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@Autowired
	private TrabalhoRepository trabalhoRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSavePessoa() {
		// adiciona pessoa
		Pessoa pessoa = this.adicionarPessoa();
		Endereco endereco = this.adicionarEndereco();

		// adiciona endereco
		endereco = this.enderecoRepository.save(endereco);
		pessoa.setEndereco(endereco);
		pessoa = this.pessoaRepository.save(pessoa);

		// adiciona telefone
		Telefone telefone = this.adicionarTelefone();
		telefone.setPessoa(pessoa);
		pessoa.addTelefone(telefone);

		this.telefoneRepository.save(telefone);

		List<Trabalhos> trabalhos = this.adicionarTrabalhos();
		trabalhos.forEach(pessoa::addTrabalho);
		pessoa.getTrabalhos().forEach(t -> this.trabalhoRepository.save(t));

		this.pessoaRepository.save(pessoa);
	}

	private List<Trabalhos> adicionarTrabalhos(){
		List<Trabalhos> trabalhos = new ArrayList<>();
		Trabalhos emprego1 = new Trabalhos();
		emprego1.setNome("CASAS BAHIA");
		trabalhos.add(emprego1);

		Trabalhos emprego2 = new Trabalhos();
		emprego2.setNome("RICARDO ELETRO");
		trabalhos.add(emprego2);

		Trabalhos emprego3 = new Trabalhos();
		emprego3.setNome("MAGAZINE LUIZA");
		trabalhos.add(emprego3);

		return trabalhos;
	}

	private Pessoa adicionarPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("TESTE CADASTRO");
		return pessoa;
	}

	private Endereco adicionarEndereco() {
		Endereco endereco = new Endereco();
		endereco.setBairro("CENTRO");
		endereco.setCidade("SÃO PAULO");
		endereco.setLogradouro("AV. PAULISTA");
		endereco.setNumero("1002");
		endereco.setUf("SP");
		return endereco;
	}

	private Telefone adicionarTelefone() {
		Telefone telefone = new Telefone();
		telefone.setDdd("21");
		telefone.setNumero("36655555");
		telefone.setTipo(EnumTipo.CELULAR);
		return telefone;
	}

}
