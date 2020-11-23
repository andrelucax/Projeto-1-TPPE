# Trabalho Prático 1 - Desenvolvimento Orientado a Testes (TDD)
Desenvolvimento de parser de resultados de análises de confiabilidade.

|Matrícula | Estudante |
| -- | -- |
| 17/0068251 | André Lucas de Sousa Pinto |
| 17/0038891 | Leonardo de Araujo Medeiros |
| 17/0039251 | Lieverton Santos Silva |
| 17/0024121 | Welison Lucas Almeida Regis |

# Notas ao professor

- O trabalho foi realizado em reuniões via teams
- Todos os integrantes participaram ativamente de todas as reuniões
- O piloto da reunião era alternado a cada reunião

# Ferramenta utilizada

- O programa foi feito feito em Java com a JDK 11
- Utilizamos a IDE do Eclipse (2020/6 - 4.16.0)
- Os testes foram feitos utilizando o JUnit 4

# Enunciado

## 1. O Parser

O programa a ser desenvolvido consiste em um parser de arquivos-texto contendo valores de tempos de análise e de execução de uma ferramenta que avalia a confiabilidade de programas de software. Para cada “versão” do software avaliada (também chamada de evolução) é realizada uma quantidade de análises de confiabilidade e, para cada iteração, são anotados os tempo de análise e o tempo total de execução da ferramenta. Por exemplo, um software com 20 evoluções analisadas 10 vezes resultará em um total de 200 avaliações realizadas, cada avaliação com seus tempos anotados.
Esses valores estão hoje armazenados em dois arquivos-texto: __analysisTime.out__ e __totalTime.out.__ Estruturalmente não há diferenças entre os arquivos sendo o primeiro arquivo o registro de tempo de avaliação de cada versão e o segundo arquivo o tempo total de execução da ferramenta de análise. Cada evolução está destacada através de uma “String” no arquivo, seguida pelos valores de tempo anotados em milisegundos (a quantidade de valores denota o número de iterações realizadas para aquela evolução). Em seguida está apresentado um pequeno pedaço de um desses arquivos.

```text
---------- Evolution 1 ----------
439
705
738
729
752
740
658
713
765
710
---------- Evolution 2 ----------
470
828
760
668
884
721
720
802
777
735
---------- Evolution 3 ----------
446
789
763
692
910
966
751
1002
720
752
```

É comum que os valores registrados nesses arquivos cresça significativamente tanto em número de evoluções quanto em número de iterações (análises) realizadas. Quando isso acontece, a análise desses tempos torna-se mais difícil, principalmente para realizar análises visuais e estatísticas dos dados. Atualmente é feita uma série de transformações nesses arquivos como pré-processamento para a fase de análise. Essas transformações são feitas em *scripts bash* e estão muito sensíveis a pequenas variações nas estruturas desses arquivos.
Portanto deseja-se implementar uma ferramenta que seja capaz de ler esses valores dispostos equencialmente nos arquivos __analysisTime.out__ e __totalTime.out__ e persisti-los em arquivos texto com campos separados por valor. Muito parecido com arquivos CSV (em que campos são separados por vírgulas, do inglês *comma-separated values*), esses arquivos terão seus valores separados por caractere(s) definidos pelo usuário. A depender da quantidade de valores dos arquivos o usuário escolherá se as sequências de valores serão dispostas em linhas ou em colunas. Considerando o trecho de arquivo apresentado anteriormente, se a opção do usuário for apresentar as sequencias em __linhas__ e ‘;’ como delimitador de campos, o arquivo texto resultante será o seguinte:

```text
1;456;782;755;729;761;751;869;823;847;730
2;523;861;770;783;720;813;750;726;770;771
3;458;973;753;758;783;749;794;769
```

No caso em que o usuário escolher apresentar as sequências em __colunas__ e ‘;’ como caractere separador de campos, o arquivo texto resultante será o seguinte:

```text
1;2;3
456;523;458
782;861;973
755;770;753
729;783;758
761;720;783
751;813;749
869;750;794
823;726;769
847;770
730;771
```

Notem que não há a necessidade que todas as evoluções tenham o mesmo número de iterações. No exemplo acima, a evolução três tem dois valores a menos que as evoluções um e dois.

## 2. O aplicativo

O aplicativo a ser desenvolvido como tema desse trabalho consiste em uma ferramenta para realizar a pré-análise dos dados dos arquivos __analysisTime.out__ e __totalTime.out__. O aplicativo deverá apresentar as seguintes funcionalidades:

- Definições das configurações das pré-análises:
  - Leitura do arquivo de entrada (__analysisTime.out__ ou __totalTime.out__)
    - Se o arquivo não existir no diretório, uma exceção do tipo __ArquivoNaoEncontradoException__, informando o nome do arquivo, deverá ser lançada e capturada pelo programa.
  - Definição do delimitador de campo a ser utilizado no arquivo de saída. Considere o delimitador como sendo um caractere apenas.
    - Se o delimitador informado for uma “string”, uma exceção __DelimitadorInvalidoException__ informando o erro deverá ser lançada e capturada pelo programa. Atenção: caracteres com o escape ‘\’ são considerados um caractere apenas. Exemplos: \r, \n, \t .
  - Definição do caminho do arquivo de saída.
    - Caso não haja permissão de escrita no caminho de saída, uma exceção do tipo __EscritaNãoPermitidaException__ deverá ser lançada e capturada pela aplicação.
  - Definição do formato de saída das sequencias de valores.
    - O usuário deverá ser capaz de indicar se quer que as sequencias de tempos para cada evolução seja apresentada em linhas ou em colunas, conforme exemplos apresentados anteriormente.
  - Parser dos valores dos arquivos:
    - A aplicação deverá ser capaz de identificar automaticamente, i.e. __sem intervenção do usuário__, quantas evoluções foram analisadas e quantas análises foram feitas para cada evolução.
  - Escrever arquivo resposta:
    - Após o parser dos arquivos de entrada o aplicativo deverá ser capaz de transformar para a forma de saída indicada pelo usuário e escrevê-la em arquivo texto com os seguintes nomes __analysisTimeTab.out__ no caso do arquivo de entrada ser o arquivo analysisTime.out ou __totalTimeTab.out__ no caso do arquivo de entrada ser totalTime.out.

A ferramenta deverá ser implementada utilizando a técnica de __Desenvolvimento Orientado a Testes (TDD)__, em linguagem Java, utilizando o framework JUnit 4 ou superior. A implementação utilizando TDD deverá ser evidenciada através do histórico de *commits* do projeto. Recomenda-se que cada uma das uncionalidades apresentadas acima seja desenvolvida em sua própria *branch*, cujos *commits* apresentarão as técnicas de TDD que foram utilizadas (falsificação, duplicação, triangulação). Ao final da implementação de cada
funcionalidade, sua respectiva branch será fundida (*merge*) na branch __Dev__.
O trabalho deverá ser realizado em grupos de até três componentes. Os nomes e matrículas dos componentes deverão ser apresentados no arquivo README.md do repositório. A avaliação da participação dos membros no trabalho será realizada pela análise de autoria dos commits.
Cada grupo deverá enviar email para o professor indicando o nome dos componentes do grupo e o endereço do repositório Github do trabalho.

__Valor do trabalho: 40% da nota final.__

__Data de entrega: 25 de novembro de 2020.__

__Forma de entrega: via repositório Github.__
