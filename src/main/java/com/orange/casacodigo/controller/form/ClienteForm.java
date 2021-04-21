package com.orange.casacodigo.controller.form;

import com.orange.casacodigo.config.CampoUnico;
import com.orange.casacodigo.config.CpfCnpj;
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
import java.util.List;
import java.util.Optional;

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
    @CpfCnpj
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
    @ExistsById(domainClass = Estado.class, fieldName = "id")
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteForm(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome, @NotBlank @CNPJ @CPF String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade, @NotNull Long paisId, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public boolean temEstado(){
       return Optional.ofNullable(estadoId).isPresent();
    }



    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository){
        Pais pais = paisRepository.getOne(paisId);
        Cliente cliente = new Cliente(email,nome,sobrenome,documento,endereco,complemento,cidade,pais,telefone,cep);
        if(estadoId !=null){
            Estado estado = estadoRepository.getOne(estadoId);
            cliente.setEstado(estado);
        }

        return cliente;
    }
}
