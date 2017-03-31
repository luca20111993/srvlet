/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.a.service;

import clienti.a.entity.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */

//Quando facciamo delle classi per lavori complessi per le quali ci servono tutta una serie di funz ci conviene fare javabin e il più usato è stateless.

//La maggior parte delle classi che fanno lavori importanti  vengono annotati con stateless


@Stateless
@Named("clientiSrv") //Indicandogli il nome col quale una pagina jsp può interagire con un oggetto clienteservice.
           //Se non gli mettiamo il nome jsp prende il nome della classe con la prima lettera minuscola
public class ClienteService {

//Ci serve l'entity manager
//Ci viene fornita un'istanza di Entitymanager con le caratt dell'entity manager.
@PersistenceContext
EntityManager em;

public List<Cliente> findAll(){
    return em.createNamedQuery("Cliente.all") . getResultList();
}

public Cliente save (Cliente tosave){
    return em.merge(tosave);
}

public void delete(Long id){
    
    Cliente find = em.find(Cliente.class, id);
    
    em.remove(find);
}








}
