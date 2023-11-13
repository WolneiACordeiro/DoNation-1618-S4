# DoNation - Plataforma de Economia da Doação

## Descrição

A plataforma web DoNation é dedicada à economia da doação, facilitando a conexão entre doadores e receptores. O objetivo principal é promover a generosidade e solidariedade, permitindo o compartilhamento eficiente e transparente de recursos. Através desta plataforma, as comunidades podem se unir, oferecendo e solicitando ajuda em diversas formas, como tempo, habilidades, alimentos, entre outros.

[![Assista ao Vídeo de Demonstração](https://img.youtube.com/vi/skY7DHPQlss/0.jpg)](https://www.youtube.com/watch?v=skY7DHPQlss)

## Tecnologias Utilizadas

- **Backend:** Desenvolvido em Spring Boot, proporcionando uma base robusta e eficiente para a lógica de negócios da plataforma.
- **Banco de Dados:** Utiliza o Neo4j para armazenar e gerenciar eficientemente as relações entre doadores e receptores, garantindo uma experiência de usuário otimizada.
- **Frontend (Futuro):** Em fase de desenvolvimento, a interface do usuário será construída em ReactJS, proporcionando uma experiência moderna e responsiva.

## Funcionalidades

1. **Registro de Doações:** Doadores podem oferecer recursos, como tempo, habilidades específicas, ou itens, através da plataforma.
2. **Solicitação de Ajuda:** Receptores podem fazer solicitações para suas necessidades específicas, seja assistência em tarefas, alimentos extras, ou outras formas de apoio.
3. **Conexões Eficientes:** A plataforma utiliza algoritmos inteligentes para facilitar a conexão entre doadores e receptores com base em suas ofertas e necessidades.
4. **Transparência:** Toda a atividade na plataforma é registrada de forma transparente, promovendo a confiança entre os usuários.

## Instalação e Execução

1. **Backend:**
   - Clone este repositório.
   - Navegue até o diretório do backend.
   - Execute o projeto Spring Boot.

```bash
cd backend
./mvnw spring-boot:run
```

## Banco de Dados

1. **Instalação do Neo4j:**
   - Certifique-se de ter o Neo4j instalado e em execução em seu ambiente.

2. **Configuração de Credenciais:**
   - No diretório do backend, encontre o arquivo de configuração correspondente.
   - Configure as credenciais do Neo4j para garantir a correta integração com o banco de dados.

```bash
# Exemplo de arquivo de configuração (application.properties)
neo4j.uri=bolt://localhost:7687
neo4j.username=seu_usuario
neo4j.password=sua_senha
