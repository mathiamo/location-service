dataSource {
    pooled = true
    driverClassName = "org.postgresql.Driver"
    dialect = "org.hibernate.dialect.PostgreSQLDialect"
    uri = new URI(System.getenv("DB_URL"))
    username = uri.userInfo.split(":")[0]
    password = uri.userInfo.split(":")[1]

}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:postgresql://"+uri.host+":"+uri.port+uri.path
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://"+uri.host+":"+uri.port+uri.path
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:postgresql://"+uri.host+":"+uri.port+uri.path
        }
    }
}
