import classes.*;
import java.sql.SQLOutput;
import java.util.*;
import com.mysql.cj.xdevapi.Client;
import javax.xml.transform.Source;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Livro l1 = new Livro("O poder do infinito","Steven Strogatz");
        Livro l2 = new Livro("O diabo dos números" , "Hans Magnus");
        Livro l3 = new Livro("O homem que calculava" , "Malba Tahan");
        Livro l4 = new Livro("Código Limpo" , "Robert Cecil");
        Livro l5 = new Livro("Engenharia de Software" , "Roger Pressman");
        Livro l6 = new Livro("Engenharia de Software" , "Ian Sommerville");
        Livro l7 = new Livro("Padrões de Projetos", "Erich Gamma");

        LivroDAO livroDAO = new LivroDAO();

        if(livroDAO.add_muitos_livros(Arrays.asList(l1,l2,l3,l4,l5,l6,l7))){
            System.out.println("Adicionado com sucesso");
        }

        List<Livro> livros = livroDAO.buscarLivrosPorTitulo("O");
        for(Livro li: livros){
            System.out.println(li);
        }
    }
}
