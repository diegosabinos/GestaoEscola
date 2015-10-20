/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.mapeamento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diego Sabino
 */
@Entity
@Table(name = "ges_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GesUsuario.findAll", query = "SELECT g FROM GesUsuario g"),
    @NamedQuery(name = "GesUsuario.findByUsuCod", query = "SELECT g FROM GesUsuario g WHERE g.usuCod = :usuCod"),
    @NamedQuery(name = "GesUsuario.findByUsuLogin", query = "SELECT g FROM GesUsuario g WHERE g.usuLogin = :usuLogin"),
    @NamedQuery(name = "GesUsuario.findByUsuSenha", query = "SELECT g FROM GesUsuario g WHERE g.usuSenha = :usuSenha")})
public class GesUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_COD")
    private Integer usuCod;
    @Size(max = 45)
    @Column(name = "USU_LOGIN")
    private String usuLogin;
    @Size(max = 45)
    @Column(name = "USU_SENHA")
    private String usuSenha;
    @JoinColumn(name = "FUN_COD", referencedColumnName = "FUN_COD")
    @ManyToOne
    private GesFuncionario funCod;

    public GesUsuario() {
    }

    public GesUsuario(Integer usuCod) {
        this.usuCod = usuCod;
    }

    public Integer getUsuCod() {
        return usuCod;
    }

    public void setUsuCod(Integer usuCod) {
        this.usuCod = usuCod;
    }

    public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    public GesFuncionario getFunCod() {
        return funCod;
    }

    public void setFunCod(GesFuncionario funCod) {
        this.funCod = funCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuCod != null ? usuCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GesUsuario)) {
            return false;
        }
        GesUsuario other = (GesUsuario) object;
        if ((this.usuCod == null && other.usuCod != null) || (this.usuCod != null && !this.usuCod.equals(other.usuCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poow.gestaoescolar.mapeamento.GesUsuario[ usuCod=" + usuCod + " ]";
    }
    
}
