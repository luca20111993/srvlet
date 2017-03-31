/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienti.a.presentation;

import clienti.a.entity.Cliente;
import clienti.a.service.ClienteService;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */

@WebServlet(urlPatterns = "/cliente")   //ci permette di specificare il percorso


//Quando lancio dopo mettere /prova

public class ProvaServlet  extends HttpServlet{
    
    //serve un db e quindi glipassiamo cliente service.
    //Inject passa un'istanza della classe dbservice pronta all'uso
    @Inject
    ClienteService clienteService;

    
    
    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("init()....");
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("destroy()....");
    }
    
    
    /*
    //L'oggetto response ci permette di rispondere al browser
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //In entrata abbiamo un parametro req e in questo caso vogliamo l'id
        String p = req.getParameter("id");
        
        //Se voglio vedere qualcosa quando poi vado in run devo mettere /prova?id=10 e guardare output
        
        System.out.println("Chiamata a doGet() ok ..." + p);
        
        //Se vogliamo rispondere al browser:
        
        resp.getWriter().println("<p> " + p + "</p>");
    }
    */
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        StringBuilder sb = new StringBuilder("<html><head><title> Elenco Clienti </title><head>");
        sb.append("<body><table>");
        
        
        for (Cliente cli : clienteService.findAll()) {
            sb.append("<tr>");
            sb.append("<td>" + cli.getId() + "</td>");
            sb.append("<td>" + cli.getRagioneSociale()+ "</td>");
            sb.append("<td>" + cli.getIndirizzo()+ "</td>");
            sb.append("</tr>");
        }
    sb.append("</table></body></html>");
    resp.getWriter().println(sb.toString());
    }

    
    //Scriviamo do post perchè il metodo form richiama il dopost con POST.
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Richiedo il parametro ragsoc
        String a= req.getParameter("rag_soc");
        //Richiedo il parametro indirizzo
        String b = req.getParameter("ind");
        
        //resp.getWriter().println("Aggiunto cliente con parametri \nRag_Soc: " + a + "  --  Ind: " + b);
        
        //Creo un nuovo cliete gli aggiungo indirizzo e ragsoc e lo salvo.
        Cliente cli = new Cliente();
        cli.setIndirizzo(b);
        cli.setRagioneSociale(a);
        clienteService.save(cli);
        //Per ridirigere vs sito indicato
        resp.sendRedirect("index.html");
        
    }
    
    
    
}
