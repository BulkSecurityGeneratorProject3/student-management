StudentManagement
==========================

[![Build Status](https://travis-ci.org/CJTaylr/student-management.svg?branch=master)](https://travis-ci.org/CJTaylr/student-management)

What you'll need 
=========================

- [PostgreSql](http://www.postgresql.org/download/)
- [Apache Maven](https://maven.apache.org/download.cgi)

Getting Started 
=========================
- Configure Postgres Database 
  - Create database: `StudentManagement`
  - Create login role: `StudentManagement` with custom password (default password for testing `StudentManagement`)
- Update `resources/config/application-dev.yml` 
  - Supply password for `Spring: datasource: password:` (default password for testing `StudentManagement`)
  - (optional) Change `server: port:` if desired (default 8081)

Running the application 
=========================
- `mvn spring-boot:run`
- Browse to either internal or external IP displayed in console 

Tips and Tricks 
========================
- Email server is not configured so all new account registrations output setup-email to console executing maven. 
