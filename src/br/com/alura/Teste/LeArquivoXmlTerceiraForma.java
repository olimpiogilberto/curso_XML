package br.com.alura.Teste;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import br.com.alura.Handlers.ProdutosHandler;
import br.com.alura.Model.Produto;

public class LeArquivoXmlTerceiraForma {
	
	public static void main(String[] args) throws Exception{

		InputStream is = new FileInputStream("src/vendas.xml");
		
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLEventReader eventos = factory.createXMLEventReader(is);
		Produto produto = new Produto();
		List<Produto> produtos = new ArrayList<>();
		
		while(eventos.hasNext()) {
			
			XMLEvent evento = eventos.nextEvent();
			
			if(evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("produto")) {
				
				
			}else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("nome")) {
				
				evento = eventos.nextEvent();
				String nome = evento.asCharacters().getData();
				produto.setNome(nome);
			} else if (evento.isStartElement() && evento.asStartElement().getName().getLocalPart().equals("preco")) {
				evento = eventos.nextEvent();
				String conteudo = evento.asCharacters().getData();
				double preco = Double.parseDouble(conteudo);
				produto.setPreco(preco);
			}else if (evento.isEndElement() && evento.asEndElement().getName().getLocalPart().equals("produto")) {
				produtos.add(produto);
				
			}
		}
		
		System.out.println(produtos);
		
		}

}
