#!/bin/bash

if [ -n $1 ]; then
  PASS="root"
fi
DB_NAME="tmp_board"

mysql -uroot -p${PASS} < db.sql
mysql -uroot -p${PASS} $DB_NAME < thread.sql
mysql -uroot -p${PASS} $DB_NAME < res.sql
