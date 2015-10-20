/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author Diego Sabino
 */
@Entity
@Table(name = "ges_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GesFuncionario.findAll", query = "SELECT g FROM GesFuncionario g"),
    @NamedQuery(name = "GesFuncionario.findByFunCod", query = "SELECT g FROM GesFuncionario g WHERE g.funCod = :funCod"),
    @NamedQuery(name = "GesFuncionario.findByFunFuncao", query = "SELECT g FROM GesFuncionario g WHERE g.funFuncao = :funFuncao"),
    @NamedQuery(name = "GesFuncionario.findByFunDataContratacao", query = "SELECT g FROM GesFuncionario g WHERE g.funDataContratacao = :funDataContratacao"),
    @NamedQuery(name = "GesFuncionario.findByFunNumero", query = "SELECT g FROM GesFuncionario g WHERE g.funNumero = :funNumero")})
public class GesFuncionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FUN_COD")
    private Integer funCod;
    @Size(max = 45)
    @Column(name = "FUN_FUNCAO")
    private String funFuncao;
    @Column(name = "FUN_DATA_CONTRATACAO")
    @Temporal(TemporalType.DATE)
    private Date funDataContratacao;
    @Column(name = "FUN_NUMERO")
    private Integer funNumero;
    @JoinColumn(name = "FUN_PES_COD", referencedColumnName = "PES_COD")
    @ManyToOne
    private GesPessoa funPesCod;
    @OneToMany(mappedBy = "funCod")
    private List<GesUsuario> gesUsuarioList;

    public GesFuncionario() {
    }

    public GesFuncionario(Integer funCod) {
        this.funCod = funCod;
    }

    public Integer getFunCod() {
        return funCod;
    }

    public void setFunCod(Integer funCod) {
        this.funCod = funCod;
    }

    public String getFunFuncao() {
        return funFuncao;
    }

    public void setFunFuncao(String funFuncao) {
        this.funFuncao = funFuncao;
    }

    public Date getFunDataContratacao() {
        return funDataContratacao;
    }

    public void setFunDataContratacao(Date funDataContratacao) {
        this.funDataContratacao = funDataContratacao;
    }

    public Integer getFunNumero() {
        return funNumero;
    }

    public void setFunNumero(Integer funNumero) {
        this.funNumero = funNumero;
    }

    public GesPessoa getFunPesCod() {
        return funPesCod;
    }

    public void setFunPesCod(GesPessoa funPesCod) {
        this.funPesCod = funPesCod;
    }

    @XmlTransient
    public List<GesUsuario> getGesUsuarioList() {
        return gesUsuarioList;
    }

    public void setGesUsuarioList(List<GesUsuario> gesUsuarioList) {
        this.gesUsuarioList = gesUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funCod != null ? funCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GesFuncionario)) {
            return false;
        }
        GesFuncionario other = (GesFuncionario) object;
        if ((this.funCod == null && other.funCod != null) || (this.funCod != null && !this.funCod.equals(other.funCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesFuncionario[ funCod=" + funCod + " ]";
    }
    
}
