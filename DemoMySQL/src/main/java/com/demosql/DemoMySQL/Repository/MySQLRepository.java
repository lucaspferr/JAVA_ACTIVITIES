package com.demosql.DemoMySQL.Repository;
import org.springframework.data.repository.CrudRepository;

import com.demosql.DemoMySQL.Service.DemoMySQLService;

public interface MySQLRepository extends CrudRepository<DemoMySQLService, Integer>{
}
