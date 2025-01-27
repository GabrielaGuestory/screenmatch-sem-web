package br.com.alura.screenmatch;

import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var jason = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=3bfbfbbc");
		System.out.println(jason);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(jason, DadosSerie.class);
		System.out.println(dados);
	}
}
