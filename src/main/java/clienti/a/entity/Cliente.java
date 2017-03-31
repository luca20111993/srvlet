/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.a.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;












/**
 *
 *public static enum tipo{
 * entrata uscita 
 * }
 * 
 * 
 * 
 * 
 * @enumerated (enumtype.String) 
 * private tipo
 */




/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(
            name = "Cliente.all",
            query = "select c from Cliente c order by c.ragioneSociale DESC"),
    @NamedQuery(
            name = "Cliente.findByName",
            query = "select c from Cliente c where c.ragioneSociale= :ragsoc")
})
@Entity
@Table (name = "Cliente")
public class Cliente implements Serializable{

    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String ragioneSociale;
    private String indirizzo;

    public Cliente() {
    }

    
    public Cliente(String ragSoc) {
        this.ragioneSociale = ragSoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo + '}';
    }

}
