package prova;

import java.util.ArrayList;
import java.util.List;

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
		resulAgrupados.add(new Resultado(listR.get(0).getSubproduto(), 0));
		boolean igual;
		for (Resultado resul : listR) {
			igual = false;
			for (Resultado resulA : resulAgrupados) {
				if (resul.getSubproduto().equals(resulA.getSubproduto())) {
					resulA.setResultado(resulA.getResultado() + resul.getResultado());
					igual = true;
				}
			}
			if (!igual) {
				resulAgrupados.add(resul);
			}
		}
		return resulAgrupados;

	}

	public static ArrayList<Resultado> acharResultados(List<DadosDeMercado> listD, List<Operacao> listO) {
		boolean nAchou;
		ArrayList<Resultado> listR = new ArrayList<Resultado>();
		for (Operacao op : listO) {
			nAchou = true;
			for (DadosDeMercado da : listD) {
				if (da.getNu_prazo() == op.getNu_prazo() && da.getId_preco() == op.getId_preco()) {
					listR.add(new Resultado(op.getSubProduto(), (op.getQuantidade() * da.getVl_preco())));
					break;
				}
			}
			if (nAchou)
				listR.add(new Resultado(op.getSubProduto(), 0));
		}
		return listR;
	}
}
