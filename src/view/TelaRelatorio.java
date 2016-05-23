/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.tools.FileOperations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        setBounds(100, 50, 550, 600);
        
        JTable tbLista = new javax.swing.JTable();
        JScrollPane scroll = new JScrollPane(tbLista);
        getContentPane().add(scroll);

        switch(i){
            case 1:{
                setTitle("Top 3 compradores");
                
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Cliente", "Quantidade de Compras" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("vendas");
                ArrayList lObjects = new ArrayList();
                for (int y = 0; y < lLista.size(); y = y+5)
                {
                    if (!lObjects.contains(lLista.get(y+1)))
                        lObjects.add(lLista.get(y+1));
                }
                List<List<Object>> lResult = new ArrayList();
                for (int y = 0; y < lObjects.size(); y++)
                {
                    int count = 0;
                    for (int z = 0; z < lLista.size(); z = z+5)
                    {
                        if (lLista.get(z+1) == lObjects.get(y))
                            count++;
                    }
                    List a = new ArrayList();
                    a.add(lObjects.get(y));
                    a.add(count);
                    lResult.add(a);
                }
                
                Collections.sort (lResult, new Comparator<List<Object>>() {
                    @Override
                    public int compare(List<Object> o1, List<Object> o2) 
                    {
                        return ((Integer)(o1.get(1))).compareTo((Integer)o2.get(1));
                    }
                });
                
                Collections.reverse(lResult);  
                for(List<Object> elemento: lResult)
                {
                    model.addRow(new Object[] {elemento.get(0), elemento.get(1)});
                }
            }break;
            case 2:{
                setTitle("Top 3 vendedores");
                
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Vendedor", "Quantidade de Vendas" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("vendas");
                ArrayList lObjects = new ArrayList();
                for (int y = 0; y < lLista.size(); y = y+5)
                {
                    if (!lObjects.contains(lLista.get(y+3)))
                        lObjects.add(lLista.get(y+3));
                }
                List<List<Object>> lResult = new ArrayList();
                for (int y = 0; y < lObjects.size(); y++)
                {
                    int count = 0;
                    for (int z = 0; z < lLista.size(); z = z+5)
                    {
                        if (lLista.get(z+3) == lObjects.get(y))
                            count++;
                    }
                    List a = new ArrayList();
                    a.add(lObjects.get(y));
                    a.add(count);
                    lResult.add(a);
                }
                
                Collections.sort (lResult, new Comparator<List<Object>>() {
                    @Override
                    public int compare(List<Object> o1, List<Object> o2) 
                    {
                        return ((Integer)(o1.get(1))).compareTo((Integer)o2.get(1));
                    }
                });
                
                Collections.reverse(lResult);  
                for(List<Object> elemento: lResult)
                {
                    model.addRow(new Object[] {elemento.get(0), elemento.get(1)});
                }
            }break;
            case 3:{
                setTitle("Top mais vendidos");
                
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Produto", "Quantidade" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("vendas");
                ArrayList lObjects = new ArrayList();
                for (int y = 0; y < lLista.size(); y = y+5)
                {
                    if (!lObjects.contains(lLista.get(y+4)))
                        lObjects.add(lLista.get(y+4));
                }
                List<List<Object>> lResult = new ArrayList();
                for (int y = 0; y < lObjects.size(); y++)
                {
                    int count = 0;
                    for (int z = 0; z < lLista.size(); z = z+5)
                    {
                        if (lLista.get(z+4) == lObjects.get(y))
                            count++;
                    }
                    List a = new ArrayList();
                    a.add(lObjects.get(y));
                    a.add(count);
                    lResult.add(a);
                }
                
                Collections.sort (lResult, new Comparator<List<Object>>() {
                    @Override
                    public int compare(List<Object> o1, List<Object> o2) 
                    {
                        return ((Integer)(o1.get(1))).compareTo((Integer)o2.get(1));
                    }
                });
                
                Collections.reverse(lResult);  
                for(List<Object> elemento: lResult)
                {
                    model.addRow(new Object[] {elemento.get(0), elemento.get(1)});
                }
                
            }break;
            case 4:{
                setTitle("Clientes Cadastrados");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Nome", "CPF" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("clientes");
                for (int y = 0; y < lLista.size(); y = y+21)
                {
                    model.addRow(new Object[] {lLista.get(y+1), lLista.get(y)});
                }
            }break;
            case 5:{
                setTitle("Estoque");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Produto", "Quantidade" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("estoque");
                for (int y = 0; y < lLista.size(); y = y+3)
                {
                    model.addRow(new Object[] {lLista.get(y+1), lLista.get(y+2)});
                }
            }break;
            case 6:{
                setTitle("Funcionários Cadastrados");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Nome", "CPF" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("funcionarios");
                for (int y = 0; y < lLista.size(); y = y+6)
                {
                    if (lLista.get(y+5).toString().contains("true"))
                        model.addRow(new Object[] {lLista.get(y+1), lLista.get(y)});
                }
            }break;
            case 7:{
                setTitle("Funcionários Inativos");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Nome", "CPF" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("funcionarios");
                for (int y = 0; y < lLista.size(); y = y+6)
                {
                    if (lLista.get(y+5).toString().contains("false"))
                        model.addRow(new Object[] {lLista.get(y+1), lLista.get(y)});
                }
            }break;
            case 8:{
                setTitle("Vendas");
                setTitle("Vendas");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"CPF Cliente", "CPF Vendendor", "Produto" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("vendas");
                for (int y = 0; y < lLista.size(); y = y+5)
                {
                    model.addRow(new Object[] {lLista.get(y), lLista.get(y+2), lLista.get(y+4)});
                }
            }break;
            case 9:{
                setTitle("Fornecedores Ativos");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"CNPJ", "Razão Social" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("fornecedores");
                for (int y = 0; y < lLista.size(); y = y+3)
                {
                    if (lLista.get(y+2).toString().contains("true"))
                        model.addRow(new Object[] {lLista.get(y), lLista.get(y+1)});
                }
            }break;
            case 10:{
                setTitle("Produtos");
                tbLista.setModel(new DefaultTableModel(
                    new Object [][] {   },
                    new String [] {"Código", "Produto" }
                ));

                DefaultTableModel model = (DefaultTableModel)tbLista.getModel();
                ArrayList lLista = FileOperations.getFileLines("produtos");
                for (int y = 0; y < lLista.size(); y = y+2)
                {
                    model.addRow(new Object[] {lLista.get(y), lLista.get(y+1)});
                }
            }break;
            default:{
                JOptionPane.showMessageDialog(null,"Opção de relatório não definido para o sistema" , "Relatório não definido", JOptionPane.ERROR_MESSAGE);
            }
        }
    }    
}
