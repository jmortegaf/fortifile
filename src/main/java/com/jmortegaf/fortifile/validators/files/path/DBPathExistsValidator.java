package com.jmortegaf.fortifile.validators.files.path;

import com.jmortegaf.fortifile.exceptions.NewFileErrorException;
import com.jmortegaf.fortifile.repositories.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBPathExistsValidator implements  PathValidator{

    @Autowired
    private DirectoryRepository directoryRepository;

    @Override
    public void validate(String path) {
        if(!directoryRepository.existsByName(path))
            throw new NewFileErrorException("Directory not in the database");
    }
}
