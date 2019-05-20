import java.util.List;

import br.org.servlet.DAO.EmpresaDAO;
import br.org.servlet.model.Empresa;


public class Try {

	public static void main(String[] args) {
    
		
		List<Empresa> lista = EmpresaDAO.list();
		Empresa empresa = new Empresa("Jcn Sistemas","2018-02-20");
	
		//EmpresaDAO.add(empresa );
		
		System.out.println(lista);

	}

}
