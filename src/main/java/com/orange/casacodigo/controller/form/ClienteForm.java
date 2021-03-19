package com.orange.casacodigo.controller.form;

import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.config.ExistsById;
import com.orange.casacodigo.config.ValidaEstadoPais;
import com.orange.casacodigo.model.Cliente;
import com.orange.casacodigo.model.Estado;
import com.orange.casacodigo.model.Pais;
import com.orange.casacodigo.repository.EstadoRepository;
import com.orange.casacodigo.repository.PaisRepository;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@ValidaEstadoPais
public class ClienteForm {

    @Email
    @CampoUnico(domainClass = Cliente.class, fieldName = "email")
    @NotBlank
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CampoUnico(domainClass = Cliente.class, fieldName = "documento")
    @Pattern(regexp =("(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})"),
            message = "Campo inválido. Utilizar o padrão {000.000.000-00} para cpf e o padrão {00.000.000/0000-00} para cnpj")

    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsById(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @CNPJ @CPF String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long paisId, @NotNull Long estadoId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.estadoId = estadoId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Pais pais = paisRepository.getOne(paisId);
        List<Estado> estados = estadoRepository.findByPais(pais);
        if (estados.isEmpty()) {
            return new Cliente(email,nome,sobrenome,documento,endereco,complemento,cidade,pais,telefone,cep);
        }
        Estado estado = estadoRepository.getOne(estadoId);
        return new Cliente(email,nome,sobrenome,documento,endereco,complemento,cidade,pais,estado,telefone,cep);
    }
}
