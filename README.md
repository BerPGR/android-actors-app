# Actors App

Um projeto Android desenvolvido em Kotlin, usando Jetpack Compose para a interface de usuário e arquitetura MVVM para uma separação limpa de responsabilidades. O projeto utiliza Retrofit para fazer chamadas de rede e Moshi para conversão de JSON.

## Visão Geral

Este projeto demonstra uma aplicação Android modular com uma arquitetura robusta, que permite escalabilidade e manutenibilidade. A aplicação implementa a arquitetura MVVM (Model-View-ViewModel), onde:
- **Model** é responsável pela lógica de negócios e dados,
- **ViewModel** faz a conexão entre os dados e a interface do usuário,
- **View** exibe as informações.

## Tecnologias e Ferramentas Utilizadas

- **Kotlin**: Linguagem de programação principal do projeto.
- **Jetpack Compose**: Framework moderno para construção de interfaces de usuário declarativas.
- **MVVM (Model-View-ViewModel)**: Arquitetura utilizada para separar as responsabilidades e melhorar a manutenibilidade do código.
- **Retrofit**: Biblioteca para fazer requisições HTTP de forma simples e estruturada.
- **Moshi**: Biblioteca para serialização e desserialização de JSON em objetos Kotlin.
- **ViewModel**: Parte do Jetpack, que facilita o gerenciamento de dados da interface de usuário.
