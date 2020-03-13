package prova;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadosDeMercado {
	public static int numId = 1;
	private int id;
	private int id_preco;
	private int nu_prazo;
	private double vl_preco;
	
	
	public DadosDeMercado(int id_preco, int nu_prazo, double vl_preco) {
		super();
		this.id = numId++;
		this.id_preco = id_preco;
		this.nu_prazo = nu_prazo;
		this.vl_preco = vl_preco;
	}
	public DadosDeMercado(int id_preco, int nu_prazo) {
		this.id_preco = id_preco;
		this.nu_prazo = nu_prazo;
		this.vl_preco = 0;
	}
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_preco() {
		return id_preco;
	}
	public void setId_preco(int id_preco) {
		this.id_preco = id_preco;
	}
	public int getNu_prazo() {
		return nu_prazo;
	}
	public void setNu_prazo(int nu_prazo) {
		this.nu_prazo = nu_prazo;
	}
	public double getVl_preco() {
		return vl_preco;
	}
	public void setVl_preco(double vl_preco) {
		this.vl_preco = vl_preco;
	}
	
	public static List<DadosDeMercado> getDados(String path) throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader(path));
		List<DadosDeMercado> lista = new ArrayList<DadosDeMercado>();
		String linha;
		bf.readLine();
		while ((linha = bf.readLine()) != null) {
			String[] colunas = linha.split(";");
			DadosDeMercado dados = new DadosDeMercado(Integer.parseInt(colunas[0]),Integer.parseInt(colunas[1]),Double.parseDouble(colunas[2].replace(',', '.')));
			lista.add(dados);
		}
		bf.close();
		return lista;
		
	}

}
