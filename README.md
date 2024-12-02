# PbNovDes1_FranciscoCastro

Repositório do projeto **"Pb Springboot - Desafio 1"**, desenvolvido para o programa de Bolsas da Compass UOL.

O desafio consiste na implementação de 3 cenários, com um adicional (extra).

## 📍 Cenário 1: Genealogia

### Propósito

O objetivo deste cenário é imprimir na tela a árvore genealégica de uma pessoa, incluindo cônjuge, filhos e seus respectivos cônjuges e filhos, de forma recursiva e sem limite para a adição de novas pessoas.

### Requisitos

- **Classe `Person`**: Implementar a classe com os atributos `name`, `spouse` e `children`.
- **Métodos da classe `Person`**:
    - `addChild(Person child)`: Adiciona um filho.
    - `addSpouse(Person spouse)`: Adiciona um cônjuge.
    - `printFamilyTree(int spacing)`: Imprime a árvore genealética na tela, mantendo a hierarquia de parentesco.

---

## 🛠️ Instruções para Compilar e Executar

### 1. Linha de Comando

Para compilar e executar o projeto diretamente pelo terminal, siga os passos abaixo:

1. **Compilar os arquivos Java**:

   ```
   javac scenario1/src/main/java/com/challenge/models/Person.java scenario1/src/main/java/com/challenge/Main.java
   ```

2. **Executar o programa**:

   ```
   java -cp scenario1/src/main/java com.challenge.Main
   ```

### 2. Executando no IntelliJ IDEA

1. Clique com o botão direito do mouse no arquivo `Main.java` no painel de navegação.
2. Selecione a opção **Run 'Main.main()'**.

### 3. Executando no Eclipse

1. Clique com o botão direito do mouse no arquivo `Main.java`.
2. Selecione **Run As > Java Application**.

### 4. Executando no Visual Studio Code (VS Code)

1. Certifique-se de que a extensão **Java Extension Pack** esteja instalada.
2. Abra o arquivo `Main.java`.
3. Clique no ícone de **Run** (um triângulo verde) no canto superior direito ou use o atalho `Ctrl + F5` para executar.

### 5. Script Bash para Compilar e Executar

Para automatizar a compilação e execução do projeto, crie um arquivo `run.sh` com o seguinte conteúdo:

```
#!/bin/bash
javac scenario1/src/main/java/com/challenge/models/Person.java scenario1/src/main/java/com/challenge/Main.java
java -cp scenario1/src/main/java com.challenge.Main
```

Torne o script executável com o comando:

```
chmod +x run.sh
```

E execute-o com:

```
./run.sh
```

---


## 📍 Cenário 2: Roda Gigante

### Propósito

Neste cenário, há a operação de uma roda gigante, com suas gôndolas e pessoas embarcando nela. A classe principal já foi fornecida, juntamente com o diagrama de classes. O objetivo é completar os métodos, atributos e classes ausentes para que a classe principal funcione corretamente e retorne o resultado esperado.

A aplicação deve simular o processo de embarque de pessoas nas gôndolas, garantindo que cada pessoa ou grupo de pessoas seja embarcado corretamente nas gôndolas, de acordo com a disponibilidade.

### Requisitos

- Criar um projeto Java com a classe principal fornecida.
- Implementar a lógica para a classe principal funcionar corretamente, com os métodos necessários para operar a roda gigante.
- A classe **FerrisWheel** deve ser capaz de procurar a próxima gôndola livre automaticamente. Nenhuma lógica complexa é necessária, mas a gôndola deve ser atribuída de maneira inteligente à próxima disponível.
- Não é necessário usar banco de dados, todos os dados devem ser mantidos na memória.

### Estrutura do Código

- **Classe `FerrisWheel`**: Deve gerenciar as gôndolas e os passageiros. A lógica de busca pela próxima gôndola livre deve ser implementada aqui.
- **Classe `Gondola`**: Representa as gôndolas da roda gigante. Cada gôndola deve ter uma capacidade máxima e uma lista de pessoas embarcadas.
- **Classe `Person`**: Representa as pessoas que embarcarão na roda gigante. Cada pessoa pode ser um **Adulto** ou uma **Criança** e as regras de embarque devem ser seguidas, como crianças necessitando estar acompanhadas por um adulto.

---

## 🛠️ Instruções para Compilar e Executar o Cenário 2

### 1. Executando no IntelliJ IDEA

1. No painel de navegação do IntelliJ, clique com o botão direito no arquivo `Main.java` dentro de `scenario2/src/main/java/com/challenge`.
2. Selecione a opção **Run 'Main.main()'**.

---

### 2. Executando no Eclipse

---

1. Clique com o botão direito no arquivo `Main.java` localizado em `scenario2/src/main/java/com/challenge`.
2. Selecione **Run As > Java Application**.

---

### 3. Executando no Visual Studio Code (VS Code)

1. Certifique-se de que a extensão **Java Extension Pack** esteja instalada no VS Code.
2. Abra o arquivo `Main.java` localizado em `scenario2/src/main/java/com/challenge`.
3. Clique no ícone de **Run** (um triângulo verde) no canto superior direito ou use o atalho `Ctrl + F5` para executar.

---

## 📍 Cenário 3: Script SQL

### Propósito

Neste cenário, o objetivo é criar um script SQL para a criação das tabelas `Gondola` e `Person`, com suas respectivas chaves primárias e estrangeiras, e os relacionamentos necessários. O script deve ser capaz de configurar as tabelas para armazenar os dados relativos às gôndolas e às pessoas da roda gigante.

### Requisitos

- Criar um script SQL que contenha apenas as instruções de criação das tabelas `Gondola` e `Person`.

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

