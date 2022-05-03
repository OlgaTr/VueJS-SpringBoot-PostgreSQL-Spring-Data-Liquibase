databaseChangeLog {

    changeSet(id: 'schema', author: 'olga') {
        sql {
            "CREATE SCHEMA journal"
        }
    }

    changeSet(id: 'create-table', author: 'olga') {
        createTable (schemaName: 'journal', tableName: 'notes') {
            column(name: 'id', type: 'bigint', autoIncrement: true) {
                constraints(primaryKey: true, nullable: false)
            }
            column (name: 'title', type: 'varchar')
            column (name: 'content', type: 'varchar')
            column (name: 'date', type: 'date')
        }
    }

//    changeSet(id: 'insert-data', author: 'olga') {
//        sql {
//            "INSERT INTO journal.notes (title) VALUES ('First note'), ('Second note')"
//        }
//    }
}