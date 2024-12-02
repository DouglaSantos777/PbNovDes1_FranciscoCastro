# PbNovDes1_FranciscoCastro

Repositório do projeto **"Pb Springboot - Desafio 1"**, desenvolvido para a trilha de formação **Back-end Journey (Java + SpringBoot) - AWS Cloud Context** do programa de Bolsas da **Compass UOL**.

O desafio consiste na implementação de 3 cenários e um 4º opcional.


## Requisitos do Desafio:
- Versão do Java: 17
- Os cenários 1, 2 e 3 são obrigatórios.
- Utilizar as branches dev e main no repositório git


## Tecnologias utilizadas no Desafio:
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=yellow)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=for-the-badge&logo=intellij-idea&logoColor=white)



## Sumário
- [Cenário 1](#-cenário-1-genealogia)
- [Cenário 2](#-cenário-2-roda-gigante)
- [Cenário-3](#-cenário-3-script-sql)
- [Cenário-4(extra)](#-cenário-4-extra-contador-de-emojis)
- [Instruções para Compilar e Executar (cenário 1, 2 e 3)](#-instruções-para-compilar-e-executar-cenário-1-2-e-3)


## 📍 Cenário 1: Genealogia

### Objetivo

O objetivo deste cenário é imprimir na tela a árvore genealógica de uma pessoa, incluindo seu cônjuge, filhos e seus respectivos cônjuges e filhos. O processo deve ser recursivo, sem limite para a adição de novas pessoas à árvore.

### Requisitos

- **Classe `Person`**: Implementar a classe com os atributos:
    - `name`: 
    - `spouse`:  (cônjuge da pessoa).
    - `children`: Lista de Filhos.

- **Métodos da classe `Person`**:
    - `addChild()`: Adiciona um filho.
    - `addSpouse()`: Adiciona um cônjuge.
    - `printFamilyTree()`: Imprime a árvore genealógica de forma recursiva. Cada pessoa e suas relações de casamento e filhos são exibidas, respeitando a hierarquia das gerações, com uma indentação crescente para refletir as diferentes camadas da árvore.

### Saída
```
Lily -- Married to: Wilhelm -- Children:
  Opa -- Married to: Oma -- Children:
    Reinhold -- Married to: Sonia -- Children:
      Christian -- Married to: Monica -- Children:
        Oscar -- Single
        Lorena -- Single
      Gabrielle -- Single
      Sabine -- Single
    Wilma -- Married to: Rodolfo -- Children:
      Ricardo -- Married to: Debora
      Rodrigo -- Single
    Sigrid -- Married to: Peter -- Children:
      Martin -- Married to: Carla -- Children:
        Nicolas -- Single
      Thomas -- Single
      Claudia -- Single

```


---


## 📍 Cenário 2: Roda Gigante

### Objetivo
No Cenário 2, o desafio é simular o processo de embarque de pessoas em uma roda gigante, com a responsabilidade de distribuir automaticamente as pessoas nas gôndolas disponíveis, de acordo com a capacidade e as regras de embarque.

### Requisitos
- **Regras de Embarque**:
    - Cada gôndola tem uma capacidade máxima definida.
    - Quando uma gôndola atingir sua capacidade, ela será considerada "cheia" e não permitirá mais embarques até que haja uma nova gôndola disponível.
    - Para embarcar crianças, deve haver pelo menos um adulto na mesma gôndola, como exigido pelas regras do desafio.

- **Busca de Gôndola Livre**: 
A classe FerrisWheel contém a lógica de buscar a primeira gôndola disponível que ainda tenha espaço para embarcar mais pessoas. O embarque deve ser feito na ordem em que as pessoas chegam, sem sobrecarregar nenhuma gôndola.



### Estrutura do Código

- **Classe `FerrisWheel`**: Deve gerenciar as gôndolas e os passageiros. A lógica de busca pela próxima gôndola livre deve ser implementada aqui.
- **Classe `Gondola`**: Representa as gôndolas da roda gigante. Cada gôndola deve ter uma capacidade máxima e uma lista de pessoas embarcadas.
- **Classe `Person`**: Representa as pessoas que embarcarão na roda gigante. Cada pessoa pode ser um `Adulto` ou uma `Criança` e as regras de embarque devem ser seguidas, como crianças necessitando estar acompanhadas por um adulto.

---


## 📍 Cenário 3: Script SQL para Roda Gigante

### Objetivo

Neste cenário, o objetivo é criar um script SQL para a criação das tabelas `Gondola` e `Person` do **cenário 2**, com suas respectivas chaves primárias e estrangeiras, e os relacionamentos necessários. O script deve ser capaz de configurar as tabelas para armazenar os dados relativos às gôndolas e às pessoas da roda gigante.

### Requisitos

- Criar um script SQL que contenha apenas as instruções de criação das tabelas `Gondola` e `Person`.

### Descrição do Script
O script SQL abaixo cria duas tabelas essenciais para o sistema de embarque da roda gigante: Person e Gondola.

- **Tabela Person**:
  A tabela Person armazena informações sobre as pessoas, com um relacionamento auto-referenciado para representar o relacionamento de pais e filhos.

  - `id`: Chave primária, identificador único para cada pessoa.
  - `name`: Nome da pessoa.
  - `age`: Idade da pessoa.
  - `parent_id`: Relacionamento com o pai/mãe da pessoa. Este campo faz referência à própria tabela Person para criar um relacionamento de paternidade/maternidade.

- **Tabela Gondola**:
  A tabela Gondola representa as gôndolas da roda gigante, contendo a informação das pessoas que estão embarcadas nas gôndolas.

    - `id`: Chave primária, identificador único para cada gôndola.
    - `gondola_number`:Número único da gôndola (limita a quantidade de gôndolas
    - `seat1` e `seat2`: Referência aos assentos da gôndola, que são preenchidos por pessoas. Essas colunas fazem referência à tabela `Person` para vincular as pessoas aos assentos.

### Script SQL

```sql
-- script para criar SOMENTE as tabelas Person e Gondola

CREATE TABLE Person (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    parent_id INT DEFAULT NULL,
    CONSTRAINT fk_parent FOREIGN KEY (parent_id) REFERENCES Person(id) ON DELETE SET NULL
);

CREATE TABLE Gondola (
    id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    gondola_number TINYINT UNSIGNED NOT NULL UNIQUE,
    seat1 INT DEFAULT NULL,
    seat2 INT DEFAULT NULL,
    CONSTRAINT fk_seat1 FOREIGN KEY (seat1) REFERENCES Person(id),
    CONSTRAINT fk_seat2 FOREIGN KEY (seat2) REFERENCES Person(id)
);
```

## 📍 Cenário 4 (Extra): Contador de Emojis

## Objetivos

O objetivo deste cenário é desenvolver um programa que analisa uma mensagem de texto e determina o sentimento expresso nela com base no número de emojis presentes. O programa irá identificar e contar os seguintes emojis:

- **Emojis divertidos**: `:-)` (representando um sentimento divertido)
- **Emojis chateados**: `:-(` (representando um sentimento chateado)

O sentimento será determinado da seguinte forma:
- **Neutro**: Se o número de emojis "divertido" for igual ao número de emojis "chateado".
- **Divertido**: Se o número de emojis "divertido" for maior que o número de emojis "chateado".
- **Chateado**: Se o número de emojis "chateado" for maior que o número de emojis "divertido".

## Requisitos

- O programa deve ser desenvolvido em Java.
- Deve usar a classe `Scanner` para ler a entrada de uma mensagem.
- O programa deve identificar os emojis `:-)` e `:-(` dentro de uma mensagem.
- Com base na contagem desses emojis, o programa deve determinar e imprimir se o sentimento da mensagem é:
    - **"divertido"**: Se o número de emojis `:-)` for maior.
    - **"chateado"**: Se o número de emojis `:-(` for maior.
    - **"neutro"**: Se ambos os emojis aparecerem o mesmo número de vezes.
- O programa deve lidar com a entrada de uma linha de texto e retornar a resposta de acordo com a contagem dos emojis.

## Detalhes do Código

O código é dividido em duas classes principais:

1. **Classe `EmojiCheck`**:
    - **Atributos**:
        - `funnyEmojis`: Conta os emojis "divertido" `:-)`.
        - `upsetEmojis`: Conta os emojis "chateado" `:-(`.
    - **Métodos**:
        - `countEmojis(String input)`: Percorre a mensagem e conta quantos emojis "divertido" e "chateado" estão presentes.
        - `returnFeeling(String input)`: Chama o método `countEmojis` para determinar o sentimento baseado na comparação entre os emojis "divertidos" e "chateados", retornando "funny", "upset" ou "neutral".

2. **Classe `Main`**:
    - O método `main` usa a classe `Scanner` para ler a mensagem inserida pelo usuário.
    - A mensagem é passada para o método `returnFeeling` da classe `EmojiCheck`, e o resultado (sentimento) é impresso.

**Fluxo do Programa**:
1. O usuário insere uma mensagem de texto.
2. A classe `EmojiCheck` conta os emojis "divertido" e "chateado".
3. O método `returnFeeling` determina o sentimento com base nos emojis contados e imprime o resultado.

---

## 📄 Instruções para Compilar e Executar (cenário 1, 2 e 3)


### 1. Executando no IntelliJ IDEA

1. Entre no diretorio src.main.java.com.challenge, haverá lá 4 diretórios: 
- scenario1
- scenario2
- scenario3 (o 3º é apenas um Script SQl)
- scenario4

2. Clique com o botão direito do mouse no arquivo `Main.java` no painel de navegação ou abra-o e execute.
3. Selecione a opção para dar **Run** na main do cenário desejado.

### 2. Executando no Eclipse

1. Clique com o botão direito do mouse no arquivo `Main.java` de algum dos cenários.
2. Selecione **Run As > Java Application**.

### 3. Executando no Visual Studio Code (VS Code)

1. Certifique-se de que a extensão **Java Extension Pack** esteja instalada.
2. Abra o arquivo `Main.java` de algum dos cenários.
3. Clique no ícone de **Run** (um triângulo verde) no canto superior direito ou use o atalho `Ctrl + F5` para executar.

