package br.com.alura.Handlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.Model.Produto;

public class ProdutosHandler extends DefaultHandler {

	private List<Produto> produtos = new ArrayList<>();
	private StringBuilder conteudo = new StringBuilder();
	private Produto produto;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		/*System.out.println("Abriu a tag:" + qName);*/
		
		if(qName.equals("produto")) {
			
			produto = new Produto();
		}
		
		conteudo = new StringBuilder();
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		conteudo.append(new String(ch,start, length));
		
	}
	
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("produto")) {
			
			produtos.add(produto);
			
		}else if(qName.equals("nome")){
			
			produto.setNome(conteudo.toString());
		}else if(qName.equals("preco")){
			
			double preco = Double.parseDouble(conteudo.toString());
			produto.setPreco(preco);
			
		}
	}
	
}
