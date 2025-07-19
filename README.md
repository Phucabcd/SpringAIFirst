# 🤖 Spring AI Chatbox Project

Welcome to my experimental **Spring AI** project! 🚀  
This application showcases how to build an AI-powered chatbox using the **Spring AI framework**, enhanced with **image generation**, **chat memory**, and **conversation history** stored in a database.

---

## 📌 Features

- 🧠 **Chatbot** using OpenAI/Gemini via Spring AI
- 🖼️ **Image generation** via prompt input (text-to-image)
- 💬 **Chat memory**: Chatmemory of Spring AI
- 🗂️ **Conversation history**: stored in PostgreSQL for later access
- 📄 **Prompt customization** using `PromptTemplate`
- 🧩 Modular agent-based structure (planned)

---

## ⚙️ Tech Stack

| Layer        | Technology                |
|--------------|----------------------------|
| Backend      | Java 17+, Spring Boot      |
| AI Layer     | Spring AI, OpenAI/Gemini   |
| Frontend     | HTML,Css,JS, with claude   |
| Database     | PostgreSQL                 |
| Memory Store | VectorStore / In-memory    |
| Build Tool   | Maven                      |

---

## 🔧 Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL (or use in-memory H2 for quick testing)
- OpenAI API key or Gemini API key

### Run Locally

```bash
# Clone the project
git clone https://github.com/your-username/spring-ai-chatbox.git
cd spring-ai-chatbox

# Configure .env or application.yaml
# (Set your API keys and DB connection)

# Run the app
mvn spring-boot:run
