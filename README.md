## CrudEx2
**Filme**
```Java
public void mediaNotaFilme() {
    double notasSoma = 0;
    for (int i = 0; i < quantidadeDeAvaliacoes; i++) {
        notasSoma += notaFilme[i];
    }
    classificacaoFilme = notasSoma / quantidadeDeAvaliacoes;
}
```
O método calcula a média das notas com valores recebidos pelo usuário

