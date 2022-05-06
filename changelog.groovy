databaseChangeLog {

    changeSet(id: 'schema', author: 'olga') {
        sql {
            "CREATE SCHEMA journal"
        }
    }

    changeSet(id: 'notebook-table', author: 'olga') {
        createTable(schemaName: 'journal', tableName: 'notebooks') {
            column(name: 'notebook_id', type: 'bigint', autoIncrement: true) {
                constraints(primaryKey: true, nullable: false)
            }
            column(name: 'theme', type: 'varchar')
        }
    }

    changeSet(id: 'note-table', author: 'olga') {
        createTable(schemaName: 'journal', tableName: 'notes') {
            column(name: 'note_id', type: 'bigint', autoIncrement: true) {
                constraints(primaryKey: true, nullable: false)
            }
            column(name: 'title', type: 'varchar')
            column(name: 'content', type: 'varchar')
            column(name: 'date', type: 'date')
            column(name: 'notebooks_key', type: 'bigint') {
                constraints(foreignKeyName: 'notebook', referencedTableName: 'notebooks',
                        referencedTableSchemaName: 'journal', referencedColumnNames: 'notebook_id')
            }
        }
    }

    changeSet(id: 'user-table', author: 'olga') {
        createTable(schemaName: 'journal', tableName:'users') {
            column(name: 'userId', type: 'bigint', autoIncrement: true) {
                constraints(primaryKey: true, nullable: false)
            }
            column(name: 'name', type: 'varchar')
            column(name: 'password', type: 'varchar')
        }
    }

//    changeSet(id: 'insert-data', author: 'olga') {
//        sql {
//            "INSERT INTO journal.notes (title) VALUES ('First note'), ('Second note')"
//        }
//    }
}