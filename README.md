StudentManagement
==========================

[![Build Status](https://travis-ci.org/CJTaylr/student-management.svg?branch=master)](https://travis-ci.org/CJTaylr/student-management)

What you'll need 
=========================

- [PostgreSql](http://www.postgresql.org/download/)
- [Apache Maven](https://maven.apache.org/download.cgi)

Getting Started 
=========================
- Requires Postgres Databased created 
-   Create database: `StudentManagement`
-   Create login role: `StudentManagement` with custom password 
-   Supply password in `resources/config/application-dev.yml` for `Spring: datasource: password:`


Running the application 
=========================
- `mvn spring-boot:run`

Tips and Tricks 
========================
- Email server is not configured so all new account registrations output setup-email to console executing maven. 
