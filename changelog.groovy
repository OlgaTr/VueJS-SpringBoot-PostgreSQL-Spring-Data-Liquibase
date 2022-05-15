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
            column(name: 'username', type: 'varchar') {
                constraints(nullable: false)
            }
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
                        referencedTableSchemaName: 'journal', referencedColumnNames: 'notebook_id',
                        nullable: false)
            }
        }
    }

    changeSet(id: 'user-table', author: 'olga') {
        createTable(schemaName: 'journal', tableName:'users') {
            column(name: 'username', type: 'varchar') {
                constraints(primaryKey: true)
            }
            column(name: 'password', type: 'varchar')
        }
    }

    changeSet(id: 'current-user-table', author: 'olga') {
        createTable(schemaName: 'journal', tableName: 'cuser') {
            column(name: 'username', type: 'varchar')
            column(name: 'password', type: 'varchar')
        }
    }
}