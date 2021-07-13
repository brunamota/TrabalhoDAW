package net.ufjnet.joppool;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import net.ufjnet.joppool.models.Aluno;
import net.ufjnet.joppool.models.Coordenador;
import net.ufjnet.joppool.models.Empresa;
import net.ufjnet.joppool.models.Habilidade;
import net.ufjnet.joppool.models.Vaga;
import net.ufjnet.joppool.repositories.AlunoDAO;
import net.ufjnet.joppool.repositories.CoordenadorDAO;
import net.ufjnet.joppool.repositories.EmpresaDAO;
import net.ufjnet.joppool.repositories.HabilidadeDAO;
import net.ufjnet.joppool.repositories.VagaDAO;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class BckendJpApplication implements CommandLineRunner{
	
	@Autowired
	private AlunoDAO alunoDAO;
	@Autowired
	private CoordenadorDAO coordenadorDAO;
	
	@Autowired
	private EmpresaDAO empresaDAO;
	
	@Autowired
	private VagaDAO vagaDAO;
	
	@Autowired
	private HabilidadeDAO habilidadeDAO;

	public static void main(String[] args) {
		SpringApplication.run(BckendJpApplication.class, args);		
		}
	
	@Override
	public void run(String... args) throws Exception {	
		Aluno aluno01 = new Aluno(1,"Bruna", "1234560", "bruna@jp", "13/08/1999", "(64)99126-7848","Rua osorio de Assis,178", "Jatai","GO","UFJ","Ciencia da Computacao", "201901985","4");
		Aluno aluno02 = new Aluno(2,"Lígia", "12345", "ligia@jp", "03/02/2000", "(64)99126-0000","Rua osorio de Assis,166", "Jatai","GO","UFJ","Ciencia da Computacao", "201901980", "4");
		
		alunoDAO.saveAll(Arrays.asList(aluno01, aluno02));
		
		Coordenador coordendor01 = new Coordenador(1, "Franciny", "012345", "franciny@cjp","(64)22222-5555", "Av. Rio Claro, 456", "Jataí", "GO", "UFJ", "Ciência da Computação", "000001");
		Coordenador coordendor02 = new Coordenador(2, "Ludmila", "045678", "ludmila@cjp","(64)55555-5555", "Av. Rio Verde, 789", "Jataí", "GO", "UFJ", "Enfermagem", "000002");
	
		coordenadorDAO.saveAll(Arrays.asList(coordendor01, coordendor02));
		
		Empresa empresa01 = new Empresa(1, "Coca-Cola", "123456789", "cocacola@company", "(64)99999-7070","Rua Oscar Freire,123","São Paulo", "SP", "Vendas");
		Empresa empresa02 = new Empresa(2, "Hospital Padre Tiago", "987654321", "hospitalPadreThiago@company", "(64)88888-7444","R. Castro Alves, 686","Jataí", "GO", "Saúde");
		
		empresaDAO.saveAll(Arrays.asList(empresa01, empresa02));
		
		Vaga vaga01 = new Vaga(1,"Analista de Sistema", "2","60%", "R$800,00","habilidade no pacote office", "Analisa, documenta, projeta, implementa, testa e gerencia os sistemas","30","Matutino", empresa01);
		Vaga vaga02 = new Vaga(2, "Enfermagem obstétrica", "3", "75%", "R$1000,00","Estar no 4º semestre ou mais do curso de enfermagem", "Atende a pacientes lactantes ou gestantes","30","Vespertino", empresa02);
	
		vagaDAO.saveAll(Arrays.asList(vaga01, vaga02));
		
		Habilidade habilidade01 = new Habilidade(1,"Curso de javascript","Conhecimento em pacote office","não possui", aluno01);
		Habilidade habilidade02 = new Habilidade(2,"cursos","conhecimentos","experiencias" , aluno02);
	
		habilidadeDAO.saveAll(Arrays.asList(habilidade01, habilidade02));
	}	

}
