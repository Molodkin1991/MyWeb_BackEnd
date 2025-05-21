

-- 1. Создаем перечисление ролей
CREATE TYPE role_type AS ENUM ('ADMIN', 'USER');

-- 2. Таблица пользователей
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(100) NOT NULL UNIQUE,
                       name VARCHAR(100) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role role_type NOT NULL,
                       created_at TIMESTAMP DEFAULT NOW(),
                       updated_at TIMESTAMP DEFAULT NOW()
);

-- Индексы для быстрого поиска
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_role ON users(role);

-- 3. Таблица постов
CREATE TABLE posts (
                       id SERIAL PRIMARY KEY,
                       content TEXT NOT NULL,
                       owner_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
                       comments TEXT[] DEFAULT ARRAY[]::TEXT[],
                       created_at TIMESTAMP DEFAULT NOW(),
                       updated_at TIMESTAMP DEFAULT NOW()
);

-- Индекс для поиска постов по владельцу
CREATE INDEX idx_posts_owner_id ON posts(owner_id);
