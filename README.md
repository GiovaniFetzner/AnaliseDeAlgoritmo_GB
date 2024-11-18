# Trabalho de Grau B - Analisando jogos de civilizações antigas

Abraão M. Duarte e Giovani S. Fetzner

## Estrutura do Projeto

```bin
TrabalhoGrauB/
├── data/
│   ├── in                     # Casos de Teste
│   ├── in1
│   ├── in2
│   ├──  ...
│   ├── out                    
│   ├── out1
│   ├── out2
│   └── ...
├── src/
│   ├── Main.java               # Arquivo principal para execução do projeto
│   ├── ExtractData.java        
│   ├── Plate.java
│   ├── FirstSolution.java      # Implementação da primeira solução
│   ├── SecondSolution.java     # Implementação da segunda solução
│   └── SecondSolutionDraft.java     
└── README.md                   # Instruções e informações do projeto
```

## Dependecias
- Java  17

## Como Rodar

- Colocar os casos de testes na pasta data, iniciando por "in" e enumerando sequencialmente até o último caso de teste desejado;
-     OBS.: Os casos de testes serão lidos em sequência na pasta data até o último arquivo;
- Abrir o terminal na pasta TrabalhoGrauB
- Rodar os seguintes comandos:

### Troca de algoritmo

- Necessário entrar no Main e modificar o algoritmo que está sendo utilizado;
  - Atualmente existem dois algoritmos, o firstSolution (metodologia aleatória) e o secondSolution (metologia força bruta);


```bin
  cd src
  javac *.java
  java Main.java