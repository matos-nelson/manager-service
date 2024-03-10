CREATE TABLE IF NOT EXISTS manager (
  id bigint PRIMARY KEY,
  address_id bigint NOT NULL,
  business_name varchar(150) NOT NULL,
  user_id varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  phone varchar(10) NOT NULL,
  created_at timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT user_id_idx UNIQUE (user_id),
  CONSTRAINT email_idx UNIQUE (email)
);

CREATE INDEX address_id_idx ON manager (address_id);