!# /bin/sh

#defining cli arguments below

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

# if statement to check if the arguments entered and exit if not

if [[ $# -ne 5 ]]
   then echo Enter all the required arguments
   exit 1
fi

# creating variable for specs
specs=`lscpu`


# Getting hardware details by using bash cmds

hostname=`hostname -f`
cpu_number=$(echo "$specs" | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
cpu_architecture=$(echo "$specs" | grep "Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$specs" | grep "Model:" | awk '{print $2}' | xargs)
cpu_mhz=$(echo "$specs" | grep "CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$specs" | grep "L2 cache:" | awk '{print $3}' | tr -d K| xargs)
total_mem=$(vmstat -s --unit M | grep "total memory" | awk '{print $1}')
timestamp=$(vmstat -t | awk '{print $18,$19}' | tail -n1 | xargs)

# Insert statement to inset values in the table
insert_stmt="INSERT INTO host_info(hostname,cpu_number,cpu_architecture,cpu_model,cpu_mhz,L2_cache,total_mem,timestamp) VALUES('$hostname','$cpu_number','$cpu_architecture','$cpu_model','$cpu_mhz','$l2_cache','$total_mem','$timestamp')"

#setting env variable for password

export PGPASSWORD=$psql_password

#inserting data into the host_info table

psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"

exit $?




