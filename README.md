
<img width="1002" height="254" alt="Capa carrinho x2" src="https://github.com/user-attachments/assets/edd2766e-68bf-46b9-800c-a74aba4dab2c" />


# 🛒 Meu Carrinho

App Android de lista de compras desenvolvido com **Jetpack Compose** e **Kotlin**, construído do zero com arquitetura MVVM e UI totalmente reativa.

---

## 📱 Telas

| Home | Novo Item |
|------|-----------|
| Lista agrupada por categoria com progresso | Formulário com seletor de categoria e quantidade |

---

## ✨ Funcionalidades

- ✅ Lista de compras agrupada por categoria
- ✅ Barra de progresso com texto motivacional dinâmico
- ✅ Adicionar itens com nome, categoria e quantidade
- ✅ Marcar itens como concluídos (com texto tachado)
- ✅ 6 categorias com cores e ícones exclusivos
- ✅ UI totalmente reativa — atualiza em tempo real

---

## 🏗️ Arquitetura

O projeto segue o padrão **MVVM (Model-View-ViewModel)** com fluxo de dados unidirecional:

```
View (Telas Compose)
    ↑ observa via collectAsState()
ViewModel (StateFlow)
    ↑ modela os dados
Model (data classes + enum)
```

### Fluxo de eventos (State Hoisting)

```
Usuário interage
      ↓
  Composable filho   → callback
  Composable pai     → callback
  Tela (Screen)      → callback
  NavGraph           → viewModel.ação()
      ↓
  StateFlow emite novo estado
      ↓
  UI se redesenha automaticamente ✅
```

---

## 🗂️ Estrutura do Projeto

```
com.example.meucarrinho/
├── data/
│   ├── Category.kt          ← enum com label, ícone e cores por categoria
│   └── ShoppingItem.kt      ← data class do item da lista
├── navigation/
│   └── NavGraph.kt          ← rotas type-safe + NavHost
├── ui/
│   ├── screens/
│   │   ├── HomeScreen.kt    ← tela principal com lista e progresso
│   │   └── AddItemScreen.kt ← formulário de novo item
│   └── theme/
│       ├── Color.kt         ← paleta de cores centralizada
│       └── Theme.kt         ← MaterialTheme do app
├── viewmodel/
│   └── ShoppingViewModel.kt ← lógica + StateFlow
└── MainActivity.kt          ← entry point
```

---

## 🛠️ Tecnologias e Conceitos

| Tecnologia | Uso |
|---|---|
| Jetpack Compose | UI declarativa |
| Kotlin | Linguagem principal |
| ViewModel | Gerenciamento de estado |
| StateFlow | Estado reativo |
| Navigation Compose | Navegação entre telas |
| Material Icons Extended | Ícones das categorias |
| Material 3 | Design system |

### Padrões aplicados

- **MVVM** — separação clara entre UI, lógica e dados
- **State Hoisting** — estado elevado, componentes sem estado próprio
- **Unidirectional Data Flow** — dados descem, eventos sobem
- **Sealed Class** — rotas de navegação type-safe
- **Componentização** — UI quebrada em composables reutilizáveis

---

## 🚀 Como rodar

### Pré-requisitos
- Android Studio Hedgehog ou superior
- JDK 17
- Android SDK 26+

### Passos
```bash
# Clone o repositório
git clone https://github.com/seuusuario/meucarrinho.git

# Abra no Android Studio
# File → Open → selecione a pasta do projeto

# Rode o app
# Clique em ▶️ ou use Shift+F10
```

---

## 📦 Dependências

```kotlin
// build.gradle (app)
implementation(platform("androidx.compose:compose-bom:2024.02.00"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.compose.material:material-icons-extended:1.6.1")
implementation("androidx.activity:activity-compose:1.8.2")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
implementation("androidx.navigation:navigation-compose:2.7.6")
```

---

## 📚 Aprendizados

Este projeto foi desenvolvido como exercício prático de aprendizado de **Jetpack Compose e Kotlin para Android**, cobrindo:

1. Configuração de projeto com Compose
2. Design system com cores e ícones por categoria
3. Modelagem de dados com `data class` e `enum`
4. Construção de componentes reutilizáveis (`@Composable`)
5. Estado local com `remember` + `mutableStateOf`
6. Estado global com `ViewModel` + `StateFlow`
7. Navegação com `Navigation Compose` e `sealed class`
8. Padrão State Hoisting em múltiplas camadas
9. UI reativa com `collectAsState()`

---

## 👨‍💻 Autor

Feito com carinho para o aprendizado da turma do Capacita Brasil iRede.
