import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o usuário do GitHub: ");
        String username = scanner.nextLine();
        String url = "https://api.github.com/users/" + username;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Accept", "application/vnd.github.v3+json")
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404){
                throw new ErroConsultaGitHubException("ERRO: Usuario não encontrado");
            }

            String json = response.body();
            System.out.println(json);
        } catch (IOException | InterruptedException e){
            System.out.println("Ocorreu um erro. Tente novamente.");
            e.printStackTrace();
        } catch (ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }

    }
}