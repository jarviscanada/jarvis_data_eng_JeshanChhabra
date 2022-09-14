!# /bin/sh
# Getting arguments from the cli
cmd=$1
db_username=$2
db_password=$3
 
#Starting the docker server with super user privilages

sudo systemctl status docker || sudo systemctl start docker

docker container inspect jrvs-psql 
container_status=$?

# using case statement ot create start or stop the instance

case $cmd in 
    create)

    if [[ $container_status -eq 0 ]]
      then echo 'Container already exists'
      exit 1
    fi

    if [[ $# -ne 3 ]]
      then echo 'Create requires username and password'
      exit 1
    fi
# Creating container
   docker volume create pgdata
#   export PGUSERNAME=`hostname`
#   export PGPASSWORD='password'
   docker run --name jrvs-psql -e POSTGRES_PASSWORD=$db_password -e POSTGRES_USER=$db_username -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine 
exit $?
;;

start|stop)
   if [[ $container_status -ne 0 ]]
    then echo Container has not been created
    exit 1
   fi
   
  #starting the instance
  docker container $cmd jrvs-psql
  exit $?
;;
*)
  echo 'Illegal command'
  echo 'Commands: start|stop|Create'
  exit 1
;;
esac
 
 
