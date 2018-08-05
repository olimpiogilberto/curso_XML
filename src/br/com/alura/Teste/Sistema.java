package br.com.alura.Teste;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.Model.Produto;


public class Sistema {
	

	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = fabrica.newDocumentBuilder();
		Document document = builder.parse("src/vendas.xml");
		
		Element venda = document.getDocumentElement();
		String moeda = venda.getAttribute("moeda");
		System.out.println(moeda);
		
		NodeList produtos = document.getElementsByTagName("produto");
		
		for(int i =0; i < produtos.getLength(); i++) {
		    Element produto = (Element) produtos.item(i);
		    String nome = produto.getElementsByTagName("nome").item(0).getTextContent();
		    String preco = produto.getElementsByTagName("preco").item(0).getTextContent();

		    System.out.println("-----------");
		    System.out.println("Nome do produto: "+ nome);
		    System.out.println("Preco do produto: "+ preco);
		    System.out.println("-----------");
		}

	}

}
