package prova;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class csvControl {
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			List<Operacao> listO = Operacao.getOperacoes("C:\\Users\\re039847\\Desktop\\desafio\\Operacoes.csv");
			List<DadosDeMercado> listD = DadosDeMercado.getDados("C:\\Users\\re039847\\Desktop\\desafio\\DadosMercado.csv");
			long finish;
			
			ArrayList<Resultado> listR = Resultado.acharResultados(listD, listO);
			ArrayList<Resultado> agrupados = Resultado.agruparSubProdutos(listR);
			
			BufferedWriter bw = new BufferedWriter (new FileWriter("C:\\Users\\re039847\\Desktop\\desafio\\Resultados.csv"));
			for(Resultado resul : agrupados) {
				bw.write(resul.getSubproduto()+";"+resul.getResultado());
				bw.newLine();
			}
			bw.close();
			
			finish = (System.currentTimeMillis() - start)/10;
			System.out.println(finish + " Segundos");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
