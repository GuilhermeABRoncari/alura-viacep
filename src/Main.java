import br.com.alura.viacep.infra.ConsultaCep;
import br.com.alura.viacep.infra.GeradorDeArquivo;
import br.com.alura.viacep.model.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cep;

        System.out.print("Digite seu CEP: ");
        cep = scanner.next();

        try {
            Endereco endereco = new ConsultaCep().buscaEndereco(cep);
            System.out.println(endereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.geraArquivo(endereco);
        } catch (RuntimeException | IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Finalizando aplicação...");
        }
    }
}