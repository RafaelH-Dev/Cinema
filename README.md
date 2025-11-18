# Cinema

## Filme

**Função:** Criar filmes  
**Usa:** ``Notas``  
**Usada por:** ``Sala``, ``Cinema``

```Java
private Notas notas = new Notas();

```

Composição da classe notas para armazenar as notas do filme.

```Java  
public void adicionarNota(double nota) {
    notas.adicionarNota(nota);
}
```  
Método que adiciona a nota ao filme utilizando a classe notas.  
  
```Java

@Override
public String toString() {
    return String.format("Filme: %s | Gênero: %s | Duração: %d min | Avaliação do filme: %.1f | Avaliações: %d",
        getNomeFilme(), getGeneroFilme(), getDuracaoMinutos(), getClassificacaoFilme(), notas.getAvaliacoes());
}
```  
Formato da exibição:  
  
Filme: Exemplo | Gênero: Fantasia | Duração: 60 min | Avaliação do filme: 4,5 | Avaliações: 150  
  
## Notas
**Função:** Adicionar uma nota ao filme  
**Usada por:** Filme
```Java  
private ArrayList<Double> notas = new ArrayList<>();
```  
Cria um array de notas.  

```Java  
public void adicionarNota(double nota) {
    notas.add(nota);
}
```  
Adiciona uma nota ao array de notas.  

```Java  
private double mediaNotaFilme() {
    if (notas.isEmpty()) {
        return 0;
    }
    double media = 0;
    for (double nota : notas) {
        media += nota;
    }
    return media / notas.size();
}
```  
Calcula a média das notas.  

## Ingressos
**Função:** Vender ingressos  
**Usada por:** ``Sala``

  ```Java  
public boolean venderIngressos() {
    if(ingressosVendidos<capacidadeIngressos){
        ingressosVendidos++;
        return true;
    }
    return false;
}
```  
Método que incrementa o valor de ``ingressosVendidos`` caso a quantidade de ingressos vendidas seja menor que a capacidade de ingressos, retornando se foi possível vender ou não.


  
## Sala  
**Função:** Criar uma sala  
**Usa:** ``Filme``, ``Ingressos``  
**Usada por:** ``Cinema``
```Java
private Filme filmeEmExibicao;
```  
Criação de um Rich Object ```filmeEmExibição``` para filmes em exibição utilizando a classe ```Filme```.  
  
```Java  
  public Sala(String numeroSala, int capacidadeIngressos) {
    setNumeroSala(numeroSala);
    setCapacidadeIngressos(capacidadeIngressos);
    ingresso = new Ingressos(capacidadeIngressos);
}

    public Sala(String numeroSala, Filme filmeEmExibicao, int capacidadeIngressos) {
        setNumeroSala(numeroSala);
        setFilmeEmExibicao(filmeEmExibicao);
        setCapacidadeIngressos(capacidadeIngressos);
        ingresso = new Ingressos(capacidadeIngressos);
}
```  
  
Utiliza sobrecarga de construtores na classe ```Sala``` para criar uma sala com ou sem um filme em exibição.  
  

  ```Java  
public String getNomeFilmeOuPadrao() {
    if (filmeEmExibicao == null) {
        return "Filme não cadastrado";
    }
    return filmeEmExibicao.getNomeFilme();
}

public double getAvaliacaoFilmeOuZero() {
    if (filmeEmExibicao == null) {
        return 0.0;
    }
    return filmeEmExibicao.getClassificacaoFilme();
}
````  
Utiliza getters para retornar algo caso o objeto ```filmeEmExibiçâo``` seja nulo.  

```Java  
public boolean venderIngresso() {
    return ingresso.venderIngressos();
}
```  
O método encapsula a operação de vender um ingresso chamando o método ```venderIngresso()``` atráves do objeto ```ingresso```.  

```Java  

@Override
public String toString() {
    return String.format(
        "Número da sala: %s\nCapacidade de ingressos: %d\nIngressos vendidos: %d\nFilme em exibição: %s\nAvaliação do Filme: %.1f",
        getNumeroSala(),
        getCapacidadeIngressos(),
        ingresso.getIngressosVendidos(),
        getNomeFilmeOuPadrao(),
        getAvaliacaoFilmeOuZero()
    );
}
```  
Formato de exibição:  

Numero da sala: 01  
Capacidade de ingressos: 50  
Ingressos vendidos: 45  
Filme em exibição: Exemplo  
Avaliação do filme: 5,0  
  
## Cinema  
**Função:** Gerenciar Sala e Filme 
**Usa:** ``Sala``, ``Filme``
```Java  
private static ArrayList<Sala> minhasSalas = new ArrayList<>();
private static ArrayList<Filme> meusFilmes = new ArrayList<>();
```  
Cria um array de salas e filmes.  

```Java  
public static void cadastrarSala(Sala novaSala) {
    Sala sala = verificadorSala(novaSala.getNumeroSala());
    if (sala == null) {
        minhasSalas.add(novaSala);
    }
}
```
Cadastra uma sala caso não exista alguma com o mesmo numero.  
  
```Java  
public static void exibirSalas() {
    for (Sala sala : minhasSalas) {
        System.out.println(sala);
    }
}
```  
Exibe as salas cadastradas.  
  
````Java  
private static Sala verificadorSala(String numeroDaSala) {
    for (Sala sala : minhasSalas) {
        if (sala.getNumeroSala().equals(numeroDaSala)) {
            return sala;
        }
    }
    return null;
}
````  
Verifica se existe alguma sala com o mesmo numero de sala do paramêtro. Se sim, retorna essa sala, se não, retorna null.  

```Java  
public static boolean removeSala(String numeroDaSala) {
    Sala sala = verificadorSala(numeroDaSala);
    if (sala != null) {
        minhasSalas.remove(sala);
        return true;
    }
    return false;
}
```  
Remove uma sala do meu array de salas caso ela exista, utilizando o meu método ``verificadorSala()``.  
  
````Java  
private static Filme verificadorFilme(String nomeDoFilme) {
    for (Filme filme : meusFilmes) {
        if (filme.getNomeFilme().equals(nomeDoFilme)) {
            return filme;
        }
    }
    return null;
}
````  
Verifica se existe um filme com o mesmo nome do paramêtro, se sim, retorna esse filme, se não, retorna null.  
  
````Java
public static boolean avaliarFilme(String nomeDoFilme, double nota) {
    Filme filme = verificadorFilme(nomeDoFilme);
    if (filme != null) {
        filme.adicionarNota(nota);
        return true;
    }
    return false;
}
````  
Utiliza o método ``verificadorFilme()`` para ver se o filme existe, se sim, adiciona a nota.  
  
````Java  
public static void exibirFilmes() {
    for (Filme filme : meusFilmes) {
        System.out.println(filme);
    }
}
````
Método percorre o array de filmes e exibe quais filmes existem.  
  
````Java  
public static void cadastrarFilme(String numeroDaSala, Filme novoFilme) {
    for (Sala sala : minhasSalas) {
        if (sala.getNumeroSala().equals(numeroDaSala)) {
            sala.setFilmeEmExibicao(novoFilme);
            return;
        }
    }
}
````  
Cadastra um filme no array de filmes e em uma sala já existente.  
  
````Java  
public static boolean cadastrarFilmeSemSala(Filme novoFilme) {
    for (Filme filme : meusFilmes) {
        if (filme.getNomeFilme().equals(novoFilme.getNomeFilme())) {
            return false;
        }
    }
    return meusFilmes.add(novoFilme);
}
````  
Cadastra um filme apenas no array de filmes.  
  
````Java  
public static boolean colocarFilmeSemSalaEmSala(String numeroDaSala, String nomeDoFilme) {
    Sala sala = verificadorSala(numeroDaSala);
    Filme filme = verificadorFilme(nomeDoFilme);
    if (filme != null && sala != null) {
        sala.setFilmeEmExibicao(filme);
        return true;
    }
    return false;
}
````  
Utiliza os dois verificadores para conferir se sala e filme existem e coloca o filme já cadastrado em uma sala.  
   
````Java  
  public static boolean removerFilme(String nomeDoFilme) {
    Filme filme = verificadorFilme(nomeDoFilme);
    if (filme != null) {
        for (Sala sala : minhasSalas) {
            if (sala.getFilmeEmExibicao() == filme) {
                sala.setFilmeEmExibicao(null);
            }
        }
        return meusFilmes.remove(filme);
    }
    return false;
}
````  
Esse método remove um filme do array de filmes.  
  
Antes de excluir o filme do array, o método percorre todas as salas e remove o filme de qualquer sala que ainda o esteja exibindo. Isso evita que uma sala continue exibindo um filme que já não existe mais no cadastro, corrigindo o erro em que um objeto que foi removido é referenciado.  
  
````Java  
  public static boolean removerFilmeDaSala(String numeroDaSala, String nomeDoFilme) {
    Filme filme = verificadorFilme(nomeDoFilme);
    Sala sala = verificadorSala(numeroDaSala);
    if (filme != null) {
        for (Sala salas : minhasSalas) {
            if (salas.getFilmeEmExibicao() == filme && salas == sala) {
                salas.setFilmeEmExibicao(null);
                return true;
            }
        }
    }
    return false;
}
````  
Utiliza os dois verificadores para conferir se a sala e o filme existem e remove o filme apenas da sala, pois o filme ainda continua no array de filmes.

