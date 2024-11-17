# Trabalho de Grau B - Analisando jogos de civilizações antigas

Abraão M. Duarte e Giovani S. Fetzner

## Estrutura do Projeto

```bin
TrabalhoGrauB/
├── data/
│   ├── in                     # Casos de Teste
│   ├── in1
│   ├── in2
│   └── ...
│   ├── out                    
│   ├── out1
│   ├── out2
│   └── ...
├── src/
│   ├── Main.java               # Arquivo principal para execução do projeto
│   ├── PrimeiraSolucao.java    # Implementação da primeira solução
│   └── SegundaSolucao.java     # Implementação da segunda solução
└── README.md                   # Instruções e informações do projeto
```

## Dependecias
- Java  17

## Como Rodar

- Colocar os casos de testes na pasta data, iniciando por "in" e enumerando sequencialmente até o último caso de teste desejado;
-     OBS.: Os casos de testes serão lidos em sequência na pasta data até o último arquivo;
- Abrir o terminal na pasta TrabalhoGrauB
- Rodar os seguintes comandos:

```bin
  cd src
  javac *.java
  java Main.java