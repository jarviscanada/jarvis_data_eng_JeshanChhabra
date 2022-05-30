
# Creating table(host_usage) and checking if already exists

CREATE TABLE IF NOT EXISTS PUBLIC.host_usage(
  "timestamp"  TIMESTAMP NOT NULL,
   host_id  SERIAL  references host_info(id),
   memory_free INTEGER NOT NULL,
   cpu_idle    INTEGER NOT NULL,  
   cpu_kernel  INTEGER NOT NULL,
   dis_io      INTEGER NOT NULL, 
   disk_available INTEGER NOT NULL
  );

# Creating table host_info and checking if its already created 
CREATE TABLE IF NOT EXISTS PUBLIC.host_info(
  id  SERIAL PRIMARY KEY NOT NULL,
  hostname VARCHAR NOT NULL UNIQUE,
  cpu_number INTEGER NOT NULL,
  cpu_architecture VARCHAR NOT NULL,
  cpu_model  VARCHAR NOT NULL,
  cpu_mhz    DECIMAL NOT NULL,
  l2_cache   INTEGER NOT NULL,
  total_mem  INTEGER NOT NULL,
  "timestamp"  TIMESTAMP NOT NULL);
