/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diego Sabino
 */
@Entity
@Table(name = "ges_aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GesAluno.findAll", query = "SELECT g FROM GesAluno g"),
    @NamedQuery(name = "GesAluno.findByAluCod", query = "SELECT g FROM GesAluno g WHERE g.aluCod = :aluCod"),
    @NamedQuery(name = "GesAluno.findByAluSerie", query = "SELECT g FROM GesAluno g WHERE g.aluSerie = :aluSerie"),
    @NamedQuery(name = "GesAluno.findByAluIdade", query = "SELECT g FROM GesAluno g WHERE g.aluIdade = :aluIdade"),
    @NamedQuery(name = "GesAluno.findByAluNumero", query = "SELECT g FROM GesAluno g WHERE g.aluNumero = :aluNumero")})
public class GesAluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALU_COD")
    private Integer aluCod;
    @Size(max = 45)
    @Column(name = "ALU_SERIE")
    private String aluSerie;
    @Column(name = "ALU_IDADE")
    private Integer aluIdade;
    @Column(name = "ALU_NUMERO")
    private Integer aluNumero;
    @JoinColumn(name = "PES_COD", referencedColumnName = "PES_COD")
    @OneToOne
    private GesPessoa pesCod;
    @OneToMany(mappedBy = "cliAluCod")
    private List<GesCliente> gesClienteList;

    public GesAluno() {
    }

    public GesAluno(Integer aluCod) {
        this.aluCod = aluCod;
    }

    public Integer getAluCod() {
        return aluCod;
    }

    public void setAluCod(Integer aluCod) {
        this.aluCod = aluCod;
    }

    public String getAluSerie() {
        return aluSerie;
    }

    public void setAluSerie(String aluSerie) {
        this.aluSerie = aluSerie;
    }

    public Integer getAluIdade() {
        return aluIdade;
    }

    public void setAluIdade(Integer aluIdade) {
        this.aluIdade = aluIdade;
    }

    public Integer getAluNumero() {
        return aluNumero;
    }

    public void setAluNumero(Integer aluNumero) {
        this.aluNumero = aluNumero;
    }

    public GesPessoa getPesCod() {
        return pesCod;
    }

    public void setPesCod(GesPessoa pesCod) {
        this.pesCod = pesCod;
    }

    @XmlTransient
    public List<GesCliente> getGesClienteList() {
        return gesClienteList;
    }

    public void setGesClienteList(List<GesCliente> gesClienteList) {
        this.gesClienteList = gesClienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aluCod != null ? aluCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GesAluno)) {
            return false;
        }
        GesAluno other = (GesAluno) object;
        if ((this.aluCod == null && other.aluCod != null) || (this.aluCod != null && !this.aluCod.equals(other.aluCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesAluno[ aluCod=" + aluCod + " ]";
    }
    
}
