import br.com.will.dao.IPessoaDAO;
import br.com.will.dao.PessoaMapDAO;
import br.com.will.domain.Pessoa;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    private static IPessoaDAO iPessoaDAO;

    public static void main(String[] args) {
        iPessoaDAO = new PessoaMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consulta, 3 para excluir, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,
                    "Opcao invalida digite 1 para cadastro, 2 para consulta, 3 para excluir, 4 para alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

       while (isOpcaoValida(opcao)){
           if(isOpcaoSair(opcao)){
               sair();
           }else if(isCadastro(opcao)){
               String dados = JOptionPane.showInputDialog(null,"Digite os dados da pessoa separado por virgula, conforme exemplo: ID, Nome, Condicao de Saúde",
                       "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
               cadastrar(dados);
           }else if(isConsultar(opcao)) {
               String dados = JOptionPane.showInputDialog(null,
                       "Digite o cpf",
                       "Consulta pessoa", JOptionPane.INFORMATION_MESSAGE);
               consultar(dados);
           }else if(isExclusao(opcao)){
               String dados = JOptionPane.showInputDialog(null,
                       "Digite o cpf",
                       "Consulta pessoa", JOptionPane.INFORMATION_MESSAGE);
               excluir(dados);
           }else if(isAlterar(opcao)){
               String dados = JOptionPane.showInputDialog(null,
                       "Digite os dados da pessoa separado por virgula, conforme exemplo: ID, Nome, Condicao de Saúde",
                       "Atualização", JOptionPane.INFORMATION_MESSAGE);
               atualizar(dados);

           }


           opcao = JOptionPane.showInputDialog(null,
                   "Digite 1 para cadastro, 2 para consulta, 3 para excluir, 4 para alteração ou 5 para sair",
                   "Green dinner", JOptionPane.INFORMATION_MESSAGE);
       }
    }



    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Pessoa pessoa = new Pessoa(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2]);
        iPessoaDAO.alterar(pessoa);
    }

    private static void excluir(String dados) {
        iPessoaDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isExclusao(String opcao) {
        if("3".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }


    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");
        Pessoa pessoa = new Pessoa(dadosSeparados[0], dadosSeparados[1],dadosSeparados[2]);
        Boolean isCadastrado = iPessoaDAO.cadastrar(pessoa);
        if(isCadastrado){
               JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso","Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado", "Deu ruim", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isAlterar(String opcao) {
        if ("4".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        }
        return false;

    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo :)","Sair",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao)) {
            return true;
        }
        return false;
    }
    private static void consultar(String dados){
        Pessoa pessoa = iPessoaDAO.consultar(Long.parseLong(dados));
        if (pessoa != null) {
            JOptionPane.showMessageDialog(null, "Pessoa encontrada: " + pessoa.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaocadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }
}