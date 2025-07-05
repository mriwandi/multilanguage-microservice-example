# 🧪 99 Backend Tech Challenge

This project showcases a microservices-based backend system using:

- 🧑‍💻 `user-service` (Java Spring Boot + SQLite)
- 🏠 `listing-service` (Python Tornado)
- 🌐 `public-api` (Java Spring Boot gateway between clients and internal services)

All services are containerized using **Docker** and orchestrated with **Docker Compose**.

---

## 📌 Prerequisites

Ensure the following are installed on your machine:

- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/install/)

Verify installation:

```bash
docker -v
docker compose version
```

---

## 🚀 Quick Start

Clone the repository and navigate into the project directory:

```bash
git clone https://github.com/mriwandi/99-backend-challenge.git
cd 99-backend-challenge
```

Run all services using Docker Compose:

```bash
docker compose up --build
```

The following ports will be exposed:

| Service         | Port  |
|-----------------|--------|
| user-service    | 8080   |
| listing-service | 6000   |
| public-api      | 8888   |

---

## 📁 Project Structure

```
.
├── docker-compose.yml
├── user-service/       # Java Spring Boot + SQLite
├── listing-service/    # Python Tornado service
├── public-api/         # Java Spring Boot public-facing gateway
```

---

## 🌐 API Endpoints

### 🔐 Public API (`http://localhost:8888/public-api`)

#### 1. Create User

**POST** `/public-api/users`  
**Content-Type:** `application/json`

```json
{
  "name": "Lorel Ipsum"
}
```

#### 2. Create Listing

**POST** `/public-api/listings`  
**Content-Type:** `application/json`

```json
{
  "user_id": 1,
  "listing_type": "rent",
  "price": 6000
}
```

#### 3. Get All Listings

**GET** `/public-api/listings?page_num=1&page_size=10`

Optional: add `&user_id=1` to filter by user

### Stop all services:

```bash
docker compose down
```

---

## ⚙️ Notes

- All data is stored in Docker volumes, including `/data/users.db` for SQLite.
- All services communicate strictly via REST APIs.
- No additional setup is required to run this project on any machine with Docker installed.

---

## 🙌 Author

Built with ❤️ by Muhammad Riwandi
