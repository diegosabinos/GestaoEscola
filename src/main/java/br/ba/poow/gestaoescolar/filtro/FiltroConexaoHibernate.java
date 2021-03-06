/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poow.gestaoescolar.filtro;

import br.ba.poow.gestaoescolar.util.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 ** Autor: Andre Portugal * Data : 01/01/2012 * Sistema de Gestão de Notas Fiscais Eletrônicas de Serviços 
 */
public class FiltroConexaoHibernate implements Filter{
    private SessionFactory sf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            this.sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
        } catch (Throwable e) {
            try {
                if (this.sf.getCurrentSession().getTransaction().isActive()){
                    this.sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
