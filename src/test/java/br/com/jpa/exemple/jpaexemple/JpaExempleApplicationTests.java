package br.com.jpa.exemple.jpaexemple;

import br.com.jpa.exemple.jpaexemple.model.*;
import br.com.jpa.exemple.jpaexemple.repository.PessoaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaExempleApplicationTests {

	@Autowired
	private PessoaRepository pessoaRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testSavePessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("TESTE CADASTRO");

		Endereco endereco = new Endereco();
		endereco.setBairro("CENTRO");
		endereco.setCidade("SÃO PAULO");
		endereco.setLogradouro("AV. PAULISTA");
		endereco.setNumero("1002");
		endereco.setUf("SP");
		endereco.setPessoa(pessoa);
		pessoa.setEndereco(endereco);

		Telefone telefone = new Telefone();
		telefone.setDdd("21");
		telefone.setNumero("36655555");
		telefone.setTipo(EnumTipo.CELULAR);
		telefone.setPessoa(pessoa);
		pessoa.addTelefone(telefone);

		Trabalhos emprego1 = new Trabalhos();
		emprego1.setNome("CASAS BAHIA");
		pessoa.addTrabalho(emprego1);

		Trabalhos emprego2 = new Trabalhos();
		emprego2.setNome("RICARDO ELETRO");
		pessoa.addTrabalho(emprego2);

		Trabalhos emprego3 = new Trabalhos();
		emprego3.setNome("MAGAZINE LUIZA");
		pessoa.addTrabalho(emprego3);

        this.pessoaRepository.save(pessoa);
	}

}
