#!/bin/bash
DB_NAME="tmp_board"

mysql -uroot < db.sql
mysql -uroot $DB_NAME < thread.sql
mysql -uroot $DB_NAME < res.sql
