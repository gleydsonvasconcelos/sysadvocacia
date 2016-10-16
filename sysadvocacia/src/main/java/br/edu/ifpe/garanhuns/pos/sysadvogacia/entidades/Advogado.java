/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gleydson
 */
@Entity
@Table(name = "advogado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advogado.findAll", query = "SELECT a FROM Advogado a")})
public class Advogado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;
    @Size(max = 12)
    @Column(name = "cpf", length = 12)
    private String cpf;
    @Size(max = 15)
    @Column(name = "oab", length = 15)
    private String oab;
    @Size(max = 100)
    @Column(name = "endereco", length = 100)
    private String endereco;
    @Size(max = 20)
    @Column(name = "telefone", length = 20)
    private String telefone;
    @JoinTable(name = "processo_has_advogado", joinColumns = {
        @JoinColumn(name = "advogado_codigo", referencedColumnName = "codigo", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "processo_codigo", referencedColumnName = "codigo", nullable = false)})
    @ManyToMany
    private List<Processo> processoList;

    public Advogado() {
    }

    public Advogado(Integer codigo) {
        this.codigo = codigo;
    }

    public Advogado(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getOab() {
        return oab;
    }

    public void setOab(String oab) {
        this.oab = oab;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @XmlTransient
    public List<Processo> getProcessoList() {
        return processoList;
    }

    public void setProcessoList(List<Processo> processoList) {
        this.processoList = processoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advogado)) {
            return false;
        }
        Advogado other = (Advogado) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpe.pos.sysadvogacia.entidades.Advogado[ codigo=" + codigo + " ]";
    }
    
}
