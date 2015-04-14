package com.management.student.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.management.student.domain.Student;
import com.management.student.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Student.
 */
@RestController
@RequestMapping("/api")
public class StudentResource {

    private final Logger log = LoggerFactory.getLogger(StudentResource.class);

    @Inject
    private StudentRepository studentRepository;

    /**
     * POST  /students -> Create a new student.
     */
    @RequestMapping(value = "/students",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> create(@Valid @RequestBody Student student) throws URISyntaxException {
        log.debug("REST request to save Student : {}", student);
        if (student.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new student cannot already have an ID").build();
        }
        studentRepository.save(student);
        return ResponseEntity.created(new URI("/api/students/" + student.getId())).build();
    }

    /**
     * PUT  /students -> Updates an existing student.
     */
    @RequestMapping(value = "/students",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Void> update(@Valid @RequestBody Student student) throws URISyntaxException {
        log.debug("REST request to update Student : {}", student);
        if (student.getId() == null) {
            return create(student);
        }
        studentRepository.save(student);
        return ResponseEntity.ok().build();
    }

    /**
     * GET  /students -> get all the students.
     */
    @RequestMapping(value = "/students",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Student> getAll() {
        log.debug("REST request to get all Students");
        return studentRepository.findAll();
    }

    /**
     * GET  /students/:id -> get the "id" student.
     */
    @RequestMapping(value = "/students/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Student> get(@PathVariable Long id) {
        log.debug("REST request to get Student : {}", id);
        return Optional.ofNullable(studentRepository.findOne(id))
            .map(student -> new ResponseEntity<>(
                student,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /students/:id -> delete the "id" student.
     */
    @RequestMapping(value = "/students/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete Student : {}", id);
        studentRepository.delete(id);
    }
}
