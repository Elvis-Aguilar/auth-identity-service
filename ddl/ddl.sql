-- Extensiones necesarias
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE SCHEMA auth;
CREATE SCHEMA identity;

-- IDENTITY
CREATE TABLE identity.customer (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    full_name VARCHAR(150) NOT NULL,
    cui VARCHAR(30) UNIQUE NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(250) NOT NULL,
    loyalty_points INTEGER DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE identity.employee (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    full_name VARCHAR(150) NOT NULL,
    cui VARCHAR(30) UNIQUE NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100) UNIQUE NOT NULL,
    job_position VARCHAR(50),
    salary NUMERIC(10,2) NOT NULL,
    address VARCHAR(250) NOT NULL,
    hotel_id UUID,
    restaurant_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

-- AUTH
CREATE TABLE auth.role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE auth.user (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    password TEXT NOT NULL,
    email VARCHAR(100),
    employee_id UUID,
    customer_id UUID,
    role_id BIGINT NOT NULL,
    active BOOLEAN DEFAULT false,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    CONSTRAINT fk_users_role FOREIGN KEY (role_id) REFERENCES auth.role(id),
    CONSTRAINT fk_user_employee FOREIGN KEY (employee_id) REFERENCES identity.employee(id),
    CONSTRAINT fk_user_customer FOREIGN KEY (customer_id) REFERENCES identity.customer(id)
);



