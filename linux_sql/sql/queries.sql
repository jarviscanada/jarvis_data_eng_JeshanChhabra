
/*# First query => Group hosts by CPU number and sort by their memory size in desc#ending order(within each cpu_number group)
*/

SELECT cpu_number,host_id, total_mem 
FROM host_info 
Group by cpu_number,host_id,total_mem 
order by host_id asc, total_mem desc;

/*
Function is created to calculate rounded time for timestamp
*/

CREATE FUNCTION round5(ts timestamp) RETURNS timestamp AS
$$
BEGIN
    RETURN date_trunc('hour', ts) + date_part('minute', ts):: int / 5 * interval '5 min';
END;
$$
    LANGUAGE PLPGSQL;


/*
2nd... Getting average percentages of the usage with required stats
*/

SELECT host_id,hostname, round5(hu.timestamp) as time,ROUND((AVG(total_mem-memory_free)/SUM(total_mem-memory_free))*100) as "avg_used_mem_percentage" 
FROM host_usage hu 
inner join host_info hi on hu.host_id=hi.id
GROUP BY host_id, time,hostname
order by host_id asc,time asc;




/*
 3rd  Detecting host_failure where num_of_data points i sless than 3 
*/


SELECT host_id, round5(timestamp) as ts, count(*) as num_data_points  
FROM host_usage 
GROUP BY ts,host_id 
HAVING count(*)< 3
ORDER BY host_id asc ,ts;

