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


