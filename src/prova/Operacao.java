package prova;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Operacao {
	private int cd_operacao;
	private int nu_prazo;
	private double quantidade;
	private int id_preco;
	private String subProduto;
	
	
	public Operacao(int cd_operacao, int nu_prazo, double qtd, int id_preco, String subProduto) {
		super();
		this.cd_operacao = cd_operacao;
		this.nu_prazo = nu_prazo;
		this.quantidade = qtd;
		this.id_preco = id_preco;
		this.subProduto = subProduto;
	}
	public int getCd_operacao() {
		return cd_operacao;
	}
	public void setCd_operacao(int cd_operacao) {
		this.cd_operacao = cd_operacao;
	}
	public int getNu_prazo() {
		return nu_prazo;
	}
	public void setNu_prazo(int nu_prazo) {
		this.nu_prazo = nu_prazo;
	}
	public double getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
	public int getId_preco() {
		return id_preco;
	}
	public void setId_preco(int id_preco) {
		this.id_preco = id_preco;
	}
	public String getSubProduto() {
		return subProduto;
	}
	public void setSubProduto(String subProduto) {
		this.subProduto = subProduto;
	}
	
	public static List<Operacao> getOperacoes(String path) throws FileNotFoundException{
		File arquivo = new File(path);
		boolean pularIndice = true;
		Scanner sc = new Scanner(arquivo);
		List<Operacao> lista = new ArrayList<Operacao>();
		while (sc.hasNextLine()) {
			if(pularIndice) {
				sc.nextLine();
				pularIndice = false;
				continue;
			}
			String[] colunas = sc.nextLine().split(";");
			int cd = Integer.parseInt(colunas[0]);
			int prazo = Operacao.calcularDias(colunas[1], colunas[2]);
			double qtd = Double.parseDouble(colunas[12].replace(',', '.'));
			int id_preco = Integer.parseInt(colunas[13]);
			String subprod = colunas[9];
			Operacao operacao = new Operacao(cd, prazo, qtd, id_preco, subprod);
			lista.add(operacao);
		}
		sc.close();
		return lista;
		
	}

	public static int calcularDias(String dataInicio, String dataFinal) {
		 DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
	        df.setLenient(false);
	        Date d1 = null;
	        Date d2 = null;
	        try {
	        	d1 = df.parse (dataInicio);
	        	d2 = df.parse (dataFinal);
	        }catch(Exception e) {
	        	
	        }
	        long dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
	        int dias =  (int) (dt / 86400000L);
			return dias; 
	}

}
