# 🏪 Sistema de Gerenciamento de Produtos - Casas Bahia

Este projeto é um sistema de gerenciamento de produtos desenvolvido em Java, simulando um catálogo de produtos de uma loja do tipo Casas Bahia. O sistema permite gerenciar dois tipos de produtos: **Eletrodomésticos** e **Móveis**.


## 📋 Funcionalidades

- ✅ **Adicionar produtos** (Eletrodomésticos ou Móveis)
- ✅ **Listar todos os produtos** cadastrados
- ✅ **Buscar produtos** por código
- ✅ **Remover produtos** do catálogo
- ✅ **Validações** robustas com tratamento de exceções personalizadas
- ✅ **Interface de console** interativa


## 🏗️ Estrutura do Projeto


### 📦 Pacotes
- **`casasBahia`**: Classes principais do sistema
- **`excecoes`**: Classes de exceções personalizadas


### 🧩 Principais Classes

#### Classes de Domínio
- **`Produto`**: Classe abstrata base para todos os produtos
- **`Eletrodomestico`**: Representa produtos eletrodomésticos
- **`Movel`**: Representa produtos móveis
- **`CategoriaEletro`**: Enum para categorias de eletrodomésticos

#### Classes de Exceção
- **`CodigoInvalidoException`**: Exceção para códigos inválidos
- **`PrecoInvalidoException`**: Exceção para preços inválidos
- **`OpcaoInvalidaException`**: Exceção para opções inválidas no menu
- **`ErroSaidaException`**: Exceção para erros durante a finalização do sistema

#### Classes do Sistema
- **`Sistema`**: Classe principal que gerencia a lógica do programa
- **`Main`**: Classe de entrada do programa com menu interativo


## 📝 Como Usar

1. **Adicionar Produto**: Escolha a opção 1 no menu e siga as instruções
   - Forneça nome, código (3 caracteres), preço e tipo do produto
   - Para eletrodomésticos: escolha categoria e voltagem
   - Para móveis: informe material e categoria

2. **Listar Produtos**: Opção 2 mostra todos os produtos cadastrados

3. **Buscar Produto**: Opção 3 permite buscar por código

4. **Remover Produto**: Opção 4 remove um produto pelo código

5. **Sair**: Opção 5 finaliza o sistema


## ⚠️ Validações Implementadas

- Código do produto deve ter exatamente 3 caracteres
- Preço deve ser maior que zero
- Opções do menu devem ser válidas
- Tratamento de entradas inválidas do usuário


## 🛠️ Tecnologias Utilizadas

- **Java** - Linguagem de programação
- **POO** - Programação Orientada a Objetos
- **Tratamento de Exceções** - Exceções personalizadas
- **Collections** - ArrayList para armazenamento de produtos


## 📊 Estrutura de Dados

O sistema utiliza um `ArrayList<Produto>` para armazenar todos os produtos cadastrados, permitindo operações eficientes de adição, remoção e busca.




---

*Este projeto foi desenvolvido para fins educacionais, simulando um sistema de gerenciamento de produtos inspirado no varejo.*
