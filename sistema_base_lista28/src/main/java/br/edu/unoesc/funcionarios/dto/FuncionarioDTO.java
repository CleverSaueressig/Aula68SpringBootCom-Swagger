package br.edu.unoesc.funcionarios.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.edu.unoesc.funcionarios.model.Funcionario;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {
	Long id;
	
	@NotBlank(message = "É obrigatório informar o nome")
	@Size(min = 3, max = 80, message = "O nome do funcionario deve ter entre{min} e {max} de caracteres")
	String nome;
	
	@NotBlank(message = "É obrigatorio informar o endereço!")
	@Size(min = 4, max = 200, message = "O endereço deve conter pelo menos {min} de caracteres e ter no maximo 200 caracteres")
	String endereco;
	
	@NotNull(message = "É obrigatório informar o numero de dependentes!")
	@Size(min = 0, max = 100, message = "O numero de dependentes deve ter entre{min} e {max} de pessoas")
	Integer numDep;
	
	@NotNull(message = "É obrigatorio informar um valor!")
	@Min(value = 1, message = "O salario deve conter pelo menos 1 digito")
	@Max(value = 99999, message ="O salario pode ter no maximo 99999 digitos")
	BigDecimal salario;
	
	LocalDate nascimento;
	
	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.endereco = funcionario.getEndereco();
		this.numDep = funcionario.getNumDep();
		this.salario = funcionario.getSalario();
		this.nascimento = funcionario.getNascimento();
	}
}