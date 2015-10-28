/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ges_pessoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GesPessoa.findAll", query = "SELECT g FROM GesPessoa g"),
    @NamedQuery(name = "GesPessoa.findByPesCod", query = "SELECT g FROM GesPessoa g WHERE g.pesCod = :pesCod"),
    @NamedQuery(name = "GesPessoa.findByPesNome", query = "SELECT g FROM GesPessoa g WHERE g.pesNome = :pesNome"),
    @NamedQuery(name = "GesPessoa.findByPesCpf", query = "SELECT g FROM GesPessoa g WHERE g.pesCpf = :pesCpf"),
    @NamedQuery(name = "GesPessoa.findByPesRg", query = "SELECT g FROM GesPessoa g WHERE g.pesRg = :pesRg"),
    @NamedQuery(name = "GesPessoa.findByPesTipo", query = "SELECT g FROM GesPessoa g WHERE g.pesTipo = :pesTipo"),
    @NamedQuery(name = "GesPessoa.findByPesTelefone", query = "SELECT g FROM GesPessoa g WHERE g.pesTelefone = :pesTelefone"),
    @NamedQuery(name = "GesPessoa.findByPesCelular", query = "SELECT g FROM GesPessoa g WHERE g.pesCelular = :pesCelular"),
    @NamedQuery(name = "GesPessoa.findByPesDataNascimento", query = "SELECT g FROM GesPessoa g WHERE g.pesDataNascimento = :pesDataNascimento"),
    @NamedQuery(name = "GesPessoa.findByPesEndereco", query = "SELECT g FROM GesPessoa g WHERE g.pesEndereco = :pesEndereco"),
    @NamedQuery(name = "GesPessoa.findByPesCidade", query = "SELECT g FROM GesPessoa g WHERE g.pesCidade = :pesCidade"),
    @NamedQuery(name = "GesPessoa.findByPesBairro", query = "SELECT g FROM GesPessoa g WHERE g.pesBairro = :pesBairro")})
public class GesPessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "PES_COD")
    private Integer pesCod;
    @Size(max = 100)
    @Column(name = "PES_NOME")
    private String pesNome;
    @Size(max = 11)
    @Column(name = "PES_CPF")
    private String pesCpf;
    @Size(max = 15)
    @Column(name = "PES_RG")
    private String pesRg;
    @Column(name = "PES_TIPO")
    private Character pesTipo;
    @Size(max = 20)
    @Column(name = "PES_TELEFONE")
    private String pesTelefone;
    @Size(max = 20)
    @Column(name = "PES_CELULAR")
    private String pesCelular;
    @Column(name = "PES_DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pesDataNascimento;
    @Size(max = 100)
    @Column(name = "PES_ENDERECO")
    private String pesEndereco;
    @Size(max = 45)
    @Column(name = "PES_CIDADE")
    private String pesCidade;
    @Size(max = 45)
    @Column(name = "PES_BAIRRO")
    private String pesBairro;
    @OneToMany(mappedBy = "funPesCod")
    private List<GesFuncionario> gesFuncionarioList;
    @OneToOne(mappedBy = "pesCod")
    private GesAluno gesAluno;
    @OneToMany(mappedBy = "cliPesCod")
    private List<GesCliente> gesClienteList;

    public GesPessoa() {
    }

    public GesPessoa(Integer pesCod) {
        this.pesCod = pesCod;
    }

    public Integer getPesCod() {
        return pesCod;
    }

    public void setPesCod(Integer pesCod) {
        this.pesCod = pesCod;
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesCpf() {
        return pesCpf;
    }

    public void setPesCpf(String pesCpf) {
        this.pesCpf = pesCpf;
    }

    public String getPesRg() {
        return pesRg;
    }

    public void setPesRg(String pesRg) {
        this.pesRg = pesRg;
    }

    public Character getPesTipo() {
        return pesTipo;
    }

    public void setPesTipo(Character pesTipo) {
        this.pesTipo = pesTipo;
    }

    public String getPesTelefone() {
        return pesTelefone;
    }

    public void setPesTelefone(String pesTelefone) {
        this.pesTelefone = pesTelefone;
    }

    public String getPesCelular() {
        return pesCelular;
    }

    public void setPesCelular(String pesCelular) {
        this.pesCelular = pesCelular;
    }

    public Date getPesDataNascimento() {
        return pesDataNascimento;
    }

    public void setPesDataNascimento(Date pesDataNascimento) {
        this.pesDataNascimento = pesDataNascimento;
    }

    public String getPesEndereco() {
        return pesEndereco;
    }

    public void setPesEndereco(String pesEndereco) {
        this.pesEndereco = pesEndereco;
    }

    public String getPesCidade() {
        return pesCidade;
    }

    public void setPesCidade(String pesCidade) {
        this.pesCidade = pesCidade;
    }

    public String getPesBairro() {
        return pesBairro;
    }

    public void setPesBairro(String pesBairro) {
        this.pesBairro = pesBairro;
    }

    @XmlTransient
    public List<GesFuncionario> getGesFuncionarioList() {
        return gesFuncionarioList;
    }

    public void setGesFuncionarioList(List<GesFuncionario> gesFuncionarioList) {
        this.gesFuncionarioList = gesFuncionarioList;
    }

    public GesAluno getGesAluno() {
        return gesAluno;
    }

    public void setGesAluno(GesAluno gesAluno) {
        this.gesAluno = gesAluno;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.pesCod);
        hash = 97 * hash + Objects.hashCode(this.pesNome);
        hash = 97 * hash + Objects.hashCode(this.pesCpf);
        hash = 97 * hash + Objects.hashCode(this.pesRg);
        hash = 97 * hash + Objects.hashCode(this.pesTipo);
        hash = 97 * hash + Objects.hashCode(this.pesTelefone);
        hash = 97 * hash + Objects.hashCode(this.pesCelular);
        hash = 97 * hash + Objects.hashCode(this.pesDataNascimento);
        hash = 97 * hash + Objects.hashCode(this.pesEndereco);
        hash = 97 * hash + Objects.hashCode(this.pesCidade);
        hash = 97 * hash + Objects.hashCode(this.pesBairro);
        hash = 97 * hash + Objects.hashCode(this.gesFuncionarioList);
        hash = 97 * hash + Objects.hashCode(this.gesAluno);
        hash = 97 * hash + Objects.hashCode(this.gesClienteList);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GesPessoa other = (GesPessoa) obj;
        if (!Objects.equals(this.pesCod, other.pesCod)) {
            return false;
        }
        if (!Objects.equals(this.pesNome, other.pesNome)) {
            return false;
        }
        if (!Objects.equals(this.pesCpf, other.pesCpf)) {
            return false;
        }
        if (!Objects.equals(this.pesRg, other.pesRg)) {
            return false;
        }
        if (!Objects.equals(this.pesTipo, other.pesTipo)) {
            return false;
        }
        if (!Objects.equals(this.pesTelefone, other.pesTelefone)) {
            return false;
        }
        if (!Objects.equals(this.pesCelular, other.pesCelular)) {
            return false;
        }
        if (!Objects.equals(this.pesDataNascimento, other.pesDataNascimento)) {
            return false;
        }
        if (!Objects.equals(this.pesEndereco, other.pesEndereco)) {
            return false;
        }
        if (!Objects.equals(this.pesCidade, other.pesCidade)) {
            return false;
        }
        if (!Objects.equals(this.pesBairro, other.pesBairro)) {
            return false;
        }
        if (!Objects.equals(this.gesFuncionarioList, other.gesFuncionarioList)) {
            return false;
        }
        if (!Objects.equals(this.gesAluno, other.gesAluno)) {
            return false;
        }
        if (!Objects.equals(this.gesClienteList, other.gesClienteList)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesPessoa[ pesCod=" + pesCod + " ]";
    }
    
}
