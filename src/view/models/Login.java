package view.models;

import view.models.PessoaTableModel;
import view.models.DataStore;


public class Login {
	
	public Login(){
		
	}
	
	public int verificacao(String cpf, String senha,PessoaTableModel modelP){
			DataStore datastore = DataStore.getInstance();
			
			try 
			{
				modelP.setData(datastore.loadPessoas());
				for(int i = 0; i < modelP.getData().size(); i ++){  
		            if(modelP.getData().get(i).getCpf().equals(cpf)){  
		            	if(modelP.getData().get(i).getSenha().equals(senha)){  
			                return i;    
			            }else{  
			                return -1;
			                  
			            }        
		            }
		            	
		        }
				return -1;
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return -1;	
			}
			
	}
}
