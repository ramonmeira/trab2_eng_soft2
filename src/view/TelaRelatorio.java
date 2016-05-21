/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramon
 */
public class TelaRelatorio extends JInternalFrame{
    
    public TelaRelatorio(int i){
        setIconifiable(true);
        setClosable(true);
        setResizable(true);
        setMaximizable(true);
        setBounds(100, 100, 450, 300);
        switch(i){
            case 1:{
                setTitle("Top 3 compradores");
            }break;
            case 2:{
                setTitle("Top 3 vendedores");
            }break;
            case 3:{
                setTitle("Top mais vendidos");
            }break;
            case 4:{
                setTitle("Clientes Cadastrados");
            }break;
            case 5:{
                setTitle("Estoque");
            }break;
            case 6:{
                setTitle("Funcionários Cadastrados");
            }break;
            case 7:{
                setTitle("Funcionários Inativos");
            }break;
            case 8:{
                setTitle("Vendas");
            }break;
            case 9:{
                setTitle("Fornecedores Ativos");
            }break;
            case 10:{
                setTitle("Produtos");
            }break;
            default:{
                JOptionPane.showMessageDialog(null,"Opção de relatório não definido para o sistema" , "Relatório não definido", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
}
