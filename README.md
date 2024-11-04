# AdOptimize

# Integrantes: 
- JAISY CIBELE ALVES - JAVA ADVANCED
- GABRIEL AMÂNCIO PEREIRA - MASTERING RELATIONAL AND NON-RELATIONAL DATABASE 
- LUIZ FELIPE CAMARGO PRENDIN - DEVOPS TOOLS & CLOUD COMPUTING
- TOMAZ DE OLIVEIRA PECORARO - DISRUPTIVE ARCHITECTURES: IOT, IOB & GENERATIVE IA, ADVANCED BUSINESS DEVELOPMENT WITH .NET  
- RENNAN FERREIRA DA CRUZ - MOBILE APPLICATION DEVELOPMENT, COMPLIANCE, QUALITY ASSURANCE & TESTS

## Diagramas: 

![Diagrama de Classes](https://github.com/jaisycibele/AdOptimize/assets/117952554/e45c028d-e95f-472e-ba97-c4eadfd53b10)
![Diagrama Entidade-Relacionamento](https://github.com/jaisycibele/AdOptimize/assets/117952554/89929a04-e9cb-4acd-849d-ba4bcadfa63a)

## Link para o vídeo mostrando a aplicação

https://youtu.be/rZ0nhocs8ZQ?si=Kw6MoIUtsllKLQXv

## Como rodar a aplicação:
- Ao clonar o projeto, ir em "Project Structure" > SDK = graalvm-ce > Language level = SDK default
- Ir em Settings > build tools > Gradle > Gradle JVM = graalvm-ce

## Spring Security

Para fazer as requisições, o usuário deve estar autenticado.

POST http://localhost:8080/auth/login
POST http://localhost:8080/auth/register

Exemplos requisição:

Register
{
    "login" : "jaisy",
    "senha" : "123456710",
    "role" : "ADMIN"
}

{
    "login" : "joao",
    "senha" : "12345678",
    "role" : "USER"
}

O "USER" possui limitações.

## SPRING AI

# Requisição para teste:

GET http://localhost:8080/springai/generate

{
  "ollama": "Que dia é hoje?"
}

## URL:

Usuário:
http://localhost:8080/usuario/template


