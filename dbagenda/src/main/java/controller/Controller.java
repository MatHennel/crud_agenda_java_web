package controller;

import entidade.Contato;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ContatoService;
import services.ContatosServiceImp;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = {"/Controller", "/main", "/insert"})

public class Controller extends HttpServlet {


     private final ContatoService contatoService = new ContatosServiceImp();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getServletPath();

        if(action.equals("/main")){
            contatos(req, resp);
        }else if(action.equals("/insert")){
            novoContato(req,resp);
        } else{
            resp.sendRedirect("index.html");
        }
    }

    protected void contatos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.sendRedirect("agenda.jsp");
    }

    protected void novoContato(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

         String nome = req.getParameter("nome");
         String fone = req.getParameter("fone");
         String email = req.getParameter("email");
         Contato contato = new Contato(null, nome, fone, email);
         contatoService.save(contato);
         resp.sendRedirect("main");


    }
}
