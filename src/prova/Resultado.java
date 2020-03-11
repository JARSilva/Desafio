package prova;

import java.util.ArrayList;

public class Resultado {
	String subproduto;
	double resultado;

	public Resultado(String subproduto, double resultado) {
		super();
		this.subproduto = subproduto;
		this.resultado = resultado;
	}

	public String getSubproduto() {
		return subproduto;
	}

	public void setSubproduto(String subproduto) {
		this.subproduto = subproduto;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public static ArrayList<Resultado> agruparSubProdutos(ArrayList<Resultado> listR) {
		ArrayList<Resultado> resulAgrupados = new ArrayList<Resultado>();
		resulAgrupados.add(listR.get(0));
		boolean igual;
		for (Resultado resul : listR) {
			igual = false;
			for (Resultado resulA : resulAgrupados) {
				if(resul.getSubproduto().equals(resulA.getSubproduto())) {
					igual = true;
				}
			}
			if(!igual) {
				resulAgrupados.add(new Resultado(resul.getSubproduto(), 0));
			}
		}
		for (Resultado resul : listR) {
			for (Resultado resulA : resulAgrupados) {
				if (resulA.getSubproduto().equals(resul.getSubproduto())) {
					resulA.setResultado(resulA.getResultado() + resul.getResultado());
				}
			}
		}
		String resultado = "";
		for (Resultado resulA : resulAgrupados) {
			resultado += "\n"+resulA.getSubproduto() +" - "+ resulA.getResultado();
		}
		System.out.println(resultado);
		return resulAgrupados;
		
	}
}
