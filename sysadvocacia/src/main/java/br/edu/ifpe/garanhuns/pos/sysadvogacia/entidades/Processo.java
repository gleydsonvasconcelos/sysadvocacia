/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.garanhuns.pos.sysadvogacia.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gleydson
 */
@Entity
@Table(name = "processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p")})
public class Processo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_abertura", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "instancia_atual", nullable = false, length = 50)
    private String instanciaAtual;
    @Column(name = "status")
    private Integer status;
    @Size(max = 100)
    @Column(name = "decisao_final", length = 100)
    private String decisaoFinal;
    @Size(max = 100)
    @Column(name = "descricao", length = 100)
    private String descricao;
    @ManyToMany(mappedBy = "processoList")
    private List<Advogado> advogadoList;
    @ManyToMany(mappedBy = "processoList")
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processoCodigo")
    private List<Lei> leiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processoCodigo")
    private List<Historico> historicoList;

    public Processo() {
    }

    public Processo(Integer codigo) {
        this.codigo = codigo;
    }

    public Processo(Integer codigo, Date dataAbertura, String instanciaAtual) {
        this.codigo = codigo;
        this.dataAbertura = dataAbertura;
        this.instanciaAtual = instanciaAtual;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getInstanciaAtual() {
        return instanciaAtual;
    }

    public void setInstanciaAtual(String instanciaAtual) {
        this.instanciaAtual = instanciaAtual;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDecisaoFinal() {
        return decisaoFinal;
    }

    public void setDecisaoFinal(String decisaoFinal) {
        this.decisaoFinal = decisaoFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Advogado> getAdvogadoList() {
        return advogadoList;
    }

    public void setAdvogadoList(List<Advogado> advogadoList) {
        this.advogadoList = advogadoList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Lei> getLeiList() {
        return leiList;
    }

    public void setLeiList(List<Lei> leiList) {
        this.leiList = leiList;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
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
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifpe.pos.sysadvogacia.entidades.Processo[ codigo=" + codigo + " ]";
    }
    
}
