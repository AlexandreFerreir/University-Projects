public class Exercicio1AlexandreGoncalvesRodriguesFerreira {
    public static void fatura(String produtos,String encomenda){
        //declarar tabelas de strings para armazenar os dados dos produtos e encomendas de forma a permitir uma pesquisa eficiente
        String[] dados_produtos= produtos.split("[;:]");//tabela com o conteudo separado pelo símbolo ";" e ":"
        String[] dados_encomenda=encomenda.split("[@;]");//tabela com o conteudo separado pelo símbolo "@" e ";"
        int total = 0;//variável para guardar o total do preço da encomenda
        for (int i = 1; i < dados_encomenda.length; i+=2) {//ciclos for para percorrer os nomes dos produtos encomendados (2 em 2 posições começando no i=1 pois os nomes estão nas posições ímpares)
            for (int j = 0; j < dados_produtos.length; j+=2) {//ciclos for para percorrer os nomes dos produtos disponiveis(2 em 2 posições começando no i=0 pois os nomes estão nas posições pares)
                if(dados_produtos[j].equalsIgnoreCase(dados_encomenda[i])) {//condição com função booleana que dá return true se os dois nomes dos produtos forem iguais, ignorando as diferenças de maiúsculas e minúsculas
                    //Print da fatura, com a respetiva quantidade, nome do produto e o seu preço no total ((quantidade * preço do produto) este que é possível através da função Integer.parseInt que transforma string em inteiro)
                    System.out.printf("%3s x %5s: %3d\n", dados_encomenda[i-1], dados_encomenda[i],
                            (Integer.parseInt(dados_encomenda[i - 1])) * (Integer.parseInt(dados_produtos[j+1])));
                    total+=(Integer.parseInt(dados_encomenda[i - 1])) * (Integer.parseInt(dados_produtos[j+1]));//variável que vai somando os preço total de cada produto
                }
            }
        }
        System.out.printf("\t  Total: %4d Euro(s)",total); //print da variável total
    }
    public static void main(String[] args) {
        //Declarar variáveis para armazenar as strings dos produtos e encomendas
        String produtos = "Mesa:30;Cadeira:25;Faca:2;Copo:3;Fogão:255;Jarro:4;Prato:3";
        String encomenda = "20@copo;5@faca;4@Mesa;1@fogão";
        fatura(produtos,encomenda); //chamar método para fazer a impressão da fatura
    }
}
