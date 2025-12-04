# 🏥 Healthcare Solutions – API de Pacientes y Registros Médicos
API REST desarrollada con **Spring Boot**, **Redis** y **Autenticación con Google OAuth**, que permite gestionar pacientes y sus registros médicos de forma eficiente y rápida utilizando almacenamiento en memoria.

---

## 🚀 Tecnologías utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Security + Google OAuth 2**
- **Redis (Docker)**
- **Lombok**
- **Maven**

---

## 📌 Arquitectura
La API maneja dos entidades principales:

### 🧑‍⚕️ Paciente
- `id_paciente`
- `nombre_paciente`
- `apellido_paciente`
- `dni`

### 📘 Registro Médico
- `id_registro`
- `id_paciente` (relación 1:N)
- `diagnostico`
- `tratamiento`
- `medicacion`

Cada paciente puede tener múltiples registros médicos.

Los datos se guardan en Redis utilizando hashes:

- `PACIENTES` → tabla hash para Pacientes
- `REGISTROS` → tabla hash para Registros Médicos

---

## 🗄️ Cómo correr Redis con Docker

```bash
docker pull redis
docker run -d --name redis -p 6379:6379 redis

---

# **Endpoints principales**

🧑‍⚕️ Pacientes
➤ Crear paciente

POST /pacientes

Body

{
  "id_paciente": 1,
  "nombre_paciente": "Juan",
  "apellido_paciente": "Perez",
  "dni": "123456"
}

➤ Obtener todos

GET /pacientes

➤ Buscar por ID

GET /pacientes/{id}
